package controladores;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import LogicaNegocio.Datos_Usuarios;
import LogicaNegocio.Factory;
import LogicaNegocio.Login;
import repositorios.ConsultasRepositorio;
import repositorios.MembreciaConsultasRepositorio;

public class FacadeLogin {
	public static Factory mifactory = Factory.getinstance();

	private static boolean entrar(HttpServletRequest request, HttpSession s) throws Exception {
		mifactory.Crear(request);
		if (ConsultasRepositorio.autenticar(Login.milogin)) {
			String tipo_usuario = ConsultasRepositorio.ConsultarUsuario(Login.milogin);
			Datos_Usuarios datos = new Datos_Usuarios(tipo_usuario);
			s.setAttribute("tipousuario", tipo_usuario);
			if (tipo_usuario.equals("CLIN")){
				datos.consultar_mensualidad(Login.milogin.getId());	
			}
			datos.consultar_rutinas();
			s.setAttribute("datos_usuario", datos);
			return true;
		}
		return false;
	}
	
	public static String orquestador(HttpServletRequest request,HttpSession s) throws Exception{
		if(request.getParameter("formulario").equals("login")){
			if (entrar (request,s))return "login";
			return "no login";
		}
		else if(request.getParameter("formulario").equals("logout"))return "salir";
		return null;
	}
}