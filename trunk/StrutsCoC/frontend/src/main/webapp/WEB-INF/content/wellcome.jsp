<%@ include file="header.jsp" %>
   <SCRIPT language=Javascript>
		function changeLang(lang) {
			
			if(document.URL.match(new RegExp("\\?","g")))
			{
				if(document.URL.match(new RegExp("lang=","g")))
				{
					var string = document.URL;
					var reg = new RegExp("lang=.*","g");
					string = string.replace(reg,"lang="+lang);
					window.location.replace(string);
				}
				else
				{
					window.location.replace(document.URL+"&lang="+lang);
				}
			}
			else
			{
				window.location.replace(document.URL+"?lang="+lang);
			}
		}
   </SCRIPT>
			<%-- <form name="langForm">
				<div class="header" style="margin-left: 0px;">
					<table>
						<tr>
							<td style="text-align: left">
								<h3><span>${user.login}<spring:message code="wellcome.login.label"/></span></h3>
							</td>
							<td>
								<span style="float: right"><spring:message code="lang.select.label"/></span>
								<br><select id="langSelectBox" style="float: right" onclick="changeLang(document.langForm.langSelectBox.value);">
	  								<option value="pl"><spring:message code="lang.select.polish"/></option>
	  								<option value="en"><spring:message code="lang.select.english"/></option>
								</select>
							</td>
						</tr>
					</table>
				</div>--%>
				
				<div id="rightSide">
				    <div class="content">
					    <div class="main">
					        <img id="mainLogo" src="images/wellcome.jpg" alt="Wellcome">
					    </div>
				    </div>
			     </div>
			     <div id="leftSide">
			     	<%@ include file="menu.jsp" %>
			     </div>
			</form>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>