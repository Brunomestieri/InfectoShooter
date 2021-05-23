import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;

public class Spaceship extends BaseActor
{
    private Thrusters thrusters;
    public int shieldPower;
    Sound laserSound;

    public Spaceship(float x, float y, Stage s)
    {
        super(x,y,s);

        loadTexture( "assets/heropq.png" );
        setBoundaryPolygon(8);

        setAcceleration(1000);
        setMaxSpeed(1000);
        setDeceleration(1000);

        

        thrusters = new Thrusters(0,0, s);
        addActor(thrusters);
        thrusters.setPosition(-thrusters.getWidth(), 
        getHeight()/2 - thrusters.getHeight()/2 );
        laserSound      = Gdx.audio.newSound(Gdx.files.internal("assets/laser.wav"));
    }

    public void shoot()
    {
        if ( getStage() == null)
            return;

        Laser laser = new Laser(0,0, this.getStage());
        laser.centerAtActor(this);
        laser.setRotation( this.getRotation() );
        laser.setMotionAngle( this.getRotation() );
        laserSound.play();
    }

    
    public void act(float dt)
    {
        super.act( dt );

        float degreesPerSecond = 350; // degrees per second
        if (Gdx.input.isKeyPressed(Keys.LEFT)) 
            rotateBy(degreesPerSecond * dt);
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            rotateBy(-degreesPerSecond * dt);

        if (Gdx.input.isKeyPressed(Keys.UP)) 
        {
            accelerateAtAngle( getRotation() );
            thrusters.setVisible(true);
        }
        else
        {
            thrusters.setVisible(false);
        }

        applyPhysics(dt);

        wrapAroundWorld();

        //shield.setOpacity(shieldPower / 100f);
    }

}