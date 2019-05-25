/**
 * 
 */
package com.dubbo.consumer.controller;

import com.dubbo.api.pojo.Master;
import com.dubbo.api.pojo.Slave;
import com.dubbo.api.service.IBankMasterService;
import com.dubbo.api.service.IBankSlaveService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Thunisoft
 *
 */
@RestController
@EnableSwagger2
@Api(value="dubbo的事务转账模块",description="解决dubbo不支持事务的测试",tags="标记dubbo事务解决方案")
public class BankController {
	//注入bean 要使用dubbo体统的@reference,同时版本号version要加上
	@Reference(version="${demo.service.version}")
	private IBankMasterService masterServiceImpl;
	@Reference(version="${demo.service.version}")
	private IBankSlaveService slaveServiceImpl;
	// 开关判断
	private boolean flag = false;
	private int intFlag = -1;
	
	//添加master
	@PostMapping(value="addMasterInfo")
	@ApiOperation(value = "添加master",notes="添加master-note")
	@ApiImplicitParams(value = { 
			@ApiImplicitParam(paramType="query",name="masterid",value="masterid-value",dataType="int"),
			@ApiImplicitParam(paramType="query",name="mastername",value="mastername-value",dataType="String"),
			@ApiImplicitParam(paramType="query",name="mastermoney",value="mastermoney-value",dataType="double")
	})
	public String addMasterInfo(@ModelAttribute Master master)
	{
		intFlag=masterServiceImpl.addMasterInfo(master);
		if (intFlag > 0) {
			return "master用户添加成功";
		} else {
			return "master用户添加失败";
		}
	}
	
	//添加slave
	@PostMapping(value="addSlaveInfo")
	@ApiOperation(value = "添加slave",notes="添加slave-note")
	@ApiImplicitParams(value = { 
			@ApiImplicitParam(paramType="query",name="slaveid",value="slaveid-value",dataType="int"),
			@ApiImplicitParam(paramType="query",name="slavename",value="slavename-value",dataType="String"),
			@ApiImplicitParam(paramType="query",name="slavemoney",value="slavemoney-value",dataType="double")
	})
	public String addSlaveInfo(@ModelAttribute Slave slave)
	{
		intFlag=slaveServiceImpl.addSlaveInfo(slave);
		if (intFlag > 0) {
			return "slave用户添加成功";
		} else {
			return "slave用户添加失败";
		}
	}
	
	//进行转账操作
	@PostMapping(value="/masterToSlave")
	public String masterToSlave(@ModelAttribute Master master,@ModelAttribute Slave slave) 
	{
		//master账户的钱转到slave账户上去
		
		return null;
	}
	

}
