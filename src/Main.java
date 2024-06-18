import model.dao.DaoFactory;
import model.dao.DepartamentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        try {
//            System.out.println("SellerDaoJDBC Test");
//
//            System.out.println("Seller findById Test");
//            SellerDao sellerDao = DaoFactory.createSellerDao();
//            Seller seller = sellerDao.findById(3);
//            System.out.println(seller);
//            System.out.println();
//
//            System.out.println("Seller findByDepartment Test");
//            List<Seller> sellers = sellerDao.findByDepartment(3);
//            sellers.forEach(System.out::println);
//            System.out.println();
//
//            System.out.println("Seller findAll Test");
//            List<Seller> allSellers = sellerDao.findAll();
//            allSellers.forEach(System.out::println);
//            System.out.println();
//
//            System.out.println("Seller insert Test");
//            Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", 4000.0, new java.util.Date(), seller.getDepartment());
//            sellerDao.insert(newSeller);
//            System.out.println("Inserted! New id = " + newSeller.getId());
//            System.out.println();
//
//            System.out.println("Seller update Test");
//            seller = sellerDao.findById(1);
//            seller.setName("Martha Waine");
//            seller.setEmail("marthaw@exemple.com");
//            seller.setBaseSalary(5000.0);
//            sellerDao.update(seller);
//            System.out.println("Update completed!");
//
//            System.out.println("Seller deleteById Test");
//            sellerDao.deleteById(16);
//            System.out.println("Delete completed!");

            System.out.println("DepartmentDaoJDBC Test");
            DepartamentDao departamentDao = DaoFactory.createDepartmentDao();

            System.out.println("Department findById Test");
            System.out.println(departamentDao.findById(1));
            System.out.println();

            System.out.println("Department findAll Test");
            List<Department> departments = departamentDao.findAll();
            departments.forEach(System.out::println);

            System.out.println("Department insert Test");
            Department newDepartment = new Department(null, "Music");
            departamentDao.insert(newDepartment);
            System.out.println("Inserted! New id = " + newDepartment.getId());
            System.out.println();

            System.out.println("Department update Test");
            Department department = departamentDao.findById(1);
            department.setName("Food");
            departamentDao.update(department);
            System.out.println("Update completed!");
            System.out.println();

            System.out.println("Department deleteById Test");
            departamentDao.deleteById(7);
            System.out.println("Delete completed!");
            System.out.println();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}