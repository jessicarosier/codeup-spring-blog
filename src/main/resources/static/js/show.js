const numLikes = document.getElementById("num-likes");

const postId = numLikes.getAttribute("data");
console.log(postId);

const userLikes = document.getElementById("user-likes");

let url = `http://localhost:8080/api/posts/likes/${postId}`;
let options = {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
    },
};

async function getUserLikes() {
    let response = await fetch(url, options);
    let data = await response.json();
    return data;
}

numLikes.addEventListener("click", async function () {
    let users = await getUserLikes();
    console.log(users);
    let userString = "";
    users.forEach(user => {
        userString += `<li>${user.username}</li>`;
    });
    userLikes.innerHTML = userString;
});







