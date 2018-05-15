<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 01.05.2018
  Time: 15:44
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
    <title>Составь букет сам</title>
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
                    <a href="<c:url value="/customer_bouquets_flower"/>" target="_self">Цветы</a>
                </li>
                <li class="">
                    <a href="<c:url value="/customer_bouquets_decoration"/>" target="_self">Украшения</a>
                </li>
                <li class="">
                    <a href="<c:url value="/customer_bouquets_pack"/>" target="_self">Упаковка</a>
                </li>
                <li class="">
                    <c:choose>
                        <c:when test="${isCustomerBouquetEmpty eq true}">
                            <a href="<c:url value="/customer_bouquets"/>" target="_self">
                                Составить букет
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value="/customer_bouquets/complete"/>" target="_self">
                                Завершить создание букета
                            </a>
                        </c:otherwise>
                    </c:choose>
                </li>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="<c:url value="/users/currentUser"/>" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-expanded="false">
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
                        text-align: center;"> Секреты создания оригинального букета</h1>
                    <section class="main">
                        <p class="advice">
                            Цветы — всегда желанный подарок. И не имеет значения — большой букет или маленький. Главное,
                            чтобы он был составлен со вкусом! Конечно, лучше всего, если цветы в подарок подберет
                            флорист — он никогда не ошибется, но и самостоятельно можно сложить оригинальный букет. Вот
                             несколько простых, но эффектных советов.</p>

                         <div class="listtt">Радуга</div>
                        <p class="advice">Тюльпаны — настоящие цветы весны. Несомненно, из них можно сложить грандиозный букет. А можно
                            сделать простой, домашний: выбрать пять красивых тюльпанчиков разных цветов. И — вуаля —
                            готово! Примечательно, что такой букет можно ничем не обрамлять, он и без того достаточно
                            красочен.</p>
   <div class="listtt">Ленточка</div>
                            <p class="advice">Любой простенький букет станет краше, если перевязать цветы красивой шелковой ленточкой.
                                Такой домашний дизайн наверняка придется по душе любителям простоты.</p>
                        <div class="listtt"> Красота в деталях</div>
                        <p class="advice">Аксессуары для букета сегодня — по-прежнему популярны. Небольшое сердечко на палочке,
                            бусинки, божья коровка, ползущая по листочку — все это может добавить нежности. Эти советы
                            касаются и букетов на свадьбу от гостей, для них актуальны аксессуары белого цвета. Главное
                            — знать меру!</p>
                        <div class="listtt"> Актуальная упаковка для букета</div>
                            <p class="advice"> Шуршащий целлофан остался в прошлом! Оборачивать современные букеты лучше в ткань или
                                мягкую бумагу.</p>
                        <div class="listtt"> Простота или совет</div>

                            <p class="advice"> Если составляете букет самостоятельно — лучше выбрать несколько цветков одинакового
                                вида. Если хотите разнообразия — не ошибетесь, если заглянете на огонек в цветочный
                                магазин, например, можно заодно купить цветы мелким оптом и попросить о помощи
                                специалиста, которому известны все секреты букетов.</p>


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