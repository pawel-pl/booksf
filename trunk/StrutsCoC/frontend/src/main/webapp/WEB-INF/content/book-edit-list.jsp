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
						<h4><span><s:text name="book.edit.list.titel"/></span></h4>
					    <layout:globalErrors/>
					</div>
					<s:form action="book-edit">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr class="head">
								<th style="width:20px"><s:text name="rent.book.choose.table.header"/></th>
								<th style="width:30%"><s:text name="cust.book.titel"/></th>
								<th style="width:30%"><s:text name="cust.book.author.first.name"/></th>
								<th style="width:30%"><s:text name="cust.book.author.last.name"/></th>
							</tr>
							<s:iterator value="selectedBooks.books">
								<tr>
									<td style="width:20px; text-align:left;">
										<s:radio theme="simple" name="book.id" list="{id}" cssStyle="width:20px"/>
									</td>
									<td style="width:30%; text-align:left;"><s:property value="titel"/></td>
									<td style="width:30%; text-align:left;"><s:property value="authorName"/></td>
									<td style="width:30%; text-align:left;"><s:property value="authorLastName"/></td>
		
								</tr>
							</s:iterator>				
						</table>
						<p class="submit"><input type="submit" value="<s:text name="edit.data"/>"/></p>
					</s:form>	
					<div class="leftButton"><a href="<s:url action="wellcome"/>"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>