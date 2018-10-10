package com.cice.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("user");
        String pass = req.getParameter("pass");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/login","root","root");

            Statement statement = connection.createStatement();
            ResultSet busqueda = statement.executeQuery("Select * FROM usuarios WHERE user ='" + user + "' AND pass = '" + pass + "'");

            if(busqueda.first()){
                resp.getWriter().print("usuario encontrado");
            }else{
                resp.getWriter().print("usuario NO encontrado");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
