import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Course;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String courseId = request.getParameter("courseId");
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Course> allCourses = new ArrayList<>();
        allCourses.add(new Course("101", "Mathematics", "Dr. Smith"));
        allCourses.add(new Course("102", "Computer Science", "Prof. Adams"));
        allCourses.add(new Course("103", "Physics", "Dr. Johnson"));

        Course selectedCourse = null;
        for (Course c : allCourses) {
            if (c.getId().equals(courseId)) {
                selectedCourse = c;
                break;
            }
        }

        if (selectedCourse != null) {
            List<Course> enrolledCourses = (List<Course>) session.getAttribute("enrolledCourses");
            if (enrolledCourses == null) {
                enrolledCourses = new ArrayList<>();
            }
            if (!enrolledCourses.contains(selectedCourse)) {
                enrolledCourses.add(selectedCourse);
            }
            session.setAttribute("enrolledCourses", enrolledCourses);
        }

        response.sendRedirect("DashboardServlet");
    }
}