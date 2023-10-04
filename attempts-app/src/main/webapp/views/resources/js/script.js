const URL = "/users/signup";
const form = document.getElementById("form");
let errors = document.getElementById("errors");

const signup = (data) => {
  fetch(URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: data,
  })
    .then(async (response) => {
      if (response.ok) {
        window.location.href = "/signin.jsp";
      }
      if (!response.ok) {
        const { message } = await response.json();
        errors.innerText = message;
      }
      if (response.ok) {
        window.location.href = "/signin.jsp";
      }
    })
    .catch((error) => {
      errors.innerText = error;
    });
};

form.addEventListener("submit", (e) => {
  e.preventDefault();
  errors.innerHTML = "";
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;
  const confirmPassword = document.getElementById("confirmPassword").value;

  if (password != confirmPassword) {
    errors.innerHTML = "password must be equal";
    return;
  }

  let data = new URLSearchParams();
  data.append("name", name);
  data.append("email", email);
  data.append("password", password);

  signup(data);
});
