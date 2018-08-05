public class Application {
    public static void main(String args[]) {
        String filePath = Operations.getFilePath();
        Operations.getNumberOfUsers(Operations.getUsersFromFile(filePath));
        Operations.getTheOldestUser(Operations.getUsersFromFile(filePath));
        }
    }