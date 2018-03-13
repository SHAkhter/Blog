package blog

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BlogPostSpec extends Specification implements DomainUnitTest<BlogPost> {

    def setupSpec() {
        mockDomain BlogPost
    }

    def cleanup() {
    }

    void "test basic persistence mocking"() {
        setup:
        new BlogPost(title: "First blog post", body: "This is my first blog post ever hello world").save()
        new BlogPost(title: "Second Blog Post", body: "I think I am getting better at this blogging thing already").save()

        expect:
        BlogPost.count() == 2
    }
    void "test title cannot be null"(){
        when:
        domain.title=null

        then:
        !domain.validate(['title'])
    }
    void "test title cannot be blank" (){
        when:
        domain.title =""
        then:
        !domain.validate(['title'])
    }
    void "test title cannot have more than 255 characters" (){
        when:
        domain.title ="J" * 256
        then: "validation fails"
        domain.validate(['title'])

        when:
        domain.title ="j" * 255
        then: "validation passes"
        domain.validate(['title'])
    }

    void  "test body cannot be null"(){
        when:
        domain.body = null
        then:
        !domain.validate(['body'])
    }
    void "test body cannot be blank" (){
        when:
        domain.body =""
        then:
        !domain.validate(['body'])
    }
    void "test body cannot have more than 5000 characters"(){
        when:
        domain.body="Y" *5001
        then: "validation fails"
        !domain.validate(['body'])

        when:
        domain.body = "y"*5000
        then: "validation passes"
        domain.validate(['body'])
    }
}
