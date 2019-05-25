/**
 * 
 */
package com.dubbo.api.service;

import com.dubbo.api.pojo.Master;
import com.dubbo.api.pojo.Slave;

/**
 * @author Thunisoft
 *
 */
public interface IBankMasterSlaveService {
	//将master的钱转移到slave的余额中
	public int masterToSlaveMoney(Master master, Slave slave);
	//将slave的钱转移到master的余额中
	public int slaveToMasterMoney(Master master, Slave slave);

}
