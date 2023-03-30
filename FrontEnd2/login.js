const url = "http://localhost:8080/ers/"

window.document.getElementById("loginButton").addEventListener("click", loginFunc);

async function loginFunc(){
    let user_name = document.getElementById("username").value;
    let pWord = document.getElementById("password").value;

    let user = {
        ers_username: user_name,
        ers_password: pWord
    }

    console.log(user);

    let response = await fetch(url + "login", {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    });

    console.log(response);

    if(response.status === 200){
        document.getElementById("loginDiv").innerText = "You are logged in.";

        let user = await response.json();

        if(user.user_role_id === 1){
            window.location.href = "./employee.html";
        } else if(user.user_role_id === 2){
            window.location.href = "./manager.html";
        }
        
    } else {
        document.getElementById("errorMsg").innerText = "Login has failed."
    }
}

