import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * Web application lifecycle listener.
 */
public class USTORE_ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
        System.out.println("UStore Web Application Initialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
        System.out.println("UStore Web Application Shut Down.");
    }
}
