public class Lec3 {
    static void printout (Cat A, Cat B, Dog C, Dog D, Crocodile E, Crocodile F){
        System.out.printf("Cat1 name: %s, weight: %f, slave name: %s\n", A.getName(), A.getWeight(), A.getNameSlave());
        System.out.printf("Cat2 name: %s, weight: %f, slave name: %s\n", B.getName(), B.getWeight(), B.getNameSlave());
        System.out.printf("Dog1 name: %s, weight: %f, master name: %s\n", C.getName(), C.getWeight(), C.getMaster());
        System.out.printf("Dog2 name: %s, weight: %f, master name: %s\n", D.getName(), D.getWeight(), D.getMaster());
        System.out.printf("Crocodile1 name: %s, weight: %f\n", E.getName(), E.getWeight());
        System.out.printf("Crocodile1 name: %s, weight: %f\n", F.getName(), F.getWeight());
        System.out.printf("Mammal number: %d\n", A.getNumMammals() + B.getNumMammals() + C.getNumMammals() + D.getNumMammals());
        System.out.printf("Reptile number: %d\n", E.getNumReptiles() + F.getNumReptiles());
    }

    public static void main(String[] args) {
        Cat A = new Cat("CatA",3.3f,"SlaveA");
        Cat B = new Cat("CatB",3.7f,"SlaveB");
        Dog C = new Dog("DogA",5.2f,"MasterA");
        Dog D = new Dog("DogB",5.9f,"MasterB");
        Crocodile E = new Crocodile("CrocoA",23.7f);
        Crocodile F = new Crocodile("CrocoB",26.9f);

        printout(A,B,C,D,E,F);

        for (int i=0; i < 3; i ++) {
            if (i == 0) {
                A.meow();
                A.sleep();
                A.bread();
                B.meow();
                B.sleep();
                B.bread();
                A.SetName("CatC");
                A.SetWeight(4.1f);
                A.setNameSlave("SlaveC");
                System.out.printf("(New setting to cat1) name: %s, weight: %f, nameSlave: %s\n", A.getName(), A.getWeight(), A.getNameSlave());
            }
            else if (i==1){
                C.bark();
                C.bread();
                D.bark();
                D.bread();
                C.SetName("DogC");
                C.SetWeight(7.4f);
                C.setMaster("MasterC");
                System.out.printf("(New setting to dog1) name: %s, weight: %f, nameMaster: %s\n", C.getName(), C.getWeight(), C.getMaster());
            }
            else{
                E.spawn();
                E.SetName("CrocoC");
                E.SetWeight(29.2f);
                System.out.printf("(New setting to croco1) name: %s, weight: %f\n", E.getName(), E.getWeight());
            }
            printout(A,B,C,D,E,F);
        }
        System.out.print("\n\n");
    }
}
