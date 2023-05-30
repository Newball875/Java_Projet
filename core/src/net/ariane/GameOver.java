package net.ariane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;


public class GameOver implements Screen {
    private Texture bucketImage;
    private Texture bucketImage2;
    private Music rainMusic;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Rectangle bucket;
    private Rectangle bucket2;
    private TextureRegion backgroundTexture;
    private GameScreen game ;
    private float f=0 ;

    private Color color;

    ShapeRenderer shape;

    BitmapFont font;

    public GameOver(GameScreen game){
        this.game = game;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        batch.begin();

        batch.draw(bucketImage2, 0, 0,900,900);
        font.draw(batch,"GAME OVER", 350, 450);

        batch.end();

        shape.begin(ShapeRenderer.ShapeType.Filled);

        shape.setColor(color.RED);

        shape.rect(300,300,200,100);
        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>300 && Gdx.input.getX()<500) && (Gdx.graphics.getHeight()-Gdx.input.getY()>300 && Gdx.graphics.getHeight()-Gdx.input.getY()<400))) game.changeScreen(new Menu(game));

        shape.end();

    }

    @Override
    public void show() {
        bucketImage2 = new Texture(Gdx.files.internal("background_space.png"));

        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("musique_epic.mp3"));

        rainMusic.setLooping(true);
        rainMusic.play();

        shape=new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();

        bucket = new Rectangle();
        bucket.x = 300;
        bucket.y = 150;
        bucket.width = 64;
        bucket.height = 64;
        bucket2 = new Rectangle();
        bucket2.x = 800 / 2 - 64 / 2;
        bucket2.y = 200;

        font = new BitmapFont();
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
        rainMusic.dispose();
        batch.dispose();
    }
}
