
$(function () {
    //初始化highcharts内容的样式
    highchartFunc();
});
function highchartFunc() {
    var chart = new Highcharts.Chart('container', {
        colors:[
            "#ffd650"
        ],
        exporting:{
            enabled:false
        },
        credits: {
            text: "",
            enabled: false
        },
        title: {
            text: ''
        },
        subtitle: {
            text: '',
        },
        xAxis: {
            categories: [
                '05-06',
                '05-07',
                '05-08',
                '05-09',
                '05-10',
                '05-11',
                '05-12',
                '05-13']
        },
        yAxis: {
            title: {
                text: ''
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#337AB7'
            }]
        },
        plotOptions: {
            series: {
                allowPointSelect: true,
                point: {
                    events: {
                        click: function() {
                            console.log(this);
                        }
                    }
                }
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: '体温',
            data: [36.5, 37.6, 38.7, 36.5, 39.5, 40.5, 37.5, 36.5, 36.5]
        }]
    });
}
