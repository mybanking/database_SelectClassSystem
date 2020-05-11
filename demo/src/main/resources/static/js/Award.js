function searchCourseTable() {
    var course_year = $("#course_year option:selected").text();
    var arr=course_year.split("/");
    var json={Id:$.getUrlParam("id"),type:$.getUrlParam("type"),year:arr[0],semster:arr[1]};
    var table=$("#courseTable");
    // data= [//指定年份和季度
    //     {courseName:"数据库",
    //         teacherName: "王方石",
    //         year: "2019",
    //         semster: "Spring",
    //         week_data: "1",
    //         time: "1",
    //         building: "SY",
    //         classroom: "101",
    //         startWeek: "1",
    //         deadWeek: "16"
    //     }, {
    //         courseName:"数据库",
    //         teacherName: "王方石",
    //         year: "2018",//本学年课表
    //         semster: "Fall",
    //         week_data: "1",
    //         time: "1",
    //         building: "SY",
    //         classroom: "101",
    //         startWeek: "1",
    //         deadWeek: "16"
    //     }
    //
    // ];

    $.ajax({
        type: "post",
        url: "/search_course",
        data:JSON.stringify(json),
        dataType: "json",
        contentType:"application/json",
        success:function (data,status) {
            for(var i=0;i<data.length;i++){
                table.find("tr").eq(data[i].time).find("td").eq(data[i].week_data).text(data[i].courseName+"  "+data[i].teacherName+"  "+data[i].building+" "+data[i].classroom+" "+data[i].startWeek+"-"+data[i].deadWeek+"周");
            }
        }
    });

}

function search_grade_table(){
    // data_2=[{
    //     //     course_number:"123",
    //     //     courseName:"数据库",
    //     //     teacherName: "王方石",
    //     //     credit:"3",
    //     //     p_grade:"91",
    //     //     grade:"91",
    //     //     total_grade:"A"
    //     // },
    //     //     {   course_number:"1234",
    //     //         courseName:"数据库",
    //     //         teacherName: "王方石",
    //     //         credit:"3",
    //     //         p_grade:"91",
    //     //         grade:"91",
    //     //         total_grade:"A"
    //     //     }
    // //     // ];
    // auto_create_table_grade(data_2);

    var course_year = $("#g_course_year option:selected").text();
    var arr=course_year.split("/");
    var json={Id:$.getUrlParam("id"),type:$.getUrlParam("type"),year:arr[0],semster:arr[1]};
    $.ajax({
        type: "post",
        url: "/search_grade",
        data:JSON.stringify(json),
        dataType: "json",
        contentType:"application/json",
        success:function (data,status) {
            auto_create_table_grade(data);
        }

    });
}
$.getUrlParam = function(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r!=null) return unescape(r[2]); return null;
}
function  load_grade(){
    document.getElementById("r").style.display="none";
    document.getElementById("g").style.display="block";

}

function  search_course(){
    document.getElementById("g").style.display="none";
    document.getElementById("r").style.display="block";
}


