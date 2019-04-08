public class Book {
    String name;
    boolean bowed;
    String borrower;

    Book (String name){
        this.name = name;
        bowed = false;
    }

    void borrowed (String borrower) {
        if (bowed == false) {
            bowed = true;
            this.borrower = borrower;
            System.out.print(this.borrower);
            System.out.print(" succeeds to borrow ");
            System.out.print(name);
            System.out.print("\n");
        }
        else {
            System.out.print("This Book is Already Borrowed, Sorry\n");
        }
    }

    void returned (String borrower) {
        if (this.borrower.equals(borrower)) {
            bowed = false;
            String temp = this.borrower;
            this.borrower = null;
            System.out.print(temp);
            System.out.print(" succeeds to return ");
            System.out.print(name);
            System.out.print("\n");
        }
        else
        {
            System.out.print("This Book is not Borrowed by ");
            System.out.print(borrower);
            System.out.print("\n");
        }
    }
}
