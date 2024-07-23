package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection con;
    private static String user = "root";
    private static String password = "";

    public static Connection seConnecter()
    {
        if(con==null)
        {
            try
            {Class.forName("com.mysql.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bdstock", user, password);
                System.out.println("Connexion avec succès");
            }catch(ClassNotFoundException e)
            {
                System.out.println("Driver non trouvé "+e.getMessage());
            }catch(SQLException e)
            {
                System.out.println("base de données introuvable "+e.getMessage());
            }

        }
        return con;

    }

    public static void setUser(String user) {
        SingletonConnection.user = user;
    }

    public static void setPassword(String password) {
        SingletonConnection.password = password;
    }


}

