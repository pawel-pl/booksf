<%@ include file="lib.jsp" %>
<html>
	<head>
		<title>Login to bookshelf</title>
	</head>
	<body>
		TEST
		<s:url action="Login" var="login"/>
		<p><a href="${login}">Login</a></p>
		
		<p><a href="<s:url action="Login"/>">Login 2</a></p>
	</body>
</html>
	