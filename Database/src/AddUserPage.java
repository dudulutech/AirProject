
import javax.swing.*;

public class AddUserPage extends JPanel {
    public MainFrame parent;

    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel groupLabel;
    private JLabel gpaLabel;

    private JTextField textName;
    private JTextField textSurname;
    private JTextField textGroup;
    private JTextField textGpa;

    private JButton addBtn;
    private JButton backBtn;

    // public ArrayList<Product> products = new ArrayList<>();



    public AddUserPage(MainFrame parent){
        this.parent = parent;

        setSize(500,600);
        setLayout(null);
        //------------------------------------------------------------------------name
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

        groupLabel = new JLabel("Group:");
        groupLabel.setBounds(100,170,300,30);
        add(groupLabel);

        textGroup = new JTextField();
        textGroup.setBounds(100,200,300,30);
        add(textGroup);

        //------------------------------------------------------------------------tenge

        gpaLabel = new JLabel("GPA:");
        gpaLabel.setBounds(100,230,300,30);
        add(gpaLabel);

        textGpa = new JTextField();
        textGpa.setBounds(100,260,300,30);
        add(textGpa);

        //------------------------------------------------------------------------
        backBtn = new JButton("Back");
        backBtn.setBounds(65,520,100,30);
        add(backBtn);

        backBtn.addActionListener(e -> {
            parent.getAddProductPage().setVisible(false);
            parent.getMainMenu().setVisible(true);
        });

        addBtn = new JButton("Add");
        addBtn.setBounds(330,520,100,30);
        add(addBtn);

        addBtn.addActionListener(e->{
            String nameField = textName.getText();
            String surnameField = textSurname.getText();
            String groupField = textGroup.getText();
            double gpaField = Double.parseDouble(textGpa.getText());

            parent.getAddProductPage().setVisible(false);
            parent.getMainMenu().setVisible(true);

        });
    }




}
