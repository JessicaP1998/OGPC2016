package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.xml.internal.stream.Entity;

public class KidMovement extends Entity{
	
	public static String name = "player";
	GameScreen screen;
	public float x;
	public float y;
	boolean switcher = true;
	public Texture textureTest;
	public Texture textureSwitch;
	SpriteBatch batch;
	
	
	public void create(){
		batch = new SpriteBatch();
		//position = new Vector2(50,50);
		x = 200;
		y = 200;

	}
	
	public boolean change(){
		if(Gdx.input.isKeyJustPressed(Input.Keys.Q)){
			if(switcher == true){
				switcher = false;
			}
			else if(switcher == false){
				switcher = true;
			}
			
		}
		
		return switcher;
	}
	
	public float xpos(float xx){
		if(switcher == false ){
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				if(xx < Gdx.graphics.getWidth() && xx > 0)
					x -=2f;
				
					
			}
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				if(xx+256 < Gdx.graphics.getWidth() && xx > -5)
					x +=2f;
				
					
			}
		}
		
		if(switcher == true ){
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
				if(xx < Gdx.graphics.getWidth() && xx > 0)
					x -=3f;
				
					
			}
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
				if(xx+256 < Gdx.graphics.getWidth() && xx > -5)
					x +=3f;
				
					
			}
		}
		
		
		return x;
	}
	
	public float ypos(float yy){
		if(switcher == false ){
			if(Gdx.input.isKeyPressed(Input.Keys.UP)){
				if(yy+256 < Gdx.graphics.getHeight() && yy > -5)
					y +=2f;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
				if(yy < Gdx.graphics.getHeight() && yy > 0)
					y -=2f;
			}
		}
		
		if(switcher == true ){
			if(Gdx.input.isKeyPressed(Input.Keys.UP)){
				if(yy+384 < Gdx.graphics.getHeight() && yy > -5)
					y +=3f;
				
			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
				if(yy < Gdx.graphics.getHeight() && yy > 0)
					y -=3f;
				
			}
		}
		
		return y;
	}

	@Override
	public boolean isExternal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUnparsed() {
		// TODO Auto-generated method stub
		return false;
	}


	
	

}
