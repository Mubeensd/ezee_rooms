package hotel_managementp1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Random;

import com.mysql.cj.Session;

@WebServlet("/cust")
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Customer() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Servises servise = new Servises();
		PrintWriter out = response.getWriter();

		
		Random r1 = new Random();
		int no = r1.nextInt(9999) + 1000;
		
        String romid = request.getParameter("rid");
        int rid=Integer.parseInt(romid);
		String name = request.getParameter("name");
		String number1 = request.getParameter("number");
		int amt=Integer.parseInt(request.getParameter("amt"));
		String mode = request.getParameter("mode");
		
		String result = servise.addCustomer(no, name, number1, mode,rid);
		if (result.equalsIgnoreCase("success")) {
			
			servise.changeStatus(rid);			
			HttpSession session = request.getSession();
			session.setAttribute("customer_id", no);
			session.setAttribute("Name", name);
			session.setAttribute("Room_id",rid );
			session.setAttribute("Phone_number", number1);
			session.setAttribute("price", amt);
			session.setAttribute("payment_mode", mode);
			
			RequestDispatcher rd = request.getRequestDispatcher("/booked.jsp");
			rd.forward(request, response);

		} else {
			
			out.print("<h1 style=color:red>Room is already booked !!<h1>");

			RequestDispatcher rd = request.getRequestDispatcher("/CustomerInfo.jsp");
			rd.include(request, response);
		}

	}

}
