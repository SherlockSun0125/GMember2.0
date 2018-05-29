<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>毕业设计阶段</title>
    <!--三个重要的CSS文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/student/static/core_62c0700cc15bd051f36fa48b7a5c1a26.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/student/static/pt_newpages_course_learn.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/jquery-2.2.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
        .lightbox{
            position: fixed;
            top: 0px;
            left: 0px;
            height: 100%;
            width: 100%;
            z-index: 7;
            opacity: 0.3;
            display: block;
            background-color: rgb(0, 0, 0);
            display: none;
        }
        .pop,iframe{
            position: absolute;
            left: 50%;
            top:0;
            width: 893px;
            height: 100%;
            margin-left: -446.5px;
            z-index: 9;
        }
    </style>
</head>
<body style="background-color: #EEEEEE">
<!--头部-->
<div class="f-pf g-headwrap" id="j-fixed-head">
    <div class="g-hd f-bg1 m-yktNav " id="j-topnav">
        <div class="g-flow">
            <div class="f-pr f-cb">
                <div style="position: absolute;top:2px;bottom:2px;">
                    <a class="f-fl" hidefocus="true" href="${pageContext.request.contextPath}/encryptWeb/student/stuHome.jsp" target="_self" data-index="logo">
                        <img class="f-fl img" src="${pageContext.request.contextPath}/encryptWeb/student/static/hitwh_logo_white.png" title="学生主页" width="540px"
                             style="margin-top: 2px;margin-bottom: 1px">
                    </a>
                </div>
                <div class="m-navrgt f-fr f-cb f-pr j-navright">
                    <div class="userinfo f-fr f-cb f-pr">
                        <div class="login f-cb">
                            <div class="u-mystudy f-pr f-cb f-fr">
                                <a class="mystudy nitem f-f0" data-index="用户退出" target="_self"
                                   href="${pageContext.request.contextPath}/encryptWeb/student/exit.jsp" hidefocus="true">退出</a>
                            </div>
                            <a class="username self f-thide" target="_self" data-index="点击用户名"
                               href="${pageContext.request.contextPath}/studentServlet?method=toUpdateSetting&stuid=${Student.stu_id}">
                                <span class=" f-fs1 f-f0">${Student.stu_name}</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--网页主体-->
