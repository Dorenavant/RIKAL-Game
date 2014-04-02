package ca.sinn.rikalgame.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public final class Resources {
	
	public static final String DATA_DIR = "data";
	
	public static final String IMAGE_DIR = concatPath(DATA_DIR, "img");
	
	public static final String AUDIO_DIR = concatPath(DATA_DIR, "audio");
	
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
	
}
