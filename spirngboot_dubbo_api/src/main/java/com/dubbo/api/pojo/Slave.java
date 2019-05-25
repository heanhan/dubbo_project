/**
 * 
 */
package com.dubbo.api.pojo;

import java.io.Serializable;


/**
 * @author Thunisoft
 *
 */
public class Slave implements Serializable{

	/**
	 * 
	 */
	private int slaveid;//账户
	private String slavename;//用户名
	private double slavemoney;//账户余额
	public Slave() {
		super();
	}
	public Slave(String slavename, double slavemoney) {
		super();
		this.slavename = slavename;
		this.slavemoney = slavemoney;
	}
	public Slave(int slaveid, String slavename, double slavemoney) {
		super();
		this.slaveid = slaveid;
		this.slavename = slavename;
		this.slavemoney = slavemoney;
	}
	public int getSlaveid() {
		return slaveid;
	}
	public void setSlaveid(int slaveid) {
		this.slaveid = slaveid;
	}
	public String getSlavename() {
		return slavename;
	}
	public void setSlavename(String slavename) {
		this.slavename = slavename;
	}
	public double getSlavemoney() {
		return slavemoney;
	}
	public void setSlavemoney(double slavemoney) {
		this.slavemoney = slavemoney;
	}
	@Override
	public String toString() {
		return "Slave [slaveid=" + slaveid + ", slavename=" + slavename + ", slavemoney=" + slavemoney + "]";
	}
	
	

}
