<%-- 
    Document   : search
    Created on : Apr 30, 2020, 2:52:13 PM
    Author     : Hui
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
    </head>
    <body>
        <jsp:include page="../header.jsp" />
        <div class="page-header">
            <div class="content-container content-container__page-header">
                <h1 class="page-title">Accounts</h1>
            </div>
        </div>
        <form action="MainController" class="content-container content-container__center">
            Search value <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" /> <br/> 
            <input type="submit" value="Search" name="btnAction"/>
            <button><a href="/PCShop/admin/ViewAccountController">Search All</a></button>
            <input type="hidden" name="controller" value="SearchAccountController"/>
        </form><br/>
        
        <c:set var="searchValue" value="${param.txtSearchValue}"/>
        <c:if test="${not empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1" class="content-container content-container__center" >
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Lastname</th>
                            <th>firstname</th>
                            <th>Roles</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                            <form action="MainController">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${dto.username}
                                        <input type="hidden" name="txtUsername" value="${dto.username}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtPassword" value="${dto.password}" />
                                    </td>
                                    <td>
                                        ${dto.lastname}
                                    </td>
                                    <td>
                                        ${dto.firstname}
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkAdmin" value="ADMIN"
                                               <c:if test="${dto.admin}">checked="checked"</c:if>
                                               >
                                    </td>
                                    <td>
                                        <c:url var="delLink" value="MainController">
                                            <c:param name="controller" value="DeleteAccountController"/>
                                            <c:param name="btnAction" value="del"/>
                                            <c:param name="pk" value="${dto.username}"/>
                                            <c:param name="lastSearchValue" value="${param.txtSearchValue}"/>
                                        </c:url>
                                        <a href="${delLink}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update" name="btnAction" />
                                        <input type="hidden" name="lastSearchValue"
                                               value="${param.txtSearchValue}"/>
                                        <input type="hidden" name="controller" value="UpdateAccountController"/>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>    
                    </tbody>
                </table>
                
            </c:if>
            <c:if test="${empty result}">
                <h2>No record is matched!!!</h2>
            </c:if>
        </c:if>
        
        <c:if test="${empty searchValue}">
            <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
            <c:if test="${not empty result}">
                <table border="1" class="content-container content-container__center">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Lastname</th>
                            <th>firstname</th>
                            <th>Roles</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                            <form action="MainController">
                                <tr>
                                    <td>
                                        ${counter.count}
                                    </td>
                                    <td>
                                        ${dto.username}
                                        <input type="hidden" name="txtUsername" value="${dto.username}" />
                                    </td>
                                    <td>
                                        <input type="text" name="txtPassword" value="${dto.password}" />
                                    </td>
                                    <td>
                                        ${dto.lastname}
                                    </td>
                                    <td>
                                        ${dto.firstname}
                                    </td>
                                    <td>
                                        <input type="checkbox" name="chkAdmin" value="ADMIN"
                                               <c:if test="${dto.admin}">checked="checked"</c:if>
                                               >
                                    </td>
                                    <td>
                                        <c:url var="delLink" value="MainController">
                                            <c:param name="controller" value="DeleteAccountController"/>
                                            <c:param name="btnAction" value="del"/>
                                            <c:param name="pk" value="${dto.username}"/>
                                            <c:param name="lastSearchValue" value="${param.txtSearchValue}"/>
                                        </c:url>
                                        <a href="${delLink}">Delete</a>
                                    </td>
                                    <td>
                                        <input type="submit" value="Update" name="btnAction" />
                                        <input type="hidden" name="lastSearchValue"
                                               value="${param.txtSearchValue}"/>
                                        <input type="hidden" name="controller" value="UpdateAccountController"/>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>    
                    </tbody>
                </table>
                
            </c:if>
            <c:if test="${empty result}">
                <h2>No record is matched!!!</h2>
            </c:if>
        </c:if>
        
    </body>
</html>
