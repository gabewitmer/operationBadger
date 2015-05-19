<!doctype html>
<html lang="en">
	<head>
		<#include "stubs/header.ftl"/>
		<title>Badger | Home</title>
	</head>
	<body>
		<div class="units-row">
			<div class="unit-centered unit-100">
				<!--<#include "stubs/navbar.ftl"/>-->
			</div>
		</div>
		<#include "stubs/alert.ftl"/>
		<div class="home-banner">
			<div>
				<img src="/static/img/badger-face.png"/>
			</div>
			<h1>See what's Badgering now!</h1>
			<h3>Find other Badgers and Badger them about topics you love</h3>
		</div>
		<div class="home-search-wrapper">
			<div class="units-row">
				<div class="unit-centered unit-25">
					<form class="home-search">
						<input type="search" name="search" placeholder="Search for other Badgers" class="width-80"/>
						<button class="btn btn-green btn-append"><i class="fa fa-search"></i></button>
						<!--<input type="search" placeholder="Search for Badgers" class="home-search width-100"/>-->
					</form>
				</div>
			</div>
		</div>
		<div class="home-pic-wrapper">
			<div class="units-row">
				<div class="unit-30 margin">
					<div class="unit-push-20 unit-80">
						<ul>
							<div>
								<li><a href="">Badger News</a></li>
								<li class="margin-small"><a href="">Badger Facts</a></li>
								<li class="margin-small"><a href="">#1 Badger</a></li>
								<li class="margin-small"><a href="">Who's being Badgered?</a></li>
								<li class="margin-small"><a href="">Need More Badger?</a></li>
							</div>
						</ul>
					</div>
				</div>
				<div class="unit-40">
					<a href="http://en.wikipedia.org/wiki/Badger" class="unit-50" style="text-decoration: none">
						<div class="home-pic">
							<div class="home-pic-text">
								<span>The Flying Badger</span>
							</div>
						</div>
					</a>
					<a href="http://en.wikipedia.org/wiki/Badger" class="unit-50" style="text-decoration: none">
						<div class="home-pic-2">
							<div class="home-pic-text">
								<span>The Curious Badger</span>
							</div>
						</div>
					</a>
					<div class="units-row">
						<div class="unit-centered unit-100">
							<a href="http://en.wikipedia.org/wiki/Honey_badger" class="unit-50" style="text-decoration: none">
								<div class="home-pic-3">
									<div class="home-pic-text">
										<span>The Honey Badger</span>
									</div>
								</div>
							</a>
							<a href="http://en.wikipedia.org/wiki/American_badger" class="unit-50" style="text-decoration: none">
								<div class="home-pic-4">
									<div class="home-pic-text">
										<span>The American Badger</span>
									</div>
								</div>
							</a>
						</div>
					</div>
				</div>
				<div class="unit-30">
					<div class="unit-centered unit-75">
						<div class="margin">
							Already a Badger? Sign in here.
						</div>
						<form action="/login" method="post" class="forms margin">
							<input type="email" name="username" placeholder="Email" class="width-100"/>
							<label>
								<input type="password" name="password" placeholder="Password" class="width-100"/>
							</label>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<input class="btn btn-blue width-100" type="submit" value="Login"/>
						</form>
						<a href="/reset/password">Forgot my Password, oh Badger!</a> <br/>
						<div class="margin">
							<a href="/login">Not a Badger? Click here!</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<#include "stubs/scripts.ftl"/>
	</body>
</html>