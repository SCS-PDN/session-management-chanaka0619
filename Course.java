public class Course {
    private String courseId;
    private String courseName;
    private String instructor;
    
    public Course(String courseId, String courseName, String instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
    }
    
    public String getId() {
        return courseId;
    }
    
    public void setId(String courseId) {
        this.courseId = courseId;
    }
    
    public String getName() {
        return courseName;
    }
    
    public void setName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getInstructor() {
        return instructor;
    }
    
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return courseId.equals(course.courseId);
    }
}