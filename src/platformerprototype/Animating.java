package platformerprototype;
/*
ToDO:
- create reload mechanisms for different guns
- Add background noise, such as birds chriping
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.Timer;
import use_audio.Use_Audio;

public class Animating extends JPanel implements ActionListener,MouseListener{

    //constructors
    Timer timer = new Timer(10,this);
    JFrame jf1 = new JFrame();
    JButton Exit_Button ;
    JButton Targot_Button1,Targot_Button2,Targot_Button3,Targot_Button4,Targot_Button5,Targot_Button6;
    ImageIcon SM ;
    ImageIcon Bg ;//background
    //gun images
    ImageIcon My_gun ;
    ImageIcon ShotGun ;
    ImageIcon AR15 ;
    //URL fro images
    URL standingMan = Start_Screen.class.getClassLoader().getResource("Resources/Standing_man.png");
    URL BG = Start_Screen.class.getClassLoader().getResource("Resources/Background_ShootingGame-Final.png");
    URL pistol = Start_Screen.class.getClassLoader().getResource("Resources/Revolver.png");
    URL shotgun = Start_Screen.class.getClassLoader().getResource("Resources/Shot_Gun.png");
    URL ar = Start_Screen.class.getClassLoader().getResource("Resources/AR.png");
    //URL for sounds 
    URL reload = Start_Screen.class.getClassLoader().getResource("Resources/Reload_Audio.wav");
    URL revolverAudio = Start_Screen.class.getClassLoader().getResource("Resources/Pistol.wav");
    URL shotgunAudio = Start_Screen.class.getClassLoader().getResource("Resources/12-Gauge Shotgun.wav");
    URL ar15Audio = Start_Screen.class.getClassLoader().getResource("Resources/AR15.wav");
    Image Gun;
    Image shotty;
    Image AR;
    Image background;
    JLabel Gun_Blast;
    int velocityX = 10;
    int velocityY = 10;
    int Points = 0;
    int Ammo ;
    int startX = 410;
    int startY = 410;
    int endX = 220;
    int endY = 250;
    int VelocityX,VelocityY;
    boolean Reload;
    JFrame Choose_Frame;
    JMenuBar MymenuBar;
    JMenu menu;
    JMenuItem menuItem;//,Stop_Music;
    int myGun=0;
    String Gun_Type;
    
    public void Display(){
    jf1.setSize(608,622);
    jf1.setVisible(true);
    jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf1.setResizable(false);
    jf1.add(this);
    
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
          
         //    Stop_Music = new JMenuItem("Stop Music",KeyEvent.VK_T);
         //   Stop_Music.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));
         //   Stop_Music.getAccessibleContext().setAccessibleDescription("Stop Music");
         //   Stop_Music.addActionListener(this);
        //    menu.add(Stop_Music);
            
            MymenuBar.add(menu);
            jf1.setJMenuBar(MymenuBar);
    
    jf1.repaint();
    }
    
    public void setTargets(){
    // sets up targot 1
        Targot_Button1 = new JButton();
        Targot_Button1.setSize(50,120);
        Targot_Button1.setVisible(true);
        Targot_Button1.setLocation(235,270);
        Targot_Button1.setContentAreaFilled(false);
        Targot_Button1.setBorder(null);
        Targot_Button1.addActionListener(this);
        this.add(Targot_Button1);
        
        // sets up targot 2
        Targot_Button2 = new JButton();
        Targot_Button2.setSize(50,125);
        Targot_Button2.setVisible(true);
        Targot_Button2.setLocation(128,280);
        Targot_Button2.setContentAreaFilled(false);
        Targot_Button2.setBorder(null);
        Targot_Button2.addActionListener(this);
        this.add(Targot_Button2);
        
        // sets up targot 3
        Targot_Button3 = new JButton();
        Targot_Button3.setSize(40,80);
        Targot_Button3.setVisible(true);
        Targot_Button3.setLocation(185,280);
        Targot_Button3.setContentAreaFilled(false);
        Targot_Button3.setBorder(null);
        Targot_Button3.addActionListener(this);
        this.add(Targot_Button3);
        
        // sets up targot 4
        Targot_Button4 = new JButton();
        Targot_Button4.setSize(65,180);
        Targot_Button4.setVisible(true);
        Targot_Button4.setLocation(15,265);
        Targot_Button4.setContentAreaFilled(false);
        Targot_Button4.setBorder(null);
        Targot_Button4.addActionListener(this);
        this.add(Targot_Button4);
        
        // sets up targot 5
        Targot_Button5 = new JButton();
        Targot_Button5.setSize(20,60);
        Targot_Button5.setVisible(true);
        Targot_Button5.setLocation(380,270);
        Targot_Button5.setContentAreaFilled(false);
        Targot_Button5.setBorder(null);
        Targot_Button5.addActionListener(this);
        this.add(Targot_Button5);
        
        // sets up targot 1
        Targot_Button6 = new JButton();
        Targot_Button6.setSize(40,100);
        Targot_Button6.setVisible(true);
        Targot_Button6.setLocation(465,280);
        Targot_Button6.setContentAreaFilled(false);
        Targot_Button6.setBorder(null);
        Targot_Button6.addActionListener(this);
        this.add(Targot_Button6);
    
    }
    
    public Animating(){
        
       setTargets();
       //URLs
       Bg = new ImageIcon(BG);
       SM = new ImageIcon(standingMan);
       
       My_gun = new ImageIcon(pistol);
       ShotGun = new ImageIcon(shotgun);
       AR15 = new ImageIcon(ar);
        //sets up the exit button
        Exit_Button = new JButton(SM);//SM
        Exit_Button.setSize(60,115);
        Exit_Button.setVisible(true);
        Exit_Button.setLocation(0,500);
        Exit_Button.setContentAreaFilled(false);
        Exit_Button.setFocusPainted(false);
        Exit_Button.setBorder(null);
        Exit_Button.addActionListener(this);
        this.add(Exit_Button);
    //sets crosshair cursor
    this.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
    this.setBackground(Color.BLACK);
    //images
    background= Bg.getImage();
    Gun = My_gun.getImage();
    shotty = ShotGun.getImage();
    AR = AR15.getImage();
    this.addMouseListener(this);
    this.setLayout(null);
    timer.start();
    validate();
    }
    
    public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(background,0,0,this);
    //if statements to select gun
                 if(myGun ==1){
                 g.drawImage(Gun,400,450,this);    
                }
                 if(myGun == 2){
                  g.drawImage(shotty,400,450,this);
                }
                 if(myGun == 3){
                  g.drawImage(AR,400,450,this);
                }
    
    repaint();
    timer.restart();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Use_Audio ua = new Use_Audio();
       // Start_Screen myStart = new Start_Screen();
        
     //  if(ae.getSource() == Stop_Music){
    //   myStart.stopmusic = true;
     //  }
        
         if(ae.getSource() == menuItem){
    Start_Screen sc = new Start_Screen();
    sc.control = sc.control+1;
          try {
              sc.Display();
          } catch (InterruptedException ex) {
              Logger.getLogger(Choose_Gun.class.getName()).log(Level.SEVERE, null, ex);
          }jf1.dispose();}
        
        //Targot button
        if(ae.getSource()==Targot_Button1 ||ae.getSource()==Targot_Button2||ae.getSource()==Targot_Button3||ae.getSource()==Targot_Button4||ae.getSource()==Targot_Button5||ae.getSource()==Targot_Button6){
           Shoot();
            Points++;
        }
        //Exit Button
         if(ae.getSource()==Exit_Button){
             //Gun shot
             try {
                 if(myGun ==1){
            ua.PlayAudio(revolverAudio);
                    }
                 if(myGun == 2){
                  ua.PlayAudio(shotgunAudio);
                    }
                 if(myGun == 3){
                  ua.PlayAudio(ar15Audio);
                    }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERROR#1\nAudio Failed to play");
        }
             //Scream
         try {
            ua.playAudio("G:\\ShooterGame\\Sound\\The Screaming Sheep (Original Upload).wav");
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERROR#2\nAudio Failed to play");
        }
             JOptionPane.showMessageDialog(null,"Thankyou for playing!\nPoints: "+Points);
         System.exit(0);
         }
    //the repaint method is built in and repaints everytime the method is executed...giving it a moving effect
       repaint();
    }
    
    public boolean Needreload(){
       
         if(Ammo<=0){
           Reload=true;
             }else{Reload = false;}
   
    return Reload;
    }
    
    public void reload(){
        Use_Audio ua = new Use_Audio();
        String User_Points;
    Reload = false;
        try {
            ua.PlayAudio(reload);
        Ammo++; 
        User_Points = Integer.toString(Points);
        jf1.setTitle("Points: "+User_Points+" Ammo: "+Ammo);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERROR#2\nAudio Failed to play");
        }
 
    }
    public void Shoot(){
        //starts here
         Use_Audio ua = new Use_Audio();
         Choose_Gun cg = new Choose_Gun();
        String User_Points;
        //ammo decreases and if relaod is false it plays the gun shot sound
        // otherwise it plays the reload sound and points remain stagnent
        Ammo--;
        if(Needreload() == false){
        try {
        if(myGun ==1){
            ua.PlayAudio(revolverAudio);
                }
                 if(myGun == 2){
                  ua.PlayAudio(shotgunAudio);
                }
                 if(myGun == 3){
                  ua.PlayAudio(ar15Audio);
                }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERROR#1\nAudio Failed to play");
        }}
        else{
        try {
        ua.PlayAudio(reload);
        Points--;
        JOptionPane.showMessageDialog(null,"Right Click to RELOAD!!!");
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERROR#2\nAudio Failed to play");
        }
        }
        //sets the frames titles to the points everytime it is executed
        User_Points = Integer.toString(Points);
        jf1.setTitle("Points: "+User_Points+" Ammo: "+Ammo);
        //ends here
            
        
    }
    
    public int AmmoControl(){
        if(myGun ==1){
              if(Ammo<=0){
                 Ammo = 0;
                          }
                   if(Ammo>=6){
                              Ammo = 6;
                                  }}
        if(myGun == 2){
                     if(Ammo<=0){
                        Ammo = 0;
                               }
                        if(Ammo>=10){
                                 Ammo = 10;
                                      }}
        if(myGun == 3){
                  if(Ammo<=0){
                      Ammo = 0;
                           }
                       if(Ammo>=24){
                           Ammo = 24;
                                       }}
        
  
    return Ammo;
    }
    
    @Override
    public void mouseClicked(MouseEvent me){        
    System.out.println("Event_clicked");
   
    AmmoControl();
    // when gun is shot: 
    if(me.getButton() == 1){
        Shoot();
    }else if(me.getButton() == 3||me.getButton() == 2){
      reload();
        }
    System.out.println("You clicked the ffg Button: "+ me.getButton()+"\nPoints: "+Points);
    

    }
    
    @Override
    public void mousePressed(MouseEvent me) {
   System.out.println("Event_pressed");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    System.out.println("Event_released");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    System.out.println("Event_entered");
    }

    @Override
    public void mouseExited(MouseEvent me) {
   System.out.println("Event_exited");
    }  
   
    
}