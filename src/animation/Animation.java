/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package animation;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.color.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.Arrays;

/**
 *
 * @author jovan
 */
interface Effects {

    public void Hide();

    public void Show();

    public void Jump();

    public void ChangesColor();
}

class Circle extends JPanel implements Effects {

    private int r;

    private int border;
    private int[] borderColor = {0, 0, 0};

    private int Xcoordinate;
    private int Ycoordinate;

    private int R;
    private int G;
    private int B;

    private int RB;
    private int GB;
    private int BB;

    private boolean hideExist = true;

    private int CurrentFrameCount;

    public Circle() {
        this.border = 2;
        this.Xcoordinate = 300;
        this.Ycoordinate = 300;
        this.R = 0;
        this.G = 0;
        this.B = 0;
        this.RB = 0;
        this.GB = 0;
        this.BB = 0;
        this.r = 20;
    }

    public void setFrame(int f) {
        this.CurrentFrameCount = f;
    }

    public void setR(int R) {
        this.r = R;
    }

    public void setX(int X) {
        if (X < 0) {
            X = abs(X);
        }

        if (X > 600) {
            this.Xcoordinate = 300;
        } else {
            this.Xcoordinate = X;
        }
    }

    public void setY(int Y) {
        if (Y < 0) {
            Y = abs(Y);
        }

        if (Y > 600) {
            this.Ycoordinate = 300;
        } else {
            this.Ycoordinate = Y;
        }
    }

    public void setBorder(int b) {
        this.border = b;
    }

    public void setColor(int r, int g, int b) {
        this.R = r;
        this.G = g;
        this.B = b;
    }

    public void setborderColor(int r, int g, int b) {
        this.RB = r;
        this.GB = g;
        this.BB = b;
    }

    @Override
    public void paint(Graphics g) {
        System.out.println(CurrentFrameCount);
        if (hideExist = true) {
            if (CurrentFrameCount < 50) {
            } else {
                setSize(600, 600);
                g.drawOval(this.Xcoordinate - r, this.Ycoordinate - r, 2 * r, 2 * r);
            }
        }

    }

    @Override
    public void Hide() {
    }

    @Override
    public void Show() {
    }

    @Override
    public void Jump() {
    }

    @Override
    public void ChangesColor() {
    }
}

class Rectangle extends JPanel implements Effects {

    private int length;
    private int width;

    private int border;
    private int[] borderColor = {0, 0, 0};

    private int Xcoordinate;
    private int Ycoordinate;

    private int R;
    private int G;
    private int B;

    private int RB;
    private int GB;
    private int BB;

    private boolean hideExist = true;

    private int CurrentFrameCount;

    public Rectangle() {
        this.border = 2;
        this.Xcoordinate = 300;
        this.Ycoordinate = 300;
        this.R = 0;
        this.G = 0;
        this.B = 0;
        this.RB = 0;
        this.GB = 0;
        this.BB = 0;
        this.length = 80;
        this.width = 40;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setLength(int l) {
        this.length = l;
    }

    public void setX(int X) {
        if (X < 0) {
            X = abs(X);
        }

        if (X > 600) {
            this.Xcoordinate = 300;
        } else {
            this.Xcoordinate = X;
        }
    }

    public void setY(int Y) {
        if (Y < 0) {
            Y = abs(Y);
        }

        if (Y > 600) {
            this.Ycoordinate = 300;
        } else {
            this.Ycoordinate = Y;
        }
    }

    public void setBorder(int b) {
        this.border = b;
    }

    public void setColor(int r, int g, int b) {
        this.R = r;
        this.G = g;
        this.B = b;
    }

    public void setborderColor(int r, int g, int b) {
        this.RB = r;
        this.GB = g;
        this.BB = b;
    }

    @Override
    public void Hide() {

    }

    @Override
    public void Show() {
    }

    @Override
    public void Jump() {
    }

    @Override
    public void ChangesColor() {
    }
}

class AnimationPlayer extends JPanel {

    private int FRAMERATE;
    private int FRAMES;
    private int numberofElements;
    private Circle circle;
    private Rectangle rectangle;
    private boolean circleExists;
    private boolean rectangleExists;

    private int TotalFrameCount = 0;

    public AnimationPlayer() {
        this.FRAMES = 500;
        this.FRAMERATE = 20;
    }

    public int getFrameCount() {
        return TotalFrameCount;
    }

