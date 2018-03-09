$(document).ready(function() {
	//insert
	$("#frmFlightAdd").submit(function() {
		$.ajax({
			type: "post",
			url: "/flight/insert",
			async: true,
			timeout: 10000,
			data: $("#frmFlightAdd").serialize(),
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
})