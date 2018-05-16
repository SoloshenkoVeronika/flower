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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Оформление заказа</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
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

            <div class="col-md-5">
                <form class="navbar-form navbar-left" role="search">
                    <input type="text" id="text-to-find" value="" class="form-control" placeholder="Найти">
                    <button type="submit" class="btn btn-default"
                            onclick="javascript: FindOnPage('text-to-find'); return false;">
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

                        <form:form action="${addAction}" commandName="order" class="form-horizontal">

                            <!--              ОБЩАЯ ИНФОРМАЦИЯ О ЗАКАЗЕ              -->
                            <c:if test="${user.login ne null}">
                                <form:hidden path="userId" value="${user.id}"/>
                            </c:if>

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

                            <div class="form-group">
                                <form:label path="payment" class="col-sm-4 control-label">
                                    <spring:message text="Введите вариант оплаты(наличные/банковская карта) *"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="payment" required="true" class="form-control"/>
                                </div>

                                <form:hidden path="cost" value="${order.cost}"/>
                            </div>

                            <!--              ОТПРАВИТЕЛЬ              -->
                            <div class="orderfield">Отправитель</div>
                            <div class="form-group">
                                <form:label path="senderBySenderId.secondName" class="col-sm-4 control-label">
                                    <spring:message text="Фамилия"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="senderBySenderId.secondName"  pattern="(.[a-zA-Zа-яА-ЯёЁ_-]*)" title="Используйте латинские или русские символы." class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="senderBySenderId.firstName" class="col-sm-4 control-label">
                                    <spring:message text="Имя"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="senderBySenderId.firstName" pattern="(.[a-zA-Zа-яА-ЯёЁ_-]*)" title="Используйте латинские или русские символы." class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="senderBySenderId.phone" class="col-sm-4 control-label">
                                    <spring:message text="Телефон"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="senderBySenderId.phone" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="senderBySenderId.email" class="col-sm-4 control-label">
                                    <spring:message text="e-mail"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="senderBySenderId.email"  pattern="^([a-z0-9_\.-]+)@([a-z0-9_\.-]+)\.([a-z\.]{2,6})$" title="Введите e-mail правильно. Пример 'sky@mail.ru'" class="form-control"/>
                                </div>
                            </div>


                            <!--              ПОЛУЧАТЕЛЬ              -->
                            <div class="orderfield">Получатель</div>
                            <div class="form-group">
                                <form:label path="recipientByRecipientId.secondName" class="col-sm-4 control-label">
                                    <spring:message text="Фамилия"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="recipientByRecipientId.secondName" pattern="(.[a-zA-Zа-яА-ЯёЁ_-]*)" title="Используйте латинские или русские символы." class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="recipientByRecipientId.firstName" class="col-sm-4 control-label">
                                    <spring:message text="Имя"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="recipientByRecipientId.firstName" pattern="(.[a-zA-Zа-яА-ЯёЁ_-]*)" title="Используйте латинские или русские символы." class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="recipientByRecipientId.phone" class="col-sm-4 control-label">
                                    <spring:message text="Телефон"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="recipientByRecipientId.phone" class="form-control"/>
                                </div>
                            </div>

                            <!--              АДРЕС ДОСТАВКИ              -->
                            <div class="orderfield">Адрес доставки</div>
                            <div class="form-group">
                                <form:label path="addressByAddressId.city" class="col-sm-4 control-label">
                                    <spring:message text="Город *"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="addressByAddressId.city" pattern="(.[a-zA-Zа-яА-ЯёЁ_-]*)" title="Используйте латинские или русские символы." required="true" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="addressByAddressId.street" class="col-sm-4 control-label">
                                    <spring:message text="Улица *"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="addressByAddressId.street" pattern="(.[a-zA-Zа-яА-Я\sё.Ё_-]*)" title="Используйте латинские или русские символы." required="true" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="addressByAddressId.house" class="col-sm-4 control-label">
                                    <spring:message text="Дом *"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="addressByAddressId.house" pattern="^[0-9]*$" title="Используйте целое число для ввода." required="true" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="addressByAddressId.block" class="col-sm-4 control-label">
                                    <spring:message text="Подъезд *"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="addressByAddressId.block" pattern="^[0-9]*$" title="Используйте целое число для ввода." required="true" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <form:label path="addressByAddressId.flat" class="col-sm-4 control-label">
                                    <spring:message text="Квартира *"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="addressByAddressId.flat" pattern="^[0-9]*$" title="Используйте целое число для ввода." required="true" class="form-control"/>
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
                        <p class="list-group-item list-group-item-success"><fmt:formatNumber type="number"
                                                                                             maxFractionDigits="2"
                                                                                             value="${order.cost}"/>
                            p.</p>

                    </ul>
                    <h4 class="page-header">Товары в Вашей корзине</h4>
                    <ul class="list-group">
                        <c:forEach items="${order.flowerOrdersById}" var="flowerOrder">
                            <p class="list-group-item list-group-item-success">${flowerOrder.flowerByFlowerId.species}
                                    ${flowerOrder.flowerByFlowerId.sort}, ${flowerOrder.quantity} шт</p>
                        </c:forEach>
                        <c:forEach items="${order.bouquetOrdersById}" var="bouquetOrder">
                            <p class="list-group-item list-group-item-success">
                                Букет ${bouquetOrder.bouquetByBouquetId.name},
                                    ${bouquetOrder.quantity} шт.</p>
                        </c:forEach>
                        <c:forEach items="${order.compositionOrdersById}" var="compositionOrder">
                            <p class="list-group-item list-group-item-success">
                                Композиция ${compositionOrder.compositionByCompositionId.name},
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
            <div style="padding: 10px 0pt 0pt 30px; clear: both; color: #8d1645; font-size: 15px;">Все права защищены
                &copy; <?=date ('Y')?></div>
        </div>
    </footer>
</div>
<script type="text/javascript">
    $(function () {
        $(".showpassword").each(function (index, input) {
            var $input = $(input);
            $("<p class='opt'/>").append(
                $("<input type='checkbox' class='showpasswordcheckbox' id='showPassword' />").click(function () {
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

        $('#showPassword').click(function () {
            if ($("#showPassword").is(":checked")) {
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