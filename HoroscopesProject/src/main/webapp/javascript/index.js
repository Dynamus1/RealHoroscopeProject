let loginButton = document.getElementById("login-button");
let signUpButton = document.getElementById("signUpButton");

console.log(loginButton);
console.log(signUpButton);

loginButton.addEventListener("click", (event) => {
    event.preventDefault();

    let xhttp = new XMLHttpRequest();

    let username = document.getElementById("horoscope-username-sign-in").value;
    let password = document.getElementById("horoscope-password-sign-in").value;

    let loginInfo = {
        username:username,
        password:password,
    };
    console.log(loginInfo);

    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && xhttp.status === 200){
            console.log(xhttp.responseText);

            let data = JSON.parse(xhttp.responseText);
            console.log(data);

            //global caching
            localStorage.setItem('currentHoroscopeUser',JSON.stringify(data));
            console.log(localStorage.getItem('currentHoroscopeUser'))
            window.location.replace("homepage.html")

        } else if(this.readyState == 4 && xhttp.status == 204){

            console.log(xhttp.responseText);
            alert("Failed to Login: Status Code - "+xhttp.status)
        }

    };

    //OPEN THE REQUEST
    xhttp.open("POST",`http://localhost:8080/HoroscopesProject/horoscopeUserServlet`);
    // xhttp.setRequestHeader("Access-Control-Allow-Origin","*");
    xhttp.setRequestHeader("Content-Type","application/json");

    //SEND STATUS
    xhttp.send(JSON.stringify(loginInfo));
});

signUpButton.addEventListener("click", (event) => {
    event.preventDefault();
    window.location.replace("signUp.html");
});