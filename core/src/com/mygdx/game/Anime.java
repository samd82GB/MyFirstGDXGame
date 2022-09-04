package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Anime {
//    private Texture img;
    private TextureAtlas atlas;
    private Animation<TextureRegion> anime;
    private float time;

    public Anime (String name, int columns, int rows, Animation.PlayMode playMode) {
//        img = new Texture(name);
        atlas = new TextureAtlas("atlas/03_lesson_.atlas");
//        TextureRegion region0 = new TextureRegion(img);
//
//        int xCnt = region0.getRegionWidth()/columns;
//        int yCnt = region0.getRegionHeight()/rows;
//
//        TextureRegion[][] regions0 = region0.split(xCnt,yCnt);
//        //TextureRegion[] regions1 = new TextureRegion[regions0.length*regions0[0].length];
//        TextureRegion[] regions1 = new TextureRegion[regions0[rows-1].length];
//
//        int cnt = 0;
//        //for (int i = 0; i< regions0.length; i++) {
//            for (int j=0; j<regions0[rows-1].length;j++) {
//                regions1[cnt++]=regions0[rows-1][j];
//            }
//      //  }

        anime = new Animation<TextureRegion>(1/2f,atlas.findRegions("run"));

        anime.setPlayMode(playMode);

        time+= Gdx.graphics.getDeltaTime();
    }

    public TextureRegion getFrame () {
        return anime.getKeyFrame(time);
    }

    public void setTime (float time) {
        this.time+=time;
    }

    public void zeroTime () {
        this.time = 0;
    }

    public boolean isAnimationOver () {
      return  anime.isAnimationFinished(time);
    }

    public void setPlayMode (Animation.PlayMode playMode) {
        anime.setPlayMode(playMode);
    }
//    public void dispose () {
//        img.dispose();
//    }
    public void dispose () {
        atlas.dispose();
    }

}
