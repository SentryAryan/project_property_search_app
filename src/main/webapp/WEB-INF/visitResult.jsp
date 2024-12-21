<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Visit Result</title>
</head>
<body>
<h2>Visit Scheduling Result</h2>
<p>Status: <c:out value="${statusMessage}" /></p>
<c:if test="${isScheduled}">
    <p><a href="visitDetails?buyerUsername=${buyerUsername}&propertyTitle=${propertyTitle}&visitDate=${visitDate}">View Visit Details</a></p>
</c:if>
</body>
</html>