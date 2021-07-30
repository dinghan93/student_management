$(function(){
    $("input.pMenu").click(function(){
        var flag = $(this).prop("checked");
        var oneList = $(this).parent('li').find("input.sMenu");
        for(var i = 0; i < oneList.length; i++){
            $(oneList[i]).prop("checked", flag);
        }
    });

    $("input.sMenu").click(function(){
        var parent = $(this).parent().parent().siblings("input");
        var oneArray = parent.parent().find('input.sMenu');
        for(var i = 0; i < oneArray.length; i++){
            if($(oneArray[i]).prop("checked")==false){
                parent.prop("checked",false);
                return;
            }
        }
        parent.prop("checked",true);
    });
});