
package jdbc.project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCProject {

    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudDB", "root", "");
            
            if (con != null) {
                System.out.println("Successfully connected!!!");
            } else {
                System.out.println("Connection failed!!!");
            }
            
            Statement stmt = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            int choice;
            
            do {
                System.out.println("***** WELCOME TO JDBC JAVA PROGRAMMING ******");
                System.out.println("Menu:");
                System.out.println("1. Insert into database");
                System.out.println("2. Update database");
                System.out.println("3. Search database");
                System.out.println("4. Delete from database");
                System.out.println("5. Display all records");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        insertRecord(stmt, scanner);
                        break;
                    case 2:
                        updateRecord(stmt, scanner);
                        break;
                    case 3:
                        searchRecord(stmt, scanner);
                        break;
                    case 4:
                        deleteRecord(stmt, scanner);
                        break;
                    case 5:
                        displayAllRecords(stmt);
                        break;
                    case 6:
                        System.out.println("Exiting the system...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                
                System.out.println();
            } while (choice != 6);
            
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Missing!");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public static void insertRecord(Statement stmt, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student name: ");
        String name = scanner.next();
        
        String query = "INSERT INTO Student VALUES (" + id + ", '" + name + "')";
        stmt.execute(query);
        
        System.out.println("Record inserted successfully");
    }
    
    public static void updateRecord(Statement stmt, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter new student name: ");
        String name = scanner.next();
        
        String query = "UPDATE Student SET Name = '" + name + "' WHERE Id = " + id;
        stmt.executeUpdate(query);
        
        System.out.println("Record updated successfully");
    }
    
    public static void searchRecord(Statement stmt, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        
        String query = "SELECT * FROM Student WHERE Id = " + id;
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.next()) {
            System.out.println("Record found:");
            System.out.println("ID: " + rs.getInt("Id"));
            System.out.println("Name: " + rs.getString("Name"));
        } else {
            System.out.println("Record not found");
        }
    }
    
    public static void deleteRecord(Statement stmt, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        
        String query = "DELETE FROM Student WHERE Id = " + id;
        int rowsAffected = stmt.executeUpdate(query);
        
        if (rowsAffected > 0) {
            System.out.println("Record deleted successfully");
        } else {
            System.out.println("Record not found");
        }
    }
    
    public static void displayAllRecords(Statement stmt) throws SQLException {
        String query = "SELECT * FROM Student";
        ResultSet rs = stmt.executeQuery(query);
        
        System.out.println("All records:");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("Id"));
            System.out.println("Name: " + rs.getString("Name"));
            System.out.println();
        }
        
    }
    
}
