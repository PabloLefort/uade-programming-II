public interface TDAPlanillaNotas {

  // Inicializa la planilla
  // PRE: -
  // POS: -
  void inicializar();

  // Permite agregar una nota a un alumno. Si el alumno no existe lo crea y
  // le asigna la nota, caso contrario se la asigna
  // PRE: planilla inicializada
  // POS: alumno con una nota mas
  void agregar(int libreta, int nota);

  // Permite eliminar el alumno y sus notas
  // PRE: planilla inicializada
  // POS: planilla con una libreta menos
  void eliminar(int libreta);

  // Retorna un diccionario simple con los promedios de las notas de los alumnos
  // PRE: planilla inicializada
  // POS: -
  TDADiccionarioSimple promedios();

  // Retorna conjunto alumnos que tienen notas mayores o iguales a cuatro
  // PRE: planilla inicializada
  // POS: -
  TDAConjunto aprobados();

  // Retorna una cola con todas las notas del alumno
  // PRE: planilla inicializada y alumno existente
  // POS: -
  TDACola notas(int libreta);

  // Retorna true si la planilla esta vacia, false en caso contrario
  // PRE: planilla inicializada
  // POS: -
  boolean estaVacia();
}


public class PlanillaNotas implements TDAPlanillaNotas {
  class NodoAlumno {
    int libreta;
    NodoNota notas;
    NodoAlumno sigA;
  }

  class NodoNota {
    int nota;
    NodoNota sigN;
  }

  public void agregar(int libreta, int nota){
    NodoAlumno aux = this.primero;
    while(aux.libreta != libreta){
      aux = this.primero.sigA;
    }
    if(aux.notas == null){
      NodoNota aux.notas = new NodoNota();
      aux.notas.nota = nota;
      aux.notas.sigN = null;
    } else {
      NodoNota auxNota = aux.notas;
      while(auxNota.sigN)
        auxNota = auxNota.sigN;
      auxNota = new NodoNota();
      auxNota.nota = nota;
      auxNota.sigN = null;
    }
  }

  public TDADiccionarioSimple promedios(){
    TDADiccionarioSimple diccionario = new DiccionarioSimple();
    diccionario.InicializarDiccionario();
    NodoAlumno auxAlu = this.primero;
    while(auxAlu.sigA){
      diccionario.Agregar(auxAlu.libreta, this.getPromedio(auxAlu));
      auxAlu = auxAlu.sigA;
    }
    return diccionario;
  }

  private int getPromedio(NodoAlumno alumno){
    int notas = 0;
    int cantNotas = 0;
    NodoNota auxNota = alumno.notas;
    while(auxNota.sigN){
      notas += auxNota.nota;
      cantNotas++;
    }
    return int(notas / cantNotas);
  }

  public TDAConjunto aprobados(){
    TDAConjunto conjunto = new Conjunto();
    conjunto.InicializarConjunto();
    NodoAlumno auxAlu = this.primero;
    while(auxAlu.sigA){
      int promedio = this.getPromedio(auxAlu);
      if(promedio >= 4){
        conjunto.Agregar(auxAlu.libreta);
      }
      auxAlu = auxAlu.sigA;
    }
    return conjunto;
  }
}





public boolean equilibrados(TDAGrafo grafo, ABBTDA arbol){
  ConjuntoTDA vertices = new Conjunto();
  vertices = grafo.Vertices();
  NodoGrafo auxV = vertices.Sacar();
  boolean equ;
  while(auxV){
    if(verticeExisteABB(arbol, auxV.valor)){
      int difAristas = diferenciaAristas(grafo, auxV, vertices);
      int difArbol = diferenciaArbol(arbol, auxV.valor);
      if(difAristas == difArbol){
        auxV = vertices.Sacar();
        equ = true;
      } else {
        auxV = null;
        equ = false;
      }
    }
  }
  return equ;
}

