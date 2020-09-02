<template>
	<div ref="chartdiv" class="chartdiv"></div>
</template>

<script>
/* Imports */
import * as am4core from '@amcharts/amcharts4/core';
import * as am4charts from '@amcharts/amcharts4/charts';
import am4themes_animated from '@amcharts/amcharts4/themes/animated';
am4core.useTheme(am4themes_animated);
export default {
	data() {
		return {
			chart: '',
		};
	},
	mounted() {
		// Create chart instance
		this.chart = am4core.create(this.$refs.chartdiv, am4charts.XYChart);

		//

		// Increase contrast by taking evey second color
		this.chart.colors.step = 2;

		// Add data
		this.chart.data = this.generateChartData();

		// Create axes
		let dateAxis = this.chart.xAxes.push(new am4charts.DateAxis());
		dateAxis.renderer.minGridDistance = 50;
		this.createAxisAndSeries('visits', 'Visits', false, 'circle');
		this.createAxisAndSeries('views', 'Views', true, 'triangle');
		this.createAxisAndSeries('hits', 'Hits', true, 'rectangle');

		// Add legend
		this.chart.legend = new am4charts.Legend();

		// Add cursor
		this.chart.cursor = new am4charts.XYCursor();
	},
	methods: {
		createAxisAndSeries(field, name, opposite, bullet) {
			let valueAxis = this.chart.yAxes.push(new am4charts.ValueAxis());
			if (this.chart.yAxes.indexOf(valueAxis) != 0) {
				valueAxis.syncWithAxis = this.chart.yAxes.getIndex(0);
			}

			let series = this.chart.series.push(new am4charts.LineSeries());
			series.dataFields.valueY = field;
			series.dataFields.dateX = 'date';
			series.strokeWidth = 2;
			series.yAxis = valueAxis;
			series.name = name;
			series.tooltipText = '{name}: [bold]{valueY}[/]';
			series.tensionX = 0.8;
			series.showOnInit = true;

			let interfaceColors = new am4core.InterfaceColorSet();

			switch (bullet) {
				case 'triangle': {
					bullet = series.bullets.push(new am4charts.Bullet());
					bullet.width = 12;
					bullet.height = 12;
					bullet.horizontalCenter = 'middle';
					bullet.verticalCenter = 'middle';
					let triangle = bullet.createChild(am4core.Triangle);
					triangle.stroke = interfaceColors.getFor('background');
					triangle.strokeWidth = 2;
					triangle.direction = 'top';
					triangle.width = 12;
					triangle.height = 12;
					break;
				}
				case 'rectangle': {
					bullet = series.bullets.push(new am4charts.Bullet());
					bullet.width = 10;
					bullet.height = 10;
					bullet.horizontalCenter = 'middle';
					bullet.verticalCenter = 'middle';
					let rectangle = bullet.createChild(am4core.Rectangle);
					rectangle.stroke = interfaceColors.getFor('background');
					rectangle.strokeWidth = 2;
					rectangle.width = 10;
					rectangle.height = 10;
					break;
				}
				default:
					bullet = series.bullets.push(new am4charts.CircleBullet());
					bullet.circle.stroke = interfaceColors.getFor('background');
					bullet.circle.strokeWidth = 2;
					break;
			}

			valueAxis.renderer.line.strokeOpacity = 1;
			valueAxis.renderer.line.strokeWidth = 2;
			valueAxis.renderer.line.stroke = series.stroke;
			valueAxis.renderer.labels.template.fill = series.stroke;
			valueAxis.renderer.opposite = opposite;
		},
		generateChartData() {
			let chartData = [];
			let firstDate = new Date();
			firstDate.setDate(firstDate.getDate() - 100);
			firstDate.setHours(0, 0, 0, 0);

			let visits = 1600;
			let hits = 2900;
			let views = 8700;

			for (var i = 0; i < 15; i++) {
				// we create date objects here. In your data, you can have date strings
				// and then set format of your dates using chart.dataDateFormat property,
				// however when possible, use date objects, as this will speed up chart rendering.
				let newDate = new Date(firstDate);
				newDate.setDate(newDate.getDate() + i);

				visits += Math.round(
					(Math.random() < 0.5 ? 1 : -1) * Math.random() * 10,
				);
				hits += Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 10);
				views += Math.round(
					(Math.random() < 0.5 ? 1 : -1) * Math.random() * 10,
				);

				chartData.push({
					date: newDate,
					visits: visits,
					hits: hits,
					views: views,
				});
			}
			return chartData;
		},
	},
};
</script>

<style>
.chartdiv {
	width: 100%;
	height: 500px;
}
</style>
