package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import LogicaNegocio.Entrenador;
import LogicaNegocio.Horario;
import LogicaNegocio.Programacion;
import repositorios.ProxyHorarioArchivoRepositorio;
import repositorios.ProxyHorarioRepositorio;
import repositorios.UsuariosRepositorio;
import LogicaNegocio.Correo;
import repositorios.ConsultasRepositorio;

@WebServlet("/HorarioControlador")
public class HorarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		try {
			if (request.getParameter("formulario").equals("agregarHorario")) {
				int id = Integer.parseInt(request.getParameter("id"));
				int descripcion = Integer.parseInt(request.getParameter("horario"));
				String tipoEntrenador = request.getParameter("tipoEntrenador");
				Horario horario;
				if (request.getParameter("archivo") != null) {
					horario = new Horario(new ProxyHorarioArchivoRepositorio(), id, descripcion);
				} else {
					horario = new Horario(new ProxyHorarioRepositorio(), id, descripcion);
				}
				Entrenador entrenador = new Entrenador(id, tipoEntrenador);
				if (UsuariosRepositorio.agregar(entrenador)) {
					if (horario.agregarbd()) {
						rd = request.getRequestDispatcher("VistaAdministrador.jsp");
						rd.forward(request, response);
						out.close();
					} else {
						out.print("<p style=\"color:red\">NO SE PUDO AGREGAR EL HORARIO</p>");
						rd = request.getRequestDispatcher("VistaAuxEntrenador.jsp");
						rd.include(request, response);
						out.close();
					}
				} else {
					out.print("<p style=\"color:red\">NO SE PUDO AGREGAR EL ENTRENADOR</p>");
					rd = request.getRequestDispatcher("VistaAuxEntrenador.jsp");
					rd.include(request, response);
					out.close();
				}
			}
				if (request.getParameter("formulario").equals("modificarHorario")) {
					int cedula = Integer.parseInt(request.getParameter("id"));
					int codigo = Integer.parseInt(request.getParameter("Horario"));
					Programacion programacion = new Programacion(cedula, codigo);
					if (repositorios.ProgramacionRepositorio.modificarProgramacion(programacion)) {
						Correo correo  =new Correo("Modificacion de horario","su nuevo horario es:"+ConsultasRepositorio.consultarHorario(codigo),ConsultasRepositorio.consultarCorreo(cedula));
						correo.sendEmail();
						out.print("<p style=\"color:red\">SE MODIFICO EL HORARIO EXITOSAMENTE</p>");
						rd = request.getRequestDispatcher("VistaAdministrador.jsp");
						rd.include(request, response);
						out.close();
					} else {
						out.print("<p style=\"color:red\">NO SE PUDO MODIFICAR EL HORARIO</p>");
						rd = request.getRequestDispatcher("VistaAdministrador.jsp");
						rd.include(request, response);
						out.close();
					}
				}

		} catch (NumberFormatException e) {
			request.setAttribute("estado", "error");
		} 
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
