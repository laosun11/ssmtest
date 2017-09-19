<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath", basePath);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script language="javascript"  src="${basePath}js/jquery.js" ></script>
<script language="javascript"  src="${basePath}js/aa.js" ></script>
<script language="javascript"  src="http://www.baidu.com" ></script>
</head>
<body>
<form id="searchForm" action="" method="post">
	<table>
<tr>
	<td>姓名</td>
	<td><input id="xm" name="xm" /></td>
</tr>
<tr>
	<td colspan="2">
		<input type="button" value="get" onclick="getshuaxin();"/>
		<input type="button" value="submit" onclick="subshuaxin();"/>
		<input type="button" value="load" onclick="loadshuaxin();"/>
		<input type="button" value="jsonp" onclick="jsonpcallback();"/>
		<input type="button" value="jsonp js调用" onclick="jscallback();"/>
		<input type="button" value="jsonp getjson调用" onclick="getJson();"/>
		<input type="button" value="jsonp ajax调用" onclick="ajaxjsonp();"/>
	</td>
</tr>
</table>
</form>
<aa:zone name="listzone">
<table id="load">
	<tr>
	   <td>id</td>
	   <td>xm</td>
	</tr>
	<c:forEach items="${list}" var="vo">
		<tr>
	   <td>${vo.id }</td>
	   <td>${vo.xm }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="2">
		<input type="button" value="增加" onclick="goadd();"/>
		</td>
	</tr>
</table>
</aa:zone>
--------------------
<aa:zone name="listzone1">
<table id="load">
	<tr>
	   <td>id</td>
	   <td>xm</td>
	</tr>
	<c:forEach items="${list}" var="vo">
		<tr>
	   <td>${vo.id }</td>
	   <td>${vo.xm }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="2">
		<input type="button" value="增加" onclick="goadd();"/>
		</td>
	</tr>
</table>
</aa:zone>
</body>
<script type="text/javascript">
var basepath="<%=basePath%>";
	function goadd(){
		window.open("user/goadd.do");
		console.info("aa");
	}
	
	function getshuaxin(){
		var ajaxanywhere=new AjaxAnywhere();
		ajaxanywhere.getAJAX(basepath+"user/list.do","listzone,listzone1");
		ajaxanywhere.onAfterResponseProcessing=function(){
			console.info("getanywhere is ok !!!");
		}
	}
	
	function subshuaxin(){
		var ajaxanywhere=new AjaxAnywhere();
		ajaxanywhere.formName="searchForm";
		ajaxanywhere.getZonesToReload = function(){
			return "listzone,listzone1";
		} 
		$("#searchForm").action=basepath+"user/list.do";
		ajaxanywhere.submitAJAX();
		ajaxanywhere.onAfterResponseProcessing=function(){
			console.info("submitajaxanywhere is ok !!!");
		}
	}
	
	function loadshuaxin(){
		var xm=$("#xm").val();
		 $("#load").load(basepath+"user/load.do", {xm: xm}, function(){
			 console.log("ok");
			 });
	}
	
	function jsonpcallback(){
		 $.ajax({
             type: "get",
             async: false,
             url: "http://127.0.0.1:8081/ajaxAnyWhereDemo/jsonptest",
             dataType: "jsonp",
             jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
//              jsonpCallback:"flightHandler",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
             success: function(json){
            	 console.log(json.flag);
             },
             error: function(){
                 alert('fail');
             }
         });
	}
	
	//回掉函数
	function fillcallback(result){
		alert(result.flag);
	}
	//创建script调用函数
	function jscallback(){
		//生成script
		var JSONP=document.createElement("script");  
	    JSONP.type="text/javascript";  
	    JSONP.src="http://127.0.0.1:8081/ajaxAnyWhereDemo/jsonptest?callback=fillcallback";  
	    document.getElementsByTagName("head")[0].appendChild(JSONP);  
	}
	
	
	//getJson
	function getJson(){
		$.getJSON("http://127.0.0.1:8081/ajaxAnyWhereDemo/jsonptest?callback=?",{"name":"zhangsan"},function(result){
			alert(result.flag);
		});
	}
</script>
</html>