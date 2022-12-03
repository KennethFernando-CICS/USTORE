import java.io.*;
import java.util.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
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
        String path = sce.getServletContext().getRealPath("") + "/WEB-INF/";
        //System.out.println(path);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
        System.out.println("UStore Web Application Shut Down.");
    }
    
//    public void getLoginCredentials(ServletContext context) throws IOException 
//    { 
//        //method to create a hashmap for username and password      
//        Map<String, String> credentials = new HashMap<>();
//        List<User> userList = new ArrayList<>();
//        String path = "/WEB-INF/loginCredentials.txt";
//
//        InputStream is = context.getResourceAsStream(path);
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
//        String user, pass = null;
//
//        for (int ctr = 1; (user = br.readLine()) != null; ctr++) { //iterate through the text file
//            if (ctr % 2 != 0) //if the current line is an odd number
//            {
//                pass = user; //give the string from user to password
//            } else //if the current line is an even number
//            {
//                credentials.put(user, pass); //set hashmap with username and password
//                //System.out.println("Put " + user + ", " + pass + " in map.");
//                User newUser = new User(user, pass);
//                userList.add(newUser);
//                //System.out.println("Added " + newUser + " to list.");
//            }
//
//        }
//        br.close();
//        
//        context.setAttribute("credentials", credentials);
//        context.setAttribute("userList", userList);
//    }
}
