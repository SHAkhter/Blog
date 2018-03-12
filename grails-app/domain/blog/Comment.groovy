package blog

class Comment {
    String body
    String name
    static mapping = {
        table 'Comments'
        id column: 'comment_id'

    }
    static belongsTo = [blogPost : BlogPost]
    static constraints = {
        name(blank: false)
        body(blank: false)
    }
}
