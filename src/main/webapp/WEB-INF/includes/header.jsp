<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <script src="/assets/plugins/jquery-3.4.1.min.js"></script>
</head>
<body>
    <header>
        <a href="#" id="logo">
            <img src="http://placehold.it/150x50">
        </a>
        <nav id="gub">
            <a href="#" id="alarm">
                <img src="http://placehold.it/35x35">
                <span class="new_badge"></span>
            </a>
            <a href="#" id="msg">
                <img src="http://placehold.it/35x35">
                <span class="new_badge"></span>
            </a>

            <a href="#">
                <img src="http://placehold.it/35x35">
                <span>사용자(user01)</span>
            </a>
        </nav>
    </header>
    <%@include file="/WEB-INF/includes/left_menu.jsp"%>
</body>
</html>