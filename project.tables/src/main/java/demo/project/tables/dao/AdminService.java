package demo.project.tables.dao;

import java.util.List;

import demo.project.tables.model.Admin;
import demo.project.tables.model.Vendor;

public interface AdminService  {

	
	public abstract boolean addAdmin(Admin admin);
	public abstract boolean updateAdmin(Admin admin);
	public abstract boolean deleteAdmin(Admin admin);
	public Admin adminLogin(String email,String password);
	public Admin getAdminByEmail(String email);
	public List<Vendor> getAllVendors();
}
