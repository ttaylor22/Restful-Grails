package restful
import grails.rest.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
@Resource(uri='levels', formats=['json', 'xml'])
class Levelsgrail {
	
	
	String level_name
	Long level_id
 	Long school_id
    
			
    static mapping = {
   		id name: 'level_id'
   		school_id insertable: true
   		school_id updateable: false
	}	

}
