package stacky;

public class Programa 
{
	private String Nombre;
	private int Memoria;
	private double PrjAsignado;
	
	Programa(String nom, int mem, double prj)
	{
		Nombre=nom;
		Memoria = mem;
		PrjAsignado = prj;	
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getMemoria() {
		return Memoria;
	}

	public void setMemoria(int memoria) {
		Memoria = memoria;
	}

	public double getPrjAsignado() {
		return PrjAsignado;
	}

	public void setPrjAsignado(double prjAsignado) {
		PrjAsignado = prjAsignado;
	}
	
	public String toString()
	{
		return "Nombre Del Programa: "+Nombre+"\nMemoria Que Ocupa El Programa: "+Memoria+"\nPorcentaje Asignado Del Programa:"+PrjAsignado;
	}
	
}
