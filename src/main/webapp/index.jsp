<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Главная страница</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/dopstyle.css" />"/>
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
                <%--<span class="sr-only">Toggle navigation</span>--%>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
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
            <div class="row">
                <div class="row otstup">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                                <!-- Indicators -->
                                <ol class="carousel-indicators">
                                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="5"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="6"></li>
                                </ol>

                                <!-- Wrapper for slides -->
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img src="resources/images/img1.jpg" alt="...">
                                        <div class="carousel-caption">
                                            <h3>Искусство есть непрестанная попытка соперничать с красотой цветов — и всегда безуспешно.</h3>
                                            <p><em>Марк Шагал</em></p>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <img src="resources/images/img3.jpg" alt="...">
                                        <div class="carousel-caption">
                                            <h3>Сколько бы мы ни говорили о пустоте жизни, иногда достаточно лишь одного цветка, чтобы нас разубедить.
                                            </h3>
                                            <p><em>Анатоль Франс</em></p>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <img src="resources/images/img7.jpg" alt="...">
                                        <div class="carousel-caption">
                                            <h3>Цветок, поворачивающийся к солнцу, видит его и за тучами.</h3>
                                            <p><em>Роберт Лейтон</em></p>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <img src="resources/images/img8.jpg" alt="...">
                                        <div class="carousel-caption">
                                            <h3>Цветы — это свободная красота в природе.</h3>
                                            <p><em>Иммануил Кант</em></p>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <img src="resources/images/img10.jpg" alt="...">
                                        <div class="carousel-caption">
                                            <h3>Никогда не надо слушать, что говорят цветы. Надо просто смотреть на них и дышать их ароматом.</h3>
                                            <p><em>Антуан де Сент-Экзюпери</em></p>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <img src="resources/images/img11.jpg" alt="...">
                                        <div class="carousel-caption">
                                            <h3>У цветов не бывает будней, они всегда одеты празднично.</h3>
                                            <p><em>Малкольм де Шазаль</em></p>
                                        </div>
                                    </div>

                                    <div class="item">
                                        <img src="resources/images/img13.jpg" alt="...">
                                        <div class="carousel-caption">
                                            <h3>О, сколько их на полях! Но каждый цветёт по-своему –
                                                вот высший подвиг цветка!</h3>
                                            <p><em>Мацуо Басё</em></p>
                                        </div>
                                    </div>

                                </div>

                                <!-- Controls -->
                                <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </a>
                                <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </a>
                            </div>
                        </div>

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
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
</body>
</html>