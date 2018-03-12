package blog

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class BlogPostSpec extends Specification implements DomainUnitTest<BlogPost> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
