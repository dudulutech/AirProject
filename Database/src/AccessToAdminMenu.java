import javax.swing.*;

public class AccessToAdminMenu extends JPanel {
    public MainFrame parent;

    private JLabel toAddressLabel;
    private JTextField textToAddress;
    private JButton goBtn;

    public AccessToAdminMenu(MainFrame mainFrame){

        this.parent = mainFrame;

        setSize(500,600);

        setLayout(null);


        toAddressLabel = new JLabel("Password:");
        toAddressLabel.setBounds(100,110,300,30);
        add(toAddressLabel);

        textToAddress = new JTextField();
        textToAddress.setBounds(100,140,300,30);
        add(textToAddress);

        goBtn = new JButton("Check");
        goBtn.setBounds(100,200,300,30);
        goBtn.addActionListener(e -> {
            String toAddress = textToAddress.getText();
            if(toAddress.equals("asd")){
                textToAddress.setText("");
                parent.getAdminMenu().setVisible(true);
                parent.getAccessToAdminMenu().setVisible(false);
            }else {
                textToAddress.setText("");
                parent.getAccessToAdminMenu().setVisible(false);
                parent.getMainMenu().setVisible(true);
            }
        });
        add(goBtn);


    }
}
