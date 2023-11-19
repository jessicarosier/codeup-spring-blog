public class Post {
//    Create a Post class. This class will ultimately represent a POST record from our database. The class should have private properties and getters and setters for a title and body.

    private String title;
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {

    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String setTitle(String title) {
        return this.title = title;
    }

    public String setBody(String body) {
        return this.body = body;
    }




}
