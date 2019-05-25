/**
 * 
 */
package com.zjh.provider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.zjh.dubbo.api.pojo.Master;
import com.zjh.dubbo.api.pojo.Slave;
import com.zjh.dubbo.api.service.IBankMasterService;
import com.zjh.dubbo.api.service.IBankMasterSlaveService;
import com.zjh.dubbo.api.service.IBankSlaveService;

/**
 * @author Thunisoft
 *
 */
@Service
public class BankMasterSlaveServiceImpl implements IBankMasterSlaveService {
	@Autowired
	private IBankMasterService masterServiceImpl;
	@Autowired
	private IBankSlaveService slaveServiceImpl;
	// 将master的钱转移到slave的余额中
	@Override
	@Transactional()
	public int masterToSlaveMoney(Master master,Slave slave) {
		masterServiceImpl.updateMasterInfo(master);
		slaveServiceImpl.updateSlaveInfo(slave);
		return 0;
	}

	// 将slave的钱转移到master的余额中
	@Override
	@Transactional()
	public int slaveToMasterMoney(Master master,Slave slave) {
		return 0;
	}

}
