package restful
import grails.rest.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
@Resource(uri='schools', formats=['json', 'xml'])
class Schools {

	Long school_id
    String school_name
    String school_website
    String school_gender
    
    static hasMany = [levels:Levelsgrail]
     
    static constraints = {
    	school_name nullable : false
    	school_website nullable : false
    	school_gender nullable : false   
    }
     
    static mapping = {
        id name: 'school_id'
        levels joinTable: [name: 'levelsgrail', column: 'level_id', key: 'school_id']
    }
}
