import java.util.Scanner;
import java.util.Arrays;

public class mainhomework {
    public static void main(String[] args) {
        System.out.println("Hello! Enter your full name," + 
            " birth date, phone number and sex in any order.");
        System.out.println("For example: Ivanov Ivan Ivanivoch 21.10.1980 79179857635 m");
        boolean bool = false;
        while (!bool) {
            try {
                Scanner sc = new Scanner(System.in);
                String contact = sc.nextLine();
                int numSpaces = CheckNumSpaces(contact);
                bool = true;
                sc.close();
            } catch (Exception e) {
                System.out.println("Enter your full name, birth date, phone number and sex in any order.\n" + 
                "If you stop to enter data write '-1'");
            } finally {
                String contact = "";
            }

        }
    }
    
    // public static String[] CheckContact() {
    //     System.out.println("Hello! Enter your full name," + 
    //         " birth date, phone number and sex in any order.");
    //     System.out.println("For example: Ivanov Ivan Ivanivoch 21.10.1980 79179857635 m");
    //     boolean bool = false;
    //     while (!bool) {
    //         try {
    //             Scanner sc = new Scanner(System.in);
    //             String contact = sc.nextLine();
    //             int numSpaces = CheckNumSpaces(contact);
    //             bool = true;
    //             sc.close();
    //         } catch (Exception e) {
    //             System.out.println("Enter your full name, birth date, phone number and sex in any order.\n" + 
    //             "If you stop to enter data write '-1'");
    //         } finally {
    //             String contact = "";
    //         }

    //     }               
    //     String[] ArrContact = contact.split(" ");
    //     return ArrContact;
    // }

    public static int CheckNumSpaces(String str) throws Exception{
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) count++;
            if (Character.isWhitespace(str.charAt(str.length()-1))) count--;
        }
        if (count != 5) {
            throw new Exception("You entered the wrong amount of data!");
        }
        return count;
    }
}

