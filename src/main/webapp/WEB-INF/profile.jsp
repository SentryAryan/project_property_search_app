<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Buyer Profile</title>
</head>
<body>
    <h1>Buyer Profile</h1>
    <div>
        <p><strong>Username:</strong> ${buyer.username}</p>
        <p><strong>Email:</strong> ${buyer.email}</p>
    </div>
    <div>
        <h2>Change Password</h2>
        <form:form action="${pageContext.request.contextPath}/buyer/changePassword" method="post" modelAttribute="buyer">
            <form:hidden path="buyerId" />
            <label for="newPassword">New Password:</label>
            <form:input path="newPassword" id="newPassword" required="true" />
            <button type="submit">Change Password</button>
        </form:form>
    </div>
    <div>
        <c:if test="${not empty message}">
            <p>${message}</p>
        </c:if>
    </div>
</body>
</html>