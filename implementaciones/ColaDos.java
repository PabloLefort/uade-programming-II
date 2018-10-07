public class Cola implements ColaTDA {
  int[] valores;
  int indice;

  public void InicializarCola(){
    valores = new int[100];
    indice = 0;
  }

  public void Acolar(int x){
    this.valores[this.indice] = x;
    this.indice++;
  }

  public void Desacolar(){
    for (int i = 0; i < this.indice; i++) {
      this.valores[i] = this.valores[i+1]
    }
    this.valores[this.indice] = null;
    this.indice--;
  }

  public int Primero(){
    return this.valores[0]
  }

  public boolean ColaVacia(){
    return (this.indice == 0)
  }

}
