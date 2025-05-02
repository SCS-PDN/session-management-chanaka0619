import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Course;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("101", "Mathematics", "Dr. Smith"));
        courseList.add(new Course("102", "Computer Science", "Prof. Adams"));
        courseList.add(new Course("103", "Physics", "Dr. Johnson"));

        request.setAttribute("courses", courseList);

        List<Course> enrolledCourses = (List<Course>) session.getAttribute("enrolledCourses");
        if (enrolledCourses == null) {
            enrolledCourses = new ArrayList<>();
        }
        request.setAttribute("enrolledCourses", enrolledCourses);

        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
    }
}