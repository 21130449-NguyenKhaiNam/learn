function isClick() {
    var isClick = document.getElementById('test');

    if(isClick.className === 'ex5-onClass') {
        isClick.classList.add('ex5-closeClass');
        isClick.classList.remove('ex5-onClass');
    }else {
        isClick.classList.add('ex5-onClass');
        isClick.classList.remove('ex5-closeClass');
    }
};
