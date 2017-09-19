<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>增加</title>
<script language="javascript"  src="${basePath}js/jquery.js" ></script>
<script language="javascript"  src="${basePath}js/json2.js" ></script>
<script>
var baseUrl="${basePath}";
$.fn.serializeObject = function()    
{    
   var o = {};    
   var a = this.serializeArray();    
   $.each(a, function() {    
       if (o[this.name]) {    
           if (!o[this.name].push) {    
               o[this.name] = [o[this.name]];    
           }    
           o[this.name].push(this.value || '');    
       } else {    
           o[this.name] = this.value || '';    
       }    
   });    
   return o;    
}; 
	function save(){
		var jsonuserinfo = $('#saveform').serializeObject();
		$.ajax({
		   type: "POST",
		   url: baseUrl+"user/save.do",
		   data: JSON.stringify(jsonuserinfo),
		   dataType:"json",
		   contentType: "application/json;charset=utf-8",
		   success: function(msg){
			   alert(msg);
		   }
		});
// 		console.log(11);
	}
</script>
</head>
<body>
	<form action="user/save" id="saveform" method="post">
	
		<table>
			<tr>
			   <td>id</td>
			   <td><input name="id" id="id"/></td>
			</tr>
			<tr>
			   <td>name</td>
			   <td><input name="xm" id="xm"/></td>
			</tr>
			<tr>
				<td colspan="2">
				   <input type="button" value="保存" onclick="save();"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>