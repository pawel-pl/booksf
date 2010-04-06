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
					<p><span><s:text name="user.login.label"/></span>${user.login}</p>
		        </div>
			</div>
		
			<div id="rightSide" style="float: left; margin-left: 3%;">
				<div class="content">
				    <div class="header" style="margin-left: 0px;">
						<h4><span><s:text name="customer.edit.titel"/></span></h4>
					    <layout:globalErrors/>
					</div>
					
						<s:form action="customer-edit">
							<table border="0" cellpadding="0" cellspacing="0">
								<s:hidden key="customer.id"/>
									<tr>
										<td>
											<s:textfield key="customer.firstName" maxlength="30"/>
										</td>
									</tr>
									<tr>
										<td>
											<s:textfield key="customer.lastName" maxlength="30"/>
										</td>
									</tr>
									<tr>
										<td>
											<s:textfield key="customer.birthDay" maxlength="30"/>
										</td>
									</tr>
									<tr>
										<td>
											<s:textfield key="customer.email" maxlength="30"/>
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
					<div class="leftButton"><a href="<s:url action="customer-edit-list"/>"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>