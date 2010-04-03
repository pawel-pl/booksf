<%@ include file="lib.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="<%=CONTENT_TYPE%>">
		<title>Customers</title>
	    <link href="css/bookshelf.css" rel="stylesheet" type="text/css" media="screen, projection">
	</head>
	<body>
		<div id="workspace">
			<div id="top">
		        <img id="logo" src="images/logo.jpg" alt="Bookshelf">
		        <div id="userIdent">
					<p><span><spring:message code="user.login.label" text="user.login.label"/></span>${user.login}</p>
		        </div>
			</div>
		
			<div id="rightSide" style="float: left; margin-left: 3%;">
				<div class="content">
				    <div class="header" style="margin-left: 0px;">
						<h4><span><spring:message code="customer.add.titel"/></span></h4>
					    <layout:globalErrors/>
					</div>
					
						<form:form method="POST" action="addCustomer.do" modelAttribute="customer">
							<table border="0" cellpadding="0" cellspacing="0">
								
									<tr>
										<td><b><spring:message code="customers.first.name"/>:</b></td>
										<td>
											<form:input path="firstName" maxlength="30"/>
		                                   	<br/><span class="errorInf"><form:errors path="firstName"/></span>
										</td>
									</tr>
									<tr>
										<td><b><spring:message code="customers.last.name"/>:</b></td>
										<td>
											<form:input path="lastName" maxlength="30"/>
		                                   	<br/><span class="errorInf"><form:errors path="lastName"/></span>
										</td>
									</tr>
									<tr>
										<td><b><spring:message code="customers.birth.day"/>:</b></td>
										<td>
											<form:input path="birthDay" maxlength="30"/>
		                                   	<br/><span class="errorInf"><form:errors path="birthDay"/></span>
										</td>
									</tr>
									<tr>
										<td><b><spring:message code="customers.email.address" text="customers.email.address"/>:</b></td>
										<td>
											<form:input path="email" maxlength="30"/>
		                                   	<br/><span class="errorInf"><form:errors path="email"/></span>
										</td>
									</tr>
		                    		<tr>
										<td>&nbsp;</td>
										<td>
		                                                            
										</td>
									</tr>
							</table>
		                	<p class="submit"><input type="submit" value="<spring:message code="add.customer"/>"/></p>
						</form:form>
					<div class="leftButton"><a href="wellcome.do"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>