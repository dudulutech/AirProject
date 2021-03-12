import javax.swing.*;

public class LoginPage extends JPanel {
    private MainFrame parent;
    private JLabel usernameLabel;
    private JLabel alertLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginBtn;
    boolean alert = false;

    public LoginPage(MainFrame mainFrame){
        this.parent = mainFrame;
        setSize(500,600);
        setLayout(null);

        if(alert){
            alertLabel = new JLabel("INCORRECT DATA!");
            alertLabel.setBounds(100,10,300,30);
            add(alertLabel);
        }

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(100,50,300,30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100,80,300,30);
        add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100,110,300,30);
        add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setBounds(100,140,300,30);
        add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(330,520,100,30);
        add(loginBtn);

        loginBtn.addActionListener(e->{
            String username = usernameField.getText();
            String password = passwordField.getText();
            boolean logged = parent.login(username, password);
            if(logged){
                parent.getMainMenu().setVisible(true);
                parent.getLoginPage().setVisible(false);
                alert = false;
            }else {
                alert=true;
                alertLabel = new JLabel("INCORRECT DATA!");
                alertLabel.setBounds(100,10,300,30);
                add(alertLabel);
            }
        });
    }
}
