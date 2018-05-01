<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.04.2018
  Time: 22:27
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
    <title>Ваши заказы</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/form.css" />"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/roza.png"/>" type="image/png">

    <style>
        td {
            border-width: 2px;
            border-color: #836FFF;
            border-style: none none dashed dashed;
        }
    </style>
</head>
<body>

<!-- ///////////////////////////////////////////////// -->
<div class="container">
    <div class="header">
        <div class="row">
            <div class="col-md-8">
                <div class="name">
                    Цветочная лавка
                </div>
            </div>

            <div class="col-md-4">

                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Найти">
                    </div>
                    <button type="submit" class="btn btn-default">
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
                <%--<li class="">--%>
                <%--<a href="<c:url value="/bouquets_client"/>" target="_self">Букеты</a>--%>
                <%--</li>--%>
                <%--<li class="">--%>
                <%--<a href="<c:url value="/compositions_client"/>" target="_self">Копмозиции</a>--%>
                <%--</li>--%>
                <%--<li class="">--%>
                <%--<a href="<c:url value="/packs_client"/>" target="_self">Составить букет</a>--%>
                <%--</li>--%>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Мой
                        профиль<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="divider"></li>
                        <li><a href="<c:url value="/autorization"/>" target="_self">Вход</a></li>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/users"/>" target="_self">Регистрация</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


