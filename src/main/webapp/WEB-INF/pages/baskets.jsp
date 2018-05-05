<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05.05.2018
  Time: 14:46
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
                        <c:url var="addAction" value="/baskets/add"/>

                        <form:form action="${addAction}" commandName="basket" class="form-horizontal">
                            <%--<c:if test="${!empty basket.cost}">--%>
                                <%--<div class="form-group">--%>
                                    <%--<form:label path="id" class="col-sm-2 control-label">--%>
                                        <%--<spring:message text="ID"/>--%>
                                    <%--</form:label>--%>
                                    <%--<div class="col-sm-2">--%>
                                        <%--<form:input path="id" readonly="true" size="8" disabled="true"--%>
                                                    <%--class="form-control"/>--%>
                                        <%--<form:hidden path="id"/>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</c:if>--%>
                            <div class="orderhead">
                                <h1>Информация об отправителе</h1>
                            </div>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="Фамилия отправителя"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="Имя отправителя"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="Телефон отправителя"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="email"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <div class="orderhead">
                                <h1>Информация об получателе</h1>
                            </div>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="Фамилия получателя"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="Имя получателя"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="Телефон получателя"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <div class="orderhead">
                                <h1>Адрес доставки</h1>
                            </div>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="Город"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="Улица"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="№ Дома"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="name" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="№ Корпус"/>--%>
                                <%--</form:label>--%>
                                <%--&lt;%&ndash;<div class="col-sm-4">&ndash;%&gt;--%>
                                    <%--&lt;%&ndash;<form:input path="name" class="form-control"/>&ndash;%&gt;--%>
                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                            <%--</div>--%>
                            <%--<div class="form-group">--%>
                                <%--<form:label path="addressId.flat" class="col-sm-2 control-label">--%>
                                    <%--<spring:message text="№ Квартиры"/>--%>
                                <%--</form:label>--%>
                                <%--<div class="col-sm-4">--%>
                                    <%--<form:input path="addressId.flat" class="form-control"/>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <div class="form-group">
                                <form:label path="postcard" class="col-sm-4 control-label">
                                    <spring:message text=" Текст записки к букету (Пожелание) 50 символов"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:textarea path="postcard" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="additionalInf" class="col-sm-4 control-label">
                                    <spring:message text="Дополнительная информация (пример 'Доставка анонимна')"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:textarea path="additionalInf" class="form-control"/>
                                </div>
                            </div>
                        <div class="orderhead">
                            <h1>Способ оплаты</h1>
                        </div>
                        <div class="form-group">
                            <form:label path="payment" class="col-sm-4 control-label">
                                <spring:message text="Введите вариант оплаты(наличные/банковская карта)"/>
                            </form:label>
                            <div class="col-sm-4">
                                <form:input path="payment" class="form-control"/>
                            </div>
                        </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                        <input type="submit" class="btn btn-success"
                                               value="<spring:message text="Оформить заказ"/>"/>
                                </div>
                            </div>
                        </form:form>
                    </section>

                </div>
                <div class="col-md-4">
                    <h4 class="page-header">Сумма заказа</h4>
                    <ul class="list-group">
                        <p class="list-group-item list-group-item-success">43.21 p.</p>

                    </ul>
                    <h4 class="page-header">Товары в  Вашей корзине</h4>
                    <ul class="list-group">
                        <p class="list-group-item list-group-item-success">Роза</p>
                        <p class="list-group-item list-group-item-success">Роза</p>
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
<script type="text/javascript">
    $(function(){
        $(".showpassword").each(function(index,input) {
            var $input = $(input);
            $("<p class='opt'/>").append(
                $("<input type='checkbox' class='showpasswordcheckbox' id='showPassword' />").click(function() {
                    var change = $(this).is(":checked") ? "text" : "password";
                    var rep = $("<input placeholder='Пароль' type='" + change + "' />")
                        .attr("id", $input.attr("id"))
                        .attr("name", $input.attr("name"))
                        .attr('class', $input.attr('class'))
                        .val($input.val())
                        .insertBefore($input);
                    $input.remove();
                    $input = rep;
                })
            ).append($("<label for='showPassword'/>").text("Показать пароль")).insertAfter($input.parent());
        });

        $('#showPassword').click(function(){
            if($("#showPassword").is(":checked")) {
                $('.icon-lock').addClass('icon-unlock');
                $('.icon-unlock').removeClass('icon-lock');
            } else {
                $('.icon-unlock').addClass('icon-lock');
                $('.icon-lock').removeClass('icon-unlock');
            }
        });
    });

</script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("resources/images/fon1.jpg");
</script>
</body>
</html>