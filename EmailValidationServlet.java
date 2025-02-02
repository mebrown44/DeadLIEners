import javax.servlet.*;
import com.google.gson.JsonObject;

@WebServlet("/validateEmail")
public class EmailValidationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        Email emailValidator = new Email(email);
        boolean isValid = emailValidator.validEmail(email);

        JsonObject json = new JsonObject();
        json.addProperty("valid", isValid);
        
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    }
}
