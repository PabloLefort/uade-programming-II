public interface GrafoTDA {

  // Inicializa el grafo
  // PRE: -
  // POS: grafo inicializado
  void InicializarGrafo();

  // Permite agregar un vertice
  // PRE: grafo inicializado
  // POS: grafo con un vertice mas
  void AgregarVertice(int x);

  // Permite eliminar un vertice del grafo
  // PRE: grafo inicializado y con elemento existente
  // POS: grafo con un elemento menos
  void EliminarVertice(int x);

  // Retorna un conjunto con todos los vertices del grafo
  // PRE: grafo inicializado
  // POS: -
  ConjuntoTDA Vertices();

  // Permite agregar una arista entre dos vertices
  // PRE: grafo inicializado, vertices existentes y arista inexistente entre ambos
  // POS: vertices con una arista
  void AgregarArista(int inicio, int destino, int peso);

  // Permite eliminar una arista entre dos vertices
  // PRE: grafo inicializado, vertices existentes y arista existente entre ambos
  // POS: vertices sin arista
  void EliminarArista(int inicio, int destino);

  // Retorna true si la arista existe entre los vertices dados, false en caso contrario
  // PRE: grafo inicializado y vertices existentes
  // POS: -
  boolean ExisteArista(int inicio, int destino);

  // Retorna el peso de una arista
  // PRE: grafo inicializado, vertices existentes y arista entre ambos
  // POS: -
  int PesoArista(int inicio, int destino);
}
