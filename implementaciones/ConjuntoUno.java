public class Conjunto implements ConjuntoTDA {
  int[] valores;
  int cantidad;

  public void InicializarConjunto(){
    this.valores = new int[100];
    this.cantidad = 0;
  }

  public void Agregar(int x){
    if(!this.Pertenece(x)){
      this.valores[this.cantidad] = x;
      this.cantidad++;
    }
  }

  public int Elegir(){
    return this.valores[this.cantidad-1];
  }

  public int Sacar(int x){
    for (int i = 0; i < this.cantidad; i++) {
      if(this.valores[i] == x){
        if(i+1 < this.cantidad){
          this.valores[i] = this.valores[this.cantidad-1];
        }
        this.valores[this.cantidad-1] = null;
        break;
      }
    }
  }

  public boolean Pertenece(int x){
    for (int i = 0; i < this.cantidad; i++) {
      if(this.valores[i] == x){
        return true
      }
    }
    return false;
  }

  public boolean ConjuntoVacio(){
    return (this.cantidad == 0)
  }
}