<div id="g-body">
    <!--为右侧定义背景-->
    <div class="m-cbg"></div>

    <div class="g-wrap f-cb">
        <!--左侧侧边栏-->
        <div class="g-sd1">
            <div class="m-learnleft">
                <div id="j-courseTabList">
                    <a class="u-learnProgress-tab j-tabitem f-f0 f-fc3 f-cb"  data-type="30"
                       href="${pageContext.request.contextPath}/studentServlet?method=findLogsOfStudentLevel&stuid=${Student.stu_id}&stulevelid=${Student.stu_level_id}">
                        <div class="ic f-fl"></div>
                        <span class="f-fl">毕设日志</span>
                    </a>
                    <ul class="tab u-tabul">
                        <li class="u-greentab j-tabitem f-f0 first u-curtab" data-name="毕业设计" data-type="1">
                            <a class="f-thide f-fc3" href="${pageContext.request.contextPath}/studentServlet?method=findProjectsByStuLevel&stuid=${Student.stu_id}&stulevelid=${Student.stu_level_id}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;毕业设计</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <!--右侧主体-->
        <div class="g-mn1">
            <div class="g-mn1c m-learnbox">
                <c:choose>
                    <c:when test="${project eq null}">
                        <!--发帖按钮-->
                        <div class="f-cb" style="margin-bottom: 30px;margin-top: 20px">
                            <div style="margin-bottom:40px;margin-top: 12px;margin-right: 20px;position: absolute;">
                                <a href="${pageContext.request.contextPath}/encryptWeb/student/level3/newProject.jsp">
                                    <img src="${pageContext.request.contextPath}/encryptWeb/student/static/addGProject.png" style="width: 120px">
                                </a>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div>
                            <!--更改-->
                            <div class="f-cb" style="margin-bottom: 30px;margin-top: 20px">
                                <div style="margin-bottom:40px;margin-top: 12px;margin-right: 20px;position: absolute;">
                                    <a href="${pageContext.request.contextPath}/studentServlet?method=toUpdateProject&projectid=${project.project_id}">
                                        <img src="${pageContext.request.contextPath}/encryptWeb/student/static/changeGProject.png" style="width: 120px">
                                    </a>
                                </div>
                            </div>

                            <!--帖子展示-->
                            <div class="u-forumlistwrap j-alltopiclist" style="margin-top: 100px">
                                <div class="m-flwrap">
                                    <div class="ttitle">
                                        <h4 class="f-fl f-fc3">毕设详情</h4>
                                        <div class="f-fl u-coursecate j-lessonuit"></div>
                                    </div>
                                    <div class="j-detailBox auto-1524789536709-parent">
                                        <div>
                                            <div class="f-cb">
                                                        <table class="table table-bordered">
                                                            <tbody>
                                                            <tr>
                                                                <td style="width: 6em;text-align: center;font-weight: bold">项目名称</td>
                                                                <td colspan="3">${project.project_name}
                                                                    <c:choose>
                                                                        <c:when test="${project.isEnd eq 0}">
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <span style="color: red">&nbsp(已结束)</span>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="width: 6em;text-align: center;font-weight: bold">所属课程</td>
                                                                <td>${project.course}</td>
                                                                <td style="width: 6em;text-align: center;font-weight: bold">负责教师</td>
                                                                <td>${project.teacher}</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="width: 6em;text-align: center;font-weight: bold">开始时间</td>
                                                                <td>${project.project_start_time}</td>
                                                                <td style="width: 6em;text-align: center;font-weight: bold">结束时间</td>
                                                                <td>${project.project_stop_time}</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="width: 6em;text-align: center;font-weight: bold">地点</td>
                                                                <td>${project.project_place}</td>
                                                                <td style="width: 6em;text-align: center;font-weight: bold">成员</td>
                                                                <td>${project.project_member}</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="height:10em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">备<br/>注</td>
                                                                <td colspan="3">${project.project_about}</td>
                                                            </tr>
                                                            <tr>
                                                                <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">项<br/>目<br/>开<br/>题<br/>汇<br/>报</td>
                                                                <script>
                                                                    function checkStartForm1() {
                                                                        if(!$("#startPaper1").val()){
                                                                            alert("开题报告：未选择任何文件！");
                                                                            return false;
                                                                        }
                                                                        return true;
                                                                    }
                                                                    function checkMidForm1() {
                                                                        if(!$("#midPaper1").val()){
                                                                            alert("中期报告：未选择任何文件！");
                                                                            return false;
                                                                        }
                                                                       return true;
                                                                    }
                                                                    function checkEndForm1() {
                                                                        if(!$("#endPaper1").val()){
                                                                            alert("终期报告：未选择任何文件！");
                                                                            return false;
                                                                        }
                                                                        return true;
                                                                    }
                                                                    function checkStartForm2() {
                                                                        if(!$("#startPaper2").val()){
                                                                            alert("开题报告：未选择任何文件！");
                                                                            return false;
                                                                        }
                                                                        return true;
                                                                    }
                                                                    function checkMidForm2() {
                                                                        if(!$("#midPaper2").val()){
                                                                            alert("中期报告：未选择任何文件！");
                                                                            return false;
                                                                        }
                                                                        return true;
                                                                    }
                                                                    function checkEndForm2() {
                                                                        if(!$("#endPaper2").val()){
                                                                            alert("终期报告：未选择任何文件！");
                                                                            return false;
                                                                        }
                                                                        return true;
                                                                    }
                                                                </script>
                                                                <td colspan="1" style="width: 25em;">
                                                                    <c:choose>
                                                                        <c:when test="${project.start_paper eq null}">
                                                                            <form class="form-group" method="post" enctype="multipart/form-data" onsubmit="return checkStartForm1()"
                                                                                  action="${pageContext.request.contextPath}/studentServlet?method=uploadFile&projectid=${project.project_id}&projectlevel=start">
                                                                                <input type="file" name="startPaper" id="startPaper1">
                                                                                <br/>
                                                                                <input type="submit" value="上传开题报告" class="btn btn-success">
                                                                            </form>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <form class="form-group" method="post" enctype="multipart/form-data" onsubmit="return checkStartForm2()"
                                                                                  action="${pageContext.request.contextPath}/studentServlet?method=uploadFile&projectid=${project.project_id}&projectlevel=start">
                                                                                <input type="file" name="startPaper" id="startPaper2">
                                                                                <br/>
                                                                                <input type="submit" value="重传开题报告" class="btn btn-success">
                                                                            </form>
                                                                                <a class="btn btn-info"  target="pdfContainer" onclick="showPdf(true)" href="${pageContext.request.contextPath}/upload/${project.start_paper}">查看开题报告</a><br/>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <small>${msgUploadFilestart}</small>
                                                                </td>
                                                                <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">导<br/>师<br/>评<br/>价</td>
                                                                <td>
                                                                    ${project.start_paperF}
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">项<br/>目<br/>中<br/>期<br/>汇<br/>报</td>
                                                                <td colspan="1">
                                                                    <c:choose>
                                                                        <c:when test="${project.mid_paper eq null}">
                                                                            <form class="form-group" method="post" enctype="multipart/form-data" onsubmit="return checkMidForm1()"
                                                                                  action="${pageContext.request.contextPath}/studentServlet?method=uploadFile&projectid=${project.project_id}&projectlevel=mid">
                                                                                <input type="file" name="midPaper" id="midPaper1">
                                                                                <br/>
                                                                                <input type="submit" value="上传中期报告" class="btn btn-success">
                                                                            </form>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <form class="form-group" method="post" enctype="multipart/form-data" onsubmit="return checkMidForm2()"
                                                                                  action="${pageContext.request.contextPath}/studentServlet?method=uploadFile&projectid=${project.project_id}&projectlevel=mid">
                                                                                <input type="file" name="midPaper" id="midPaper2">
                                                                                <br/>
                                                                                <input type="submit" value="重传中期报告" class="btn btn-success">
                                                                            </form>
                                                                            <a class="btn btn-info"  target="pdfContainer" onclick="showPdf(true)" href="${pageContext.request.contextPath}/upload/${project.mid_paper}">查看中期报告</a><br/>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <small>${msgUploadFilemid}</small>
                                                                </td>
                                                                <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">导<br/>师<br/>评<br/>价</td>
                                                                <td>
                                                                    ${project.mid_paperF}
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">项<br/>目<br/>终<br/>期<br/>汇<br/>报</td>
                                                                <td colspan="1">
                                                                    <c:choose>
                                                                        <c:when test="${project.end_paper eq null}">
                                                                            <form class="form-group" method="post" enctype="multipart/form-data" onsubmit="return checkEndForm1()"
                                                                                  action="${pageContext.request.contextPath}/studentServlet?method=uploadFile&projectid=${project.project_id}&projectlevel=end">
                                                                                <input type="file" name="endPaper" id="endPaper1">
                                                                                <br/>
                                                                                <input type="submit" value="上传终期报告" class="btn btn-success">
                                                                            </form>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <form class="form-group" method="post" enctype="multipart/form-data" onsubmit="return checkEndForm2()"
                                                                                  action="${pageContext.request.contextPath}/studentServlet?method=uploadFile&projectid=${project.project_id}&projectlevel=end">
                                                                                <input type="file" name="endPaper" id="endPaper2">
                                                                                <br/>
                                                                                <input type="submit" value="重传终期报告" class="btn btn-success">
                                                                            </form>
                                                                            <a class="btn btn-info" target="pdfContainer" onclick="showPdf(true)" href="${pageContext.request.contextPath}/upload/${project.end_paper}">查看终期报告</a><br/>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <small>${msgUploadFileend}</small>
                                                                </td>
                                                                <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">导<br/>师<br/>评<br/>价</td>
                                                                <td colspan="1">
                                                                     ${project.end_paperF}
                                                                </td>
                                                            </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                            <small>${msgAddProject}</small>
                                        </div>
                                        <div>
                                            <script src="${pageContext.request.contextPath}/pdfjs/build/pdf.js"></script>
                                            <script src="${pageContext.request.contextPath}/pdfjs/build/pdf.worker.js"></script>
                                            <script type="text/javascript">
                                                function showPdf(isShow){
                                                    var state = "";
                                                    if(isShow){
                                                        state = "block";
                                                    }else{
                                                        state = "none";
                                                    }
                                                    var pop = document.getElementById("pop");
                                                    pop.style.display = state;
                                                    var lightbox = document.getElementById("lightbox");
                                                    lightbox.style.display = state;
                                                }
                                                function close(){
                                                    showPdf(false);
                                                }
                                            </script>
                                            <div>
                                                <div class="lightbox" id="lightbox"></div>
                                                <div id="pop" class="pop" style="display: none;">
                                                    <a href="javascript:close()" style="
                                                                    position: absolute;
                                                                    right: -90px;
                                                                    display: inline-block;
                                                                    width: 80px;
                                                                    height: 30px;
                                                                " id="close"><img src="${pageContext.request.contextPath}/encryptWeb/student/static/close.png" width="25px"></a>
                                                    <iframe src="" frameborder="0" id="pdfContainer" name="pdfContainer"></iframe>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
</body>
</html>
