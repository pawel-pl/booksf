<%@ include file="lib.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="<%=CONTENT_TYPE%>">
		<title>Remove Book</title>
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
						<h4><span><s:text name="remove.book.title"/></span></h4>
					    <layout:globalErrors/>
					</div>
					
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2">
						<b><s:text name="customer.info.titel"/></b>
					</td>	
				</tr>
				<tr>
					<td>
						<b><s:text name="customers.first.name"/></b><span><s:property value="customer.firstName"/></span>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						<b><s:text name="customers.last.name"/></b><span><s:property value="customer.lastName"/></span>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						<b><s:text name="customers.email.address"/></b><span><s:property value="customer.email"/></span>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						<b><s:text name="customers.birth.day"/></b><span><s:property value="customer.birthDay"/></span>
					</td>
					<td>
					</td>
				</tr>				
			</table>
			<s:form action="remove-book">
				<table border="0" cellpadding="0" cellspacing="0">
					<s:hidden key="customer.id"/>
					<tr>
						<td colspan="2">
							<b><s:text name="rented.books.titel"/></b>
						</td>	
					</tr>
					<tr class="head">
						<th style="width:20px"><s:text name="rent.book.choose.table.header"/></th>
						<th style="width:30%"><s:text name="cust.book.titel"/></th>
						<th style="width:30%"><s:text name="cust.book.author.first.name"/></th>
						<th style="width:30%"><s:text name="cust.book.author.last.name"/></th>
					</tr>
					<s:iterator value="selectedBooks.books">
						<tr>
							<td style="width:20px; text-align:left;">
								<s:checkbox theme="simple" name="selectedBooks.selectedBooks" fieldValue="%{getId()}" cssStyle="width:20px"/>
							</td>
							<td style="width:30%; text-align:left;"><s:property value="titel"/></td>
							<td style="width:30%; text-align:left;"><s:property value="authorName"/></td>
							<td style="width:30%; text-align:left;"><s:property value="authorLastName"/></td>

						</tr>
					</s:iterator>				
				</table>
				<p class="submit"><input type="submit" name="method:removeBook" value="<s:text name="book.remove"/>"/></p>
			</s:form>	
					<div class="leftButton"><a href="customer.action?customer.id=${customer.id}"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>