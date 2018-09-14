package demo.project.tables.productsDao;

import demo.project.tables.products.Laptop;

public interface LaptopService {
	public abstract boolean addLaptop(Laptop laptop);
	public abstract boolean updateLaptop(Laptop laptop);
	public boolean  deleteLaptop(Laptop laptop);
	public Laptop getLaptopDetails(int product_id);

}



