import db.DB;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            DB.getConnection();
            System.out.println("Connection opened!");

            var department = new Department(1, "Books");
            System.out.println(department);

            var seller = new Seller(21, "Bob", "bob@gmail.com", 3000.0, new Date(), department);
            System.out.println(seller);
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