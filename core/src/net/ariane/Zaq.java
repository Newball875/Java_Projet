package net.ariane;

import com.badlogic.gdx.ApplicationAdapter;

public class Zaq extends ApplicationAdapter {

    ArianeGame arianeGame = new ArianeGame();
    Menu menu = new Menu();
    ApplicationAdapter scene;

    public void create () {
         this.scene = menu ;
    }

    public void render() {
        this.scene.render();
    }

    public void changeScene(){
        if(this.scene==menu){
            this.scene=arianeGame;
        }
        if(this.scene==arianeGame){
            this.scene=menu;
        }
    }
}
