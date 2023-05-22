package net.ariane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends com.badlogic.gdx.Game {

    public void create () {
        changeScreen(new Menu(this));
    }

    public void changeScreen(Screen newScreen){
        Screen oldScreen = getScreen();
        setScreen(newScreen);
        if(oldScreen != null){
            oldScreen.dispose();
        }
    }

    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }

    public void dispose(){

    }
}
