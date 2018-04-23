package restful
import grails.rest.*
import grails.plugin.springsecurity.annotation.Secured
import grails.converters.JSON


@Secured(['ROLE_USER'])
class LevelsgrailController extends RestfulController<Levelsgrail> {
	static responseFormats = ['json', 'xml']
   
    LevelsgrailController() {
        super(Levelsgrail)
    }
    
    @Override
    protected Levelsgrail queryForResource(Serializable id) {
    def scId = params.schoolsId
        respond Levelsgrail.where {
            level_id == id && school_id == scId
        }.find()
    }
         
    def index(){
    	def scID = params.schoolsId
    	respond Levelsgrail.where {
    		school_id == scID
		}.findAll() 
	}
	
	def save(){
	
		Long scID = params.long("schoolsId")
		def json = request.JSON
		Levelsgrail levelsgrail = json
		
		if (json.getLong("school_id") == scID){
			levelsgrail.save(flush: true)
			respond Levelsgrail.where {
    			school_id == scID
			}.findAll()
		}else{
			response.status = 403
			respond levelsgrail.errors
		}
	}
	
	def delete(){
	
		Long scID = params.long("schoolsId")
		Long ID = params.long("id")
		def json = request.JSON
		
		if (json.getLong("school_id") == scID && json.getLong("level_id") == ID){
			Levelsgrail levelsgrail = Levelsgrail.get(ID)
			levelsgrail.delete(flush: true)
			respond Levelsgrail.where {
    			school_id == scID
			}.findAll()
		}else{
			response.status = 403
			respond levelsgrail.errors
		}
	}
}

