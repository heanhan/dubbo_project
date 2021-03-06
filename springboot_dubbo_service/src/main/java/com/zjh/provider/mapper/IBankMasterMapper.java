/**
 * 
 */
package com.zjh.provider.mapper;

import java.util.List;

import com.dubbo.api.pojo.Master;
import org.apache.ibatis.annotations.Mapper;



/**
 * @author Thunisoft
 *
 */
@Mapper
public interface IBankMasterMapper {
	// master用户下操作
	// 添加账户信息
	public int addMasterInfo(Master master);

	// 删除账户信息,根据masterid
	public int removerMaterInfoById(int masterid);

	// 修改账户信息
	public int updateMasterInfo(Master master);

	// 查询银行的所有master的用户
	public List<Master> findAllMasterInfo();

	// 根据masterid 查询的的指定用户信息
	public Master findMasterInfoById(int id);

}
