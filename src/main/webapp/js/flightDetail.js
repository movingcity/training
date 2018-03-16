$(function() {
	getData();
});

function funFlightManage() {
    var lStorage = window.localStorage;
    lStorage.removeItem("flightID");
    window.location.href = "FlightManage.html";
}

function getData() {
	var lStorage = window.localStorage;
	console.log(lStorage.getItem("flightID"));
	if(lStorage.getItem("flightID") != null) {
		$.ajax({
			type: "get",
			url: "/flight/selectOne",
			async: true,
			timeout: 10000,
			data: "id=" + lStorage.getItem("flightID"),
			dataType: "json",
			success: function(msg) {
				console.log(msg);
				$("#airl_code").val(msg.airl_code);
				$("#flt_number").val(msg.flt_number);
				$("#schd_date_time").val(decodeURIComponent(msg.schd_date_time).replace(" ", "T"));
				$("#arrvdept").val(msg.arrvdept);
				$("#acfttype").val(msg.acfttype);
				$("#flgttype").val(msg.flgttype);
				$("#reno").val(msg.reno);
				$("#domsintl").val(msg.domsintl);
				$("#actual_date_time").val(decodeURIComponent(msg.actual_date_time).replace(" ", "T"));
				$("#estimated_date_time").val(decodeURIComponent(msg.estimated_date_time).replace(" ", "T"));
				$("#terminal_code").val(msg.terminal_code);
				$("#user_code").val(msg.user_code);
				$("#stepNum1").val(msg.routes[0].step_number);
				$("#airpCode1").val(msg.routes[0].airp_Code);
				$("#stepNum2").val(msg.routes[1].step_number);
				$("#airpCode2").val(msg.routes[1].airp_Code);
			}
		});
	}
}

$(document).ready(function() {
	$("#frmFlightAdd").submit(function() {
		if(lStorage.getItem("flightID") != null) {
			//update
			$.ajax({
				type: "post",
				url: "/flight/update?id="+lStorage.getItem("flightID"),
				async: true,
				timeout: 10000,
				data: $("#frmFlightAdd").serialize(),
				success: function(msg) {
					console.log(msg);
					if(msg = 1)
						window.alert("更新成功");
				},
				error: function(msg) {
					console.log(msg);
				}
			});
		}else{
			//insert
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
		}
		setTimeout(function(){funFlightManage()},1000);
		return false;
	})
})