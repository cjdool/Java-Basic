import java.util.Scanner;

public class Library {
    Book[] books = {new Book("Beauty and Beast"), new Book("Helen Keller"), new Book("Gulliver's Travel"), new Book("The Three Little Pigs")};
    String[] users = {"Sam", "Susan", "John"};

    public static int whoareyou (Library a){
        Scanner scn = new Scanner(System.in);
        System.out.print("Who are you? ");
        for (int i=0; i < a.users.length; i++)
        {
            System.out.print(i+1);
            System.out.print(". ");
            System.out.print(a.users[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
        return scn.nextInt()-1;
    }

    public static int whichbook (Library a){
        Scanner scn = new Scanner(System.in);
        System.out.print("Books: ");
        for (int i=0; i < a.books.length; i++)
        {
            System.out.print(i+1);
            System.out.print(".");
            System.out.print(a.books[i].name);
            System.out.print(" ");
        }
        System.out.print("\n");
        return scn.nextInt()-1;
    }

    public static void main(String[] args) {
        Library def = new Library();
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.print("0. Exit \n");
            System.out.print("1. Print Library Status \n");
            System.out.print("2. Borrow Book \n");
            System.out.print("3. Return Book \n");
            System.out.print("Please choose number: ");
            int a = scn.nextInt();

            if (a == 0)
            {
                break;
            }
            else if (a == 1)
            {
                for (int i=0; i< def.books.length; i++)
                {
                    System.out.print(def.books[i].name);
                    System.out.print(" is ");
                    if (!def.books[i].bowed)
                    {
                        System.out.print("valid\n");
                    }
                    else {
                        System.out.print("invalid\n");
                    }
                }
            }
            else if (a == 2)
            {
                int who = whoareyou(def);
                int whatbook = whichbook(def);
                def.books[whatbook].borrowed(def.users[who]);
            }
            else if (a == 3)
            {
                int who = whoareyou(def);
                int whatbook = whichbook(def);
                def.books[whatbook].returned(def.users[who]);
            }
            else
            {
                System.out.print("Wrong Input, Try Again \n");
            }

            System.out.print("\n");
        }
    }
}
