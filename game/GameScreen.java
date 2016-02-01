package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen{
	TryingGame game;
	KidMovement mv;

	SpriteBatch batch;
	public Texture textureTest;
	public Texture textureSwitch;
	public Sprite spriteTest;
	public Sprite spriteSwitch;
	Vector2 position;
	public float xp;
	public float yp;
	boolean sw;
	
	
	public GameScreen(TryingGame game){
		this.game = game;
		
		
	}
	public void create () {

	}
	@Override
	public void show() {

		batch = new SpriteBatch();
		textureTest = new Texture(Gdx.files.internal("Kid-standing_Foreward.png"));
		textureSwitch = new Texture(Gdx.files.internal("Mother_Standing_Forward.png"));
		spriteSwitch = new Sprite(textureSwitch);
		spriteTest = new Sprite(textureTest);
		mv = new KidMovement();
		sw = mv.change();

	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub 

		sw = mv.change();
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
			
		}

		batch.begin();
		if(sw == false){
			xp = mv.xpos(spriteTest.getX());
			yp = mv.ypos(spriteTest.getY());

			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			spriteTest.setPosition(xp, yp);
			spriteTest.draw(batch);
			
		}
		
		else if(sw == true){
			xp = mv.xpos(spriteSwitch.getX());
			yp = mv.ypos(spriteSwitch.getY());

			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			spriteSwitch.setPosition(xp, yp);
			spriteSwitch.draw(batch);
		}
		
		
		
		batch.end();

		
	}
	
}
	
	
