<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script src="/resources/contribute/heatmap.js"></script>
    <link rel="stylesheet" href="/resources/contribute/heatmap.css">
    <div id="heatmap"></div>
    <script>
        let data = {};
        //generate dummy data
        let current = new Date(new Date().getFullYear()+'-01-01T00:00:00');
        let end = new Date(new Date().getFullYear()+'-12-31T00:00:00');
        while(current <= end){
            unit = current.getDate()+'.'+(current.getMonth()+1)+'.'+current.getFullYear()+
                'T'+current.getHours()+':'+current.getMinutes()+':'+current.getSeconds();
            random = Math.floor((Math.random() * 10) + 1);
            if(random > 6){
                data[unit] = random -6;
            }
            current.setDate(current.getDate()+1);
        }
        console.log(data)
        console.log(current)
        let heatmap = new HeatmapPlugin('heatmap',data,{},{},true);
    </script>
</body>
</html>
