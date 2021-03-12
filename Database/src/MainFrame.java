import javax.swing.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private MainMenu mainMenu;
    private AddTicketPage addTicketPage;
    private ListOfTicketsPage listOfTicketsPage;
    private ListOfBuyTicketPage listOfBuyTicketPage;
    private AdminMenu adminMenu;
    private AccessToAdminMenu  accessToAdminMenu;
    private AddUserPage addProductPage;
    private ListOfUsersPage listOfUsersPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private IntroPage introPage;
    private MyProfilePage myProfilePage;
    private DBManager db = new DBManager();
    private User currentUser = null;


    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Flights Application");
        setSize(500,600);
        setLayout(null);

        introPage = new IntroPage(this);
        introPage.setVisible(true);
        add(introPage);

        loginPage = new LoginPage(this);
        loginPage.setVisible(false);
        add(loginPage);

        registerPage = new RegisterPage(this);
        registerPage.setVisible(false);
        add(registerPage);

        mainMenu = new MainMenu(this);
        mainMenu.setVisible(false);
        add(mainMenu);

        addProductPage = new AddUserPage(this);
        addProductPage.setVisible(false);
        add(addProductPage);

        addTicketPage = new AddTicketPage(this);
        addTicketPage.setVisible(false);
        add(addTicketPage);

        listOfUsersPage = new ListOfUsersPage(this);
        listOfUsersPage.setVisible(false);
        add(listOfUsersPage);

        adminMenu = new AdminMenu(this);
        adminMenu.setVisible(false);
        add(adminMenu);

        accessToAdminMenu = new AccessToAdminMenu(this);
        accessToAdminMenu.setVisible(false);
        add(accessToAdminMenu);

        listOfTicketsPage = new ListOfTicketsPage(this);
        listOfTicketsPage.setVisible(false);
        add(listOfTicketsPage);

        listOfBuyTicketPage = new ListOfBuyTicketPage(this);
        listOfBuyTicketPage.setVisible(false);
        add(listOfBuyTicketPage);



    }

    public boolean login(String username, String password){
        User loggedUser = db.login(username,password);
        if(loggedUser!=null){
            currentUser = loggedUser;
            myProfilePage = new MyProfilePage(this);
            myProfilePage.setVisible(false);
            add(myProfilePage);
            return true;
        }
        return false;
    }

    public Tickets getTicketById(Long id){
        return db.getTicketById(id);
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public MyProfilePage getMyProfilePage() {
        return myProfilePage;
    }

    public ListOfBuyTicketPage getListOfBuyTicketPage() {
        return listOfBuyTicketPage;
    }

    public RegisterPage getRegisterPage() {
        return registerPage;
    }

    public IntroPage getIntroPage() {
        return introPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<User> getAllUsers(){
        return db.getAllUsers();
    }
    public ArrayList<Tickets> getAllTicket(){
        return db.getAllTickets();
    }

    public DBManager dbManager(){
        return db;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    public AddUserPage getAddProductPage() {
        return addProductPage;
    }

    public AddTicketPage getAddTicketPage() {
        return addTicketPage;
    }

    public ListOfUsersPage getListOfUsersPage() {
        return listOfUsersPage;
    }

    public AdminMenu getAdminMenu() {
        return adminMenu;
    }

    public AccessToAdminMenu getAccessToAdminMenu() {
        return accessToAdminMenu;
    }

    public ListOfTicketsPage getListOfTicketsPage() {
        return listOfTicketsPage;
    }
}
