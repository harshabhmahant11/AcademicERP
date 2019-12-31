<html>


<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">

<script type="text/javascript" src="js/login.js"></script>
<script src="js/jquery.min.js"></script>


<body>


<div class="limiter">
    <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
        <div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Admin Login
				</span>
            <form class="login100-form p-b-33 p-t-5">

                <div class="wrap-input100" data-validate = "Enter username">
                    <input class="input100" type="text" id="eid" name="username" placeholder="User name">
                    <span class="focus-input100" data-placeholder="&#xe82a;"></span>
                </div>

                <div class="wrap-input100" data-validate="Enter password">
                    <input class="input100" type="password" id="password" name="pass" placeholder="Password">
                    <span class="focus-input100" data-placeholder="&#xe80f;"></span>
                </div>

                <div class="container-login100-form-btn m-t-32">
                    <img src="images/loginloader.gif" alt="loading" style="display:none" id="loginWait">
                    <button class="login100-form-btn" onclick="login()">Login</button>
                </div>

            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>



<script type="text/javascript">
    $(document).ready(function() {

        $('form').submit(false);
    });
</script>

</body>
</html>
