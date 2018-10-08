public interface DiccionarioMultipleTDA {

  // Inicializa el diccionario
  void InicializarDiccionario();

  // Permite agregar un elemento al conjunto relacionado con la clave. Estos
  // elementos no se repiten
  // PRE: diccionario inicializado
  // POS: diccionario con un elemento mas en el conjunto de la clave
  void Agregar(int clave, int valor);

  // Elimina la clave y el conjunto relacionado a la misma
  // PRE: diccionario inicializado y clave existente
  // POS: diccionario con conjunto y clave menos
  void Eliminar(int clave);

  // Elimina el valor del conjunto de la clave en caso de que exista la misma.
  // Si luego de eliminar el valor del conjunto el mismo queda vacio se elimina
  // la clave
  // PRE: diccionario inicializado
  // POS: diccionario con clave menos o conjunto asociado con un elemento menos
  void EliminarValor(int clave, int valor);

  // Retorna el conjunto de valores segun una clave. En caso de no existir la
  // clave retorna un conjunto vacio
  // PRE: diccionario inicializado
  // POS: -
  ConjuntoTDA Recuperar(int clave);

  // Retorna el conjunto de todas las claves del diccionario
  // PRE: diccionario inicializado
  // POS: -
  ConjuntoTDA Claves();
}
