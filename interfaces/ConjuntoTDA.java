public interface ConjuntoTDA {

  // Inicializa el conjunto
  void InicializarConjunto();

  // Permite agregar un elemento al conjunto. En caso de existir anteriormente
  // no se agrega el elemento.
  // PRE: conjunto inicializado
  // POS: conjunto con un elemento mas
  void Agregar(int x);

  // Permite eliminar el elemento del conjunto
  // PRE: conjunto inicializado, elemento existente en el conjunto
  // POS: conjunto con un elemento menos
  void Sacar(int x);

  // Retorna un elemento al azar del conjunto
  // PRE: conjunto inicializado y con uno o mas elementos
  // POS: -
  int Elegir(int x);

  // Retorna true si el elemento existe, false en caso contrario
  // PRE: conjunto inicializado
  // POS: -
  boolean Pertenece(int x);

  // Retorna true si el conjunto se encuentra vacio, false en caso contrario
  // PRE: conjunto inicializado
  // POS: -
  boolean ConjuntoVacio();
}
