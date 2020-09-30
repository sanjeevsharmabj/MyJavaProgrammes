package com.wellsfargo.fsd.cpv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.wellsfargo.fsd.cvp.entity.CovidProds;
import com.wellsfargo.fsd.cvp.entity.UsersPortal;
import com.wellsfargo.fsd.cvp.exception.CovidProdException;
import com.wellsfargo.fsd.cvp.service.CovidProdsImp;
import com.wellsfargo.fsd.cvp.service.CovidProdsService;
import com.wellsfargo.fsd.cvp.service.UsersPortalImp;

/**
 * Servlet implementation class CovidProdKitFrontEnd
 */
@WebServlet({ "/listprods", "/editprod", "/deleteprod", "/addprod", "/saveprod", "/newprod", "/logout",
		"/newuser", "/saveuser", "/addtokit","/showKit","/listprodagain","/placeorder","/orderSummary","/userprodlist","/adminLogin" })
public class CovidProductsKitManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CovidProdsService covidprodsservice;

	@Override
	public void init() throws ServletException {
		covidprodsservice = new CovidProdsImp();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		String view = "";

		switch (url) {
		case "/listprods":
			view = doList(request, response);
			break;
		case "/deleteprod":
			view = doDeleteProd(request, response);
			break;
		case "/newprod":
			view = doAddProd(request, response);
			break;
		case "/addprod":
			view = doCreateorSaveProd(request, response);
			break;
		case "/editprod":
			view = doEditProd(request, response);
			break;
		case "/saveprod":
			view = doCreateorSaveProd(request, response);
			break;
		case "/adminLogin":
			view = doAdminPage(request, response);
			break;	
		case "/logout":
			view = doLogout(request, response);
			break;
		case "/newuser":
			view = doNewUser(request, response);
			break;
		/*case "/saveuser":
			view = doSaveNewUser(request, response);
			break;*/
		case "/addtokit":
			view = doaddtoKit(request, response);
			break;
		case "/listprodagain":
			view = doListprodAgain(request,response);
			break;
		case "/showKit":
			view = doShowCart(request,response);
			break;
		case "/placeorder":
			view = doPlaceOrder(request,response);
			break;
		case "/orderSummary" :
			view = doorderSummary(request,response);
			break;
		case "/userprodlist":
			view = doAvailableProducts(request,response); 
			break;
		default:
			view = "notFound.jsp";
			break;
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	
	
	private String doAdminPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		HttpSession session = request.getSession();
		session.setAttribute("login", true);
		session.setAttribute("username", request.getParameter("user"));
		view = doList(request, response);
		//view = "listProductsPage.jsp";
		return view;		
		}
		
	

	/*private String doNewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";

		UsersPortal usersportal = new UsersPortal();
		request.setAttribute("usersportal", usersportal);
		// request.setAttribute("msg", "User Details Saved Successfully");
		view = "newUser.jsp";
		return view;
	}*/

	private String doNewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		HttpSession session = request.getSession();
		session.setAttribute("listProducts", true);
		UsersPortal usersportal = new UsersPortal();
		usersportal.setFirstName(request.getParameter("firstName"));
		session.setAttribute("firstName", request.getParameter("firstName"));
		usersportal.setLastName(request.getParameter("lastName"));
		session.setAttribute("lastName", request.getParameter("lastName"));
		//usersportal.setAddress(request.getParameter("address"));
		usersportal.setContactNo(request.getParameter("contactNo"));
		session.setAttribute("contactNo", request.getParameter("contactNo"));
		usersportal.setEmailAdd(request.getParameter("emailAdd"));
		session.setAttribute("emailAdd", request.getParameter("emailAdd"));
		request.setAttribute("msg", "User Details Saved Successfully");
		session.setAttribute("usersportal", request.getParameter("usersportal"));
		view = "newUser.jsp";
		return view;
	}

	private String doList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		
		try {
			List<CovidProds> covidprodts = covidprodsservice.getAllCovidProds();
			request.setAttribute("covidprodts", covidprodts);
			view = "listProductsPage.jsp";
			// view= "showProducts.jsp";
		} catch (CovidProdException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
			
		}
		return view;
	}

	private String doAddProd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = "";
		CovidProds covidprod = new CovidProds();
		request.setAttribute("covidprod", covidprod);
		request.setAttribute("isNew", true);
		view = "newProduct.jsp";
		return view;
	}

	private String doEditProd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = "";
		int prodId = Integer.parseInt(request.getParameter("id"));
		try {
			CovidProds covidprods = covidprodsservice.getCovidProds(prodId);
			request.setAttribute("covidprods", covidprods);
			request.setAttribute("isNew", false);
			view = "newProduct.jsp";
		} catch (CovidProdException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}

		return view;
	}

	private String doCreateorSaveProd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CovidProds covidprods = new CovidProds();
		covidprods.setProdId(Integer.parseInt(request.getParameter("prodId")));
		covidprods.setProdName(request.getParameter("prodName"));
		covidprods.setProdDesc(request.getParameter("prodDesc"));
		covidprods.setProdPrice(Double.parseDouble(request.getParameter("prodPrice")));
		String view = "";
		try {
			if (request.getServletPath().equals("/addprod")) {
				covidprodsservice.ValidateandAdd(covidprods);
			} else {
				covidprodsservice.ValidateandSave(covidprods);
			}

			request.setAttribute("msg", "Product is saved successfully");
			view = doList(request, response);
		} catch (CovidProdException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		return view;
	}

	private String doDeleteProd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		int prodId = Integer.parseInt(request.getParameter("id"));
		try {
			covidprodsservice.deletCovidProds(prodId);
			request.setAttribute("msg", "Product Deleted Succesfully");
			view = "index.jsp";
		} catch (CovidProdException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		return view;
	}

	private String doLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		HttpSession session = request.getSession();
		session.setAttribute("login", false);
		request.setAttribute("msg", "Logged out successfully");
		view = "adminLogin.jsp";
		return view;
	}

	private String doAvailableProducts(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		HttpSession session = request.getSession();
		session.setAttribute("covprod", null);
		session.setAttribute("prodaddedtocart", null);
		try {
			List<CovidProds> covidprodts = covidprodsservice.getAllCovidProds();
			request.setAttribute("covidprodts", covidprodts);
			view = "showProducts.jsp";
		} catch (CovidProdException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		return view;
	}
	
	
	

	protected String doaddtoKit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		CovidProds covidprods = null;
		try {
			covidprods = covidprodsservice.getCovidProds(Integer.parseInt(request.getParameter("id")));
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (CovidProdException e) {
			request.setAttribute("errMsg", e.getMessage());
		}
		HttpSession session = request.getSession();

		List<CovidProds> covprods = (List<CovidProds>)session.getAttribute("covprod");
		if (covprods == null) {
			covprods = new ArrayList<>();
		}

		if (covidprods!= null) {
			covprods.add(covidprods);
		}
		session.setAttribute("covprod", covprods);
		try {
			List<CovidProds> covidprodts = covidprodsservice.getAllCovidProds();
			request.setAttribute("covidprodts", covidprodts);
			request.setAttribute("prodaddmsg", "Selected product added to the cart  successfully!!");
			view="showProducts.jsp"; 
		} catch (CovidProdException e1) {
			request.setAttribute("errMsg", e1.getMessage());
			view = "errorPage.jsp";
		}
		return view;
	}
	
	private String doListprodAgain(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		try {
			List<CovidProds> covidprodts = covidprodsservice.getAllCovidProds();
			request.setAttribute("covidprodts", covidprodts);
			view = "showProducts.jsp";
		} catch (CovidProdException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		return view;
	}
	
	protected String doShowCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		HttpSession session = request.getSession();
		List<CovidProds> covprods = (List<CovidProds>) session.getAttribute("covprod");
		if (covprods!=null) {
			List<CovidProds> prodaddedtocart = new ArrayList<>();
			session.setAttribute("quantity", null);
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			for(CovidProds eachProd :covprods ) {
				if(map.containsKey(eachProd.getProdId())) {
					map.put(eachProd.getProdId(), map.get(eachProd.getProdId())+1);
				} else {
						map.put(eachProd.getProdId(), 1);
						prodaddedtocart.add(eachProd);
				}
					
			}
			
			session.setAttribute("quantity", map);
			session.setAttribute("prodaddedtocart", prodaddedtocart);
		}
		
		view ="showKit.jsp";
		return view;
	}
	
	protected String doPlaceOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view ="";
		HttpSession session = request.getSession();
		session.setAttribute("enteraddress", true);
		if(session.getAttribute("enteraddress")!=null){
			session.setAttribute("address",request.getParameter("address"));
		}
		view = "placeOrder.jsp";
		return view;
	}
	
	protected String doorderSummary(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view ="";
		HttpSession session = request.getSession();
		Double TotalPrice = 0.0;
		List<CovidProds> prodaddedtocart = (List<CovidProds>) session.getAttribute("prodaddedtocart");
		HashMap<Integer,Integer> map = (HashMap<Integer,Integer>) session.getAttribute("quantity");
		for (CovidProds eachProd : prodaddedtocart) {
			TotalPrice = TotalPrice + (eachProd.getProdPrice() * map.get(eachProd.getProdId()));
		}
		session.setAttribute("TotalPrice", TotalPrice);	
		view="orderSummary.jsp";
		return view;
		
	}
}
