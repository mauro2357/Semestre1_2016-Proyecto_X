package LogicaNegocio;

public class Imc {
	
	private double peso;
	private double estatura;
	
	public Imc(double peso, double estatura) {
		super();
		this.peso = peso;
		this.estatura = estatura;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	
	public double imc(){
		return this.peso/(this.estatura*this.estatura);
	}
	

}
