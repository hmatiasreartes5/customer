package com.matiasreartes.customer.infrastructure.output.adapter.mysql;

import com.matiasreartes.customer.domain.Customer;
import com.matiasreartes.customer.infrastructure.output.port.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class MySQLCustomerRepository implements CustomerRepository {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    private static final String INSERT = "INSERT INTO customer" + "(id ,name, country) VALUES" + "(?,?,?)";
    private static final String SELECT = "SELECT * FROM customer WHERE id = ?";

    @Override
    public void save(Customer customer) {
        try (Connection connection = DriverManager.getConnection(dbUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

            preparedStatement.setString(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getCountry());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Customer getById(String id) {
        Customer customer = new Customer();
        try (Connection connection = DriverManager.getConnection(dbUrl, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT)) {

            preparedStatement.setString(1, id);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                customer.setId(result.getString("id"));
                customer.setName(result.getString("name"));
                customer.setCountry(result.getString("country"));
            }
            return customer;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return customer;
    }
}
