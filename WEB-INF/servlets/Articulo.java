import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Articulo extends HttpServlet
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			try
			{
				FileWriter fw = new FileWriter("Articulo.txt", true);
				PrintWriter ArchivoTutorias = new PrintWriter(fw);
				
				Enumeration nombresParams = request.getParameterNames();
				while(nombresParams.hasMoreElements())
				{
					String param = (String) nombresParams.nextElement();
					String valor = request.getParameter(param);
					ArchivoTutorias.println(param + ": " + valor);
				}
				
				ArchivoTutorias.println("<FIN>");
				fw.close();
				
				out.println("<html>");
				out.println("<title>Articulo registrado correctamente</title>");
				out.println("<br> Verifiquelo !!!");
				out.println("</html>");
				
			}
			
			catch(IOException e)
			{
				out.println("Hubo problemas atendiendo su solicitud. " + "<br>Por Favor, Intentelo nuevamente.");
			}
			
			out.close();
		}
}


//Nota. Al compilar este archivo es necesario agregar el archivo servlet.jar almacenado en la carpeta C:\servidor\lib
//mediante la siguiente opcion: Configure - Options - JDK Profiles - Seleccionar la version del jdk y presionar
// el boton Edit - presionar el boton Add - y seleccionar Add file, buscar el servlet.jar, aceptar, aplicar y compilar.
// de tal forma que se genera el .class
// copiar el .class en C:\servidor\webpages\WEB-INF\servlets