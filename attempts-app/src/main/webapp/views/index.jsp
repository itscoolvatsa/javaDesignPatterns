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
                            id="name"
                            name="name"
                            placeholder="Name"
                            required
                            type="text"
                    />
                </div>
                <div>
                    <label for="email"></label>
                    <input
                            id="email"
                            name="email"
                            placeholder="Email"
                            required
                            type="email"
                    />
                </div>
                <div>
                    <label for="password"></label>
                    <input
                            id="password"
                            name="password"
                            placeholder="Password"
                            required
                            type="password"
                    />
                </div>
                <div>
                    <label for="confirmPassword"></label>
                    <input
                            id="confirmPassword"
                            name="confirmPassword"
                            placeholder="Confirm Password"
                            required
                            type="password"
                    />
                </div>
                <p id="errors"></p>
                <button class="submit" type="submit">SignUp</button>
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
