package model.dao;

import db.DB;
import model.implementation.DepartmentDaoJDBC;
import model.implementation.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartamentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
