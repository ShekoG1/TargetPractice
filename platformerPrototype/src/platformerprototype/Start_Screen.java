/*
* Audio for guns
 */
package platformerprototype;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import use_audio.Use_Audio;

public class Start_Screen extends JPanel implements ActionListener{
    
    JLabel credits = new JLabel("Target Practice by Shekhar Maharaj - Instagram: @gamerforever29 - GitHub: @ShekoG1");
    JButton startButton,exitButton,ChooseGun;
    ImageIcon bg ;
    Image Background;
   //  boolean stopmusic=false;
    URL resource = Start_Screen.class.getClassLoader().getResource("Resources/Start_ScreenBG.png");
    
    JFrame Start_Frame = new JFrame();
     int control=0;
     JMenuItem Stop_Music;
     JMenuItem returnTostart;
     JMenu menu;
     JMenuBar MymenuBar;
    
    public Start_Screen(){
        this.setLayout(null);
        bg = new ImageIcon(resource);
    Background = bg.getImage();
    startButton = new JButton("START");
    startButton.setLocation(100,170);
    startButton.setSize(100,40);
    startButton.setContentAreaFilled(false);
    startButton.setForeground(Color.WHITE);
    startButton.addActionListener(this);
    exitButton = new JButton("EXIT");
    exitButton.setLocation(400,170);
    exitButton.setVisible(true);
    exitButton.setSize(100,40);
    exitButton.setContentAreaFilled(false);
    exitButton.setForeground(Color.WHITE);
    exitButton.addActionListener(this);
    credits.setVisible(true);
    credits.setSize(500,100);
    credits.setLocation(80,500);
    credits.setForeground(Color.WHITE);
    this.add(credits);
        
    this.add(startButton);
    this.add(exitButton);
    }
    
    public void Display() throws InterruptedException{
        Thread thread = new Thread(new BG_Music());
        if(control <= 0){
       thread.start();}
        else{thread.stop();}
    
    Start_Frame.setSize(608,622);
    Start_Frame.setVisible(true);
    Start_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Start_Frame.setResizable(false);
    Start_Frame.add(this);
    
       MymenuBar = new JMenuBar();
             Start_Frame.setJMenuBar(MymenuBar);
        menu = new JMenu("Options");
            menu.addActionListener(this);
            menu.setMnemonic(KeyEvent.VK_A);
            menu.getAccessibleContext().setAccessibleDescription("This is the only menu in the prorgam that has menu items");
          
        Stop_Music = new JMenuItem("Stop Music",KeyEvent.VK_T);
            Stop_Music.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.ALT_MASK));
            Stop_Music.getAccessibleContext().setAccessibleDescription("Stop Music");
            Stop_Music.addActionListener(this);
            menu.add(Stop_Music);
            
            MymenuBar.add(menu);
           
    
            Start_Frame.repaint();
    }
    
    public void paintComponent(Graphics g){
    g.drawImage(Background, 0, 0,this);
    
    repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
   if(ae.getSource() == startButton){
   Choose_Gun cg = new Choose_Gun();
   cg.Display();
   Start_Frame.dispose();
   }
   
   if(ae.getSource() == exitButton){
   System.exit(0);
   }
    }
    
   class BG_Music implements Runnable{
      Use_Audio ua;
     
   public void run(){
      
       control++;
       ua = new Use_Audio();
       try{
   ua.playAudio("G:\\ShooterGame\\Sound\\THE BANJO BEAT - RICKY DESKTOP.wav");}
       catch (Exception e) {
        JOptionPane.showMessageDialog(null,"ERROR#1\nAudio Failed to play");
        }
    //   if(stopmusic == true){
  //     ua.StopAudio();
  //     }
   }
   }
}
