package blog


class BlogPost {
    String title
    String body

    static mapping = {
        table 'blogPost'
        id column: 'blog_id'
    }

    static hasMany = [comments: Comment]
    static constraints = {
        title(blank:false)
        body(blank:false, maxSize:5000)
    }
}
