import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        int seed = Integer.parseInt(args[0]);
        int numberofplayer = Integer.parseInt(args[1]);

        /*Prepare Deck*/
        Deck deck = new Deck();
        deck.shuffle(seed);

        /*Prepare User and Dispense Card*/
        House house = new House();
        house.getCard(deck.dealCard());
        house.getCard(deck.dealCard());
        Player user = new Player();
        user.getCard(deck.dealCard());
        user.getCard(deck.dealCard());
        Computer[] computers = new Computer[numberofplayer-1];
        for (int i = 0; i < numberofplayer - 1; i++)
        {
            String tempname = "Player" + Integer.toString(i+2);
            computers[i] = new Computer(tempname);
            computers[i].getCard(deck.dealCard());
            computers[i].getCard(deck.dealCard());
        }

        /*Show Card*/
        house.showhand(false);
        user.showhand(false);
        for (int i = 0; i < numberofplayer - 1; i++){
            computers[i].showhand(false);
        }

        /*Check House is BlackJack?*/
        if (house.CardSum != 21) {
            /*Game Start*/
            System.out.printf("\n--- %s turn ---\n", user.Name);
            while (true){
                user.showhand(false);
                if (user.makedecision() == 1)
                {
                    break;
                }
                else
                {
                    user.getCard(deck.dealCard());
                    if (user.bursted)
                    {
                        break;
                    }
                }
            }
            user.showhand(false);
            for (int i = 0; i < numberofplayer -1; i++) {
                System.out.printf("\n--- %s turn ---\n", computers[i].Name);
                while (true) {
                    computers[i].showhand(false);
                    if (computers[i].makedecision() == 1) // stand
                    {
                        break;
                    }
                    else // dec == 0 -> hit
                    {
                        computers[i].getCard(deck.dealCard());
                        if (computers[i].bursted)
                        {
                            break;
                        }
                    }
                }
                computers[i].showhand(false);
            }
            System.out.printf("\n--- %s turn ---\n", house.Name);
            while (true){
                house.showhand(true);
                if (house.makedecision() == 1)
                {
                    break;
                }
                else
                {
                    house.getCard(deck.dealCard());
                    if (house.bursted)
                    {
                        break;
                    }
                }
            }
            house.showhand(true);
        }

        /*get Final Result*/
        if (house.bursted)
        {
            if (user.bursted)
            {
                user.gameresult = "[Lose]";
            }
            else {
                user.gameresult = "[Win] ";
            }
            for (int i = 0; i < numberofplayer - 1; i++){
                if (computers[i].bursted){
                    computers[i].gameresult = "[Lose]";
                }
                else{
                    computers[i].gameresult = "[Win] ";
                }
            }
        }
        else
        {
            if (user.bursted)
            {
                user.gameresult = "[Lose]";
            }
            else if (user.CardSum > house.CardSum)
            {
                user.gameresult = "[Win] ";
            }
            else if (user.CardSum == house.CardSum)
            {
                user.gameresult = "[Draw]";
            }
            else
            {
                user.gameresult = "[Lose]";
            }
            for (int i = 0; i < numberofplayer - 1; i++){
                if (computers[i].bursted){
                    computers[i].gameresult = "[Lose]";
                }
                else if (computers[i].CardSum > house.CardSum)
                {
                    computers[i].gameresult = "[Win] ";
                }
                else if (computers[i].CardSum == house.CardSum)
                {
                    computers[i].gameresult = "[Draw]";
                }
                else
                {
                    computers[i].gameresult = "[Lose]";
                }
            }
        }

        /*Show Final Result*/
        System.out.print("\n--- Game Results ---\n");
        house.showhand(true);
        System.out.printf("%s  ",user.gameresult);
        user.showhand(true);
        for (int i = 0; i < numberofplayer -1; i++){
            System.out.printf("%s  ",computers[i].gameresult);
            computers[i].showhand(true);
        }
    }
}

