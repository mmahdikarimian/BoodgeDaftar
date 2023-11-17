$(document).ready(function(){
    for(let i =1; i<=3;i++){
        createChart(i);
    }
})

const data = {
    labels: ['مصوب ساتع'],
    datasets: [{
        label: ['مقدار'],
        data: [18, 5],
        backgroundColor: [
            'rgba(255, 26, 104, 0.2)',
            'rgba(54, 162, 235, 0.2)',
        ],
        borderColor: [
            'rgba(255, 26, 104, 0.2)',
            'rgba(54, 162, 235, 0.2)',

        ],
        borderWidth: 1
    }]
};

// config
const config = {
    type: 'doughnut',
    data,
    options: {
        circumference: 180,
        rotation : 270,
        cutout: '97%',
        aspectRatio : 2,
        plugins : {
            legend:{display:false},
            tooltip:{
                filter : (tooltipItem)=>{
                    return tooltipItem.dataIndex === 0;
                }
            }
        }
    }
};


function createChart(number)
{

    console.log("hello"+number)
    const myChart = new Chart(
        document.getElementById('myChart'+number),
        config
    );
}