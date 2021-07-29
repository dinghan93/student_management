$(function(){
    $("input[name='all']").click(function(){
        var flag = $("input[name='all']").prop("checked");
        var oneList = $("input[name='one']");
        console.log(oneList.length)
        for(var i = 0; i < oneList.length; i++){
            $(oneList[i]).prop("checked",flag);
        }
    });

    $("input[name='one']").click(function(){
        var all = $("input[name='all']");
        var oneArray = $("input[name='one']");
        for(var i = 0; i < oneArray.length; i++){
            if($(oneArray[i]).prop("checked")==false){
                all.prop("checked",false);
                return;
            }
        }
        all.prop("checked", true);
    });
});