    public void run() {
        JFrame mainframe = new JFrame();
        mainframe.setSize(600, 600);
        mainframe.setVisible(true);
        mainframe.add(circle);

        boolean running;
        long startTime;
        long URDTimeMilis;
        long WaitTime;
        long TotalTime = 0;

        int FrameCount = 0;
        int MaxFrameCount = FRAMERATE;

        long TargetFPS = 1000 / FRAMERATE;

        while (running = true) {
            if (circleExists = true) {
                circle.setFrame(TotalFrameCount);
                circle.repaint();
            }
            //System.out.println(TotalFrameCount);
            startTime = System.nanoTime();
            URDTimeMilis = (System.nanoTime() - startTime) / 1000000;
            WaitTime = TargetFPS - URDTimeMilis;
            try {
                Thread.sleep(WaitTime);
            } catch (InterruptedException e) {

            }
            TotalTime += System.nanoTime() - startTime;
            FrameCount++;

            if (FrameCount == MaxFrameCount) {
                TotalFrameCount += FrameCount;
                FrameCount = 0;
                TotalTime = 0;
            }

            if (TotalFrameCount == FRAMES) {
                System.exit(0);

            }
        }
    }

    public void loadAnimationFromFile(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File not found.");
            throw new FileNotFoundException();
        } else {
            BufferedReader R = new BufferedReader(new FileReader(file));
            String line = R.readLine();

            while (line.isEmpty() != true) {
                if (line.toLowerCase().contains("frames:")) {
                    String[] arr = line.split(" ");
                    try {
                        FRAMES = Integer.parseInt(arr[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number for frames. Return to default.");
                    }
                    System.out.println(Arrays.toString(arr));
                    line = R.readLine();

                } else if (line.toLowerCase().contains("speed:")) {
                    String[] arr = line.split(" ");
                    System.out.println(Arrays.toString(arr));
                    try {
                        FRAMERATE = Integer.parseInt(arr[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number for framerate. Return to default.");
                    }
                    line = R.readLine();

                } else {
                    try {
                        numberofElements = Integer.parseInt(line);
                        System.out.println(numberofElements);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter text file containing valid information!");
                        System.exit(0);
                    }
                    line = R.readLine();
                }
            }

            line = R.readLine();
            System.out.println(line);
            for (int i = 0; i < numberofElements + 1; i++) {
                if (line.toLowerCase().contains("circle")) {
                    line = R.readLine();
                    System.out.println(line);
                    circleExists = true;
                    circle = new Circle();

                    while (line.isEmpty() == false) {

                        if (line.toLowerCase().contains("color:")) {
                            String fina = line.replace(",", "");
                            String[] arr = fina.split(" ");
                            try {
                                int r = Integer.parseInt(arr[1]);
                                int g = Integer.parseInt(arr[2]);
                                int b = Integer.parseInt(arr[3]);
                                circle.setColor(r, g, b);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for color. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("x:")) {
                            String[] arr = line.split(" ");
                            try {
                                int X = Integer.parseInt(arr[1]);
                                circle.setX(X);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for X. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("y:")) {
                            String[] arr = line.split(" ");
                            try {
                                int Y = Integer.parseInt(arr[1]);
                                circle.setY(Y);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for Y. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("border:")) {
                            String[] arr = line.split(" ");
                            try {
                                int B = Integer.parseInt(arr[1]);
                                circle.setBorder(B);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for border. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("r:")) {
                            String[] arr = line.split(" ");
                            try {
                                int radius = Integer.parseInt(arr[1]);
                                circle.setR(radius);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for radius. Return to default.");
                            }
                            line = R.readLine();
                        } else if (line.toLowerCase().contains("effect")) {

                            line = R.readLine();
                            while ((line.isEmpty() != true) || (line.toLowerCase().contains("effect") == true)) {
                                if (line.toLowerCase().contains("hide")) {

                                    line = R.readLine();
                                    String[] arr = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr[1]);
                                        circle.setBorder(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid number for hide. Return to default.");
                                    }

                                } else if (line.toLowerCase().contains("show")) {

                                }
                            }
                        }
                    }

                } else if (line.toLowerCase().contains("rectangle")) {
                    line = R.readLine();
                    rectangleExists = true;
                    rectangle = new Rectangle();
                    while (line.isEmpty() != true) {

                    }

                } else if (line.toLowerCase().contains("line")) {
                    while (line.isEmpty() != true) {

                    }
                } else {
                    System.out.println("Loading Complete");
                }
            }

        }
    }

}

public class Animation {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        AnimationPlayer player = new AnimationPlayer();
        try {
            player.loadAnimationFromFile("animation1.txt");
        } catch (IOException e) {
            System.out.println("Please enter a valid file.");
            System.exit(0);
        }
        player.run();
    }

}
