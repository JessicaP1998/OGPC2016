package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.xml.internal.stream.Entity;

import gnu.io.SerialPortEvent;

public class KidMovement extends Entity{
	
	public static String name = "player";
	GameScreen screen;
	Select intr;
	public float x;
	public float y;
	boolean switcher = true;
	public Texture textureTest;
	public Texture textureSwitch;
	SpriteBatch batch;
	SerialTestMain cntr;
	public int thing;
	public int dire = 0;
	
	public void create(){
		batch = new SpriteBatch();
		
		x = 230;
		y = 230;
		
		//Declaring the select class and the controller input class.
		intr = new Select(); 
		cntr = new SerialTestMain();
		
		//Initializing the controller input.
		cntr.initialize();
		
		//Integer taking the input from the controller class to determine which button is pressed.
		thing = cntr.dr;

	}
	
	//Class that changes the character.
	public boolean change(){
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.Q) || thing == 1){
			if(switcher == true){
				switcher = false;
			}
			else if(switcher == false){
				switcher = true;
			}
		}
		
		return switcher;
	}
	
	//Class determines character movement in the x direction based on input from controller or keyboard.
	public float xpos(float xx){
		thing = cntr.dr;
		
		
		if(switcher == false ){
			
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || thing == 4){
				//Checks if the character is within the constraints of the screen, if at the edge, character won't move.
				if(xx < Gdx.graphics.getWidth() && xx > 0)
					x -=2f;
					dire = 3;
			}
			
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || thing == 6){
				if(xx+256 < Gdx.graphics.getWidth() && xx > -5)
					x +=2f;	
					dire = 2;
			}
		}
		
		if(switcher == true ){
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || thing == 4){
				if(xx < Gdx.graphics.getWidth() && xx > 0)
					x -=3f;
					dire = 3;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) || thing == 6){
				if(xx+256 < Gdx.graphics.getWidth() && xx > -5)
					x +=3f;
					dire = 2;
			}
		}
		
		return x;
	}
	
	//Class determines character movement in the y direction based on input from controller or keyboard.
	public float ypos(float yy){
		
		thing = cntr.dr;
		
		if(switcher == false ){
			if(Gdx.input.isKeyPressed(Input.Keys.UP) || thing == 8){
				if(yy+256 < Gdx.graphics.getHeight() && yy > -5)
					y +=2f;
					dire = 1;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || thing == 2){
				if(yy < Gdx.graphics.getHeight() && yy > 0)
					y -=2f;
					dire = 0;
			}
		}
		
		if(switcher == true ){
			if(Gdx.input.isKeyPressed(Input.Keys.UP) || thing == 8){
				if(yy+384 < Gdx.graphics.getHeight() && yy > -5)
					y +=3f;
					dire = 1;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.DOWN) || thing == 2){
				if(yy < Gdx.graphics.getHeight() && yy > 0)
					y -=3f;
					dire = 0;
			}
		}
		
		return y;
	}
	
	public void interact(){
		
	}

	@Override
	public boolean isExternal() {
		return false;
	}

	@Override
	public boolean isUnparsed() {
		return false;
	}


	
	

}
