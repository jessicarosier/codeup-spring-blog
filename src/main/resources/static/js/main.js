


let url = `http://localhost:8080/api/posts/likes`;
let options = {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
    },
};



async function getPosts() {
    let response = await fetch(url, options);
    let data = await response.json();
    console.log(data);
    return data;
}


(async function () {
    let posts = await getPosts();
    const topPostsContainer = document.getElementById("top-posts");

    posts.forEach((post) => {
        let postCard = document.createElement("div");
        postCard.classList.add("post-card");

        postCard.innerHTML = `
        <p>${post.createdAt}</p>
        <h3>${post.title}</h3>
        <p>${post.body}</p>
        
        
       <a href=/posts/${post.id}>Read More</a>
    `;

        topPostsContainer.appendChild(postCard);
    });
})();


