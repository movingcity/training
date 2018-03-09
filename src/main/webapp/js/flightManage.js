var tbodySelectAll;

function funFlightSelectAll() {

    $.ajax({
        type: "get",
        url: "/flight/selectAll",
        async: true,
        timeout: 10000,
        data: "whichNum=" + 1,
        dataType: "json",
        success: function (msg) {
            console.log(msg);
            $('#table').bootstrapTable({
                columns: [{
                    field: 'flt_number',
                    title: '航班号'
                }, {
                    field: 'airl_code',
                    title: '航空公司'
                }, {
                    field: 'schd_date_time',
                    title: '计划时间'
                }, {
                    field: 'arrvdept',
                    title: '到港/离港'
                }, {
                    field: 'domsintl',
                    title: '国际/国内'
                },
                    {
                        field: 'operate',
                        title: '操作',
                        align: 'center',
                        events: operateEvents,
                        formatter: operateFormatter
                    }],
                data: msg
            });
            // tbodySelectAll = "";
            // for(var i = 0; i < msg.length; i++) {
            // 	tbodySelectAll += "<tr class='info'>";
            // 	tbodySelectAll += "<td>";
            // 	tbodySelectAll += msg[i].flt_number == null ? "---" : msg[i].flt_number;
            // 	tbodySelectAll += "</td>";
            // 	tbodySelectAll += "<td>";
            // 	tbodySelectAll += msg[i].airl_code == null ? "---" : msg[i].airl_code;
            // 	tbodySelectAll += "</td>";
            // 	tbodySelectAll += "<td>";
            // 	tbodySelectAll += msg[i].schd_date_time == null ? "---" : msg[i].schd_date_time;
            // 	tbodySelectAll += "</td>";
            // 	tbodySelectAll += "<td>";
            // 	tbodySelectAll += msg[i].arrvdept == "A" ? "到港" : "离港";
            // 	tbodySelectAll += "</td>";
            // 	tbodySelectAll += "<td>";
            // 	tbodySelectAll += msg[i].domsintl == null ? "---" : msg[i].domsintl;
            // 	tbodySelectAll += "</td>";
            // 	tbodySelectAll += "<td>";
            // 	tbodySelectAll += "<a href='javascript:void(0)' onclick=funFlightUpdate()>更新</a>";
            // 	tbodySelectAll += "</td>";
            // 	tbodySelectAll += "<td>";
            // 	tbodySelectAll += "<a href='javascript:void(0)' onclick=funFlightDelete()>删除</a>";
            // 	tbodySelectAll += "</td>";
            // 	tbodySelectAll += "</tr>";
            // 	$("#tbodySelectAll").html(tbodySelectAll);
            // }
        },
        error: function (msg) {
            console.log(msg);
        }
    });
}

$(document).ready(function () {
    //Select all at page loaded
    funFlightSelectAll();

    $("#btnSelectAll").click(function () {
        funFlightSelectAll();

    });
})


function operateFormatter(value, row, index) {
    return [
        '<a class="detail" href="javascript:void(0)" title="详细">',
        '<i class="glyphicon glyphicon-new-window"></i>',
        '</a>  ',
        '<a class="remove" href="javascript:void(0)" title="删除">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}

window.operateEvents = {
    'click .detail': function (e, value, row, index) {
        window.location.href="FlightDetail.html?id="+ row.id;
    },
    'click .remove': function (e, value, row, index) {

        $.ajax({
            type: "post",
            url: "/flight/deleteById?id="+ row.id,
            async: true,
            timeout: 10000,
            data: "id="+ row.id,
            success: function(msg) {
                console.log(msg);
                if(msg = 1)
                    window.alert("删除成功");
                funFlightSelectAll();
            },
            error: function(msg) {
                console.log(msg);
                window.alert("删除失败" + msg.responseJSON.message);
            }
        });
    }
};