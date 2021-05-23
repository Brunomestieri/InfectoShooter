import java.net.URL;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;
public class BgSound implements Runnable
{           
            public void run() {
                try {
                    String resource = "/assets/bgSoundIndex.wav";
                    InputStream input = getClass().getResourceAsStream(resource);
                    Clip oClip = AudioSystem.getClip();
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(input);
                    oClip.open(audioInput);
 
                    oClip.loop(Clip.LOOP_CONTINUOUSLY);
                    SwingUtilities.invokeLater(new Runnable()
                    {
                        public void run() {
          
                        }
                        });
                    } catch (Exception e) {
                    }          
            }
}