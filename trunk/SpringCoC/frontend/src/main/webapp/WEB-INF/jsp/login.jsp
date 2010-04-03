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
						<p><span><spring:message code="login.cmd" text="login.cmd"/></span></p>
			        </div>
			</div>
		
			<div id="rightSide" style="float: left; margin-left: 12%;">
				<div class="content">
				    <div class="header" style="margin-left: 0px;">
						<h3><spring:message code="login.cmd" text="login.cmd"/></h3>
					    <layout:globalErrors/>
					</div>
					<div class="loading">
						<form:form method="POST" action="login.do" modelAttribute="user">
							<table border="0" cellpadding="0" cellspacing="0" id="loginTable">
								
									<tr>
										<td><b><spring:message code="login.field" text="login.field"/>:</b></td>
										<td>
											<form:input path="login" maxlength="30"/>
		                                   	<br/><span class="errorInf"><form:errors path="login"/></span>
										</td>
									</tr>
									<tr>
										<td><b><spring:message code="password.field" text="password.field"/>:</b></td>
										<td>
											<form:password path="password" showPassword="true" maxlength="30"/>
		                                   	<br/><span class="errorInf"><form:errors path="password"/></span>
										</td>
									</tr>
		                    		<tr>
										<td>&nbsp;</td>
										<td>
		                                                            
										</td>
									</tr>
							</table>
		                	<input name="submit" src="images/btn_dalej.gif" alt="Zaloguj" type="image" id="btn_log">
						</form:form>
					</div>
				</div>
			
		
			<div>&nbsp;<br/></br></div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>