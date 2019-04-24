package test.examples.crud_operations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBListener
 *
 */
@WebListener
public class DBListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
    	
    	 System.out.println("Initializing Database.....");
         ServletContext context = event.getServletContext();
         
         Connection conn = (Connection) context.getAttribute("connection");
         
         try {
			Statement stmt = conn.createStatement();
			
			String fileName = "/WEB-INF/create_person_table.sql";
			
			InputStream in = context.getResourceAsStream(fileName);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line = null;
			System.out.println("Executing Query.....");
			while((line = reader.readLine()) != null) {
				System.out.println(line);
				int i = stmt.executeUpdate(line);
				
				String msg = (i == 0) ? "Table Created Successfully" : "Row(s) inserted successfully";
				System.out.println(msg);
				
			}
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    }
	
}
