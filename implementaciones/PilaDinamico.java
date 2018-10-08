public class Pila implements PilaTDA {
  class Nodo {
    int valor;
    Nodo sig;
  }

  Nodo primero;

  public void InicializarPila(){
    this.primero = null;
  }

  public void Apilar(int x){
    Nodo aux = new Nodo();
    aux.valor = x;
    aux.sig = this.primero;
    this.primero = aux;
  }

  public void Desapilar(){
    this.primero = this.primero.sig;
  }

  public int Tope(){
    return this.primero.valor;
  }

  public boolean PilaVacia(){
    return (this.primero == null)
  }
}
