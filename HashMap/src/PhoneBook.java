import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, Integer> PB;

    public PhoneBook() {
        this.PB = new HashMap<>();
    }

    public void añadirActualizar(String clave, Integer valor) {
        this.PB.put(clave, valor);
    }

    public boolean delete(String clave) {
        if (this.PB.remove(clave) == null || this.PB.isEmpty()) {
            return false;
        } else {
            return this.PB.remove(clave) != null;
        }
    }

    public void buscar(String clave) {
        if (this.PB.containsKey(clave)) {
            System.out.println(clave + " Phone number is : " + this.PB.get(clave));
        } else {
            System.out.println(clave + " no existe en nuestra agenda");
        }
    }

    public void ListarC() {
        if (this.PB.isEmpty()) {
            System.out.println("No hay numeros de telefono almacenados");
        } else {
            for (String name : PB.keySet()) {
                System.out.println("Name :" + name + " , Phone Namber : " + PB.get(name));
            }
        }
    }

}
