$(function (){
    $("#back").on("click",function(){
        if(referer !== undefined && "" !== referer && "null" !== referer
            && referer.length > 4){
            window.location.href = referer;
        }else{
            history.back(-1);
        }
    });
})

function judgeBuy(){
    var add = document.getElementById("addGood").value;
    var error = document.getElementById("error").value;

    if(add!==null&&add==="success"){
        alert("购买成功!");
        window.location.href=referer;
    }else if (error!==null&&error==="pwdFail"){
        alert("密码错误!");
    }

}