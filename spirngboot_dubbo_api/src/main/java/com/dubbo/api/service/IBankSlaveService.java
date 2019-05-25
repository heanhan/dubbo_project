/**
 * 
 */
package com.dubbo.api.service;

import java.util.List;

import com.dubbo.api.pojo.Slave;

/**
 * @author Thunisoft
 *
 */
public interface IBankSlaveService {
	// slave用户下操作
	// 添加账户信息
	public int addSlaveInfo(Slave slave);

	// 删除账户信息,根据slaveid
	public int removerSlaveInfoById(int slaveid);

	// 修改账户信息
	public int updateSlaveInfo(Slave slave);

	// 查询银行的所有slave的用户
	public List<Slave> findAllSlaveInfo();

	// 根据slaveid 查询的的指定用户信息
	public Slave findSlaveInfoById(int salveid);

}
