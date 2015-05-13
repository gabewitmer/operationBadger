<!doctype html>
<html lang="en">
	<head>
		<#include "../stubs/header.ftl"/>
		<title>Badger | User</title>
	</head>
	<body>
		<#include "../stubs/navbar.ftl"/>
		<#include "../stubs/alert.ftl"/>
		<div>
			<form action="/secure/user" method="post">
				<input type="email" name="username" placeholder="Email" value="${(user.username)!}"/>
				<input type="password" name="password" placeholder="Password"/>
				<input type="text" name="displayName" placeholder="Display Name" value="${(user.displayName)!}"/>
				<input type="number" name="age" placeholder="Age" value="${(user.age)!}"/>
				<input type="text" name="state" placeholder="State" value="${(user.state)!}"/>
				<input type="hidden" name="id" value="${(user.id)!}"/>
				<input type="hidden" name="active" value="${(user.active)!}"/>
				<input type="hidden" name="role" value="${(user.role)!}"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button>Save</button>
			</form>
		</div>

		<#include "../stubs/scripts.ftl"/>
	</body>
</html>