package com.asset.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.asset.pojo.Asset;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class AssetMapperTest {
	@Autowired
	private AssetMapper assetMapper;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		//fail("Not yet implemented");
		Asset a=new Asset();
		a.setEquipModel("毕aaa设");
		a.setAssetAllocation("aaa");
		a.setEquipGenre("aa");
		a.setEquipIdentifier("aaaa");
		a.setUseDepart("aa");
		a.setUsedTime(new Date());
		a.setUsePerson("aa");
		a.setUsePosition("aa");
		//a.setId((long)1);
		a.setCondition("gggg");
		a.setBuyTime(new Date());
		a.setSource("sssssss");
		a.setLastTime(new Date());
		//System.out.println(assetMapper.insert(a));
		System.out.println(a.getId());
	}

	@Test
	public void testListAll() {
		//fail("Not yet implemented");
		System.out.println(assetMapper.listAll());
	}

	@Test
	public void testUpdateByPrivateKey() {
		//fail("Not yet implemented");
		Asset a=new Asset();
		a.setEquipModel("bijiben");
		a.setAssetAllocation("aaa");
		a.setEquipGenre("aa");
		a.setEquipIdentifier("aaaa");
		a.setUseDepart("aa");
		a.setUsedTime(new Date());
		a.setUsePerson("aa");
		a.setUsePosition("aa");
		a.setId((long)1);
		a.setCondition("aaaa");
		a.setBuyTime(new Date());
		a.setLastTime(new Date());
		a.setSource("sssssss");
		assetMapper.updateByPrivateKey(a);
	}
	@Test
	public void testdelectByPrivateKey(){
		assetMapper.delectByPrivateKey(5);
	}
	@Test
	public void testgetAssetByPrivateKey(){
		Asset a =assetMapper.getAssetByPrivateKey(1);
		System.out.println(a);
	}
	@Test
	public void testlistAsset(){
		System.out.println(assetMapper.listAsset(null, "aaa"));
	}

	@Test
	public void testListAssetById(){
		List<Long> assets = new ArrayList<Long>();
		assets.add((long) 211);
		assets.add((long) 213);
		assets.add((long) 222);
		assets.add((long) 228);
		List<Asset> result= assetMapper.findByIds(assets);
		System.out.println(result.size());
	}
}
