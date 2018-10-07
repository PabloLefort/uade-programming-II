public class Cola implements ColaTDA {
  int[] valores;
  int cantidad;

  public void InicializarCola(){
    valores = new int[100];
    cantidad = 0;
  }

  public void Acolar(int x){
    for (int i = cantidad; i > 0; i--) {
      this.valores[i] = this.valores[i-1]
    }
    this.valores[0] = x;
    this.cantidad++;
  }

  public void Desacolar(){
    this.valores[this.cantidad] = null;
    this.cantidad--;
  }

  public int Primero(){
    return this.valores[this.cantidad-1]
  }

  public boolean ColaVacia(){
    return (this.cantidad == 0)
  }

}
