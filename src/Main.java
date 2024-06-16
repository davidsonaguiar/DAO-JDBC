import db.DB;
import model.entities.Department;

public class Main {
    public static void main(String[] args) {
        try {
            DB.getConnection();
            System.out.println("Connection opened!");
            var department = new Department(1, "Books");
            System.out.println(department);
        }
        catch (Exception e) {
            System.out.println("Error accessing database!");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Closing connection!");
            DB.closeConnection();
        }
    }
}