package com.youtube1.BO;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.youtube1.dao.ChannelDAO;
import com.youtube1.dominio.Channel;

@ManagedBean(name="channelBO")
@ApplicationScoped
public class ChannelBO {

	@ManagedProperty("#{channelDAO}")
	private ChannelDAO channelDAO;

	public List<Channel> consultChannels() throws SQLException, Exception{
		List<Channel> listChannel = getChannelDAO().consultChannels();
		return listChannel;
	}

	public ChannelDAO getChannelDAO() {
		return channelDAO;
	}

	public void setChannelDAO(ChannelDAO channelDAO) {
		this.channelDAO = channelDAO;
	}

}
