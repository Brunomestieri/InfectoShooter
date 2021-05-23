import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import javax.swing.*;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;

public class LevelScreen extends BaseScreen
{
    private Spaceship spaceship;
    Sound col;
    int score;
    Label scoreLabel;
    Label gameOverMessage;
    Label score2;
    Tempo tempo = new Tempo();
    boolean gameOver;
    public void initialize() 
    {        
        BaseActor space = new BaseActor(0,0, mainStage);
        space.loadTexture( "assets/fundo.png" );
        space.setSize(800,600);
        BaseActor.setWorldBounds(space);
        spaceship = new Spaceship(300,200, mainStage);
        
        
        
        //========================================================================
            new Thread(new Runnable() {
            @Override
            public void run() {

                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        new Rock(200,100, mainStage);
                        new Rock(200,300, mainStage);
                        new Rock(200,500, mainStage);
                        new Rock(400,500, mainStage);
                        new Rock(600,500, mainStage);
                        new Rock(600,300, mainStage);
                        new Rock(600,100, mainStage);
                        new Rock(400,100, mainStage);
                        new Rock(200,100, mainStage);
                        new Rock(200,300, mainStage);
                        new Rock(200,100, mainStage);
                        new Rock(200,300, mainStage);
                        new Rock(200,500, mainStage);
                        new Rock(400,500, mainStage);
                        new Rock(600,500, mainStage);
                        new Rock(600,300, mainStage);
                        new Rock(600,100, mainStage);
                        new Rock(400,100, mainStage);
                        new Rock(200,100, mainStage);
                        new Rock(200,300, mainStage);
                        new Rock(200,100, mainStage);
                        new Rock(200,300, mainStage);
                        new Rock(200,500, mainStage);
                        new Rock(400,500, mainStage);
                        new Rock(600,500, mainStage);
                        new Rock(600,300, mainStage);
                        new Rock(600,100, mainStage);
                        new Rock(400,100, mainStage);
                        new Rock(200,100, mainStage);
                        new Rock(200,300, mainStage);
                        new Rock(200,100, mainStage);
                        new Rock(200,300, mainStage);
                        new Rock(200,500, mainStage);
                        new Rock(400,500, mainStage);
                        new Rock(600,500, mainStage);
                        new Rock(600,300, mainStage);
                        new Rock(600,100, mainStage);
                        new Rock(400,100, mainStage);
                        new Rock(200,100, mainStage);
                        new Rock(200,300, mainStage);
                    }
                
                });
            }
        }).start();
    
        
    
    
    
    //=============================================================================

        gameOver = false;
        score = 0;
        score2 = new Label ("Vírus Neutralizados: " + score, BaseGame.labelStyle );
        score2.setPosition( 20, 50 );
        scoreLabel = new Label( "Pontuaçao: " + score , BaseGame.labelStyle );
        scoreLabel.setPosition( 20, 520 );
        uiStage.addActor(scoreLabel);
        uiStage.addActor(score2);
        
        gameOverMessage = new Label( "", BaseGame.labelStyle );
        gameOverMessage.setPosition( 20, 50 );
        uiStage.addActor(gameOverMessage);
        gameOverMessage.setVisible(false);
        Gdx.graphics.setTitle("=== Infecto Shooter ===");
        col      = Gdx.audio.newSound(Gdx.files.internal("assets/col.wav"));
    }
    
    public void update(float dt)
    {
        
        for ( BaseActor rockActor : BaseActor.getList(mainStage, "Rock") )
        {
            
          
            for ( BaseActor laserActor : BaseActor.getList(mainStage, "Laser") )
            {
                if (laserActor.overlaps(rockActor))
                {
                    Explosion boom = new Explosion(0,0, mainStage);
                    boom.centerAtActor(rockActor);
                    laserActor.remove();
                    rockActor.remove();
                    score++;
                    scoreLabel.setText( "Pontuaçao: " + Integer.toString(score*tempo.getMult()) );
                    score2.setText( "Vírus Neutralizados: " + score );;
                    System.out.println("tempo + score" + tempo.getMult() + score);
                    col.play();
                }
            }
        }
        
        if ( !gameOver && BaseActor.count(mainStage, "Rock") == 0 )
        {
            
            if(score*tempo.getMult() >= 0)
            {
            BaseActor messageWin = new BaseActor(0,0, uiStage);
            messageWin.loadTexture("assets/message-win2.png");
            messageWin.centerAtPosition(400,300);
            messageWin.setOpacity(0);
            messageWin.addAction( Actions.fadeIn(1) );
            gameOver = true;
            score2.setVisible(false);
            gameOverMessage.setVisible(true);
            scoreLabel.setVisible(false);
            gameOverMessage.setText( "GANHOOU!!! " + Integer.toString(score*tempo.getMult()) + " pontos!" );
            }
            
        else
        
        {
            BaseActor messageLose = new BaseActor(0,0, uiStage);
                    messageLose.loadTexture("assets/message-lose2.png");
                    messageLose.centerAtPosition(400,300);
                    messageLose.setOpacity(0);
                    messageLose.addAction( Actions.fadeIn(1) );
                    gameOver = true;
            
            gameOverMessage.setVisible(true);
            score2.setVisible(false);
            scoreLabel.setVisible(false);
            gameOverMessage.setText( "Perdeu!!! " + Integer.toString(score*tempo.getMult()) + " pontos!" );
        
        }
            
        }
    }
    // override default InputProcessor methods
    public boolean keyDown(int keycode)
    {
        if ( keycode == Keys.SPACE )
            spaceship.shoot();
            
        return false;  
    }

}

