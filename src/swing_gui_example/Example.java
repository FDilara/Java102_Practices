package swing_gui_example;

import javax.swing.*;
import java.awt.*;

public class Example extends JFrame{
    private JPanel wrapper;
    private JPanel wTop;
    private JTextField fld_username;
    private JButton loginButton;
    private JPasswordField passwordField;

    public Example() {
        //Theme can be changed
        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            //System.out.println(info.getName() + " => " +info.getClassName());
            if("Nimbus".equals(info.getName())) {
                try {
                    //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //this.add(wrapper);
        setContentPane(wrapper);
        setSize(400, 300);
        setTitle("Application Name");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //closes the existing application - automatically stops
        setResizable(false);  //not resizing

        //Calculate the x and y values to find the midpoint of the screen
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2; //x = screen.size.weight - frame.size.weight
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2; //y = screen.size.height - frame.size.height
        setLocation(x, y); //position of screen

        setVisible(true); //frame appear
        loginButton.addActionListener(actionEvent -> {
            //System.out.println("Button clicked!");
            if(fld_username.getText().length()==0 && passwordField.getText().length()==0) {
                JOptionPane.showMessageDialog(null, "Fill in all fields", "Warning", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Welcome " + fld_username.getText(), "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
