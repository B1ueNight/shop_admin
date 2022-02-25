$(function(){
    $(".delivery_confirm").click(function(){
        let seq = $(this).attr("data-seq");
        $(".popup").css("display", "block");
        $(".popup #save").attr("data-seq", seq);
    })
    $("#save").click(function(){
        if(!confirm("송장번호를 등록하시겠습니까?")) return;
        $(".popup").css("display", "none");
        let number = $("#delivery_number").val();
        console.log(number);
        $.ajax({
            url:"/api/order/delivery?seq="+$(this).attr("data-seq")+"&delivery_no="+number,
            type:"patch",
            success:function(msg){
                alert(msg);
                location.reload();
            }
        })
    })
    $("#cancel").click(function(){
        if(!confirm("등록을 취소 하시겠습니까?")) return;
        $(".popup").css("display", "none");
        $("#delivery_number").val("");
    })
})