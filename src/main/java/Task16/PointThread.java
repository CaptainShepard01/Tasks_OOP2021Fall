package Task16;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PointThread extends Thread {
    private static final Random random = new Random();

    JPanel panel;
    private int posX;
    private int posY;
    private final int BALL_SIZE = 10;
    private double alpha;
    private int SPEED = 4;
    private Color color;

    PointThread(JPanel p) {
        this.panel = p;
        boolean direction = random.nextBoolean();
        if(direction){
            posX = 0;
            alpha = 0;
        }
        else {
            posX = panel.getWidth() - BALL_SIZE;
            alpha = Math.PI;
        }
        posY = (int) ((panel.getHeight() - BALL_SIZE) * Math.random());
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    PointThread(JPanel p, int startX, double alpha) {
        this.panel = p;
        this.alpha = alpha;
        posX = startX;
        posY = (int) ((panel.getHeight() - BALL_SIZE) * Math.random());
        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public void run() {
        while (true) {
            posX += (int) (SPEED * Math.cos(alpha));
            if (posX >= panel.getWidth() - BALL_SIZE) {
                new PointThread(panel, 0, alpha).start();
                break;
            } else if (posX <= 0) {
                new PointThread(panel, panel.getWidth() - BALL_SIZE, alpha).start();
                break;
            }
            paint(panel.getGraphics());
        }
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360);
        g.drawArc(posX + 1, posY + 1, BALL_SIZE, BALL_SIZE, 120, 30);

        try {
            sleep(30);
        } catch
        (InterruptedException e) {
            e.printStackTrace();
        }
        g.setColor(panel.getBackground());
        g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360);
    }
}
