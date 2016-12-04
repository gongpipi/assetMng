package com.asset.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.asset.pojo.Asset;


public interface AssetService {
	public List<Asset> listAll();
	public List<Asset> listPd();
	public List<Asset> listUnPd();
	public boolean insert(Asset asset);
	public int updateByPrivateKey(Asset asset);
	public int delectByPrivateKey(long id);
	public Asset getAssetByPrivateKey(long id);
	public List<Asset> listAssetByKeyAndString(Long id,String SearchTemp);
	public int exitIfPd(int ifPd);
	public List<Asset>  listAssetAllPage(String SearchTemp, int start,int end);
}
