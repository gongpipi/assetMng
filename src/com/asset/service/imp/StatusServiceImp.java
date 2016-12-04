package com.asset.service.imp;

import org.springframework.stereotype.Service;

import com.asset.pojo.Status;
import com.asset.service.BaseService;
import com.asset.service.StatusService;
@Service
public class StatusServiceImp extends BaseService implements StatusService{

	@Override
	public Status getStatus() {
		// TODO Auto-generated method stub
		return statusMapper.getStatus();
	}

	@Override
	public void updateSataus(Status status) {
		// TODO Auto-generated method stub
		statusMapper.updateSataus(status);
	}

}
