import javax.swing.*;

public class MainMenu extends JPanel {
    public MainFrame parent;


    public MainMenu(MainFrame mainFrame){
        this.parent = mainFrame;
        setSize(500,600);
        setLayout(null);

        JButton adminMenu = new JButton("Admin");
        adminMenu.setBounds(25,25,150,30);

        adminMenu.addActionListener(e -> {
            parent.getMainMenu().setVisible(false);
            parent.getAccessToAdminMenu().setVisible(true);
        });
        add(adminMenu);
        if(parent.getCurrentUser()!=null) {
            JLabel currentUser = new JLabel(parent.getCurrentUser().getName());
            currentUser.setBounds(150,25,150,30);
            add(currentUser);
        }


        JButton my_profile = new JButton("My profile");
        my_profile.setBounds(100,200,300,30);

        my_profile.addActionListener(e -> {
            parent.getMainMenu().setVisible(false);
            parent.getMyProfilePage().setVisible(true);
        });
        add(my_profile);


        JButton listButton = new JButton("Buy Ticket");
        listButton.setBounds(100,300,300,30);

        listButton.addActionListener(e -> {
            parent.getListOfBuyTicketPage().generateTable();
            parent.getMainMenu().setVisible(false);
            parent.getListOfBuyTicketPage().setVisible(true);
        });
        add(listButton);
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100,400,300,30);

        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);
    }
}
