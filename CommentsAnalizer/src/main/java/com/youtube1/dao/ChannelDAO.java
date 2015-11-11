package com.youtube1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.mysql.jdbc.Connection;
import com.youtube1.dominio.Channel;
import com.youtube1.utils.Conexion;

@ManagedBean
@ApplicationScoped
public class ChannelDAO {

	Connection con = null;
	Statement st = null;
	String query = null;
	ResultSet rs = null;
	Channel channel = null;

	public List<Channel> consultChannels() throws SQLException, Exception{
		List<Channel> channelList = new ArrayList<Channel>();
		con = new Conexion().Conectar();

		st = (Statement)con.createStatement();
		query = "SELECT ID, NOMBRE FROM CANALES WHERE NOMBRE <> '';";
		rs = st.executeQuery(query);
		String id = null;
		String name = null;
		while (rs.next())
		{
			id = rs.getString("ID");
			name = rs.getString("NOMBRE");
			channel = new Channel(id, name);
			channelList.add(channel);
		}
		rs.close();
		new Conexion().cerrarConexion(con);
		return channelList;
	}
}
