package com.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.HoroscopeUser;
import com.persistence.HoroscopeUserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SignUpServlet extends HttpServlet {

    HoroscopeUserDAO horoscopeUserDAO = new HoroscopeUserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //doCors(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        //REGISTER NEW USER
        doCors(req,resp);
        processUserSignUp(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doOptions(req, resp);
        doCors(req, resp);
    }

    public void doCors(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin","http://127.0.0.1:5500");
        resp.addHeader("Vary","Origin");
        resp.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, PUT, DELETE, HEAD");
        resp.addHeader("Access-Control-Allow-Headers","*"); //"X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        resp.addHeader("Access-Control-Allow-Credentials","true");
        resp.addHeader("Access-Control-Max-Age","1728000");
        resp.addHeader("Produces","application/json");

    }
    private void processUserSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }

        System.out.println(sb);

        String body = sb.toString();

        String[] sepByComma = body.split(",");

        ArrayList<String> values = new ArrayList<>();

        for (String value : sepByComma) {
            value = value.replaceAll("\\{", "").replaceAll("}", "").replaceAll("\"", "");
            System.out.println(value);
            String target = value.substring(value.indexOf(":") + 1);
            System.out.println(target);
            values.add(target);
        }

        String first_name = values.get(0);
        String last_name = values.get(1);
        String email = values.get(2);
        String username = values.get(3);
        String passw = values.get(4);
        String horoscope = values.get(5);

        HoroscopeUser horoscopeUser = new HoroscopeUser(first_name,last_name,email,username,passw,horoscope);
        horoscopeUserDAO.create(horoscopeUser);

        if(horoscopeUser != null){
            resp.setStatus(200);
            System.out.println("horoscopeUser is NOT null");

            //get an HTTP Session
            HttpSession session = req.getSession();
            session.setAttribute("user",horoscopeUser);
            System.out.println("Made it through HTTP Session");

            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");
//            resp.addHeader("Access-Control-Allow-Origin","*");
            System.out.println("Made it through PrintWriter");


            //NEED BELOW FOR LOGGING IN NOT TO SIGN UP BECAUSE WE DONT HAVE TO RETURN A USER
//            ObjectMapper om = new ObjectMapper();
//
//            //convert the Java object to a JSON object with the object mapper
//
//            out.println(om.writeValueAsString(horoscopeUser));
//            System.out.println("Made it through Object Mapper");
//
//            System.out.println("The user with username: "+horoscopeUser.getUsername()+" has signed up");

        }
            //System.out.println("horoscopeUser is null");

        }

    }



