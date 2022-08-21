package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyFirstGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
//	Texture img;
	int click;
	Anime anime;
	int count=0;
	boolean dir = false;


	@Override
	public void create () {
		batch = new SpriteBatch();
		//img = new Texture("ReStart_Logo.jpg");
		anime = new Anime("boldbaby.png", 9, 4, Animation.PlayMode.LOOP);
	}

	@Override
	public void render () {

		// Вводим данные по времени для анимации, равные времени между фреймами
		anime.setTime(Gdx.graphics.getDeltaTime());

		//Координаты перемещения рисунка
		//привязка мышки к центру рисунка
//		float x = Gdx.input.getX() - anime.getFrame().getRegionWidth()/2;
//		float y = Gdx.graphics.getHeight() - Gdx.input.getY() - anime.getFrame().getRegionHeight()/2;

		//Привязать перемещение рисунка дельте по времени
		int border = Gdx.graphics.getWidth()-anime.getFrame().getRegionWidth();


 		float x = 0;
		float y = 0;//Gdx.graphics.getHeight() - anime.getFrame().getRegionHeight();

		if (!dir) {
			if (count<border) {
				count++;

			}
			if (count>=border){
				dir = true;
//
			}
		}
		if (dir) {
			if (count<=border) {
				count--;
			}
			if (count ==0) {
				dir = false;

			}
		}
		//если идём вправо и повёрнут, то поворачиваем ещё раз
		if (!dir&&anime.getFrame().isFlipX()) {
			anime.getFrame().flip(true, false);
		}
		//если идём влево и не повёрнут, то поворачиваем
		if (dir&&!anime.getFrame().isFlipX()){
			anime.getFrame().flip(true, false);
		}

//		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
//			click++;

//		Gdx.graphics.setTitle("Мышка нажата "+click + " раз!");




		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		batch.draw(anime.getFrame(),x+count,y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		anime.dispose();
	}
}
