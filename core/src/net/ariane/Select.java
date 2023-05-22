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
    private GameScreen game ;
    private float f=0 ;
    BitmapFont font;

    private Color color;

    ShapeRenderer shape;

    private Menu menu ;

    public Select(GameScreen game){
        this.game = game;
    }

    public void create(){
        menu = new Menu(this.game);
        backToMenu();
    }

    public void backToMenu(){
        game.setScreen(menu);
    }

    public void creerBouton(int x, int y, Color color, ShapeRenderer shape){
        shape.setColor(color);
        shape.rect(x,y,200,200);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        batch.begin();

        batch.draw(bucketImage2, 0, 0,900,900);
        batch.end();

        batch.begin();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        

        creerBouton(100,600,Color.GREEN,shape);
        creerBouton(500,600,Color.GREEN,shape);

        creerBouton(100,400,Color.BLUE,shape);
        creerBouton(500,400,Color.BLUE,shape);

        creerBouton(300,100,Color.RED,shape);


        shape.end();
        batch.end();    
        if(Gdx.input.isButtonPressed(0)){
            if(Gdx.input.getX()>100 && Gdx.input.getX()<300){
                if(Gdx.graphics.getHeight()-Gdx.input.getY()>600 && Gdx.graphics.getHeight()-Gdx.input.getY()<800){
                    game.changeScreen(new ArianeGame(game,0));
                }
                if(Gdx.graphics.getHeight()-Gdx.input.getY()>400 && Gdx.graphics.getHeight()-Gdx.input.getY()<600){
                    game.changeScreen(new ArianeGame(game,2));
                }
            }
            if(Gdx.input.getX()>500 && Gdx.input.getX()<700){
                if(Gdx.graphics.getHeight()-Gdx.input.getY()>600 && Gdx.graphics.getHeight()-Gdx.input.getY()<800){
                    game.changeScreen(new ArianeGame(game,1));
                }
                if(Gdx.graphics.getHeight()-Gdx.input.getY()>400 && Gdx.graphics.getHeight()-Gdx.input.getY()<600){
                    game.changeScreen(new ArianeGame(game,3));
                }
            }
            if(Gdx.input.getX()>300 && Gdx.input.getX()<500){
                if((Gdx.graphics.getHeight()-Gdx.input.getY()>100 && Gdx.graphics.getHeight()-Gdx.input.getY()<300)){
                    game.changeScreen(new ArianeGame(game,4));
                }
            }
        }
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
        bucketImage.dispose();
        bucketImage2.dispose();
        rainMusic.dispose();
        batch.dispose();
    }
}
