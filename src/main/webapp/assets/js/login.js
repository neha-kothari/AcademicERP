let form = document.getElementById('login-form');

let getUserId = async (username, password) => {

    if(username == "admin" && password=="password"){
        return Promise.resolve("admin")
    }
    return Promise.resolve(null)

    // Use this to check login in backend:
    // const response = await fetch('api/students/login', {
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json;charset=utf-8'
    //     },
    //     body: JSON.stringify({
    //         username: username,
    //          password: password
    //     })
    // });
    // let result = await response;
    // if(result['status'] === 200){
    //     let data = response.json();
    //     return data['student_id']
    // } else return null;

};

form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (form.checkValidity() === true) {
        document.getElementById("submit-button").style.display = "none";
        document.getElementById("spinner-button").style.display = "block";
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;


        const userId = await getUserId(username, password);
        if(userId != null){
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            sessionStorage.setItem('id', userId);
            location.href = "dashboard.html";
        }else{
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            document.getElementById("login-alert").style.display = "block";
        }
    }
});