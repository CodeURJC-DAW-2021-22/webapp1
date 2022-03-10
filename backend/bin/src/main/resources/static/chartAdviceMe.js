// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
    ['Genre', 'Percentage'],
    ['Action', 15],
    ['Adventure', 25],
    ['Comedy', 25],
    ['Drama', 10],
    ['Horror', 5],
    ['Science Fiction', 20]
  ]);

  var options = {
    'width': 460,
    'height': 305,
    'backgroundColor': 'transparent',
    'chartArea': {left: 20, top: 0, width: '100%', height: '100%'},
    'legend': {position: 'right', alignment: 'center', textStyle: {color: 'white', fontSize: 16}}
  };

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
  chart.draw(data, options);
}