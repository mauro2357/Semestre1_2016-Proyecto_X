package servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import repositorios.MembreciaConsultasRepositorio;

@Path("/Imc")
public class ImcService {
		 
		@GET
		@Path("/{id}")
		public double Imc(@PathParam("id") String id ) throws Exception {
			return MembreciaConsultasRepositorio.consultarImc(Integer.parseInt(id));
			
		}
	 
}
