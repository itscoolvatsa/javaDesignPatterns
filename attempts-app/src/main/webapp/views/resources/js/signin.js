const URL = "/users/signin";
const form = document.getElementById("form");
let errors = document.getElementById("errors");

let innerdiv = document.getElementById("inner");

const signin = (data) => {
  fetch(URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: data,
  })
    .then(async (response) => {
      const { message, data } = await response.json();
      console.log(message);
      console.log(data);
      if (response.ok) {
        const { email, name } = data;
        innerDivRes(email, name);
      }
      if (!response.ok) {
        let msg = "";
        msg += message;

        let { attempts, time } = data;

        console.log(attempts, time);

        if (attempts != undefined) {
          errors.innerText = attempts;
          msg += `\n total attempts left ${attempts}`;
        }

        if (time != undefined) {
          msg += `\n ${time}`;
        }
        errors.innerText = msg;
      }
      // if (response.ok) {
      //   window.location.href = "/signin.jsp";
      // }
    })
    .catch((error) => {
      errors.innerText = error;
    });
};

form.addEventListener("submit", (e) => {
  e.preventDefault();
  errors.innerHTML = "";
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  let data = new URLSearchParams();
  data.append("email", email);
  data.append("password", password);

  signin(data);
});

const innerDivRes = (email, name) => {
  console.log(innerdiv);

  let res = `<h1> ${name} <h1>
            <h2> ${email} <h2>`;

  innerdiv.innerHTML = res;
};
