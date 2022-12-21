import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class mainwork {
    public static void main(String[] args) {
        Hello();
        String contact = CheckContact();
        String[] arrContact = contact.split(" ");
        System.out.println(Arrays.toString(arrContact));
        // объявляю новый массив, куда буду записывать данные по требуемому порядку
        String [] arrContactSort = new String[6];
        boolean flagDateBirth = false;
        boolean flagPhone = false;
        boolean flagGender = false;
        int indexDateBirth = 0;
        int indexPhone = 0;
        int indexGender = 0;
        for (int i = 0; i < arrContact.length; i++) {
            // проверка ввода и формата даты рождения
            if (CheckDateBirth(arrContact[i]) == true) {
                arrContactSort[3] = arrContact[i];
                flagDateBirth = true;
                indexDateBirth = i;
            }
            // проверка ввода номера телефона
            if (CheckPhone(arrContact[i]) == true) {
                arrContactSort[4] = arrContact[i];
                flagPhone = true;
                indexPhone = i;
            }
            // проверка ввода пола
            if (CheckGender(arrContact[i]) == true) {
                arrContactSort[5] = arrContact[i];
                flagGender = true;
                indexGender = i;
            }
        }
        // выброс исключения по дате рождения
        if (flagDateBirth == false) {
            throw new BirthDateException("Wrong format birth date!");
        }
        // выброс исключения по телефону
        if (flagPhone == false) {
            throw new PhoneExcepton("No phone number!");
        }
        // выброс исключения по полу
        if (flagGender == false) {
            throw new GenderExcepton ("No gender!");
        }
        
        // проверка на ввод ФИО и далее сортировка по требуемому порядку
        boolean isFullname = CheckFullName(arrContact, indexDateBirth, indexPhone, indexGender);
        if (isFullname == false) {
            throw new FullNameExcepton ("Full name is not entered!");
        } else {
            String[] arrContactMain = SortFullName(arrContact, arrContactSort, indexDateBirth, indexPhone, indexGender);
            System.out.println(Arrays.toString(arrContactMain));
            WriteFileContact(arrContactMain);
        }
    }

    // приветствие
    public static void Hello() {
            System.out.println("Hello! Enter your full name," + 
            " birth date, phone number and sex in any order.\n" + 
            "Example 1: Ivanov Ivan Ivanivoch 21.10.1980 79179857635 m\n" +
            "Example 2: f 28.08.1992 Alekseeva Marina Petrovna 79196665544");
    }

    // проверка на количество введенных данных
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

    // проверка строки на соответствие формату даты рождения
    public static boolean CheckDateBirth (String str) {
        boolean ItIsBirthDate = false;
        if (str.matches("(0?[1-9]|[12][0-9]|3[01]).(0?[1-9]|1[012]).((19|20)\\d\\d)")) {
            ItIsBirthDate = true;
        }
        return ItIsBirthDate;
    }

    //  Метод проверяет, введен ли пол
    public static boolean CheckGender(String str) {
        boolean ItIsSex = false;
        if ((str.equals("m")) | (str.equals("f"))) {
            ItIsSex = true;
            }
        return ItIsSex;
    }

    // проверка строки на соответствие номеру телефона
    public static boolean CheckPhone (String str) {
        boolean ItIsPhone = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                ItIsPhone = false;
            }
        }
        return ItIsPhone;
    }

    // проверка на ввод ФИО
    public static boolean CheckFullName(String[] arr, 
        int indexDateBirth, int indexPhone, int indexGender) {
        boolean ItIsFullName = false;
        for (int i = 2; i < arr.length; i++) {
            if ((i != indexDateBirth) & (i != indexPhone) & (i != indexGender) & (i != 0) & 
                (arr[i].matches("^[a-zA-Z]*$")) & (arr[i-1].matches("^[a-zA-Z]*$")) &
                (arr[i-2].matches("^[a-zA-Z]*$"))) {
                ItIsFullName = true;
            }
        }
        return ItIsFullName;
    }

    // Запись ФИО на 0-2 места массива
    public static String[] SortFullName (String[] arr, String[] arrSort, 
        int indexDateBirth, int indexPhone, int indexGender) {
        for (int i = 2; i < arr.length; i++) {
            if ((i != indexDateBirth) & (i != indexPhone) & (i != indexGender) & (i != 0) & 
                (arr[i].matches("^[a-zA-Z]*$")) & (arr[i-1].matches("^[a-zA-Z]*$")) &
                (arr[i-2].matches("^[a-zA-Z]*$"))) {
                arrSort[0] = arr[i-2];
                arrSort[1] = arr[i-1];
                arrSort[2] = arr[i];
            }
        }
        return arrSort;
    }

    public static class BirthDateException extends RuntimeException {

        public BirthDateException(String message) {
            super(message);
        }
    }

    public static class PhoneExcepton extends RuntimeException {
        public PhoneExcepton(String message) {
            super(message);
        }
    }

    public static class GenderExcepton extends RuntimeException {
        public GenderExcepton(String message) {
            super(message);
        }
    }

    public static class FullNameExcepton extends RuntimeException {
        public FullNameExcepton(String message) {
            super(message);
        }
    }

    // метод записи контакта в файл
    public static void WriteFileContact(String[] arr) {
        String nameFile = arr[0];
        try(FileWriter writer = new FileWriter(nameFile + ".txt", true))
        {
           // запись всей строки
            for (int i = 0; i < arr.length; i++) {
                if (i != arr.length-1) {
                    writer.write(arr[i] + " ");
                } else {
                    writer.write(arr[i] + "\n");
                }
            }
            writer.flush();
        }
        catch(IOException ex){
        }
    }
}