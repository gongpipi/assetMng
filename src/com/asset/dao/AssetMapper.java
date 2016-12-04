package com.asset.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.asset.pojo.Asset;

@Component
public interface AssetMapper {
	public void insert(Asset asset);
	public List<Asset> listAll();
	public int updateByPrivateKey(Asset asset);
	public int delectByPrivateKey(long id);
	public Asset getAssetByPrivateKey(long id);
	public List<Asset> listAsset(@Param("tempId") Long id,@Param("tempName") String  tempName);
	public int exitIfPd(int ifPd);
	public List<Asset> listAssetAllPage(@Param("tempName") String  tempName , 
			@Param("recordStart") int recordStart , @Param("recordEnd") int recordEnd);
	public List<Asset> findByIds(List<Long> ids);
}
