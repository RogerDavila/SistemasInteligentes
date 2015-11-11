package com.youtube1.view;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.youtube1.dominio.Channel;
import com.youtube1.dominio.Comment;
import com.youtube1.service.ChannelService;
import com.youtube1.service.CommentService;

@ManagedBean
@ApplicationScoped
public class PrincipalMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Channel> channels;
	private List<Comment> comments;
	
	private Channel selectedChannel;

	@ManagedProperty("#{channelService}")
	private ChannelService channelService;

	@ManagedProperty("#{commentService}")
	private CommentService commentService;
	
	public void buscar() {
		try {
			channels = channelService.consultChannels();
		} catch (SQLException sqex) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!","Ocurrió el error SQL: "+sqex.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(Exception ex){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!","Ocurrió el error: "+ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public List<Channel> getChannels() {
		return channels;
	}
	
	public List<Comment> getComments(){
		return comments;
	}
	
	public void setChannelService(ChannelService channelService) {
		this.channelService = channelService;
	}

	public Channel getSelectedChannel() {
		return selectedChannel;
	}

	public void setSelectedChannel(Channel selectedChannel) {
		this.selectedChannel = selectedChannel;
	}


	public void onRowSelect(SelectEvent event) {
		String id = ((Channel) event.getObject()).getId();
		try {
			comments = getCommentService().consultComments(id);
			FacesContext.getCurrentInstance().getExternalContext().redirect("comments.xhtml");
		} catch (SQLException sqex) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!","Ocurrió el error SQL: "+sqex.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(Exception ex){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error!","Ocurrió el error: "+ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

}