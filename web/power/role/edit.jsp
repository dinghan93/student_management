<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>
        学生信息管理平台
    </title>
    <link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css"/>
    <link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css"/>
    <link href="../../Style/ks.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.8.0.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
    <script src="../../Script/Menu.js"></script>

</head>
<body>

<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》考试-》新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="javascript:history.back();">【返回】</a>
                </span>
            </span>
</div>
</div>
<div class="cztable">
    <form action="/power/role/roleOperation?method=submitUpdate" method="post">
        <input type="hidden" name="roleid" value="${role.roleid}"/>
        <table border="1" width="100%" class="table_a">
            <tr width="120px;">
                <td width="120px">角色名：<span style="color:red">*</span>：</td>
                <td>
                    <input type="text" name="rolename" value="${role.rolename}"/>
                </td>
            </tr>

            <tr width="120px;">
                <td>菜单资源<span style="color:red">*</span>：</td>
                <td>
                    <ul>
                        <c:forEach items="${menuList}" var="m">
                            <li>
                                <c:set var="flag" value="false"></c:set>
                                <c:forEach items="${role.menuList}" var="ml">
                                    <c:if test="${ml.menuid==m.menuid}">
                                        <c:set var="flag" value="true"></c:set>
                                    </c:if>
                                </c:forEach>
                                <input type="checkbox" ${flag==true?'checked':''} name="menuid" class="pMenu"
                                       value="${m.menuid}"/>${m.menuname}
                                <ul>
                                    <c:forEach items="${m.subMenus}" var="sub">
                                        <c:set var="flag" value="false"></c:set>
                                        <c:forEach items="${role.menuList}" var="ml">
                                            <c:if test="${ml.menuid==sub.menuid}">
                                                <c:set var="flag" value="true"></c:set>
                                            </c:if>
                                        </c:forEach>
                                        <li>&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" ${flag==true?'checked':''}
                                                                           name="menuid" class="sMenu"
                                                                           value="${sub.menuid}"/>${sub.menuname}</li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>

            <tr>
                <td>启用状态<span style="color:red">*</span>：</td>
                <td>
                    <input type="radio" name="rolestate" ${role.rolestate==1?'checked':''} value="1"/>启用 <input
                        type="radio" name="rolestate" ${role.rolestate==0?'checked':''} value="0"/>禁用
                </td>
            </tr>


            <tr width="120px">
                <td colspan="2" align="center">
                    <input type="submit" value="修改"/>
                </td>
            </tr>
        </table>
    </form>
</div>

</div>
</div>

</div>
</body>
</html>
