import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.math.MathUtils;

public class Rock extends BaseActor
{          
    public Rock(float x, float y, Stage s)
    {
       super(x,y,s);
       loadTexture("assets/sprite2.png");
       float random = MathUtils.random(30);       
       setSpeed(70 + random);
       setMaxSpeed(70 + random);
       setDeceleration(0);
       setMotionAngle( MathUtils.random(360) );
    }
    
    public void act(float dt)
    {
        super.act(dt);
        applyPhysics(dt);
        wrapAroundWorld();
    }
}

/*
new Thread(new Runnable() {
            @Override
            public void run() {

                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        
                        //==================================================
                        
                        }
                    }
                });
            }
        }).start();
    }*/
