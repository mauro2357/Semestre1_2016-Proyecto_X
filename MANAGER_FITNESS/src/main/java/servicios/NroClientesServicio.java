package servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import repositorios.ConsultasRepositorio;

@Path("/Cantidad")
public class NroClientesServicio {
		 
		@GET
		@Path("")
		public double Imc(@PathParam("id") String id ) throws Exception {
			return ConsultasRepositorio.consultarCantidad();
			
		}
	 
}
