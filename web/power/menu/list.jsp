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
    <script src="../../Script/jBox/jquery-1.8.0.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>
    <script src="../../Script/myJs.js"></script>
    <script>
	function del(){
		confirm("确认删除？");
	}

    </script>
    <script>
        $(function(){
            $("#go").click(function (){
                var index = $("#pageSearch").val();
                index = (index==null || index=="") ? 1 : parseInt(index);
                index = isNaN(index) ? 1 : index;
                index = index<1 ? 1 : index;
                index = index>${p4.totalPages} ? ${p4.totalPages} : index;
                location.href = '/power/menu/menuOperation?method=getAll&index=' + index;
            });

            $("#dellink").click(function(){
                if(confirm("确认批量删除？")){
                    $("#myForm").submit();
                }
            });
        });
    </script>
</head>
<body>

   
<form id="myForm" action="/power/menu/menuOperation?method=deleteBatch" method="post">
<div class="div_head" style="width: 100%;text-align:center;">
		<span> <span style="float:left">当前位置是：权限管理-》菜单管理</span> <span
			style="float:right;margin-right: 8px;font-weight: bold">
            <a id="dellink" style="text-decoration: none;" href="#">【批量删除】</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a style="text-decoration: none;" href="/power/menu/menuOperation?method=selectUpMenus&next=add">【新增菜单】</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</span>
		</span>
	</div>


<div class="morebt">
 
</div>


 <div class="cztable">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tbody>
                <tr style="height: 25px" align="center">
                	<th><input type="checkbox" name="all"/></th>
                    <th scope="col">
                        序号
                    </th>
                    
                    <th scope="col">
                        菜单名称
                    </th>
                    <th scope="col">
                        URL
                    </th>
                    <th scope="col">
                        状态
                    </th>
                    <th scope="col">
                        操作
                    </th>
                </tr>


                <c:forEach items="${p4.dataList}" var="menu" varStatus="sta">
                    <tr align="center">
                        <th><input type="checkbox" name="one" value="${menu.menuid}"/></th>
                        <td>
                            ${sta.count}
                        </td>
                        <td>${menu.menuname}</td>
                        <td>
                            <a href="">${menu.url}</a>
                        </td>

                        <td>&nbsp;
                            ${menu.state==1?'启用':'禁用'}
                        </td>

                        <td>&nbsp;
                            <a href="/power/menu/menuOperation?method=selectUpMenus&next=info&menuid=${menu.menuid}">详情</a>
                            <a href="/power/menu/menuOperation?method=selectUpMenus&next=edit&menuid=${menu.menuid}">修改</a>
                            <a href="/power/menu/menuOperation?method=delete&menuid=${menu.menuid}" onclick="return del();" class="tablelink"> 删除</a>
                        </td>
                    </tr>
                </c:forEach>
                
            </tbody>
        </table>

     <div class='MainStyle'>
         <div class=''><a href='/power/menu/menuOperation?method=getAll&index=1' target='_self'>首页</a>
         </div>
         <div class=''><a href='/power/menu/menuOperation?method=getAll&index=${p4.pageIndex-1<1 ? 1 : p4.pageIndex-1}' target='_self'>上一页</a></div>

         <c:forEach begin="1" end="${p4.totalPages}" var="i">
             <div class=${i==p4.pageIndex ? 'NowItemStyle' : ''}>
                 <a href='/power/menu/menuOperation?method=getAll&index=${i}' target='_self'>${i}</a>
             </div>
         </c:forEach>

         <div class=''><a href='/power/menu/menuOperation?method=getAll&index=${p4.pageIndex+1>p4.totalPages ? p4.totalPages : p4.pageIndex+1}' target='_self'>下一页</a>
         </div>
         <div class=''><a href='/power/menu/menuOperation?method=getAll&index=${p4.totalPages}' target='_self'>尾页</a>
         </div>
         <div class=''>总共<b>${p4.total}</b>条数据</div>
         <div class=''>每页<b>${p4.pageSize}</b>条数据</div>
         <div class=''><b>${p4.pageIndex}</b>/${p4.totalPages}</div>
         <div class='SearchStyle'><input type='text' id='pageSearch'/></div>
         <div class=''><input id='go' type='button' value='Go'/></div>
     </div>

 </div>

</form>
</body>
</html>