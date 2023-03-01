import java.util.*;
public class UsaArbolBB {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBB<Integer> arbolbb=new ArbolBB<Integer>();
		Random rd= new Random();
		for(int i=0;i<10;i++){
			int Num=rd.nextInt(100);
			System.out.println(Num);
			arbolbb.Inserta(Num);
		}
		System.out.println("RECORRIENDO LADO IZQ");
		NodoABB<Integer> Aux=arbolbb.DameRaiz();
		while (Aux!=null){
			System.out.println(Aux.Info);
			Aux=Aux.DameSubIzq();
			
		}
		System.out.println("contendio del arbol");
		Met(arbolbb.DameRaiz());
		
		System.out.println("Total de nodos "+arbolbb.length(arbolbb.DameRaiz()));
		System.out.println("Altura arbol "+arbolbb.Altura(arbolbb.DameRaiz(),0));
		System.out.println("Buscando números");
		
		for(int i=10;i<91;i++)
			System.out.println("Num "+i+ "Localizado= "+arbolbb.Busca(arbolbb.DameRaiz(), i));
		
	}*/
	
	public static void main(String[] args)
	{
		ArbolBB<Integer> arbolbb=new ArbolBB<Integer>();
				arbolbb.Inserta(27);
				
				arbolbb.Inserta(14);
				arbolbb.Inserta(47);
				
				arbolbb.Inserta(17);
				arbolbb.Inserta(32);
				arbolbb.Inserta(59);
				
				arbolbb.Inserta(50);
				arbolbb.Inserta(77);
				arbolbb.Inserta(11);
				
				
		System.out.println("contendio del arbol");
		System.out.println();
		Met(arbolbb.DameRaiz());
		System.out.println();
		System.out.println(" PREORDEN-> ");
		
		arbolbb.PreOrden(arbolbb.DameRaiz());
		System.out.println();
		System.out.println("POSORDEN-> ");
		arbolbb.PosOrden(arbolbb.DameRaiz());
		
	}
	
	public static void Met(NodoABB<Integer> Raiz){
		if(Raiz==null)
			return;
		Met(Raiz.DameSubIzq());
		System.out.print(Raiz.Info+",");
		Met(Raiz.DameSubDer());
			
	}

}
