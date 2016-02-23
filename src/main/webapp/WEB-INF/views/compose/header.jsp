<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <title>Order registration</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/order/add" var="urlAddOrder"/>
<spring:url value="/order/" var="urlOrders"/>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Home</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlOrders}">All orders</a></li>
            </ul>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlAddOrder}">Add order</a></li>
            </ul>
        </div>
    </div>
</nav>