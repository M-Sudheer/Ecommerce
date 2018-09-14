package web.frontend.dao;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import demo.project.tables.model.Products;

@Service
public class ImageUpload {

	public static void uploadImage(Products products,HttpServletRequest request) {
		
		String contextPath = request.getRealPath("/");
		File file = new File(contextPath + "/resources/images/products/");

		if (!file.exists()) {
			file.mkdir();
		}

		System.out.println(file.getPath());
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file.getPath() + "/" + products.getProduct_id() + ".jpg");
			InputStream inputStream = products.getImage().getInputStream();
			byte[] imageBytes = new byte[inputStream.available()];
			inputStream.read(imageBytes);

			fileOutputStream.write(imageBytes);
			fileOutputStream.flush();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}

	}
}