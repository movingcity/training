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
		},
		error: function(msg) {
			console.log(msg);
		}
	});
}

$(document).ready(function() {
	//insert
	$("#frmCalendar").submit(function() {
		console.log($("#frmCalendar").serialize());
		$.ajax({
			type: "post",
			url: "/calendarInsert",
			async: true,
			timeout: 10000,
			data: $("#frmCalendar").serialize(),
			success: function(msg) {
				console.log(msg);
				if(msg = 1)
					window.alert("添加成功");
			},
			error: function(msg) {
				console.log(msg);
			}
		});
		return false;
	})
	funCalendarSelectAll();
})