package com.asset.utils;

import java.util.Date;

public class POIExcelAssetBean extends POIExcelBaseBean {
	private String equipIdentifier;//资产编号
	private String equipGenre;//设备类别
	private String equipModel;//设备型号
	private String usePerson;//使用人员
	private String useDepart;//use_depart
	private String usePosition;//使用地点
	private String condition;//使用状况
	private String source;//设备来源
	private String assetAllocation;//资产配置
	private String buyTime;//购买时间
	private String usedTime;//开始使用时间
	private String lastTime;//最后修改时间
	public POIExcelAssetBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public POIExcelAssetBean(String equipIdentifier, String equipGenre,
			String equipModel, String usePerson, String useDepart,
			String usePosition, String condition, String source,
			String assetAllocation, String buyTime, String usedTime, String lastTime,String remarks) {
		super();
		this.equipIdentifier = equipIdentifier;
		this.equipGenre = equipGenre;
		this.equipModel = equipModel;
		this.usePerson = usePerson;
		this.useDepart = useDepart;
		this.usePosition = usePosition;
		this.condition = condition;
		this.source = source;
		this.assetAllocation = assetAllocation;
		this.buyTime = buyTime;
		this.usedTime = usedTime;
		this.lastTime = lastTime;
	}

	public String getEquipIdentifier() {
		return equipIdentifier;
	}
	public void setEquipIdentifier(String equipIdentifier) {
		this.equipIdentifier = equipIdentifier;
	}
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
	public String getUsePosition() {
		return usePosition;
	}
	public void setUsePosition(String usePosition) {
		this.usePosition = usePosition;
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
	public String getAssetAllocation() {
		return assetAllocation;
	}
	public void setAssetAllocation(String assetAllocation) {
		this.assetAllocation = assetAllocation;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public String getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	
}
