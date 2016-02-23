<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../compose/header.jsp"/>
<body>

<div class="container">
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>All orders</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Target link</th>
            <th>Come back link</th>
            <th>Action</th>
        </tr>
        </thead>

        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.title}</td>
                <td>${order.description}</td>
                <td>${order.targetLink}</td>
                <td>${order.comeBackLink}</td>
                <td>
                    <spring:url value="/order/${order.orderId}" var="orderUrl"/>
                        <%-- 						<spring:url value="/users/${user.id}/delete" var="deleteUrl" />  --%>
                    <spring:url value="/order/${order.orderId}/update" var="updateUrl"/>

                    <button class="btn btn-info" onclick="location.href='${orderUrl}'">Query</button>
                    <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                        <%-- 						<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td> --%>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<jsp:include page="../compose/footer.jsp"/>

</body>
</html>