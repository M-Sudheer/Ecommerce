package web.frontend.dao;



import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
@GetMapping("admin/adminprofile")
public ModelAndView getAdminProfile(Principal principal)
{
    ModelAndView view=new ModelAndView("adminprofile");
    view.addObject("admin",adminService.getAdminByEmail(principal.getName()));
    return view;
}

@GetMapping("admin/accept/{id}")
public String acceptUser(@PathVariable("id") int id) {

    Vendor vendor = vendorService.getVendor(id);
    vendor.setStatus(true);
    vendorService.updateVendor(vendor);
    return "redirect:/admin/vendordetails";

}
@GetMapping("admin/reject/{id}")
public String rejectUser(@PathVariable("id") int id) 
{
    Vendor vendor = vendorService.getVendor(id);
    vendor.setStatus(false);
    vendorService.updateVendor(vendor);
    return "redirect:/admin/vendor";

}
@GetMapping("admin/vendor")
public String getVendorDetails(Map<String, Object> vendors) {
    vendors.put("vendorList", adminService.getAllVendors());
    return "vendor";
}
    
}
    
    
    
  