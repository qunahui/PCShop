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
        <title>Search page</title>
        <link rel="stylesheet" href=<c:url value="/css/header.css"/> />
        <link rel="stylesheet" href=<c:url value="/css/style.css" /> />
        <link rel="stylesheet" href=<c:url value="/plugins/font-awesome-4.7.0/css/font-awesome.min.css" /> />
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous"/>
    </head>
    <body>
        <jsp:include page="../header.jsp" />
        <div class="container text-center">
                <h1 class="page-title">Accounts</h1>
        </div>
        <form action="MainController" class="input-group container " style="width: 50%">
            <input type="text" class="form-control" placeholder="Search..."  name="txtSearchValue" value="${param.txtSearchValue}">
            <div class="input-group-append">
            <button class="btn btn-secondary" type="submit" value="Search" name="btnAction">
                <i class="fa fa-search"></i>
            </button>
            <input type="hidden" name="controller" value="ViewAccountController"/>
            </div>
        </form> <br/>
        <c:set var="result" value="${requestScope.SEARCHRESULT}"/>
       <c:if test="${not empty result}">
                <table border="1" class="table table-bordered container" >
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">No.</th>
                            <th scope="col">Username</th>
                            <th scope="col">Password</th>
                            <th scope="col">Lastname</th>
                            <th scope="col">firstname</th>
                            <th scope="col">Admin</th>
                            <th scope="col">Delete</th>
                            <th scope="col">Update</th>
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
                                        <button type="submit" value="Update" name="btnAction" class="btn btn-success">Update</button>
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
    </body>
</html>
