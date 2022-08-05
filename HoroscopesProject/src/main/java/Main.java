import com.models.HoroscopeUser;
import com.persistence.HoroscopeUserDAO;
import com.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args){
//        USED TO TEST  connection
//        try {
//            Connection connection = ConnectionManager.connect();
//            System.out.println(connection.getSchema());
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        }

//        USED TO TEST HoroscopeUserDAO create() method
//        HoroscopeUserDAO horoscopeUserDAO = new HoroscopeUserDAO();
//        HoroscopeUser Eric = new HoroscopeUser("Eric","Curiel","curieleric@gmail.com","curieleric","ericpassword","capricorn","");
//        Integer EricHoroscopeId = horoscopeUserDAO.create(Eric);

//        USED TO TEST  HoroscopeUserDAO read() method
//        HoroscopeUserDAO horoscopeUserDAO = new HoroscopeUserDAO();
//        HoroscopeUser horoscopeUser = horoscopeUserDAO.read(1);
//        System.out.println(horoscopeUser.getFirst_name());






    }
}
