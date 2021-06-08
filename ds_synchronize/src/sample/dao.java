package sample;


import java.sql.*;
import java.util.*;

public class dao<name> {

    public static ArrayList<student> getStudent(String name) {
        ArrayList<student> studentTable = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/"+ name;
            Connection con = DriverManager.getConnection(url, "root", "ngan");

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from student1");

            while (rs.next()) {
                studentTable.add(new student(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return studentTable;
    }
    public static void insertStudent(String name, ArrayList<student> studentTable) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/"+name;
            Connection con = DriverManager.getConnection(url, "root", "ngan");
            Statement statement = con.createStatement();
            for (student s:studentTable) {
                statement.executeUpdate("insert into student1 values ("+ s.getId() +", \""+ s.getName() +"\", "+s.getGrade()+");");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


}
