import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HydraVirus extends JDialog{
    private JPanel panelHydra;
    private JButton buttonCut;

    public HydraVirus(JFrame parent) {
        super(parent);

        setTitle("Hydra virus");
        setContentPane(panelHydra);
        setLocationRelativeTo(parent);
        setMinimumSize(new Dimension(300,300));
        setVisible(true);


        buttonCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                HydraVirus leftHead = new HydraVirus(parent);
                HydraVirus rightHead = new HydraVirus(parent);
            }
        });
    }

    public static void main(String[] args) {
        HydraVirus virus = new HydraVirus(null);
    }
}
