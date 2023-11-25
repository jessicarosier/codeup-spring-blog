


let url1 = `http://localhost:8080/api/posts/likes`;
let url2 = `http://localhost:8080/api/posts/recent`;
let options = {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
    },
};



async function getTopPosts() {
    let response = await fetch(url1, options);
    let data = await response.json();
    console.log(data);
    return data;
}

async function getRecentPosts() {
    let response = await fetch(url2, options);
    let data = await response.json();
    console.log(data);
    return data;
}


(async function () {
    let topPosts = await getTopPosts();
    const topPostsContainer = document.getElementById("top-posts");

    for (let i = 0; i < 4; i++) {
        let postCard = document.createElement("div");
        postCard.classList.add("post-card");

        postCard.innerHTML = `
        <p>${topPosts[i].createdAt}</p>
        <h3>${topPosts[i].title}</h3>
        <p>By: ${topPosts[i].user.username}</p>
        <p>${topPosts[i].body.substring(0,300)}</p>
        
        
       <a href=/posts/${topPosts[i].id}>Read More</a>
    `;

        topPostsContainer.appendChild(postCard);

    }


    // get first 5 recent posts and display them
    let recentPosts = await getRecentPosts();
    const recentPostsContainer = document.getElementById("recent-posts");
    for (let i = 0; i < 4; i++) {
        let postCard = document.createElement("div");
        postCard.classList.add("post-card");

        postCard.innerHTML = `
        <p>${recentPosts[i].createdAt}</p>
        <p>By: ${recentPosts[i].user.username}</p>
        <h3>${recentPosts[i].title}</h3>
        <p>${recentPosts[i].body.substring(0,300)}</p>
        
        
       <a href=/posts/${recentPosts[i].id}>Read More</a>
    `;

        recentPostsContainer.appendChild(postCard);

    }


})();


