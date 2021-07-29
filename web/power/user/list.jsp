<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.8.0.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
    <script src="../../Script/myJs.js" type="text/javascript"></script>
    <script>
		function del(){
			confirm("确定删除？");
		}
	</script>

</head>
<body>


<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：权限管理-》人员管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
          
            <a style="text-decoration: none;" href="javascript:alert('操作成功！');">【批量删除】</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a style="text-decoration: none;" href="/power/user/usersOperation?method=showRoleList">【新增人员】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>

<div class="morebt">
 
</div>
 <div class="cztable" style="width: 100%;">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px;" align="center">
                    
                    <th  width="8%">
						<input type="checkbox" name="all"/>
					</th>
					<th scope="col" width="15%">
                        序号
                    </th>
                    <th scope="col" width="15%">
                        账号
                    </th>
                    <th scope="col" width="15%">
                        姓名
                    </th>
                    <th scope="col" width="15%">
                        角色
                    </th>
                   
                    <th scope="col" >
                        操作
                    </th>
                </tr>
                
               
                <c:forEach items="${p2.dataList}" var="u" varStatus="sta">
                    <tr align="center">
                        <th><input type="checkbox" name="one"/></th>
                        <td>
                            ${sta.count}
                        </td>

                        <td>
                            ${u.loginname}
                        </td>
                        <td>
                            <a href="info.jsp">${u.realname}</a>
                        </td>

                        <td>&nbsp;
                            ${u.role.rolename}
                        </td>

                        <td>&nbsp;
                            <a href="edit.jsp">修改</a>
                            <a href="javascript:void(0)" onclick="del();return false" class="tablelink"> 删除</a>
                        </td>
                    </tr>
                </c:forEach>
                
            </tbody>
        </table>
        
          <div class='MainStyle'>
              <div class=''>
                  <a href='/power/user/usersOperation?method=getAll&index=1' target='_self'>首页</a>
              </div>
              <div class=''>
                  <a href='/power/user/usersOperation?method=getAll&index=${p2.pageIndex-1<1 ? 1 : p2.pageIndex-1}' target='_self'>上一页</a>
              </div>
              <c:forEach begin="1" end="${p2.totalPages}" var="i" step="1">
                  <div class= ${i==p2.pageIndex ? 'NowItemStyle' : ''}>
                      <a href='/power/user/usersOperation?method=getAll&index=${i}' target='_self'>${i}</a>
                  </div>
              </c:forEach>
              <div class=''>
                  <a href='/power/user/usersOperation?method=getAll&index=${p2.pageIndex+1>p2.totalPages ? p2.totalPages : p2.pageIndex+1}' target='_self'>下一页</a>
              </div>
              <div class=''>
                  <a href='/power/user/usersOperation?method=getAll&index=${p2.totalPages}' target='_self'>尾页</a>
              </div>
              <div class=''>总共<b>${p2.total}</b>条数据</div>
              <div class=''>每页<b>${p2.pageSize}</b>条数据</div>
              <div class=''><b>${p2.pageIndex}</b>/${p2.totalPages}</div>
              <div class='SearchStyle'>
                  <input type='text' id='john_Page_Search' onkeydown="if(event.keyCode == 13){page_searchIndex();}"/>
              </div>
              <div class=''>
                  <input type='button' value='Go' onclick="page_searchIndex()"/></div>
          </div>
     <script>    function page_searchIndex(){        var searchText = document.getElementById('john_Page_Search');        var searchIndex = searchText != null && searchText.value != '' ? parseInt(searchText.value) : 0;        if(searchIndex > 0 && searchIndex <= 3) {             window.location='StudentMaterial.aspx?page=' + searchIndex;        }        else        {            alert('需要跳转的页码不能超出范围！');        }    }</script>
        </div>
    </div>

        
        
      
    </div>
</body>
</html>