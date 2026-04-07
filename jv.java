import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class jv extends JFrame implements ActionListener {

    JTextArea textArea;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem newItem, openItem, saveItem, exitItem;

    jv() {
       
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");

        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

       
        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);


        setTitle("Simple Notepad");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == newItem) {
            textArea.setText("");
        }

        else if (e.getSource() == openItem) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    textArea.read(br, null);
                    br.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }

        else if (e.getSource() == saveItem) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);

            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    textArea.write(bw);
                    bw.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }

        else if (e.getSource() == exitItem) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new jv();
    }
}