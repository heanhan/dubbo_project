/**
 * 
 */
package com.dubbo.api.pojo;

import java.io.Serializable;


/**
 * @author Thunisoft
 *
 */
public class Master implements Serializable{

	/**
	 * 
	 */

	private int masterid;//master账号

	private String mastername;//姓名
	private double mastermoney;
	public Master() {
		super();
	}
	public Master(String mastername, double mastermoney) {
		super();
		this.mastername = mastername;
		this.mastermoney = mastermoney;
	}
	public Master(int masterid, String mastername, double mastermoney) {
		super();
		this.masterid = masterid;
		this.mastername = mastername;
		this.mastermoney = mastermoney;
	}
	public int getMasterid() {
		return masterid;
	}
	public void setMasterid(int masterid) {
		this.masterid = masterid;
	}
	public String getMastername() {
		return mastername;
	}
	public void setMastername(String mastername) {
		this.mastername = mastername;
	}
	public double getMastermoney() {
		return mastermoney;
	}
	public void setMastermoney(double mastermoney) {
		this.mastermoney = mastermoney;
	}
	@Override
	public String toString() {
		return "Master [masterid=" + masterid + ", mastername=" + mastername + ", mastermoney=" + mastermoney + "]";
	}
	

}
