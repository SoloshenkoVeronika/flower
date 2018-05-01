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
    <title>Упаковки</title>
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

<br>
<div class="mybody">
    <div class="container">
        <div class="article container">
            <div class="row otstup">
                <div class="col-md-12">
                    <h1 class="h2 page-header"
                        style="color:#8d1645; font-family: 'Lobster', cursive; margin-top: -1px;
                        text-align: center;">Упаковки</h1>
                    <section class="main">


                        <c:if test="${!empty listPacks}">
                            <table class="tg">
                                <tr>
                                    <th width="40">ID</th>
                                    <th width="120">Название</th>
                                    <th width="80">Количество, шт</th>
                                    <th width="40">Цена, руб</th>
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
                                        <td><c:set var="nm" value="getPicture${j=j+1}"/>
                                            <div class="col-md-3" id="${nm}">
                                                <script>
                                                    var adress="/resources/images/pictures/";
                                                    var img = document.createElement('img');
                                                    img.setAttribute('src', adress+"${pack.picture}");
                                                    img.height = 150;
                                                    document.getElementById("${nm}").appendChild(img);
                                                </script>
                                            </div></td>
                                        <td><a href="<c:url value='/editPack/${pack.id}'/>">Изменить</a></td>
                                        <td><a href="<c:url value='/removePack/${pack.id}'/>">Удалить</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:if>


                        <div class="headname">
                            <h1>Форма для данных</h1>
                        </div>
                        <c:url var="addAction" value="/packs/add"/>

                        <form:form action="${addAction}" commandName="pack" class="form-horizontal">
                            <c:if test="${!empty pack.name}">
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
                                <form:label path="name" class="col-sm-2 control-label">
                                    <spring:message text="Название"/>
                                </form:label>
                                <div class="col-sm-4">
                                    <form:input path="name" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="amount" class="col-sm-2 control-label">
                                    <spring:message text="Количество"/> (шт.)
                                </form:label>
                                <div class="col-sm-2">
                                    <form:input path="amount" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:label path="price" class="col-sm-2 control-label">
                                    <spring:message text="Цена"/> (руб.)
                                </form:label>
                                <div class="col-sm-2">
                                    <form:input path="price" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <c:if test="${!empty pack.name}">
                                        <input type="submit" class="btn btn-success"
                                               value="<spring:message text="Редактировать упаковку"/>"/>
                                    </c:if>
                                    <c:if test="${empty pack.name}">
                                        <input type="submit" class="btn btn-success"
                                               value="<spring:message text="Добавить упаковку"/>"/>
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

