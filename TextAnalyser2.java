import java.util.Scanner;

public class TextAnalyser2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter a text");
    String s = new String();
    s = sc.nextLine();
    System.out.println("1: to count Number of charectors in given String:");
    System.out.println("2: to count Number of words in given String:");
    System.out.println("3: to count Number of lines in given String:");
    System.out.println("4: to find most common words in given String:");
    char c;
    do {
      System.out.println("enter your choice:");
      int ch = sc.nextInt();

      TextAnalyser2 t = new TextAnalyser2();

      switch (ch) {
        case 1:
          t.numChar(s);
          break;
        case 2:
          t.numWords(s);
          break;
        case 3:
          t.numLines(s);
          break;
        case 4:
          t.most(s);
          break;
        default:
          System.out.println("Wrong choice");
          break;
      }
      System.out.println("doyou want to continue (y/n)");
      c = sc.next().charAt(0);
    } while (c != 'n');
  }

  void numChar(String s) {
    // anothor method also there which is Stringname.length()
    // System.out.println("num of string"+s.length());
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      count++;
    }
    System.out.println("  number of characters in the given text is: " + count);
  }

  void numWords(String s) {
    int count = 0;
    String a[] = s.split(" ");
    for (int i = 0; i < a.length; i++) {
      count++;
    }
    System.out.println("number of words in the given text" + count + "its using length method: " + a.length);
  }

  void numLines(String s) {
    /*
     * Scanner sc = new Scanner(System.in);
     * int count = 0;
     * while (sc.hasNextLine()) {
     * count++;
     * }
     */
    int count = 0;
    String arr[] = s.split("\n");
    for (int i = 0; i < arr.length; i++) {
      count++;
    }
    System.out.println(" number of lines in the given text is: " + arr.length + " abcdefg" + count);

  }

  void most(String s) {

    String c[] = s.split(" ");
    String b[] = new String[c.length];
    for (int i = 0; i < b.length; i++)
      b[i] = "-1";
    for (int i = 0; i < c.length; i++) {
      int count = 1;
      for (int j = 0; j < b.length; j++) {
        if (c[i].equalsIgnoreCase(c[j]) && b[j].equals("-1"))
          count++;
        b[j] = "0";
      }
     // if (!b[i].equals("0"))
        System.out.println(c[i] + " frequency " + count);

    }

  }

}

/*
 * class test {
 * void numChar(String s) {
 * int count = 0;
 * for (int i = 0; i < s.length(); i++) {
 * // System.out.println(s.charAt(i));
 * count++;
 * }
 * System.out.println("  number of characters in the given text is: " + count);
 * }
 * }
 */