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
						<h4><span><spring:message code="customer.titel.label"/></span></h4>
					    <layout:globalErrors/>
					</div>
					
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2">
						<b><spring:message code="customer.info.titel"/></b>
					</td>	
				</tr>
				<tr>
					<td>
						<b><spring:message code="customers.first.name"/></b><span>${customer.firstName}</span>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						<b><spring:message code="customers.last.name"/></b><span>${customer.lastName}</span>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						<b><spring:message code="customers.email.address"/></b><span>${customer.email}</span>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						<b><spring:message code="customers.birth.day"/></b><span>${customer.birthDay}</span>
					</td>
					<td>
					</td>
				</tr>				
			</table>
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2">
						<b><spring:message code="cust.book.info.titel"/></b>
					</td>	
				</tr>
				<tr class="head">
					<th style="width:25%"><spring:message code="cust.book.titel"/></th>
					<th style="width:25%"><spring:message code="cust.book.author.first.name"/></th>
					<th style="width:25%"><spring:message code="cust.book.author.last.name"/></th>
					<th style="width:25%"><spring:message code="cust.book.year"/></th>
				</tr>
				<c:forEach items="${customer.books}" var="book">
					<tr>
						<td style="text-align:left;">${book.titel}</td>
						<td style="text-align:left;">${book.authorName}</td>
						<td style="text-align:left;">${book.authorLastName}</td>
						<td style="text-align:left;">${book.year}</td>
					</tr>
				</c:forEach>				
			</table>
			  <table class="table-buttons">
			    <tr>
			      <td colspan="2" align="center">
			        <form method="GET" action="<c:url value="/addBook.do"/>">
			          <input type="hidden" name="custId" value="${customer.id}"/>
			          <p class="submit"><input type="submit" value="<spring:message code="book.add"/>"/></p>
			        </form>
			      </td>
			      <td>
			        <form method="GET" action="<c:url value="/removeBook.do"/>">
			          <input type="hidden" name="custId" value="${customer.id}"/>
			          <p class="submit"><input type="submit" value="<spring:message code="book.remove"/>"/></p>
			        </form>
			      </td>
			    </tr>
			  </table>
					<div class="leftButton"><a href="rentBook.do"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>