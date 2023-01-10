<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/static/css/1.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <img src="https://www.google.com/images/branding/googleg/1x/googleg_standard_color_128dp.png">
    <img src="/static/images/hp.jpg">

    <p>Hello, ${name} name!</p>

    <table border="5">
        <thead>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        </thead>
        <tbody>

        <#list her as line>
        <tr>
            <td>${line.id}</td>
            <td>${line.name}</td>
            <td>${line.price}</td>
        </tr>
        </#list>
        </tbody>
    </table>

<#--    <table border="2">-->
<#--        <thead>-->
<#--            <td>Id</td>-->
<#--            <td>Name</td>-->
<#--            <td>Price, USD</td>-->
<#--        </thead>-->
<#--        <tbody>-->
<#--        <#list her as line>-->
<#--            <tr>-->
<#--                <td>${line.id}</td>-->
<#--                <td>${line.name}</td>-->
<#--                <td>$${line.price}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--        </tbody>-->
<#--    </table>-->
</body>
</html>