package dev.alazar.repositories;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dev.alazar.controllers.Controller;
import dev.alazar.models.Reimbursement;
import dev.alazar.utils.ConnectionUtil;
import dev.alazar.utils.StreamCloser;

public class ReimbursementDaoJDBC implements ReimbursementDao {

	@Override
	public Reimbursement getReimbursement(int employee_id) {
		Reimbursement r = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM reimbursements WHERE employee_id = ?;";
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setLong(1, employee_id);
				if (stmt.execute()) {
					try (ResultSet resultSet = stmt.getResultSet()) {
						if (resultSet.next()) {
							r = createReimbursementFromRS(resultSet);
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;
	}

	@Override
	public Reimbursement viewResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement viewAllPending(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement viewAllResolved(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> viewEmployeePending() {
		// Statement and ResultSet (and Connection) interfaces
		Statement statement = null;
		ResultSet resultSet = null;
		Connection conn = null;
		// List to return
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try {
			conn = ConnectionUtil.getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(
					"SELECT * FROM reimbursements WHERE employee_id = " + Controller.currentEmployee.id + ";");

			// loop through ResultSet
			while (resultSet.next()) {
				// At each row in the ResultSet, do the following:
				reimbursement.add(createReimbursementFromRS(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close all open resources to prevent memory leak
			StreamCloser.close(resultSet);
			StreamCloser.close(statement);
			StreamCloser.close(conn);
		}

		return reimbursement;

	}

	private Reimbursement createReimbursementFromRS(ResultSet resultSet) throws SQLException {
		return new Reimbursement(resultSet.getInt("id"), resultSet.getInt("employee_id"), resultSet.getString("title"),
				resultSet.getDouble("amountrequested"), resultSet.getString("status"));
	}

	@Override
	public List<Reimbursement> viewEmployeeResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> viewAllPending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> viewAllResolved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createReimbursement(Reimbursement r) {
		Connection conn = null;
		PreparedStatement stmt = null;

		String query = "INSERT INTO reimbursements VALUES (DEFAULT, ?, ?, ?, DEFAULT, ?);";

		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, r.employee_id);
			stmt.setString(2, r.title);
			stmt.setDouble(3, r.amountrequested);
			stmt.setString(4, r.status);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			StreamCloser.close(stmt);
			StreamCloser.close(conn);
		}

		return true;
	}

	@Override
	public Reimbursement viewPending() {
		// TODO Auto-generated method stub
		return null;
	}

}
