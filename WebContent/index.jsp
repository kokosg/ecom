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
	<p>This is a template for a simple marketing or informational
		website. It includes a large callout called a jumbotron and three
		supporting pieces of content. Use it as a starting point to create
		something more unique.</p>
	<p>
		<a href="#" class="btn btn-primary btn-lg" role="button">Learn
			more &raquo;</a>
	</p>
<% } else if (session.getAttribute("email") == null) { %>
<h1>Hello, GuestUser!</h1>
<p>This is a template for a simple marketing or informational
	website. It includes a large callout called a jumbotron and three
	supporting pieces of content. Use it as a starting point to create
	something more unique.</p>
<p>
	<a href="#" class="btn btn-primary btn-lg" role="button">Learn
		more &raquo;</a>
</p>
<% } %> 
</div>
<div id="results"></div><!-- ???? -->

<%@ include file="footer.jsp"%>

</body>
</html>