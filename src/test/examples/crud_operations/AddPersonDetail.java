package test.examples.crud_operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPersonDetail
 */
@WebServlet("/AddPersonDetail")
public class AddPersonDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPersonDetail() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String id = request.getParameter("id");

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");

		Person person = new Person(firstName, lastName, address);

		if (id == "" || id.isEmpty()) {
			String sql = "insert into PERSON(FIRST_NAME, LAST_NAME, ADDRESS) values (?,?,?)";

			Connection conn = null;

			try {
				conn = (Connection) request.getServletContext().getAttribute("connection");
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, person.getFirstName());
				pStmt.setString(2, person.getLastName());
				pStmt.setString(3, person.getAddress());

				int row = pStmt.executeUpdate();

				response.getWriter().println("User Added Successfully");

				request.getRequestDispatcher("/addPerson.jsp").include(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {

			String sql = "update PERSON set FIRST_NAME=?, LAST_NAME=?, ADDRESS=? where id=?";

			Connection conn = null;

			try {
				conn = (Connection) request.getServletContext().getAttribute("connection");
				PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, person.getFirstName());
				pStmt.setString(2, person.getLastName());
				pStmt.setString(3, person.getAddress());
				pStmt.setInt(4, Integer.parseInt(id));

				int row = pStmt.executeUpdate();

				response.getWriter().println("User Updated Successfully");

				request.getRequestDispatcher("/addPerson.jsp").include(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
