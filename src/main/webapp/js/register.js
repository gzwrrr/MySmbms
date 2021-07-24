var path = $("#path").val();
var Yes = "<img width='15px' src='images/y.png' />";
var No = "<img width='15px' src='images/n.png' />";

var userName = null;
var userPassword = null;
var ruserPassword = null;
var phone = null;
var birthday = null;
var addBtn = null;
var backBtn = null;
var green = {"color":"#437247","font-size":"15px"};
var red = {"color":"#96251D","font-size":"15px"};
var grey = {"color":"#999191","font-size":"15px"};

$(function(){
    userName = $("#userName");
    userPassword = $("#userPassword");
    ruserPassword = $("#ruserPassword");
    phone = $("#phone");
    birthday = $("#birthday");
    addBtn = $("#add");
    backBtn = $("#back");
    //初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
    // userCode.next().html("*");
    userName.next().html("*");
    userPassword.next().html("*");
    ruserPassword.next().html("*");
    phone.next().html("*");
    birthday.next().html("*");
    // userRole.next().html("*");



    /*
     * 验证
     * 失焦\获焦
     * jquery的方法传递
     */
    userName.bind("focus",function(){
        validateTip(userName.next(), grey,"* 用户名长度必须是大于1小于10的字符",false);
    }).bind("blur",function(){
        if(userName.val() != null && userName.val().length > 1
            && userName.val().length < 10){
            validateTip(userName.next(),green,Yes,true);
        }else{
            validateTip(userName.next(),red,No+" 用户名输入的不符合规范，请重新输入",false);
        }

    });

    userPassword.bind("focus",function(){
        validateTip(userPassword.next(),grey,"* 密码长度必须是大于6小于20",false);
    }).bind("blur",function(){
        if(userPassword.val() != null && userPassword.val().length > 6
            && userPassword.val().length < 20 ){
            validateTip(userPassword.next(),green,Yes,true);
        }else{
            validateTip(userPassword.next(),red,No + " 密码输入不符合规范，请重新输入",false);
        }
    });

    ruserPassword.bind("focus",function(){
        validateTip(ruserPassword.next(),grey,"* 请输入与上面一只的密码",false);
    }).bind("blur",function(){
        if(ruserPassword.val() != null && ruserPassword.val().length > 6
            && ruserPassword.val().length < 20 && userPassword.val() == ruserPassword.val()){
            validateTip(ruserPassword.next(),green,Yes,true);
        }else{
            validateTip(ruserPassword.next(),red,No + " 两次密码输入不一致，请重新输入",false);
        }
    });


    birthday.bind("focus",function(){
        validateTip(birthday.next(),grey,"* 点击输入框，选择日期",false);
    }).bind("blur",function(){
        if(birthday.val() != null && birthday.val() != ""){
            validateTip(birthday.next(),green,Yes,true);
        }else{
            validateTip(birthday.next(),red,No + " 选择的日期不正确,请重新输入",false);
        }
    });

    phone.bind("focus",function(){
        validateTip(phone.next(),grey,"* 请输入手机号",false);
    }).bind("blur",function(){
        var patrn=/^(13[0-9]|15[0-9]|18[0-9])\d{8}$/;
        if(phone.val().match(patrn)){
            validateTip(phone.next(),green,Yes,true);
        }else{
            validateTip(phone.next(),red,No + " 您输入的手机号格式不正确",false);
        }
    });


    addBtn.bind("click",function(){
        if(userName.attr("validateStatus") != "true"){
            userName.blur();
        }else if(userPassword.attr("validateStatus") != "true"){
            userPassword.blur();
        }else if(ruserPassword.attr("validateStatus") != "true"){
            ruserPassword.blur();
        }else if(birthday.attr("validateStatus") != "true"){
            birthday.blur();
        }else if(phone.attr("validateStatus") != "true"){
            phone.blur();
        }else{
                $("#userForm").submit();
        }
    });

    backBtn.on("click",function(){
        if(referer !== undefined && "" !== referer && "null" !== referer
            && referer.length > 4){
            window.location.href = referer;
        }else{
            history.back(-1);
        }
    });
});