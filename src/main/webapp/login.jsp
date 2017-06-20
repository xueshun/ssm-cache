<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center"><button class="btn" id="huode">获取数据</button></div>
	<div align="center"><button class="btn" id="yichu">获取数据</button></div>
	<table id="list" align="center" width="50%" border="1px solid gray" style="margin-top: 20px">
		<thead>
			<tr>
				<th width="30%">编号</th>
				<th>姓名</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<script type="text/javascript" src="jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#huode").bind("click", function() {
				$.ajax({
					url: "user/list.do",
					type: "post",
					data: {"id":1},
					success: function(data) {
						var html = "";
						var list = data;
						for (var i = 0; i < list.length; i++) {
							var item = list[i];
							var d = item.birthday;
							html += "<tr>";
							html += "<td>" + item.id + "</td>";
							html += "<td>" + item.name + "</td>";
							html += "<tr>";
						}
						$("#list tbody").html(html);
					}
				});
			});
		});
		
		$(function() {
			$("#yichu").bind("click", function() {
				$.ajax({
					url: "user/removeCache",
					type: "post",
					success: function(data) {
						alert(data)
					}
				});
			});
		});
	</script>
</body>
</html>