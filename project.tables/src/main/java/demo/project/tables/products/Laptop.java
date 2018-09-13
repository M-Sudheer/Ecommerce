package demo.project.tables.products;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import demo.project.tables.model.Products;

@Entity
@Component("laptop")
public class Laptop extends Products
{

	private String ram;
	private String rom;
	private String brand;
	private String processor;
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) 
	{
		this.processor = processor;
	}

	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
