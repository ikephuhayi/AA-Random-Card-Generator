import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class Main {

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(new File("cards.txt"));
    Scanner input = new Scanner(System.in);

    ArrayList<String> cards = new ArrayList<String>();
    ArrayList<String> pool = new ArrayList<String>();

    String help = "-card: get a random card\n-deck: get a random deck\n-draft: get a random draft\n-fill: refill the pool of cards";

    System.out.print("-help for commands\n");

    while (scanner.hasNext()) {

      pool.add(scanner.nextLine());

    }

    for (String c: pool) {

      cards.add(c);

    }

    while (input.hasNext()) {

      switch(input.nextLine()) {

        case "-card": 
          System.out.println();
          card(cards);
          break;

        case "-deck":
          System.out.println();
          deck(cards);
          break;

        case "-draft":
          System.out.println();
          draft(cards);
          break;

        case "-help":
          System.out.println("\n" + help);
          break;

        case "-fill":
          System.out.println("pool replenished");
          for (int i = 0; i < cards.size(); i++)
            cards.remove(0);
          for (String c: pool)
            cards.add(c);
          break;

        default:
          System.out.println();
          break;

      }

    }

  }

  static void deck(ArrayList<String> cards) {

    for (int i = 0; i < 8; i++) {

      int r = (int)(Math.random() * cards.size());

      try {

        System.out.println(cards.get(r));

        cards.remove(r);

      }

      catch(Exception e) {

        System.out.println("pool is empty");

      }

    }

  }

  static void card(ArrayList<String> cards) {

    try {

      System.out.println(cards.get((int) (Math.random() * cards.size())));

    }

    catch(Exception e) {

      System.out.println("pool is empty");

    }

  }

  static void draft(ArrayList<String> cards) {

    for (int i = 0; i < 8; i++) {

      for(int j = 0; j < 3; j++) {

        int r = (int) (Math.random() * cards.size());

        try {

          System.out.println(cards.get(r));

          cards.remove(r);

        }

        catch(Exception e) {

          System.out.println("pool is empty");

        }

      }

      System.out.println();

    }

  }

}