<%!
	String CONTENT = "text/html";
	String TYPE = "charset=utf-8";
	String CONTENT_TYPE = CONTENT + "; " + TYPE;
%>
<% response.setContentType( CONTENT_TYPE ); %>
<% response.addHeader("Cache-Control", "no-cache"); %>
<% response.addHeader("Pragma", "no-cache"); %>
<%@page contentType="text/html"%>
<%@page pageEncoding="utf-8"%>
<%@ page isELIgnored='false'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>