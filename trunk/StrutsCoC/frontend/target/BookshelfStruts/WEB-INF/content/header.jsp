<%@ include file="lib.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="<%=CONTENT_TYPE%>">
		<title>Wellcome in Bookshelf</title>
	    <link href="css/bookshelf.css" rel="stylesheet" type="text/css" media="screen, projection">
	</head>
	<body>
		<div id="workspace">
			<div id="top">
		        <img id="logo" src="images/logo.jpg" alt="Bookshelf">
		        <div id="userIdent">
					<p><span><s:text name="user.login.label"/></span>${user.login}</p>
		        </div>
		        <div id="logout">
					<p><span><a href="<s:url action="Logout"/>"><s:text name="user.logout.label"/></a></span></p>
		        </div>
			</div>