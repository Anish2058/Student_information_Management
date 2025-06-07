
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Student_Database {
    private final String url = "jdbc:sqlite:students.db";

    public Student_Database(){
        CreateTable();
    }

    private Connection connect() throws SQLException{
        return DriverManager.getConnection(url);
    }

    private void CreateTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS students (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                age INTEGER NOT NULL
                );
                """;
        try (Connection connection = connect(); Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Create Table Error: " + e.getMessage());
        }
    }

    public void addStudent(Student s){
        String sql = "INSERT INTO students(name, age) VALUES(?, ?)";
        try (Connection connection=connect(); PreparedStatement pstmt=connection.prepareStatement(sql)){
            pstmt.setString(1,s.getName());
            pstmt.setInt(2,s.getAge());
            pstmt.executeUpdate();
            System.out.println("Student added : ");
        }catch (SQLException e){
            System.out.println("Add Error : " +e.getMessage());
        }
    }

    public List<Student>getAllStudents(){
        List<Student> list = new ArrayList<>();
        String sql="SELECT * FROM students";
        try(Connection connection=connect();Statement stmt = connection.createStatement();ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                list.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age")));
            }
        }catch (SQLException e){
            System.out.println("Fetch Error: " + e.getMessage());
        }
        return list;
    }

    public void updateStudent(Student s){
        String sql = "UPDATE students SET name= ?, age = ? WHERE id = ?";
        try(Connection connection=connect();PreparedStatement pstmt=connection.prepareStatement(sql)){
            pstmt.setString(1,s.getName());
            pstmt.setInt(2, s.getAge());
            pstmt.setInt(3,s.getId());
            pstmt.executeUpdate();
            System.out.println("Student Updated.");
        }catch (SQLException e){
            System.out.println("Update Error : "+e.getMessage());
        }
    }

    public void deleteStudent(int id){
        String sql ="DELETE FROM students WHERE id = ?";
        try(Connection connection=connect();PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            System.out.println("Student Deleted. ");
        }catch (SQLException e){
            System.out.println("Delete Error :" + e.getMessage());
        }
    }
}
