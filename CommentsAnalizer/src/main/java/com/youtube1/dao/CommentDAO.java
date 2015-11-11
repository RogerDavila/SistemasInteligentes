package com.youtube1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.mysql.jdbc.Connection;
import com.youtube1.dominio.Comment;
import com.youtube1.utils.Conexion;

@ManagedBean
@ApplicationScoped
public class CommentDAO {

	Connection con = null;
	Statement st = null;
	String query = null;
	ResultSet rs = null;
	Comment comment = null;

	public List<Comment> consultComments(String parametro) throws SQLException, Exception{
		List<Comment> commentList = new ArrayList<Comment>();
		con = new Conexion().Conectar();

		st = (Statement)con.createStatement();
		query = "SELECT CAN.ID ID_CANAL, CAN.NOMBRE NOMBRE, COM.COMENTARIO COMENTARIO FROM CANALES CAN, COMENTARIOS COM"
				+ " WHERE CAN.ID = COM.CANAL_ID AND CAN.ID ='"+parametro+"';";
		rs = st.executeQuery(query);
		String channelId = null;
		String channelName = null;
		String comentario = null;
		while (rs.next())
		{
			channelId = rs.getString("ID_CANAL");
			channelName = rs.getString("NOMBRE");
			comentario = rs.getString("COMENTARIO");
			comment = new Comment(channelId, channelName, comentario);
			commentList.add(comment);
		}
		rs.close();
		new Conexion().cerrarConexion(con);
		return commentList;
	}
}
