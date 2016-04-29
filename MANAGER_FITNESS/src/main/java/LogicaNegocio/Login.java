package LogicaNegocio;

public class Login {
	private int id;
	private String pass;
	private static Login milogin;
	
	public static Login getinstance(int id, String password){
		if (milogin==null)milogin= new Login(id, password);
		return milogin;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	private Login(int id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	
	
}
	