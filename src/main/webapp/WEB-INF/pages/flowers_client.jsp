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
    <title>Цветы</title>
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
    <link rel="stylesheet" href="<c:url value="/resources/css/modal.css" />"/>
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
                        <c:if test="${user.login ne null}">
                            <li class="divider"></li>
                            <li><a href="<c:url value="/orders_client"/>" target="_self">Мои заказы</a></li>
                        </c:if>
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
                        text-align: center;"> Цветы</h1>
                    <section class="main">


                        <c:if test="${!empty listFlowers}">

                            <c:set var="j" value="0"/>
                            <c:forEach items="${listFlowers}" var="flower">

                                <div class="row">
                                    <c:set var="nm" value="getPicture${j=j+1}"/>
                                    <div class="col-md-3" id="${nm}">
                                        <script>
                                            var adress = "/resources/images/pictures/";
                                            var img = document.createElement('img');
                                            img.setAttribute('src', adress + "${flower.picture}");
                                            img.height = 150;
                                            document.getElementById("${nm}").appendChild(img);
                                        </script>
                                    </div>
                                    <div class="col-md-7">
                                        <div class="titlegood">
                                            <b>${flower.species} ${flower.sort}</b>
                                        </div>
                                        <br>
                                        <div class="fontchar">
                                            <div class="namechar">Цвет:</div>
                                            <div class="charact">${flower.color}</div>
                                            <br>
                                            <div class="namechar">Высота:</div>
                                            <div class="charact">${flower.length} см.</div>
                                            <br>
                                            <div class="namechar">Цена:</div>
                                            <div class="charact">${flower.price}</div>
                                            <br>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <c:url var="addAction" value="/order/addFlower"/>
                                        <form:form action="${addAction}" modelAttribute="flowerOrder" class="form-horizontal">
                                            <div class="inputBlock">
                                                <div class="minus">-</div>
                                                <form:input id="input${j}" path="quantity" value="0"/>
                                                <div class="plus">+</div>
                                            </div>

                                            <div class="fontbut">
                                                <form:hidden path="flowerId" value="${flower.id}"/>

                                                <input onclick="return openModal('${flower.species} ${flower.sort}', '${flower.amount}' , 'input${j}')"
                                                       type="submit" class="btn btn-success"
                                                       value="<spring:message text="В корзину"/>"/>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                                <br> <br>
                            </c:forEach>
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

    function openModal(name, quantity, input) {
        var amount = document.getElementById(input).value;
        if (+amount > +quantity) {
            var text = document.getElementById('info');
            text.innerHTML = "Приносим свои извенения, но на данный момент в " +
                "магазине имеется только " + quantity + " единиц товара '" + name + "'";
            var a = document.createElement('a');
            a.href = "#modal";
            a.click();
            return false;
        }
        return true;
    }
</script>

<div id="modal" class="modalDialog">
    <div>
        <a href="#close" title="Закрыть" class="close">x</a>
        <h2>Оповещение</h2>
        <p></p>
        <p id="info"></p>
    </div>
</div>
</body>
</html>

