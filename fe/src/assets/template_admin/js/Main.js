function menuToggleClick(){
    document.querySelector('#menuToggle').addEventListener('click',function(){
        document.body.classList.toggle('open');
    })
}

function searchCloseClick(){
    var searchCloses = document.querySelectorAll('.searck-close');
    var searchClosesLength = searchCloses.length;
    for(var i =0;i<searchClosesLength;i++){
        searchCloses[i].addEventListener('click',function(event){
            event.preventDefault();
            event.stopPropagation();
            this.parentElement.classList.remove('open');
        })
    }
}

function navbarButtonClick(){
    var navbarButtons = document.querySelectorAll('.navbar-toggler');
    var navbarButtonsLength = navbarButtons.length;
    for(var i =0;i<navbarButtonsLength;i++){
        navbarButtons[i].addEventListener('click',function(event){
            event.preventDefault();
            event.stopPropagation();
            var mainMenu = document.querySelector('#main-menu');
            mainMenu.style.display = 'flex !important';
            mainMenu.classList.toggle('show')
            if(mainMenu.classList.contains('show')){
                this.classList.remove('collapsed')
                Array.from(this.attributes)['aria-expanded'] = false;
            }else{
                this.classList.add('collapsed')
                Array.from(this.attributes)['aria-expanded'] = true;
            }
        })
    }
}

function showSubmenuChildren(){
    var dropdown = document.querySelectorAll('.menu-item-has-children');
    var dropdownLength = dropdown.length;
    for(var i =0;i<dropdownLength;i++){
        dropdown[i].addEventListener('click',function(event){
            event.preventDefault();
            var children = this.querySelector('ul');
            this.classList.toggle('show');
            if(this.classList.contains('show')){
                children.classList.add('show');
                children.addEventListener('click',function(event){
                    event.stopPropagation();
                });
            }else{
                children.classList.remove('show');
            }
        });
    }
}

function showUserArea(){
    var userArea = document.querySelector('.user-area');
    userArea.addEventListener('click',function(){
        this.classList.toggle('show');
        var userMenu = document.querySelector('.user-menu');
        if(this.classList.contains('show')){
            userMenu.classList.add('show');
        }else{
            userMenu.classList.remove('show');
        }
    });
}

export {menuToggleClick,searchCloseClick,navbarButtonClick,showSubmenuChildren,showUserArea};