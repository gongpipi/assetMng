package com.asset.pojo;

import java.util.Date;

public class Asset {
	private long id;
	private String equipIdentifier;//资产编号
	private String equipGenre;//设备类别
	private String equipModel;//设备型号
	private String usePerson;//使用人员
	private String useDepart;//use_depart
	private String usePosition;//使用地点
	private String condition;//使用状况
	private String source;//设备来源
	private String assetAllocation;//资产配置
	private Date buyTime;//购买时间
	private Date usedTime;//开始使用时间
	private Date lastTime;
	private int ifPd;//1:已经判点，0或2没有被盘点
	private String remarks;
	public String getEquipModel() {
		return equipModel;
	}
	public void setEquipModel(String equipModel) {
		this.equipModel = equipModel;
	}
	public String getEquipGenre() {
		return equipGenre;
	}
	public void setEquipGenre(String equipGenre) {
		this.equipGenre = equipGenre;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public String getUsePosition() {
		return usePosition;
	}
	public void setUsePosition(String usePosition) {
		this.usePosition = usePosition;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getEquipIdentifier() {
		return equipIdentifier;
	}
	public void setEquipIdentifier(String equipIdentifier) {
		this.equipIdentifier = equipIdentifier;
	}
	public Date getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(Date usedTime) {
		this.usedTime = usedTime;
	}
	public String getUsePerson() {
		return usePerson;
	}
	public void setUsePerson(String usePerson) {
		this.usePerson = usePerson;
	}
	public String getUseDepart() {
		return useDepart;
	}
	public void setUseDepart(String useDepart) {
		this.useDepart = useDepart;
	}
	public String getAssetAllocation() {
		return assetAllocation;
	}
	public void setAssetAllocation(String assetAllocation) {
		this.assetAllocation = assetAllocation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	
	public int getIfPd() {
		return ifPd;
	}
	public void setIfPd(int ifPd) {
		this.ifPd = ifPd;
	}
	
	@Override
	public String toString() {
		return "Asset [id=" + id + ", equipIdentifier=" + equipIdentifier
				+ ", equipGenre=" + equipGenre + ", equipModel=" + equipModel
				+ ", usePerson=" + usePerson + ", useDepart=" + useDepart
				+ ", usePosition=" + usePosition + ", condition=" + condition
				+ ", source=" + source + ", assetAllocation=" + assetAllocation
				+ ", buyTime=" + buyTime + ", usedTime=" + usedTime
				+ ", lastTime=" + lastTime + ", ifPd=" + ifPd + "]";
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
