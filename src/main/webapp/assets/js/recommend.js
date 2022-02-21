$(function(){
    $(".recommend_btn").click(function(){
        let seq = $(this).attr("data-seq");
        let $this = $(this);
        if($(this).hasClass("active")){
            //active 클래스가 있는 상태라면 추천 제품에 추가 되어있기 때문에 delete 를 작동.
            $.ajax({
                url:"/product/recommend?seq="+seq,
                type:"delete",
                success:function(r) {
                    console.log(r);
                    $this.removeClass("active");
                }
            })
        }
        else {
            $.ajax({
                url:"/product/recommend?seq="+seq,
                type:"put",
                success:function(r) {
                    console.log(r);
                    $this.addClass("active");
                }
            })
        }
    })
})