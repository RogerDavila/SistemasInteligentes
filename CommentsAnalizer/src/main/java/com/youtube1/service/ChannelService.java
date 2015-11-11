package com.youtube1.service;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.youtube1.BO.ChannelBO;
import com.youtube1.dominio.Channel;


@ManagedBean
@ApplicationScoped
public class ChannelService {

	@ManagedProperty("#{channelBO}")
	private ChannelBO channelBO;

	public List<Channel> consultChannels() throws SQLException, Exception {

		List<Channel> channelList = null;
		channelList = getChannelBO().consultChannels();
		return channelList;
	}

	public ChannelBO getChannelBO() {
		return channelBO;
	}

	public void setChannelBO(ChannelBO channelBO) {
		this.channelBO = channelBO;
	}
}
