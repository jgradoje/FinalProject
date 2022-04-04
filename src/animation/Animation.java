/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package animation;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author jovan
 */
class Circle extends JPanel {

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

    private boolean hideExist = false;
    private boolean showExist = false;
    private boolean colorExist = false;
    private boolean jumpExist = false;

    private int CurrentFrameCount;

    private int ColorStart;
    private int ColorR;
    private int ColorG;
    private int ColorB;

    private int HideStart;

    private int ShowStart;

    private int JumpStart;
    private int JumpX;
    private int JumpY;

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

    public void setHideExist(boolean b) {
        hideExist = b;
    }

    public void setShowExist(boolean b) {
        showExist = b;
    }

    public void setJumpExist(boolean b) {
        jumpExist = b;
    }

    public void setColorExist(boolean b) {
        colorExist = b;
    }

    public void setColorStart(int c) {
        this.ColorStart = c;
    }

    public void setColorChange(int r, int g, int b) {
        this.ColorR = r;
        this.ColorG = g;
        this.ColorB = b;
    }

    public void setHide(int h) {
        this.HideStart = h;
    }

    public void setShow(int s) {
        this.ShowStart = s;
    }

    public void setJump(int j) {
        this.JumpStart = j;
    }

    public void setJumpY(int y) {
        this.JumpX = y;
    }

    public void setJumpX(int x) {
        this.JumpY = x;
    }

    public void setFrame(int f) {
        this.CurrentFrameCount = f;
    }

    public void setR(int R) {
        this.r = R;
    }

    public void setX(int X) {
        this.Xcoordinate = X;
    }

    public void setY(int Y) {
        this.Ycoordinate = Y;
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fg = (Graphics2D) g;

        Color currentColor = new Color(R, G, B);
        Color currentBorderColor = new Color(RB, GB, BB);

        setSize(600, 600);
        fg.setColor(currentColor);
        fg.fillOval(this.Xcoordinate - r, this.Ycoordinate - r, 2 * r, 2 * r);
        fg.setColor(currentBorderColor);
        fg.drawOval(this.Xcoordinate - r, this.Ycoordinate - r, 2 * r, 2 * r);
        fg.setStroke(new BasicStroke(border));

        if (hideExist == true) {
            if (HideStart < CurrentFrameCount) {
                this.setX(900);
                this.setY(900);
            }
        }

        if (showExist == true) {
            if (ShowStart < CurrentFrameCount) {
                this.setX(20);
                this.setY(20);
                showExist = false;
            } else {
                this.setX(900);
                this.setY(900);
            }
        }

        if (jumpExist == true) {
            if (JumpStart < CurrentFrameCount) {
                this.setX(JumpX);
                this.setY(JumpY);
            }
        }

        if (colorExist == true) {
            if (ColorStart < CurrentFrameCount) {
                this.setColor(ColorR, ColorG, ColorB);
            }
        }

    }
}

class Line extends JPanel {

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private int border;

    private int R;
    private int G;
    private int B;

    private boolean hideExist = false;
    private boolean showExist = false;
    private boolean colorExist = false;
    private boolean jumpExist = false;

    private int CurrentFrameCount;

    private int ColorStart;
    private int ColorR;
    private int ColorG;
    private int ColorB;

    private int HideStart;

    private int ShowStart;

    private int JumpStart;
    private int JumpX;
    private int JumpY;

    public Line() {
        this.startX = 50;
        this.startY = 50;
        this.endX = 200;
        this.endY = 50;
        this.R = 0;
        this.G = 0;
        this.B = 0;
        this.border = 1;
    }

    public void setHideExist(boolean b) {
        hideExist = b;
    }

    public void setShowExist(boolean b) {
        showExist = b;
    }

    public void setJumpExist(boolean b) {
        jumpExist = b;
    }

    public void setColorExist(boolean b) {
        colorExist = b;
    }

    public void setColorStart(int c) {
        this.ColorStart = c;
    }

    public void setColorChange(int r, int g, int b) {
        this.ColorR = r;
        this.ColorG = g;
        this.ColorB = b;
    }

    public void setHide(int h) {
        this.HideStart = h;
    }

    public void setShow(int s) {
        this.ShowStart = s;
    }

