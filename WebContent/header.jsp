<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="ico/favicon.ico">

<title>eCom Journal - Team 10</title>

<!-- CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<!-- <link href="theme.css" rel="stylesheet">
 -->
</head>
<body>

<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">eCom Journal</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Separated link</a></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search for Article">
					</div>
					<button type="submit" class="btn">  <i class="glyphicon glyphicon-search"></i></button>
					<button type="submit" class="btn"><a href="searchServlet.jsp"> Advance </a><i class="glyphicon glyphicon-cog"></i></button>
				</form>
				<ul class="nav navbar-nav pull-right">
				<% if (session.getAttribute("email") == null) { %>
					<li id="login_form" class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret"></strong></a>
						<div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;">
							<!-- ADD YOUR LOGIN FORM HERE -->
							<%@ include file="/forms/login.jsp"%>
							<!-- <form action="[YOUR ACTION]" method="post" accept-charset="UTF-8">
								<input id="user_username" style="margin-bottom: 15px;" type="text" name="user[username]" size="30" placeholder="username"/>
								<input id="user_password" style="margin-bottom: 15px;" type="password" name="user[password]" size="30" placeholder="password"/>
								<input id="user_remember_me" type="checkbox" name="user[remember_me]" value="1" />
								<label class="string optional" for="user_remember_me">Remember me</label>
								<input class="btn" type="submit" style="margin-bottom: 15px;" name="commit" value="Sign In" />
							</form> -->
						</div>
					</li>
				<% } else if (session.getAttribute("email") != null) { %>
				<li id="login_form" class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Hello, <%=session.getAttribute("email")%> (<%=session.getAttribute("userRole")%>) <strong class="caret"></strong></a>
						<div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;">
							<!-- ADD functions HERE -->
							add functions here!
						</div>
				</li>
				<li><a href="Logout">Logout</a></li>	
				<% } %>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<div class="container theme-showcase" role="main">