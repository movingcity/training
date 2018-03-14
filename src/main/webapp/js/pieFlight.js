var option1;
var myChart1;
$(document).ready(function() {
	$("#btnGet1").click(function() {
		// 为echarts对象加载数据 
		myChart1.setOption(option1);
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
		'echarts/chart/pie' // 使用柱状图就加载pie模块，按需加载
	],
	function(ec) {
		// 基于准备好的dom，初始化echarts图表
		myChart1 = ec.init(document.getElementById('main1'));

		option1 = {
			tooltip: {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
			legend: {
				orient: 'horizontal',
				left: 'left',
				data: ['2017年10月', '2017年11月', '2017年12月', '2018年1月', '2018年2月', '2018年3月']
			},
			series: [{
				name: '月航班延误班次',
				type: 'pie',
				radius: '55%',
				center: ['50%', '60%'],
				data: [{
						value: 335,
						name: '2017年10月'
					},
					{
						value: 310,
						name: '2017年11月'
					},
					{
						value: 234,
						name: '2017年12月'
					},
					{
						value: 135,
						name: '2018年1月'
					},
					{
						value: 548,
						name: '2018年2月'
					},
					{
						value: 648,
						name: '2018年3月'
					}
				],
				itemStyle: {
					emphasis: {
						shadowBlur: 10,
						shadowOffsetX: 0,
						shadowColor: 'rgba(0, 0, 0, 0.5)'
					}
				}
			}]
		};

	}
);