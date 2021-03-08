package platformerprototype;

public class PlatformerPrototype {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException  {
       
       Start_Screen ss = new Start_Screen();
       ss.Display();
    }
    
}
/*
WHAT YOU SHOULD KNOW:
- About the Gun mechanics - myGun (int):
    - The guns sounds are controlled using the myGun int. This is done because 
    changing the string variable to the correct url for the gun sound does not work.
    I assume that its because the string does not register that the change has 
    been made or because it reverts back to the original value or something like that... I really dont know.
    How ever using the int as a control variable does.
      - You will notice that I also use an int variable to control the background music.
         - The choose gun screen/class is purely for choosing the gun as well as  maing the code a whole lot more
    understandable by sperating the choosing mechanics from the actual shooting mechanics in the Animating class.
- Music(Youtube to mp3,mp3 to .wav):
    -I have created and imported my own project that allows me to use all of the sounds that I have used here simply
    by calling the playAudio(String) method from my UseAudio project, 
    which you can find on my github account(ShekoG1).

- Code for transparent button:
I knew there had to be a way to make it rtansparetn...so I googled it
Thank god for stackoveflow ;)

https://stackoverflow.com/questions/4585867/transparent-jbutton/4586003
answered Jan 3 '11 at 16:01 by camickr

- Audio controls to be fixed soon!
*/