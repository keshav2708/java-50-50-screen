
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class HomeScreen extends javax.swing.JFrame {

    
    public HomeScreen() 
    {   setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("logo.png")));
        setUndecorated(true);
         Toolkit t =Toolkit.getDefaultToolkit();
    Dimension d=t.getScreenSize();
    int sw=(int) d.getWidth();
    int sh=(int) d.getHeight();
        initComponents();
        setVisible(true);
        setSize(900,609);
        int w=getWidth();
        int h=getHeight();
        setLocation((sw-w)/2,(sh-h)/2);
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1469153652_navigation-right-button_sticker - Copy.png"))); // NOI18N
        jButton1.setToolTipText("Help A Friend");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(650, 450, 50, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1469153652_navigation-right-button_sticker - Copy.png"))); // NOI18N
        jButton2.setToolTipText("Get Help");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(190, 450, 50, 50);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        jButton3.setToolTipText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(850, 10, 40, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/info-icon-23.png"))); // NOI18N
        jButton4.setToolTipText("Minimise");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(770, 10, 40, 40);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimise.png"))); // NOI18N
        jButton6.setToolTipText("Minimise");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(810, 10, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HomeScreen.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 610);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 900, 609);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   new About();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      new PanelClient();
      dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   new PanelServer();
   dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       setState(ICONIFIED);
    }//GEN-LAST:event_jButton6ActionPerformed

    public static void main(String args[]) {
        try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }catch(Exception ex)
       {
           System.out.println(ex);
       }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
                new HomeScreen();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    

    
}
