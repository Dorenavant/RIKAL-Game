package ca.sinn.rikalgame.screens.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class SpriteActor extends Actor {
	
	private final Sprite sprite;
	private boolean isVisible = true;
	
	public SpriteActor(Sprite sprite) {
		this.sprite = java.util.Objects.requireNonNull(sprite);
	}
	
	@Override
	public void draw(SpriteBatch batch, float alpha) {
		if (!isVisible()) {
			return;
		}
		sprite.draw(batch, alpha);
	}
	
	@Override
	protected void sizeChanged() {
		sprite.setBounds(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void setX(float x) {
		super.setX(x);
		sprite.setX(x);
	}
	
	@Override
	public void setY(float y) {
		super.setY(y);
		sprite.setY(y);
	}
	
	@Override
	public void setPosition(float x, float y) {
		super.setPosition(x, y);
		sprite.setPosition(x, y);
	}
	
	public boolean isVisible() {
		return isVisible;
	}
	
	public void setVisible(boolean value) {
		this.isVisible = value;
	}
	
	public SpriteActor show(boolean value) {
		setVisible(value);
		return this;
	}
	
}
