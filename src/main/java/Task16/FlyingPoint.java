package Task16;

import javax.swing.*;
import java.awt.*;

public class FlyingPoint extends JFrame {
    JPanel panel = new JPanel();
    Graphics g;
    JButton btn = new JButton("Add point");
    int i;

    public FlyingPoint() {
        setBounds(100, 200, 600, 600);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        btn.setBounds(200, 10, 160, 20);
        contentPane.add(btn);
        panel.setBounds(30, 40, 520, 500);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        btn.addActionListener(e -> {
            new PointThread(panel).start();
            i++;
            repaint();
        });
    }

    public static void main(String[] args) {
        FlyingPoint frame = new FlyingPoint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



