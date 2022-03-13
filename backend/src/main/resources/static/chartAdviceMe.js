// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var action;
  var adventure;
  var comedy;
  var drama;
  var horror;
  var scFiction;
  
  // AJAX call
  $.ajax({
	url: '/chart'
  }).done(function(counts) {
	action = counts[0];
	adventure = counts[1];
	comedy = counts[2];
	drama = counts[3];
	horror = counts[4];
	scFiction = counts[5];
  })

  var data = google.visualization.arrayToDataTable([
    ['Genre', 'Comments Number'],
    ['Action', action],
    ['Adventure', adventure],
    ['Comedy', comedy],
    ['Drama', drama],
    ['Horror', horror],
    ['Science Fiction', scFiction]
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