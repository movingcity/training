var tbody;

$(document).ready(function () {
    $("#detail_div").attr("style", "display:none;");
    fillData();
    $("#aAdd").click(function () {
        funUserInsert();
    });
});

function fillData() {
    tbody = "";
    var msg = [
        {"id": "0", "username": "user00", "locked": "0"},
        {"id": "1", "username": "user01", "locked": "0"},
        {"id": "2", "username": "user02", "locked": "1"},
        {"id": "3", "username": "user03", "locked": "1"},
        {"id": "4", "username": "user04", "locked": "0"},
        {"id": "5", "username": "user05", "locked": "0"}
    ];
    for (var i = 0; i < msg.length; i++) {
        tbody += "<tr>";
        tbody += "<td>";
        tbody += msg[i].id;
        tbody += "</td>";
        tbody += "<td>";
        tbody += msg[i].username;
        tbody += "</td>";
        tbody += "<td>";
        tbody += msg[i].locked == 1 ? "是" : "否";
        tbody += "</td>";
        tbody += "<td>";
        tbody += "<a href='javascript:void(0)' onclick=funUserUpdate(" + msg[i] + ")>更新</ a>";
        tbody += "</td>";
        tbody += "<td>";
        tbody += "<a href='javascript:void(0)' onclick=funUserDelete(" + msg[i].id + ")>删除</a>";
        tbody += "</td>";
        tbody += "</tr>";
        $("#tbody").html(tbody);
    }
}

function funUserUpdate() {
    $("#detail_div").attr("style", "display:block;");
    $("#expand").click();
}

function funUserInsert() {
    $("#detail_div").attr("style", "display:block;");
    $("#expand").click();
}

function funUserDelete(id) {
    var msg = "您真的确定要删除吗？" + id;
    if (confirm(msg) === true) {
        // 调用删除
        $.ajax({
            type: "post",
            url: "/deleteUser",
            async: true,
            timeout: 10000,
            data: "id=" + 1,
            dataType: "json",
            success: function (msg) {
                console.log(msg);
            },
            error: function (msg) {
                console.log(msg);
            }
        });
    } else {
        return false;
    }
}

window.operateEvents = {};