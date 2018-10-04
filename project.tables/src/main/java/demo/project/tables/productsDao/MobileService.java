package demo.project.tables.productsDao;

import demo.project.tables.products.Laptop;
import demo.project.tables.products.Mobile;

public interface MobileService 
{
	public abstract boolean addMobile(Mobile mobile);
	public abstract boolean updateMobile(Mobile mobile);
	public boolean  deleteMobile(Mobile mobile);
	public Mobile getMobileDetails(int product_id);

}
