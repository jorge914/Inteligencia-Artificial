
class Nodo<T>
{
   public T info;
   private Nodo <T> sig;
   public Nodo (T d)
   {
   info = d;
   sig =null;
   }
    public Nodo <T> Damesig(){
       return sig;
   } 

   	public void setSig(Nodo <T> Ap)
   	{

         sig = Ap;
   	}

}
