<!doctype html>
<html lang="en">
	<head>
		<#include "../stubs/header.ftl"/>
		<title>Badger | User</title>
	</head>
	<body class="user-page">
		<div class="units-row">
			<div class="unit-centered unit-50">
				<nav class="clericmenu">
					<a href="/">Home</a>
					<a href="/secure/user">${(auth)?string('My Badger', 'Login')}</a>
					<a href="/">Badger others</a>
					<#if auth>
						<a href="/logout">Logout</a>
						<#else/>
						<a href="#">testing!!!</a>
					</#if>
				</nav>
			</div>
		</div>
		<#include "../stubs/alert.ftl"/>
		<div class="units-row">
			<div class="unit-push-20 unit-25">
				<form action="/secure/user" method="post" class="register">
					<input type="email" name="username" placeholder="Email" value="${(user.username)!}" class="width-100"/>
					<input type="password" name="password" placeholder="Password" class="width-100"/>
					<input type="text" name="displayName" placeholder="Display Name" value="${(user.displayName)!}" class="width-100"/>
					<input type="number" name="age" placeholder="Age" value="${(user.age)!}" class="width-100"/>
					<input type="text" name="state" placeholder="State" value="${(user.state)!}" class="width-100"/>
					<input type="hidden" name="id" value="${(user.id)!}" class="width-100"/>
					<input type="hidden" name="active" value="${(user.active)!}" class="width-100"/>
					<input type="hidden" name="role" value="${(user.role)!}" class="width-100"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input class="btn btn-blue width-100 margin-small" type="submit" value="Save"/>
				</form>
				<form action="/secure/user/del/${user.id}" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input class="btn btn-red width-100 margin" type="submit" value="Delete"/>
				</form>
			</div>
		</div>

		<#include "../stubs/scripts.ftl"/>
	</body>
</html>