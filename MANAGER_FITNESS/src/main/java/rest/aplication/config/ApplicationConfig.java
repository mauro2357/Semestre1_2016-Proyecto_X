package rest.aplication.config;
import java.util.Set;
import javax.ws.rs.core.Application;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

	public Set<Class<?>> getClasses() {
        return getRestClasses();
    }
    
	//Auto-generated from RESTful web service wizard
    private Set<Class<?>> getRestClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		resources.add(servicios.UsuariosServicio.class);
		resources.add(servicios.LoginServicio.class);
		resources.add(servicios.ImcService.class);
		resources.add(servicios.NroClientesServicio.class);
		return resources;    
    }
}

