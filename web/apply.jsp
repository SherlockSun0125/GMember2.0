<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chong
  Date: 2018/4/25
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>项目申请</title>
    <meta name="viewport" content="width=100%; initial-scale=1; maximum-scale=1; minimum-scale=1; user-scalable=no;"/>
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/images/apple-touch-icon-144-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/images/apple-touch-icon-114-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/images/apple-touch-icon-72-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/images/apple-touch-icon-57-precomposed.png"/>
    <link href="${pageContext.request.contextPath}/css/bootstrap-2.min.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/prettyPhoto.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/font-icomoon.css" type="text/css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.quicksand.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/superfish.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hoverIntent.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jflickrfeed.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.elastislide.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.tweet.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/smoothscroll.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ui.totop.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajax-mail.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <style>
        tr {
            height: 30px;
            /*background-color: red;*/
            margin: 0 5px;
        }
        .td1 {
            text-align: right;
            padding-right: 2em;
            width: 8em;
            /*background-color: red;*/
        }
        .td2 {
            height: 50px;
        }
        .td2 > .input-text {
            height: 30px;
            width: 250px;
            border-radius: 20px;
        }
        #stugrade,#studepid {
            width: 250px;
        }
        #stugrade {
            width: 250px;
        }
        em{
            font-weight: bold;
            color: #cc3333;
            padding-right: 5px;
            vertical-align: middle;
        }
    </style>
    <script>
        function checkForm() {
            if(!$("#stunum").val()){
                alert("学号不能为空！");
                return false;
            }
            if(!$("#stuname").val()){
                alert("姓名不能为空！");
                return false;
            }
            if(!$("#stuage").val()){
                alert("年龄不能为空！");
                return false;
            }
            if(!$("#stumail").val()){
                alert("邮箱不能为空！");
                return false;
            }

            if(!$("#stuphone").val()){
                alert("手机号不能为空！");
                return false;
            }
            if(!$("#depid").val()){
                alert("院系不能为空！");
                return false;
            }
            if(!$("#stuenglish").val()){
                alert("英语水平不能为空！");
                return false;
            }
            if(!$("#stugrade").val()){
                alert("成绩排名不能为空！");
                return false;
            }
            if(!$("#stumajor").val()){
                alert("成绩排名不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<!--头部-->
<header id="header">
    <div class="container" style="margin-bottom: 2px">
        <div class="row header-top" style="margin-left:5px;margin-bottom:0px;">
            <div class="span5 logo" style="width: 100%;margin-left:10px">
                <a class="logo-img" href="home.jsp" title="responsive template" style="margin-bottom: 5px"><img
                        src="${pageContext.request.contextPath}/images/myimg/hitwh_logo_blue.png" alt="哈工大威海校徽"/></a>
            </div>
        </div>
        <div class="row header-nav">
            <div class="span12">
                <nav id="menu" class="clearfix">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/home.jsp"><span class="name">主页</span></a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/newsServlet?method=findAllNews"><span class="name">新闻中心</span></a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/noticeServlet?method=findAllNotices"><span class="name">通知公告</span></a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/enterprise.jsp"><span class="name">合作企业</span></a>
                        </li>
                        <li class="current"><a><span class="name">用户中心</span></a>
                            <ul>
                                <li><a href="${pageContext.request.contextPath}/studentLogin.jsp"  target="_blank">学生用户登录</a></li>
                                <li><a href="${pageContext.request.contextPath}/teacherLogin.jsp" target="_blank">教师用户登录</a></li>
                                <li><a href="${pageContext.request.contextPath}/employeeLogin.jsp" target="_blank">企业用户登录</a></li>
                            </ul>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/about1.jsp"><span class="name">计划介绍</span></a></li>
                    </ul>
                </nav>
                <form class="top-search pull-right">
                    <input type="text" placeholder="站内搜索..." class="span3">
                    <button type="button" class="btn"><i class="icon-search-form"></i></button>
                </form>
            </div>
        </div>
    </div>
</header>

<!--container-->
<section id="container">
    <div class="container">
        <div class="row" style="padding-left: 80px;text-align: center">
            <form class="form-actions" style="text-align: center" onsubmit="return checkForm()" action="${pageContext.request.contextPath}/studentServlet?method=apply" method="post">

                <table style="margin-left:35%;">
                    <thead style="text-align: left">
                        <small style="color: dimgray;text-align: left;">请认真填写申请人资料</small><br/>
                    </thead>
                    <tr>
                        <td class="td1"><label for="stuname"><em>*</em>姓名</label></td>
                        <td class="td2"><input type="text" id="stuname" name="stuname" class="input-text form-control" style="border-radius:20px"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="td1"><label for="stunum"><em>*</em>学号</label></td>
                        <td class="td2"><input type="text" id="stunum" name="stunum" class="input-text form-control" style="border-radius: 9px;"></td>
                    </tr>
                    <tr>
                        <td class="td1"><label for="stuage"><em>*</em>年龄</label></td>
                        <td class="td2"><input type="text" id="stuage" name="stuage" class="input-text form-control" style="border-radius: 9px;"></td>
                    </tr>
                    <tr>
                        <td class="td1"><em>*</em><label>性别</label></td>
                        <td class="td2">
                            <input type="radio" name="stusex" value="1" checked="checked">男&nbsp;&nbsp;
                            <input type="radio" name="stusex" value="0">女
                        </td>
                    </tr>
                    <tr>
                        <td class="td1"><label><em>*</em>院系</label></td>
                        <td class="td2">
                            <select name="depid"  id="depid">
                                <c:forEach items="${departmentPageBean.beanList}" var="departments">
                                    <option value="${departments.dep_id}">${departments.dep_name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="td1"><label for="stumajor"><em>*</em>专业</label></td>
                        <td class="td2"><input type="text" id="stumajor" name="stumajor" class="input-text form-control" style="border-radius: 9px;"></td>
                    </tr>
                    <tr>
                        <td class="td1"><label for="stugrade"><em>*</em>专业排名</label></td>
                        <td class="td2">
                            <select id="stugrade" name="stugrade">
                                <c:forEach items="${stugradePageBean.beanList}" var="stugrade">
                                    <option value="${stugrade.stu_grade_id}">${stugrade.stu_grade_name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="td1"><label for="stuenglish"><em>*</em>英语水平</label></td>
                        <td class="td2">
                            <input type="text" id="stuenglish" class="input-text" name="stuenglish">
                        </td>
                    </tr>
                    <tr>
                        <td class="td1"><label for="stuphone"><em>*</em>手机号</label></td>
                        <td class="td2"><input type="text" class="input-text" id="stuphone" name="stuphone"></td>
                    </tr>
                    <tr>
                        <td class="td1"><label for="stumail"><em>*</em>邮箱</label></td>
                        <td class="td2"><input type="email" class="input-text" id="stumail" name="stumail"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right" style="text-align: left">
                            <label for="stunote">&nbsp;&nbsp;备注（所获奖项及项目概况）</label>
                            <textarea id="stunote" style="width: 100%;height: 100px" name="stunote"></textarea>
                        </td>
                    </tr>
                    <%--<tr>--%>
                        <%--<td class="td1"><label>上传附件</label></td>--%>
                        <%--<td class="td2">--%>
                            <%--<input type="file">--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                    <tr></tr>
                    <tr align="center">
                        <td colspan="2">
                            <button type="submit" class="btn-success" style="width: 5em;height: 2.5em;border-radius: 9px">确定</button>
                        </td>
                    </tr>
                </table>
            </form>
            <small>${msgApply}</small>
        </div>
    </div>
</section>

<!-- 最下方 -->
<footer id="footer">
    <div class="container" align="center">
        友情链接：
        <a href="http://www.hit.edu.cn/">哈工大（本部）</a>&nbsp;
        <a href="http://www.hitwh.edu.cn/">哈工大（威海）</a>&nbsp;
        <a href="http://www.hitsz.edu.cn/index.html">哈工大（深圳）</a>&nbsp;
    </div>
</footer>

<!--footer menu-->
<section id="footer-menu">
    <div class="container">
        <p align="center">
            山东省威海市环翠区文化西路2号&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：264209&nbsp;&nbsp;&nbsp;&nbsp;哈尔滨工业大学（威海）版权所有 |
            <a class="my_a_link" href="${pageContext.request.contextPath}/adminLogin.jsp" style="color: #1a1a1a">登陆</a>
        </p>
    </div>
</section>
</body>
</html>
