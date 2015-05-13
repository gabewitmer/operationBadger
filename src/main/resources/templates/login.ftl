<!doctype html>
<html lang="en">
	<head>
		<#include "stubs/header.ftl"/>
		<title>Badger | Login</title>
	</head>
	<body>
		<#include "stubs/navbar.ftl"/>
		<#include "stubs/alert.ftl"/>
		<div>
			<form action="/login" method="post">
				<input type="email" name="username" placeholder="Email"/>
				<input type="password" name="password" placeholder="Password"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button>Login</button>
			</form>
			<form action="/register" method="post">
				<input type="email" name="username" placeholder="Email"/>
				<input type="password" name="password" placeholder="Password"/>
				<input type="text" name="displayName" placeholder="Display Name"/>
				<input type="number" name="age" placeholder="Age"/>
				<input type="text" name="state" placeholder="State"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button>Register</button>
			</form>
		</div>

		<#include "stubs/scripts.ftl"/>
	</body>
</html>