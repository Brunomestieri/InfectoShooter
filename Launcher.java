import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Launcher implements Runnable
{
    public void run ()
    {
        Game myGame = new SpaceGame();
        LwjglApplication launcher = new LwjglApplication( myGame, "Infecto Shooter", 800, 600 );
    }
}