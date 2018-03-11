var tbodySelectAll;

function queryParams(params) {
    return params
}

function funFlightSelectAll() {

    var url = '/flight/selectAll';
    $('#table').bootstrapTable({
        method: 'get',
        url: url,
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
            }]
    });

}

$(document).ready(function () {
    //Select all at page loaded
    funFlightSelectAll();

    $("#btnSelectAll").click(function () {
        funFlightSelectAll();
    });
    $(window).resize(function () {
        $('#table').bootstrapTable('resetView');
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
        window.location.href = "FlightDetail.html?id=" + row.id;
    },
    'click .remove': function (e, value, row, index) {

        $.ajax({
            type: "post",
            url: "/flight/deleteById?id=" + row.id,
            async: true,
            timeout: 10000,
            data: "id=" + row.id,
            success: function (msg) {
                console.log(msg);
                if (msg = 1)
                    window.alert("删除成功");
                $('#table').bootstrapTable('refresh');
            },
            error: function (msg) {
                console.log(msg);
                window.alert("删除失败" + msg.responseJSON.message);
            }
        });
    }
};