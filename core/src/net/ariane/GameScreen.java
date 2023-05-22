package net.ariane;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen extends com.badlogic.gdx.Game {

    public void create () {
        backToMenu();
    }

    public void changeScreen(Screen newScreen){
        Screen oldScreen = getScreen();
        if(oldScreen != null){
            oldScreen.dispose();
        }
        setScreen(newScreen);
    }

    public void backToMenu () {
        changeScreen(new Menu(this));
    }

    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }

    public void dispose(){

    }
}