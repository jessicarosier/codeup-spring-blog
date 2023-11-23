console.log("test");

let url = "http://localhost:8080/posts.json";
let url2 = `http://localhost:8080/api/posts/likes/${7}`;
let options = {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
    },
};

//async fetch request
async function getPosts() {
    let response = await fetch(url, options);
    let data = await response.json();
    console.log(data);
    return data;

}

let posts = getPosts();
console.log(posts);

async function getPosts2() {
    let response = await fetch(url2, options);
    let data = await response.json();
    console.log(data);
    return data;
}

let posts2 = getPosts2();
console.log(posts2);
