<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp"%>

<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<% if (request.getAttribute("message123") != null) { %>
			<%= request.getAttribute("message123") %> 
		<% } %>
		<% if (session.getAttribute("email") != null) { %>
			<h1>Hello, <%= session.getAttribute("userName") %> <%= session.getAttribute("userSurname") %>!</h1>
		<% } else if (session.getAttribute("email") == null) { %>
			<h1>Hello, GuestUser!</h1>
		<% } %> 
		<p>Example - ScienceDirect: is a leading full-text scientific database offering journal articles and book chapters from more than 2,500 journals and almost 20,000 books.</p>
		<p> <a href="#" class="btn btn-primary btn-lg" role="button">Learn more &raquo;</a> </p>
	</div>
	<div class="col-lg-4">
		<div class="bs-component">
			<div class="well">Look, I'm in a well!</div>
		</div>
	</div>
	<div class="col-lg-8">
		<div class="bs-component">
			<div class="well">Look, I'm in a small well!</div>
		</div>
	</div>
	<div id="results"></div><!-- ???? -->
	<%@ include file="footer.jsp"%>
	
</body>
</html>