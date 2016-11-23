package demo.jaxrs.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/hello/{username}")
public class Hello {

        @GET
        @Produces("text/xml")
        public String sayHello(@PathParam("username") String userName) {
                return "hello " + userName;
        }
}