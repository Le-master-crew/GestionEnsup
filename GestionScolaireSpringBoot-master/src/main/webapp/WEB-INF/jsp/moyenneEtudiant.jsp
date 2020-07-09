<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="css/styleGraph.css">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Moyenne étudiants</title>
</head>
<body>
<div class="container">
  <h2>Graphique des moyennes des étudiants<h2>
  <div>
    <canvas id="canvas"></canvas>
  </div>
</div>


</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>

<script>
var lineChartData = {
	    labels: ["Data 1", "Data 2", "Data 3", "Data 4", "Data 5", "Data 6", "Data 7"],
	    datasets: [{
	        fillColor: "rgba(220,220,220,0)",
	        strokeColor: "rgba(220,180,0,1)",
	        pointColor: "rgba(220,180,0,1)",
	        data: [20, 30, 80, 20, 40, 10, 60]
	    }, {
	        fillColor: "rgba(151,187,205,0)",
	        strokeColor: "rgba(151,187,205,1)",
	        pointColor: "rgba(151,187,205,1)",
	        data: [60, 10, 40, 30, 80, 30, 20]
	    }]

	}

	Chart.defaults.global.animationSteps = 50;
	Chart.defaults.global.tooltipYPadding = 16;
	Chart.defaults.global.tooltipCornerRadius = 0;
	Chart.defaults.global.tooltipTitleFontStyle = "normal";
	Chart.defaults.global.tooltipFillColor = "rgba(0,160,0,0.8)";
	Chart.defaults.global.animationEasing = "easeOutBounce";
	Chart.defaults.global.responsive = true;
	Chart.defaults.global.scaleLineColor = "black";
	Chart.defaults.global.scaleFontSize = 16;

	var ctx = document.getElementById("canvas").getContext("2d");
	var LineChartDemo = new Chart(ctx).Line(lineChartData, {
	    pointDotRadius: 10,
	    bezierCurve: false,
	    scaleShowVerticalLines: false,
	    scaleGridLineColor: "black"
	});
</script>
</html>
