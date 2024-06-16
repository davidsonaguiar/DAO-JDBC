package model.implementation;

import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private final Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        String sql = "SELECT seller.*, department.Name as DepName FROM seller INNER JOIN department ON seller.DepartmentId = department.Id WHERE seller.Id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) return null;

            Integer departmentId = resultSet.getInt("DepartmentId");
            String departmentName = resultSet.getString("DepName");
            Department department = new Department(departmentId, departmentName);

            Integer sellerId = resultSet.getInt("Id");
            String sellerName = resultSet.getString("Name");
            String sellerEmail = resultSet.getString("Email");
            Double sellerBaseSalary = resultSet.getDouble("BaseSalary");
            Date sellerBirthDate = resultSet.getDate("BirthDate");
            Seller seller = new Seller(sellerId, sellerName, sellerEmail, sellerBaseSalary, sellerBirthDate, department);

            return seller;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (resultSet != null) resultSet.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
