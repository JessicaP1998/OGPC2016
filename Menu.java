package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Screen;

public class Menu implements Screen{
	TryingGame game;
	Skin skin;
	Stage stage;
	OrthographicCamera camera;
	TextButton newGameButton;
	Viewport viewport;
	SpriteBatch batch;
	
	public Menu(final TryingGame gam){
			this.game = gam;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		batch = new SpriteBatch();
		stage = new Stage();
		viewport = stage.getViewport();
	}
	
	public class MyActor extends Actor{
		
			@Override
		    public void act(float delta) {
		        super.act(delta);
		    }

		    @Override
		    public void draw(Batch batch, float parentAlpha) {
		        super.draw(batch, parentAlpha);
		        
		    }
		
	}
	
	private void createBasicSkin(){
		//Creates Font
		BitmapFont font = new BitmapFont();
		skin = new Skin();
		skin.add("default", font);
		
		//Creates a texture
		Pixmap pixmap = new Pixmap((int)Gdx.graphics.getWidth()/4,(int)Gdx.graphics.getHeight()/10,Pixmap.Format.RGB888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("background", new Texture(pixmap));
		
		//Creates button style
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
		textButtonStyle.down = skin.newDrawable("background", Color.CYAN);
		textButtonStyle.checked = skin.newDrawable("background", Color.VIOLET);
		textButtonStyle.over = skin.newDrawable("background", Color.MAGENTA);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);
	}
	
	
	public void create(){
		
		//stage.setViewport(1080, stageHeight, true, 0, 0, 1080, stageHeight);
		//stage.setCamera(camera);
		//Makes stage consume events
		
		
		
		
	}
	

	


	@Override
	public void show() {
		// TODO Auto-generated method stub
		Gdx.input.setInputProcessor(stage);
		
		createBasicSkin();
		TextButton newGameButton = new TextButton("New Game", skin);
		newGameButton.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/8, (4*Gdx.graphics.getHeight())/6);
		stage.addActor(newGameButton);
		TextButton continueButton = new TextButton("Continue",skin);
		continueButton.setPosition(Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/8, (3*Gdx.graphics.getHeight())/6);
		stage.addActor(continueButton);
		
		newGameButton.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor){
				game.setScreen(game.play);
			}
		});
		
	}





	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
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
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClearColor(80/255f,49/255f,3/255f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
		batch.begin();
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		batch.end();
		
		stage.act(delta);
		stage.draw();
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
	}

}
