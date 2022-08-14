package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyFirstGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int click;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("ReStart_Logo.jpg");
	}

	@Override
	public void render () {
		float x = Gdx.input.getX() - img.getWidth()/2;
		float y = Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight()/2;

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
			click++;

		Gdx.graphics.setTitle("Мышка нажата "+click + " раз!");




		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		batch.draw(img, x,y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
