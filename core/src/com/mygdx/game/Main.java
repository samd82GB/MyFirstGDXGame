package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.screen.MenuScreen;

public class Main  extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
    @Override
    public void render (){

    };

    @Override
    public void setScreen(Screen screen) {
        super.setScreen(screen);
    }



    @Override
    public void dispose() {
        super.dispose();
    }
}
