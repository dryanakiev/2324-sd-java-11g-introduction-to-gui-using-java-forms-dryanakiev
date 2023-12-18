import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

public class PressMeButton extends JDialog{
    public int clicks = 0;
    public int highScore = 0;
    public int score = 0;
    public static Timer timer;
    public static int counter = 10;
    public static int period = 1000;
    public static int delay = 10;
    private JLabel labelCounter;
    private JButton startButton;
    private JPanel buttonPanel;
    private JLabel labelTopScore;

    public PressMeButton(JFrame parent) {
        super(parent);

        setTitle("Button incrementor");
        setContentPane(buttonPanel);
        setLocationRelativeTo(parent);
        setMinimumSize(new Dimension(300,300));
        setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer = new Timer();

                startButton.setVisible(false);

                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        if (counter == 1) {
                            timerCompleted();
                            timer.cancel();
                        }
                        else {
                            --counter;
                            System.out.println(counter);
                            labelCounter.setText(String.valueOf(counter));
                        }
                    }
                },delay,period);
            }
        });

        buttonPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                clicks ++;
            }
        });
    }

    public void timerCompleted() {
        score = clicks/ counter * 6;
        labelCounter.setText("Number of clicks per minute: " + String.valueOf(score));

        if(highScore < score) {
            labelTopScore.setText("Highest score:" + String.valueOf(score));
            highScore = score;
        }

        counter = 10;
        clicks = 0;
        startButton.setVisible(true);
    }

    public static void main(String[] args) {
        PressMeButton formButton = new PressMeButton(null);
    }
}
