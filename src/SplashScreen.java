
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAVID
 */
public class SplashScreen extends javax.swing.JFrame implements ActionListener 
    {
      Timer tm=new Timer(4000,this);
   

    public SplashScreen() 
    {
      setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("logo.png")));  
       
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(true);
    Toolkit t =Toolkit.getDefaultToolkit();
    Dimension d=t.getScreenSize();
    int sw=(int) d.getWidth();
    int sh=(int) d.getHeight();
        initComponents();
        setSize(900,606);
        
        int w=getWidth();
        int h=getHeight();
        setLocation((sw-w)/2,(sh-h)/2);
      
      
        tm.start();
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Copyright ©  2016 by Fifty-Fifty Screen LTD . All Rights Reserved ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(500, 580, 430, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arvirargus---Copy-(2).gif"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1, -4, 900, 610);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e)
    {
        float op=(float) 1.000;
        while(op>=0.0)
        {
            setOpacity(op);
            op=(float) (op-0.000001);
            
        }
        dispose();
        new HomeScreen();
      tm.stop();
    }

}
