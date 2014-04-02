package ca.sinn.rikalgame.screens;

import java.util.Objects;

import ca.sinn.rikalgame.resources.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {
	
	private final SpriteBatch batch;
	private final OrthographicCamera camera;
	private final Sprite sprite = new Sprite(new Texture(Resources.getImageFile("introscreen.png")));
	
	public MainMenuScreen(SpriteBatch batch, OrthographicCamera camera) {
		this.batch = Objects.requireNonNull(batch);
		this.camera = Objects.requireNonNull(camera);
		this.sprite.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	@Override
	public void render(float delta) {
		this.camera.update();
		this.batch.setProjectionMatrix(camera.combined);
		this.batch.begin();
		{
			this.sprite.draw(this.batch);
		}
		this.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
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
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
