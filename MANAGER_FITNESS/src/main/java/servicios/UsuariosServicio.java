package servicios;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import LogicaNegocio.Usuarios;

@Path("/Usuarios")
public class UsuariosServicio {
		 
		@GET
		@Path("/{id}/{nombre}/{direccion}/{telefono}/{correo}/{password}/{fnac}")
		public Response getMsg(@PathParam("id") String id, @PathParam("nombre") String nombre,@PathParam("direccion") String direccion,@PathParam("telefono") String telefono,@PathParam("correo") String correo,@PathParam("password") String password,@PathParam("fnac") String fnac) throws Exception {
			Usuarios miusuario= new Usuarios(Integer.parseInt(id),nombre,direccion,Long.parseLong(telefono),correo,password,fnac,"CLIN");
			String output1 = "Los Datos del Usuario son:  Cedula "+id+"; "+"Nombre "+ nombre+"; "+"Direccion "+ direccion+"; "+ "Telefono "+ telefono+ "; "+"Correo "+ correo+"; "+"Password "+password +"; "+"Fecha Nacimiento "+ fnac+ " SE AGREGO EXITOSAMENTE";
			String output2 = "Los Datos del Usuario son:  Cedula "+id+"; "+"Nombre "+ nombre+"; "+"Direccion "+ direccion+"; "+ "Telefono "+ telefono+ "; "+"Correo "+ correo+"; "+"Password "+password +"; "+"Fecha Nacimiento "+ fnac+ " NO SE PUDO AGREGAR";

			if (miusuario.agregar())return Response.status(200).entity(output1).build();
			return Response.status(200).entity(output2).build();
		}
	 
}

