package com.asset.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvUtil {
	public static List<List<String>> readCSVFile(InputStreamReader fr ) throws IOException {  
		BufferedReader  br = new BufferedReader(fr);  
        String rec = null;// 一行  
        String str;// 一个单元格  
        List<List<String>> listFile = new ArrayList<List<String>>();  
        try {  
            // 读取一行  
           /* while ((rec = br.readLine()) != null) {  
                Pattern pCells = Pattern  
                        .compile("(\"[^\"]*(\"{2})*[^\"]*\")*[^,]*,");  
                Matcher mCells = pCells.matcher(rec);  
                List<String> cells = new ArrayList<String>();// 每行记录一个list  
                // 读取每个单元格  
                while (mCells.find()) {  
                    str = mCells.group();  
                    str = str.replaceAll(  
                            "(?sm)\"?([^\"]*(\"{2})*[^\"]*)\"?.*,", "$1");  
                    str = str.replaceAll("(?sm)(\"(\"))", "$2");  
                    cells.add(str);  
                }  
                listFile.add(cells);  
            } */ 
        	 while ((rec = br.readLine()) != null) {  
                 int index=0;  
                 Pattern pCells = Pattern  
                         .compile("(\"[^\"]*(\"{2})*[^\"]*\")*[^,]*,");  
                 Matcher mCells = pCells.matcher(rec);  
                 List<String> cells = new ArrayList<String>();// 每行记录一个list  
                 // 读取每个单元格  
                 while (mCells.find()) {  
                     str = mCells.group();  
                     str = str.replaceAll(  
                             "(?sm)\"?([^\"]*(\"{2})*[^\"]*)\"?.*,", "$1");  
                     str = str.replaceAll("(?sm)(\"(\"))", "$2");  
                     cells.add(str);  
                     index = mCells.end();  
                 }  
                 cells.add(rec.substring(index));  
                 listFile.add(cells);  
             }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (fr != null) {  
                fr.close();  
            }  
            if (br != null) {  
                br.close();  
            }  
        }  
        return listFile;  
    }  
	
	public static void main(String[] args) throws Throwable {   
        List<List<String>> csvList = CsvUtil.readCSVFile(new InputStreamReader(new FileInputStream("C:/Users/Administrator/Desktop/cpc_func_menu_sub.csv")));    
        System.out.println(csvList);
    }
}
