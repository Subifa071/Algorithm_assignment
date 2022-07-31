package GUI;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
class Dashboard {
    Dashboard() {
        JFrame f = new JFrame("SELECT ONE");
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        JButton addinfo, viewNetwork, shortDist, vulnerableNodes;
        JLabel titleLabel;

        titleLabel = new JLabel("CHOOSE ONE");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 45));
        f.add(titleLabel);
        titleLabel.setBounds(150, 30, 3000, 100);

        addinfo = new JButton("Add Information");
        f.add(addinfo);
        addinfo.setBounds(50, 150, 500, 50);


        viewNetwork = new JButton("View Network");
        f.add(viewNetwork);
        viewNetwork.setBounds(50, 250, 500, 50);

        shortDist = new JButton("Shortest Distance");
        f.add(shortDist);
        shortDist.setBounds(50, 350, 500, 50);

        vulnerableNodes = new JButton("Vulnerable Points");
        f.add(vulnerableNodes);
        vulnerableNodes.setBounds(50, 450, 500, 50);

        JTextField Srctxt = new JTextField();
        JTextField Distxt = new JTextField();

        

         addinfo.addActionListener(e -> {
            f.dispose();
            new Information();
        });

        viewNetwork.addActionListener(e -> {
            f.dispose();
             try {
                new ViewDetails();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        shortDist.addActionListener(e -> {
            f.dispose();

            Object[]info = {

                "Source : ",Srctxt,
                
                "Destination : ",Distxt,
                
                };
                
                
                
                int response = JOptionPane.showConfirmDialog(null,info, "Please Enter New House Details: ",JOptionPane.OK_CANCEL_OPTION);
                
                
                
                if (response ==JOptionPane.OK_OPTION) {
                
                String src = Srctxt.getText();
                
                String des = Distxt.getText();
             
                
            
            MST ms = new MST(20);


            ShortDis sd;
            try {
                sd = new ShortDis(ms.totalHouses());
                String message = sd.dijkstra(Integer.parseInt(src), Integer.parseInt(des));

                JOptionPane.showMessageDialog(f,message);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        });

        // vulnerableNodes.addActionListener(e -> {
        //     f.dispose();
           
        // });


        f.setLayout(null);
        f.setBounds(500, 100, 600, 450);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);


        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setBounds(800, 200, 600, 600);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}