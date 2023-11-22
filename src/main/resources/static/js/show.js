const numLikes = document.getElementById("num-likes");


const postId = numLikes.getAttribute("data");
console.log(postId);


// Path: src/main/resources/static/js/show.js
    (function($) {
        let request = $.ajax({'url': '/posts.ajax'});
        request.done(function (posts) {
            var html = '';
            posts.forEach(function(post) {
                html += '<div>';
                html += '<h1>' + post.title + '</h1>';
                html += '<p>' + post.description + '</p>';
                html += '<p>Published by ' + post.user.username + '</p>';
                html += '</div>';
            });
            $('#ads').html(html);
        });
    })(jQuery);

