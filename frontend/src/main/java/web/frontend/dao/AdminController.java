package web.frontend.dao;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import demo.project.tables.dao.AdminService;
import demo.project.tables.dao.VendorService;
import demo.project.tables.model.Admin;
import demo.project.tables.model.AdminLogin;
import demo.project.tables.model.Vendor;

@Controller
public class AdminController 
{
	@Autowired
    private Admin admin;
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminLogin adminLogin;
    @Autowired
    private Vendor vendor;
    @Autowired
    private VendorService vendorService;

    
    @GetMapping("/adminlogin")
public String adminlogin()
{
    return "adminlogin";
}

@GetMapping("admin/adminpage")
public String adminpage()
{
	return "adminpage";
}


@PostMapping("/updateadmin")
public String updateadmin(@ModelAttribute("admin") Admin admin,HttpSession httpSession)
{
    httpSession.setAttribute("admin", admin);
    adminService.updateAdmin(admin);
    return "adminprofile";
}
}
    
    
    
  