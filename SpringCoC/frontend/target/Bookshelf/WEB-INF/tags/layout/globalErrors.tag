<%@ include file="../declarations.tagf"%>

<c:choose>
	<c:when
		test="${errors != null and errors.globalErrors != null and not empty errors.globalErrors}">
		<div class="globalError">
			<c:forEach var="err" items="${errors.globalErrors}">
				<spring:message code="${err.code}" text="${err.defaultMessage}"
					arguments="${err.arguments}" />
			</c:forEach>
		</div>
	</c:when>
	<c:otherwise>
		<c:if test="${globalError != null and globalError.errors != null and not empty globalError.errors}">
			<div class="globalError">
				<c:forEach var="err" items="${globalError.errors}">
					<spring:message code="${err.code}" arguments="${err.arguments}" />
				</c:forEach>
			</div>
		</c:if>
	</c:otherwise>
</c:choose>

