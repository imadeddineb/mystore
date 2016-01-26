package com.mystorebusiness.media;

public class Media {

	private static final String FORWARD_SLASH = "/";
	private String id;
	private String url;
	private String folder;
	public String getId() {
		return id;
	}
	
	public String getAbsolutePath()
	{
		return folder+ FORWARD_SLASH + url;
	}
	public String getUrl() {
		return url;
	}
	public String getFolder() {
		return folder;
	}
	
	
	
	
}
