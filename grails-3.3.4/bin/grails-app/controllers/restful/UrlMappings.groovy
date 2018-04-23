package restful

class UrlMappings {

    static mappings = {
            
            "/restful/schools"(resources:'schools',includes:['index', 'show', 'update']){
            	"/levels"(resources:'levelsgrail',includes:['index','save','delete'])
            
            }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
