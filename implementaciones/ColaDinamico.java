public class Cola implements ColaTDA {
  class Nodo {
    int valor;
    Nodo sig;
  }

  Nodo primero;
  Nodo ultimo;

  public void InicializarCola(){
    this.primero = null;
    this.ultimo = null;
  }

  public void Acolar(int x){
    Nodo aux = new Nodo();
    aux.valor = x;
    aux.sig = null;

    if(this.ultimo){
      this.ultimo.sig = aux;
    }
    this.ultimo = aux;

    if(!this.primero){
      this.primero = this.ultimo;
    }
  }

  public void Desacolar(){
    this.primero = this.primero.sig;
    if(!this.primero){
      this.ultimo = null;
    }
  }

  public int Primero(){
    return this.primero.valor;
  }

  public boolean ColaVacia(){
    return (this.primero == null)
  }
}
