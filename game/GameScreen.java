package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


public class GameScreen implements Screen{
	TryingGame game;
	KidMovement mv;
	Select sl;

	SpriteBatch batch;
	public Texture textureTest;
	public Texture textureSwitch;
	public Texture backgroundOneMum;
	public Texture backgroundTwoMum;
	public Texture backgroundOneKid;
	public Texture backgroundTwoKid;
	public Sprite spriteTest;
	public Sprite spriteSwitch;
	Vector2 position;
	public float xp;
	public float yp;
	boolean sw;
	int op = 0;
	SerialTestMain contr;
	public int cnsl;
	public int xlimr =500;
	public int xliml = 500;
	public int ylimu = 500;
	public int ylimd = 500;
	
	static Animation walk;
	static TextureRegion[] walkFrame;
	static TextureRegion currentFrame;
	static float stateTime;
	static final int FRAME_COLS = 6;
	static final int FRAME_ROWS = 1;
	
	public GameScreen(TryingGame game){
		this.game = game;
	}
	
	public void create () {

	}
	
	@Override
	public void show() {
		
		contr = new SerialTestMain();

		batch = new SpriteBatch();
		
		//Setting the textures for the characters. textureTest is the kid, textureSwitch is the mother.
		textureTest = new Texture(Gdx.files.internal("Kid-standing_Foreward.png"));
		textureSwitch = new Texture(Gdx.files.internal("SpriteSheetMum.png"));
		
		backgroundOneMum = new Texture(Gdx.files.internal("BackgroundMumWall.png"));
		backgroundTwoMum = new Texture(Gdx.files.internal("InsideMum.png"));
		backgroundOneKid = new Texture(Gdx.files.internal("BackgroundKidWall.png"));
		backgroundTwoKid = new Texture(Gdx.files.internal("InsideKid.png"));
		
		TextureRegion[][] tmp = new TextureRegion(textureSwitch).split( textureSwitch.getWidth()/7,textureSwitch.getHeight()/4);
		walkFrame = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		
		int index = 0;
		for(int i = 0; i < FRAME_ROWS;i++){
			for( int j = FRAME_COLS - 1; j>=0; j--){
				walkFrame[index++]=tmp[i][j];
			}
		}
		
		walk = new Animation(.1f, walkFrame);
		stateTime = 0f;
		
		//Creating the sprites for the kid and mother using the textures which are sprite sheets.
		spriteSwitch = new Sprite(textureSwitch);
		spriteTest = new Sprite(textureTest);
		
		spriteSwitch.setOriginCenter();
		spriteTest.setOriginCenter();
		
		//Declaring the movement class and setting related variables. sw is a boolean that checks if the characters switched.
		mv = new KidMovement();
		sw = mv.change();
		
		//Declaring the class that checks if the characters are interacting with the enviornment.
		sl = new Select();
		
		mv.create();
		sl.create();
		
		cnsl = contr.dr;

	}


	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {

	}
	@Override
	public void render(float delta) {
		if(sl.scrnOne == true){
			xlimr = Gdx.graphics.getWidth() - 200;
			xliml = 0;
			ylimu = (Gdx.graphics.getHeight()/2)+100;
			ylimd =  0;
		}
		
		cnsl = mv.thing;


		//Sets which character is selected by calling on the corresponding function in the movement class.
		sw = mv.change();
		
		//Checks if escape is pressed, if it is, the game quits.
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE) || cnsl == 0){
			Gdx.app.exit();
			
		}
		
		//Checks to see if the select key is pressed,if it is, the Select class is called the check if the character can 
		//interact with the enviornment in that given area.
		if(Gdx.input.isKeyPressed(Input.Keys.E) || cnsl == 3){
				sl.sel(xp,yp,sw);
			}
		batch.begin();
		
		//Rendering the kid.
		if(sw == false){
			//gets x and y positions from the movement class.
			xp = mv.xpos(spriteTest.getX(), xlimr, xliml);
			yp = mv.ypos(spriteTest.getY(), ylimu, ylimd);
			
			//Setting the background colour.
			Gdx.gl.glClearColor(sl.p, sl.t, sl.c, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			if(sl.scrnTwo == false && sl.scrnOne == true){
				batch.draw(backgroundOneKid, 0,0);
	//			xlim = 1000;
	//			ylim = 550;
			}
			else if(sl.scrnOne == false && sl.scrnTwo == true){
				batch.draw(backgroundTwoKid, 0, 0);
			}
			
			//Draws the sprite for the kid.
			spriteTest.setPosition(xp, yp);
			spriteTest.draw(batch);
			
			
		}
		
		//Rendering the mother.
		else if(sw == true){
			//Gets mother's x,y position from the movement class.
			xp = mv.xpos(spriteSwitch.getX(), xlimr, xliml);
			yp = mv.ypos(spriteSwitch.getY(), ylimu, ylimd);
			
			//Setting the backdrop colour.
			Gdx.gl.glClearColor(sl.r, sl.g, sl.b, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
			if(sl.scrnTwo == false && sl.scrnOne == true){
				batch.draw(backgroundOneMum, 0,0);
			}
			else if(sl.scrnOne == false && sl.scrnTwo == true){
				batch.draw(backgroundTwoMum, 0, 0);
			}
			

			//currentFrame = walkFrame[mv.dire];
			currentFrame = walk.getKeyFrame(stateTime, true);
			batch.draw(currentFrame, xp, yp);

			
			//Drawing the mother's sprites using her x,y position.
			spriteSwitch.setPosition(xp, yp);
			//spriteSwitch.draw(batch);
		}

		batch.end();

		
	}
	
}
	
	
