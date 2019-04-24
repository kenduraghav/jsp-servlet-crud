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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetPersonDetails
 */
@WebServlet("/GetPersonDetails")
public class GetPersonDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPersonDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		String action = request.getParameter("action") == null ? "" : request.getParameter("action");

		switch (action.toLowerCase()) {
		case "edit":
			edit(request, response);
			break;
		case "delete":
			delete(request, response);
		default:
			select(request, response);
			break;
		}

	}

	private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from PERSON";
		Connection conn = null;
		try {
			conn = (Connection) request.getServletContext().getAttribute("connection");
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			List<Person> persons = new ArrayList<>();
			while (rs.next()) {
				Person person = new Person();
				person.setId(rs.getLong("ID"));
				person.setFirstName(rs.getString("FIRST_NAME"));
				person.setLastName(rs.getString("LAST_NAME"));
				person.setAddress(rs.getString("ADDRESS"));
				persons.add(person);
			}
			request.setAttribute("persons", persons);
			request.getRequestDispatcher("/listUser.jsp").include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select * from PERSON where id=?";
		Connection conn = null;
		try {
			conn = (Connection) request.getServletContext().getAttribute("connection");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(request.getParameter("id")));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Person person = new Person();
				person.setId(rs.getLong("ID"));
				person.setFirstName(rs.getString("FIRST_NAME"));
				person.setLastName(rs.getString("LAST_NAME"));
				person.setAddress(rs.getString("ADDRESS"));
				request.setAttribute("person", person);
			}
			request.getRequestDispatcher("/addPerson.jsp").include(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sql = "Delete from PERSON where id=?";

		Connection conn = null;
		try {
			conn = (Connection) request.getServletContext().getAttribute("connection");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(request.getParameter("id")));
			int row = stmt.executeUpdate();
			response.getWriter().println("Person detail deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
