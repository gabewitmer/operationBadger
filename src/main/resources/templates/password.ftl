<!doctype html>
<html lang="en">
	<head>
		<#include "stubs/header.ftl"/>
		<title>Document</title>
	</head>
	<body>
		<#include "stubs/navbar.ftl"/>
		<#include "stubs/alert.ftl"/>
		<div class="units-row">
			<div class="unit-centered unit-25">
				<form action="/reset/password" method="post">
					<input type="email" name="username" placeholder="email"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<button class="btn btn-blue">Recover password, dummy!</button>
				</form>
			</div>
		</div>

		<#include "stubs/scripts.ftl"/>
	</body>
</html>