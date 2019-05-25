/**
 * 
 */
package com.zjh.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.zjh.dubbo.api.pojo.Slave;
import com.zjh.dubbo.api.service.IBankSlaveService;
import com.zjh.provider.mapper.IBankSlaveMapper;

/**
 * @author Thunisoft
 *
 */
@Service
public class SlaveServiceImpl implements IBankSlaveService {
	@Autowired
	private IBankSlaveMapper slaveMapper;
	// 添加账户信息
	@Override
	public int addSlaveInfo(Slave slave) {
		return slaveMapper.addSlaveInfo(slave);
	}
	// 删除账户信息,根据slaveid
	@Override
	public int removerSlaveInfoById(int slaveid) {
		return slaveMapper.removerSlaveInfoById(slaveid);
	}
	// 修改账户信息
	@Override
	public int updateSlaveInfo(Slave slave) {
		return slaveMapper.updateSlaveInfo(slave);
	}
	// 查询银行的所有slave的用户
	@Override
	public List<Slave> findAllSlaveInfo() {
		return slaveMapper.findAllSlaveInfo();
	}
	// 根据slaveid 查询的的指定用户信息
	@Override
	public Slave findSlaveInfoById(int salveid) {
		return slaveMapper.findSlaveInfoById(salveid);
	}

}
