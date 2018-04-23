
import com.mysecurerest.UserPasswordEncoderListener
import grails.rest.render.json.*
import restful.*
// Place your Spring DSL code here
beans = {
     userPasswordEncoderListener(UserPasswordEncoderListener)
     schoolsRenderer(JsonRenderer,Schools){
     
     }
     levelsgrailRenderer(JsonRenderer,Levelsgrail){
     excludes = ['school','id']
     }
     //rest(grails.plugins.rest.client.RestBuilder)
}
