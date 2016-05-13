package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import LogicaNegocio.Factory;
import LogicaNegocio.Login;
import repositorios.ConsultasRepositorio;

public class FacadeLogin {
	public static Factory mifactory= Factory.getinstance();
	private static boolean entrar (HttpServletRequest request,HttpSession s){
		mifactory.Crear(request);
		if(ConsultasRepositorio.autenticar(Login.milogin)){
	    	 s.setAttribute("tipousuario",ConsultasRepositorio.ConsultarUsuario(Login.milogin) );
	    	 return true;
	     }
		return false;
	}
	public static String orquestador(HttpServletRequest request,HttpSession s){
		if(request.getParameter("formulario").equals("login")){
			if (entrar (request,s))return "login";
			return "no login";
		}
		else if(request.getParameter("formulario").equals("logout"))return "salir";
		return null;
	}
}