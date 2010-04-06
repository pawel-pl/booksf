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
					<p><span><s:text name="user.login.label"/></span>${user.login}</p>
		        </div>
			</div>
		
			<div id="rightSide" style="float: left; margin-left: 3%;">
				<div class="content">
				    <div class="header" style="margin-left: 0px;">
						<h4><span><s:text name="book.edit.titel"/></span></h4>
					    <layout:globalErrors/>
					</div>
					
						<s:form action="book-edit">
							<s:hidden key="book.id"/>
							<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<s:textfield key="book.titel" maxlength="30"/>
										</td>
									</tr>
									<tr>
										<td>
											<s:textfield key="book.authorName" maxlength="30"/>
										</td>
									</tr>
									<tr>
										<td>
											<s:textfield key="book.authorLastName" maxlength="30"/>
										</td>
									</tr>
		                    		<tr>
										<td>&nbsp;</td>
										<td>
		                                                            
										</td>
									</tr>
							</table>
		                	<p class="submit"><input type="submit" name="method:submit" value="<s:text name="save.data"/>"/></p>
						</s:form>
					<div class="leftButton"><a href="bookListToEdit.do"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>