package dev.alazar.repositories;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dev.alazar.models.Employee;
import dev.alazar.utils.ConnectionUtil;
import dev.alazar.utils.StreamCloser;

public class EmployeeDaoJDBC implements EmployeeDao {
	@Override
	public Employee getEmployee(String emp_username) {
		ResultSet resultSet = null;
		//PreparedStatements are better than simple ones
		PreparedStatement statement =  null;
		Employee employee = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(
					"SELECT * FROM employees WHERE emp_username = ?;");
		
			//fill in the ? with name argument
			statement.setString(1, emp_username);
			
			//try to execute SQL query
			if(statement.execute()) {
				//get the ResultSet
				resultSet =  statement.getResultSet();
				//check for a single row and use it
				if(resultSet.next()) {
					employee = createEmployeeFromRS(resultSet);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
		}
		
		return employee;
	}
	
	@Override
	public Employee viewEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee viewEmployee(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Employee getEmployee(String emp_username, String emp_password) {
		ResultSet resultSet = null;
		PreparedStatement statement =  null;
		Employee employee = null;
		try (Connection conn = ConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(
					"SELECT * FROM employees WHERE emp_username = ?AND emp_password = ?;");
		
			//fill in the ? with name argument
			statement.setString(1, emp_username);
			statement.setString(2, emp_password);
			//try to execute SQL query
			if(statement.execute()) {
				//get the ResultSet
				resultSet =  statement.getResultSet();
				//check for a single row and use it
				if(resultSet.next()) {
					employee = createEmployeeFromRS(resultSet);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
		}
		
		return employee;
	}

	private Employee createEmployeeFromRS(ResultSet resultSet) throws SQLException {
		return new Employee(
				resultSet.getInt("id"),
				resultSet.getString("first_name"),
				resultSet.getString("last_name"),
				resultSet.getString("email"),
				resultSet.getString("emp_username"),
				resultSet.getString("emp_password"),
				resultSet.getString("emp_type"));
	}

	@Override
	public List<Employee> viewEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createEmployee(Employee e) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String query = "INSERT INTO employees VALUES (DEFAULT, ?, ?, ?, ?, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, e.getFirst_name());
			stmt.setString(2, e.getLast_name());
			stmt.setString(3, e.getEmail());
			stmt.setString(4, e.getEmp_username());
			stmt.setString(5, e.getEmp_password());
			stmt.setString(6, e.getEmp_type());
			stmt.execute();
		} catch (SQLException sql) {
			sql.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}
		
		return true;
	}


}
