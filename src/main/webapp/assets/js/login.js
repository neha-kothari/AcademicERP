let form = document.getElementById('login-form');

form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (form.checkValidity() === true) {
        document.getElementById("submit-button").style.display = "none";
        document.getElementById("spinner-button").style.display = "block";
        const username = document.getElementById('username').value;
        //const password = document.getElementById('password').value;

        const response = await fetch('api/employee/email/'+username).catch(err => {
            console.log(err)
        });

        let result = await response;
        if(result['status'] === 200){

            //let data = response.json();
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            location.href = "dashboard.html";
        }else{
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            document.getElementById("login-alert").style.display = "block";
        }
    }
});
