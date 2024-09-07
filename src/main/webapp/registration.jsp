<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="ISO-8859-1">
    <title>Register</title>
    <link href="css/styles.css" rel="stylesheet">
    <script type="text/javascript">
    function onSubmit() {
        var firstname = document.getElementById('firstname');
        var lastname = document.getElementById('lastname');
        var phone = document.getElementById('phone');
        var email = document.getElementById('email');
        var address = document.getElementById('address');
        var username = document.getElementById('username');
        var password = document.getElementById('password');
        if (username.value==""||username.value==null||
                password.value==""||password.value==null||
                firstname.value==""||firstname.value==null||
                lastname.value==""||lastname.value==null||
                phone.value==""||phone.value==null||
                email.value==""||email.value==null||
                address.value==""||address.value==null
                ){
            alert("All fileds required!");
            return false;
        }
        else {
            return true;
        }
    }
    </script>
    
    </head>
    <body>
        <div class="regi-main-container">
            <div class="regi-form-container">
                <div class="regi-form">
                    <h2>Registration</h2>
                    <form action="register" method="post" onsubmit="return onSubmit()">
                        <div>
                           <label for="firstname" class="form-label">First Name</label>
                            <input type="text" id="firstname" name="first_name">
                        </div>
                        <div>
                            <label for="lastname" class="form-label">Last Name</label>
                            <input type="text" id="lastname" name="last_name">
                        </div>
                        <div>
                            <label for="phone" class="form-label">Phone Number</label>
                            <input type="text" id="phone"  name="phone">
                        </div>
                        <div>
                            <label for="email" class="form-label">email</label>
                            <input type="text"  id="email" name="email">
                        </div>
                        <div>
                            <label for="address" class="form-label">Address</label>
                            <input type="text" id="address" name="address">
                        </div>
                        <div>
                            <label for="username" class="form-label">User Name</label>
                            <input type="text" id="username" name="username">
                        </div>
                        <div>
                            <label for="password" class="form-label">Password</label>
                            <input type="password" id="password" name="password">
                        </div>
                        <div class="sub-btn">
                            <button type="submit">Register</button>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
        
    </body>
    </html>