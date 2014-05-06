package ca.sinn.rikalgame.screens;

import ca.sinn.rikalgame.GameRunner;
import ca.sinn.rikalgame.resources.Resources;
import ca.sinn.rikalgame.screens.actors.SpriteActor;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MainMenuScreen extends StagedScreen {
	
	private final SpriteActor introBackground;
	
	{
		Sprite sprite = new Sprite(new Texture(Resources.getImageFile("introscreen.png")));
		introBackground = new SpriteActor(sprite);
	}
	
	public MainMenuScreen(final Stage stage) {
		super(stage);
		
		this.introBackground.setBounds(0, 0, stage.getWidth(), stage.getHeight());
		stage.addActor(introBackground);
		
		Skin skin = new Skin();
		final TextButton button;
		BitmapFont font = new BitmapFont();
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		TextureAtlas buttonAtlas = Resources.getPack("button_1");
		textButtonStyle.font = font;
		skin.addRegions(buttonAtlas);
		textButtonStyle.up = skin.getDrawable("button_unclicked");
		textButtonStyle.down = skin.getDrawable("button_clicked");
		button = new TextButton("PLAY", textButtonStyle);
		button.setBounds(500, 150, 200, 50);
		
		EventListener listener = new InputListener() {
			
			@Override
			public boolean touchDown(InputEvent evt, float x, float y, int pointer, int b) {
				if (b == Buttons.LEFT) {
					stage.clear();
					GameRunner.getGame().setScreen(new WorldMapScreen(stage));
				}
				return false;
			}
		};
		// button.addCaptureListener(listener);
		button.addListener(listener);
		stage.addActor(button);
	}

}
