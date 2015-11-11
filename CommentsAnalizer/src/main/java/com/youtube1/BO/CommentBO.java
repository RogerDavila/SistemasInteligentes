package com.youtube1.BO;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.youtube1.dao.CommentDAO;
import com.youtube1.dominio.Comment;

@ManagedBean
@ApplicationScoped
public class CommentBO {

	@ManagedProperty("#{commentDAO}")
	private CommentDAO commentDAO;

	public List<Comment> consultComments(String parametro) throws SQLException, Exception{
		List<Comment> listComment = null;
		if(!parametro.isEmpty() || !parametro.trim().equals("")){
			listComment = getCommentDAO().consultComments(parametro);
		}
		return listComment;
	}

	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

}
