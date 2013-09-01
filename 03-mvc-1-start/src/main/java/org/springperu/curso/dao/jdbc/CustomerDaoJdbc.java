package org.springperu.curso.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springperu.curso.dao.CustomerDao;
import org.springperu.curso.dao.DBManager;
import org.springperu.curso.model.Customer;

@Repository
public class CustomerDaoJdbc {
	
	public void saveCustomer(Customer customer) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("INSERT INTO customer(name) VALUES(?)");
			ps.setString(1, customer.getName());
			int nr = ps.executeUpdate();
			if(nr!=1){
				throw new RuntimeException("No grabo el registro");
			}
			ps = conn.prepareStatement("SELECT MAX(id) FROM customer");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				customer.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		} finally{
			if(ps != null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	public void updateCustomer(Customer customer) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("UPDATE customer SET name = ? WHERE id = ?");
			ps.setString(1, customer.getName());
			ps.setLong(2, customer.getId());
			int nr = ps.executeUpdate();
			if(nr!=1){
				throw new RuntimeException("No actualiz� el registro");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		} finally{
			if(ps != null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

	public void deleteCustomer(Customer customer) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM customer WHERE id = ?");
			ps.setLong(1, customer.getId());
			int nr = ps.executeUpdate();
			if(nr!=1){
				throw new RuntimeException("No borr� el registro");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		} finally{
			if(ps != null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}	
	}
	
	public Customer getCustomer(Customer customer) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		Customer $customer = null;
		try {
			ps = conn.prepareStatement("SELECT id, name FROM customer WHERE id = ?");
			ps.setLong(1, customer.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				$customer = new Customer();
				$customer.setId(id);
				$customer.setName(name);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		} finally{
			if(ps != null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return $customer;
	}
	
	public List<Customer> getCustomers() {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		List<Customer> customerList = null;
		try {
			ps = conn.prepareStatement("SELECT id, name FROM customer");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				customerList = new ArrayList<Customer>();
				do{
					Long id = rs.getLong("id");
					String name = rs.getString("name");
					Customer $customer = new Customer();
					$customer.setId(id);
					$customer.setName(name);
					customerList.add($customer);
				}while(rs.next());
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		} finally{
			if(ps != null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return customerList;
	}
}
