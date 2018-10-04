package demo.project.tables.products;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import demo.project.tables.model.Products;

@Entity
@Component("mobile")
public class Mobile extends Products 
{
	private String size;
	private String camera;
	private String processor;
	private String battery;
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	
	

}
