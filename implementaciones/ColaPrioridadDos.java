public class ColaPrioridad implements ColaPrioridadTDA {
  class Elemento {
    int valor;
    int prioridad;
  }

  Elemento[] elementos;
  int cantidad;

  public void InicializarCola(){
    elementos = new Elemento[100];
    cantidad = 0;
  }

  public void Acolar(int x, int prioridad){
    int i = this.cantidad;
    for (; i > 0 && this.elementos[i].prioridad >= prioridad; i--) {
      this.elementos[i] = this.elementos[i-1];
    }
    this.elementos[i] = new Elemento();
    this.elementos[i].valor = x;
    this.elementos[i].prioridad = prioridad;
    this.cantidad++;
  }

  public void Desacolar(){
    this.elementos[this.cantidad-1] = null;
    this.cantidad--;
  }

  public int Primero(){
    return this.elementos[this.cantidad-1].valor;
  }

  public int Prioridad(){
    return this.elementos[this.cantidad-1].prioridad;
  }

  public boolean ColaVacia(){
    return (this.cantidad == 0)
  }

}
