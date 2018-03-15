$(document).ready(function () {
    $("#aLogin").click(function () {
        // login ajax
        $.ajax({
            type: "get",
            url: "/login",
            async: true,
            timeout: 10000,
            data: "username=" + $("#username").val() + "&password=" + $("#password").val(),
            dataType: "json",
            success: function (msg) {
                console.log(msg);
                if (msg !== 1) {
                   alert("登录失败，请检查用户名和密码")
                }
                else
                {
                    //成功
                    window.location.href="/bg/index.html";
                    var lStorage = window.localStorage;
                    lStorage.setItem("username",$("#username").val());
                   // alert("登录成功 " + $("#username").val());
                }
            },
            error: function (msg) {
                console.log(msg);
                //
                // window.location.href="/bg/index.html";
                // var lStorage = window.localStorage;
                // lStorage.setItem("username",$("#username").val());
                alert("登录时发生错误 " + msg.responseJSON.message );
            }
        });

    });
})