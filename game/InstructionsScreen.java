package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
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
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.Viewport;

public class InstructionsScreen implements Screen{
	TryingGame game;
	
	SpriteBatch batch;
	BitmapFont font;
	CharSequence instructions;
	Skin skin;
	Stage stage;
	OrthographicCamera camera;
	Viewport viewport;
	
	public InstructionsScreen(final TryingGame gamer){
		this.game = gamer;
		
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
		Pixmap pixmap = new Pixmap(100,30,Pixmap.Format.RGB888);
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
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		
		createBasicSkin();
		TextButton backButton = new TextButton("return", skin);
		backButton.setPosition((3*Gdx.graphics.getWidth())/4, (4*Gdx.graphics.getHeight())/6);
		stage.addActor(backButton);
		
		backButton.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor){
				game.setScreen(game.mainMenu);
			}
		});
		
		instructions = "For Keyboard:\r\n"
				+ "\r\n"
				+ "Up Arrow: Move Up\r\n"
				+ "Down Arrow: Move Down\r\n"
				+ "Right Arrow: Move Right\r\n"
				+ "Left Arrow: Move Left\r\n"
				+ "Q: Switch character\r\n"
				+ "E: Select/Interact\r\n"
				+ "Escape: Menu\r\n"
				+ "\r\n"
				+ "For Controller:\r\n"
				+ "\r\n"
				+ "Directional pad for movement\r\n"
				+ "Outside button: Switch Character\r\n"
				+ "Inside Button: Select/Interact\r\n"
				+ "Middle Button: Menu\r\n";
		
		font = new BitmapFont();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(80/255f,49/255f,3/255f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		font.draw(batch, instructions, Gdx.graphics.getWidth()/2-Gdx.graphics.getWidth()/4, (3*Gdx.graphics.getHeight())/6);
		
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.end();
		
		stage.act(delta);
		stage.draw();
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
		}
		
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
		
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

}
