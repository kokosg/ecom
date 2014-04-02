<style type="text/css">
label.error {
	float: none;
	color: red;
	padding-left: .3em;
	vertical-align: top;
	font-size:12px;
}
</style>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"
	type="text/javascript"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.10.0/jquery.validate.js"
	type="text/javascript"></script>

<script>
	$(document).ready(function() {
		$("#Login-form").validate({
			rules : {
				email : {
					required : true
				},
				password : {
					required : true
				}
			},
			messages : {
				email : {
					required : "**You must enter the email"
				},
				password : {
					required : "**You must enter the password"
				}
			}

		});
	});
</script>
<div onload="init()">
	<form name="Login Form" action="Login" id="Login-form" method="post">
		<div class="form-group" id="err">
			<label> Email:</label> 
			<input class="form-control" class="error" type="text" name="email" id="email" />
		</div>
		<div class="form-group">
			<label> Password :</label> 
			<input class="form-control"	type="password" name="password" id="password" size="30" />
		</div>
		<input class="btn btn-success submit-btn" type="submit"	value="Sign in">
	</form>
</div>