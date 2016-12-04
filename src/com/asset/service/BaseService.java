package com.asset.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asset.dao.AssetMapper;
import com.asset.dao.StatusMapper;


public class BaseService {
	@Resource
	protected AssetMapper assetMapper;
	@Resource
	protected StatusMapper statusMapper;
}
