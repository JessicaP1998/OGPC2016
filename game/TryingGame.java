package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/*import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.InputEvent;*/
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class TryingGame extends Game {
	//boolean fullscreen = Gdx.graphics.isFullscreen();
	public SpriteBatch batch;
	 Menu mainMenu;
	 GameScreen play;
	
	@Override
    public void create() {
            mainMenu = new Menu(this);
            play = new GameScreen(this);
            setScreen(mainMenu);              
    }
	
	
//	public void render(float delta) {
//		super.render();
//	}
	
//	public void dispose(){
//		batch.dispose();
//	}

}
