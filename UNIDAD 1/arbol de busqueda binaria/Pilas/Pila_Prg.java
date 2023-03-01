package stacky;

import java.util.Stack;

import pila.Pila;
import pila.PilaApp;
import practicas.Leer;

public class Pila_Prg {

	int memoria = 1000;
	double prjProcesador = 100;
	
	Stack <Programa> prog = new Stack();
	
	public int menu()
	{
		System.out.print("\n\n");
		System.out.println("1.- Agregar Programa");
		System.out.println("2.- Terminar Programa");
		System.out.println("3.- Verificar Programa En Ejecución");
		System.out.println("4.- Mostrar Programas Pendientes (Recorrer Programas)");
		System.out.println("5.- Ver Estatus Del Sistema (Memoria y Porcentaje De Procesador");
		System.out.println("6.- Salir");

		System.out.println();
	
		int op;
		do
		{		
			System.out.print("  Opcion:  ");
			op=Leer.datoInt();
		
		}while (op<1 || op>6);
		return op;
	}
	
	public void AggPrg()
	{
		
	if(memoria>0 && prjProcesador>0)
	{	
		boolean c=true;
		String nom;
		double prj;
		int memo;
		
		System.out.println("Teclea el nombre del programa");
		nom = Leer.dato();
		
		System.out.println("Teclea la cantidad de memoria que ocupa el programa");
		memo = Leer.datoInt();
		
		System.out.println("Teclea el porcentaje asignado del procesador");
		prj = Leer.datoDouble();
			
		
		if((prjProcesador - prj)<0 || (memoria - memo)<0)
			c=false;
		else
		{
			memoria -= memo;
			prjProcesador -= prj; 
		}
		
		if(c)
		{	
			Programa program = new Programa (nom, memo, prj);
			prog.push(program);
			System.out.println("Programa Añadido");
		}
		else
			System.out.println("Memoria Insuficiente o Porcentaje de Procesador Exedido");
	}
	else
		System.out.println("Memoria Llena o Porcentaje de Procesador en su limite");
	}
	
	public void FinishPrg()
	{
		if(prog.isEmpty())
		{
			System.out.println("Pila Vacia...");
		}
		else
		{
		Programa prg = prog.pop();
		
		memoria += prg.getMemoria();
		prjProcesador += prg.getPrjAsignado();
		
		System.out.println("Programa Terminado: \n"+prg.toString());
		}
	}
	
	public void veriProgExe()
	{
		if(prog.isEmpty())
		{
			System.out.println("Pila Vacia...");
		}
		else
			System.out.println("Prgrama En Ejecución: \n"+prog.peek().toString());
	}
	
	public void AllPrgs()
	{
		if(prog.isEmpty())
		{
			System.out.println("Pila Vacia...");
		}
		else
		{
			Stack <Programa> aux = new Stack();
			
			do
			{
				aux.push(prog.pop());
				System.out.println("\n"+aux.peek().toString());
				
			}while(prog.empty()==false);
			
			do
			{
				prog.push(aux.pop());
			}while(aux.isEmpty()==false);
			
			
		}
		
		
		
	}
	
	public void Status()
	{
		System.out.println("\nMemoria Disponible: "+memoria+"\nPorcentaje De Procesador Disponible: "+prjProcesador+"%");
	}
	
	
	public static void main(String[] args) 
	{
		int op;
		
		Pila_Prg pilita = new Pila_Prg();
		
		do
		{	
			op=pilita.menu();
					
			switch(op)
			{
				case 1: pilita.AggPrg();
				break;
				case 2: pilita.FinishPrg();
				break;
				case 3: pilita.veriProgExe();
				break;
				case 4: pilita.AllPrgs();
				break;
				case 5: pilita.Status();
				break;
			}
		}while(op != 6);
		
		System.out.println("Fin Del Programa....");	

	}

}
