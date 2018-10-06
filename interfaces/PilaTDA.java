public interface PilaTDA {

    // Inicializa la pila
    void InicializarPila();

    // Agrega un elemento a la pila
    // PRE: pila inicializada
    // POS: pila con un elemento mas
    void Apilar(int x);

    // Elimina un elemento de la pila
    // PRE: pila inicializada y no vacia
    // POS: pila con un elemento menos
    void Desapilar();

    // Retorna true si la pila se encuentra vacia y false en caso contrario
    // PRE: pila inicializada
    boolean PilaVacia();

    // Retorna el valor del primer elemento de la pila
    // PRE: pila inicializada y no vacia
    int Tope();
}
