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
<html>
<head>
    <title>Корзина</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/button_counter.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/form.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/client.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/order.css" />"/>
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
            <a href="<c:url value="/shopping_cart"/>" target="_self">
                <div class="col-md-1">
                    <div class="backet">
                        <i class="fa fa-cart-plus" aria-hidden="true"></i>
                        Корзина
                    </div>
                </div>
            </a>
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


<br>
<div class="mybody">
    <div class="container">
        <div class="article container">
            <div class="row otstup">
                <div class="col-md-12">
                    <h1 class="h2 page-header"
                        style="color:#8d1645; font-family: 'Lobster', cursive; margin-top: -1px;
                        text-align: center;">Корзина покупок</h1>
                    <section class="main">
                        <c:choose>
                            <c:when test="${isEmpty eq true}">
                                <div class="empty">Ваша корзина пуста</div>
                            </c:when>
                            <c:otherwise>
                                <c:set var="totalCost" value="0"/>
                                <c:set var="j" value="0"/>
                                <!-- *********************** ЦВЕТЫ ***********************-->
                                <c:if test="${!empty order.flowerOrdersById}">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="product_text">
                                                Цветы
                                            </div>
                                        </div>
                                    </div>

                                    <c:forEach items="${order.flowerOrdersById}" var="flowerOrder">
                                        <div class="row">
                                            <div class="cell">
                                                <div class="col-md-3">
                                                    <div class="picture">
                                                        <c:set var="nm" value="getPicture${j=j+1}"/>
                                                        <div class="col-md-6" id="${nm}">
                                                            <script>
                                                                var adress = "/resources/images/pictures/";
                                                                var img = document.createElement('img');
                                                                img.setAttribute('src', adress + "${flowerOrder.flowerByFlowerId.picture}");
                                                                img.height = 150;
                                                                document.getElementById("${nm}").appendChild(img);
                                                            </script>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="product_info">
                                                        <div class="product_name">
                                                                ${flowerOrder.flowerByFlowerId.species}
                                                                ${flowerOrder.flowerByFlowerId.sort}
                                                        </div>
                                                        Цвет: ${flowerOrder.flowerByFlowerId.color},
                                                        Длина: ${flowerOrder.flowerByFlowerId.length}
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="price">
                                                            ${flowerOrder.flowerByFlowerId.price} руб.<br/>
                                                            ${flowerOrder.quantity} шт.
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="center">
                                                        Стоимость<br/>
                                                        <c:set var="price"
                                                               value="${flowerOrder.flowerByFlowerId.price}"/>
                                                        <c:set var="number" value="${flowerOrder.quantity}"/>
                                                        <c:set var="sum" value="${price*number}"/>
                                                        <div class="cost"><c:out value="${sum}"/> руб.</div>
                                                        <c:set var="total" value="${totalCost = totalCost + sum}"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>

                                <!-- *********************** БУКЕТЫ ***********************-->
                                <c:if test="${!empty order.bouquetOrdersById}">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="product_text">
                                                Букеты
                                            </div>
                                        </div>
                                    </div>

                                    <c:forEach items="${order.bouquetOrdersById}" var="bouquetOrder">
                                        <div class="row">
                                            <div class="cell">
                                                <div class="col-md-3">
                                                    <c:set var="nm" value="getPicture${j=j+1}"/>
                                                    <div class="col-md-6" id="${nm}">
                                                        <script>
                                                            var adress = "/resources/images/pictures/";
                                                            var img = document.createElement('img');
                                                            img.setAttribute('src', adress + "${bouquetOrder.bouquetByBouquetId.picture}");
                                                            img.height = 150;
                                                            document.getElementById("${nm}").appendChild(img);
                                                        </script>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="product_info">
                                                        <div class="product_name">
                                                                ${bouquetOrder.bouquetByBouquetId.name}
                                                        </div>
                                                        Высота: ${bouquetOrder.bouquetByBouquetId.height},
                                                        Диаметр: ${bouquetOrder.bouquetByBouquetId.diameter},
                                                        Вес: ${bouquetOrder.bouquetByBouquetId.weight} <br/>
                                                        Состав: ${bouquetOrder.bouquetByBouquetId.composition}
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="price">
                                                            ${bouquetOrder.bouquetByBouquetId.price} руб.<br/>
                                                            ${bouquetOrder.quantity} шт.
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="center">
                                                        Стоимость<br/>
                                                        <c:set var="price"
                                                               value="${bouquetOrder.bouquetByBouquetId.price}"/>
                                                        <c:set var="number" value="${bouquetOrder.quantity}"/>
                                                        <c:set var="sum" value="${price*number}"/>
                                                        <div class="cost"><c:out value="${sum}"/> руб.</div>
                                                        <c:set var="total" value="${totalCost = totalCost + sum}"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>

                                <!-- *********************** КОМПОЗИЦИИ ***********************-->
                                <c:if test="${!empty order.compositionOrdersById}">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="product_text">
                                                Композиции
                                            </div>
                                        </div>
                                    </div>

                                    <c:forEach items="${order.compositionOrdersById}" var="compositionOrder">
                                        <div class="row">
                                            <div class="cell">
                                                <div class="col-md-3">
                                                    <c:set var="nm" value="getPicture${j=j+1}"/>
                                                    <div class="col-md-6" id="${nm}">
                                                        <script>
                                                            var adress = "/resources/images/pictures/";
                                                            var img = document.createElement('img');
                                                            img.setAttribute('src', adress + "${compositionOrder.compositionByCompositionId.picture}");
                                                            img.height = 150;
                                                            document.getElementById("${nm}").appendChild(img);
                                                        </script>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="product_info">
                                                        <div class="product_name">
                                                                ${compositionOrder.compositionByCompositionId.name}
                                                        </div>
                                                        Состав: ${compositionOrder.compositionByCompositionId.composition}
                                                        <br/>
                                                        Упаковка: ${compositionOrder.compositionByCompositionId.pack}
                                                    </div>
                                                </div>

                                                <div class="col-md-1">
                                                    <div class="price">
                                                            ${compositionOrder.compositionByCompositionId.price} руб.<br/>
                                                            ${compositionOrder.quantity} шт.
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="center">
                                                        Стоимость<br/>
                                                        <c:set var="price"
                                                               value="${compositionOrder.compositionByCompositionId.price}"/>
                                                        <c:set var="number" value="${compositionOrder.quantity}"/>
                                                        <c:set var="sum" value="${price*number}"/>
                                                        <div class="cost"><c:out value="${sum}"/> руб.</div>
                                                        <c:set var="total" value="${totalCost = totalCost + sum}"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>

                                <!-- *********************** БУКЕТЫ ПОЛЬЗОВАТЕЛЯ ***********************-->
                                <c:if test="${!empty order.customerBouquetOrdersById}">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="product_text">
                                                Ваши букеты
                                            </div>
                                        </div>
                                    </div>

                                    <c:set var="i" value="0"/>
                                    <c:forEach items="${order.customerBouquetOrdersById}"
                                               var="customerBouquetOrder">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="product_text">
                                                    Букет № <c:out value="${i=i+1}"/>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- ####################### ЦВЕТЫ В БУКЕТЕ ПОЛЬЗОВАТЕЛЯ #######################-->
                                        <c:if test="${!empty customerBouquetOrder.customerBouquetByCustomerBouquetId.flowerCustomerBouquetsById}">
                                            <c:forEach
                                                    items="${customerBouquetOrder.customerBouquetByCustomerBouquetId.flowerCustomerBouquetsById}"
                                                    var="flowerCustomerBouquet">
                                                <div class="row">
                                                    <div class="cell">
                                                        <div class="col-md-3">
                                                            <c:set var="nm" value="getPicture${j=j+1}"/>
                                                            <div class="col-md-6" id="${nm}">
                                                                <script>
                                                                    var adress = "/resources/images/pictures/";
                                                                    var img = document.createElement('img');
                                                                    img.setAttribute('src', adress + "${flowerCustomerBouquet.flowerByFlowerId.picture}");
                                                                    img.height = 150;
                                                                    document.getElementById("${nm}").appendChild(img);
                                                                </script>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="product_info">
                                                                <div class="product_name">
                                                                        ${flowerCustomerBouquet.flowerByFlowerId.species}
                                                                        ${flowerCustomerBouquet.flowerByFlowerId.sort}
                                                                </div>
                                                                Цвет: ${flowerCustomerBouquet.flowerByFlowerId.color},
                                                                Длина: ${flowerCustomerBouquet.flowerByFlowerId.length}
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="price">
                                                                    ${flowerCustomerBouquet.flowerByFlowerId.price} руб.<br/>
                                                                    ${flowerCustomerBouquet.quantity} шт.
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="center">
                                                                Стоимость<br/>
                                                                <c:set var="price"
                                                                       value="${flowerCustomerBouquet.flowerByFlowerId.price}"/>
                                                                <c:set var="number"
                                                                       value="${flowerCustomerBouquet.quantity}"/>
                                                                <c:set var="sum" value="${price*number}"/>
                                                                <div class="cost"><c:out value="${sum}"/> руб.</div>
                                                                <c:set var="total" value="${totalCost = totalCost + sum}"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>

                                        <!-- ####################### УКРАШЕНИЯ В БУКЕТЕ ПОЛЬЗОВАТЕЛЯ #######################-->
                                        <c:if test="${!empty customerBouquetOrder.customerBouquetByCustomerBouquetId.decorationCustomerBouquetsById}">
                                            <c:forEach
                                                    items="${customerBouquetOrder.customerBouquetByCustomerBouquetId.decorationCustomerBouquetsById}"
                                                    var="decorationCustomerBouquet">
                                                <div class="row">
                                                    <div class="cell">
                                                        <div class="col-md-3">
                                                            <c:set var="nm" value="getPicture${j=j+1}"/>
                                                            <div class="col-md-6" id="${nm}">
                                                                <script>
                                                                    var adress = "/resources/images/pictures/";
                                                                    var img = document.createElement('img');
                                                                    img.setAttribute('src', adress + "${decorationCustomerBouquet.decorationByDecorationId.picture}");
                                                                    img.height = 150;
                                                                    document.getElementById("${nm}").appendChild(img);
                                                                </script>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6">
                                                            <div class="product_info">
                                                                <div class="product_name">
                                                                        ${decorationCustomerBouquet.decorationByDecorationId.name}
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-1">
                                                            <div class="price">
                                                                    ${decorationCustomerBouquet.decorationByDecorationId.price}
                                                                руб.<br/>
                                                                    ${decorationCustomerBouquet.quantity} шт.
                                                            </div>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <div class="center">
                                                                Стоимость<br/>
                                                                <c:set var="price"
                                                                       value="${decorationCustomerBouquet.decorationByDecorationId.price}"/>
                                                                <c:set var="number"
                                                                       value="${decorationCustomerBouquet.quantity}"/>
                                                                <c:set var="sum" value="${price*number}"/>
                                                                <div class="cost"><c:out value="${sum}"/> руб.</div>
                                                                <c:set var="total" value="${totalCost = totalCost + sum}"/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                        </c:if>

                                        <!-- ####################### УПАКОВКА В БУКЕТЕ ПОЛЬЗОВАТЕЛЯ #######################-->
                                        <c:if test="${!empty customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId}">
                                            <div class="row">
                                                <div class="cell">
                                                    <div class="col-md-3">
                                                        <c:set var="nm" value="getPicture${j=j+1}"/>
                                                        <div class="col-md-6" id="${nm}">
                                                            <script>
                                                                var adress = "/resources/images/pictures/";
                                                                var img = document.createElement('img');
                                                                img.setAttribute('src', adress + "${customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId.picture}");
                                                                img.height = 150;
                                                                document.getElementById("${nm}").appendChild(img);
                                                            </script>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <div class="product_info">
                                                            <div class="product_name">
                                                                    ${customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId.name}
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <div class="price">
                                                                ${customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId.price}
                                                            руб.
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="center">
                                                            Стоимость<br/>
                                                            <div class="cost">
                                                                    ${customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId.price}
                                                                руб.
                                                            </div>
                                                            <c:set var="total" value="${totalCost = totalCost +
                                                                customerBouquetOrder.customerBouquetByCustomerBouquetId.packByPackId.price}"/>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="product_text">
                                            Общая стоимость: <c:out value="${totalCost}"/> руб.
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <a href="/baskets">Перейти к оформлению заказа</a>
                                </div>
                            </c:otherwise>
                        </c:choose>
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