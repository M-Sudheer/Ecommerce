package web.frontend.dao;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import demo.project.tables.dao.CartItemIdService;
import demo.project.tables.dao.CartItemsService;
import demo.project.tables.dao.CartService;
import demo.project.tables.dao.CustomerService;
import demo.project.tables.dao.NoOfProductsService;
import demo.project.tables.dao.ProductService;
import demo.project.tables.model.Cart;
import demo.project.tables.model.CartItemId;
import demo.project.tables.model.CartItems;
import demo.project.tables.model.Customer;
import demo.project.tables.model.NoOfProducts;
import demo.project.tables.model.Products;



@Controller
public class CartController
{
	@Autowired
	private NoOfProductsService noOfProductsService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItems cartItems;

	@Autowired
	private Customer customer;

	@Autowired
	private CartItemsService cartItemsService;

	@Autowired
	private CartItemId cartItemId;

	@Autowired
	private CartItemIdService cartItemIdService;

	@Autowired
	private ProductService productService;

	@Autowired
	private Products products;
	
	@Autowired
	private Cart cart;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private NoOfProducts noOfProducts;

	@GetMapping("/customer/addtocart")
	public String addToCart(Principal principal, HttpServletRequest request) 
	{
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int quantity = Integer.parseInt(request.getParameter("noOfProducts"));
		int unitprice = productService.getProduct(product_id).getPrice();
		System.out.println(productService.getProduct(product_id).getPrice());
		Products products=productService.getProduct(product_id);
		customer=customerService.getCustomerByEmail(principal.getName());

		if (checkAvailabilityOfProducts(product_id,quantity)==true)
		{
			cart = cartService.getCart(customer.getId());
			
			if (cart == null) {
				
				cart = new Cart();
				cartItems = new CartItems();
				List<CartItemId> cartItemIdList = new ArrayList<CartItemId>();
				List<CartItems> cartItemsList = new ArrayList<CartItems>();
				List<NoOfProducts> noOfProductsList = noOfProductsService.getNoOfProducts(product_id);

				for (int i = 0; i < quantity; i++) {
					
					cartItemId = new CartItemId();
					noOfProducts = new NoOfProducts();
					noOfProducts = noOfProductsList.get(i);
					noOfProducts.setSold(true);
					cartItemId.setNoOfProducts(noOfProducts);
					cartItemId.setCartItems(cartItems);
					cartItemIdList.add(cartItemId);
				}
				cartItems.setUnitPrice(unitprice);
				cartItems.setTotalPrice(unitprice * quantity);
				cartItems.setQuantity(quantity);
				cartItems.setCartItemIds(cartItemIdList);
				cartItems.setCart(cart);
				cartItemsList.add(cartItems);
				cart.setCartItems(cartItemsList);
				cart.setCustomer(customer);
				cart.setNetPrice(quantity * unitprice);
				cart.setNoOfItems(quantity);
				cartService.addCart(cart);

				return "redirect:/customer/cart";

			} else {

				cartItems = checkIfProductAlreadyExists(product_id, cart);

				if (cartItems != null) 
				{

					List<CartItemId> cartItemIdsList = new ArrayList<CartItemId>();
					List<CartItems> cartItemsList = new ArrayList<CartItems>();
					cartItemsList = cart.getCartItems();
					int position = cartItemsList.indexOf(cartItems);
					List<NoOfProducts> noOfProductsList = noOfProductsService.getNoOfProducts(product_id);
					cartItemIdsList = cartItemIdService.getAllCartItemId(cartItems.getCartItem_id());
					
					for (int i = 0; i < quantity; i++) {
						
						cartItemId = new CartItemId();
						noOfProducts = new NoOfProducts();
						noOfProducts = noOfProductsList.get(i);
						noOfProducts.setSold(true);
						cartItemId.setNoOfProducts(noOfProducts);
						cartItemId.setCartItems(cartItems);
						cartItemIdsList.add(cartItemId);
					}
					cartItems.setCartItemIds(cartItemIdsList);
					cartItemsList.add(position, cartItems);
					cart.setCartItems(cartItemsList);
					cart.setNetPrice((quantity * unitprice) + cart.getNetPrice());
					cart.setNoOfItems(quantity + cart.getNoOfItems());
					cartService.updateCart(cart);

					return "redirect:/customer/cart";
				} else {

					cartItems = new CartItems();
					List<CartItemId> cartItemIdsList = new ArrayList<CartItemId>();
					List<CartItems> cartItemsList = new ArrayList<CartItems>();
					List<NoOfProducts> numberOfProductsList = noOfProductsService.getNoOfProducts(product_id);
					for (int i = 0; i < quantity; i++) {
						
						cartItemId = new CartItemId();
						noOfProducts = new NoOfProducts();
						noOfProducts = numberOfProductsList.get(i);
						noOfProducts.setSold(true);
						cartItemId.setNoOfProducts(noOfProducts);
						cartItemId.setCartItems(cartItems);
						cartItemIdsList.add(cartItemId);
					}
					cartItems.setUnitPrice(unitprice);
					cartItems.setTotalPrice(unitprice * quantity);
					cartItems.setQuantity(quantity);
					cartItems.setCartItemIds(cartItemIdsList);
					cartItems.setCart(cart);
					cartItemsList.add(cartItems);
					cart.setCartItems(cartItemsList);
					cart.setNetPrice((quantity * unitprice) + cart.getNetPrice());
					cart.setNoOfItems(quantity + cart.getNoOfItems());
					cartService.updateCart(cart);
					return "redirect:/customer/cart";
				}

			}

		} else {

			return  "redirect:/customer/customerpage";
		}

	}

	public CartItems checkIfProductAlreadyExists(int product_id, Cart cart) 
	{
		
		List<CartItems> cartItemsList = cart.getCartItems();
		for (CartItems items : cartItemsList)
		{
				if (items.getCartItemIds().get(0).getNoOfProducts().getProduct().getProduct_id() == product_id) {
				return items;
		}
		}
		return null;
	}

	public boolean checkAvailabilityOfProducts(int product_id, int quantity) 
	{
			if (noOfProductsService.getNoOfProducts(product_id).size() >= quantity) 
			{
				return true;
			}
			else
			{
				return false;
			}
	}
	
	@GetMapping("/customer/cart")
	public String displayCart(Principal principal,Model model)
	{
		Customer customer=customerService.getCustomerByEmail(principal.getName());
		Cart cart=cartService.getCart(customer.getId());
		
		model.addAttribute("cart",cart);
		return "cart";
	}

}