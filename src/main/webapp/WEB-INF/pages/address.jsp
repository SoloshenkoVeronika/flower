<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 06.05.2018
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Оформление заказа</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script  src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />" />
    <link rel="stylesheet" href="<c:url value="/resources/css/client.css" />" />
    <link rel="shortcut icon" href="<c:url value="/resources/images/roza.png"/>" type="image/png">
</head>
<body>
<!-- ///////////////////////////////////////////////// -->
<div class="container">
    <div class="header">
        <div class="row">
            <div class="col-md-7">
                <div class="name">
                    Цветочная лавка
                </div>
            </div>

            <div class="col-md-5">
                <form class="navbar-form navbar-left" role="search">
                    <input type="text" id="text-to-find" value="" class="form-control" placeholder="Найти">
                    <button type="submit" class="btn btn-default" onclick="javascript: FindOnPage('text-to-find'); return false;">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- ///////////////////////////////////////////////// -->
<nav class="navbar navbar-default ">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="sr-only"></span>
            </button>

        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="">
                    <a href="<c:url value="/flowers_client"/>" target="_self">Цветы</a>
                </li>
                <li class="">
                    <a href="<c:url value="/bouquets_client"/>" target="_self">Букеты</a>
                </li>
                <li class="">
                    <a href="<c:url value="/compositions_client"/>" target="_self">Копмозиции</a>
                </li>
                <li class="">
                    <a href="<c:url value="/customer_bouquets"/>" target="_self">Составить букет</a>
                </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="<c:url value="/users/currentUser"/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        <c:choose>
                            <c:when test="${user.login ne null}">
                                ${user.login}
                            </c:when>
                            <c:otherwise>
                                Мой профиль
                            </c:otherwise>
                        </c:choose>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="divider"></li>
                        <c:choose>
                            <c:when test="${user.login ne null}">
                                <li><a href="<c:url value="/exit"/>" target="_self">Выход</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="<c:url value="/autorization"/>" target="_self">Вход</a></li>
                            </c:otherwise>
                        </c:choose>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/users"/>" target="_self">Регистрация</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<%--//////////////////////////////////////////////////////////////////////////--%>

<br>
<div class="mybody">
    <div class="container">
        <div class="article container">
            <div class="row otstup">
                <div class="col-md-8">
                    <h1 class="h2 page-header"
                        style="color:#8d1645; font-family: 'Lobster', cursive; margin-top: -1px;
                        text-align: center;">Оформление заказа</h1>
                    <section class="main">
                        <div class="orderhead">
                            <h1>Адрес доставки</h1>
                        </div>
                        <c:url var="addAction" value="/addresss/add"/>

                        <form:form action="${addAction}" commandName="address" class="form-horizontal">
                            <c:if test="${!empty address.city}">
                                <div class="form-group">
                                    <form:label path="id" class="col-sm-2 control-label">
                                        <spring:message text="ID"/>
                                    </form:label>
                                    <div class="col-sm-2">
                                        <form:input path="id" readonly="true" size="8" disabled="true"
                                                    class="form-control"/>
                                        <form:hidden path="id"/>
                                    </div>
                                </div>
                            </c:if>
                            <div class="form-group">
                                <form:label path="city" class="col-sm-2 control-label">
                                    <spring:message text="Город"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="city" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="street" class="col-sm-2 control-label">
                                    <spring:message text="Улица"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="street" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="house" class="col-sm-2 control-label">
                                    <spring:message text="№ Дома"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="house" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="block" class="col-sm-2 control-label">
                                    <spring:message text="№ Корпус"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="block" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="flat" class="col-sm-2 control-label">
                                    <spring:message text="№ Квартиры"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="flat" class="form-control"/>
                                </div>
                            </div>


                        <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <input type="submit" class="btn btn-success"
                                           value="<spring:message text="Следующий шаг"/>"/>
                                </div>
                            </div>
                        </form:form>
                    </section>
                </div>
                <div class="col-md-4">
                    <h4 class="page-header">Сумма заказа</h4>
                    <ul class="list-group">
                        <p class="list-group-item list-group-item-success"> <fmt:formatNumber type="number" maxFractionDigits="2" value="${order.cost}"/> p.</p>

                    </ul>
                    <h4 class="page-header">Товары в  Вашей корзине</h4>
                    <ul class="list-group">
                        <c:forEach items="${order.flowerOrdersById}" var="flowerOrder">
                            <p class="list-group-item list-group-item-success">${flowerOrder.flowerByFlowerId.species}
                                    ${flowerOrder.flowerByFlowerId.sort}, ${flowerOrder.quantity} шт</p>
                        </c:forEach>
                        <c:forEach items="${order.bouquetOrdersById}" var="bouquetOrder">
                            <p class="list-group-item list-group-item-success">Букет ${bouquetOrder.bouquetByBouquetId.name},
                                    ${bouquetOrder.quantity} шт.</p>
                        </c:forEach>
                        <c:forEach items="${order.compositionOrdersById}" var="compositionOrder">
                            <p class="list-group-item list-group-item-success">Композиция ${compositionOrder.compositionByCompositionId.name},
                                    ${compositionOrder.quantity} шт.</p>
                        </c:forEach>
                        <c:set var="i" value="0"/>
                        <c:forEach items="${order.customerBouquetOrdersById}"
                                   var="customerBouquetOrder">
                            <p class="list-group-item list-group-item-success">Букет № <c:out value="${i=i+1}"/></p>
                        </c:forEach>
                    </ul>

                </div>

            </div>
        </div>
    </div>

    <footer>
        <div class="container">
            <div style="padding: 10px 0pt 0pt 30px; clear: both; color: #8d1645; font-size: 15px;">Все права защищены &copy; <?=date ('Y')?></div>
        </div>
    </footer>
</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("resources/images/fon1.jpg");
</script>
</body>
</html>