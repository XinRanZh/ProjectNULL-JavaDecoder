package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
	// write your code here

        JFrame mainFrame = new JFrame();
        JPanel mainPanel = new JPanel();
        JTextArea jTextArea = new JTextArea();
        jTextArea.setSize(300,300);
        JButton jButton = new JButton("Confirm 确认");
        mainPanel.setLayout(new BorderLayout());
        jTextArea.setLineWrap(true);
        mainPanel.add(jTextArea,BorderLayout.NORTH);
        mainPanel.add(jButton,BorderLayout.SOUTH);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(300,400);
        mainFrame.setVisible(true);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Decoder decoder = new Decoder(jTextArea.getText());
            }
        });
        //Decoder decoder = new Decoder(" \n \n \n \n \n \n \n \n\t \n\t\n \n \n \n \n\t \n\t\n \n \n\t\n \n \n \n\t\n \n \n \n\t\n \n\t\t\n\t\t\n\t\t\n\t\t\n  \n \t\n\t\n \n\t\n \n\t\n  \n\t\n\t\n \n\t \n\t\t\n \t\n\t\t\n  \n \t\n\t\n\t\n\t \t\n\t\n  \n  \n  \n\t \t\n \n \n \n \n \n \n \n\t \t\n\t \t\n \n \n \n\t \t\n\t\n\t\n\t \t\n\t\t\n  \n\t \t\n\t\t\n\t \t\n \n \n \n\t \t\n  \n  \n  \n  \n  \n  \n\t \t\n  \n  \n  \n  \n  \n  \n  \n  \n\t \t\n\t\n\t\n \n\t \t\n\t\n \n \n\t \t\n");
    }
}
