package com.codeup.codeupspringblog.controllers;//package com.codeup.codeupspringblog.models;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })




public class Post {


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
