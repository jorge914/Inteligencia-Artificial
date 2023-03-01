
public class Lista <T>{

    private Nodo <T>  Frente;
    public T Dr; 
    private Nodo<T> Fin;
     public Lista() {
     
    Frente=Fin=null;
          Dr=null;
    }

     public Nodo<T> DameFrente (){
             return Frente;

    }

    public Nodo<T> DameFin (){
             return Fin;

    }
    public boolean InsertaFrente(T Dato){

        Nodo<T> Nuevo=new Nodo<T> (Dato);
         if(Nuevo == null)
            return false;
           
			if(Frente == null){
				
			
           Frente= Fin = Nuevo;
           return true;
			}
    
        Nuevo.setSig(Frente);
        Frente=Nuevo;
        return true;

         }
    



public boolean InsertaFin(T Dato){

    Nodo<T> Nuevo=new Nodo<T> (Dato);
     if(Nuevo == null)
        return false;
     
     
		if(Frente == null)
	  {
       Frente= Fin = Nuevo;
       return true;
		}
     

    Fin.setSig(Nuevo);
    Fin=Nuevo;
    return true;

}


    public boolean InsertaOrd(T Dato){
    	Nodo<T> Nuevo = new Nodo<T>(Dato);
    	if(Nuevo==null)
    	return false;
    	
    	if(Frente==null)
    	{
    		Frente=Fin=Nuevo;
    		return true;
    	}
    	if(Nuevo.info.toString().compareTo(Frente.info.toString())<=0)
    	{
          Nuevo.setSig(Frente);
          Frente=Nuevo;
          return true;
    	}
    	if(Nuevo.info.toString().compareTo(Fin.info.toString())>=0)
    	{
    	Fin.setSig(Nuevo);	
    	Fin=Nuevo;
    	return true;
    	}
		
   Nodo <T> Ant=null, Aux =Frente;
   while (Aux.info.toString().compareTo(Nuevo.info.toString())<0){
    	Ant=Aux;
    	Aux=Aux.Damesig();
    	}
   
   Ant.setSig(Nuevo);
   Nuevo.setSig(Aux);
   return true;
   	}
    
    public void EstadoActual(){
    	boolean band=false;
    	Nodo <T >
        Aux=Frente;
    	while(Aux!=null){
    		System.out.println(Aux.info);
    		Aux=Aux.Damesig();
    	}
	}
    
    public boolean Retira(T Dato){
		String Id_Nuevo=Dato.toString();
		String Id_Nodo;
		//Buscar el nodo que contiene id_nuevo
		Nodo<T> Tra=Frente,Ant=null;
		boolean Band=false;
		while (Tra!=null){
			
			Id_Nodo=Tra.info.toString();
			if(Id_Nuevo.equals(Id_Nodo)){
				Band=true;
				break;
			}
			Ant=Tra;
			
			Tra=Tra.Damesig();
		}
		if(!Band)
			return false;
		Dr=Tra.info;
		//Borrar el  inico nodo de la lista
		if(Frente==Fin){
			Frente=Fin=null;
			return true;
		}
		// Borrar el primer nodo de la lista
		if(Tra==Frente){
			Frente=Frente.Damesig();
			return true;
		}
		//Borrar el  ltimo no de la lista
		if(Tra==Fin){
			Fin=Ant;
			Fin.setSig(null);
			return true;
		}
		// entre dos nodos
		Ant.setSig(Tra.Damesig());
		return true;
	}

    
    
   }

