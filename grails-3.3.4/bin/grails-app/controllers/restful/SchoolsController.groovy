package restful
import grails.rest.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class SchoolsController extends RestfulController<Schools> {
	static responseFormats = ['json', 'xml']
      
    SchoolsController() {
        super(Schools)
    }
       
    def index(Integer max) {
    	params.max = max
    	respond Schools.list(params), model:[schoolCount: Schools.count()] 
	}
	
	def show(){
	respond Schools.get(params.id)
	}
   
}
