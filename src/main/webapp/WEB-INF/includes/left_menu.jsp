<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/left_menu.css">
</head>
<body>
    <nav id="left_nav">
        <ul id="left_menu">
            <li class="current">
                <a href="/summary">
                    <img src="http://placehold.it/25x25">
                    <span>Summary</span>
                </a>
            </li>
            <li>
                <a href="/manage">
                    <img src="http://placehold.it/25x25">
                    <span>Manage</span>
                </a>
            </li>
            <ul class="sub">
                <li>
                    <a href="/manage/category">Category</a>
                </li>
            </ul>
        </ul>
    </nav>
</body>
</html>