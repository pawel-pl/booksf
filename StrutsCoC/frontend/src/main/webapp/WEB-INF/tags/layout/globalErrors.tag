<%@ include file="../declarations.tagf"%>

	<s:if test="hasActionErrors()">
		<div class="globalError">
			<s:iterator value="actionErrors"> 
				<span><s:property escape="false" /></span> 
			</s:iterator> 
		</div>
	</s:if>


