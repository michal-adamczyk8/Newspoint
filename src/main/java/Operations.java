import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Operations {

    public static String getFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide path of the file.");
        return scanner.nextLine();
    }

    public static List<User> getUsersFromFile(String filePath) {
        ArrayList<User> users = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] data = sCurrentLine.split(",");
                if (data.length == 3) {
                    users.add(User.makingUserWithNoPhoneNumber(data[0], data[1], LocalDate.parse(data[2], formatter)));
                } else {
                    users.add(User.makingUserWithPhoneNumber(data[0], data[1], LocalDate.parse(data[2], formatter), data[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void  getNumberOfUsers(List<User> users) {
        System.out.println("Liczba użytkowników w pliku to : " + users.size());
    }

    public static void getTheOldestUser(List<User> users) {
        User theOldestUser = Collections.min(users, Comparator.comparing(c-> c.getDateOfBirth().getYear()));
        String fullName = theOldestUser.getFirstName() + " " + theOldestUser.getLastName();
        int age = Period.between(theOldestUser.getDateOfBirth(), LocalDate.now()).getYears();
        if (theOldestUser.getPhoneNumber().equals("0")) {
            System.out.println("The oldest user data: " + "\n" + "Name: " + fullName + "\n" + "Age: " + age);
        } else {
            String phoneNumber = theOldestUser.getPhoneNumber();
            System.out.println("The oldest user data: " + "\n" + "Name: " + fullName + "\n" + "Age: " + age +
                    "\n" + "Phone: " + phoneNumber);
        }
    }

}


