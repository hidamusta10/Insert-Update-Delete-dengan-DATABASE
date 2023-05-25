import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLInsertTableDemo {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mahasiswa";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        try {
            insertTable();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insertTable() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        int count = 0;

        String insertTableSQL = "INSERT INTO MAHASISWA"
                + "(id_mhs, nama_mhs, nim, prodi) " + "VALUES"
                + "(null,'Dimas EKa','140022','Teknik Informatika', "+")";

        try {
            // dapatkan database connection
            connection = getDatabaseConnection();

            // membuat object connection
            statement = connection.createStatement();

            System.out.println(insertTableSQL);

            // eksekusi insert SQL stetement
            statement.executeUpdate(insertTableSQL);

            // mendapat total record yang telah di-insert
            count = statement.getUpdateCount();

            System.out.println(count +" Record telah berhasil di masukkan ke tabel PROFIL");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }

        }
    }

    public static Connection getDatabaseConnection() {
        Connection connection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return connection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return connection;
    }
}