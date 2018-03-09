var tbodySelectAll;

function funCalendarSelectAll() {

	$.ajax({
		type: "get",
		url: "/calendarSelectAllFromFastJson",
		async: true,
		timeout: 10000,
		data: "whichNum=" + 1,
		dataType: "json",
		success: function(msg) {
			console.log(msg);
			tbodySelectAll = "";
			for(var i = 0; i < msg.length; i++) {
				tbodySelectAll += "<tr class='info'>";
				tbodySelectAll += "<td>";
				tbodySelectAll += msg[i].title == null ? "---" : msg[i].title;
				tbodySelectAll += "</td>";
				tbodySelectAll += "<td>";
				tbodySelectAll += msg[i].content == null ? "---" : msg[i].content;
				tbodySelectAll += "</td>";
				tbodySelectAll += "<td>";
				tbodySelectAll += msg[i].importance == null ? "---" : msg[i].importance;
				tbodySelectAll += "</td>";
				tbodySelectAll += "<td>";
				tbodySelectAll += msg[i].ifOK == 1 ? "是" : "否";
				tbodySelectAll += "</td>";
				tbodySelectAll += "<td>";
				tbodySelectAll += msg[i].finishDate == null ? "---" : msg[i].finishDate;
				tbodySelectAll += "</td>";
				tbodySelectAll += "<td>";
				tbodySelectAll += "<a href='javascript:void(0)' onclick=funCalendarUpdate()>更新</a>";
				tbodySelectAll += "</td>";
				tbodySelectAll += "<td>";
				tbodySelectAll += "<a href='javascript:void(0)' onclick=funCalendarDelete()>删除</a>";
				tbodySelectAll += "</td>";
				tbodySelectAll += "</tr>";
				$("#tbodySelectAll").html(tbodySelectAll);
			}
		},
		error: function(msg) {
			console.log(msg);
		}
	});
}
$(document).ready(function() {
	$("#btnSelectAll").click(function() {
		funCalendarSelectAll();

	});
})
function funCalendarUpdate() {

	$.ajax({
		type: "get",
		url: "/calendarUpdate",
		async: true,
		timeout: 10000,
		data: "whichNum=" + 1,
		dataType: "json",
		success: function(msg) {
			console.log(msg);
			
			}
		},
		error: function(msg) {
			console.log(msg);
		}
	});
}