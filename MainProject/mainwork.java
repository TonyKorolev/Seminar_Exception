import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class mainwork {
    public static void main(String[] args) {
        String contact = CheckContact();
        String[] ArrContact = contact.split(" ");
        System.out.println(Arrays.toString(ArrContact));
        try {
            String[] ArrContact_Birthdate = CheckDateBirth(ArrContact);
            System.out.println(Arrays.toString(ArrContact));
            String[] ArrContact_Sex = CheckSex(ArrContact_Birthdate);
            System.out.println(Arrays.toString(ArrContact));
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    public static String CheckContact() {
        Scanner sc = new Scanner(System.in);
        String contact = sc.nextLine();
        int numSpaces = CheckNumSpaces(contact);            
        if (numSpaces != 5) {
            sc.close();
            throw new RuntimeException ("Error: You entered the wrong amount of data!" + 
            " Enter your full name, birth date, phone number and sex in any order.");
        }
        sc.close();
        return contact;
    }

    // метод считает количество пробелов для выявления количества данных
    public static int CheckNumSpaces(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) count++;
            if (Character.isWhitespace(str.charAt(str.length()-1))) count--;
        }
        return count;
    }

    //  Метод проверяет, выбран ли пол, если выбран, то сортирует его на последнее место
    //  В случае отсутствия пола бросается исключение
    public static String[] CheckSex(String[] arr) throws Exception {
        boolean flag = false;
        String var_str;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == "m" | arr[i] == "f") {
                // условие, если пол находится не на последнем месте, согласну формату
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

    // сортировка массива при наличии в массиве даты рождения корректного формата
    public static String[] CheckDateBirth (String[] arr) throws Exception {
        boolean flag = false;
        String var_str;
        for (int i = 0; i < arr.length; i++) {
            if (ItIsDate(arr[i]) == true) {
                var_str = arr[i];
                arr[i] = arr[1];
                arr[1] = var_str;
                flag = true;
            }
        }
        if (flag == false) {
            throw new Exception ("Wrong format birth date!");
        }
        return arr;
    }

    // проверка строки на соответствие формату даты рождения
    public static boolean ItIsDate (String str) {
        boolean flag = true;
        if (!str.matches("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)"))
            return flag = false;
        return flag;
    }

    public static String[] CheckPhone (String[] arr) {
        
    }

    public static void name() {
        
    }
}
