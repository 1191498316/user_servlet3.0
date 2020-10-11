$(document).ready(function () {
    $("table").attr("bgColor", "#222222"); //设置表格的背景颜色
    $("tr").attr("bgColor", "#3366CC"); //为单数行表格设置背景颜色
    $("tr:even").css("background-color", "#CC0000"); //为双数行表格设置背颜色素
    $("table").css("width", "600px"); //为表格添加样式，设置表格长度为300像素

    $("#name").blur(name);
    $("#pass").blur(pass);
});

function name() {
    var name=$("#name").val();
    var res=/^[A-Za-z0-9]{3,16}$/
    if (name==null||name==""){
        $("#Sname").html("名字不能为空！");
        return false;
    }
    if (!res.test(name)){
        $("#Sname").html("用户名必须是由字母和数字组成切位3~16位");
        return false;
    }
    $("#Sname").html("");
    return true;
}

function pass() {
    var pass=$("#pass").val();
    if (pass==null||pass==""){
        $("#Spass").html("密码不能为空！");
        return false;
    }
    $("#Spass").html("");
    return true;
}

function del(a) {
    var aa=confirm("你确定要删除吗？");
    if (aa){
        location.href="UserServlet?id="+a+"&comm=del";
    }
}