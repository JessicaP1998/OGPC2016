package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;

public class TryingGame extends Game {
	public SpriteBatch batch;
	 Menu mainMenu;
	 GameScreen play;
	 InstructionsScreen inst;
	
	@Override
    public void create() {
		//Declares the Main Menu and Game Screens.
            mainMenu = new Menu(this);
            play = new GameScreen(this);
            inst = new InstructionsScreen(this);
            
        //Stets the screen to main menu. 
            setScreen(mainMenu);              
    }

}
