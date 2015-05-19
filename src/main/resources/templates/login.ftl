<!doctype html>
<html lang="en">
	<head>
		<#include "stubs/header.ftl"/>
		<title>Badger | Login</title>
	</head>
	<body class="login-background">
		<#include "stubs/navbar.ftl"/>
		<#include "stubs/alert.ftl"/>
<!--		<div class="units-row login-login">
			<div class="unit-centered unit-25">
				<form action="/login" method="post" class="forms">
					<input type="email" name="username" placeholder="Email" class="width-100"/>
					<label>
						<input type="password" name="password" placeholder="Password" class="width-100"/>
					</label>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input class="btn btn-blue width-100" type="submit" value="Login"/>
				</form>
				<a href="/reset/password">Forgot my Password, Badger!</a>
			</div>
		</div>-->
		</div>
		<div class="units-row login-register">
			<div class="unit-push-20 unit-25">
				<form action="/register" method="post" class="forms">
					<div class="width-100"><h3>New Badger? Fill out this form.</h3></div>
					<input type="email" name="username" placeholder="Email" class="width-100"/>
					<input type="password" name="password" placeholder="Password" class="width-100"/>
					<input type="text" name="displayName" placeholder="Display Name" class="width-100"/>
					<input type="number" name="age" placeholder="Age" class="width-100"/>
					<label>
						<input type="text" name="state" placeholder="State" class="width-100"/>
					</label>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input class="btn btn-blue width-100" type="submit" value="Register"/>
				</form>
			</div>
		</div>
	</body>
</html>