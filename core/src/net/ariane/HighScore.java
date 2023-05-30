package net.ariane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import net.ariane.hud.Score;


public class HighScore implements Screen {
    
    private BitmapFont font;
    private Texture bucketImage2;
    private GameScreen game;
    private SpriteBatch batch;
    private Score score;

    public HighScore(GameScreen game){
        this.game = game;
    }

    public void backToMenu(){
        game.backToMenu();
    }

    public void render(float delta) {
        String str = score.LireFichier() ;

        batch.begin();
        batch.draw(bucketImage2, 0, 0,900,900);
        font.draw(batch,str, 350, 450);
        batch.end();

    }

    public void show() {
        bucketImage2 = new Texture(Gdx.files.internal("background_space.png"));
        score=new Score();
        batch = new SpriteBatch();
		font=new BitmapFont();
    }

    @Override
    public void resize(int width, int height) {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {
        
    }

}