import java.net.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.border.LineBorder;

class ScreenClient extends JFrame {
    BufferedImage limg;
    JLabel l;
    String ip;
   
    int sw,sh,w,h;

    ScreenClient(String ip) 
    {
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("logo.png")));
        this.ip = ip;
    
        initComponents();
        Thread th = new Thread(new ScreenThread());
        th.start();
    }

    public class ScreenThread extends Thread {

        Socket client;

        public void run() {
            while (true) {
                try {
                    client = new Socket(ip, 6068);
                    InputStream in = client.getInputStream();
                    BufferedImage img = ImageIO.read(in);
                    limg=img;
                    l.repaint();
                
                   
                } catch (Exception ex)
                {
                    System.out.println(ex);
                }
            }
        }
    }
   

    public void initComponents() {
        setTitle("Remote Desktop");
        l = new CustLabel("Please Wait...");
        add(l);
        setUndecorated(true);
        l.setHorizontalAlignment(JLabel.CENTER);
        addMouseMotionListener(new MouseClass());
        addMouseListener(new MouseClickClass());
        addKeyListener(new KeyClass());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        sw = (int) d.getWidth();
        sh = (int) d.getHeight();
        setSize(1160,655);
        w=getWidth();
        h=getHeight();
        setLocation((sw-w)/2,(sh-h)/2);
        setVisible(true);
          l.setBorder(new LineBorder(new Color(0,0,0)));
        
        
    }
    
    public class CustLabel extends JLabel{

        public CustLabel(String l) {
            super(l);
        }
        
        
        @Override
        public void paint(Graphics g) {
          
            l.setBounds(4,3,1154,650);
            g.drawImage(limg, 0, 0,1152,648, null);
        }
        
    }
    public class KeyClass extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            try {
                int keycode = e.getKeyCode();
                Socket client = new Socket(ip, 6074);
                String content = "keypress#" + keycode;
                OutputStream out = client.getOutputStream();
                out.write(content.getBytes());
            } catch (Exception ex)
                         {
                             System.out.println(ex);
                         }
        }

        public void keyReleased(KeyEvent e) {
            try {
                int keycode = e.getKeyCode();
                Socket client = new Socket(ip, 6074);
                String content = "keyrelease#" + keycode;
                OutputStream out = client.getOutputStream();
                out.write(content.getBytes());
            } catch (Exception ex) 
            {
                System.out.println(ex);
            }
        }
    }

    public class MouseClass extends MouseAdapter {
       

        public void mouseMoved(MouseEvent e) {
            try {
                int x = (int) (e.getX());
                int y = (int) (e.getY());
              
                Socket client = new Socket(ip, 6070);
                OutputStream out = client.getOutputStream();
                out.write((x + "#" + y).getBytes());
            } catch (Exception ex) 
            {
                System.out.println(ex);
            }
        }
    }

    public class MouseClickClass extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            try {
                int n = e.getButton();
                int c = e.getClickCount();
                Socket client = new Socket(ip, 6072);
                OutputStream out = client.getOutputStream();
                if (c == 2 && n != 3) 
                {
                    n = 4;
                }
                out.write((n + "").getBytes());
            } catch (Exception ex) 
            {
                System.out.println(ex);
            }
        }
    }

    public static void main(String args[]) {
        new ScreenClient(null);
    }
}
