<%@ include file="lib.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="<%=CONTENT_TYPE%>">
		<title>Customers</title>
	    <link href="css/bookshelf.css" rel="stylesheet" type="text/css" media="screen, projection">
	</head>
	<body>
    <script type="text/javascript">
	  	function DoNav(theUrl)
	  	{
	  		var s = document.URL;
	  		var ind = s.indexOf('/',7);
	  		s = s.substring(0, (s.indexOf('/',ind+1))+1);
	  		s = s+theUrl
	  		document.location.href = s;
	  	}

  	</script>
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
						<h4><span><spring:message code="customers.titel.label"/></span></h4>
					    <layout:globalErrors/>
					</div>
					
					<table class="addTable">
						<tr class="head">
							<th style="width:200px"><spring:message code="customers.first.name"/></th>
							<th style="width:70px"><spring:message code="customers.last.name"/></th>
							<th style="width:70px"><spring:message code="customers.email.address"/></th>
						</tr>
						<c:forEach items="${customers}" var="cust" varStatus='status'>
							
							<c:choose>
								<c:when test="${status.count % 2 == 0}">
							    	<tr class="adTableRowGrey"
              							onclick="DoNav('customer.do?custId=${cust.id}');">
								</c:when>
								<c:otherwise>
							    	<tr class="adTableRowWhite"
              							onclick="DoNav('customer.do?custId=${cust.id}');">   
								</c:otherwise>
							</c:choose>
							
								<td style="width:60px; text-align:left;">${cust.firstName}</td>
								<td style="width:60px; text-align:left;">${cust.lastName}</td>
								<td style="width:60px; text-align:left;">${cust.email}</td>
							</tr>
						</c:forEach>	
					</table>
					<div class="leftButton"><a href="wellcome.do"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>