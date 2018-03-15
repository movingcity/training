var tbody;

function queryParams(params) {
    return params
}


function funUserSelectAll() {

    var url = '/user/selectAll';
    $('#table').bootstrapTable({
        method: 'get',
        cache: false,
        striped: true,
        pagination: true,
        pageList: [10, 20],
        pageSize: 10,
        pageNumber: 1,
        search: true,
        sidePagination: 'server',//设置为服务器端分页
        queryParams: queryParams,//参数
        showColumns: true,
        showRefresh: true,
        minimumCountColumns: 2,
        clickToSelect: true,
        smartDisplay: true,
        formatNoMatches: function () {
            return '无符合条件的记录';
        },
        columns: [{
            field: 'username',
            title: '用户名'
        }, {
            field: 'locked',
            title: '锁定？'
        },
            {
                field: 'operate',
                title: '操作',
                align: 'center',
                events: operateEvents,
                formatter: operateFormatter
            }]
    });

}

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
        {"id": "0","username": "user00", "locked": "0"},
        {"id": "1","username": "user01", "locked": "0"},
        {"id": "2","username": "user02", "locked": "1"},
        {"id": "3","username": "user03", "locked": "1"},
        {"id": "4","username": "user04", "locked": "0"},
        {"id": "5","username": "user05", "locked": "0"}
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
        tbody += "<a href='javascript:void(0)' onclick=funUserUpdate(" + msg[i].id + ")>更新</ a>";
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

window.operateEvents = {

};