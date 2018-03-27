<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.03.2018
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Украшение</title>
    <link rel="stylesheet" type="text/css" href="css/autor_style.css"/>
    <script src="js/modernizr.custom.63321.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/menu_style.css"/>
    <%--<link rel="stylesheet" href="css/table.css" />--%>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
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
                    <a href="<c:url value="/flowers"/>" target="_blank">Цветы<span class="caret"></span></a>
                    <%--<ul class="dropdown-menu" role="menu">--%>
                    <%--<li><a href="<c:url value="/flowers"/>" target="_blank">Просмотреть</a></li>--%>
                    <%--<li><a href="#">Добавить</a></li>--%>
                    <%--<li><a href="#">Удалить</a></li>--%>
                    <%--<li><a href="#">Редактировать</a></li>--%>
                    <%--</ul>--%>
                </li>
                <li class="">
                    <a href="<c:url value="/bouquets"/>" target="_blank">Букеты</a>
                </li>
                <li class="">
                    <a href="<c:url value="/compositions"/>" target="_blank">Копмозиции</a>
                </li>
                <li class="">
                    <a href="<c:url value="/packs"/>" target="_blank">Упаковки</a>
                </li>
                <li class="">
                    <a href="<c:url value="/decorations"/>" target="_blank">Украшения</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Мой
                        профиль<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="divider"></li>
                        <li><a href="<c:url value="/autorization"/>" target="_blank">Вход</a></li>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/users"/>" target="_blank">Регистрация</a></li>
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
                        style="color:#8d1645;   font-family: 'Lobster', cursive; text-align: center;">Украшение</h1>
                    <section class="main">


                        <c:if test="${!empty listPacks}">
                            <table class="tg">
                                <tr>
                                    <th width="40">ID</th>
                                    <th width="120">Название</th>
                                    <th width="80">Количество</th>
                                    <th width="40">Цена</th>
                                    <th width="120">Изображение</th>
                                    <th width="60">Редактирование</th>
                                    <th width="60">Удаление</th>
                                </tr>
                                <c:forEach items="${listPacks}" var="pack">
                                    <tr>
                                        <td>${pack.id}</td>
                                        <td>${pack.name}</td>
                                        <td>${pack.amount}</td>
                                        <td>${pack.price}</td>
                                        <td>${pack.picture}</td>
                                        <td><a href="<c:url value='/editpack/${pack.id}'/>">Редактирование</a></td>
                                        <td><a href="<c:url value='/removepack/${pack.id}'/>">Удаление</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>


                        <h1>Форма для данных</h1>

                        <c:url var="addAction" value="/packs/add"/>

                        <form:form action="${addAction}" commandName="pack">
                            <table>
                                <c:if test="${!empty pack.name}">
                                    <tr>
                                        <td>
                                            <form:label path="id">
                                                <spring:message text="ID"/>
                                            </form:label>
                                        </td>
                                        <td>
                                            <form:input path="id" readonly="true" size="8" disabled="true"/>
                                            <form:hidden path="id"/>
                                        </td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td>
                                        <form:label path="name">
                                            <spring:message text="Название"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="name"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="amount">
                                            <spring:message text="Количество"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="amount"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <form:label path="price">
                                            <spring:message text="Цена"/>
                                        </form:label>
                                    </td>
                                    <td>
                                        <form:input path="price"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <c:if test="${!empty pack.name}">
                                            <input type="submit"
                                                   value="<spring:message text="Редактировать украшение"/>"/>
                                        </c:if>
                                        <c:if test="${empty pack.name}">
                                            <input type="submit"
                                                   value="<spring:message text="Добавить украшение"/>"/>
                                        </c:if>
                                    </td>
                                </tr>
                            </table>
                        </form:form>


                    </section>


                </div>

            </div>
        </div>
    </div>

    <footer>
        <div class="container">
            Consequatur, vel illum, qui in culpa, qui dolorem.
        </div>
    </footer>
</div>
<script src="js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("images/fon1.jpg");
</script>

</body>
</html>

