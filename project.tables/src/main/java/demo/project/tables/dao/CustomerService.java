package demo.project.tables.dao;

import demo.project.tables.model.Customer;

public interface CustomerService {

	public abstract boolean addCustomer(Customer customer);
	public abstract boolean updateCustomer(Customer customer);
	public abstract boolean deleteCustomer(Customer customer);
	public Customer customerLogin(String email,String password);
	public Customer getCustomerByEmail(String email);
	
}
