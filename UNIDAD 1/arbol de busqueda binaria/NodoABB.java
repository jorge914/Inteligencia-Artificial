public class NodoABB<T> {
	   private NodoABB <T>   SubIzq;
	   public T Info;
	   private NodoABB<T>   SubDer;
	   public NodoABB(T d)
	   {  Info=d;
	      SubIzq=null; SubDer=null;
	   	}
	   public NodoABB<T> DameSubIzq(){
		   return SubIzq;
	   }
	   public NodoABB<T> DameSubDer(){
		   return SubDer;
	   }
	   public void setSubIzq(NodoABB<T> Ap){
		   SubIzq=Ap;
	   }
	   public void setSubDer(NodoABB<T> Ap){
		   SubDer=Ap;
	   }

}

