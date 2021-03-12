import javax.swing.*;

public class AdminMenu extends JPanel {
    public MainFrame parent;


    public AdminMenu(MainFrame mainFrame){
        this.parent = mainFrame;
        setSize(500,600);
        setLayout(null);


        JButton addButton = new JButton("Add Ticket");
        addButton.setBounds(100,100,300,30);

        addButton.addActionListener(e -> {
            parent.getAdminMenu().setVisible(false);
            parent.getAddTicketPage().setVisible(true);
        });
        add(addButton);
        JButton listButton = new JButton("List Tickets");
        listButton.setBounds(100,200,300,30);

        listButton.addActionListener(e -> {
            parent.getListOfTicketsPage().generateTable();
            parent.getAdminMenu().setVisible(false);
            parent.getListOfTicketsPage().setVisible(true);
        });
        add(listButton);
        JButton backBtn = new JButton("Back to main menu");
        backBtn.setBounds(100,300,300,30);

        backBtn.addActionListener(e -> {
            parent.getAdminMenu().setVisible(false);
            parent.getMainMenu().setVisible(true);
        });
        add(backBtn);
    }
}
