var option;
var myChart;
$(document).ready(function() {
	$("#btnGet").click(function() {
		option.series[0].data[0] = 55222;
		// 为echarts对象加载数据 
		myChart.setOption(option);
	});
});

// 路径配置
require.config({
	paths: {
		echarts: 'http://echarts.baidu.com/build/dist'
	}
});
// 加载使用
// 使用
require(
	[
		'echarts',
		'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
	],
	function(ec) {
		// 基于准备好的dom，初始化echarts图表
		myChart = ec.init(document.getElementById('main'));

		option = {
			tooltip: {
				show: true
			},
			legend: {
				data: ['月航班数量统计']
			},
			xAxis: [{
				type: 'category',
				data: ["2017年10月", "2017年11月", "2017年12月", "2018年1月", "2018年2月", "2018年3月"]
			}],
			yAxis: [{
				type: 'value'
			}],
			series: [{
				"name": "月航班数量统计",
				"type": "bar",
				"data": [55222, 53411, 56677, 55432, 57213, 58921]
			}]
		};

	}
);