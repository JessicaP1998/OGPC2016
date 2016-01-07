package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen{
	TryingGame game;
	SpriteBatch batch;
	Texture textureTest;
	Texture textureSwitch;
	Sprite spriteTest;
	Sprite spriteSwitch;
	boolean switcher = true;
	float x;
	float y;
	
	public GameScreen(TryingGame game){
		this.game = game;
		
		batch = new SpriteBatch();
		textureTest = new Texture(Gdx.files.internal("SpriteThingyTest.png"));
		textureSwitch = new Texture(Gdx.files.internal("SwitchTestSprite.png"));
		spriteSwitch = new Sprite(textureSwitch);
		spriteTest = new Sprite(textureTest);
	}
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		
		x = w-spriteTest.getWidth();
		y = h/2-spriteTest.getHeight()/2;
		
		
	}
	@Override
	public void show() {

		
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
	//	batch.dispose();
	//	textureTest.dispose();
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
			switcher = false;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.E)){
			switcher = true;
		}
		
		if(switcher == false ){
			spriteTest.setPosition(x, y);
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				if(spriteTest.getX() < Gdx.graphics.getWidth() && spriteTest.getX() > 0)
					spriteTest.translateX(-2.0f);
				
					
			}
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				if(spriteTest.getX()+spriteTest.getWidth() < Gdx.graphics.getWidth() && spriteTest.getX() > -5)
					spriteTest.translateX(2.0f);
				
					
			}
			if(Gdx.input.isKeyPressed(Input.Keys.UP)){
				if(spriteTest.getY()+spriteTest.getHeight() < Gdx.graphics.getHeight() && spriteTest.getY() > -5)
					spriteTest.translateY(2.0f);
			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
				if(spriteTest.getY() < Gdx.graphics.getHeight() && spriteTest.getY() > 0)
					spriteTest.translateY(-2.0f);
			}
				
			batch.begin();
			spriteTest.draw(batch);
			batch.end();
			x = spriteTest.getX();
			y = spriteTest.getY();
		}
		if(switcher == true ){
			spriteSwitch.setPosition(x, y);
			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				if(spriteSwitch.getX() < Gdx.graphics.getWidth() && spriteSwitch.getX() > 0)
					spriteSwitch.translateX(-3.0f);
				
					
			}
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				if(spriteSwitch.getX()+spriteSwitch.getWidth() < Gdx.graphics.getWidth() && spriteSwitch.getX() > -5)
					spriteSwitch.translateX(3.0f);
				
					
			}
			if(Gdx.input.isKeyPressed(Input.Keys.UP)){
				if(spriteSwitch.getY()+spriteSwitch.getHeight() < Gdx.graphics.getHeight() && spriteSwitch.getY() > -5)
					spriteSwitch.translateY(3.0f);
			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
				if(spriteSwitch.getY() < Gdx.graphics.getHeight() && spriteSwitch.getY() > 0)
					spriteSwitch.translateY(-3.0f);
			}
				
			batch.begin();
			spriteSwitch.draw(batch);
			batch.end();
			x = spriteSwitch.getX();
			y = spriteSwitch.getY();
			}
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
			
	}
	
}
	
	