private boolean verticeExisteABB(ABBTDA arbol, int x){
  if(arbol.Raiz() == x){
    return true;
  } else {
    if(arbol.Raiz() < x && !arbol.HijoDer.ArbolVacio())
      return verticeExisteABB(arbol.HijoDer, x);
    else if(arbol.Raiz() > x && !arbol.HijoIzq.ArbolVacio())
      return verticeExisteABB(arbol.HijoIzq, x);
    else
      return false;
  }
}

private int diferenciaAristas(GrafoTDA grafo, NodoGrafo nodo, ConjuntoTDA vertices){
  int salientes = 0;
  NodoArista auxA = nodo.arista;
  while(auxA){
    salientes += auxA.peso;
    auxA = auxA.proxA;
  }

  int entrantes = 0;
  NodoGrafo auxV = vertices.Sacar();
  while(auxV){
    if(grafo.ExisteArista(auxV, nodo))
      entrantes += grafo.PesoArista(auxV, nodo);
    auxV = auxV.proxV;
  }

  return entrantes - salientes;
}

private int diferenciaArbol(ABBTDA arbol, int x){
  ABBTDA auxA = null;
  while(auxA.Raiz() != x){
    if(auxA.Raiz() > x)
      auxA = auxA.HijoIzq;
    else
      auxA = auxA.HijoDer;
  }
  return sumArbol(auxA.HijoIzq) - sumArbol(auxA.HijoDer)
}

private int sumArbol(ABBTDA arbol){
  if(arbol.HijoDer.ArbolVacio() && arbol.HijoIzq.ArbolVacio())
    return arbol.Raiz()
  else {
    if(arbol.HijoDer.ArbolVacio())
      return arbol.Raiz() + sumArbol(arbol.HijoIzq)
    else if (arbol.HijoIzq.ArbolVacio())
      return arbol.Raiz() + sumArbol(arbol.HijoDer)
    else
      return arbol.Raiz() + sumArbol(arbol.HijoDer) + sumArbol(arbol.HijoIzq)
  }
}




public TDAConjunto valores(ABBTDA arbol, TDAColaPrioridad cola){
  TDAConjunto conjunto = new Conjunto();
  conjunto.InicializarConjunto();
  if(arbol.ArbolVacio() || cola.ColaVacia())
    return conjunto;

  Nodo nodo = arbol.Raiz();
  while(nodo){
    if(existeValorCola(nodo.valor, cola)){
      int prioridad = obtenerPrioridad(nodo.valor, cola);
      int profundidadIzq = profundidadNodo(nodo.HijoIzq);
      int profundidadDer = profundidadNodo(nodo.HijoDer);
      if(prioridad == (profundidadIzq - profundidadDer))
        conjunto.Agregar(nodo.valor)
    }
  }
  return conjunto;
}

private boolean existeValorCola(int x, TDAColaPrioridad cola){
  int aux = cola.Primero();
  while(!cola.ColaVacia()){
    if(aux == x)
      return true;
    else {
      cola.Desacolar();
      if(cola.ColaVacia())
        return false;
      else
        aux = cola.Primero();
    }
  }
}

private int obtenerPrioridad(int x, TDAColaPrioridad cola){
  int aux = cola.Primero();
  while(!cola.ColaVacia()){
    if(aux == x)
      return cola.Prioridad();
    else {
      cola.Desacolar();
      aux = cola.Primero();
    }
  }
}

private int profundidadNodo(Nodo nodo){
  if(nodo.HijoDer.ArbolVacio() && nodo.HijoIzq.ArbolVacio())
    return 1;
  else {
    if(nodo.HijoDer.ArbolVacio())
      return 1 + diferenciaArbolDescAsc(nodo.HijoIzq);
    else if (nodo.HijoIzq.ArbolVacio())
      return 1 + diferenciaArbolDescAsc(nodo.HijoDer);
    else
      return 1 + diferenciaArbolDescAsc(nodo.HijoDer) + diferenciaArbolDescAsc(nodo.HijoIzq);
  }
}
