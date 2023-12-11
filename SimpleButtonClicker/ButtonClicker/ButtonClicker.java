import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClicker extends JDialog{
    private JButton buttonCounter;
    private JPanel buttonPanel;
    private JLabel counterLabel;

    int counter = 0;

    public ButtonClicker(JFrame parent) {
        super(parent);

        setTitle("Button incrementor");
        setContentPane(buttonPanel);
        setLocationRelativeTo(parent);
        setMinimumSize(new Dimension(200,200));
        setVisible(true);


        buttonCounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter += 1;
                counterLabel.setText("Clicks: " + String.valueOf(counter));
            }
        });
    }

    public static void main(String[] args) {
        ButtonClicker buttonClicker = new ButtonClicker(null);
    }
}
