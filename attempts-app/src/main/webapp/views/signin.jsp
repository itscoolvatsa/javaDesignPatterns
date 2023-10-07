<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
            name="viewport"
    />
    <meta content="ie=edge" http-equiv="X-UA-Compatible"/>
    <link href="../resources/css/style.css" rel="stylesheet"/>
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
                    <input id="email" name="email" placeholder="Email" type="email"/>
                </div>
                <div>
                    <label for="password"></label>
                    <input
                            id="password"
                            name="password"
                            placeholder="Password"
                            type="password"
                    />
                </div>
                <p id="errors"></p>
                <button class="submit" type="submit">SignIn</button>
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
