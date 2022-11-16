import java.util.Scanner;
import java.util.Arrays;

public class homework {
    
    public static void main(String[] args) {
        String[] arrayContact = CheckContact();
        System.out.println(Arrays.toString(arrayContact));
    }
    
    

    public static String[] CheckContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Превед! Я справочнег! Я запишу твой контакт, для этого тебе нужно " +
        "ввести ФИО, дату рождения в формате 'дд.мм.гггг'," +
        " номер телефона (без знака '+') и пол ('f' или 'm') через пробел.");
        System.out.println("Пример: Иванов Иван Иванович 21.10.1980 79179857635 m");
        String contact = sc.nextLine();
        String[] ArrContact = contact.split(" ");
        sc.close();
        return ArrContact;
    }
    
}
