package net.ariane;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;


public class Select implements Screen {
    private Texture bucketImage;
    private Texture bucketImage2;
    private Music rainMusic;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Rectangle bucket;
    private Rectangle bucket2;
    private Array<Rectangle> raindrops;
    private long lastDropTime;
    private TextureRegion backgroundTexture;
    private Zaq game ;
    private float f=0 ;

    private Color color;

    ShapeRenderer shape;

    private Menu menu ;

    public Select(Zaq game){
        this.game = game;
    }

    public void create(){
        menu = new Menu(this.game);
        backToMenu();
    }

    public void backToMenu(){
        game.setScreen(menu);
    }

    private void spawnRaindrop() {
        Rectangle raindrop = new Rectangle();
        raindrop.x = MathUtils.random(0, 800-64);
        raindrop.y = 480;
        raindrop.width = 64;
        raindrop.height = 64;
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        batch.begin();

        batch.draw(bucketImage2, 0, 0,900,900);
        batch.end();

        shape.begin(ShapeRenderer.ShapeType.Filled);

        shape.setColor(color.GREEN);

        shape.rect(100,600,200,200);
        shape.rect(500,600,200,200);

        shape.setColor(color.BLUE);

        shape.rect(100,400,200,200);
        shape.rect(500,400,200,200);

        shape.setColor(color.RED);

        shape.rect(300,100,200,200);

        shape.end();

        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>100 && Gdx.input.getX()<300) && (Gdx.graphics.getHeight()-Gdx.input.getY()>600 && Gdx.graphics.getHeight()-Gdx.input.getY()<800))) game.changeScreen(new ArianeGame(game,0));
        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>500 && Gdx.input.getX()<700) && (Gdx.graphics.getHeight()-Gdx.input.getY()>600 && Gdx.graphics.getHeight()-Gdx.input.getY()<800))) game.changeScreen(new ArianeGame(game,1));

        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>100 && Gdx.input.getX()<300) && (Gdx.graphics.getHeight()-Gdx.input.getY()>400 && Gdx.graphics.getHeight()-Gdx.input.getY()<600))) game.changeScreen(new ArianeGame(game,2));
        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>500 && Gdx.input.getX()<700) && (Gdx.graphics.getHeight()-Gdx.input.getY()>400 && Gdx.graphics.getHeight()-Gdx.input.getY()<600))) game.changeScreen(new ArianeGame(game,3));

        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>300 && Gdx.input.getX()<500) && (Gdx.graphics.getHeight()-Gdx.input.getY()>100 && Gdx.graphics.getHeight()-Gdx.input.getY()<300))) game.changeScreen(new ArianeGame(game,4));
    }

    @Override
    public void show() {
        bucketImage = new Texture(Gdx.files.internal("menu.png"));
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

        raindrops = new Array<Rectangle>();
        spawnRaindrop();
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
        bucketImage.dispose();
        bucketImage2.dispose();
        rainMusic.dispose();
        batch.dispose();
    }
}
