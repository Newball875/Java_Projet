package net.ariane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import net.ariane.hud.Score;


public class HighScore implements Screen {
    
    private Texture bucketImage2;
    private BitmapFont font ;
    private GameScreen game ;
    private SpriteBatch batch ;
    private Score score;
    private ShapeRenderer shape;

    public HighScore(GameScreen game){
        this.game = game;
    }

        public void render(float delta) {
        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>300 && Gdx.input.getX()<500) && (Gdx.graphics.getHeight()-Gdx.input.getY()>300 && Gdx.graphics.getHeight()-Gdx.input.getY()<400))) backToMenu();


        String str = score.LireFichier() ;
        batch.begin();
        batch.draw(bucketImage2, 0, 0,900,900);
        font.draw(batch,str, 350, 450);
        batch.end();

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);
        shape.rect(300,300,200,100);
        shape.end();

    }

    public void show() {
        bucketImage2 = new Texture(Gdx.files.internal("background_space.png"));
        batch = new SpriteBatch();
		font=new BitmapFont();
        shape=new ShapeRenderer();
        score=new Score();
    }

    public void backToMenu(){
        //game.backToMenu();
        game.changeScreen(new ArianeGame(game,0));
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
        bucketImage2.dispose();
        batch.dispose();
        font.dispose();
    }

}