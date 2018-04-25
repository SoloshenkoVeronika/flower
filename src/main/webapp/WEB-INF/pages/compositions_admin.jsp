<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26.03.2018
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Композиции</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/form.css" />"/>
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
                    <a href="<c:url value="/flowers_admin"/>" target="_self">Цветы</a>
                </li>
                <li class="">
                    <a href="<c:url value="/bouquets_admin"/>" target="_self">Букеты</a>
                </li>
                <li class="">
                    <a href="<c:url value="/compositions_admin"/>" target="_self">Копмозиции</a>
                </li>
                <li class="">
                    <a href="<c:url value="/packs_admin"/>" target="_self">Упаковки</a>
                </li>
                <li class="">
                    <a href="<c:url value="/decorations_admin"/>" target="_self">Украшения</a>
                </li>
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

<br><br><br><br><br>
<div class="mybody">
    <div class="container">
        <div class="article container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="h2 page-header"
                        style="color:#8d1645;   font-family: 'Lobster', cursive; text-align: center;">Композиции</h1>
                    <section class="main">


                        <c:if test="${!empty listCompositions}">
                            <table class="tg">
                                <tr>
                                    <th width="40">ID</th>
                                    <th width="120">Название</th>
                                    <th width="170">Состав</th>
                                    <th width="40">Упаковка</th>
                                    <th width="80">Количество</th>
                                    <th width="40">Цена</th>
                                    <th width="120">Изображение</th>
                                    <th width="60">Редактирование</th>
                                    <th width="60">Удаление</th>
                                </tr>
                                <c:forEach items="${listCompositions}" var="composition">
                                    <tr>
                                        <td>${composition.id}</td>
                                        <td>${composition.name}</td>
                                        <td>${composition.composition}</td>
                                        <td>${composition.pack}</td>
                                        <td>${composition.amount}</td>
                                        <td>${composition.price}</td>
                                        <td>${composition.picture}</td>
                                        <td><a href="<c:url value='/editComposition/${composition.id}'/>">Редактирование</a>
                                        </td>
                                        <td><a href="<c:url value='/removeComposition/${composition.id}'/>">Удаление</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>

                        <div class="headname">
                            <h1>Форма для данных</h1>
                        </div>
                        <c:url var="addAction" value="/compositions/add"/>

                        <form:form action="${addAction}" commandName="composition" class="form-horizontal">

                            <c:if test="${!empty composition.name}">
                                <div class="form-group">
                                    <form:label path="id" class="col-sm-2 control-label">
                                        <spring:message text="ID"/>
                                    </form:label>
                                    <div class="col-sm-2">
                                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                                        <form:hidden path="id" class="form-control"/>
                                    </div>
                                </div>
                            </c:if>

                            <div class="form-group">
                                <form:label path="name" class="col-sm-2 control-label">
                                    <spring:message text="Название"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="name" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="composition" class="col-sm-2 control-label">
                                    <spring:message text="Состав"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="composition" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="pack" class="col-sm-2 control-label">
                                    <spring:message text="Упаковка"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="pack" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="amount" class="col-sm-2 control-label">
                                    <spring:message text="Количество"/>
                                </form:label>
                                <div class="col-sm-2">
                                    <form:input path="amount" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="price" class="col-sm-2 control-label">
                                    <spring:message text="Цена"/>
                                </form:label>
                                <div class="col-sm-2">

                                    <form:input path="price" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <c:if test="${!empty composition.name}">
                                        <input type="submit" class="btn btn-success"
                                               value="<spring:message text="Редактировать композицию"/>"/>
                                    </c:if>
                                    <c:if test="${empty composition.name}">
                                        <input type="submit" class="btn btn-success"
                                               value="<spring:message text="Добавить композицию"/>"/>
                                    </c:if>
                                </div>
                            </div>

                        </form:form>


                    </section>


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
