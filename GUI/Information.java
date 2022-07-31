package GUI;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

// Class to add route
class Information {
    Information(){
//        Initializing swing components
        JFrame f = new JFrame("Information Panel");
        JLabel houseA = new JLabel("House A");// source vertex
        JLabel houseB = new JLabel("House B");// destination vertex
        JLabel length_of_pipe = new JLabel("Length of pipe");// length of pipe

        JTextField houseA_text = new JTextField();
        JTextField houseB_text = new JTextField();
        JTextField length_of_pipe_text = new JTextField();

        
        JButton backButton = new JButton("Back");
        JButton addroute  = new JButton("Add Info");

//      Adding Swing Components in frame

        f.add(houseA).setBounds(50, 170, 100, 30);
        f.add(houseA_text).setBounds(150, 170, 150, 30);

        f.add(houseB).setBounds(50, 240, 100, 30);
        f.add(houseB_text).setBounds(150, 240, 150, 30);

        f.add(length_of_pipe).setBounds(50, 310, 100, 30);
        f.add(length_of_pipe_text).setBounds(150, 310, 150, 30);

        f.add(addroute).setBounds(80, 380, 200, 30);

        f.add(backButton).setBounds(5,25,150,30);


        //from here adding the user information into file

//        Add information action listener
        addroute.addActionListener(e -> {
            String source, destination, pipeLength;
            source = houseA_text.getText();
            destination = houseB_text.getText();
            pipeLength = length_of_pipe_text.getText();
            FileWriter fw;

//            Declaring list to store information data
            List<String> list = new ArrayList<>();
            List<String> length_of_pipeList = new ArrayList<>();
            File file = new File("houses.txt");
            if(file.exists()){
                try {
                    list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
//            Splitting information list with ';'
            for(String line : list){
                String [] res = line.split(";");
                length_of_pipeList.add(res[0]);
            }
            try {
//                Form Validations
                if(!length_of_pipeList.contains(pipeLength)){
                    if( source.isEmpty()|| destination.isEmpty() || pipeLength.isEmpty()){
                        JOptionPane.showMessageDialog(f,"Fill up the full form");
                    }
                    else {
                        fw = new FileWriter("information.txt", true);
                        
                        fw.write(source+","+destination+","+pipeLength+"\n");
                        fw.close();
                        JOptionPane.showMessageDialog(f, "Information Added Successfully");

                        houseA_text.setText("");
                        houseB_text.setText("");
                        length_of_pipe_text .setText("");
                    }

                }
                else {
                    JOptionPane.showMessageDialog(f,"fill carefully");

                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        backButton.addActionListener(e -> {
            f.dispose();
            // new Application();
        });

        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setBounds(800, 200, 400, 650);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}