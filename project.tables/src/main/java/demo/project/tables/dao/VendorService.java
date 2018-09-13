//VendorService
package demo.project.tables.dao;

import java.util.List;

import demo.project.tables.model.Vendor;

public interface VendorService
{
	public abstract boolean addVendor(Vendor vendor);
	public abstract boolean updateVendor(Vendor vendor);
	public abstract boolean deleteVendor(Vendor vendor);
	public Vendor login(String email,String password);
	public  Vendor getVendor(int id); 
	public Vendor getVendorByEmail(String email);
	public List<Vendor> getVendorDetails();
}
