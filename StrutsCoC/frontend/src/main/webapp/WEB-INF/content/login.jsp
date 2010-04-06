<%@ include file="lib.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="<%=CONTENT_TYPE%>">
		<title>Login to bookshelf</title>
	    <link href="css/bookshelf.css" rel="stylesheet" type="text/css" media="screen, projection">
	</head>
	<body>
		<div id="workspace">
			<div id="top">
			        <img id="logo" src="images/logo.jpg" alt="Bookshelf">
			        <div id="userIdent">
						<p><span><s:text name="login.cmd"/></span></p>
			        </div>
			</div>
		
			<div id="rightSide" style="float: left; margin-left: 12%;">
				<div class="content">
				    <div class="header" style="margin-left: 0px;">
						<h3><s:text name="login.cmd"/></h3>
					    <layout:globalErrors/>
					</div>
					<div class="loading">
						<s:form action="login">
							<table border="0" cellpadding="0" cellspacing="0" id="loginTable">
									<tr>
										<td>
											<s:textfield key="user.login" maxlength="30" cssErrorClass="errorInf"/>
										</td>
									</tr>
									<tr>
										<td>
											<s:password showPassword="true" key="user.password" maxlength="30" cssErrorClass="errorInf"/>
										</td>
									</tr>
		                    		<tr>
										<td>&nbsp;</td>
									</tr>
							</table>
							<s:submit method="login" src="images/btn_dalej.gif" type="image" cssStyle="float: left; margin-left: 83%;"/>
						</s:form>
					</div>
				</div>
			
		
			<div>&nbsp;<br/></br></div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>