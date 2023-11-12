$(document).ready(function(){
    $('.ex8-btn-one').click(function() {
        $('.ex8-content__one').show(800);
        $('.ex8-content__two').hide(800);
        $('.ex8-content__three').hide(800);
    })    
});

$(document).ready(function(){
    $('.ex8-btn-two').click(function() {
        $('.ex8-content__one').hide(800);
        $('.ex8-content__two').show(800);
        $('.ex8-content__three').hide(800);
    })    
});

$(document).ready(function(){
    $('.ex8-btn-three').click(function() {
        $('.ex8-content__one').hide(800);
        $('.ex8-content__two').hide(800);
        $('.ex8-content__three').show(800);
    })    
});