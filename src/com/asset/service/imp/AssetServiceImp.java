package com.asset.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asset.pojo.Asset;
import com.asset.service.AssetService;
import com.asset.service.BaseService;
@Service
public class AssetServiceImp extends BaseService implements AssetService {
	@Override
	public List<Asset>  listAssetAllPage(String SearchTemp, int start,int end){
		return assetMapper.listAssetAllPage(SearchTemp, start, end);
	}
	@Override
	public List<Asset> listAll() {
		// TODO Auto-generated method stub
		return assetMapper.listAll();
	}

	@Override
	public boolean insert(Asset asset) {
		// TODO Auto-generated method stub
		try {
			assetMapper.insert(asset);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public int updateByPrivateKey(Asset asset) {
		// TODO Auto-generated method stub
		return assetMapper.updateByPrivateKey(asset);
	}

	@Override
	public int delectByPrivateKey(long id) {
		// TODO Auto-generated method stub
		return assetMapper.delectByPrivateKey(id);
	}

	@Override
	public Asset getAssetByPrivateKey(long id) {
		// TODO Auto-generated method stub
		return assetMapper.getAssetByPrivateKey(id);
	}

	@Override
	public List<Asset> listAssetByKeyAndString(Long id, String SearchTemp) {
		// TODO Auto-generated method stub
		return assetMapper.listAsset(id, SearchTemp);
	}

	@Override
	public List<Asset> listPd() {
		// TODO Auto-generated method stub
		List<Asset> la=assetMapper.listAll();
		List<Asset> l=new ArrayList();
		for(Asset a:la){
			if(a.getIfPd()==1){
				l.add(a);
			}
		}
		return l;
	}

	@Override
	public List<Asset> listUnPd() {
		// TODO Auto-generated method stub
		List<Asset> la=assetMapper.listAll();
		List<Asset> l=new ArrayList();
		for(Asset a:la){
			if(a.getIfPd()!=1){
				l.add(a);
			}
		}
		return l;
	}

	@Override
	public int exitIfPd(int ifPd) {
		// TODO Auto-generated method stub
		return assetMapper.exitIfPd(ifPd);
	}
}
