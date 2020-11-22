import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Servlet1")
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
PrintWriter out=response.getWriter();
 request.getRequestDispatcher("link.html").include(request, response);

 String uname=request.getParameter("username");
 String password=request.getParameter("password");

 if(password.equals("web")){
 out.print("<h1 >You are successfully logged in!</h1>");
 out.print("<br> Welcome , "+uname);

 Cookie ck=new Cookie("name",uname);
 response.addCookie(ck);
 }
 else{
 out.print("<h2 > Invalid username or password!</h2>");
 request.getRequestDispatcher("login.html").include(request, response);
 }
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
}
