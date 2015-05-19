<nav class="clericmenu width-100">
	<a href="/">Home</a>
	<a href="/secure/user">${(auth)?string('My Badger', 'Login')}</a>
	<a href="/">Badger others</a>
	<#if auth>
		<a href="/logout">Logout</a>
	<#else/>
		<a href="#">testing!!!</a>
	</#if>
</nav>