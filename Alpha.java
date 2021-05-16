import java.awt.Color;
import javax.swing.JFrame;

public class Alpha {
    public void aplyAlpha(JFrame frame){
        frame.setUndecorated(true); // Tira as bordas
        //frame.setOpacity(0.5f); //Seta alpha em tudo
        frame.setBackground(new Color(0,0,0,0)); // seta cor rgb e alpha no frame
 
}
}
