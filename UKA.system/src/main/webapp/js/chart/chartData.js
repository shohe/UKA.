var doughnutData = [
    {
        value : 80,
        color : "#6aa6cc"
    },
    {
        value: 20,
        color:"#dee7eb"
    }
];

$(function() {
    var context = document.getElementById("doughnut_chart").getContext("2d");
    var myDoughnut = new Chart(context).Doughnut(doughnutData, {
        segmentShowStroke : false,
        segmentStrokeWidth : 2,
        percentageInnerCutout : 0,
        animationSteps : 20,
        animationEasing : "easeInSine",
        animateRotate : false,
        animateScale : false,
        legendTemplate :""
    });
});



var doughnutData0 = [
    {
        value : 80,
        color : "#6aa6cc"
    },
    {
        value: 20,
        color:"#dee7eb"
    }
];

$(function() {
    var context = document.getElementById("doughnut_chart0").getContext("2d");
    var myDoughnut = new Chart(context).Doughnut(doughnutData0, {
        segmentShowStroke : false,
        segmentStrokeWidth : 2,
        percentageInnerCutout : 0,
        animationSteps : 20,
        animationEasing : "easeInSine",
        animateRotate : false,
        animateScale : false,
        legendTemplate :""
    });
});




var doughnutData2 = [
    {
        value : 30,
        color : "#6aa6cc"
    },
    {
        value: 70,
        color:"#dee7eb"
    }
];

$(function() {
    var context = document.getElementById("doughnut_chart2").getContext("2d");
    var myDoughnut = new Chart(context).Doughnut(doughnutData2, {
        segmentShowStroke : false,
        segmentStrokeWidth : 2,
        percentageInnerCutout : 0,
        animationSteps : 20,
        animationEasing : "easeInSine",
        animateRotate : false,
        animateScale : false,
        legendTemplate :""
    });
});






var doughnutData3 = [
    {
        value : 60,
        color : "#6aa6cc"
    },
    {
        value: 40,
        color:"#dee7eb"
    }
];

$(function() {
    var context = document.getElementById("doughnut_chart3").getContext("2d");
    var myDoughnut = new Chart(context).Doughnut(doughnutData3, {
        segmentShowStroke : false,
        segmentStrokeWidth : 2,
        percentageInnerCutout : 0,
        animationSteps : 20,
        animationEasing : "easeInSine",
        animateRotate : false,
        animateScale : false,
        legendTemplate :""
    });
});
