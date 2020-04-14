
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class PanelClient extends javax.swing.JFrame
    {
    String ip;

    public PanelClient() 
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
        setSize(400,609);
         int w=getWidth();
        int h=getHeight();
        setLocation((sw-w)/2,(sh-h)/2);
        setVisible(true);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimise.png"))); // NOI18N
        jButton1.setToolTipText("Minimise");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(310, 10, 40, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        jButton2.setToolTipText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(350, 10, 40, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1469153652_navigation-right-button_sticker - Copy.png"))); // NOI18N
        jButton3.setToolTipText("Go");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(180, 480, 50, 50);

        jTextField1.setToolTipText("Enter IP Of Your Friend's Computer");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(70, 310, 270, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PanelClient.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 610);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        if (jTextField1.getText().length()!=0)
        {    ip=jTextField1.getText();
              
                       
             new ClientWindow(ip);
            dispose();
            
           
        }
        else
        {
            JOptionPane.showMessageDialog(null,"IP Cannot Be Left Blank");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         setState(ICONIFIED);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        new HomeScreen();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       int keycode=evt.getKeyCode();
        if(keycode==KeyEvent.VK_ENTER)
        {
           
           
        if (jTextField1.getText().length()!=0)
        {  ip=jTextField1.getText();
           
             new ClientWindow(ip);
            dispose();
           
           
        }
        else
        {
             JOptionPane.showMessageDialog(null,"IP Cannot Be Left Blank");
        }
        
        }
                
            
    }//GEN-LAST:event_jTextField1KeyPressed

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
                new PanelClient();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}

