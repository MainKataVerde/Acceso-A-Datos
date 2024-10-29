public class Main {
    public static void main(String[] args) throws Exception {
        Trees tree = new Trees();
        Trees tree2 = new Trees();

        tree.insert(10);
        tree.insert(15);
        tree.insert(20);
        tree.insert(12);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(0);
        tree.insert(19);
        tree.insert(18);

        tree2.insert(10);
        tree2.insert(15);
        tree2.insert(20);
        tree2.insert(12);
        tree2.insert(2);
        tree2.insert(1);
        tree2.insert(3);
        tree2.insert(0);
        tree2.insert(19);
        tree.insert(17);

        tree.inorder();

        System.out.println("El numero 6 esta dentro del arbol : " + tree.search(6));
        System.out.println("El numero 11 esta dentro del arbol : " + tree.search(11));
        System.out.println("El arbol es estricto? " + tree.estrict());
        System.out.println("La altura de este arbol es : " + tree.altura());
        System.out.println("El valor mas grande del arbol es : " + tree.maxValue());
        System.out.println("Numero de nodos : " + (tree.numNodos() - 1));
        System.out.println("Numero de hojas : " + tree.hojas());
        System.out.println("Los arboles son iguales : " + tree.isIdentical(tree2));
        System.out.println("Sumatorio : " + tree.sumatorio());
        System.out.println("Sumatorio Pares : " + tree.sumPares());
    }
}
