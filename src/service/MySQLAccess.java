package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/junit?"
                            + "user=root&password=&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from junit.PatientenTermin");
            writeResultSet(resultSet);

        } catch (Exception e) {
            throw new Exception("Keine Verbindung mit der Datenbank!\n\n");
        } finally {
            close();
        }

    }


    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
    	String termin = null;
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String patientVorname = resultSet.getString("patientVorname");
            String patientNachname = resultSet.getString("patientNachname");
            termin = resultSet.getString("termin");
            String arztNachname = resultSet.getString("arztNachname");
            System.out.printf("%s:  %s,  %s\t\tArzt: %s\n", termin, patientNachname,
					patientVorname, arztNachname);
            
            
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}