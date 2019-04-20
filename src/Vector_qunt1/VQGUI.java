package Vector_qunt1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VQGUI {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JPanel jack;

    public VQGUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String compo= textField1.getText();
                int z=Integer.parseInt(compo);
                String compo1= textField2.getText();
                int z1=Integer.parseInt(compo1);
                String compo2= textField3.getText();
                int z2=Integer.parseInt(compo2);
                Main.compression(z,z1,z2);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("VQ_wohoo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new VQGUI().jack);
        frame.pack();
        frame.setVisible(true);
    }
}
