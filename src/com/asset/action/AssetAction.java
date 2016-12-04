package com.asset.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.asset.pojo.Asset;
import com.asset.pojo.Status;
import com.asset.utils.CsvUtil;
import com.asset.utils.POIExcelAssetBean;
import com.asset.utils.POIExcelBaseBean;
import com.asset.utils.POIExcelUtils;
import com.asset.utils.QRCodeUtil;



public class AssetAction extends BaseAction{
	
	private String text;
	private OutputStream output;
	private File file;
	private String fileName;
	private String temp;
	private List<Asset> assetLists;
	private List<Asset> pdLists;
	private List<Asset> unPdLists;
	private int pdStatus;
	private Asset asset;
	private int id;
	private String ids;
	private String operaRes; // 1 操作成功，2 操作失败
	private String url = "http://10.10.10.21:8080/assetMng/getAssetMessage.action" ;
	private List<String> QRcodeUrl;
	private String [] checkedIds;
	private static int pigeNum =15;
	//总页数
	private int pageSizeALL;
	//当前页
	private int pageSizeCurr =1;
	//所有记录数目
	private int pageNumAll;
	//显示导航数组
	private List<Integer> pagingArr;
	//查询总数量;
	private int querySum;
	
	public String editPdAsset(){
		Status status=new Status();
		status.setPdStatus(pdStatus);
		if(pdStatus==1){
			statusService.updateSataus(status);
		}else{
			statusService.updateSataus(status);
			assetService.exitIfPd(2);
		}
		
		return SUCCESS;
	}
	public String toPdNotAsset(){
		Status s=statusService.getStatus();
		pdLists=new ArrayList<Asset>();
		unPdLists=new ArrayList<Asset>();
		pdStatus=s.getPdStatus();
		if(pdStatus==1){//如果开启盘点
			unPdLists=assetService.listUnPd();
			pageNumAll =unPdLists.size();
		}
		return SUCCESS;
	}
	