<br>
<div class="mybody">
    <div class="container">
        <div class="article container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="h2 page-header"
                        style="color:#8d1645; font-family: 'Lobster', cursive; margin-top: -1px;
                        text-align: center;">Ваши заказы</h1>
                    <section class="main">


                        <c:if test="${!empty listOrders}">
                            <table id="order_table">
                                <c:forEach items="${listOrders}" var="order">
                                    <tr>
                                        <td colspan="4">
                                            <div class="fontname" style="text-align: center;">
                                                    Заказ № ${order.id} <fmt:formatDate value="${order.date}"
                                                                                        pattern="yyyy-MM-dd HH:mm:ss"/>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td height="40" colspan="3">Адрес доставки: г. ${order.addressByAddressId.city},
                                                ${order.addressByAddressId.street}, д. ${order.addressByAddressId.house},
                                            <c:if test="${order.addressByAddressId.block ne 0}">
                                                под. ${order.addressByAddressId.block},
                                            </c:if>
                                            кв. ${order.addressByAddressId.flat}
                                        </td>
                                        <td width=15% height="40">Стоимость заказа</td>
                                    </tr>

                                    <tr>
                                        <td colspan="3">
                                            <c:if test="${!empty order.additionalInf}">
                                                Дополнительная информация: ${order.additionalInf}
                                            </c:if>
                                        </td>
                                            <%--<c:choose>
                                                <c:when test="${!empty order.additionalInf}">
                                                    <td width=60% rowspan="3">Дополнительная информация: ${order.additionalInf}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td width=60% rowspan="3"></td>
                                                </c:otherwise>
                                            </c:choose>--%>
                                        <td width=15% height="40">${order.cost} руб.</td>
                                    </tr>

                                    <tr>
                                        <td colspan="3">
                                            <c:if test="${!empty order.postcard}">
                                                Надпись на открытке: ${order.postcard}
                                            </c:if>
                                        </td>
                                        <td width=15% height="40"> Оплата: ${order.payment}</td>
                                    </tr>

                <!-- *********************** ЦВЕТЫ ***********************-->
                                    <c:if test="${!empty order.flowerOrdersById}">
                                        <tr>
                                            <td colspan="4" style="text-align: center;">
                                                    Цветы
                                            </td>
                                        </tr>

                                        <c:forEach items="${order.flowerOrdersById}" var="flowerOrder">
                                            <tr>
                                                <td width="20%">
                                                    Фото
                                                </td>
                                                <td width="52%">
                                                        ${flowerOrder.flowerByFlowerId.species}
                                                        ${flowerOrder.flowerByFlowerId.sort} <br/>
                                                    Цвет: ${flowerOrder.flowerByFlowerId.color},
                                                    Длина: ${flowerOrder.flowerByFlowerId.length}
                                                </td>
                                                <td width="13%">
                                                        ${flowerOrder.flowerByFlowerId.price} руб.<br/>
                                                        ${flowerOrder.quantity} шт.
                                                </td>
                                                <td width="15%">
                                                    Стоимость<br/>
                                                    <c:set var="price"
                                                           value="${flowerOrder.flowerByFlowerId.price}"/>
                                                    <c:set var="number" value="${flowerOrder.quantity}"/>
                                                    <c:set var="sum" value="${price*number}"/>
                                                    <c:out value="${sum}"/> руб.
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>

                <!-- *********************** БУКЕТЫ ***********************-->
                                    <c:if test="${!empty order.bouquetOrdersById}">
                                        <tr>
                                            <td colspan="4" style="text-align: center;">
                                                    Букеты
                                            </td>
                                        </tr>

                                        <c:forEach items="${order.bouquetOrdersById}" var="bouquetOrder">
                                            <tr>
                                                <td width="20%">
                                                    Фото
                                                </td>
                                                <td width="52%">
                                                        ${bouquetOrder.bouquetByBouquetId.name} <br/>
                                                    Высота: ${bouquetOrder.bouquetByBouquetId.height},
                                                    Диаметр: ${bouquetOrder.bouquetByBouquetId.diameter},
                                                    Вес: ${bouquetOrder.bouquetByBouquetId.weight} <br/>
                                                    Состав: ${bouquetOrder.bouquetByBouquetId.composition}
                                                </td>
                                                <td width="13%">
                                                        ${bouquetOrder.bouquetByBouquetId.price} руб.<br/>
                                                        ${bouquetOrder.quantity} шт.
                                                </td>
                                                <td width="15%">
                                                    Стоимость<br/>
                                                    <c:set var="price"
                                                           value="${bouquetOrder.bouquetByBouquetId.price}"/>
                                                    <c:set var="number" value="${bouquetOrder.quantity}"/>
                                                    <c:set var="sum" value="${price*number}"/>
                                                    <c:out value="${sum}"/> руб.
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>

                <!-- *********************** КОМПОЗИЦИИ ***********************-->
                                    <c:if test="${!empty order.compositionOrdersById}">
                                        <tr>
                                            <td colspan="4" style="text-align: center;">
                                                    Композиции
                                            </td>
                                        </tr>

                                        <c:forEach items="${order.compositionOrdersById}" var="compositionOrder">
                                            <tr>
                                                <td width="20%">
                                                    Фото
                                                </td>
                                                <td width="52%">
                                                        ${compositionOrder.compositionByCompositionId.name} <br/>
                                                    Состав: ${compositionOrder.compositionByCompositionId.composition}
                                                    <br/>
                                                    Упаковка: ${compositionOrder.compositionByCompositionId.pack}
                                                </td>
                                                <td width="13%">
                                                        ${compositionOrder.compositionByCompositionId.price} руб.<br/>
                                                        ${compositionOrder.quantity} шт.
                                                </td>
                                                <td width="15%">
                                                    Стоимость<br/>
                                                    <c:set var="price"
                                                           value="${compositionOrder.compositionByCompositionId.price}"/>
                                                    <c:set var="number" value="${compositionOrder.quantity}"/>
                                                    <c:set var="sum" value="${price*number}"/>
                                                    <c:out value="${sum}"/> руб.
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>

                <!-- *********************** БУКЕТЫ ПОЛЬЗОВАТЕЛЯ ***********************-->
                                    <c:if test="${!empty order.customerBouquetOrdersById}">
                                        <tr>
                                            <td colspan="4" style="text-align: center;">
                                                    Ваши букеты
                                            </td>
                                        </tr>

                                        <c:set var="i" value="0"/>
                                        <c:forEach items="${order.customerBouquetOrdersById}"
                                                   var="customerBouquetOrder">
                                            <tr>
                                                <td colspan="4" style="text-align: center;">
                                                        Букет № <c:out value="${i=i+1}"/>
                                                </td>
                                            </tr>

                                        <!-- ####################### ЦВЕТЫ В БУКЕТЕ ПОЛЬЗОВАТЕЛЯ #######################-->
                                            <c:if test="${!empty customerBouquetOrder.customerBouquetByCustomerBouquetId.flowerCustomerBouquetsById}">
                                                <c:forEach items="${customerBouquetOrder.customerBouquetByCustomerBouquetId.flowerCustomerBouquetsById}"
                                                           var="flowerCustomerBouquet">
                                                    <tr>
                                                        <td width="20%">
                                                            Фото
                                                        </td>
                                                        <td width="52%">
                                                                ${flowerCustomerBouquet.flowerByFlowerId.species}
                                                                ${flowerCustomerBouquet.flowerByFlowerId.sort} <br/>
                                                            Цвет: ${flowerCustomerBouquet.flowerByFlowerId.color},
                                                            Длина: ${flowerCustomerBouquet.flowerByFlowerId.length}
                                                        </td>
                                                        <td width="13%">
                                                                ${flowerCustomerBouquet.flowerByFlowerId.price} руб.<br/>
                                                                ${flowerCustomerBouquet.quantity} шт.
                                                        </td>
                                                        <td width="15%">
                                                            Стоимость<br/>
                                                            <c:set var="price"
                                                                   value="${flowerCustomerBouquet.flowerByFlowerId.price}"/>
                                                            <c:set var="number" value="${flowerCustomerBouquet.quantity}"/>
                                                            <c:set var="sum" value="${price*number}"/>
                                                            <c:out value="${sum}"/> руб.
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>

                                        <!-- ####################### УКРАШЕНИЯ В БУКЕТЕ ПОЛЬЗОВАТЕЛЯ #######################-->
                                            <c:if test="${!empty customerBouquetOrder.customerBouquetByCustomerBouquetId.decorationCustomerBouquetsById}">
                                                <c:forEach items="${customerBouquetOrder.customerBouquetByCustomerBouquetId.decorationCustomerBouquetsById}"
                                                           var="decorationCustomerBouquet">
                                                    <tr>
                                                        <td width="20%">
                                                            Фото
                                                        </td>
                                                        <td width="52%">
                                                                ${decorationCustomerBouquet.decorationByDecorationId.name}
                                                        </td>
                                                        <td width="13%">
                                                                ${decorationCustomerBouquet.decorationByDecorationId.price} руб.<br/>
                                                                ${decorationCustomerBouquet.quantity} шт.
                                                        </td>
                                                        <td width="15%">
                                                            Стоимость<br/>
                                                            <c:set var="price"
                                                                   value="${decorationCustomerBouquet.decorationByDecorationId.price}"/>
                                                            <c:set var="number" value="${decorationCustomerBouquet.quantity}"/>
                                                            <c:set var="sum" value="${price*number}"/>
                                                            <c:out value="${sum}"/> руб.
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>

                                            <!-- ####################### УПАКОВКА В БУКЕТЕ ПОЛЬЗОВАТЕЛЯ #######################-->
                                            <c:if test="${!empty customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId}">
                                                <tr>
                                                    <td width="20%">
                                                        Фото
                                                    </td>
                                                    <td width="52%">
                                                            ${customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId.name}
                                                    </td>
                                                    <td width="13%">
                                                            ${customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId.price} руб.
                                                    </td>
                                                    <td width="15%">
                                                        Стоимость<br/>
                                                            ${customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId.price} руб.
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                    <!--<div class="row">-->
                                    <!--<div class="col-md-6" id="getPicture">
                                    <script>
                                    var adress="/resources/images/pictures/";
                                    var img = document.createElement('img');
                                    img.setAttribute('src', adress+<%--"${flower.picture}");--%>
                                    document.getElementById("getPicture").appendChild(img);
                                    </script>
                                    </div>-->
                                    <!--<div class="col-md-4">
                                    <div class="fontname"><center>
                                    Заказ № </center>
                                    </div>
                                    <br>Цвет
                                    <br>Высота
                                    <br>Цена
                                    </div>
                                    <div class="col-md-2">
                                    <div class="fontbut">
                                    <input type="submit" class="btn btn-success"
                                    value="<spring:message text="Заказать"/>"/>
                                    </div>
                                    </div>
                                    </div>
                                    <br> <br>-->
                                </c:forEach>
                            </table>
                        </c:if>

                    </section>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="container">
            <div style="padding: 10px 0pt 0pt 30px; clear: both; color: #8d1645; font-size: 15px;">Все права защищены
                &copy; <?=date ('Y')?></div>
        </div>
    </footer>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("resources/images/fon1.jpg");
</script>

</body>
</html>

