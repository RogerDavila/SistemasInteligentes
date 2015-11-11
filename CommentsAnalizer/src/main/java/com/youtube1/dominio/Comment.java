package com.youtube1.dominio;

public class Comment {

	private String channelId;
	private String channelName;
	private String comentario;
	

	public Comment(String channelId, String channelName, String comentario){
		this.channelId = channelId;
		this.channelName = channelName;
		this.setComentario(comentario);
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
