public class Pila implements PilaTDA {
  int[] valores;
  int cantidad;

  public void InicializarPila(){
    valores = new int[100];
    cantidad = 0;
  }

  public void Apilar(int x){
    for (int i = cantidad; i > 0; i--) {
      this.valores[i] = this.valores[i-1];
    }
    this.valores[0] = x;
    this.cantidad++;
  }

  public void Desapilar(){
    for (int i = 0; i < cantidad; i++) {
      this.valores[i] = this.valores[i++];
    }
    this.valores[cantidad] = null;
    this.cantidad--;
  }

  public boolean PilaVacia(){
    return (this.cantidad == 0)
  }

  public int Tope(){
    return this.valores[0];
  }
}
