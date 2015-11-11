package com.youtube1.service;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.youtube1.BO.CommentBO;
import com.youtube1.dominio.Comment;


@ManagedBean
@ApplicationScoped
public class CommentService {

	@ManagedProperty("#{commentBO}")
	private CommentBO commentBO;

	public List<Comment> consultComments(String parametro) throws SQLException, Exception {

		List<Comment> commentList = null;
		commentList = getCommentBO().consultComments(parametro);
		return commentList;
	}

	public CommentBO getCommentBO() {
		return commentBO;
	}

	public void setCommentBO(CommentBO commentBO) {
		this.commentBO = commentBO;
	}
}
