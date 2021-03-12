import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListOfUsersPage extends JPanel {
    private MainFrame parent;

    private JTable table;
    private JScrollPane scrollPane;
    private String[] header = {"ID","Name","Surname","Group","GPA"};

    private ArrayList<User> users = new ArrayList<>();

    public ListOfUsersPage(MainFrame parent){
        this.parent = parent;
        this.users = parent.getAllUsers();


        setSize(500,600);
        setLayout(null);

        table = new JTable();
        table.setFont(new Font("Montserrat", Font.PLAIN,12));
        table.setRowHeight(50);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(440,500);
        scrollPane.setLocation(20,0);
        add(scrollPane);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(65,520,100,30);
        add(backBtn);

        backBtn.addActionListener(e -> {
            parent.getListOfUsersPage().setVisible(false);
            parent.getMainMenu().setVisible(true);
        });
    }
    public void generateTable(){
        this.users = parent.getAllUsers();
        Object[][] data = new Object[users.size()][5];

        for(int i =0;i<users.size();i++){
            data[i][0] = users.get(i).getId();
            data[i][1] = users.get(i).getName();
            data[i][2] = users.get(i).getSurname();
            data[i][3] = users.get(i).getUsername();
            data[i][4] = users.get(i).getTickets().getId();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);

    }
}
