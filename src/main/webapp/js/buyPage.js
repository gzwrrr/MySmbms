var path = $("#path").val();

function add(){
    document.getElementById('num').value++;
}

function sub(){
    if (document.getElementById('num').value>0){
        document.getElementById('num').value--;
    }else {
        alert("不能再减了!");
    }
}

$(function (){
    $("#plus").on("click",function (){
        add();
    })

    $("#sub").on("click",function (){
        sub();
    })
})

function del() {
    var result = window.confirm('确定删除吗?');
    if (result == true){
        return true;
    }else{
        return false;
    }

}

function judgeDel(){
    var add = document.getElementById("added").value;
    var deleted = document.getElementById("deleted").value;
    if (add!==null&&add==="success"){
        alert("添加成功!");
    }else if (add!==null&&add==="fail"){
        alert("添加失败!");
    }
    if (deleted!=null&&deleted==="success"){
        alert("删除成功!");
    }
}

// 直接购买
function bought(){
    $.ajax({
        type:"POST",
        url:path+"/jsp/bought.do",
        data:{method:"bought",billid:obj.attr("billid")},
        dataType:"json",
        success:function(data){
            if(data.delResult == "true"){//删除成功：移除删除行
                cancleBtn();
                obj.parents("tr").remove();
            }else if(data.delResult == "false"){//删除失败
                //alert("对不起，删除订单【"+obj.attr("billcc")+"】失败");
                changeDLGContent("对不起，删除订单【"+obj.attr("billcc")+"】失败");
            }else if(data.delResult == "notexist"){
                //alert("对不起，订单【"+obj.attr("billcc")+"】不存在");
                changeDLGContent("对不起，订单【"+obj.attr("billcc")+"】不存在");
            }
        },
        error:function(data){
            alert("对不起，删除失败");
        }
    });
}

// 加入购物车
function shoppingCart(){
    $.ajax({
        type:"GET",
        url:path+"/jsp/shoppingCart.do?method=shoppingCart",
        data:{
            method:"shoppingCart",
            goodId: $("#goodId"),
            goodName:$("#goodName"),
            goodPrice:$("#goodPrice"),
            goodNumber:$("#goodNumber"),
            addressDesc:$("#addressDesc"),
            goodUrl:$("#goodUrl")
        },
        dataType:"json",
        success:function(data){

            if (data.addResult == "true"){
                alert("添加成功!");
            }else if (data.addResult == "false"){
                alert("添加失败!");
            }else {
                alert("不存在!");
            }
        },
        error:function(data){
            alert("对不起，添加失败!");
        }
    });
}