window.onload=function () {

    data_1 = [{
        year: "2019",//此学生所有年份降序排列
        semster: "Spring"
    },
        {
            year: "2018",
            semster: "Fall"
        }];

    // data= [
    //     {courseName:"数据库",
    //         teacherName: "王方石",
    //         year: "2019",//本学年课表
    //         semster: "Spring",
    //         week_data: "1",
    //         time: "1",
    //         building: "SY",
    //         classroom: "101",
    //         startWeek: "1",
    //         deadWeek: "16"
    //     }, {
    //         courseName:"数据库",
    //         teacherName: "王方石",
    //         year: "2018",//本学年课表
    //         semster: "Fall",
    //         week_data: "1",
    //         time: "1",
    //         building: "SY",
    //         classroom: "101",
    //         startWeek: "1",
    //         deadWeek: "16"
    //     }
    //
    // ];

    //返回本学年的课程分数
    // data_2=[{
    //     course_number:"123",
    //     courseName:"数据库",
    //     teacherName: "王方石",
    //     credit:"3",
    //     p_grade:"91",
    //     grade:"91",
    //     total_grade:"A"
    //     },
    //     {   course_number:"1234",
    //         courseName:"数据库",
    //         teacherName: "王方石",
    //         credit:"3",
    //         p_grade:"91",
    //         grade:"91",
    //         total_grade:"A"
    //     }
    // ];


    // data_3={
    //     totalCredit:"100"
    // };
    // $("#totalCredit").text(data_3.totalCredit);

    // for(var j=0;j<data_1.length;j++){
    //     //排序，从降序
    //     alert(data_1[j].year);
    //     select.append("<option style='font-size: 1em' value="+j+">"+data_1[j].year+"/"+data_1[j].semster+"</option>");
    //     g_select.append("<option style='font-size: 1em' value="+j+">"+data_1[j].year+"/"+data_1[j].semster+"</option>");
    // }//选择下拉框
    // select.val(0);
    // g_select.val(0);
    //   auto_create_table_grade(data_2);
    // }

    var select = $("#course_year");
    var g_select = $("#g_course_year");
    var json = {Id: $.getUrlParam("id"), type: $.getUrlParam("type")};
    $.ajax({
        type: "post",
        url: "/load_course_select",
        data: JSON.stringify(json),
        dataType: "json",
        contentType: "application/json",
        success: function (data_1, status) {
            //追加下拉框
            for (var j = 0; j < data_1.length; j++) {
                //排序，从降序
                //alert(data_1[j].year);
                select.append("<option style='font-size: 1em' value=" + j + ">" + data_1[j].year + "/" + data_1[j].semster + "</option>");
                g_select.append("<option style='font-size: 1em' value=" + j + ">" + data_1[j].year + "/" + data_1[j].semster + "</option>");
            }//选择下拉框
            select.val(0);
            g_select.val(0);
        }
    });
    var table = $("#courseTable");

    var json_1 = {Id: $.getUrlParam("id"), type: $.getUrlParam("type")};
    $.ajax({
        type: "post",
        url: "/load_course_load",
        data: JSON.stringify(json_1),
        dataType: "json",
        contentType: "application/json",
        success: function (data, status) {
            for (var i = 0; i < data.length; i++) {
                table.find("tr").eq(data[i].time).find("td").eq(data[i].week_data).text(data[i].courseName + "  " + data[i].teacherName + "  " + data[i].building + " " + data[i].classroom + " " + data[i].startWeek + "-" + data[i].deadWeek + "周");
            }
        }
    });

    var g_json_1 = {Id: $.getUrlParam("id"), type: $.getUrlParam("type")};
    $.ajax({
        type: "post",
        url: "/load_grade",
        data: JSON.stringify(g_json_1),
        dataType: "json",
        contentType: "application/json",
        success: function (data_2, status) {
            auto_create_table_grade(data_2);
        }
    });
    var totalCredit = {Id: $.getUrlParam("id"), type: $.getUrlParam("type")};
    $.ajax({
        type: "post",
        url: "/load_ totalCredit",
        data: JSON.stringify(totalCredit),
        dataType: "json",
        contentType: "application/json",
        success: function (data_3, status) {
            $("#totalCredit").text(data_3.totalCredit);
        }
    });
}

function sumitAward() {
    var things = $("#things");
    var award = $("#award_inf");
    var mainWork = $("#main_work");

    document.getElementById("things").style.borderColor = "#fafafa";
    document.getElementById("award_inf").style.borderColor = "#fafafa";
    document.getElementById("main_work").style.borderColor = "#fafafa";
    var tag = 1;
    if (things.text() == "") {
        document.getElementById("things").style.borderColor = "red";
        tag = 0;
    }
    if (award.text() == "") {
        document.getElementById("award_inf").style.borderColor = "red";
        tag = 0;
    }
    if (mainWork.text() == "") {
        document.getElementById("main_work").style.borderColor = "red";
        tag = 0;
    }
    if (tag == 1) {
        var json = {
            Id: $.getUrlParam("id"), type: $.getUrlParam("type"),
            awNumber: $("#aw_number").text(),//奖学金编号
            things: things.text(),//主要事迹
            award: award.text(),//获得其他奖项
            mainWork: mainWork.text()//主要工作
        };
        $.ajax({
            type: "post",
            url: "/apply_award",
            data: JSON.stringify(json),
            dataType: "json",
            contentType: "application/json",
            success: function (data, status) {
            }
        });
    }
}