public class Animal {
    String name;
    float weight;
    Animal (String name, float weight)
    {
        this.name = name;
        this.weight = weight;
    }
    String getName ()
    {
        return name;
    }
    float getWeight ()
    {
        return weight;
    }
    void SetName (String name)
    {
        this.name = name;
    }
    void SetWeight (float weight)
    {
        this.weight = weight;
    }
}

abstract class Mammal extends Animal{
    int numMammal;
    Mammal (String name, float weight)
    {
        super(name, weight);
        numMammal = 1;
    }
    int getNumMammals()
    {
        return numMammal;
    }
    abstract void bread();
}

abstract class Reptile extends Animal{
    int numReptile;
    Reptile (String name, float weight)
    {
        super(name, weight);
        numReptile = 1;
    }
    int getNumReptiles()
    {
        return numReptile;
    }
    abstract void spawn();
}

final class Cat extends Mammal{
    String nameSlave;
    Cat (String name, float weight, String nameSlave)
    {
        super(name, weight);
        this.nameSlave = nameSlave;
    }
    String getNameSlave ()
    {
        return nameSlave;
    }
    void setNameSlave (String nameSlave)
    {
        this.nameSlave = nameSlave;
    }
    void meow()
    {
        System.out.print(name);
        System.out.print(" : meow\n");
    }
    void sleep()
    {
        System.out.print(name);
        System.out.print(" : Zzz\n");
    }
    void bread()
    {
        numMammal += 3;
    }
}

final class Dog extends Mammal{
    String nameMaster;
    Dog (String name, float weight, String nameMaster)
    {
        super(name, weight);
        this.nameMaster = nameMaster;
    }
    String getMaster ()
    {
        return nameMaster;
    }
    void setMaster (String nameMaster)
    {
        this.nameMaster = nameMaster;
    }
    void bark()
    {
        System.out.print(name);
        System.out.print(" : bowwow\n");
    }
    void bread()
    {
        numMammal += 5;
    }
}

final class Crocodile extends Reptile{
    Crocodile (String name, float weight)
    {
        super(name, weight);
    }
    void spawn()
    {
        numReptile += 20;
    }
}
