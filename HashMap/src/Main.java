import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        PhoneBook phoneBook = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        String eleccion = " --- Phone Book Menu --- \n1. Add/Update Contact\n2.Delete Contact\n3.Search Contact\n4.List All Contact\n5.Exist";

        System.out.println(eleccion);

        System.out.print("Enter your choice : ");

        int numero = sc.nextInt();

        while (numero != 5) {
            switch (numero) {
                case 1:
                    System.out.print("Enter a contact name : ");
                    String clave = sc2.nextLine();
                    System.out.print("\nEnter a phone number : ");
                    int valor = sc.nextInt();
                    phoneBook.añadirActualizar(clave, valor);
                    break;
                default:
                    break;
                case 2:
                    System.out.print("Enter a contact name to delete : ");
                    String clave2 = sc2.nextLine();
                    if (!phoneBook.delete(clave2)) {
                        System.out.println("Contact delete successfully");
                    } else {
                        System.out.println("The contact doesnt exisist");
                    }
                    break;
                case 3:
                    System.out.print("Enter the contact name to search : ");
                    String clave3 = sc2.nextLine();
                    phoneBook.buscar(clave3);
                    break;
                case 4:
                    System.out.println("Contacts in the phone book :");
                    phoneBook.ListarC();
                    break;
            }
            System.out.println(eleccion);
            System.out.print("Enter your choice : ");
            numero = sc.nextInt();
        }
        sc.close();
        sc2.close();
    }
}
