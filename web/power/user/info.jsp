<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
    
    
</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：权限管理-》人员管理-》详情</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="javascript:history.back();">【返回】</a>
                </span>
            </span>
        </div>
</div>
<div class="cztable">
	<form action="list.jsp" method="post">
<table border="1" width="100%" class="table_a">
                <tr  width="120px;">
                    <td width="120px">用户名：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="f_goods_image" value="${users.loginname}" readonly/>
					</td>
                </tr>

				<tr  width="120px;">
                    <td>密码：<span style="color:red">*</span>：</td>
                    <td>
						<input type="password"  name="f_goods_image" value="${users.password}" readonly/>
					</td>
                </tr>

                <tr  width="120px;">
                    <td>姓名<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="f_goods_image" value="${users.realname}" readonly/>
					</td>
                </tr>
                <tr>
                    <td>性别<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="gender" ${users.sex==1?'checked':''} value="1" onclick="return false;"/>男
                        <input type="radio" name="gender" ${users.sex==0?'checked':''} value="0" onclick="return false;"/>女
                    </td>
                </tr>

				<tr>
                    <td>角色：<span style="color:red">*</span>：</td>
                    <td>
                        <select>
                            <c:forEach items="${roleList}" var="r">
                                <option value="${r.roleid}" ${users.role.roleid==r.roleid?'selected':''} onclick="return false;">${r.rolename}</option>
                            </c:forEach>
						</select>
                    </td>
                </tr>

				<tr>
                    <td>EMAIL：</td>
                    <td>
                        <input type="text" name="f_goods_image" value="${users.email}" readonly/>
                    </td>                
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="f_goods_image" value="${users.phone}" readonly/>
                    </td>                
                </tr>

				<tr>
                    <td>住址：</td>
                    <td>
                        <input type="text" name="f_goods_image" value="${users.address}" readonly/>
                    </td>                
                </tr>
				</tr>
				<tr>
                    <td>身份证号：</td>
                    <td>
                        <input type="text" name="f_goods_image" value="${users.cardid}" readonly/>
                    </td>                
                </tr>
				
				
				<tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea readonly>${users.desc}</textarea>
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
