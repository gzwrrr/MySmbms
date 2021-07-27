var path = document.getElementById("path").value;
var goodName = document.getElementById("goodName").value;
var goodPrice = document.getElementById("goodPrice").value;
var num = document.getElementById("num").value;
var goodId = document.getElementById("goodId").value;


function add(){
    document.getElementById('num').value++;
}

function sub(){
    if (document.getElementById('num').value>1){
        document.getElementById('num').value--;
    }else {
        alert("不能再减了!");
    }
}

$(function (){
    // $("#plus").on("click",function (){
    //     add();
    // })

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
        data:{method:"bought"},
        dataType:"json",
        success:function(data){
            if(data.result == "true"){//删除成功：移除删除行
                alert(goodId);
                window.location.href=path+"/jsp/bought.do?method=toBoughtPage&goodName="+goodName
                    +"&goodPrice="+goodPrice+"&goodId="+goodId+"&goodNumber="+num;
            }
        },
        error:function(data){
            alert("对不起，购买失败");
            alert(path);
        }
    });
}

$(function (){
    $("#bought").on("click",function (){
        bought();
    })
})

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