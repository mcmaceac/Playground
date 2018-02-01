package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MaxPrincipal
 *
 */
@WebListener
public class MaxPrincipal implements HttpSessionAttributeListener {
	
	public static final String PRINCIPAL = "principal";
	public static final String MAX_PRINCIPAL = "maxPrincipal";
	
	private static double maxPrincipal;
	
    /**
     * Default constructor. 
     */
    public MaxPrincipal() {
        // TODO Auto-generated constructor stub
    		System.out.println("MaxPrincipal constructor called!");
    		maxPrincipal = 0.0;
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  {
    		//if the attribute added is principal we set initial max to the value entered
    		System.out.println("attribute added: " + arg0.getName() + ": " + arg0.getValue());
    		
    		updateMaxPrincipal(arg0);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // not a concern right now
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    		//System.out.println("Attribute replaced: " + arg0.getName());
    		
    		updateMaxPrincipal(arg0);
    }
    
    /**
     * updates the maximum principal if it is larger than the current maximum
     */
    public void updateMaxPrincipal(HttpSessionBindingEvent arg0) {
    		if (arg0.getName().equals(PRINCIPAL)) { 

			double newValue = Double.parseDouble(arg0.getValue().toString());
			
			if (newValue > maxPrincipal) {		//replace max with new value if it is greater
				maxPrincipal = newValue;
			}
		}
    }
    
    public static double getMax() {
    		return maxPrincipal;
    }
	
}
