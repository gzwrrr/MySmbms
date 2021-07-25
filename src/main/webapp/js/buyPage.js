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
