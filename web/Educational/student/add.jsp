<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <script>
        var flag = false;
        $(function(){
            $("#stuno").blur(function(){
                var stuno = $(this).val();
                $.ajax({
                    url:"/Educational/student/stuOperation?method=validateStuNo",
                    data:"stuno="+stuno,
                    type:"get",
                    success: function(rs){
                        if(rs=='wrong'){
                            alert('学号无效！');
                            flag = false;
                        }else{
                            flag = true;
                        }
                    },
                    dataType: "text"
                });
            });

            $("#myForm").submit(function(){
                if(flag==false){
                    alert("学号已存在，请检查后重新输入！")
                }else{
                    return true;
                }
            });
        });

    </script>
</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》学生管理-》新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form id="myForm" action="/Educational/student/stuOperation?method=add" method="post">
	<table border="1" width="100%" class="table_a">
                <tr  width="120px;">
                    <td width="10%">学号<span style="color:red">*</span>：</td>
                    <td>
						<input type="text" id="stuno" name="stuno" value="" required/>
					</td>
                </tr>

                <tr  width="120px;">
                    <td>姓名<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuname" value="杨XX" required/>
					</td>
                </tr>
              
                <tr>
                    <td>班级<span style="color:red">*</span>：</td>
                    <td>
                        <select name="gid" required>
                            <c:forEach items="${grades}" var="g">
                                <option value="${g.gradeid}">${g.gradename}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>性别<span style="color:red">*</span>：</td>
                    <td>
                        <input type="radio" name="sex" checked value="1" />男
                        <input type="radio" name="gender" value="0"/>女
                    </td>
                </tr>

				<tr>
                    <td>EMAIL：</td>
                    <td>
                        <input type="text" name="email" value="1332@126.com" />
                    </td>                
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="phone" value="13333333333" />
                    </td>                
                </tr>

				<tr>
                    <td>户口所在地：</td>
                    <td>
                        <input type="text" name="registered" value="北京"  />
                    </td>                
                </tr>

				<tr>
                    <td>住址：</td>
                    <td>
                        <input type="text" name="address" value="朝阳" />
                    </td>                
                </tr>
				<tr>
                    <td>政治面貌：</td>
                    <td>
                        <input type="text" name="politics" value="党员" />
                    </td>                
                </tr>
				<tr>
                    <td>身份证号：</td>
                    <td>
                        <input type="text" name="idnumber" value="110111111111111111111" />
                    </td>                
                </tr>
				
				<tr>
                    <td>专业：</td>
                    <td>
                        <input type="text" name="profession" value="java" />
                    </td>                
                </tr>
					
				
				<tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="introduction" required>一个新开辟领域的探讨，探讨摸索</textarea>
                    </td>
                </tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="添加" /> 
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
