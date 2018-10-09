public class ABB implements ABBTDA {

  class Nodo {
    int valor;
    ABBTDA HijoIzq;
    ABBTDA HijoDer;
  }

  Nodo raiz;

  public void InicializarArbol(){
    this.raiz = null;
  }

  public void AgregarElem(int x){
    if(this.raiz == null){
      Nodo this.raiz = this.InicializarNodo(x);
    } else {
      if(x < this.raiz.valor)
        this.raiz.HijoIzq.AgregarElem(x);
      else
        this.raiz.HijoDer.AgregarElem(x);
    }
  }

  private void InicializarNodo(int x){
    Nodo aux = new Nodo();
    aux.valor = x;
    ABBTDA aux.HijoIzq = new ABB();
    aux.HijoIzq.InicializarArbol();
    ABBTDA aux.HijoDer = new ABB();
    aux.HijoDer.InicializarArbol();
    return aux
  }

  public void EliminarElem(int x){
    if(x == this.raiz.HijoIzq.valor)
      this.raiz.HijoIzq = null;
    else if(x == this.raiz.HijoDer.valor)
      this.raiz.HijoDer = null;
    else if(x < raiz.valor)
      this.raiz.HijoIzq.EliminarElemArbol(x);
    else
      this.raiz.HijoDer.EliminarElemArbol(x);
  }

  public int Raiz(){
    return this.raiz.valor;
  }

  public ABBTDA HijoIzq(){
    return this.raiz.HijoIzq;
  }

  public ABBTDA HijoDer(){
    return this.raiz.HijoDer;
  }

  public boolean ArbolVacio(){
    return (this.raiz == null);
  }
}
