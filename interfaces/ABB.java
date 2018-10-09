public interface ABBTDA {

  // Inicializa el arbol
  // PRE: -
  // POS: arbol inicializado
  void InicializarArbol();

  // Permite agregar un elemento al arbol
  // PRE: arbol inicializado
  // POS: arbol con un elemento mas
  void AgregarElem(int x);

  // Permite eliminar un elemento del arbol
  // PRE: arbol inicializado y con elemento existente
  // POS: arbol con un elemento menos
  void EliminarElem(int x);

  // Retorna el valor de la raiz
  // PRE: arbol inicializado y no vacio
  // POS: -
  int Raiz();

  // Retorna el arbol del hijo izquierdo
  // PRE: arbol inicializado y no vacio
  // POS: -
  ABBTDA HijoIzq();

  // Retorna el arbol del hijo derecho
  // PRE: arbol inicializado y no vacio
  // POS: -
  ABBTDA HijoDer();

  // Retorna true si el arbol se encuentra vacio, false en caso contrario
  // PRE: arbol inicializado
  // POS: -
  boolean ArbolVacio();
}
