<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script  src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />" />
</head>
<body>
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
            <div class="col-md-1">
                <div class="backet">
                    <i class="fa fa-cart-plus" aria-hidden="true"></i>
                    Корзина
                </div>
            </div>
        </div>
    </div>
</div>

<!-- ///////////////////////////////////////////////// -->
<nav class="navbar navbar-default ">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="#">Цветы <span class="sr-only">(current)</span></a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Букеты<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Подпункт 1.1</a></li>
                        <li><a href="#">Подпункт 1.2</a></li>
                        <li><a href="#">Подпункт 1.3</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Подпункт 1.4</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Подпункт 1.5</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Композиции<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Подпункт 1.1</a></li>
                        <li><a href="#">Подпункт 1.2</a></li>
                        <li><a href="#">Подпункт 1.3</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Подпункт 1.4</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Подпункт 1.5</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Подарки<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Розы</a></li>
                        <li><a href="#">Хризантемы</a></li>
                        <li><a href="#">Подпункт 1.3</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Подпункт 1.4</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Подпункт 1.5</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Мой профиль<span class="caret"></span></a>
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
<%--//////////////////////////////////////////////////////////////////////////--%>






<br><br><br><br><br>
<div class="mybody">
    <div class="container">
        <div class="article container">
            <div class="row">
                <div class="col-md-8">
                    <h1 class="h2 page-header"
                        style="color:#8d1645;   font-family: 'Lobster', cursive; text-align: center;">
                        Добро пожаловать на страницу регистрации</h1>
                    <section class="main">
                            <c:url var="addAction" value="/users/add"/>

                            <form:form action="${addAction}" commandName="user" class="form-2">
                                <table>
                                    <c:if test="${!empty user.login}">
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
                                            <p class="field">
                                            <form:label for="login" path="login">
                                                <spring:message text="Логин"/>
                                            </form:label>
                                            <form:input path="login" type="text" name="login" placeholder="Логин или email" />
                                            <i class="icon-user icon-large"></i>

                                        </p>
                                    </tr>

                                    <tr>
                                        <p class="field">
                                            <form:label for="password" path="password">
                                                <spring:message text="Пароль"/>
                                            </form:label>
                                            <form:input path="password" type="password" name="password" placeholder="Пароль" />
                                            <i class="icon-lock icon-large"></i>
                                        </p>
                                    </tr>

                                    <tr>
                                            <p class="field">
                                            <form:label for="password" path="status">
                                                <spring:message text="Пароль"/>
                                            </form:label>
                                            <form:input path="status" type="password" name="password" placeholder="Подтверждения пароля" class="showpassword"/>
                                                <i class="icon-lock icon-large"></i>
                                            </p>
                                    </tr>


                                    <tr>
                                        <c:if test="${empty user.login}">
                                            <button type="submit" name="submit"
                                                    value="<spring:message text="Add User"/>">
                                                <i class="icon-arrow-right"></i>
                                                <span>Регистрация</span>
                                            </button>
                                        </c:if>

                                    </tr>
                                </table>
                            </form:form>


                    </section>

                </div>
                <div class="col-md-4">
                    <h4 class="page-header">Cupiditate non</h4>
                    <ul class="list-group">
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>

                    </ul>
                    <h4 class="page-header">Cupiditate non</h4>
                    <ul class="list-group">
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>

                    </ul>
                    <h4 class="page-header">Cupiditate non</h4>
                    <ul class="list-group">
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>

                    </ul>




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