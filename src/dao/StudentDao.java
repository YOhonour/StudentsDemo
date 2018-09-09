package dao;

import bean.Student;
import util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public int getTotal() {

        int total = 0;

        String sql = "SELECT COUNT(*) FROM student";
        try (Connection c = DBUtil.getConnection(); Statement st = c.createStatement()) {

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    public void add(Student student) {

        String sql = "INSERT INTO student(`id`, `name`, `sex`, `age`, `number`, `major`)  VALUES(NULL,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getSex());
            ps.setInt(3, student.getAge());
            ps.setInt(4,student.getStudentNumber());
            ps.setInt(5,student.getMajor());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        String sql = "DELETE FROM `student` WHERE `student`.`number` = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {

        /*
        UPDATE `student` SET `name` = '王五2', `sex` = '22', `age` = '152', `number` = '22222222', `major` = '1' WHERE `student`.`id` = 2;
         */
        String sql = "UPDATE `student` SET `name` = ?, `sex` = ?, `age` = ?, `major` = ? WHERE `student`.`number` = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getSex());
            ps.setInt(3, student.getAge());
            ps.setInt(4,student.getMajor() );
            ps.setInt(5, student.getStudentNumber());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student get(int studentNumber) {
//    public List<Student> get(int studentNumber) {

//        List<Student> students = new ArrayList<>();

        Student student = new Student();

        String sql = "SELECT * FROM `student` WHERE `student`.`number` = " + studentNumber;
        try (Connection c = DBUtil.getConnection(); Statement st = c.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                int sqlid = rs.getInt("id");
                String name  = rs.getString("name");
                int sex = rs.getInt("sex");
                int age = rs.getInt("age");
//                int studentNumber = rs.getInt("number");
                int major = rs.getInt("major");

                student.setId(sqlid);
                student.setName(name);
                student.setSex(sex);
                student.setAge(age);
                student.setStudentNumber(studentNumber);
                student.setMajor(major);

//                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public Student get(String name) {
//    public List<Student>  get(String name) {

//        List<Student> students = new ArrayList<>();

        Student student = new Student();

        String sql = "SELECT * FROM `student` WHERE `student`.`name` = " +"'" +name + "'";
        try (Connection c = DBUtil.getConnection(); Statement st = c.createStatement()){

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                int sqlid = rs.getInt("id");
//                String name  = rs.getString("name");
                int sex = rs.getInt("sex");
                int age = rs.getInt("age");
                int studentNumber = rs.getInt("number");
                int major = rs.getInt("major");

                student.setId(sqlid);
                student.setName(name);
                student.setSex(sex);
                student.setAge(age);
                student.setStudentNumber(studentNumber);
                student.setMajor(major);

//                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;

    }

    public List<Student> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Student> list(int start, int count) {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM `student` ORDER BY `id` desc limit ?,?";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                int id = rs.getInt("id");
                String name  = rs.getString("name");
                int sex = rs.getInt("sex");
                int age = rs.getInt("age");
                int studentNumber = rs.getInt("number");
                int major = rs.getInt("major");
                student.setId(id);
                student.setName(name);
                student.setSex(sex);
                student.setAge(age);
                student.setStudentNumber(studentNumber);
                student.setMajor(major);

                students.add(student);
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

}
