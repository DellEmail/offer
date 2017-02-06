<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
    <style>
        <#include "xcss.css">
    </style>
</head>
<body>
<h1>Tere tulemast pakkumise kodulehele</h1>
<nav role="navigation">
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Log in</a></li>
    </#if>
    <#if currentUser??>
        <li>
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <!--li><a href="/user/${currentUser.id}">View myself</a></li-->
    </#if>
    <#if currentUser??>
        <li><a href="/offer/create">Loo uus pakkumine</a></li>
        <li><a href="/offers">Vaata pakkumisi</a></li>
    </#if>
    </ul>
</nav>
</body>
</html>