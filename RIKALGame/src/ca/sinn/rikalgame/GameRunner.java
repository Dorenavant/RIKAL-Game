package ca.sinn.rikalgame;

import ca.sinn.rikalgame.screens.MainMenuScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameRunner extends com.badlogic.gdx.Game {
	
	private static GameRunner GAME_RUNNER;
	
	public GameRunner() {
	}
	
	@Override
	public void create() {
		if (GAME_RUNNER != null) {
			throw new RuntimeException("Only one instance of game possible");
		}
	    //OrthographicCamera camera = new OrthographicCamera();
		//camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//SpriteBatch batch = new SpriteBatch();
		GAME_RUNNER = this;
		Stage stage = new Stage();
		this.setScreen(new MainMenuScreen(stage));
	}
	
	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	public static Game getGame() {
		return GAME_RUNNER;
	}
	
}

