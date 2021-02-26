<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="barter.service.ViewService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="parakeet" uri="/META-INF/tags/parakeet.tld"%>
<%
    ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    ViewService viewService = (ViewService) context.getBean("viewService");
%>
<html>
<head>

    <title><%=viewService.getShopName()%>: <decorator:title default="The Goal to Remove Barriers"/></title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" type="image/png" href="/shop/assets/media/icon.png?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="/shop/assets/css/packages/grid.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="/shop/assets/css/base.css?v=<%=System.currentTimeMillis()%>">
    <link rel="stylesheet" href="/shop/assets/css/app.css?v=<%=System.currentTimeMillis()%>">

    <script type="text/javascript" src="/z/assets/js/packages/jquery.js"></script>

</head>
<body>

<div class="container">

    <div class="row">

        <div class="col-sm-12">

            <div id="guest-content">
                <decorator:body />
            </div>

            <div id="footer-navigation">
                <%if(!request.getServletPath().equals("/home")){%>
                    <a href="/z/home" class="href-dotted">Home</a>
                <%}%>

                <%if(!request.getServletPath().equals("/about")){%>
                    &nbsp;<a href="/z/about" class="href-dotted">About</a>
                <%}%>

                <%if(!request.getServletPath().equals("/cost")){%>
                &nbsp;<a href="/z/cost" class="href-dotted">Cost</a>
                <%}%>

                <%if(!request.getServletPath().equals("/developers")){%>
                &nbsp;<a href="/z/developers" class="href-dotted">Developers</a>
                <%}%>


                <parakeet:isAuthenticated>
                    &nbsp;<strong class="highlight" style="font-family: roboto-slab-semibold !important">Signed in <a href="/z/" class="href-dotted">My Profile</a></strong>&nbsp;
                </parakeet:isAuthenticated>
                <parakeet:isAnonymous>
                    &nbsp;<a href="/z/signin" class="href-dotted">Signin</a>&nbsp;
                </parakeet:isAnonymous>

            </div>

            <div id="footer-wrapper">
                <p class="center"><a href="mailto:mail@dynamicsgain.org" class="href-dotted-black">mail@dynamicsgain.org</a></p>
                <span class="regular">&copy; 2021 <br/>Dynamics<br/> <strong class="gain">+Gain</strong></span>
            </div>

            <style>
                #guest-content{
                    margin-top:30px;
                }
                #footer-navigation{
                    text-align:center;
                    margin-top:70px;
                }
                #footer-wrapper{
                    margin:103px auto 200px;
                    text-align: center;
                }

            </style>

        </div>

    </div>
</div>

<script async src="https://www.googletagmanager.com/gtag/js?id=G-EF5QWVVWFK"></script>
<script>
    window.dataLayer = window.dataLayer || [];
    function gtag(){dataLayer.push(arguments);}
    gtag('js', new Date());

    gtag('config', 'G-EF5QWVVWFK');
</script>

</body>
</html>