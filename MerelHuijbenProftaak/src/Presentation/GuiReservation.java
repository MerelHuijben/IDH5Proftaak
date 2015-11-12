
package Presentation;


import DataStorage.ReservationDAO;
import Domain.Reservation;
import BusinessLogic.reservationFound;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class GuiReservation extends JFrame {

    /**
     * The serializable class GUIpanel does not declare a static final
     * serialVersionUID field of type long So we added it.
     */
    private static final long serialVersionUID = 1L;

    public GuiReservation() {

        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Reserveringen");

        setContentPane(new GuiPanel());

        setVisible(true);

    }

}

class GuiPanel extends JPanel {

    /**
     * The serializable class GUIpanel does not declare a static final
     * serialVersionUID field of type long So we added it.
     */
    private static final long serialVersionUID = 1L;

    private DefaultTableModel dtm;

    private JTable table;

    private JTextArea textarea;
    private JPanel windows1;
    private JPanel window2;
    private Object bean;
    private Reservation Reservation;
    private java.awt.Panel FieldAvailability;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton ReservationButton;
    private JLabel avalabilityLabel;
    
        
    
    public void countdown(Reservation reservation) {


        if (reservationFound.reservationFound (getreservations())) {
            this.textarea.setBackground(Color.red);
            this.avalabilityLabel.setText("Gesereveerd");

        } else {
            this.textarea.setBackground(Color.green);
            this.avalabilityLabel.setText("Beschikbaar");

        }

    }

    public List<Reservation> getreservations() {
        ReservationDAO reservationdao = new ReservationDAO();
        List<Reservation> result = reservationdao.findReservations();
        return result;
    }

    public GuiPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        //left
        windows1 = new JPanel();

        //right
        window2 = new JPanel();
        
         //add button
        ReservationButton = new JButton("Reserveringen");
                ReservationButton.setLocation(0,0);
        ReservationButton.setVisible(true);
        windows1.add(ReservationButton);

        ReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dtm.setRowCount(0);
                List<Reservation> reservations = getreservations();
                for (Reservation res : reservations) { 
                addRow (res.GetStartTime(),res.GetEndTime());

                }

            }
        });

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                countdown(new Reservation(1400, 1606, 23));
            }
        }, 1 * 60 * 10, 1 * 60 * 10);

        //make visualisation of field
        textarea = new JTextArea(20, 20);

        //make tablecolumns
        String[] columns = new String[]{"Starttijd", "Eindtijd"};

        //make table
        table = new JTable();
        table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        table.setRowHeight(25);
        table.setRowMargin(3);
        table.setRowSelectionAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        dtm = new DefaultTableModel(0, 0);

        table.setModel(dtm);
        dtm.setColumnIdentifiers(columns);
      

        // action for Mouse clicks
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
       

        this.avalabilityLabel = new JLabel("Available");
        window2.add(this.avalabilityLabel);

        //adding to different windows
        windows1.add(new JScrollPane(table));
        window2.add(new JScrollPane(textarea));

        //left
        add(windows1);

        //right
        add(window2);
        this.initPanel();
    }
    // add rows
    public void addRow(int StartTime, int EndTime) {
        dtm.addRow(new Object[]{StartTime, EndTime});
    }
    // avoid duplicity of data
    public void resetTable() {
        dtm.setRowCount(0);
    }

    private void tableMouseClicked(MouseEvent evt) {

        String text = "";
        // clear textarea on next click
        textarea.setText(text);
        int selected = table.getSelectedRow();

        // map selected row in the JTable to id of the Event as 
        // known in the manager.
        selected = selected + 1;

        //for (String string : evenement.giveEventInfo()) {
        //text += string;
        //text += "\n";
        //}
        textarea.setText(text);

    }

    public void setObject(Object bean) {
        this.bean = bean;
    }

    private void initPanel() {
        // set background colour:\
        this.textarea.setBackground(Color.green);

    }
}
