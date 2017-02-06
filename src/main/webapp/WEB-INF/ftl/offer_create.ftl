<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Loo pakkumine</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Loo uus pakkumine</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div>
        <label for="price">Sõiduki hind</label>
        <input type="price" name="price" id="price" value="${form.price}" required autofocus/>
    </div>
    <button type="submit">Save</button>
</form>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>
</body>
</html>