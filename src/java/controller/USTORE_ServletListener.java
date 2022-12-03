package controller;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.Product;
import model.User;

/*
 * Web application lifecycle listener.
 */
public class USTORE_ServletListener implements ServletContextListener 
{

    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
        System.out.println("UStore Web Application Initialized.");
        ServletContext context = sce.getServletContext();
        String path = context.getRealPath("") + "/WEB-INF/";
        //System.out.println(path);
        try {
            getLoginCredentials(context);
            getProducts(context);
        } catch (IOException ex) {
            Logger.getLogger(USTORE_ServletListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
        System.out.println("UStore Web Application Shut Down.");
    }
    
    public void getLoginCredentials(ServletContext context) throws IOException 
    { 
        //method to create a hashmap for username and password      
        Map<String, String> credentials = new HashMap<>();
        List<User> userList = new ArrayList<>();
        String path = "/WEB-INF/loginCredentials.txt";

        InputStream is = context.getResourceAsStream(path);

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String user, pass = null;

        for (int ctr = 1; (user = br.readLine()) != null; ctr++) { //iterate through the text file
            if (ctr % 2 != 0) //if the current line is an odd number
            {
                pass = user; //give the string from user to password
            } else //if the current line is an even number
            {
                credentials.put(user, pass); //set hashmap with username and password
                //System.out.println("Put " + user + ", " + pass + " in map.");
                User newUser = new User(user, pass);
                newUser.setFirstName(user);
                userList.add(newUser);
                //System.out.println("Added " + newUser + " to list.");
            }

        }
        br.close();
        
        context.setAttribute("credentials", credentials);
        context.setAttribute("userList", userList);
    }
    public void getProducts(ServletContext context) throws IOException 
    {
        List<Product> productList = new ArrayList<>();

        String line = "";
        String path = "/WEB-INF/products.csv";

        InputStream is = context.getResourceAsStream(path);
        int ctr = 0;
            try (BufferedReader fileRead = new BufferedReader(new InputStreamReader(is))) 
            {
                while((line = fileRead.readLine()) != null)
                {
                    Product addProduct = new Product();
                    String[] productDetails = line.split(",");
                    //System.out.println(Arrays.toString(productDetails));
                    addProduct.setName(productDetails[0]);
                    addProduct.setPrice(Double.parseDouble(productDetails[1]));
                    addProduct.setStock(Integer.parseInt(productDetails[2]));
                    addProduct.setSizeList(productDetails[3]);
                    addProduct.setPictureName(productDetails[4]);                     
                    productList.add(addProduct);
                    System.out.println("Added " + productList.get(ctr)); 
                    ctr++;
                }

            } catch (Exception e) {
                //System.out.println("Error at try-catch");
            }
        
        context.setAttribute("productList", productList);
    }
}
