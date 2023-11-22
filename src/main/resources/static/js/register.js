const MAP_BOX_KEY = "pk.eyJ1IjoiamVzc2ljYXJvc2llciIsImEiOiJjbG1mOHJ0Y24xc3YyM25zNm90Z3V4N2x2In0.LC_KKVOV1fKBEVcb56GUEw";

const registerButton = document.getElementById("register-button");
const password = document.getElementById("password");
const passwordConfirm = document.getElementById("password-confirm");
const passwordError = document.getElementById("password-error");
const registerForm = document.getElementById("register-form");



//WHEN A NEW USER REGISTERS, CREATE A NEW MAP FOR THEM
mapboxgl.accessToken = `${MAP_BOX_KEY}`;
const map = new mapboxgl.Map({
    container: 'map', // container ID
    style: 'mapbox://styles/mapbox/streets-v12', // style URL
    center: [-74.5, 40], // starting position [lng, lat]
    zoom: 9 // starting zoom
});
console.log(typeof map);
console.log(map);
console.log(map.container);
console.log(map.style);
console.log(map.center);
console.log(map.zoom);


registerButton.addEventListener("click", (e)=> {
    e.preventDefault();
    passwordError.innerText = "";
    if (passwordConfirm.value !== password.value) {

        passwordError.innerText = "Passwords do not match";
    } else {
        registerForm.submit();
    }
})

