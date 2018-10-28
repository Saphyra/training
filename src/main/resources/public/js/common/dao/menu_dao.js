(function MenuDao(){
    window.menuDao = new function(){
        this.getMenuOfPage = getMenuOfPage;
    }
    
    function getMenuOfPage(pageId, successCallBack){
        const path = "/menu/" + pageId;
        const request = new Request(dao.GET, path);
            request.processValidResponse = successCallBack;
            request.convertResponse = function(response){
                return JSON.parse(response.response);
            }
        dao.sendRequestAsync(request);
    }
})();