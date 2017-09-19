<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
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

