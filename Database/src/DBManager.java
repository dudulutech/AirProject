import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    Connection connection;

    public DBManager() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/air", "postgres", "25399" );

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public User login(String username, String password){

        ArrayList<User> users = getAllUsers();
        for(User u: users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    public Tickets getTicketById(Long id){
        Tickets ticket = null;
        ArrayList<Tickets> tickets = getAllTickets();
        for(Tickets t:tickets){
            if(t.getId().equals(id)){
                ticket = t;
                return ticket;
            }
        }
        return null;
    }

    public void updateMyTicket(Tickets tickets, User currentUser){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET ticket_id =? WHERE id =?");
            ps.setLong(1, tickets.getId());
            ps.setLong(2, currentUser.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addTicket(Tickets ticket){

        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO tickets (id,fromAddress,toAddress,goDate,arriveDate)" +
                    "VALUES(NULL,?,?,?,?)");

            statement.setString(1,ticket.getFromAddress());
            statement.setString(2,ticket.getToAddress());
            statement.setString(3,ticket.getGoDate());
            statement.setString(4,ticket.getArriveDate());
            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }


    public boolean register(User user){

        int rows = 0;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (id,name,surname,username,password,ticket_id)" +
                    "VALUES(NULL,?,?,?,?,NULL)");

            statement.setString(1,user.getName());
            statement.setString(2,user.getSurname());
            statement.setString(3,user.getUsername());
            statement.setString(4,user.getPassword());
            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public ArrayList<User> getAllUsers(){

        ArrayList<User> users = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT id, name, surname, username, password, ticket_id FROM users");

            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()){

                ArrayList<Tickets> tickets = getAllTickets();
                Tickets ticket = null;
                for(Tickets t:tickets){
                    if(t.getId()==resultSet.getLong("ticket_id")){
                        ticket = t;
                        break;
                    }
                }
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        ticket
                ));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public ArrayList<Tickets> getAllTickets(){
        ArrayList<Tickets> tickets = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT id, fromAddress, toAddress, goDate, arriveDate FROM tickets");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                tickets.add(new Tickets(
                        resultSet.getLong("id"),
                        resultSet.getString("fromAddress"),
                        resultSet.getString("toAddress"),
                        resultSet.getString("goDate"),
                        resultSet.getString("arriveDate")
                ));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return tickets;
    }

}
