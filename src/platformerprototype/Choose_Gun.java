package platformerprototype;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.logging.*;
import javax.swing.*;

public class Choose_Gun extends JPanel implements ActionListener{
    JFrame Choose_Frame;
    JMenuBar MymenuBar;
    JMenu menu,submenu;
    JMenuItem menuItem;
    JButton Gun_1,Gun_2,Gun_3;
    ImageIcon bg ;
    ImageIcon Revolver;
    ImageIcon ShotGun ;
    ImageIcon AR15;
    //URL
     URL BG = Start_Screen.class.getClassLoader().getResource("Resources/Choose_Gun background.png");
    URL revolver = Start_Screen.class.getClassLoader().getResource("Resources/Revolver-T.png");
    URL shotgun = Start_Screen.class.getClassLoader().getResource("Resources/Shot_Gun-T.png");
    URL ar = Start_Screen.class.getClassLoader().getResource("Resources/AR-T.png");
    Image gun1,gun2,gun3;
    Image background;
    public void Display(){
    
    Choose_Frame = new JFrame("Choose_Gun");
    Choose_Frame.setSize(608,622);
    Choose_Frame.setVisible(true);
    Choose_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Choose_Frame.setResizable(false);
    Choose_Frame.add(this);
    
    MymenuBar = new JMenuBar();
            
            menu = new JMenu("Options");
            menu.addActionListener(this);
            menu.setMnemonic(KeyEvent.VK_A);
            menu.getAccessibleContext().setAccessibleDescription("This is the only menu in the prorgam that has menu items");
            
            menuItem = new JMenuItem("Return to Start Screen",KeyEvent.VK_T);
            menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));
            menuItem.getAccessibleContext().setAccessibleDescription("This is doesnt really do anything");
            menuItem.addActionListener(this);
            menu.add(menuItem);
          
            MymenuBar.add(menu);
            Choose_Frame.setJMenuBar(MymenuBar);
            
            Choose_Frame.repaint();
    }
    
  public  Choose_Gun(){
      this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
      bg = new ImageIcon(BG);
      Revolver = new ImageIcon(revolver);
      ShotGun = new ImageIcon(shotgun);
      AR15 = new ImageIcon(ar);
      
      Animating a = new Animating();
      //sets mygun to 0 so that it does not go over the limit of 3
      a.myGun = 0 ;
      this.setLayout(null);
    background = bg.getImage();
    gun1=Revolver.getImage();
    gun2=ShotGun.getImage();
    gun3=AR15.getImage();
    
     Gun_1 = new JButton(Revolver);
    Gun_1.setVisible(true);
    Gun_1.setSize(110,379);
    Gun_1.setLocation(100,100);
    Gun_1.setContentAreaFilled(false);
    Gun_1.setFocusPainted(false);
    Gun_1.setBorder(null);
    Gun_1.addActionListener(this);
    this.add(Gun_1);
    
    Gun_2 = new JButton(ShotGun);
    Gun_2.setVisible(true);
    Gun_2.setSize(150,482);
    Gun_2.setLocation(200,100);
    Gun_2.setContentAreaFilled(false);
    Gun_2.setFocusPainted(false);
    Gun_2.setBorder(null);
    Gun_2.addActionListener(this);
    this.add(Gun_2);
    
    Gun_3 = new JButton(AR15);
    Gun_3.setVisible(true);
    Gun_3.setSize(150,471);
    Gun_3.setLocation(400,100);
    Gun_3.setContentAreaFilled(false);
    Gun_3.setFocusPainted(false);
    Gun_3.setBorder(null);
    Gun_3.addActionListener(this);
    this.add(Gun_3);
            
    }
    @Override
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(background, 4, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //gun choosing
        Animating a = new Animating();
        if(ae.getSource() == Gun_1){
            a.myGun++;
            a.Ammo =6;   
        a.Display();
        Choose_Frame.dispose();
        }
        if(ae.getSource() == Gun_2){
            a.myGun = a.myGun+2;
            a.Ammo = 10;
        a.Display();
        Choose_Frame.dispose();
        }
        if(ae.getSource() == Gun_3){
            a.myGun = a.myGun + 3;
            a.Ammo =24;
        a.Display();
        Choose_Frame.dispose();
        }
        //menu
    if(ae.getSource() == menuItem){
    Start_Screen sc = new Start_Screen();
    sc.control = sc.control+1;
          try {
              sc.Display();
          } catch (InterruptedException ex) {
              Logger.getLogger(Choose_Gun.class.getName()).log(Level.SEVERE, null, ex);
          }
    Choose_Frame.dispose();
    }
    }
}
