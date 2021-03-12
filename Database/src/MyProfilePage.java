import javax.swing.*;

public class MyProfilePage extends JPanel {
    public MainFrame parent;

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel ticketLabel;

    public MyProfilePage(MainFrame mainFrame){

        this.parent = mainFrame;
        setSize(500,600);
        setLayout(null);
        if(parent.getCurrentUser()!=null) {
            System.out.println("Name:"+parent.getCurrentUser().getName());
            nameLabel = new JLabel(parent.getCurrentUser().getName());
            nameLabel.setBounds(100, 100, 300, 30);
            add(nameLabel);

            surnameLabel = new JLabel("Surname:"+parent.getCurrentUser().getSurname());
            surnameLabel.setBounds(100, 150, 300, 30);
            add(surnameLabel);

            usernameLabel = new JLabel("Username:"+parent.getCurrentUser().getUsername());
            usernameLabel.setBounds(100, 200, 300, 30);
            add(usernameLabel);

            passwordLabel = new JLabel("Password:"+parent.getCurrentUser().getPassword());
            passwordLabel.setBounds(100, 250, 300, 30);
            add(passwordLabel);

            if(parent.getCurrentUser().getTickets()!=null) {

                ticketLabel = new JLabel("Ticket ID:" + parent.getCurrentUser().getTickets().getId() + ", " + parent.getCurrentUser().getTickets().getFromAddress() +
                        " - " + parent.getCurrentUser().getTickets().getToAddress());
                ticketLabel.setBounds(100, 300, 300, 30);
                add(ticketLabel);
            }
        }

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(65,520,100,30);
        add(backBtn);

        backBtn.addActionListener(e -> {
            parent.getMyProfilePage().setVisible(false);
            parent.getMainMenu().setVisible(true);
        });


    }
}
