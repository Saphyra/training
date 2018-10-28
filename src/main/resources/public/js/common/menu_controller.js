(function MenuController(){
    window.menuController = new function(){
        scriptLoader.loadScript("/js/common/dao/menu_dao.js");
        
        $(document).ready(function(){
            loadMenu();
        });
    }
    
    function loadMenu(){
        if(window.pageId == null || window.pageId == undefined){
            console.log("PageId has not been set.");
            return;
        }
        
        const menuContainer = document.getElementById("menu_container");
        if(menuContainer == null){
            console.log("Element with id menu_container not found.");
            return;
        }
        
        menuDao.getMenuOfPage(window.pageId, displayMenu);
        
        function displayMenu(response){
            const container = document.getElementById("menu_container");
                container.innerHTML = "";
            
                for(let bid in response){
                    addMenuElement(container, response[bid]);
                }
                
            function addMenuElement(container, menuElement){
                const menuButton = document.createElement("DIV");
                    menuButton.classList.add("button");
                    menuButton.innerHTML = menuElement.label;
                    menuButton.title = menuElement.description;
                    menuButton.onclick = function(){
                        window.location.href = menuElement.url;
                    }
                container.appendChild(menuButton);
            }
        }
    }
})();