    public void setJump(int j) {
        this.JumpStart = j;
    }

    public void setJumpY(int y) {
        this.JumpX = y;
    }

    public void setJumpX(int x) {
        this.JumpY = x;
    }

    public void setFrame(int f) {
        this.CurrentFrameCount = f;
    }

    public void setX(int X) {
        this.startX = X;
    }

    public void setY(int Y) {
        this.startY = Y;
    }

    public void endX(int X) {
        this.endX = X;
    }

    public void endY(int Y) {
        this.endY = Y;
    }

    public void setBorder(int b) {
        this.border = b;
    }

    public void setColor(int r, int g, int b) {
        this.R = r;
        this.G = g;
        this.B = b;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fg = (Graphics2D) g;

        Color currentColor = new Color(R, G, B);

        setSize(600, 600);
        fg.setColor(currentColor);
        fg.drawLine(startX, startY, endX, endY);
        fg.setStroke(new BasicStroke(border));

        if (hideExist == true) {
            if (HideStart < CurrentFrameCount) {
                this.setX(900);
                this.setY(900);
                this.endX(900);
                this.endY(900);
            }
        }

        if (showExist == true) {
            if (ShowStart < CurrentFrameCount) {
                this.setX(20);
                this.setY(20);
                showExist = false;
            } else {
                this.setX(900);
                this.setY(900);
                this.endX(900);
                this.endY(900);
            }
        }

        if (jumpExist == true) {
            if (JumpStart < CurrentFrameCount) {
                this.setX(JumpX);
                this.setY(JumpY);
            }
        }

        if (colorExist == true) {
            if (ColorStart < CurrentFrameCount) {
                this.setColor(ColorR, ColorG, ColorB);
            }
        }

    }
}

class Rectangle extends JPanel {

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

    private boolean hideExist = false;
    private boolean showExist = false;
    private boolean colorExist = false;
    private boolean jumpExist = false;

    private int ColorStart;
    private int ColorR;
    private int ColorG;
    private int ColorB;

    private int HideStart;

    private int ShowStart;

    private int JumpStart;
    private int JumpX;
    private int JumpY;

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

    public void setHideExist(boolean b) {
        hideExist = b;
    }

    public void setShowExist(boolean b) {
        showExist = b;
    }

    public void setJumpExist(boolean b) {
        jumpExist = b;
    }

    public void setColorExist(boolean b) {
        colorExist = b;
    }

    public void setColorStart(int c) {
        this.ColorStart = c;
    }

    public void setColorChange(int r, int g, int b) {
        this.ColorR = r;
        this.ColorG = g;
        this.ColorB = b;
    }

    public void setHide(int h) {
        this.HideStart = h;
    }

    public void setShow(int s) {
        this.ShowStart = s;
    }

    public void setJump(int j) {
        this.JumpStart = j;
    }

    public void setJumpY(int y) {
        this.JumpX = y;
    }

    public void setJumpX(int x) {
        this.JumpY = x;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setLength(int l) {
        this.length = l;
    }

    public void setFrame(int f) {
        this.CurrentFrameCount = f;
    }

    public void setX(int X) {
        this.Xcoordinate = X;
    }

    public void setY(int Y) {
        this.Ycoordinate = Y;
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D fg = (Graphics2D) g;

        Color currentColor = new Color(R, G, B);
        Color currentBorderColor = new Color(RB, GB, BB);

        fg.setStroke(new BasicStroke(border));
        fg.setColor(currentColor);
        fg.fillRect(Xcoordinate, Ycoordinate, length, width);
        fg.setColor(currentBorderColor);
        fg.drawRect(Xcoordinate, Ycoordinate, length, width);

        System.out.println(CurrentFrameCount);

        if (hideExist == true) {
            if (HideStart < CurrentFrameCount) {
                this.setX(900);
                this.setY(900);
            }
        }

        if (showExist == true) {
            if (ShowStart < CurrentFrameCount) {
                this.setX(20);
                this.setY(20);
                showExist = false;
            } else {
                this.setX(900);
                this.setY(900);
            }
        }

        if (jumpExist == true) {
            if (JumpStart < CurrentFrameCount) {
                this.setX(JumpX);
                this.setY(JumpY);
            }
        }

        if (colorExist == true) {
            if (ColorStart < CurrentFrameCount) {
                this.setColor(ColorR, ColorG, ColorB);
            }
        }
    }
}

class AnimationPlayer extends JFrame {

