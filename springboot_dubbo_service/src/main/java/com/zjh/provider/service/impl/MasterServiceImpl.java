/**
 * 
 */
package com.zjh.provider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.zjh.dubbo.api.pojo.Master;
import com.zjh.dubbo.api.service.IBankMasterService;
import com.zjh.provider.mapper.IBankMasterMapper;

/**
 * @author Thunisoft
 *
 */
@Service
public class MasterServiceImpl implements IBankMasterService {
	@Autowired
	private IBankMasterMapper masterMapper;
	// 添加账户信息
	@Override
	public int addMasterInfo(Master master) {
		return masterMapper.addMasterInfo(master);
	}
	// 删除账户信息,根据masterid
	@Override
	public int removerMaterInfoById(int masterid) {
		return masterMapper.removerMaterInfoById(masterid);
	}
	// 修改账户信息
	@Override
	public int updateMasterInfo(Master master) {
		return masterMapper.updateMasterInfo(master);
	}
	// 查询银行的所有master的用户s
	@Override
	public List<Master> findAllMasterInfo() {
		return masterMapper.findAllMasterInfo();
	}
	// 根据masterid 查询的的指定用户信息
	@Override
	public Master findMasterInfoById(int id) {
		return masterMapper.findMasterInfoById(id);
	}

}
