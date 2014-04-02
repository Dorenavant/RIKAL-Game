package ca.sinn.rikalgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ca.sinn.rikalgame.screens.MainMenuScreen;

public class GameRunner extends com.badlogic.gdx.Game {

	@Override
	public void create() {
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		SpriteBatch batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(batch, camera));
	}
}
