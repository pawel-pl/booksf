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
						<h4><span><s:text name="customer.titel.label"/></span></h4>
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
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2">
						<b><s:text name="cust.book.info.titel"/></b>
					</td>	
				</tr>
				<tr class="head">
					<th style="width:25%"><s:text name="cust.book.titel"/></th>
					<th style="width:25%"><s:text name="cust.book.author.first.name"/></th>
					<th style="width:25%"><s:text name="cust.book.author.last.name"/></th>
					<th style="width:25%"><s:text name="cust.book.year"/></th>
				</tr>
					<s:iterator value="customer.books">
						<tr>
							<td style="text-align:left;"><s:property value="titel"/></td>
							<td style="text-align:left;"><s:property value="authorName"/></td>
							<td style="text-align:left;"><s:property value="authorLastName"/></td>
							<td style="text-align:left;"><s:property value="year"/></td>
						</tr>
					</s:iterator>
			
			</table>
			  <table class="table-buttons">
			    <tr>
			      <td colspan="2" align="center">
			        <form method="GET" action="<c:url value="/add-book.action"/>">
			          <input type="hidden" name="customer.id" value="${customer.id}"/>
			          <p class="submit"><input type="submit" value="<s:text name="book.add"/>"/></p>
			        </form>
			      </td>
			      <td>
			        <form method="GET" action="<c:url value="/remove-book.action"/>">
			          <input type="hidden" name="customer.id" value="${customer.id}"/>
			          <p class="submit"><input type="submit" value="<s:text name="book.remove"/>"/></p>
			        </form>
			      </td>
			    </tr>
			  </table>
					<div class="leftButton"><a href="<s:url action="rent-book"/>"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>