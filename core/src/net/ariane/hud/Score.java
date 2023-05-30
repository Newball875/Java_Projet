package net.ariane.hud;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score {
    public int score;
    public int bestScore=0;

    public Score(){
        score = 0 ;
    }

    public void add(int addscore){
        score = score + addscore ;
    }

    //Dessine le score actuel du joueur
    public void draw(BitmapFont font, SpriteBatch batch){
        String motScore = "Score : " + this.score ;
        font.draw(batch, motScore , 350, 835);
    }

    public highScore(score){
        if(this.score>=this.bestScore){
            this.bestScore=this.score ;
        }
    }

    //Dessine le meilleur score du joueur
    public void drawBestScore(BitmapFont font, SpriteBatch batch){
        String motBestScore = "Best Score : " + this.bestScore ;
        font.draw(batch, motBestScore , 10, 10);
    }
}
