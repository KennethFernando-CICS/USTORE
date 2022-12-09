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
            categorizeProducts(context);
            System.out.println("Success");
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
        Map<String, String> credentials = new HashMap<>();
        List<User> userList = new ArrayList<>();
        String path = "/WEB-INF/loginCredentials.txt";

        InputStream is = context.getResourceAsStream(path);

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String user, pass = null;

        for (int ctr = 1; (user = br.readLine()) != null; ctr++) {
            if (ctr % 2 != 0){
                pass = user;
            } else {
                credentials.put(user, pass);
                User u = new User(user, pass);
                u.setFirstName(user);
                userList.add(u);
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
                    addProduct.setProductId(ctr);
                    addProduct.setName(productDetails[0]);
                    addProduct.setPrice(Double.parseDouble(productDetails[1]));
                    addProduct.setStock(Integer.parseInt(productDetails[2]));
                    addProduct.setSizeList(productDetails[3]);
                    addProduct.setPictureName(productDetails[4]);                     
                    productList.add(addProduct);
                    System.out.println("Added " + productList.get(ctr)); 
                    ctr++;
                }
            } catch (Exception e) {}
        
        context.setAttribute("productList", productList);
    }
    public void categorizeProducts(ServletContext context){
        List<Product> productList = (ArrayList)context.getAttribute("productList");
        Map<String,List<Product>> categoryMap = new HashMap<>();
        String[] categories = {"T-shirt","Windbreaker","Jacket"};
        
        for (String category : categories) {
            List<Product> sortedList = new ArrayList<>();
            categoryMap.put(category, sortedList);
            //System.out.println("Added " + category + " to Map.");
            for (Product product: productList) {
                if(product.getName().contains(category)){
                    product.setCategory(category);
                    //System.out.println("Category " + category + " set to " + product);
                    sortedList.add(product);
                    //System.out.println("Added " + product + "to " + category);
                }
            }
        }        
        context.setAttribute("categoryMap", categoryMap);        
    }
}
