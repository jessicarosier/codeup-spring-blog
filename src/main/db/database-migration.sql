use springblog_db;


CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       first_name VARCHAR(200),
                       last_name VARCHAR(200),
                       email VARCHAR(200),
                       password VARCHAR(500),
                       PRIMARY KEY (id)
);

CREATE TABLE blog_posts (
                            id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                            title VARCHAR(100),
                            body VARCHAR(1000),
                            user_id INT UNSIGNED NOT NULL,
                            PRIMARY KEY (id),
                            FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE comments (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    content VARCHAR(500),
    user_id INT UNSIGNED,
    blog_post_id INT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (blog_post_id) REFERENCES blog_posts(id) ON DELETE CASCADE
);