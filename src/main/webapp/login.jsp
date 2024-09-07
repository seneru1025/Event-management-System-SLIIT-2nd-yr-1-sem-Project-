<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    
    <head>
        <meta charset="ISO-8859-1">
        <title>Login</title>
        <link href="css/styles.css" rel="stylesheet">
        <script type="text/javascript">
            function onSubmit() {
                var username = document.getElementById('username');
                var password = document.getElementById('password');
                if (username.value == "" || username.value == null || password.value == "" || username.value == null) {
                    alert("Both username and password required!");
                    return false;
                }
                else {
                    return true;
                }
            }
        </script>
    
    </head>
    
    <body>
        <div class="login-main-container">
            <div class="login-form-container">
                <div class="login-form">
                    <h2>Login</h2>
                    <form action="login" method="post" onsubmit="return onSubmit()">
                        <div>
                            <label for="username" class="form-label">User Name</label>
                            <input type="text" id="username" name="username">
                        </div>
                        <div>
                            <label for="password" class="form-label">Password</label>
                            <input type="password" id="password" name="password">
                        </div>
    
                        <button type="submit"> Login </button>
                    </form>
                    <p>Not registered? <a href="registration.jsp">Register here</a></p>
                </div>
            </div>
        </div>
    
    </body>
    
    </html>