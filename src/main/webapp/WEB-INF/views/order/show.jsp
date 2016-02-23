<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="../compose/header.jsp"/>
<div class="container">
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>Order Detail</h1>
    <br/>

    <div class="row">
        <label class="col-sm-2">ID</label>

        <div class="col-sm-10">${order.orderId}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Description</label>
        <div class="col-sm-10">${order.description}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Target link</label>
        <div class="col-sm-10">${order.targetLink}</div>
    </div>

    <div class="row">
        <label class="col-sm-2">Back link</label>
        <div class="col-sm-10">${order.comeBackLink}</div>
    </div>

</div>
<jsp:include page="../compose/footer.jsp"/>
</body>
</html>