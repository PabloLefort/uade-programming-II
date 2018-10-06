public inteface ColaTDA {

  // Inicializa la cola
  void InicializarCola();

  // Permite agregar un elemento a la Colar
  // PRE: cola inicializada
  // POS: cola con un elemento mas
  void Acolar(int x);

  // Permite eliminar el primer elemento agregado
  // PRE: cola inicializada y con uno o más elementos
  // POS: cola con un elemento menos
  void Desacolar();

  // Retorna el primer elemento de la cola
  // PRE: cola inicializada y con uno o más elementos
  // POS: -
  int Primero();

  // Retorna true si la cola no tiene elementos, false en caso contrario
  // PRE: cola inicializada
  // POS: -
  boolean ColaVacia();
}
