let userStorage = localStorage.getItem('currentHoroscopeUser');
let currentUser = JSON.parse(userStorage);
let moodButton = document.getElementById("moodButton");

console.log(currentUser);

let greetingLabel = document.getElementById("greeting");
greetingLabel.innerText = `Welcome ${currentUser.first_name}, Check Your Horoscope NOW!`

let button = document.getElementById("button")

button.addEventListener("click", async() => {

   
        try {
            const raw_response = await fetch(`http://sandipbgt.com/theastrologer/api/horoscope/${currentUser.horoscope}/today`);

        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }

        const json_data = await raw_response.json();

        console.log(json_data)

        var input = document.getElementById("input");
        var horoscope = document.createElement('h2');

        horoscope.innerHTML = `Your mood for the day is: ${json_data.horoscope}`;
        input.append(horoscope);

        var b = document.createElement('br');
        input.append(b);

        var mood = document.getElementById("mood");
        mood.innerText = `${json_data.meta.mood}`;

        // var newButton = document.createElement("BUTTON")
        // newButton.setAttribute("id","moodButton")
        // newButton.setAttribute("width", "250px");
        // newButton.setAttribute("height","250px");
        // newButton.innerText = "Click Here To Update Mood";
        // buttons.append(newButton);

        } catch (error) {
            alert("Error: "+error)
        }
    


}
);

moodButton.addEventListener("click", (event) => {
    event.preventDefault();

    let xhttp = new XMLHttpRequest();

    let userid = currentUser.horoscope_user_id;
    console.log(userid)
    var mood2 = document.getElementById("mood");
    let mood3 = mood2.innerText;
    console.log(mood3)
    
    

    let moodInfo = {
        horoscope_user_id:currentUser.horoscope_user_id,
        mood:mood3,
    };
    console.log(moodInfo);

    xhttp.onreadystatechange = function(){
        if(this.readyState == 4 && xhttp.status === 200){
            console.log(xhttp.responseText);

            let data = JSON.parse(xhttp.responseText);
            console.log(data);

            //global caching
            // localStorage.setItem('currentHoroscopeUser',JSON.stringify(data));
            // console.log(localStorage.getItem('currentHoroscopeUser'))
            // window.location.replace("homepage.html")

        } else if(this.readyState == 4 && xhttp.status == 204){

            console.log(xhttp.responseText);
            alert("Failed to Send Mood: Status Code - "+xhttp.status)
        }

    };

    //OPEN THE REQUEST
    xhttp.open("POST",`http://localhost:8080/HoroscopesProject/mood`);
    // xhttp.setRequestHeader("Access-Control-Allow-Origin","*");
    xhttp.setRequestHeader("Content-Type","application/json");

    //SEND STATUS
    xhttp.send(JSON.stringify(moodInfo));
});



