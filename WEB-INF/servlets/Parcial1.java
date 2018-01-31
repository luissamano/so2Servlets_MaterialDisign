import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Parcial1 extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			try
			{
				FileWriter fw = new FileWriter("Parcial1.txt", true);
				PrintWriter ArchivoTutorias = new PrintWriter(fw);
				
				
				//String turno;
    			//turno=req.getParameter("TURNO");
    			String a,b,c,d,e,f,g,h,i,j;
    			a=req.getParameter("clave");
    			b=req.getParameter("horasl");
    			c=req.getParameter("nombre");
    			d=req.getParameter("horasp");
   				e=req.getParameter("appp");
   				f=req.getParameter("appm");
   				g=req.getParameter("depto");
   				h=req.getParameter("horase");
   				i=req.getParameter("sueldos");
   				j=req.getParameter("sueldon");
   				
				
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
                out.println("<center><h2> Parcial 1 </h2></center>");
                out.println("<title>Respuesta a la solicitud</title>");
                out.println("<font color =BLACK>");
                out.println("<br><br><center><table border=5 CELLSPACING=6 CELLPADDING=8");
                out.println("<TR><TD><B><font color =RED>Clave:</b></TD>");
                out.println ("<td><font color =lightblue>" + req.getParameter("clave") + "</td></tr>");
                out.println("<TR><TD><B><font color =RED>Nombre:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("nombre")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Ap. paterno:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("appp")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Ap. materno:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("appm")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Depto:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("depto")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Horas tarbajadas:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("horasl")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Pago x hora:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("horasp")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Horas extras:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("horase")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Sueldo semanal:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("sueldos")+"</td></tr>");
                out.println("<TR><TD><B><font color =RED>Sueldo neto:</b></td>");
                out.println("<td><font color =lightblue>" + req.getParameter("sueldos")+"</td></tr>");
                
                
                
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