    private int FRAMERATE;
    private int FRAMES;
    private int numberofElements;
    private Circle circle;
    private Rectangle rectangle;
    private Line lines;
    private boolean circleExists = false;
    private boolean rectangleExists = false;
    private boolean lineExists = false;

    private int TotalFrameCount = 0;

    public AnimationPlayer() {
        this.FRAMES = 500;
        this.FRAMERATE = 20;
    }

    public int getFrameCount() {
        return TotalFrameCount;
    }

    public void run() {
        this.setSize(600, 600);
        this.setTitle("Final Project");

        boolean running;
        long startTime;
        long URDTimeMilis;
        long WaitTime;
        long TotalTime = 0;

        int FrameCount = 0;
        int MaxFrameCount = FRAMERATE;

        long TargetFPS = 1000 / FRAMERATE;

        while (running = true) {
            if (circleExists == true) {
                add(circle);
                circle.setFrame(TotalFrameCount);
                circle.repaint();
            }

            if (rectangleExists == true) {
                add(rectangle);
                rectangle.setFrame(TotalFrameCount);
                rectangle.repaint();
            }

            setVisible(true);
            System.out.println(TotalFrameCount);
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
                    circleExists = true;
                    circle = new Circle();

                    while (line.isEmpty() == false) {

                        if (line.toLowerCase().contains("bordercolor:")) {
                            String fina = line.replace(",", "");
                            String[] arr = fina.split(" ");
                            try {
                                int r = Integer.parseInt(arr[1]);
                                int g = Integer.parseInt(arr[2]);
                                int b = Integer.parseInt(arr[3]);
                                circle.setborderColor(r, g, b);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for border color. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("color:")) {
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
                            while (line.isEmpty() == false) {

                                line = R.readLine();
                                if (line.toLowerCase().contains("hide")) {
                                    circle.setHideExist(true);
                                    line = R.readLine();
                                    String[] arr = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr[1]);
                                        circle.setHide(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                } else if (line.toLowerCase().contains("show")) {
                                    circle.setShowExist(true);
                                    line = R.readLine();
                                    String[] arr = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr[1]);
                                        circle.setShow(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                } else if (line.toLowerCase().contains("jump")) {
                                    circle.setJumpExist(true);
                                    line = R.readLine();
                                    String[] arr = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr[1]);
                                        circle.setJump(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                    String[] arr1 = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr1[1]);
                                        circle.setJumpX(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                    String[] arr2 = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr2[1]);
                                        circle.setJumpY(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();
                                } else if (line.toLowerCase().contains("changecolor")) {
                                    circle.setColorExist(true);
                                    line = R.readLine();
                                    String[] arr = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr[1]);
                                        circle.setColorStart(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                    String fina = line.replace(",", "");
                                    String[] arr1 = fina.split(" ");
                                    try {
                                        int r = Integer.parseInt(arr1[1]);
                                        int g = Integer.parseInt(arr1[2]);
                                        int b = Integer.parseInt(arr1[3]);
                                        circle.setColorChange(r, g, b);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid number for color. Return to default.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();
                                }
                            }
                        }
                    }

                } else if (line.toLowerCase().contains("rectangle")) {
                    line = R.readLine();
                    rectangleExists = true;
                    rectangle = new Rectangle();
                    while (line.isEmpty() != true) {

                        if (line.toLowerCase().contains("bordercolor:")) {
                            String fina = line.replace(",", "");
                            String[] arr = fina.split(" ");
                            try {
                                int r = Integer.parseInt(arr[1]);
                                int g = Integer.parseInt(arr[2]);
                                int b = Integer.parseInt(arr[3]);
                                rectangle.setborderColor(r, g, b);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for border color. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("color:")) {
                            String fina = line.replace(",", "");
                            String[] arr = fina.split(" ");
                            try {
                                int r = Integer.parseInt(arr[1]);
                                int g = Integer.parseInt(arr[2]);
                                int b = Integer.parseInt(arr[3]);
                                rectangle.setColor(r, g, b);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for color. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("x:")) {
                            String[] arr = line.split(" ");
                            try {
                                int X = Integer.parseInt(arr[1]);
                                rectangle.setX(X);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for X. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("y:")) {
                            String[] arr = line.split(" ");
                            try {
                                int Y = Integer.parseInt(arr[1]);
                                rectangle.setY(Y);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for Y. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("border:")) {
                            String[] arr = line.split(" ");
                            try {
                                int B = Integer.parseInt(arr[1]);
                                rectangle.setBorder(B);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for border. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("length:")) {
                            String[] arr = line.split(" ");
                            try {
                                int len = Integer.parseInt(arr[1]);
                                rectangle.setLength(len);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for length. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("width:")) {
                            String[] arr = line.split(" ");
                            try {
                                int wit = Integer.parseInt(arr[1]);
                                rectangle.setWidth(wit);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for length. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("effect")) {
                            while (line.isEmpty() == false) {
                                System.out.println("hello");
                                line = R.readLine();
                                if (line.toLowerCase().contains("hide")) {
                                    rectangle.setHideExist(true);
                                    line = R.readLine();
                                    String[] arr = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr[1]);
                                        rectangle.setHide(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                } else if (line.toLowerCase().contains("show")) {
                                    rectangle.setShowExist(true);
                                    line = R.readLine();
                                    String[] arr = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr[1]);
                                        rectangle.setShow(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                } else if (line.toLowerCase().contains("jump")) {
                                    rectangle.setJumpExist(true);
                                    line = R.readLine();
                                    String[] arr = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr[1]);
                                        rectangle.setJump(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                    String[] arr1 = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr1[1]);
                                        rectangle.setJumpX(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                    String[] arr2 = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr2[1]);
                                        rectangle.setJumpY(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();
                                } else if (line.toLowerCase().contains("changecolor")) {
                                    rectangle.setColorExist(true);
                                    line = R.readLine();
                                    String[] arr = line.split(" ");
                                    try {
                                        int H = Integer.parseInt(arr[1]);
                                        rectangle.setColorStart(H);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Incorrect effect number. No default, please check file again.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();

                                    String fina = line.replace(",", "");
                                    String[] arr1 = fina.split(" ");
                                    try {
                                        int r = Integer.parseInt(arr1[1]);
                                        int g = Integer.parseInt(arr1[2]);
                                        int b = Integer.parseInt(arr1[3]);
                                        rectangle.setColorChange(r, g, b);
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid number for color. Return to default.");
                                        System.exit(0);
                                    }
                                    line = R.readLine();
                                }
                            }
                        }
                    }

                } else if (line.toLowerCase().contains("line")) {
                    line = R.readLine();
                    lineExists = true;
                    lines = new Line();
                    while (line.isEmpty() != true) {
                        if (line.toLowerCase().contains("color:")) {
                            String fina = line.replace(",", "");
                            String[] arr = fina.split(" ");
                            try {
                                int r = Integer.parseInt(arr[1]);
                                int g = Integer.parseInt(arr[2]);
                                int b = Integer.parseInt(arr[3]);
                                lines.setColor(r, g, b);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for color. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("startx:")) {
                            String[] arr = line.split(" ");
                            try {
                                int X = Integer.parseInt(arr[1]);
                                lines.setX(X);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for X. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("starty:")) {
                            String[] arr = line.split(" ");
                            try {
                                int Y = Integer.parseInt(arr[1]);
                                lines.setY(Y);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for Y. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("border:")) {
                            String[] arr = line.split(" ");
                            try {
                                int B = Integer.parseInt(arr[1]);
                                lines.setBorder(B);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for border. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("endx:")) {
                            String[] arr = line.split(" ");
                            try {
                                int len = Integer.parseInt(arr[1]);
                                lines.endX(len);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for length. Return to default.");
                            }
                            line = R.readLine();

                        } else if (line.toLowerCase().contains("endy:")) {
                            String[] arr = line.split(" ");
                            try {
                                int wit = Integer.parseInt(arr[1]);
                                lines.endY(wit);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid number for length. Return to default.");
                            }
                            line = R.readLine();

                        }
                    }
                } else {
                    System.out.println("Loading Complete");
                }
                line = R.readLine();
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
