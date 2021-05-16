import java.util.Timer;
import java.util.TimerTask;
public class Tempo
{
    Timer timer1 = new Timer();
    private int multiplicador = 30;
    
    public void setMultiplicador(int multiplicador){
        this.multiplicador = multiplicador;
    }
    
    public Tempo()
    {
        
    
        int delay = 1000;
        int interval = 1000;      

        timer1.scheduleAtFixedRate(new TimerTask() 
        {public void run() {multiplicador--;
        
        
        }}, delay, interval);
    
    

    }
        
    
    public int getMult(){
        return multiplicador;
    }
}
