<%-- 
    Document   : landingPage
    Created on : May 19, 2020, 3:00:41 PM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="<c:url value="/css/landingPage.css" />">
    <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
    <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
    <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
</head>

<body>
    <jsp:include page="header.jsp" />
</body>

</html>