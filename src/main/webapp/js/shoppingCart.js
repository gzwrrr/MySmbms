function del (){
    var result = window.confirm('确定删除吗?');
    if (result === true){
        return true;
    }else{
        return false;
    }
}

function judge(){
    var deleted = document.getElementById("del").value;
    if (deleted!=null&&deleted==="success"){
        alert("删除成功!");
    }else if (deleted!=null&&deleted==="fail"){
        alert("删除失败!")
    }
}