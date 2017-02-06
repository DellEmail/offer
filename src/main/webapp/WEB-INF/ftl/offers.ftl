<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Offers</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/offer/create">Create a new offer</a></li>
    </ul>
</nav>

<h1>List of Offers</h1>

<table>
    <thead>
    <tr>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <#list offers as offer>
    <tr>
        <td><a href="/offer/${offer.offerid}">${offer.price}</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>