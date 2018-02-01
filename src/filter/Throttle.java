package filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Throttle
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
			, urlPatterns = { "/Throttle", "/Start" })
public class Throttle implements Filter {
	
	private static final String TRY_AGAIN = "/TryAgain.jspx";

    /**
     * Default constructor. 
     */
    public Throttle() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		boolean enabled = false;
		HttpServletRequest req = (HttpServletRequest) request;
		
		long lastTime = req.getSession().getLastAccessedTime();
		long currTime = System.currentTimeMillis();
		
		long timeBetween = (currTime - lastTime);
		
		System.out.println("Time between requests: " + timeBetween);
		
		if (enabled) {
			if (timeBetween < 1000) {
				request.getRequestDispatcher(TRY_AGAIN).forward(request, response);
			}
			else {
				// pass the request along the filter chain
				chain.doFilter(request, response);	
			}
		}
		else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
