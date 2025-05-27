
document.querySelector('form').addEventListener("submit", async function(e) {
    e.preventDefault();
    
    const email = document.getElementById("emailId").value; 
    const password = document.getElementById("password").value;
  
    const response = await fetch("http://localhost:8080/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ email, password }),
      credentials: "include"
    });
  
    if (response.ok) {
      window.location.href = "dashboard.html"; 
    } else if(response.status === 401){
      alert("Incorrect email or password");

    }
    else {
      document.getElementById("errorMsg").textContent = "Incorrect email or password"; 
    }
});


