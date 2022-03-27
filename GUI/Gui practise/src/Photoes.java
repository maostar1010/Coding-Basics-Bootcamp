


import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.Rectangle;


public class Photoes extends JFrame {
   static int x = 0;
   JButton bNext = new JButton();
   JButton bPrevious = new JButton();
   TitledBorder titledBorder1 = new TitledBorder("");
   JLabel lblPhoto = new JLabel();
   TitledBorder titledBorder2 = new TitledBorder("");
   public Photoes() {
      try {
         jbInit();
      }
         catch (Exception e) {
         }
   }
   private void jbInit() throws Exception {
      getContentPane().setLayout(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.setResizable(false);
      this.setTitle("Simple Photo Viewer");
      this.setBounds(50,10,810,740);
      this.setVisible(true);
      this.addWindowListener(new Photoes_this_windowAdapter(this));
      lblPhoto.setFont(new java.awt.Font("Arial", Font.BOLD, 30));
      lblPhoto.setHorizontalAlignment(JLabel.CENTER);
      lblPhoto.setBorder(titledBorder2);
      lblPhoto.setBounds(new Rectangle(2, 0, 800, 600));
      bNext.setBounds(new Rectangle(610, 636, 118, 46));
      bNext.setToolTipText("Show next image");
      bNext.setText("Next");
      bNext.addMouseListener(new Photoes_bNext_mouseAdapter(this));
      bNext.addActionListener(new Photoes_bNext_actionAdapter(this));
      bNext.setMnemonic('N');
      bPrevious.setBounds(new Rectangle(371, 636, 118, 46));
      bPrevious.setToolTipText("Show Previous Photo");
      bPrevious.setText("Previous");
      bPrevious.addActionListener(new Photoes_bPrevious_actionAdapter(this));
      bPrevious.setMnemonic('P');
      this.getContentPane().add(lblPhoto);
      this.getContentPane().add(bNext);
      this.getContentPane().add(bPrevious);
      this.viewPhotoes();
   }
   public void viewPhotoes(){
      String file = "slide" + Integer.toString(x) + ".jpg";
      File f = new File(file);
      if (!f.exists()) {
         x = -1;
      }
      ImageIcon i = new ImageIcon(file);
      lblPhoto.setIcon(i);
   }
   public static void main(String args[]){
      Photoes pho=new Photoes();
   }
   public void bPrevious_actionPerformed(ActionEvent e) {
      if(x>1) {
         x--;
         this.viewPhotoes();
      }
   }
   public void bNext_actionPerformed(ActionEvent e) {
      x++;
      this.viewPhotoes();
   } 
}
class Photoes_this_windowAdapter extends WindowAdapter {
   private Photoes adaptee;
   Photoes_this_windowAdapter(Photoes adaptee) {
      this.adaptee = adaptee;
   }
}
class Photoes_bNext_mouseAdapter extends MouseAdapter {
   private Photoes adaptee;
   Photoes_bNext_mouseAdapter(Photoes adaptee) {
      this.adaptee = adaptee;
   }
}
class Photoes_bNext_actionAdapter implements ActionListener {
   private Photoes adaptee;
   Photoes_bNext_actionAdapter(Photoes adaptee) {
      this.adaptee = adaptee;
   }
   public void actionPerformed(ActionEvent e) {
      adaptee.bNext_actionPerformed(e);
   }
}
class Photoes_bPrevious_actionAdapter implements ActionListener {
   private Photoes adaptee;
   Photoes_bPrevious_actionAdapter(Photoes adaptee) {
      this.adaptee = adaptee;
   }
   public void actionPerformed(ActionEvent e) {
      adaptee.bPrevious_actionPerformed(e);
   }
}
