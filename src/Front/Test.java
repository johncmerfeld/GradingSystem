import java.awt.*;
import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Fri Apr 05 16:04:36 EDT 2019
 */



/**
 * @author unknown
 */
public class Test extends JFrame {
    public Test() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        frame1 = new JFrame();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        panel1 = new JPanel();
        label1 = new JLabel();
        panel3 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();

        //======== frame1 ========
        {
            Container frame1ContentPane = frame1.getContentPane();
            frame1ContentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[433,fill]" +
                "[269,fill]",
                // rows
                "[49]" +
                "[141]" +
                "[192]" +
                "[182]"));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            frame1ContentPane.add(scrollPane1, "cell 0 2");

            //======== panel2 ========
            {
                panel2.setLayout(new GridLayout(0, 1));

                //---- button1 ----
                button1.setText("Student Info");
                panel2.add(button1);

                //---- button2 ----
                button2.setText("Create Course Work");
                panel2.add(button2);

                //---- button3 ----
                button3.setText("Course Logistic");
                panel2.add(button3);

                //---- button4 ----
                button4.setText("Course Rubric");
                panel2.add(button4);

                //---- button5 ----
                button5.setText("Add Note");
                panel2.add(button5);

                //---- button6 ----
                button6.setText("Export CSV");
                panel2.add(button6);
            }
            frame1ContentPane.add(panel2, "cell 1 2");

            //======== panel1 ========
            {
                panel1.setLayout(new GridLayout(0, 1));

                //---- label1 ----
                label1.setText("Course Work Summary");
                panel1.add(label1);

                //======== panel3 ========
                {
                    panel3.setLayout(new GridLayout());

                    //---- label2 ----
                    label2.setText("Search Students");
                    panel3.add(label2);
                    panel3.add(textField1);
                }
                panel1.add(panel3);
            }
            frame1ContentPane.add(panel1, "cell 0 1");
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JFrame frame1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel3;
    private JLabel label2;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
