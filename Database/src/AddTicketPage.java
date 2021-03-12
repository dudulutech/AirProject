
import javax.swing.*;
import java.util.Calendar;

public class AddTicketPage extends JPanel {
    public MainFrame parent;
    
    private JLabel fromAddressLabel;
    private JLabel toAddressLabel;
    private JLabel goDateLabel;
    private JLabel arriveDateLabel;

    private JTextField textFromAddress;
    private JTextField textToAddress;
    private JTextField textGoDate;
    private JTextField textArriveDate;

    private JButton addBtn;
    private JButton backBtn;

    // public ArrayList<Product> products = new ArrayList<>();



    public AddTicketPage(MainFrame parent){
        this.parent = parent;

        setSize(500,600);
        setLayout(null);
        //------------------------------------------------------------------------name
        fromAddressLabel = new JLabel("To Address:");
        fromAddressLabel.setBounds(100,50,300,30);
        add(fromAddressLabel);

        textFromAddress = new JTextField();
        textFromAddress.setBounds(100,80,300,30);
        add(textFromAddress);

        //------------------------------------------------------------------------dollar

        toAddressLabel = new JLabel("From Address:");
        toAddressLabel.setBounds(100,110,300,30);
        add(toAddressLabel);

        textToAddress = new JTextField();
        textToAddress.setBounds(100,140,300,30);
        add(textToAddress);
        //------------------------------------------------------------------------tenge

        goDateLabel = new JLabel("Go Date:");
        goDateLabel.setBounds(100,170,300,30);
        add(goDateLabel);

        textGoDate = new JTextField();
        textGoDate.setBounds(100,200,300,30);
        add(textGoDate);

        //------------------------------------------------------------------------tenge

        arriveDateLabel = new JLabel("Arrive Date:");
        arriveDateLabel.setBounds(100,230,300,30);
        add(arriveDateLabel);

        textArriveDate = new JTextField();
        textArriveDate.setBounds(100,260,300,30);
        add(textArriveDate);

        //------------------------------------------------------------------------
        backBtn = new JButton("Back");
        backBtn.setBounds(65,520,100,30);
        add(backBtn);

        backBtn.addActionListener(e -> {
            parent.getAddTicketPage().setVisible(false);
            parent.getAdminMenu().setVisible(true);
        });

        addBtn = new JButton("Add");
        addBtn.setBounds(330,520,100,30);
        add(addBtn);

        addBtn.addActionListener(e->{
            String formAddress = textFromAddress.getText();
            String toAddress = textToAddress.getText();
            String goDate = textGoDate.getText();
            String  arriveDate = textArriveDate.getText();
            Tickets ticket = new Tickets(null,formAddress,toAddress,goDate,arriveDate);
            parent.dbManager().addTicket(ticket);
            parent.getAddTicketPage().setVisible(false);
            parent.getAdminMenu().setVisible(true);

        });
    }




}
