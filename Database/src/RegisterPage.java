import javax.swing.*;

public class RegisterPage extends JPanel {
    public MainFrame parent;

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    private JTextField textName;
    private JTextField textSurname;
    private JTextField textUsername;
    private JTextField textPassword;

    private JButton registerBtn;
    private JButton backBtn;


    public RegisterPage(MainFrame mainFrame) {
        this.parent = mainFrame;
        setSize(500, 600);
        setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100,50,300,30);
        add(nameLabel);

        textName = new JTextField();
        textName.setBounds(100,80,300,30);
        add(textName);

        //------------------------------------------------------------------------dollar

        surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(100,110,300,30);
        add(surnameLabel);

        textSurname = new JTextField();
        textSurname.setBounds(100,140,300,30);
        add(textSurname);
        //------------------------------------------------------------------------tenge

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(100,170,300,30);
        add(usernameLabel);

        textUsername = new JTextField();
        textUsername.setBounds(100,200,300,30);
        add(textUsername);

        //------------------------------------------------------------------------tenge

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100,230,300,30);
        add(passwordLabel);

        textPassword = new JTextField();
        textPassword.setBounds(100,260,300,30);
        add(textPassword);

        //------------------------------------------------------------------------
        backBtn = new JButton("Back");
        backBtn.setBounds(65,520,100,30);
        add(backBtn);

        backBtn.addActionListener(e -> {
            parent.getAddProductPage().setVisible(false);
            parent.getMainMenu().setVisible(true);
        });

        registerBtn = new JButton("Register");
        registerBtn.setBounds(330,520,100,30);
        add(registerBtn);

        registerBtn.addActionListener(e -> {
            String nameField = textName.getText();
            String surnameField = textSurname.getText();
            String usernameField = textUsername.getText();
            String passwordField = textPassword.getText();
            User user = new User(null,nameField,surnameField,usernameField,passwordField);
            parent.dbManager().register(user);
            parent.getRegisterPage().setVisible(false);
            parent.getIntroPage().setVisible(true);
        });

    }
}
