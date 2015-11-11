package com.youtube1.utils;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion{
	
	public Connection Conectar() throws SQLException, Exception{
		Connection conn = null; 
		conn = (Connection) DriverManager.getConnection("jdbc:mysql://107.170.221.16:3306/YOUTUBE1_V2?" +
	                                   "user=root");
		return conn;
	}
	
	public void cerrarConexion(Connection con) throws SQLException, Exception{
		con.close();
	}
}
