import java.util.*;
public class UsaLista {
	static Scanner leer = new Scanner(System.in);
	Lista<String> lista= new Lista<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsaLista usa= new UsaLista();
		usa.AgregaFte();
		usa.AgregaFin();
		usa.AgregaFte();
		usa.ImprimeTodo();

	}
	
	public void AgregaFte()
	{
		System.out.println("Elemento a agregar al Frente");
		String dato=leer.nextLine();
		boolean resul=lista.InsertaFrente(dato);
		if (resul==false)
			System.out.println("Error al Insertar Dato "+ dato);
		else
			System.out.println("Elemento "+ dato+ " Agregado");
	}
	
	public void AgregaFin()
	{
		System.out.println("Elemento a agregar al Final");
		String dato=leer.nextLine();
		boolean resul=lista.InsertaFin(dato);
		if (resul==false)
			System.out.println("Error al Insertar Dato "+ dato);
		else
			System.out.println("Elemento "+ dato+ " Agregado");
	}
	
	public void ImprimeTodo()
	{
		System.out.println("Elementos de la Lista");
		lista.EstadoActual();
	}
	
}
