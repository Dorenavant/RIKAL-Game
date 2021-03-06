package ca.sinn.rikalgame.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public final class Resources {
	
	public static final String DATA_DIR = "data";
	
	public static final String IMAGE_DIR = concatPath(DATA_DIR, "img");
	
	public static final String PACK_DIR = concatPath(IMAGE_DIR, "packs");
	
	public static final String AUDIO_DIR = concatPath(DATA_DIR, "audio");
	
	public static final String DEFAULT_PACK_NAME = "pack.atlas";
	
	private Resources() {
		throw new IllegalAccessError(getClass().getName());
	}
	
	public static String concatPath(String base, String path) {
		return base + "/" + path;
	}
	
	public static String getImagePath(String path) {
		return concatPath(IMAGE_DIR, path);
	}
	
	public static FileHandle getImageFile(String path) {
		return Gdx.files.internal(getImagePath(path));
	}
	
	public static String getAudioPath(String path) {
		return concatPath(AUDIO_DIR, path);
	}
	
	public static FileHandle getAudioFile(String path) {
		return Gdx.files.internal(getAudioPath(path));
	}
	
	public static String getPackPath(String path) {
		return concatPath(PACK_DIR, path);
	}
	
	public static FileHandle getPackFile(String packName) {
		return Gdx.files.internal(concatPath(getPackPath(packName), DEFAULT_PACK_NAME));
	}
	
	public static TextureAtlas getPack(String packName) {
		return new TextureAtlas(getPackFile(packName));
	}
	
	
}
