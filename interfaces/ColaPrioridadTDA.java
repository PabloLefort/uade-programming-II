public interface ColaPrioridadTDA {

  // Inicializa la cola con prioridad
  void InicializarCola();

  // Permite agregar un elemento a la cola con una prioridad
  // PRE: cola inicializada
  // POS: cola con un elemento mas
  void Acolar(int x, int prioridad);

  // Permite eliminar el elemento con mayor prioridad. En caso de existir
  // dos o mas elementos con la misma prioridad se elimina el primero ingresado
  // PRE: cola inicializada y con uno o mas elementos
  // POS: cola con un elemento menos
  void Desacolar();

  // Retorna el elemento con mayor prioridad. En caso de existir dos o mas
  // elementos con la misma prioridad se retorna el primero ingresado
  // PRE: cola inicializada y con uno o mas elementos
  // POS: -
  int Primero();

  // Retorna el valor de la prioridad mas alta
  // PRE: cola inicializada y con uno o mas elementos
  // POS: -
  int Prioridad();

  // Retorna true si la cola se encuentra vacia, false en caso contrario
  // PRE: cola inicializada
  // POS: -
  boolean ColaVacia();
}
