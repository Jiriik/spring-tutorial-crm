package cz.vlasimsky.tutorials.spring.crm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServlet")
public class TestDbServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String user = "springstudent";
        String pass = "springstudent";

        String connectionString = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";


        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to database" + connectionString);

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(connectionString, user, pass);

            out.println("Connection to the DB established");

            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException();
        } finally {
        }

    }
}
