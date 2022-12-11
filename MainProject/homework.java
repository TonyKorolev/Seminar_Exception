import java.util.Scanner;
import java.util.Arrays;

public class homework {
    
    public static void main(String[] args) {
        String[] arrayContact = CheckContact();
        System.out.println(Arrays.toString(arrayContact));
        try {
            String[] arrayContact_Sex = CheckSex(arrayContact);    
        } catch (Exception e) {
            // TODO: handle exception
        }
        

        
    }
    
    

    public static String[] CheckContact() {
        System.out.println("Hello! Enter your full name," + 
            " birth date, phone number and sex in any order.");
        System.out.println("For example: Ivanov Ivan Ivanivoch 21.10.1980 79179857635 m");
        Scanner sc = new Scanner(System.in);
        String contact = sc.nextLine();
        int numSpaces = CheckNumSpaces(contact);            
        while (numSpaces != 5) {
            System.out.println("You entered the wrong amount of data!" + 
            " Enter your full name, birth date, phone number and sex in any order.\n" + 
            "If you stop to enter data write '-1'");
            String contact_double = sc.nextLine();
            if (contact_double.equals("-1") ) {
                numSpaces = 5;
                contact = "";
            } else {
                contact = contact_double;
            }
        }
        sc.close();       
        String[] ArrContact = contact.split(" ");
        return ArrContact;
    }

    public static String[] CheckSex(String[] arr) throws Exception{
        boolean flag = false;
        String var_str;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == "m" | arr[i] == "f") {
                if (i != arr.length -1) {
                    var_str = arr[i];
                    arr[i] = arr[arr.length - 1];
                    arr[arr.length - 1] = var_str;
                }
                flag = true;
            }
        }
        if (flag == false) {
            throw new Exception("You didn't enter sex! Please enter 'm' or 'f' for choise sex!");
        }
        return arr;
    }
    
    public static int CheckNumSpaces(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) count++;
            if (Character.isWhitespace(str.charAt(str.length()-1))) count--;
        }
        return count;
    }

    // private static String[] CheckBirthDate(String str, String[] args) {
        
    // }
}
