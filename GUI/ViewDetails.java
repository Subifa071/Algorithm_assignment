package GUI;

import java.io.IOException;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;
public class ViewDetails {

    public ViewDetails() throws IOException{


    String input = "";

    BufferedReader reader = new BufferedReader(new FileReader("connection.txt"));
    String line = null;
    while ((line = reader.readLine()) != null) {

        input += line + "\n";
    }
    reader.close();

    JTextArea textArea = new JTextArea(input);
    JScrollPane scrollPane = new JScrollPane(textArea);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);

    scrollPane.setPreferredSize( new Dimension( 800,600 )) ;
    JOptionPane.showMessageDialog(null, scrollPane, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

}

