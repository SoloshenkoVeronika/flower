<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Главная страница</title>
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
                <li class="">
                    <a href="<c:url value="/flowers"/>" target="_self">Цветы</a>
                </li>
                <li class="">
                    <a href="<c:url value="/bouquets"/>" target="_self">Букеты</a>
                </li>
                <li class="">
                    <a href="<c:url value="/compositions"/>" target="_self">Копмозиции</a>
                </li>
                <li class="">
                    <a href="<c:url value="/packs"/>" target="_self">Упаковки</a>
                </li>
                <li class="">
                    <a href="<c:url value="/decorations"/>" target="_self">Украшения</a>
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
                <div class="col-md-8">
                    <h1 class="h2 page-header"
                        style="color:#8d1645;   font-family: 'Lobster', cursive; text-align: center;">
                        Акции</h1>


                </div>
                <div class="col-md-4">
                    <h4 class="page-header">Cupiditate non</h4>
                    <ul class="list-group">
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae
                            vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae
                            vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae
                            vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>

                    </ul>
                    <h4 class="page-header">Cupiditate non</h4>
                    <ul class="list-group">
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae
                            vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae
                            vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae
                            vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>

                    </ul>
                    <h4 class="page-header">Cupiditate non</h4>
                    <ul class="list-group">
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae
                            vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae
                            vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>
                        <a href="#" class="list-group-item list-group-item-success">Ut labore et quasi architecto beatae
                            vitae dicta sunt explicabo. Non numquam eius modi tempora incidunt, ut aliquid.</a>

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