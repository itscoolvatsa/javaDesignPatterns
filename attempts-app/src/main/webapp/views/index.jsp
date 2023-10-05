<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
    />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="../resources/css/style.css" />
    <title>SignUp</title>
  </head>

  <body>
    <section>
      <div>
        <div>
          <form id="form">
            <span>Sign Up</span>
            <div>
              <label for="name"></label>
              <input
                type="text"
                name="name"
                id="name"
                placeholder="Name"
                required
              />
            </div>
            <div>
              <label for="email"></label>
              <input
                type="email"
                name="email"
                id="email"
                placeholder="Email"
                required
              />
            </div>
            <div>
              <label for="password"></label>
              <input
                type="password"
                name="password"
                id="password"
                placeholder="Password"
                required
              />
            </div>
            <div>
              <label for="confirmPassword"></label>
              <input
                type="password"
                name="confirmPassword"
                id="confirmPassword"
                placeholder="Confirm Password"
                required
              />
            </div>
            <p id="errors"></p>
            <button type="submit" class="submit">SignUp</button>
          </form>
        </div>
        <div>
          <p>Already have an account? <a href="/signin.jsp">Login</a></p>
        </div>
      </div>
    </section>
  </body>
  <script src="../resources/js/signup.js"></script>
</html>
