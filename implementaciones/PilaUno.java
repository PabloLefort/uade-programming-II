public class Pila implements PilaTDA {
  int[] valores;
  int indice;

  public void InicializarPila(){
    valores = new int[100];
    indice = 0;
  }

  public void Apilar(int x){
    this.valores[indice] = x;
    this.indice++;
  }

  public void Desapilar(){
    this.indice--;
  }

  public boolean PilaVacia(){
    return (this.indice == 0)
  }

  public int Tope(){
    return this.valores[indice-1];
  }
}
