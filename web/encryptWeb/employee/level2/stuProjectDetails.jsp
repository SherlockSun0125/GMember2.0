<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>校企合作阶段管理</title>
    <!--三个重要的CSS文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/employee/static/core_62c0700cc15bd051f36fa48b7a5c1a26.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/employee/static/core_e47b1ded06977727b0dc00ac5fae1259.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/employee/static/pt_newpages_course_learn.css">
    <style type="text/css">
        .ux-pager_itm > a, .ux-pager_itm > span, .ux-pager_btn > a, .ux-pager_btn > span, .ux-pager_sep > a, .ux-pager_sep > span {
            display: inline-block;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            text-decoration: none;
            padding: 0 12px;
            min-width: 6px;
            height: 30px;
            line-height: 30px
        }

        .ux-pager_itm > a, .ux-pager_btn > a, .ux-pager_sep > a {
            border: 1px solid #ddd;
            border-radius: 2px
        }

        .ux-pager > li.z-crt > a {
            color: white
        }

        .ux-pager > li.z-dis > a {
            cursor: not-allowed;
            color: #999
        }

        .ux-dropdown-check_listview li {
            cursor: pointer;
            padding: 0 12px
        }

        .ux-dropdown-check_listview li:hover {
            background-color: #e6eaeb
        }

        .ux-table table {
            font-size: 14px;
            margin-bottom: 60px;
            position: relative;
            table-layout: fixed;
            border-collapse: collapse;
            border-spacing: 0;
            min-height: 180px;
        }

        .ux-table table thead .head {
            color: #859295;
            height: 44px;
        }

        .ux-table table thead .head th {
            padding: 0px 15px;
            text-align: center;
            position: relative;
            background-color: #f2f5f5;
            border-color: #ddd;
            font-size: 14px;
            color: #999;
        }

        .ux-table table tbody tr {
            border-bottom: 1px dashed #d9ddde;
        }

        .ux-table table tbody tr td {
            color: #52585a;
            padding: 20px 15px;
            text-align: center;
        }

        .ux-table-border table thead .head th {
            background-color: #f3f6f7;
        }

        .ux-table-border table tbody {
            border: 1px solid #ddd;
        }

        .ux-table-border table tbody tr:hover {
            background: #F3F6F7;
        }

        .ux-table-border table tbody tr {
            height: 41px;
            border-bottom: 1px solid #eee;
        }

        .ux-table-border table tbody tr td {
            padding: 10px 15px;
        }

        .ux-table-border table tbody tr td:hover {
            background: #F3F6F7;
        }

        .ux-table-border table tbody tr:last-child {
            border-bottom: 1px solid #ddd;
        }

        .ux-table-border table tbody tr:last-child td {
            border-bottom: 1px solid #ddd;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-header > * {
            display: inline-block;
            vertical-align: middle;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-table table {
            width: 620px;
            margin: 0;
            table-layout: auto !important;
            border-collapse: separate !important;
            min-height: 0px !important;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-table table thead {
            width: 618px;
            border: 1px solid #DDDDDD;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-table table tbody tr {
            cursor: pointer;
            border-bottom: none;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-table table tbody tr td {
            height: 39px;
            line-height: 39px;
            font-size: 14px;
            color: #666666;
            padding: 0;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-table table tbody tr td td-icon {
            width: 36px;
            height: 36px;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-table table tbody tr:hover {
            background-color: #F3F6F7;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-table table tbody tr.selected {
            background-color: #49AF4F;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-table table tbody tr.selected td {
            color: white;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-table table tbody tr.disable td {
            color: #C9C9C9;
        }

        .ux-richeditor-video-selector-dialog .m-video-selector-footer hr {
            margin-top: 10px;
            margin-bottom: 20px;
        }

        .ux-richeditor .zdlitm .up {
            font-size: 12px;
            color: #999;
            line-height: 22px;
        }

        .ux-richeditor .zdlitm.js-disabled .up {
            cursor: default;
        }

        .ux-richeditor .zdlitm .down, .ux-richeditor .zitm .down {
            position: absolute;
            top: 22px;
            left: -1px;
            width: auto;
            max-height: 210px;
            overflow-x: hidden;
            overflow-y: auto;
            z-index: 100;
            border: 1px solid #d1d2d4;
            background-color: #fff;
        }

        .ux-richeditor-link .txtwrap .title {
            color: #ccc;
            height: 30px;
            width: 30px;
            line-height: 30px;
            text-align: center;
        }

        .ux-richeditor-uploadCard .tabitem span {
            line-height: 30px;
            text-align: center;
            font-size: 12px;
            padding: 0 5px;
        }

        .syntaxhighlighter a, .syntaxhighlighter div, .syntaxhighlighter code, .syntaxhighlighter td, .syntaxhighlighter tr, .syntaxhighlighter tbody, .syntaxhighlighter thead, .syntaxhighlighter caption, .syntaxhighlighter textarea {
            -moz-border-radius: 0 !important;
            -webkit-border-radius: 0 0 0 0 !important;
            background: none !important;
            border: 0 !important;
            bottom: auto !important;
            float: none !important;
            left: auto !important;
            line-height: 1.1em !important;
            outline: 0 !important;
            overflow: visible !important;
            position: static !important;
            right: auto !important;
            text-align: left !important;
            top: auto !important;
            vertical-align: baseline !important;
            width: auto !important;
            box-sizing: content-box !important;
            font-family: Monaco, Menlo, Consolas, "Courier New", monospace;
            font-weight: 400 !important;
            font-style: normal !important;
            min-height: auto !important;
            font-size: 13px !important;
            margin: 0 !important;
            padding: 0 !important;
        }



        .syntaxhighlighter caption {
            text-align: left !important;
            color: #000 !important;
            padding: .5em 0 .5em 1em !important;
        }

        .syntaxhighlighter ol {
            list-style: decimal;
            margin: 0px 0px 1px 0px;
            padding: 2px 0;
            color: #AFAFAF;
            font-size: 1.0em;
            line-height: 1.4em;
            color: #afafaf !important;
            background-color: #f7f7f9;
        }

        .syntaxhighlighter ol li {
            list-style: decimal;
            border-left: 1px solid #E1E1E8;
            padding-left: 10px;
            line-height: 1.1em;
            margin: 0 0 0 45px;
        }

        .syntaxhighlighter.collapsed .toolbar span {
            display: inline !important;
            margin-right: 1em !important;
        }

        .syntaxhighlighter.collapsed .toolbar span a {
            display: none !important;
            padding: 0 !important;
        }

        .syntaxhighlighter .toolbar {
            position: absolute !important;
            right: 1px !important;
            top: 1px !important;
            width: 11px !important;
            height: 11px !important;
            font-size: 10px !important;
            z-index: 10 !important;
            color: #FFF !important;
            background: #6ce26c !important;
            border: none !important;
        }

        .syntaxhighlighter .toolbar a {
            display: block !important;
            text-align: center !important;
            text-decoration: none !important;
            padding-top: 1px !important;
            color: #FFF !important;
        }

        .syntaxhighlighter.ie .toolbar a {
            padding-top: 0 !important;
        }

        .syntaxhighlighter.ie ol {
            white-space: normal;
        }

        .syntaxhighlighter.printing .line.alt1 .content, .syntaxhighlighter.printing .line.alt2 .content, .syntaxhighlighter.printing .line.highlighted .number, .syntaxhighlighter.printing .line.highlighted.alt1 .content, .syntaxhighlighter.printing .line.highlighted.alt2 .content {
            background: none !important;
        }

        .syntaxhighlighter.printing .line .number {
            color: #bbb !important;
        }

        .syntaxhighlighter.printing .line .content {
            color: #000 !important;
            border: none !important;
        }

        .syntaxhighlighter.printing a {
            text-decoration: none !important;
        }


        .syntaxhighlighter .bold, .syntaxhighlighter.printing .script {
            font-weight: 700 !important;
        }

        .syntaxhighlighter.collapsed table, .syntaxhighlighter .toolbar a.expandSource, .syntaxhighlighter.printing .toolbar {
            display: none !important;
        }

        .syntaxhighlighter.collapsed .toolbar span a.expandSource, .syntaxhighlighter .toolbar span.title {
            display: inline !important;
        }

        .syntaxhighlighter.printing .plain, .syntaxhighlighter.printing .plain a, .syntaxhighlighter.printing .break, .syntaxhighlighter.printing .break a, .syntaxhighlighter .line.highlighted.number, .syntaxhighlighter .toolbar a:hover, .syntaxhighlighter .plain, .syntaxhighlighter .plain a {
            color: #000 !important;
        }

        .syntaxhighlighter.printing .comments, .syntaxhighlighter.printing .comments a, .syntaxhighlighter .comments, .syntaxhighlighter .comments a {
            color: #008200 !important;
        }

        .syntaxhighlighter.printing .string, .syntaxhighlighter.printing .string a, .syntaxhighlighter.collapsed .toolbar a, .syntaxhighlighter .string, .syntaxhighlighter .string a {
            color: blue !important;
        }

        .syntaxhighlighter.printing .preprocessor, .syntaxhighlighter.printing .color1, .syntaxhighlighter.printing .color1 a, .syntaxhighlighter .preprocessor, .syntaxhighlighter .color1, .syntaxhighlighter .color1 a {
            color: gray !important;
        }

        .ux-richeditor-math .m-mathedit .imgshow img {
            max-width: 570px;
        }

        .ux-richeditor-math .m-mathedit .samright img {
            vertical-align: middle;
        }

        body .ux-eduEditorDialog .ux-richeditor-link .row label {
            margin-right: 10px;
            line-height: 33px;
            float: left;
            color: #859295;
        }

        body .ux-eduEditorDialog .ux-richeditor-link .txtwrap .ipt:focus {
            background: white;
            color: #343d42;
            -webkit-box-shadow: 1px 1px 10px #E4F9E5;
            -moz-box-shadow: 1px 1px 10px #E4F9E5;
            box-shadow: 1px 1px 10px #E4F9E5;
        }

        body .ux-eduEditorDialog .ux-richeditor-link .btns {
            margin-top: 15px;
        }

        body .ux-eduEditorDialog .ux-richeditor-link .btns .ux-btn, body .ux-eduEditorDialog .ux-richeditor-link .btns .ux-btn-gh {
            margin-left: 20px;
            width: 100px;
            height: 32px;
            line-height: 32px;
            font-size: 14px;
            text-align: center;
            -webkit-border-radius: 3px;
            border-radius: 3px;
            box-sizing: border-box;
        }

        body .ux-eduEditorDialog .ux-richeditor-math .u-equation .eqitems .item :first-child {
            padding-left: 0;
        }

        .auto-1524789536668 .priceset label {
            display: inline-block;
            width: 40px;
        }

        .auto-1524789536668 .timeSet .zday th {
            font-size: 12px;
            font-family: sans-serif;
            text-align: center;
        }

        .auto-1524789536668 .timeSet .zact span {
            font-size: 12px;
            font-family: sans-serif;
        }

        .auto-1524789536671 .title {
            font-size: 14px;
        }

        .auto-1524789536682 h3 img {
            vertical-align: text-bottom;
        }

        .auto-1524789536682 h3 span {
            font-size: 18px;
            color: #333;
        }

        .auto-1524789536682 h3:hover {
            cursor: pointer;
            backgorund: #fff;
        }

        .auto-1524789536682 .list-in a {
            display: block;
            color: #333;
            font-size: 14px;
            height: 30px;
            line-height: 30px;
            margin-top: 10px;
            padding: 5px 8px;
            background: #f5f5f5;
        }

        .auto-1524789536682 .list-in a:hover {
            color: #21a557;
        }

        .auto-1524789536682 .list-in img {
            width: 30px;
            height: 30px;
            border-radius: 50%;
            margin-right: 10px;
            float: left;
        }

        .auto-1524789536682 .list-in span {
            float: left;
            width: 155px;
        }

        .auto-1524789536688 div {
            cursor: pointer;
            width: 15px;
            height: 15px;
            background: url(/encryptWeb/student/static/forum_icon.png) no-repeat -4999px -4999px;
        }

        .auto-1524789536688 .num {
            color: #666;
            line-height: 15px;
            max-width: 45px;
            margin: 0 3px;
        }

        .auto-1524789536688 .up {
            background-position: 2px -22px;
        }

        .auto-1524789536688 .up.hvr:hover {
            background-position: -15px -22px;
        }

        .auto-1524789536688 .down {
            background-position: 2px -44px;
        }

        .auto-1524789536688 .down.hvr:hover {
            background-position: -15px -44px;
        }

        .auto-1524789536690 .manBtn span {
            display: inline-block;
            vertical-align: middle;
            height: 14px;
            width: 14px;
            background: url(/encryptWeb/student/static/forum_icon.png) no-repeat -55px -45px;
        }

        .auto-1524789536690 .manBtn:hover span {
            background-position: -72px -45px;
        }

        .u-manList li {
            line-height: 30px;
            text-align: center;
            border-bottom: 1px solid #DDD;
            cursor: pointer;
        }

        .u-manList li:hover a {
            color: #61A500;
        }

        .auto-1524789536693 {
            background-color: #f8f8f8;
            padding: 10px 20px;
        }

        .auto-1524789536693 .title {
            max-width: 68%;
        }

        .auto-1524789536693 .content {
            padding-top: 10px;
        }

        .auto-1524789536693 .infobar {
            padding: 10px 0;
            border-bottom: 1px solid #eee;
        }

        .auto-1524789536693 .infobar .time {
            padding: 0 10px;
        }

        .auto-1524789536693 .optbar {
            padding-top: 10px;
        }

        .auto-1524789536693 .optBox, .auto-1524789536693 .votebox {
            margin-top: 5px;
        }

        .auto-1524789536693 .optBox .divider {
            color: #ddd;
            margin: 0 5px;
        }

        .auto-1524789536693 .optbar a i {
            vertical-align: -3px;
            display: inline-block;
            width: 20px;
            height: 16px;
            background: url(/encryptWeb/student/static/forum_icon.png) no-repeat -4999px -4999px;
        }

        .auto-1524789536693 .optbar .replyBtn i {
            background-position: -54px 1px;
        }

        .auto-1524789536693 .optbar .followBtn.unfollowed i {
            background-position: -78px 0;
        }

        .auto-1524789536693 .optbar .followBtn.unfollowed .second, .auto-1524789536693 .optbar .followBtn.unfollowed .secHvr {
            display: none;
        }

        .auto-1524789536693 .optbar .followBtn.followed i {
            background-position: -53px -24px;
        }

        .auto-1524789536693 .optbar .followBtn.followed .first, .auto-1524789536693 .optbar .followBtn.followed .secHvr {
            display: none;
        }

        .auto-1524789536695 {
        }

        .auto-1524789536695 .rich-opt {
            margin-top: 10px;
        }

        .auto-1524789536695 .rich-opt label {
            cursor: pointer;
            color: #999;
            vertical-align: top;
        }

        .auto-1524789536695 .rich-opt label:hover {
            color: #61a500;
        }

        .auto-1524789536695 .rich-opt label input {
            margin-top: 3px;
        }

        .auto-1524789536695 .rich-opt .cancelbtn {
            margin-right: 10px;
            line-height: 24px;
        }

        .auto-1524789536695 .unlogin {
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
        }

        .auto-1524789536695 .unlogin .autowrap {
            margin: 115px auto;
            width: 188px;
        }

        .auto-1524789536695 .unlogin .autowrap p {
            line-height: 26px;
            color: #666;
            margin-right: 10px;
        }

        .auto-1524789536697 {
            width: 100%;
            padding-top: 15px;
        }

        .auto-1524789536697 .tagCt {
            margin-bottom: 6px;
        }

        .auto-1524789536697 .bar {
            padding: 10px 0;
        }

        .auto-1524789536697 .time {
            padding-left: 10px;
        }

        .auto-1524789536697 .opt {
            cursor: pointer;
        }

        .auto-1524789536697 .divider {
            color: #ddd;
            margin: 0 5px;
        }

        .auto-1524789536699 {
            width: 550px;
        }

        .auto-1524789536699 .small {
            background-color: #fff;
            border: 1px solid #dfdfdf;
            padding: 10px;
            color: #999;
        }

        .auto-1524789536699 .small a {
            color: #61A500;
        }




        .auto-1524789536701 .m-detailInfoItem .bar {
            padding: 5px 0;
        }

        .auto-1524789536705 {
            border-bottom: 1px solid #eee;
            zoom: 1;
        }

        .auto-1524789536707 {
            line-height: 20px;
            color: #666;
        }

        .auto-1524789536707 .divider {
            display: inline-block;
            border-left: 1px solid #ddd;
            margin: 0px 10px 0px 5px;
        }

        .auto-1524789536707 a {
            color: #666;
            cursor: pointer;
        }

        .auto-1524789536707 a:hover {
            color: #61A500;
            text-decoration: none;
        }

        .auto-1524789536707 a span {
            background: url(/encryptWeb/student/static/forum_icon.png) no-repeat -4999px -4999px;
            margin-left: 4px;
            display: inline-block;
            width: 12px;
            height: 20px;
            vertical-align: top;
        }

        .auto-1524789536707 .upsort {
            color: #61A500;
        }

        .auto-1524789536707 .double.nosort span {
            background-position: 0 2px;
        }

        .auto-1524789536707 .double.downsort span {
            background-position: -20px 2px;
        }

        .auto-1524789536707 .double.upsort span {
            background-position: -38px 2px;
        }

        .auto-1524789536709 .rinfobox {
            padding: 30px 0 10px 0;
            border-bottom: 1px solid #eee;
        }

        .auto-1524789536709 .allbox {
            margin-bottom: 20px;
        }
        .auto-1524789536729 h3 {
            background: #fff;
            border: 1px solid #2cb060;
            text-align: center;
            height: 40px;
            line-height: 40px;
        }

        .auto-1524789536729 h3 span {
            font-size: 18px;
            color: #333;
        }

        .auto-1524789536729 h3:hover {
            cursor: pointer;
            background: #fff;
        }

        .auto-1524789536729 .box-in-small span {
            font-size: 12px;
        }

        .auto-1524789536729 .box-in-small h3:hover {
            background: #f0f0f0;
        }

        .auto-1524789536729 .box-in-small h3 {
            height: 20px;
            line-height: 20px;
            background: #fff;
            padding: 2px 8px 4px;
            border: 1px solid #e6e6e6;
            display: inline-block;
            border-radius: 6px;
            line-height:19px;
        }

        .auto-1524789536729 p {
            line-height: 20px;
            color: #333;
            font-size: 12px;
            margin-top: 10px;
        }



        .um-cps-ux-promoter-course-detail-collect-bubble img {
            width: 100%;
        }

        .ux-member-module-head a {
            font-size: 15px;
        }


        .ux-dropdown_listview li {
            cursor: pointer;
            padding: 0 12px
        }

        .ux-dropdown_listview li:hover {
            background-color: #f3f6f7
        }
    </style>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/encryptWeb/admin/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/encryptWeb/admin/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/encryptWeb/admin/lib/jquery-1.11.1.min.js"
            type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/premium.css">
    <script type="text/javascript">
        $(function () {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if (match) var color = match[1];
            if (color) {
                $('body').removeClass(function (index, css) {
                    return (css.match(/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});

        });
    </script>
    <style type="text/css">
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }

        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
            color: #fff;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>
    <script src="${pageContext.request.contextPath}/encryptWeb/admin/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function () {
            $('.demo-cancel-click').click(function () {
                return false;
            });
        });
    </script>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/pager/pager.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/encryptWeb/student/static/wangEditor.min.js"></script>
</head>


<body style="background-color: #EEEEEE">
<div id="g-container">
    <!--头部-->
    <div class="f-pf g-headwrap" id="j-fixed-head">
        <div class="g-hd f-bg1 m-yktNav " id="j-topnav">
            <div class="g-flow">
                <div class="f-pr f-cb">
                    <div style="position: absolute;top:2px;bottom:2px;">
                        <a class="f-fl" hidefocus="true" target="_self" data-index="logo" href="${pageContext.request.contextPath}/encryptWeb/employee/empHome.jsp">
                            <img class="f-fl img" src="${pageContext.request.contextPath}/encryptWeb/employee/static/hitwh_logo_white.png" title="教师主页" width="540px"
                                 style="margin-top: 2px;margin-bottom: 1px">
                        </a>
                    </div>
                    <div class="m-navrgt f-fr f-cb f-pr j-navright">
                        <div class="userinfo f-fr f-cb f-pr">
                            <div class="login f-cb">
                                <div class="u-mystudy f-pr f-cb f-fr">
                                    <a class="mystudy nitem f-f0" data-index="用户退出" target="_self"
                                       href="${pageContext.request.contextPath}/encryptWeb/employee/exit.jsp" hidefocus="true">退出</a>
                                </div>
                                <a class="username self f-thide" target="_self" data-index="点击用户名"
                                   href="${pageContext.request.contextPath}/encryptWeb/employee/setting.jsp">
                                    <span class=" f-fs1 f-f0">${Employee.emp_name}</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--网页主体-->
    <!--网页主体-->
    <div id="g-body">
        <div class="m-cbg"></div>
        <div class="g-wrap f-cb">
            <!--左侧边栏-->
            <div class="g-sd1">
                <div class="m-learnleft">
                    <div id="j-courseTabList">
                        <ul class="tab u-tabul">
                            <c:forEach items="${studentPageBean.beanList}" var="student">
                                <c:choose>
                                    <c:when test="${project.stu_id eq student.stu_id}">
                                        <li class="u-greentab j-tabitem f-f0 first u-curtab">
                                            <a class="f-thide f-fc3" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentLevelInfo&stuid=${student.stu_id}&stulevelid=${student.stu_level_id}">${student.stu_num}&nbsp;&nbsp;${student.stu_name}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="u-greentab j-tabitem f-f0">
                                            <a class="f-thide f-fc3" href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentLevelInfo&stuid=${student.stu_id}&stulevelid=${student.stu_level_id}">${student.stu_num}&nbsp;&nbsp;${student.stu_name}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>

            <!--中间-->
            <div class="g-mn1">
                <div class="g-mn1c m-learnbox" id="courseLearn-inner-box">
                    <div class="u-learn-modulewidth" style="width: 90%">
                        <div class="j-breadNavBox">
                            <div class="u-forumbreadnav">
                                <a href="${pageContext.request.contextPath}/employeeServlet?method=findAllStudentsByEmp&empid=${Employee.emp_id}&stulevelid=2">校企合作阶段管理</a>
                                <span class="f-icon split"></span>
                                <span>项目查看</span>
                            </div>
                        </div>
                        <div class="j-detailBox auto-1524789536709-parent" id="auto-id-1524789537182">
                            <div class="auto-1524789536709" id="auto-id-1524789537181">
                                <div class="j-post">
                                    <div class="auto-1524789536693">
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
                                                    <td colspan="3">${project.start_paper}</td>
                                                </tr>
                                                <tr>
                                                    <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">项<br/>目<br/>中<br/>期<br/>汇<br/>报</td>
                                                    <td colspan="3">${project.mid_paper}</td>
                                                </tr>
                                                <tr>
                                                    <td style="height:12em;width: 6em;text-align: center;font-weight: bold;vertical-align: middle">项<br/>目<br/>终<br/>期<br/>汇<br/>报</td>
                                                    <td colspan="3">${project.end_paper}</td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="infobar f-cb"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>