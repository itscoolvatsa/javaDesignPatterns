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
    <title>SignIn</title>
  </head>

  <body>
    <section>
      <div>
        <div id="inner">
          <form action="" id="form">
            <span>Sign In</span>
            <div>
              <label for="email"></label>
              <input type="email" name="email" id="email" placeholder="Email" />
            </div>
            <div>
              <label for="password"></label>
              <input
                type="password"
                name="password"
                id="password"
                placeholder="Password"
              />
            </div>
            <p id="errors"></p>
            <button type="submit" class="submit">SignIn</button>
          </form>
        </div>
        <div>
          <p>Don't have an account? <a href="/">SignUp</a></p>
        </div>
      </div>
    </section>
  </body>
  <script src="../resources/js/signin.js"></script>
</html>
