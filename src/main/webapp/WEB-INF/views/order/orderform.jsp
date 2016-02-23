<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../compose/header.jsp"/>

<div class="container">
    <spring:url value="/order/add" var="orderAddUrl"/>
    <form:form class="form-horizontal" method="post" modelAttribute="orderForm" action="${orderAddUrl}">

        <spring:bind path="title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Title</label>

                <div class="col-sm-10">
                    <form:input path="title" type="text" class="form-control " id="title" placeholder="Title"/>
                    <form:errors path="title" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="description">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Description</label>

                <div class="col-sm-10">
                    <form:input path="description" type="text" class="form-control " id="description" placeholder="Description"/>
                    <form:errors path="description" class="control-label"/>
                </div>
            </div>
        </spring:bind>
        <spring:bind path="targetLink">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Target link</label>

                <div class="col-sm-10">
                    <form:input path="targetLink" type="text" class="form-control " id="title" placeholder="Target link"/>
                    <form:errors path="targetLink" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="comeBackLink">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <label class="col-sm-2 control-label">Come back link</label>

                <div class="col-sm-10">
                    <form:input path="comeBackLink" type="text" class="form-control " id="comeBackLink" placeholder="Come back link"/>
                    <form:errors path="comeBackLink" class="control-label"/>
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${orderForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

    </form:form>
</div>
</body>
</html>
