<%@ include file="lib.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="<%=CONTENT_TYPE%>">
		<title>Edit Books</title>
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
						<h4><span><spring:message code="book.edit.titel"/></span></h4>
					    <layout:globalErrors/>
					</div>
					
						<form:form method="POST" action="editBook.do" modelAttribute="book">
							<table border="0" cellpadding="0" cellspacing="0">
								
									<tr>
										<td><b><spring:message code="cust.book.titel"/>:</b></td>
										<td>
											<form:input path="titel" maxlength="30"/>
		                                   	<br/><span class="errorInf"><form:errors path="titel"/></span>
										</td>
									</tr>
									<tr>
										<td><b><spring:message code="cust.book.author.first.name"/>:</b></td>
										<td>
											<form:input path="authorName" maxlength="30"/>
		                                   	<br/><span class="errorInf"><form:errors path="authorName"/></span>
										</td>
									</tr>
									<tr>
										<td><b><spring:message code="cust.book.author.last.name"/>:</b></td>
										<td>
											<form:input path="authorLastName" maxlength="30"/>
		                                   	<br/><span class="errorInf"><form:errors path="authorLastName"/></span>
										</td>
									</tr>
		                    		<tr>
										<td>&nbsp;</td>
										<td>
		                                                            
										</td>
									</tr>
							</table>
		                	<p class="submit"><input type="submit" value="<spring:message code="save.data"/>"/></p>
						</form:form>
					<div class="leftButton"><a href="bookListToEdit.do"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>