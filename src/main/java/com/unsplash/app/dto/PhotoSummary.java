package com.unsplash.app.dto;

public class PhotoSummary {
	
	private String id;
    private String title;
    private String description;
    private String cover_photo_id;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover_photo_id() {
		return cover_photo_id;
	}
	public void setCover_photo_id(String cover_photo_id) {
		this.cover_photo_id = cover_photo_id;
	}
    
    

}
