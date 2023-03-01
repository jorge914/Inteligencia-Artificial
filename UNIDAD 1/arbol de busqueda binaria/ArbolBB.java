public class ArbolBB <T> {
	private NodoABB<T> Root;
	public  T           Dr;

	public ArbolBB(){
		Root=null;
		Dr=null;
	}
	
	public NodoABB<T> DameRaiz(){
		return Root;
	}
	public boolean Inserta(T Dato){
		return Inserta(Root,Dato);
	}
	private boolean Inserta(NodoABB<T> Raiz, T Dato){
		if(Root==null){
			Root=new NodoABB<T>(Dato);
			return true;
		}
		if(Dato.toString().compareTo(Raiz.Info.toString()   )==0  ){
			return false;
		}
		if(Dato.toString().compareTo(Raiz.Info.toString()   )<0  ){
			if(Raiz.DameSubIzq()!=null){
				return Inserta(Raiz.DameSubIzq(),Dato);
			}
			else {
				NodoABB<T> Nuevo=new NodoABB<T>(Dato);
				Raiz.setSubIzq(Nuevo);
				return true;
			}
		}
		else {
			if(Raiz.DameSubDer()!=null){
				return Inserta(Raiz.DameSubDer(),Dato);
			}
			else {
				NodoABB<T> Nuevo=new NodoABB<T>(Dato);
				Raiz.setSubDer(Nuevo);
				return true;
			}			
			
		}
	}
	public int length(NodoABB<T> Raiz){
		if(Raiz==null)
			return 0;
		return length(Raiz.DameSubIzq()) +1 + length(Raiz.DameSubDer() );
	}
	public int Altura(NodoABB<T> Raiz,int Nivel){
		if(Raiz==null)
			return 0;
		int NSIzq=Altura(Raiz.DameSubIzq(),Nivel+1);
		if(Nivel>NSIzq)
			NSIzq=Nivel;
		int NSDer=Altura(Raiz.DameSubDer(),Nivel+1);
		if(NSIzq>NSDer)
			return NSIzq;
		return NSDer;
	}
	
	
	
	
	
	public boolean Busca(NodoABB<T> Raiz, T Dato){
		if(Raiz==null){
			Dr=null;
			return false;
		}
		if( Dato.toString().compareTo(Raiz.Info.toString())==0    ){
			Dr=Raiz.Info;
			return true;
		}
		if( Dato.toString().compareTo(Raiz.Info.toString())>0    ){
			
			return Busca(Raiz.DameSubDer(),Dato);
		}
		return Busca(Raiz.DameSubIzq(),Dato);
	}
    public boolean Retira(NodoABB<T> R, T Infor) {
  	boolean b=true;
  	NodoABB<T> Ant=null;
  	String Llave=Infor.toString();
  	while (R != null) {
  	   if ( Llave.compareTo( R.Info.toString()  )  < 0 )
  	   {
  	      Ant=R;
  	      R=R.DameSubIzq();
  	      b=false;
  	   }
  	   else
 	          if ( Llave.compareTo( R.Info.toString()  )  > 0 )
 	          {
 	          	 Ant=R;
  	         R=R.DameSubDer();
  	         b=true;
  	      }
  	      else
  	         break;// Localizo el nodo
  	}
  	if (R==null)
  	   return false;
  	if (R.DameSubIzq() != null && R.DameSubDer() != null)  // Tiene dos hijos
  	{
  	    // Buscamos el nodo mas pequeño del subárbol derecho
  		NodoABB<T> Temp=R.DameSubDer();
  		NodoABB<T> Aux=R;
  		boolean RamaIzq=false;
  		while (Temp.DameSubIzq() != null)
  		{
  		   Aux=Temp;
  		   Temp=Temp.DameSubIzq();
  		   RamaIzq=true;
  		}
  	    // sustituyo valor
  	    Dr = R.Info;
  		R.Info = Temp.Info;
          // Elimino el nodo que sustituye
  		if (RamaIzq)
  		{
  		   if (Temp.DameSubIzq() == null)
  		      Aux.setSubIzq(Temp.DameSubDer());
  		   else
  		      Aux.setSubIzq(Temp.DameSubIzq());
  		}
  		else
  		{
  		      Aux.setSubDer(Temp.DameSubDer());
  		}
          return true;
  	}
  	else
  	{
  		if (R==Root)//Borrando la raiz y puede tener uno o cero hijos
  		{
  			Dr=R.Info;
  			if (R.DameSubIzq()==null)
  			   Root=R.DameSubDer();
  			else
  			   Root=R.DameSubIzq();
  	    }
  	    else // Resto de nodos con cero o un hijo
  	    {
  	    	Dr=R.Info;
  		   if (R.DameSubIzq() == null)
  		      if (b)
  		         Ant.setSubDer(R.DameSubDer());
  		      else
  		         Ant.setSubIzq(R.DameSubDer());
  		   else
  		      if (b)
  		         Ant.setSubDer(R.DameSubIzq());
  		      else
  		         Ant.setSubIzq(R.DameSubIzq());
  		}
  	}
  	return true;
  }
    
    public  void PreOrden(NodoABB<T> Raiz){
		if(Raiz==null)
			return;
		System.out.print(Raiz.Info+",");
		PreOrden(Raiz.DameSubIzq());
		
		PreOrden(Raiz.DameSubDer());
			
	}
    public  void PosOrden(NodoABB<T> Raiz){
		if(Raiz==null)
			return;
		
		PosOrden(Raiz.DameSubIzq());
		PosOrden(Raiz.DameSubDer());
		System.out.print(Raiz.Info+",");
			
	}
}