class Card {
    int mark; // 0 -> Spade, 1 -> Heart, 2 -> Diamond, 3 -> Club
    private int number; // 1 -> A, 11 -> J, 12 -> Q, 13 -> K
    public Card (){
        mark = 0;
        number = 0;
    }
    public Card(int theValue, int theSuit) {
        setCard(theValue, theSuit);
    }
    public void setCard (int theValue, int theSuit){
        mark = theSuit;
        number = theValue;
    }
    public int getNumber () {
        int retnum;
        if (number == 1)
        {
            retnum = 11;
        }
        else if (number == 11 || number == 12 || number == 13)
        {
            retnum = 10;
        }
        else
        {
            retnum = number;
        }
        return retnum;
    }
    public String read () {
        String markman;

        if (number == 1)
        {
            markman = "A";
        }
        else if (number == 11)
        {
            markman = "J";
        }
        else if (number == 12)
        {
            markman = "Q";
        }
        else if (number == 13)
        {
            markman = "K";
        }
        else
        {
            markman = Integer.toString(number);
        }

        if (mark == 0)
        {
            markman = markman + "s";
        }
        else if (mark == 1)
        {
            markman = markman + "h";
        }
        else if (mark == 2)
        {
            markman = markman + "d";
        }
        else
        {
            markman = markman + "c";
        }

        return markman;
    }
}

class Deck {
    private Card[] deck;
    private int cardUsed;

    Deck ()
    {
        deck = new Card[4*13];
        for (int j = 0; j < 4; j++) // 4 kind of mark (Spade, Heart, Diamond, Club)
        {
            for (int i = 0; i < 13; i++) // A to K (13 numbers)
            {
                deck[j*13+i] = new Card(i+1, j);
            }
        }
    }

    public void shuffle(int seed) {
        Random random = new Random(seed);
        for (int i=deck.length-1; i > 0; i--){
            int rand = (int)(random.nextInt(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardUsed = 0;
    }
    public Card dealCard(){
        if (cardUsed == deck.length){
            throw new IllegalStateException("No cards are left in the deck");
        }
        cardUsed++;
        return deck[cardUsed - 1];
    }
}

class Hand {
    boolean isHouse;
    String Name;
    protected List<Card> mycard = new ArrayList<Card>();
    int CardSum = 0;
    int numberoface = 0;
    boolean bursted = false;
    public void showhand (boolean isfinal){
        System.out.printf("%s: ", Name);
        boolean temp = true;
        for (Card a: mycard){
            if (temp){
                if (isHouse && !isfinal){
                    System.out.print("HIDDEN");
                }
                else {
                    System.out.print(a.read());
                }
                temp = false;
            }
            else {
                System.out.printf(", %s", a.read());
            }
        }
        if (isfinal || !isHouse){
            System.out.printf(" (%d)", CardSum);
        }
        if (bursted){
            System.out.print(" - Bust!!");
        }
        System.out.print("\n");
    }
    public void getCard (Card incard){
        mycard.add(incard);
        if (incard.getNumber() == 11)
        {
            numberoface++;
        }
        int tempsum = CardSum + incard.getNumber();
        if (tempsum > 21)
        {
            handlesum();
        }
        else
        {
            CardSum = tempsum;
        }
    }
    protected void handlesum (){
        int actsum = 0;
        for (Card a: mycard){
            actsum += a.getNumber();
        }
        bursted = true;
        CardSum = actsum;
        for (int i = 1; i <= numberoface; i++)
        {
            CardSum = actsum - i * 10;
            if (0 < CardSum && CardSum < 22)
            {
                bursted = false;
                break;
            }
        }
    }
    int makedecision (){
        int res;
        if (CardSum < 14){
            res = 0;
        }
        else if (CardSum > 17){
            res = 1;
        }
        else {
            Random random = new Random();
            int is_hit = (int)(random.nextInt(2));
            if (is_hit == 1){
                res = 0;
            }
            else{
                res = 1;
            }
        }
        if (res == 0)
        {
            System.out.print("Hit\n");
        }
        else
        {
            System.out.print("Stand\n");
        }
        return res;
    }
}

class Computer extends Hand {
    String gameresult;
    Computer(String name){
        Name = name;
        isHouse = false;
    }
}

class Player extends Hand {
    String gameresult;
    Player(){
        Name = "Player1";
        isHouse = false;
    }
    int makedecision (){
        int res;
        Scanner scn = new Scanner(System.in);
        while (true) {
            String userinput = scn.nextLine();

            if (userinput.compareTo("Hit") == 0) {
                res = 0;
                break;
            } else if (userinput.compareTo("Stand") == 0) {
                res = 1;
                break;
            } else {
                System.out.print("Wrong input, Try Again");
            }
        }
        return res;
    }
}

class House extends Hand {
    House(){
        Name = "House";
        isHouse = true;
    }
}