package net.ariane;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Menu extends ApplicationAdapter {

    private Stage stage;

    @Override
    public void create () {
        stage = new Stage(new ScreenViewport());

        Texture texture = new Texture(Gdx.files.internal("..../assets/background_space.gif"));

        texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        TextureRegion textureRegion = new TextureRegion(texture);
        textureRegion.setRegion(0,0,texture.getWidth()*8,texture.getHeight()*4);
        Image image4 = new Image(textureRegion);
        image4.setSize(200,100);
        image4.setPosition(Gdx.graphics.getWidth()*2/3-image4.getWidth()/2,Gdx.graphics.getHeight()/3-image4.getHeight());
        stage.addActor(image4);

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

    }

}
