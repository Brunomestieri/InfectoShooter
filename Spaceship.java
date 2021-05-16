import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;

public class Spaceship extends BaseActor
{
    private Thrusters thrusters;
    private Shield shield;
    public int shieldPower;

    public Spaceship(float x, float y, Stage s)
    {
        super(x,y,s);

        loadTexture( "assets/heropq.png" );
        setBoundaryPolygon(8);

        setAcceleration(2000);
        setMaxSpeed(2000);
        setDeceleration(1000);

        

        thrusters = new Thrusters(0,0, s);
        addActor(thrusters);
        thrusters.setPosition(-thrusters.getWidth(), 
            getHeight()/2 - thrusters.getHeight()/2 );

        shield = new Shield(0,0, s);
        addActor(shield);
        shield.centerAtPosition( getWidth()/2, getHeight()/2 );
        shieldPower = 100;
    }

    public void shoot()
    {
        if ( getStage() == null)
            return;

        Laser laser = new Laser(0,0, this.getStage());
        laser.centerAtActor(this);
        laser.setRotation( this.getRotation() );
        laser.setMotionAngle( this.getRotation() );
    }

    public void warp()
    {
        if ( getStage() == null)
            return;

        Warp warp1 = new Warp(0,0, this.getStage());
        warp1.centerAtActor(this);
        setPosition(MathUtils.random(800), MathUtils.random(600));
        Warp warp2 = new Warp(0,0, this.getStage());
        warp2.centerAtActor(this);
    }

    public void act(float dt)
    {
        super.act( dt );

        float degreesPerSecond = 500; // degrees per second
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

        shield.setOpacity(shieldPower / 100f);
    }

}