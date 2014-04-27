package ca.sinn.rikalgame.screens;

import java.util.Objects;

import ca.sinn.rikalgame.GameRunner;
import ca.sinn.rikalgame.resources.Resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import static com.badlogic.gdx.Input.*;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Region;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MainMenuScreen implements Screen {
	
	private final Stage stage;
	private final Sprite sprite;
	
	{
		sprite =  new Sprite(new Texture(Resources.getImageFile("introscreen.png")));
	}
	
	public MainMenuScreen(final Stage stage) {
		this.stage = Objects.requireNonNull(stage);
		this.sprite.setBounds(0, 0, stage.getWidth(), stage.getHeight());
		Gdx.input.setInputProcessor(stage);
		stage.addActor(new Actor() {
			
			@Override
			public void draw(SpriteBatch spriteBatch, float alpha) {
				sprite.draw(spriteBatch);
			}
			
		});
		Skin skin = new Skin();
		final TextButton button;
		BitmapFont font = new BitmapFont();
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		TextureAtlas buttonAtlas = Resources.getPack("button_1");
		
		textButtonStyle.font = font;
		skin.addRegions(buttonAtlas);
		textButtonStyle.up = skin.getDrawable("button_unclicked");
		textButtonStyle.down = skin.getDrawable("button_clicked");
		button = new TextButton("PLAY WITH RAHUL'S STUPIDITY", textButtonStyle);
		button.setBounds(500, 150, 200, 50);
		EventListener listener = new InputListener() {
			
			@Override
			public boolean touchDown(InputEvent evt, float x, float y, int pointer, int button) {
				if (button == Buttons.LEFT)
					stage.clear();
					GameRunner.getGame().setScreen(new WorldMapScreen(stage));
				return false;
			}
		};
		// button.addCaptureListener(listener);
		button.addListener(listener);
		stage.addActor(button);
	}
	
	@Override
	public void render(float delta) {
		stage.draw();
		stage.act(delta);
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
