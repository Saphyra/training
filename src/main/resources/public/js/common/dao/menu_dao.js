(function MenuDao(){
    window.menuDao = new function(){
        this.getMenuOfPage = getMenuOfPage;
    }
    
    function getMenuOfPage(pageId, successCallBack){
        const path = "/menu/" + pageId;
        const request = new Request(dao.GET, path);
            request.processValidResponse = successCallBack;
            request.convertResponse = function(response){
                const menuElements = JSON.parse(response.response);
                
                    menuElements.sort(function(a, b){
                        return a.id.localeCompare(b.id);
                    });
                
                return menuElements;
            }
        dao.sendRequestAsync(request);
    }
})();