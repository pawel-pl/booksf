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
						<h4><span><spring:message code="book.edit.list.titel"/></span></h4>
					    <layout:globalErrors/>
					</div>
					<form:form method="POST" action="bookListToEdit.do" modelAttribute="freeBooks">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr class="head">
								<th style="width:20px"><spring:message code="rent.book.choose.table.header"/></th>
								<th style="width:30%"><spring:message code="cust.book.titel"/></th>
								<th style="width:30%"><spring:message code="cust.book.author.first.name"/></th>
								<th style="width:30%"><spring:message code="cust.book.author.last.name"/></th>
							</tr>
							<c:forEach items="${freeBooks.books}" var="book">
								<tr>
									<td style="width:20px; text-align:left;">
										<form:radiobutton path="bookId" value="${book.id}" cssStyle="width:20px"/>
									</td>
									<td style="width:30%; text-align:left;">${book.titel}</td>
									<td style="width:30%; text-align:left;">${book.authorName}</td>
									<td style="width:30%; text-align:left;">${book.authorLastName}</td>
		
								</tr>
							</c:forEach>				
						</table>
						<p class="submit"><input type="submit" value="<spring:message code="edit.data"/>"/></p>
					</form:form>	
					<div class="leftButton"><a href="wellcome.do"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>