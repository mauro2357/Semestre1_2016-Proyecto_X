package servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import LogicaNegocio.Login;
import repositorios.ConsultasRepositorio;

@Path("/Login")
public class LoginServicio {
		 
		@GET
		@Path("/{id}/{password}")
		public boolean Login(@PathParam("id") String id, @PathParam("password") String password) throws Exception {
			Login.getinstance(Integer.parseInt(id),password);	
			//String output1 = "Los Datos del Usuario son:  Cedula "+id+"; "+"pass "+ password;

			if (ConsultasRepositorio.autenticar(Login.milogin))return true;
			return false;
		}
	 
}
