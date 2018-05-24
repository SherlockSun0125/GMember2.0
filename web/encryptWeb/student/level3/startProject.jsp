<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>毕设开题</title>
    <!--三个重要的CSS文件-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/student/static/core_62c0700cc15bd051f36fa48b7a5c1a26.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/encryptWeb/student/static/pt_newpages_course_learn.css">

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/pdfjs/web/viewer.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/pdfjs/build/pdf.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/pdfjs/build/pdf.worker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/pdfjs/web/viewer.js"></script>
</head>
<body>
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
                               href="../setting.jsp">
                                <span class=" f-fs1 f-f0">${Student.stu_name}</span>
                            </a>
                            <i class="line" style="padding-top: 2%"></i>
                            <a data-index="消息" class="mes f-pr f-cb j-nav-mescenter"
                               href="${pageContext.request.contextPath}/encryptWeb/student/messageT.jsp" title="查看更多消息" target="_blank">
                                <span>消息</span>
                                <em class="num hidddenClass j-nav-msgnum">0</em>
                            </a>
                            <div class="u-mystudy f-pr f-cb f-fr">
                                <a class="mystudy nitem f-f0" id="j-nav-my-class" data-index="我的学习" target="_self"
                                   href="${pageContext.request.contextPath}/encryptWeb/student/forum.jsp" hidefocus="true">讨论区</a>
                            </div>
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
                        <li class="u-greentab j-tabitem f-f0 first u-curtab" data-name="开题" data-type="1">
                            <a class="f-thide f-fc3" href="${pageContext.request.contextPath}/encryptWeb/student/level3/startProject.jsp">毕设开题</a>
                        </li>
                        <li class="u-greentab j-tabitem f-f0" data-name="中期" data-type="7"
                            data-id="2001487096">
                            <a class="f-thide f-fc3"  href="${pageContext.request.contextPath}/encryptWeb/student/level3/midProject.jsp">毕设中期</a>
                        </li>
                        <li class="u-greentab j-tabitem f-f0 last" data-name="终期" data-type="7"
                            data-id="2001487096">
                            <a class="f-thide f-fc3"  href="${pageContext.request.contextPath}/encryptWeb/student/level3/endProject.jsp">毕设终期</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <!--右侧主体-->
        <div class="g-mn1">
            <div class="g-mn1c m-learnbox" id="courseLearn-inner-box">

                <div class="m-forumindex">
                    <!--发帖按钮-->
                    <div class="f-cb">
                        <a class="j-newTopicBtn f-fl" style="margin-bottom:40px;margin-top: 12px;"
                           href="newLog.jsp"><img src="${pageContext.request.contextPath}/encryptWeb/student/static/uploadReport.png" style="width: 120px"></a>
                    </div>

                    <!--帖子展示-->
                    <div class="u-forumlistwrap j-alltopiclist">
                        <div class="m-flwrap">
                            <div class="ttitle">
                                <h4 class="f-fl f-fc3">报告详情</h4>
                                <div class="f-fl u-coursecate j-lessonuit"></div>
                            </div>
                            <div id="outerContainer">

                                <div id="sidebarContainer">
                                    <div id="toolbarSidebar">
                                        <div class="splitToolbarButton toggled">
                                            <button id="viewThumbnail" class="toolbarButton toggled" title="Show Thumbnails" tabindex="2" data-l10n-id="thumbs">
                                                <span data-l10n-id="thumbs_label">Thumbnails</span>
                                            </button>
                                            <button id="viewOutline" class="toolbarButton" title="Show Document Outline (double-click to expand/collapse all items)" tabindex="3" data-l10n-id="document_outline">
                                                <span data-l10n-id="document_outline_label">Document Outline</span>
                                            </button>
                                            <button id="viewAttachments" class="toolbarButton" title="Show Attachments" tabindex="4" data-l10n-id="attachments">
                                                <span data-l10n-id="attachments_label">Attachments</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div id="sidebarContent">
                                        <div id="thumbnailView">
                                        </div>
                                        <div id="outlineView" class="hidden">
                                        </div>
                                        <div id="attachmentsView" class="hidden">
                                        </div>
                                    </div>
                                </div>  <!-- sidebarContainer -->

                                <div id="mainContainer">
                                    <div class="findbar hidden doorHanger" id="findbar">
                                        <div id="findbarInputContainer">
                                            <input id="findInput" class="toolbarField" title="Find" placeholder="Find in document…" tabindex="91" data-l10n-id="find_input">
                                            <div class="splitToolbarButton">
                                                <button id="findPrevious" class="toolbarButton findPrevious" title="Find the previous occurrence of the phrase" tabindex="92" data-l10n-id="find_previous">
                                                    <span data-l10n-id="find_previous_label">Previous</span>
                                                </button>
                                                <div class="splitToolbarButtonSeparator"></div>
                                                <button id="findNext" class="toolbarButton findNext" title="Find the next occurrence of the phrase" tabindex="93" data-l10n-id="find_next">
                                                    <span data-l10n-id="find_next_label">Next</span>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="findbarOptionsContainer">
                                            <input type="checkbox" id="findHighlightAll" class="toolbarField" tabindex="94">
                                            <label for="findHighlightAll" class="toolbarLabel" data-l10n-id="find_highlight">Highlight all</label>
                                            <input type="checkbox" id="findMatchCase" class="toolbarField" tabindex="95">
                                            <label for="findMatchCase" class="toolbarLabel" data-l10n-id="find_match_case_label">Match case</label>
                                            <span id="findResultsCount" class="toolbarLabel hidden"></span>
                                        </div>

                                        <div id="findbarMessageContainer">
                                            <span id="findMsg" class="toolbarLabel"></span>
                                        </div>
                                    </div>  <!-- findbar -->

                                    <div id="secondaryToolbar" class="secondaryToolbar hidden doorHangerRight">
                                        <div id="secondaryToolbarButtonContainer">
                                            <button id="secondaryPresentationMode" class="secondaryToolbarButton presentationMode visibleLargeView" title="Switch to Presentation Mode" tabindex="51" data-l10n-id="presentation_mode">
                                                <span data-l10n-id="presentation_mode_label">Presentation Mode</span>
                                            </button>

                                            <button id="secondaryOpenFile" class="secondaryToolbarButton openFile visibleLargeView" title="Open File" tabindex="52" data-l10n-id="open_file">
                                                <span data-l10n-id="open_file_label">Open</span>
                                            </button>

                                            <button id="secondaryPrint" class="secondaryToolbarButton print visibleMediumView" title="Print" tabindex="53" data-l10n-id="print">
                                                <span data-l10n-id="print_label">Print</span>
                                            </button>

                                            <button id="secondaryDownload" class="secondaryToolbarButton download visibleMediumView" title="Download" tabindex="54" data-l10n-id="download">
                                                <span data-l10n-id="download_label">Download</span>
                                            </button>

                                            <a href="#" id="secondaryViewBookmark" class="secondaryToolbarButton bookmark visibleSmallView" title="Current view (copy or open in new window)" tabindex="55" data-l10n-id="bookmark">
                                                <span data-l10n-id="bookmark_label">Current View</span>
                                            </a>

                                            <div class="horizontalToolbarSeparator visibleLargeView"></div>

                                            <button id="firstPage" class="secondaryToolbarButton firstPage" title="Go to First Page" tabindex="56" data-l10n-id="first_page">
                                                <span data-l10n-id="first_page_label">Go to First Page</span>
                                            </button>
                                            <button id="lastPage" class="secondaryToolbarButton lastPage" title="Go to Last Page" tabindex="57" data-l10n-id="last_page">
                                                <span data-l10n-id="last_page_label">Go to Last Page</span>
                                            </button>

                                            <div class="horizontalToolbarSeparator"></div>

                                            <button id="pageRotateCw" class="secondaryToolbarButton rotateCw" title="Rotate Clockwise" tabindex="58" data-l10n-id="page_rotate_cw">
                                                <span data-l10n-id="page_rotate_cw_label">Rotate Clockwise</span>
                                            </button>
                                            <button id="pageRotateCcw" class="secondaryToolbarButton rotateCcw" title="Rotate Counterclockwise" tabindex="59" data-l10n-id="page_rotate_ccw">
                                                <span data-l10n-id="page_rotate_ccw_label">Rotate Counterclockwise</span>
                                            </button>

                                            <div class="horizontalToolbarSeparator"></div>

                                            <button id="cursorSelectTool" class="secondaryToolbarButton selectTool toggled" title="Enable Text Selection Tool" tabindex="60" data-l10n-id="cursor_text_select_tool">
                                                <span data-l10n-id="cursor_text_select_tool_label">Text Selection Tool</span>
                                            </button>
                                            <button id="cursorHandTool" class="secondaryToolbarButton handTool" title="Enable Hand Tool" tabindex="61" data-l10n-id="cursor_hand_tool">
                                                <span data-l10n-id="cursor_hand_tool_label">Hand Tool</span>
                                            </button>

                                            <div class="horizontalToolbarSeparator"></div>

                                            <button id="documentProperties" class="secondaryToolbarButton documentProperties" title="Document Properties…" tabindex="62" data-l10n-id="document_properties">
                                                <span data-l10n-id="document_properties_label">Document Properties…</span>
                                            </button>
                                        </div>
                                    </div>  <!-- secondaryToolbar -->

                                    <div class="toolbar">
                                        <div id="toolbarContainer">
                                            <div id="toolbarViewer">
                                                <div id="toolbarViewerLeft">
                                                    <button id="sidebarToggle" class="toolbarButton" title="Toggle Sidebar" tabindex="11" data-l10n-id="toggle_sidebar">
                                                        <span data-l10n-id="toggle_sidebar_label">Toggle Sidebar</span>
                                                    </button>
                                                    <div class="toolbarButtonSpacer"></div>
                                                    <button id="viewFind" class="toolbarButton" title="Find in Document" tabindex="12" data-l10n-id="findbar">
                                                        <span data-l10n-id="findbar_label">Find</span>
                                                    </button>
                                                    <div class="splitToolbarButton hiddenSmallView">
                                                        <button class="toolbarButton pageUp" title="Previous Page" id="previous" tabindex="13" data-l10n-id="previous">
                                                            <span data-l10n-id="previous_label">Previous</span>
                                                        </button>
                                                        <div class="splitToolbarButtonSeparator"></div>
                                                        <button class="toolbarButton pageDown" title="Next Page" id="next" tabindex="14" data-l10n-id="next">
                                                            <span data-l10n-id="next_label">Next</span>
                                                        </button>
                                                    </div>
                                                    <input type="number" id="pageNumber" class="toolbarField pageNumber" title="Page" value="1" size="4" min="1" tabindex="15" data-l10n-id="page">
                                                    <span id="numPages" class="toolbarLabel"></span>
                                                </div>
                                                <div id="toolbarViewerRight">
                                                    <button id="presentationMode" class="toolbarButton presentationMode hiddenLargeView" title="Switch to Presentation Mode" tabindex="31" data-l10n-id="presentation_mode">
                                                        <span data-l10n-id="presentation_mode_label">Presentation Mode</span>
                                                    </button>

                                                    <button id="openFile" class="toolbarButton openFile hiddenLargeView" title="Open File" tabindex="32" data-l10n-id="open_file">
                                                        <span data-l10n-id="open_file_label">Open</span>
                                                    </button>

                                                    <button id="print" class="toolbarButton print hiddenMediumView" title="Print" tabindex="33" data-l10n-id="print">
                                                        <span data-l10n-id="print_label">Print</span>
                                                    </button>

                                                    <button id="download" class="toolbarButton download hiddenMediumView" title="Download" tabindex="34" data-l10n-id="download">
                                                        <span data-l10n-id="download_label">Download</span>
                                                    </button>
                                                    <a href="#" id="viewBookmark" class="toolbarButton bookmark hiddenSmallView" title="Current view (copy or open in new window)" tabindex="35" data-l10n-id="bookmark">
                                                        <span data-l10n-id="bookmark_label">Current View</span>
                                                    </a>

                                                    <div class="verticalToolbarSeparator hiddenSmallView"></div>

                                                    <button id="secondaryToolbarToggle" class="toolbarButton" title="Tools" tabindex="36" data-l10n-id="tools">
                                                        <span data-l10n-id="tools_label">Tools</span>
                                                    </button>
                                                </div>
                                                <div id="toolbarViewerMiddle">
                                                    <div class="splitToolbarButton">
                                                        <button id="zoomOut" class="toolbarButton zoomOut" title="Zoom Out" tabindex="21" data-l10n-id="zoom_out">
                                                            <span data-l10n-id="zoom_out_label">Zoom Out</span>
                                                        </button>
                                                        <div class="splitToolbarButtonSeparator"></div>
                                                        <button id="zoomIn" class="toolbarButton zoomIn" title="Zoom In" tabindex="22" data-l10n-id="zoom_in">
                                                            <span data-l10n-id="zoom_in_label">Zoom In</span>
                                                        </button>
                                                    </div>
                                                    <span id="scaleSelectContainer" class="dropdownToolbarButton">
                                                      <select id="scaleSelect" title="Zoom" tabindex="23" data-l10n-id="zoom">
                                                        <option id="pageAutoOption" title="" value="auto" selected="selected" data-l10n-id="page_scale_auto">Automatic Zoom</option>
                                                        <option id="pageActualOption" title="" value="page-actual" data-l10n-id="page_scale_actual">Actual Size</option>
                                                        <option id="pageFitOption" title="" value="page-fit" data-l10n-id="page_scale_fit">Page Fit</option>
                                                        <option id="pageWidthOption" title="" value="page-width" data-l10n-id="page_scale_width">Page Width</option>
                                                        <option id="customScaleOption" title="" value="custom" disabled="disabled" hidden="true"></option>
                                                        <option title="" value="0.5" data-l10n-id="page_scale_percent" data-l10n-args='{ "scale": 50 }'>50%</option>
                                                        <option title="" value="0.75" data-l10n-id="page_scale_percent" data-l10n-args='{ "scale": 75 }'>75%</option>
                                                        <option title="" value="1" data-l10n-id="page_scale_percent" data-l10n-args='{ "scale": 100 }'>100%</option>
                                                        <option title="" value="1.25" data-l10n-id="page_scale_percent" data-l10n-args='{ "scale": 125 }'>125%</option>
                                                        <option title="" value="1.5" data-l10n-id="page_scale_percent" data-l10n-args='{ "scale": 150 }'>150%</option>
                                                        <option title="" value="2" data-l10n-id="page_scale_percent" data-l10n-args='{ "scale": 200 }'>200%</option>
                                                        <option title="" value="3" data-l10n-id="page_scale_percent" data-l10n-args='{ "scale": 300 }'>300%</option>
                                                        <option title="" value="4" data-l10n-id="page_scale_percent" data-l10n-args='{ "scale": 400 }'>400%</option>
                                                      </select>
                                                    </span>
                                                </div>
                                            </div>
                                            <div id="loadingBar">
                                                <div class="progress">
                                                    <div class="glimmer">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <menu type="context" id="viewerContextMenu">
                                        <menuitem id="contextFirstPage" label="First Page"
                                                  data-l10n-id="first_page"></menuitem>
                                        <menuitem id="contextLastPage" label="Last Page"
                                                  data-l10n-id="last_page"></menuitem>
                                        <menuitem id="contextPageRotateCw" label="Rotate Clockwise"
                                                  data-l10n-id="page_rotate_cw"></menuitem>
                                        <menuitem id="contextPageRotateCcw" label="Rotate Counter-Clockwise"
                                                  data-l10n-id="page_rotate_ccw"></menuitem>
                                    </menu>

                                    <div id="viewerContainer" tabindex="0">
                                        <div id="viewer" class="pdfViewer"></div>
                                    </div>

                                    <div id="errorWrapper" hidden='true'>
                                        <div id="errorMessageLeft">
                                            <span id="errorMessage"></span>
                                            <button id="errorShowMore" data-l10n-id="error_more_info">
                                                More Information
                                            </button>
                                            <button id="errorShowLess" data-l10n-id="error_less_info" hidden='true'>
                                                Less Information
                                            </button>
                                        </div>
                                        <div id="errorMessageRight">
                                            <button id="errorClose" data-l10n-id="error_close">
                                                Close
                                            </button>
                                        </div>
                                        <div class="clearBoth"></div>
                                        <textarea id="errorMoreInfo" hidden='true' readonly="readonly"></textarea>
                                    </div>
                                </div> <!-- mainContainer -->

                                <div id="overlayContainer" class="hidden">
                                    <div id="passwordOverlay" class="container hidden">
                                        <div class="dialog">
                                            <div class="row">
                                                <p id="passwordText" data-l10n-id="password_label">Enter the password to open this PDF file:</p>
                                            </div>
                                            <div class="row">
                                                <input type="password" id="password" class="toolbarField">
                                            </div>
                                            <div class="buttonRow">
                                                <button id="passwordCancel" class="overlayButton"><span data-l10n-id="password_cancel">Cancel</span></button>
                                                <button id="passwordSubmit" class="overlayButton"><span data-l10n-id="password_ok">OK</span></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="documentPropertiesOverlay" class="container hidden">
                                        <div class="dialog">
                                            <div class="row">
                                                <span data-l10n-id="document_properties_file_name">File name:</span> <p id="fileNameField">-</p>
                                            </div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_file_size">File size:</span> <p id="fileSizeField">-</p>
                                            </div>
                                            <div class="separator"></div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_title">Title:</span> <p id="titleField">-</p>
                                            </div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_author">Author:</span> <p id="authorField">-</p>
                                            </div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_subject">Subject:</span> <p id="subjectField">-</p>
                                            </div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_keywords">Keywords:</span> <p id="keywordsField">-</p>
                                            </div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_creation_date">Creation Date:</span> <p id="creationDateField">-</p>
                                            </div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_modification_date">Modification Date:</span> <p id="modificationDateField">-</p>
                                            </div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_creator">Creator:</span> <p id="creatorField">-</p>
                                            </div>
                                            <div class="separator"></div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_producer">PDF Producer:</span> <p id="producerField">-</p>
                                            </div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_version">PDF Version:</span> <p id="versionField">-</p>
                                            </div>
                                            <div class="row">
                                                <span data-l10n-id="document_properties_page_count">Page Count:</span> <p id="pageCountField">-</p>
                                            </div>
                                            <div class="buttonRow">
                                                <button id="documentPropertiesClose" class="overlayButton"><span data-l10n-id="document_properties_close">Close</span></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="printServiceOverlay" class="container hidden">
                                        <div class="dialog">
                                            <div class="row">
                                                <span data-l10n-id="print_progress_message">Preparing document for printing…</span>
                                            </div>
                                            <div class="row">
                                                <progress value="0" max="100"></progress>
                                                <span data-l10n-id="print_progress_percent" data-l10n-args='{ "progress": 0 }' class="relative-progress">0%</span>
                                            </div>
                                            <div class="buttonRow">
                                                <button id="printCancel" class="overlayButton"><span data-l10n-id="print_progress_close">Cancel</span></button>
                                            </div>
                                        </div>
                                    </div>
                                </div>  <!-- overlayContainer -->

                            </div> <!-- outerContainer -->

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
