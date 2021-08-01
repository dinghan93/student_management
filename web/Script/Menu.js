$(function () {
    //父菜单选中，子菜单全选中；父菜单不选中，子菜单都不选中
    $("input.pMenu").click(function () {
        var flag = $(this).prop("checked");
        var oneList = $(this).parent('li').find("input.sMenu");
        for (var i = 0; i < oneList.length; i++) {
            $(oneList[i]).prop("checked", flag);
        }
    });

    //只要有一个子菜单选中，则父菜单就选中
    $("input.sMenu").click(function () {
        alert('子菜单点击');
        var parent = $(this).parent().parent().siblings("input");
        var oneArray = parent.parent().find('input.sMenu');
        for (var i = 0; i < oneArray.length; i++) {
            if ($(oneArray[i]).prop("checked") == true) {
                alert('子菜单选中');
                parent.prop("checked", true);
                return;
            }
        }
        parent.prop("checked", false);
    });
});