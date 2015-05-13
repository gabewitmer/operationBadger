<nav class="clericmenu">
	<a href="/">Home</a>
	<a href="/secure/user">${(auth)?string('My Badger', 'Login')}</a>
	<#if auth>
		<a href="/logout">Logout</a>
	<#else/>
		<a href="#">testing!!!</a>
	</#if>
</nav>