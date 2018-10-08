public class DiccionarioMultiple implements DiccionarioMultipleTDA {
  class Elemento {
    int clave;
    int[] valores;
    int cantValores;
  }

  Elemento[] elementos;
  int cantidad;

  public void InicializarDiccionario(){
    this.elementos = new Elemento[100];
    this.cantidad = 0;
  }

  public void Agregar(int clave, int valor){
    for (int i = 0; i < cantidad; i++) {
      if(this.elementos[i].clave == clave){
        this.elementos[i].valores[this.elementos[i].cantValores] = valor;
        this.elementos[i].cantValores++;
        return
      }
    }
    this.elementos[this.cantidad] = new Elemento();
    this.elementos[this.cantidad].clave = clave;
    this.elementos[this.cantidad].valores = new int[100];
    this.elementos[this.cantidad].valores[0] = valor;
    this.elementos[this.cantidad].cantValores = 1;
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

  public void EliminarValor(int clave, int valor){
    for (int i = 0; i < this.cantidad; i++) {
      if(this.elementos[i].clave == clave){
        for (int j = 0; j < this.elementos[i].cantValores; j++) {
          if(this.elementos[i].valores[j] == valor){
            int cantValores = this.elementos[i].cantValores;
            if(j+1 < cantValores){
              this.elementos[i].valores[j] = this.elementos[i].valores[cantValores-1];
            }
            this.elementos[i].valores[cantValores-1] = null;
          }
        }
      }
    }
  }

  public ConjuntoTDA Recuperar(int clave){
    ConjuntoTDA conjunto = new Conjunto();
    conjunto.InicializarConjunto();
    for (int i = 0; i < this.cantidad; i++) {
      if(this.elementos[i].clave == clave){
        for (int j = 0; j < this.elementos[i].cantValores; j++) {
          conjunto.Agregar(this.elementos[i].valores[j])
        }
      }
    }
    return conjunto
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
