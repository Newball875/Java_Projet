package net.ariane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;


public class Menu implements Screen {
    
    private Texture bucketImage2;
    private BitmapFont font ;

    public HighScore(GameScreen game){
        this.game = game;
    }

    public void backToMenu(){
        game.backToMenu();
    }

    public void render(float delta) {
        String str = score.LireFichier()

        batch.begin();
        batch.draw(bucketImage2, 0, 0,900,900);
        font.draw(batch,str, 350, 450);
        batch.end();
        
    }

    public void show() {
        batch = new SpriteBatch();
		font=new BitmapFont();
    }

}