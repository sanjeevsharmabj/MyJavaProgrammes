package com.wellsfargo.fsd.ckmp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wellsfargo.fsd.ckmp.entity.Product;
import com.wellsfargo.fsd.ckmp.exception.CoronaKitException;
import com.wellsfargo.fsd.ckmp.service.ProductService;
import com.wellsfargo.fsd.ckmp.service.ProductServiceImpl;

/**
 * Servlet implementation class CkmpFrontController
 */
@WebServlet({"/login","/Productslist","/newProduct","/addProduct","/editProduct","/saveProduct","/deleteProduct","/logout","/newUser","/listAllProducts","/addProductsToKit","/showKit","/addAnotherProduct","/placeOrder","/orderSummary"})
public class CkmpFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService;
	
    @Override
	public void init() throws ServletException {
    	productService = new ProductServiceImpl();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public CkmpFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getServletPath();
	    String view = "";
	    switch (url) {
	    	case "/login":
	    		view = doLogin(request, response);
	       		break;
	    	case "/Productslist":
	       		view = doListProducts(request, response);
	       		break;
	       	case "/newProduct":
	       		view = doAddProduct(request, response);
	       		break;
	       	case "/addProduct":
	       		view = doCreateorSaveProduct(request, response);
	       		break;
	       	case "/editProduct":
	       		view = doEditProduct(request, response);
	       		break;
	       	case "/saveProduct":
	       		view = doCreateorSaveProduct(request, response);
	       		break;
	       	case "/deleteProduct":
	       		view = doDeleteProduct(request, response);
	       		break;
	       	case "/logout":
	       		view = doLogout(request, response);
	       		break;
	       	case "/newUser":
	    		view = doEnterNewUser(request, response);
	    		break;
	    	case "/listAllProducts":
	    		view = dolistAllProductsForUser(request, response);
	    		break;
	    	case "/addProductsToKit":
	    		view = doAddProductsToKit(request, response);
	    		break;
	    	case "/showKit":
	    		view = doShowKit(request, response);
	    		break;
	    	case "/addAnotherProduct":
	    		view = dolistAllProductsToAddAgain(request, response);
	    		break;
	    	case "/placeOrder":
	    		view = doPlaceOrder(request, response);
	    		break;
	    	case "/orderSummary":
	    		view = doDisplayOrderSummary(request, response);
	    		break;
	       	default :
	       		view = "notfound.jsp";
	       		break;
	       }
	       
	      request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private String doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "";
		HttpSession session = request.getSession();
		session.setAttribute("loginSuccess", true);
		session.setAttribute("userName", request.getParameter("userName"));
		view = doListProducts(request, response);
	    return view;
	}	
	
	
	private String doListProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String view = "";
	       try {
	           List<Product> products = productService.getAllProducts();
	           request.setAttribute("products", products);
	           view="listproducts.jsp";
	       } catch (CoronaKitException e) {
	           request.setAttribute("errMsg", e.getMessage());
	           view="errorPage.jsp";
	       }
	       return view;
	}
	
	
	private String doAddProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String view = "";
	       Product product = new Product();
	       request.setAttribute("product", product);
	       view = "newproduct.jsp";
	       return view;
	}
	
	private String doEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String view = "";
	       int productId = Integer.parseInt(request.getParameter("id"));
	       try {
	    	   Product product = productService.getProduct(productId);
	           request.setAttribute("product", product);
	           view = "editproduct.jsp";
	       } catch (CoronaKitException e) {
	           request.setAttribute("errMsg", e.getMessage());
	           view = "errorPage.jsp";
	       }
	       return view;
	}
	
	private String doCreateorSaveProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        
        product.setProductId(Integer.parseInt(request.getParameter("productId")));
        product.setProductName(request.getParameter("productName"));
        product.setProductCost(Double.parseDouble(request.getParameter("productCost")));
        product.setProductDesc(request.getParameter("productDesc"));
        
        String view = "";
        
        try {
        	if(request.getServletPath().equals("/addProduct")) {
                productService.validateAndAdd(product);
            }else {
            	productService.validateAndSave(product);
            }
            request.setAttribute("msg", "Product is saved!");
            view = doListProducts(request, response);
        } catch (CoronaKitException e) {
            request.setAttribute("errMsg", e.getMessage());
            view = "errorPage.jsp";
        }
        return view;
    }
	
	
	private String doDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String view = "";
	       int productId = Integer.parseInt(request.getParameter("id"));
	       try {
	    	   productService.deleteProduct(productId);
	           request.setAttribute("msg", "Product Record Deleted!");
	           view = "listproducts.jsp";
	       } catch (CoronaKitException e) {
	           request.setAttribute("errMsg", e.getMessage());
	           view = "errorPage.jsp";
	       }
	       return view;
	}
	
	private String doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "";
		HttpSession session = request.getSession();
		session.setAttribute("loginSuccess", false);
		request.setAttribute("msg", "Logged Out Successfully!");
        view = "login.jsp";
		return view;
	}
	
	private String doEnterNewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "";
		HttpSession session = request.getSession();
		session.setAttribute("listProductPage", true);
		session.setAttribute("userFirstName", request.getParameter("firstName"));
		session.setAttribute("userLastName", request.getParameter("lastName"));
		session.setAttribute("userFullName", request.getParameter("firstName") + " " + request.getParameter("lastName"));
		session.setAttribute("userEmailId", request.getParameter("emailId"));
		session.setAttribute("userContactNo", request.getParameter("contactNo"));
	    view = "newuser.jsp";
	    return view;
	}

	private String dolistAllProductsForUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		HttpSession session = request.getSession();
		session.setAttribute("kitProduct", null);
		session.setAttribute("kitAddedProducts", null);
		try {
			List<Product> products = productService.getAllProducts();
	        request.setAttribute("products", products);
	        view="showproductstoadd.jsp"; 
		} catch (CoronaKitException e) {
			request.setAttribute("errMsg", e.getMessage());
	        view = "errorPage.jsp";
	        }			
		return view;
	}
	
	protected String doAddProductsToKit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		Product product = null;
		try {
			product = productService.getProduct(Integer.parseInt(request.getParameter("id")));
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (CoronaKitException e1) {
			e1.printStackTrace();
		}
		HttpSession session = request.getSession();

		List<Product> kitProducts = (List<Product>)session.getAttribute("kitProduct");
		
		if (kitProducts==null) {
			kitProducts =  new ArrayList<>();
		}
		
		if (product!=null) {
			kitProducts.add(product);
		}
		
		session.setAttribute("kitProduct", kitProducts); 
		try {
			List<Product> products = productService.getAllProducts();
	        request.setAttribute("products", products);
	        request.setAttribute("addMsg", "Selected Item is added to the Kit! Click on Add again to increase the quantity");
			view="showproductstoadd.jsp"; 
		} catch (CoronaKitException e) {
			request.setAttribute("errMsg", e.getMessage());
	        view = "errorPage.jsp"; 
	    }			
		return view;		
	}
	
	private String dolistAllProductsToAddAgain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		//HttpSession session = request.getSession();
		//session.setAttribute("kitProduct", null);
		//session.setAttribute("kitAddedProducts", null);
		try {
			List<Product> products = productService.getAllProducts();
	        request.setAttribute("products", products);
	        view="showproductstoadd.jsp"; 
		} catch (CoronaKitException e) {
			request.setAttribute("errMsg", e.getMessage());
	        view = "errorPage.jsp";
	        }			
		return view;
	}

	protected String doShowKit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		HttpSession session = request.getSession();
		List<Product> kitProducts = (List<Product>) session.getAttribute("kitProduct");
		
		if (kitProducts!=null) {
			List<Product> kitAddedProducts = new ArrayList<>();
			session.setAttribute("quantity", null);
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			for(Product eachProd : kitProducts) {
				if (map.containsKey(eachProd.getProductId())) {
					map.put(eachProd.getProductId(), map.get(eachProd.getProductId())+1);	
				} else {
					map.put(eachProd.getProductId(), 1);
					kitAddedProducts.add(eachProd);
				}
			}
			
			session.setAttribute("quantity", map);
			session.setAttribute("kitAddedProducts", kitAddedProducts);
		}
		
		view="showkit.jsp";
		return view;		
	}

	protected String doPlaceOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "";
		HttpSession session = request.getSession();
		session.setAttribute("EnteredAddress", true);
		if (session.getAttribute("EnteredAddress")!=null) {
			session.setAttribute("AddLine1", request.getParameter("AddLine1"));
			session.setAttribute("AddLine2", request.getParameter("AddLine2"));
			session.setAttribute("City", request.getParameter("City"));
			session.setAttribute("State", request.getParameter("State"));
			session.setAttribute("PinCode", request.getParameter("PinCode"));
		}
		view="placeorder.jsp";
		return view;		
	}

	protected String doDisplayOrderSummary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		HttpSession session = request.getSession();
		Double TotalAmount = 0.0;
		List<Product> kitAddedProducts = (List<Product>) session.getAttribute("kitAddedProducts");
		HashMap<Integer,Integer> map = (HashMap<Integer,Integer>) session.getAttribute("quantity");
		for (Product eachProd : kitAddedProducts) {
			TotalAmount = TotalAmount + (eachProd.getProductCost() * map.get(eachProd.getProductId()));
		}
		session.setAttribute("TotalAmount", TotalAmount);	
		view="ordersummary.jsp";
		return view;
	}

		
}
