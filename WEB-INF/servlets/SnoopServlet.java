import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;




public class SnoopServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
	ServletConfig config = getServletConfig();
        ServletOutputStream out = response.getOutputStream();
        out.println("Snoop Servlet");
	out.println();
	out.println("Init Parameters");
	Enumeration e = config.getInitParameterNames();
	while (e.hasMoreElements()) {
	    String key = (String)e.nextElement();
	    String value = config.getInitParameter(key);
	    out.println("   " + key + " = " + value);
	}
	out.println();
	out.println("Context attributes:");
	ServletContext context = config.getServletContext();
	Enumeration attributs = context.getAttributeNames();
	while (attributs.hasMoreElements()) {
	    String key = (String)attributs.nextElement();
            Object value = context.getAttribute(key);
            out.println("   " + key + " = " + value);
	}
	out.println();

	out.println("javax.servlet.Servlet methods");
        out.println();
        out.println("Attribute names in this request:");
        e = request.getAttributeNames();
        while (e.hasMoreElements()) {
            String key = (String)e.nextElement();
            Object value = request.getAttribute(key);
            out.println("   " + key + " = " + value);
        }
        out.println();
        out.println("Protocol: " + request.getProtocol());
        out.println("Scheme: " + request.getScheme());
        out.println("Server Name: " + request.getServerName());
        out.println("Server Port: " + request.getServerPort());
        out.println("Server Info: " + getServletConfig().getServletContext().getServerInfo());
        out.println("Remote Addr: " + request.getRemoteAddr());
        out.println("Remote Host: " + request.getRemoteHost());
        out.println("Character Encoding: " + request.getCharacterEncoding());
        out.println("Content Length: " + request.getContentLength());
        out.println("Content Type: "+ request.getContentType());
        out.println("RequestURL: " + HttpUtils.getRequestURL(request).toString());
        out.println();
        out.println("Parameter names in this request");
        e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String key = (String)e.nextElement();
            String[] values = request.getParameterValues(key);
            out.print("   " + key + " = ");
            for(int i = 0; i < values.length; i++) {
                out.print(values[i] + " ");
            }
            out.println();
        }
        out.println();
        out.println("javax.servlet.http.HttpServletRequest methods");
        out.println();
        out.println("Headers in this request");
        e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String key = (String)e.nextElement();
            String value = request.getHeader(key);
            out.println("   " + key + " : " + value);
        }
        out.println();
        out.println("Cookies in this request");
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            out.println("   " + cookie.getName() + " = " + cookie.getValue());
        }
        out.println();

        out.println("Auth Type: " + request.getAuthType());
        out.println("HTTP Method: " + request.getMethod());
        out.println("Path Info: " + request.getPathInfo());
	out.println("Path Trans: " + request.getPathTranslated());
        out.println("Query String: " + request.getQueryString());
        out.println("Remote User: " + request.getRemoteUser());
        out.println("Session Id: " + request.getRequestedSessionId());
        out.println("Request URI: " + request.getRequestURI());
        out.println("Servlet Path: " + request.getServletPath());

        out.println();

        out.println("Session Information");
        HttpSession session = request.getSession(true);
	out.println("Created: " + session.getCreationTime());
        out.println("ID: " + session.getId());
        out.println("Last Accessed: " + session.getLastAccessedTime());
        out.println("Max Inactive Interval: " +
                    session.getMaxInactiveInterval());
        out.println();
        out.println("Values: ");
        String[] valueNames = session.getValueNames();
        for (int i = 0; i < valueNames.length; i++) {
            out.println("   " + valueNames[i] + " = " +
                        session.getValue(valueNames[i]));
        }
        out.println();
    }
}