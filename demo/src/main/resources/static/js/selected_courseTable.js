function load_selected_courseTable(data) {
    var table=$("#courseTable");
    for(var i=0;i<data.length;i++){
        alert(data[i].time);
        table.find("tr").eq(data[i].time).find("td").eq(data[i].week_data).text(data[i].courseName+"  "+data[i].teacherName+"  "+data[i].building+" "+data[i].classroom+" "+data[i].startWeek+"-"+data[i].deadWeek+"周");
    }
}