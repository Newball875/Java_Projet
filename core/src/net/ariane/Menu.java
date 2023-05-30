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
    private GameScreen game ;
    private float f=0 ;


    public Menu(GameScreen game){
        this.game = game;
    }

    public void backToMenu(){
        game.backToMenu();
    }

    public void creerBouton(int x, int y, String image, SpriteBatch batch){
        Texture texture=new Texture((Gdx.files.internal("menu/"+image)));
        batch.draw(texture,x,y);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        batch.begin();

        batch.draw(bucketImage2, 0, 0,900,900);
        batch.end();

        if(Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

        }

        batch.begin();
        creerBouton(150,635,"Play.png",batch);
        creerBouton(150,515,"Select.png",batch);
        creerBouton(150,395,"High-Score.png",batch);
        creerBouton(150, 275, "Quit.png", batch);
        batch.end();

        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>375 && Gdx.input.getX()<475) && (Gdx.graphics.getHeight()-Gdx.input.getY()>635 && Gdx.graphics.getHeight()-Gdx.input.getY()<735))) game.changeScreen(new ArianeGame(game,0));//PLay
        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>375 && Gdx.input.getX()<475) && (Gdx.graphics.getHeight()-Gdx.input.getY()>515 && Gdx.graphics.getHeight()-Gdx.input.getY()<615))) game.changeScreen(new Select(game));//Select
        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>375 && Gdx.input.getX()<475) && (Gdx.graphics.getHeight()-Gdx.input.getY()>395 && Gdx.graphics.getHeight()-Gdx.input.getY()<495))) game.changeScreen(new HighScore(game));//High-Score
        if(Gdx.input.isButtonPressed(0) && ((Gdx.input.getX()>375 && Gdx.input.getX()<475) && (Gdx.graphics.getHeight()-Gdx.input.getY()>275 && Gdx.graphics.getHeight()-Gdx.input.getY()<375))) System.exit(1);//Quit
        
        if(bucket.x < 0) bucket.x = 0;
        if(bucket.x > 800 - 64) bucket.x = 800 - 64;
    }

    @Override
    public void show() {
        bucketImage = new Texture(Gdx.files.internal("menu.png"));
        bucketImage2 = new Texture(Gdx.files.internal("background_space.png"));

        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("musique_epic.mp3"));

        rainMusic.setLooping(true);
        rainMusic.play();

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
