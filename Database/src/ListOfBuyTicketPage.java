import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListOfBuyTicketPage extends JPanel {
    private MainFrame parent;

    private JTable table;
    private JScrollPane scrollPane;
    private String[] header = {"ID","FROM","TO","GO","ARRIVE"};

    private ArrayList<Tickets> tickets = new ArrayList<>();

    public ListOfBuyTicketPage(MainFrame parent){
        this.parent = parent;
        this.tickets = parent.getAllTicket();


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
            parent.getListOfBuyTicketPage().setVisible(false);
            parent.getMainMenu().setVisible(true);
        });
        JButton buyBtn = new JButton("Buy");
        buyBtn.setBounds(205, 520, 100 ,30);
        add(buyBtn);
        buyBtn.addActionListener(e -> {
            int selectedRowIndex= table.getSelectedRow();

            Long id = (Long) model.getValueAt(selectedRowIndex,0);
            Tickets ticket = parent.getTicketById(id);
            parent.dbManager().updateMyTicket(ticket,parent.getCurrentUser());
            parent.login(parent.getCurrentUser().getUsername(),parent.getCurrentUser().getPassword());
        });
    }
    DefaultTableModel model;
    public void generateTable(){
        this.tickets = parent.getAllTicket();
        Object[][] data = new Object[tickets.size()][5];

        for(int i =0;i<tickets.size();i++){
            data[i][0] = tickets.get(i).getId();
            data[i][1] = tickets.get(i).getFromAddress();
            data[i][2] = tickets.get(i).getToAddress();
            data[i][3] = tickets.get(i).getGoDate();
            data[i][4] = tickets.get(i).getArriveDate();
        }

        model = new DefaultTableModel(data, header);
        table.setModel(model);

    }
}
