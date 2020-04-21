import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clienteGUI extends JFrame
{
    private JButton UNBOTONFIFIButton;
    private JTextArea textSpace1;
    private JPanel mainPanel;

    public clienteGUI()
    {

        add(mainPanel);

        setTitle("El Cajero FIFI");
        setSize(400,500);

        textSpace1.append("1234");
        textSpace1.insert("hola", 1);

        ActionListener hola = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String info = textSpace1.getText();

                System.out.println(info);
            }
        };

        UNBOTONFIFIButton.addActionListener(hola);




    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
