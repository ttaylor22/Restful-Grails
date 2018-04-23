package restful
import com.mysecurerest.*

class BootStrap {

    def init = { servletContext ->
    
    def role1 = Authority.findByAuthority("ROLE_USER") ?: new Authority(authority: "ROLE_USER").save(flush: true)
    def user1 = User.findByUsername("user1") ?: new User(username:"user1",password:"pwd1").save(flush:true)
    UserAuthority.create(user1,role1,true)
    }
    def destroy = {
    }
}
