import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interest extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, result;
    JTextField t1, t2, t3;
    JButton simpleBtn, compoundBtn, clearBtn;

    public Interest() {
        setTitle("Interest Calculator");
        setSize(400, 350);
        setLayout(new FlowLayout());

        l1 = new JLabel("Principal Amount:");
        l2 = new JLabel("Rate of Interest (%):");
        l3 = new JLabel("Time (Years):");
        l4 = new JLabel("Result:");

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);

        result = new JLabel("");

        simpleBtn = new JButton("Simple Interest");
        compoundBtn = new JButton("Compound Interest");
        clearBtn = new JButton("Clear");

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(simpleBtn);
        add(compoundBtn);
        add(clearBtn);
        add(l4);
        add(result);

        simpleBtn.addActionListener(this);
        compoundBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double principal = Double.parseDouble(t1.getText());
            double rate = Double.parseDouble(t2.getText());
            double time = Double.parseDouble(t3.getText());

            if (e.getSource() == simpleBtn) {
                double si = (principal * rate * time) / 100;
                result.setText("Simple Interest = " + si);
            }

            if (e.getSource() == compoundBtn) {
                double ci = principal * Math.pow((1 + rate / 100), time) - principal;
                result.setText("Compound Interest = " + ci);
            }

            if (e.getSource() == clearBtn) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                result.setText("");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new Interest();
    }
}