	public String toPdAlreadyAsset(){
		Status s=statusService.getStatus();
		pdLists=new ArrayList<Asset>();
		unPdLists=new ArrayList<Asset>();
		pdStatus=s.getPdStatus();
		if(pdStatus==1){//如果开启盘点
			pdLists=assetService.listPd();
			pageNumAll=pdLists.size();
		}
		return SUCCESS;
	}
	public String addByFile(){
		try {
			if(!fileName.endsWith("csv")){
				getSession().setAttribute("tip", "失败，目前仅支持csv格式");
			}else{
				InputStream fs=new FileInputStream(file);
				InputStreamReader fsr=new InputStreamReader(fs,"GBK");
				List<List<String>> lls =CsvUtil.readCSVFile(fsr);
				System.out.println(lls);
				//注意点：csv 顺序：资产编号，设备类别，设备型号，使用人员，使用部门，使用地点，使用状况，设备来源，资产配置，购买时间，开始使用时间
				//		时间格式："yyyy-MM-dd".
				
				for(List<String> ls :lls){
					Asset a=new Asset();
					if(ls.get(0)!=null&&!ls.get(0).equals("")){
						a.setEquipIdentifier(ls.get(0));
					}
					if(ls.get(1)!=null&&!ls.get(1).equals("")){
						a.setEquipGenre(ls.get(1));
					}
					if(ls.get(2)!=null&&!ls.get(2).equals("")){
						a.setEquipModel(ls.get(2));
					}
					if(ls.get(3)!=null&&!ls.get(3).equals("")){
						a.setUsePerson(ls.get(3));
					}
					if(ls.get(4)!=null&&!ls.get(4).equals("")){
						a.setUseDepart(ls.get(4));
					}
					if(ls.get(5)!=null&&!ls.get(5).equals("")){
						a.setUsePosition(ls.get(5));
					}
					if(ls.get(6)!=null&&!ls.get(6).equals("")){
						a.setCondition(ls.get(6));
					}
					if(ls.get(7)!=null&&!ls.get(7).equals("")){
						a.setSource(ls.get(7));
					}
					if(ls.get(8)!=null&&!ls.get(8).equals("")){
						a.setAssetAllocation(ls.get(8));
					}
					SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd");
					if(ls.get(9)!=null&&!ls.get(9).equals("")){
						String temp=ls.get(9).replaceAll("/", "-");
						Date buyTime=sdf.parse(temp);
						a.setBuyTime(buyTime);
					}
					if(ls.get(10)!=null&&!ls.get(10).equals("")){
						temp=ls.get(10).replaceAll("/", "-");
						Date usedTime=sdf.parse(temp);
						a.setUsedTime(usedTime);
						a.setLastTime(new Date());
					}
					if(ls.get(11)!=null&&!ls.get(11).equals("")){
						a.setRemarks(ls.get(11));
					}
					assetService.insert(a);
					getSession().setAttribute("tip", "录入成功");
				}
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "sysError";
			//return "sysError";
		}
		return SUCCESS;
	}
	
	
	public String getAssetMessage(){
		try {
			asset=assetService.getAssetByPrivateKey(id);
			if(null==asset){
				asset=new Asset();
				tip="数据为空，可能已经被删除";
			}else{
				Status s=statusService.getStatus();
				pdStatus=s.getPdStatus();
				if(pdStatus==1){
					asset.setIfPd(1);
					assetService.updateByPrivateKey(asset);
					tip="盘点成功";
				}else{
					
				}
			}
			/*if(getSession().getAttribute("tip")!=null&&getSession().getAttribute("tip")!=""){
				tip=(String) getSession().getAttribute("tip");
				getSession().setAttribute("tip", "");
			};*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "sysError";
		}
		return SUCCESS;
	}
	
	
	public String getQRcode(){
		try {
			output=getResponse().getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return "sysError";
		}
		try {
			QRCodeUtil.encode(text, "C:/Users/Administrator/Desktop/20111014111307895.jpg", output, true);
			output.flush();  
			output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "sysError";
		}
		return null;
	}
	public String exportAssetExcel(){
		List<Asset> assetList=assetService.listAll();
		String excelName="信息表";
		try {
			Workbook wb=getAssetExcel(assetList,excelName);
			OutputStream out = getResponse().getOutputStream();
	        wb.write(out);
	        out.flush();
	        out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getSession().setAttribute("tip", "导出Excel失败");
		}
		return null;
	}
	
	private Workbook getAssetExcel(List<Asset> assetList, String excelName) throws Exception{
	      ArrayList<String> listTitle = new ArrayList<String>();//csv 顺序：资产编号，设备类别，设备型号，使用人员，使用部门，使用地点，使用状况，设备来源，资产配置，购买时间，开始使用时间
	      listTitle.add("资产编号");
	      listTitle.add("设备类别");
	      listTitle.add("设备型号");
	      listTitle.add("使用人员");
	      listTitle.add("使用部门");
	      listTitle.add("使用地点");
	      listTitle.add("使用状况");
	      listTitle.add("设备来源");
	      listTitle.add("资产配置");
	      listTitle.add("购买时间");
	      listTitle.add("开始使用时间");
	      listTitle.add("最后修改时间");
	      listTitle.add("备注");
	      Object[] oarr = listTitle.toArray();
	      //HttpServletResponse response = ServletActionContext.getResponse();
	      getResponse().setContentType("application/vnd.ms-excel;charset=UTF-8");
	      if(getRequest().getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0)// firefox浏览器
	         excelName = new String(excelName.getBytes("UTF-8"), "ISO8859-1");
	      else if(getRequest().getHeader("User-Agent").toLowerCase().indexOf("trident") > 0)// IE浏览器，ie11后请求头中的User-Agent中不再有"MSIE"
	         excelName = URLEncoder.encode(excelName, "UTF-8");
	      else if(getRequest().getHeader("User-Agent").toLowerCase().indexOf("chrome") > 0)// google浏览器
	         excelName = new String(excelName.getBytes("UTF-8"), "ISO8859-1");
	      // 转码防止乱码
	      getResponse().addHeader("Content-Disposition", "attachment;filename=" + excelName + ".xls");
	      List<POIExcelBaseBean> listRows = new ArrayList<POIExcelBaseBean>();
	      SimpleDateFormat fd0 = new SimpleDateFormat("yyyy-MM-dd");
	      SimpleDateFormat fd1 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
	      for(Asset a: assetList){
	         listRows.add(new POIExcelAssetBean(a.getEquipIdentifier(), a.getEquipGenre(), a.getEquipModel(), a.getUsePerson(), a.getUseDepart(), a.getUsePosition(), a.getCondition(), a.getSource(), a.getAssetAllocation(), fd0.format(a.getBuyTime()), fd0.format(a.getUsedTime()),fd1.format(a.getLastTime()),a.getRemarks()));
	      }
	      return POIExcelUtils.OutputExcel(oarr, listRows, 1, null, null);
	   }
	public String listAssetAll(){
		try{
			/*if(temp!=null&&!"".equals(temp)){
				assetLists=assetService.listAssetByKeyAndString(null, temp);
			}else{
				assetLists = assetService.listAll();
			}*/
			assetLists = listAssetAllPage();
			temp=getTemp();
			if(getSession().getAttribute("tip")!=null&&getSession().getAttribute("tip")!=""){
				tip=(String) getSession().getAttribute("tip");
				getSession().setAttribute("tip", "");
			};
		}catch(Exception e){
			e.printStackTrace();
			return "sysError";
		}
		
		return "success";
	}

	public List<Asset> listAssetAllPage() {

		int recordStart = 0;
		int recordEnd = 0;
		if (getSession().getAttribute("oldTemp") != null) {
			if (!getSession().getAttribute("oldTemp").equals(temp)) {
				pageSizeCurr = 1;
			}
		}
		if (pageSizeCurr == 1) {
			assetLists = assetService.listAssetAllPage(temp, 0, pigeNum);
			List<Asset> listAll = assetService.listAssetByKeyAndString(null, temp);
			pageSizeALL = (int) listAll.size() / pigeNum + 1;
			querySum = listAll.size();
		} else {
			List<Asset> listAll = assetService.listAssetByKeyAndString(null, temp);
			pageSizeALL = (int) listAll.size() / pigeNum + 1;
			if (pageSizeCurr >= pageSizeALL) {
				pageSizeCurr = pageSizeALL;
			}
			recordStart = (pageSizeCurr - 1) * pigeNum + 1;
			recordEnd = pigeNum;
			assetLists = assetService.listAssetAllPage(temp, recordStart, recordEnd);
			querySum = listAll.size();
		}
		//产生分页编号
		pagingArr = new ArrayList<Integer>();
		if(pageSizeALL<=3){
			for (int i = 1; i <= pageSizeALL; i++) {
				pagingArr.add(i);
			}
		}else if(pageSizeCurr+2>=pageSizeALL){
			pagingArr.add(pageSizeALL-2);
			pagingArr.add(pageSizeALL-1);
			pagingArr.add(pageSizeALL);	
			}else{
				pagingArr.add(pageSizeCurr);
				pagingArr.add(pageSizeCurr+1);
				pagingArr.add(pageSizeCurr+2);
			}
		
		getSession().setAttribute("oldTemp", temp);
		return assetLists;
	}

	public String fileInputAsset(){
		if(fileName!=null && !fileName.equals(""))
		{
			System.out.println(fileName);
			return "success";
		}else{
			return "success";
		}		
	}
	
	public String assetInfo(){
		try{
			if(id==0){
				asset=new Asset();
			}else{
				asset= assetService.getAssetByPrivateKey(id);
			}
			//asset= assetService.getAssetByPrivateKey(id);
		}catch(Exception e){
			e.printStackTrace();
			return "sysError";
		}
		return "success";
	}
	public String toAddAsset(){
		return assetInfo();
	}
	
	public String addAsset(){
		try{
			asset.setLastTime(new Date());
			assetService.insert(asset);
		}catch(Exception e){
			e.printStackTrace();
			return "sysError";
		}
		return "success";
	}
	
	public String modifyAsset(){
		try{
			asset.setLastTime(new Date());
			assetService.updateByPrivateKey(asset);
		}catch(Exception e){
			e.printStackTrace();
			return "sysError";
		}
		return "success";
	}
	
	//删除单个
	public String deleteAsset(){
		try{
			assetService.delectByPrivateKey(id);
			getSession().setAttribute("tip", "删除成功");
			operaRes = "1";
		}catch(Exception e){
			e.printStackTrace();
			getSession().setAttribute("tip", "删除失败");
			return "success";
		}
		return "success"; 
	}
	
	//删除多个
	public String deleteAssetMany(){
		try{
			String [] assetId = ids.split(",");
			int result =0;
			int a=assetId.length;
			String b=assetId[0];
			if(assetId.length==1&&"".equals(assetId[0])){
				getSession().setAttribute("tip", "请选择需要删除的信息");
			}else{
				for(String as:assetId){
					result=assetService.delectByPrivateKey(Integer.parseInt(as));				
				}
				if(result!=0){
					operaRes ="1";
					getSession().setAttribute("tip", "删除成功");
				}else{
					operaRes ="2";
					getSession().setAttribute("tip", "删除失败");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			getSession().setAttribute("tip", "删除失败，系统有错误");
			return "success";
		}
		return "success";
	}
	
	//产生二维码
	public String genQRcode(){
		try{
			QRcodeUrl = new ArrayList<String>();
			if(checkedIds != null){
				for(String as : checkedIds){
					QRcodeUrl.add("/getQRcode.action?text="+url+"?id="+as);				
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public OutputStream getOutput() {
		return output;
	}
	public void setOutput(OutputStream output) {
		this.output = output;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public List<Asset> getAssetLists() {
		return assetLists;
	}


	public void setAssetLists(List<Asset> assetLists) {
		this.assetLists = assetLists;
	}


	public Asset getAsset() {
		return asset;
	}


	public void setAsset(Asset asset) {
		this.asset = asset;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIds() {
		return ids;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}


	public String getOperaRes() {
		return operaRes;
	}


	public void setOperaRes(String operaRes) {
		this.operaRes = operaRes;
	}


	public String[] getCheckedIds() {
		return checkedIds;
	}


	public void setCheckedIds(String[] checkedIds) {
		this.checkedIds = checkedIds;
	}


	public List<String> getQRcodeUrl() {
		return QRcodeUrl;
	}


	public void setQRcodeUrl(List<String> qRcodeUrl) {
		QRcodeUrl = qRcodeUrl;
	}


	public String getTemp() {
		return temp;
	}


	public void setTemp(String temp) {
		this.temp = temp;
	}
	public List<Asset> getPdLists() {
		return pdLists;
	}
	public void setPdLists(List<Asset> pdLists) {
		this.pdLists = pdLists;
	}
	public List<Asset> getUnPdLists() {
		return unPdLists;
	}
	public void setUnPdLists(List<Asset> unPdLists) {
		this.unPdLists = unPdLists;
	}
	public int getPdStatus() {
		return pdStatus;
	}
	public void setPdStatus(int pdStatus) {
		this.pdStatus = pdStatus;
	}
	public int getPageSizeALL() {
		return pageSizeALL;
	}
	public void setPageSizeALL(int pageSizeALL) {
		this.pageSizeALL = pageSizeALL;
	}
	public int getPageSizeCurr() {
		return pageSizeCurr;
	}
	public void setPageSizeCurr(int pageSizeCurr) {
		this.pageSizeCurr = pageSizeCurr;
	}
	public int getPageNumAll() {
		return pageNumAll;
	}
	public void setPageNumAll(int pageNumAll) {
		this.pageNumAll = pageNumAll;
	}
	
	public int getQuerySum() {
		return querySum;
	}
	public void setQuerySum(int querySum) {
		this.querySum = querySum;
	}
	public static int getPigeNum() {
		return pigeNum;
	}
	public static void setPigeNum(int pigeNum) {
		AssetAction.pigeNum = pigeNum;
	}
	public List<Integer> getPagingArr() {
		return pagingArr;
	}
	public void setPagingArr(List<Integer> pagingArr) {
		this.pagingArr = pagingArr;
	}
	
	
	
	
}
