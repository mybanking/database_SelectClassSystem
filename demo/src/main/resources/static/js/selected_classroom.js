function auto_create_table_selected_classroom(data) {
    annexList = new Array();
    count=0;
    page=0;
    size=13;
    last=0;
    remain=0;
    $(function(){
        //第二种： 动态创建表格的方式，使用动态创建dom对象的方式
        //清空所有的子节点
        $("#group_one").empty();
        //自杀
        // $("#J_TbData").remove();
        last=Math.floor(data.length/size);
        $("#total_page").text(last+1);
        remain=data.length%size;
        for( var i = 0; i < data.length; i++ ) {
            t="111";
            var tab="<tr>"+ "<td class='color_1'>"+data[i].classroom+"</td>";
            tab+="<td class='color_1'>"+$("#year option:selected").text()+"</td>";
            tab+="<td class='color_1'>"+data[i].start_time+"</td>";
            tab+="<td class='color_1'>"+data[i].end_time+"</td>";
            tab+="<td class='color_1'>"+data[i].id+"</td>";
            tab+="<td class='color_1'>"+data[i].information+"</td>";
            tab+="<td class='color_1'>"+data[i].state+"</td>";
            tab+="<td  class='color_1' onclick='cancel($(this));'><a class='l_select_1' href='#'>取消申请</a></td>";
            tab=tab+"</tr>";
            if (count < size) {
                //第一页显示的数量
                $("#group_one").append(tab);
                $("#prePage" ).attr("disabled","disabled");
                $("#nextPage").attr("disabled","disabled");
            } else {
                //恢复点击
                $("#nextPage").removeAttr("disabled");
            }
            count++;
            //保存到数组中
            var annex = new String();
            annex=tab;
            annexList.push(annex);
        }
        $("#currentPage").text(page+1);


    });

//上一页
    $("#prePage").click( function () {
        page--;
        paging();
    });

    //下一页
    $("#nextPage").click( function () {
        page++;
        paging();
    });
    //首页
    $("#firstPage").click( function () {
        page=0;
        paging();

    });
    //末页
    $("#lastPage").click( function () {
        page=last;
        paging();

    });
    //指定页
    $("#jump").click( function () {
        page=$("#aim_page").val()-1;
        paging();

    });
    //分页
    function paging() {
        var tab ="";
        var curentNumber = page*size;
        var length = curentNumber+size;
        //当前页数
        var currentPage = page+1;
        for(var i = curentNumber; i < length; i++ ) {
            // console.log(annexList[i]);
            if(typeof(annexList[i]) == "undefined") {
                break;
            }
            tab +=annexList[i];
        }
        if(page==last) {
            //到了最后一页不可以点击
            $("#nextPage" ).attr("disabled","disabled");
        } else {
            //恢复点击
            $("#nextPage").removeAttr("disabled");
        }

        if(page==0) {
            //到了第一页不可以点击
            $("#prePage" ).attr("disabled","disabled");
        } else {
            $("#prePage").removeAttr("disabled");
        }
        //填充到表格
        $("#group_one").html(tab);
        //显示当前页数
        $("#currentPage").text(currentPage);
    }
}





function  Search_selected_classroom(){

    // //返回指定学年，指定教室，已申请教室的所有情况
    // data=[{
    //     classroom:"SY101", //格式
    //     week:"week 1 MOnday",
    //     start_time:"1",
    //     end_time:"2",
    //     id:"17301066",
    //     information:"借用",
    //     state:"未审核",
    //
    // },
    //     {
    //         classroom:"SY101", //格式
    //         week:"week 1 MOnday",
    //         start_time:"1",
    //         end_time:"2",
    //         id:"17301066",
    //         information:"借用",
    //         state:"未审核",
    //
    //     }];
    // auto_create_table_selected_classroom(data);
    var json = {
        Id: $.getUrlParam("id"),
        type: $.getUrlParam("type"),
        year:$("#year option:selected").text(),
        week:$("#week option:selected").text(),
        building:$("#building option:selected").text(),
        classroom: $("#classroom_number").val()
    };
    $.ajax({
        type: "post",
        url: "/Search_selected_classroom",
        data:JSON.stringify(json),
        dataType: "json",
        contentType:"application/json",
        success:function (data,status) {
            auto_create_table_selected_classroom(data);
        }
    });

}
function cancel(a) {
    var table=$("#senfe");
    var tr=table.find("tr").eq(a.parent("tr").index());
    var str=tr.find("tr").eq(1).split(" ");
    str[2]=change(str[2]);
    var json={
        Id: $.getUrlParam("id"),
        type: $.getUrlParam("type"),
        classroom_id:tr.find("td").eq(0),
        week:str[1],
        day:str,
        startTime:tr.find("tr").eq(2),
        endTime:tr.find("tr").eq(3)
    }
    $.ajax({
        type: "post",
        url: "/cancel_apply",
        data:JSON.stringify(json),
        dataType: "json",
        contentType:"application/json",
        success:function (data,status) {

        }
    });

}
function change(str) {
    if(str.eq("Monday")){
        return 1;
    }
    if(str.eq("Thueday")){
        return 2;
    }
    if(str.eq("Wednesday")){
        return 3;
    }
    if(str.eq("Thursday")){
        return 4;
    }
    if(str.eq("Friday")){
        return 5;
    }
    if(str.eq("Saturday")){
        return 6;
    }
    if(str.eq("Sunday")){
        return 7;
    }
}