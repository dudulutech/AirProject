import javax.swing.*;

public class IntroPage extends JPanel {
    public MainFrame parent;

    private JButton register;
    private JButton login;

    public IntroPage(MainFrame mainFrame){

        this.parent = mainFrame;

        setSize(500,600);

        setLayout(null);


        register = new JButton("Login");
        register.setBounds(100,200,300,30);
        register.addActionListener(e -> {
            parent.getLoginPage().setVisible(true);
            parent.getIntroPage().setVisible(false);
        });
        add(register);

        login = new JButton("Register");
        login.setBounds(100,300,300,30);
        login.addActionListener(e -> {
            parent.getRegisterPage().setVisible(true);
            parent.getIntroPage().setVisible(false);
        });
        add(login);


    }
}
