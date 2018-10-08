public class ColaPrioridad implements ColaPrioridadTDA {
  int[] valores;
  int[] prioridades;
  int cantidad;

  public void InicializarCola(){
    valores = new int[100];
    prioridades = new int[100];
    cantidad = 0;
  }

  public void Acolar(int x, int prioridad){
    int i = this.cantidad;
    for (; i > 0 && this.prioridades[i] >= prioridad; i--) {
      this.valores[i] = this.valores[i-1];
      this.prioridades[i] = this.prioridades[i-1];
    }
    this.valores[i] = x;
    this.prioridades[i] = prioridad;
    this.cantidad++;
  }

  public void Desacolar(){
    this.valores[this.cantidad-1] = null;
    this.prioridades[this.cantidad-1] = null;
    this.cantidad--;
  }

  public int Primero(){
    return this.valores[this.cantidad-1];
  }

  public int Prioridad(){
    return this.prioridades[this.cantidad-1];
  }

  public boolean ColaVacia(){
    return (this.cantidad == 0)
  }

}
