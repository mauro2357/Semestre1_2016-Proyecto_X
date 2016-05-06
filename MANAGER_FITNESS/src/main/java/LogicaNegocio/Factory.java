package LogicaNegocio;

import javax.servlet.http.HttpServletRequest;

public class Factory {
	private static Factory mifactory=null;
	
	private Factory() {
		super();
	}
	public static Factory getinstance(){
		if (mifactory==null)mifactory= new Factory();
		return mifactory;
	}
	public void Crear (HttpServletRequest request){
		if(request.getParameter("formulario").equals("login")){
			int id = Integer.parseInt(request.getParameter("id"));
            String pass =request.getParameter("pass");
            Login.getinstance(id,pass);	
		}
	}
	
	
	
}
