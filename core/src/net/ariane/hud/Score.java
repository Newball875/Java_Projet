package net.ariane.hud;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score {
    public int score;
    public int bestScore=0;

    public Score(){
        score = 0 ;
        String str = LireFichier();
        int s = Integer.parseInt(str);
        bestScore= s ;
    }

    public void add(int addscore){
        score = score + addscore ;
    }

    //Dessine le score actuel du joueur
    public void draw(BitmapFont font, SpriteBatch batch){
        String motScore = "Score : " + this.score ;
        font.draw(batch, motScore , 350, 835);
    }

    public void highScore(){
        if(this.score>=this.bestScore){
            this.bestScore=this.score ;
        }
    }

    //Dessine le meilleur score du joueur
    public void drawBestScore(BitmapFont font, SpriteBatch batch){
        String motBestScore = "Best Score : " + this.bestScore ;
        font.draw(batch, motBestScore , 10, 30);
    }

    public String LireFichier(){
      FileHandle file=Gdx.files.local("BestScore.json");
      String text=file.readString();
      return text;
    }

    public void EcrireFichier(){
    FileHandle file=Gdx.files.local("BestScore.json");
      String text=""+this.bestScore;
      file.writeString(text, false);
    }
}
