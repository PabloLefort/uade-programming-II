public interface DiccionarioSimpleTDA {

  // Inicializa el diccionario
  void InicializarDiccionario();

  // Permite agregar un elemento al diccionario
  // PRE: diccionario inicializado y con clave inexistente
  // POS: diccionario con un elemento mas
  void Agregar(int clave, int valor);

  // Permite eliminar un valor segun la clave
  // PRE: diccionario inicializado y con clave existente
  // POS: diccionario con un elemento menos
  void Eliminar(int clave);

  // Retorna el valor de un elemento segun la clave
  // PRE: diccionario inicializado y con clave existente
  // POS: -
  int Recuperar(int clave);

  // Retorna el conjunto de claves del diccionario
  // PRE: diccionario inicializado
  // POS: -
  ConjuntoTDA Claves();
}
