<%@ include file="lib.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="<%=CONTENT_TYPE%>">
		<title>Exception page</title>
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

	<div id="rightSide" style="float: left;">

		<div class="content">
		    <div class="header" style="margin-left: 0px; border-bottom:1px solid #D0DFB3;">
				<h3><span><spring:message code="fatal.error.titel" /></span></h3>
			</div>
		    <div class="header" style="margin-left: 0px;">
				<h4><span><spring:message code="error.details.info" /></span></h4>		
			</div>
		</div>
		<div class = "commentForm"> 
    		<table class="infoAppTable" style="width: 70%">
				<tr>
					<td colspan="2" class="titleTd">
						<spring:message code="error.details.info.date"/>
					</td>
			
					<td class="infoTd">
						${edh.date}
					</td>			
				</tr> 
				<tr>
					<td colspan="2" class="titleTd">
						<spring:message code="error.details.info.sessoin.id"/>
					</td>
			
					<td class="infoTd">
						${edh.sessionId}
					</td>			
				</tr>
				<tr>
					<td colspan="2" class="titleTd">
						<spring:message code="error.details.info.message"/>
					</td>
			
					<td class="infoTd">
						${edh.message}
					</td>			
				</tr>
				<tr>
					<td colspan="2" class="titleTd">
						<spring:message code="error.details.info.location"/>
					</td>
			
					<td class="infoTd">
						${edh.location}
					</td>			
				</tr>
				<tr>
					<td colspan="2" class="titleTd">
						<spring:message code="error.details.info.stack.trace"/>
					</td>
			
					<td class="infoTd">
						${edh.fullStackTrace}
					</td>			
				</tr>								
			</table>
		</div>
		<div class="leftButton"><a href="wellcome.do"><img  src="images/btn_wstecz.gif" alt="OK" ></a></div>
	</div>
</div>
</body>
</html>