import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                "roll_no INTEGER PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "age INTEGER," +
                "course TEXT)";
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addStudent(Student student) {
        String sql = "INSERT INTO students(roll_no, name, age, course) VALUES(?,?,?,?)";
        try (Connection conn = DBConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, student.getRollNo());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getCourse());
            pstmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("roll_no"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // Add more methods: updateStudent(), deleteStudent(), getStudentByRollNo()
    public void updateStudent(Student student) {
    String sql = "UPDATE students SET name = ?, age = ?, course = ? WHERE roll_no = ?";
    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, student.getName());
        pstmt.setInt(2, student.getAge());
        pstmt.setString(3, student.getCourse());
        pstmt.setInt(4, student.getRollNo());
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
public void deleteStudent(int rollNo) {
    String sql = "DELETE FROM students WHERE roll_no = ?";
    try (Connection conn = DBConnection.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, rollNo);
        int rows = pstmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

}
