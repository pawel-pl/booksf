<%@ include file="lib.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="<%=CONTENT_TYPE%>">
		<title>Edit customers list</title>
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
					<p><span><s:text name="user.login.label"/></span>${user.login}</p>
		        </div>
			</div>
		
			<div id="rightSide" style="float: left; margin-left: 3%;">
				<div class="content">
				    <div class="header" style="margin-left: 0px;">
						<h4><span><s:text name="customer.edit.list.titel"/></span></h4>
					    <layout:globalErrors/>
					</div>
					
					<table class="addTable">
						<tr class="head">
							<th style="width:200px"><s:text name="customers.first.name"/></th>
							<th style="width:70px"><s:text name="customers.last.name"/></th>
							<th style="width:70px"><s:text name="customers.email.address"/></th>
						</tr>
						<s:iterator value="customers" status="rowstatus">
    						<s:if test="#rowstatus.odd == false">
						    	<tr class="adTableRowGrey"
             							onclick="DoNav('customer-edit.action?customer.id=<s:property value="id"/>');">
    						</s:if>
    						<s:else>
						    	<tr class="adTableRowWhite"
             							onclick="DoNav('customer-edit.action?customer.id=<s:property value="id"/>');"> 
   			 				</s:else>
							
								<td style="width:60px; text-align:left;"><s:property value="firstName"/></td>
								<td style="width:60px; text-align:left;"><s:property value="lastName"/></td>
								<td style="width:60px; text-align:left;"><s:property value="email"/></td>
							</tr>
						</s:iterator>	
					</table>
					<div class="leftButton"><a href="<s:url action="wellcome"/>"><img  src="images/btn_wstecz.gif" alt="Back" ></a></div>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>