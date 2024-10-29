
public class Trees {
    private Nodo root;

    public void insert(int data) {
        this.root = insertRec(root, data);

    }

    // Insercuin de datos recursiva
    private Nodo insertRec(Nodo root, int data) {
        // si el root esta vacio entonces solo ponemos el dato dentro
        if (root == null)
            root = new Nodo(data);
        // si no estsa vacio entonces si el dato que estramos poniendo es menor que root
        // entonces lo ponemos en la izquierda
        else if (root.data > data)
            root.left = insertRec(root.left, data);
        // si no estsa vacio entonces si el dato que estramos poniendo es mayor que root
        // entonces lo ponemos en la derecha
        else if (root.data < data)
            root.right = insertRec(root.right, data);

        return root;
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Nodo root, int data) {
        // Si el root esta vacio o root es igual al dato que le damos devuelve en el
        // primer caso del if = false y en el segudo caso si es igual true este seria el
        // caso base ya que en el momento en el que pasemos recorriendo y el numero sea
        // igual nos devolvera true si no esta o es ta vacio nos veolvera false
        if (root == null || root.data == data)
            return root != null;
        // con esto pasando el primero if lo que tenemos es que si el el dato que
        // estamos buscando es mayor que en el qeu estamos ahora (root) vamos a movernos
        // a la derecha si no iremos directamente a las derecha
        else if (root.data < data)
            return searchRec(root.right, data);

        return searchRec(root.left, data);
        // y el ciclo se repite recoriendo el todo hasta que o lo encontremos o no
        // exista en todo el arbol
    }

    public void inorder() {
        inorderRec(root);
        System.out.println("\n");
    }

    private void inorderRec(Nodo root) {
        // comprobamos que no esta vacio
        if (root != null) {
            // al ser inorder empezamos imprimiendo la izquierda antes que el root hasta que
            // no encontremos nada mas a la izquierda
            inorderRec(root.left);
            // lo imprimimos
            System.out.print(root.data + " ");
            // en el caso en el que ya no haya nada mas a la derecha imprimimos la derecha
            inorderRec(root.right);
        }
    }

    public boolean estrict() {
        return estrticRec(root);
    }

    private boolean estrticRec(Nodo root) {
        // si el root esta vacio (no hay nada) es estricto
        if (root == null)
            return true;
        // si no tiene hijos es estricto
        if (root.left == null && root.right == null)
            return true;

        // si tieien 2 hijos es estricto y se mete dentro de los hijos para ver si ellos
        // cumplen las demas condiciones
        if (root.left != null && root.right != null)
            return estrticRec(root.left) && estrticRec(root.right);

        // si algunos de los hijos tienen 1 solo hijo no es estricto
        return false;
    }

    public int altura() {
        return this.alturaRec(root);
    }

    private int alturaRec(Nodo root) {
        // si el nodo es null no se suma nada
        if (root == null) {
            return 0;
        }
        // aqui obtenemos las alturas de cada parte de cada rama
        int alturaIzq = alturaRec(root.left);
        int alturaDere = alturaRec(root.right);
        // aqui nos quedamos el mas grande de los dos le sumamos uno pq el primero no lo
        // cuneta
        return Math.max(alturaIzq, alturaDere) + 1;
    }

    public int maxValue() {
        return maxValueRec(root);
    }

    // se tiene que arreglar esto pq uso un atributo y se puede hacer sin el
    private int maxValueRec(Nodo root) {
        if (root == null) {
            return 0;
        }

        return Math.max(root.data, Math.max(maxValueRec(root.left), maxValueRec(root.right)));
    }

    public int numNodos() {
        return numNodosRec(root);
    }

    private int numNodosRec(Nodo root) {
        // si el nodo es null no se suma nada
        if (root == null) {
            return 0;
        }
        return (numNodosRec(root.left) + numNodosRec(root.right)) + 1;
    }

    public int hojas() {
        return hojasRec(root);
    }

    private int hojasRec(Nodo root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null || root.right != null) {
            return (hojasRec(root.left) + hojasRec(root.right));
        }

        return 1;
    }

    public boolean isIdentical(Trees other) {
        if (this.numNodos() != other.numNodos()) {
            return false;
        }
        return isIdenticalRec(this.root, other.root);
    }

    private boolean isIdenticalRec(Nodo thisroot, Nodo otheroot) {
        if (thisroot == null && otheroot == null) {
            return true;
        }

        if (thisroot.data == otheroot.data) {
            isIdenticalRec(thisroot.left, otheroot.left);
            isIdenticalRec(thisroot.right, otheroot.right);
            return true;
        }

        return false;
    }

    public int sumatorio() {
        return sumatorioRec(root);
    }

    public int sumatorioRec(Nodo root) {
        if (root == null) {
            return 0;
        }
        return root.data + (sumatorioRec(root.left) + sumatorioRec(root.right));
    }

    public int sumPares() {
        return sumParesRec(root);
    }

    public int sumParesRec(Nodo root) {
        if (root == null) {
            return 0;
        }
        if (root.data % 2 == 0) {
            return root.data + (sumParesRec(root.left) + sumParesRec(root.right));
        }
        return sumParesRec(root.left) + sumParesRec(root.right);
    }
}