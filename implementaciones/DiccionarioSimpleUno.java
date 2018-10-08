public class DiccionarioSimple implements DiccionarioSimpleTDA {
  class Elemento {
    int clave;
    int valor;
  }

  Elemento[] elementos;
  int cantidad;

  public void InicializarDiccionario(){
    this.elementos = new Elemento[100];
    this.cantidad = 0;
  }

  public void Agregar(int clave, int valor){
    this.elementos[this.cantidad] = new Elemento();
    this.elementos[this.cantidad].clave = clave;
    this.elementos[this.cantidad].valor = valor;
    this.cantidad++;
  }

  public void Eliminar(int clave){
    for (int i = 0; i < this.cantidad; i++) {
      if(this.elementos[i].clave == clave){
        if(i+1 < this.cantidad){
          this.elementos[i] = this.elementos[this.cantidad-1];
        }
        this.elementos[this.cantidad-1] = null;
      }
    }
  }

  public int Recuperar(int clave){
    for (int i = 0; i < this.cantidad; i++) {
      if(this.elementos[i].clave == clave){
        return this.elementos[i].valor;
      }
    }
  }

  public ConjuntoTDA Claves(){
    ConjuntoTDA conjunto = new Conjunto();
    conjunto.InicializarConjunto();
    for (int i = 0; i < this.cantidad; i++) {
      conjunto.Agregar(this.elementos[i].clave)
    }
    return conjunto
  }
}
