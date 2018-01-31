import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Tutoria extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			try
			{
				FileWriter fw = new FileWriter("Tutorias.txt", true);
				PrintWriter ArchivoTutorias = new PrintWriter(fw);
				
				
				//String turno;
    			//turno=req.getParameter("TURNO");
    			String a,b,c,d,e;
    			a=req.getParameter("alumno");
    			b=req.getParameter("profesor");
    			c=req.getParameter("dia");
    			d=req.getParameter("rb");
   				e=req.getParameter("asunto");
				
				Enumeration nombresParams = req.getParameterNames(); 
				while(nombresParams.hasMoreElements())
				{
					String param = (String) nombresParams.nextElement();
					String valor = req.getParameter(param);
					ArchivoTutorias.println(param + ": " + valor);
				}
				ArchivoTutorias.println("<FIN>");
       			ArchivoTutorias.close();
				fw.close();
				
								
                out.println("<html>");
                out.println("<center><h1> Universidad </h1></center>");
                out.println("<title>Respuesta a la solicitud</title>");
                out.println("<font color =YELLOW>");
                out.println("<br><br><center><table border=5 CELLSPACING=6 CELLPADDING=8");
                out.println("<TR><TD><B><font color =RED>Alumno:</b></TD>");
                out.println ("<td><font color =lightblue>" + req.getParameter("alumno") + "</td></tr>");
                out.println("<TR><TD><B><font color =RED>Profesor:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("profesor")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Dia:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("dia")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Hora:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("rb")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Asunto:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("asunto")+"</td></tr>");
                try {
    	            if(a.compareTo("on")==0)out.println("<font color =DarkBlue>Alumno<br>");}
    	        catch(java.lang.NullPointerException er){};  
                try {
    	            if(b.compareTo("on")==0)out.println("<font color =DarkBlue>Profesor<br>");}
    	        catch(java.lang.NullPointerException er){};  
                try {
    	            if(c.compareTo("on")==0)out.println("<font color =DarkBlue>Dia<br>");}
    	        catch(java.lang.NullPointerException er){};  
                try {
    	            if(d.compareTo("on")==0)out.println("<font color =DarkBlue>Hora<br>");}
    	        catch(java.lang.NullPointerException er){};  
                try {
    	            if(e.compareTo("on")==0)out.println("<font color =DarkBlue>Asunto<br></tr>");}
    	        catch(java.lang.NullPointerException er){};    
                
                out.println("</td></table>");
                out.println("</html>");
        }
        catch(IOException e)
        {
        out.println("Hubo problemas cursando su solicitud." +
                          "<BR>Por favor, inténtelo otra vez.");
        }
			out.close();
		}
}

//Nota. Al compilar este archivo es necesario agregar el archivo servlet.jar almacenado en la carpeta C:\servidor\lib
//mediante la siguiente opcion: Configure - Options - JDK Profiles - Seleccionar la version del jdk y presionar
// el boton Edit - presionar el boton Add - y seleccionar Add file, buscar el servlet.jar, aceptar, aplicar y compilar.
// de tal forma que se genera el .class
// copiar el .class en C:\servidor\webpages\WEB-INF\servlets