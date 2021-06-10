package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import student.student;
public class input extends JFrame {
    JLabel label;
    JTextField textFieldName;
    JTextField textFieldID;
    JTextField textFieldGender;
    JTextField textFieldYear;
    JButton button;
    private static Socket socket;

    public input() {
        setLayout(new FlowLayout());

        label = new JLabel("Enter student information");
        add(label);

        add(new Label("Student Name"));
        textFieldName = new JTextField(10);
        add(textFieldName);

        add(new Label("Student ID"));
        textFieldID = new JTextField(10);
        add(textFieldID);

        add(new Label("Gender"));
        textFieldGender = new JTextField(10);
        add(textFieldGender);

        add(new Label("Year"));
        textFieldYear = new JTextField(10);
        add(textFieldYear);

        button = new JButton("Submit");
        add(button);

        event onclick = new event();
        button.addActionListener(onclick);
    }
     public class event implements ActionListener {
        public void actionPerformed(ActionEvent onclick) {
            student std = new student(
                    textFieldName.getText(),
                    textFieldID.getText(),
                    textFieldGender.getText(),
                    textFieldYear.getText());
            try {
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(std);
            } catch(IOException e){
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        input gui = new input();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(300, 150);
        gui.setTitle("Student Information");
        gui.setVisible(true);
    }
}
