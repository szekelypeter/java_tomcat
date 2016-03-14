import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        request.getRequestDispatcher("link.html").include(request, response);  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password"); 
        HttpSession session = request.getSession();
		
		if(!name.equals(session.getAttribute("name"))){
          
        if(password.equals("admin123")){  
        out.print("Welcome, "+name);    
        session.setAttribute("name",name);  
        }  
        else{  
            out.print("Sorry, username or password error!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  }
		else {
			out.print("<center>");
			out.print("<h2>You already logged in!</h2>");
			out.print("</center>");
		}
        out.close();  
    }  
}  