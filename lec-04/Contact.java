import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Contact {
    HashMap<String,String> contactlist = new HashMap<>();

    void show (){
        for (String key : contactlist.keySet()){
            System.out.printf("%s %s\n", key, contactlist.get(key));
        }
    }

    void find (String name){
        innerfun(name,1);
    }

    void add (String name, String number){
        if (contactlist.containsKey(name))
        {
            System.out.printf("%s is already in contact list\n", name);
        }
        else {
            contactlist.put(name, number);
        }
    }

    void delete(String name){
        innerfun(name,2);
    }

    private void innerfun (String name, int option){
        Iterator<String> keys = contactlist.keySet().iterator(); // just use for iterator (it can be simplified by containkeys method)
        while (keys.hasNext()){
            String key = keys.next();
            if (key.equals(name)){
                if (option == 1) {
                    System.out.print(contactlist.get(key));
                    System.out.print("\n");
                }
                else {
                    contactlist.remove(key);
                }
                return;
            }
        }
        System.out.printf("No Information for %s\n", name);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Contact listed = new Contact();
        while (true) {
            System.out.print("Command: ");
            String input = scn.nextLine();
            String[] parts = input.split(" ");

            if (parts[0].equals("add")) {
                listed.add(parts[1], parts[2]);
            } else if (parts[0].equals("find")) {
                listed.find(parts[1]);
            } else if (parts[0].equals("delete")) {
                listed.delete(parts[1]);
            } else if (parts[0].equals("show")) {
                listed.show();
            } else if (parts[0].equals("end")) {
                break;
            } else {
                System.out.print("Wrong Input, Try Again\n");
            }
        }
    }
}
