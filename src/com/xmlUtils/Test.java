package com.xmlUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Test {
	
	public static void main(String[] args) throws Exception {
		long nowTime = System.currentTimeMillis();
		XmlTool tool = new XmlTool(Paths.standardForderPath, Paths.selfForderPath);
		
 		List<File> standaredList = tool.standaredList;
		List<File> selfsList = tool.selfsList;
		
		int i = 0;
		int time = standaredList.size();
		for(int a= 0; a < time; a++){
			File[] xmls = tool.provideXML(standaredList, selfsList);
			if(xmls != null && xmls.length > 0){
				System.out.println("提取的标准文件：" + xmls[0].getName());
				System.out.println("提取的我方文件：" + xmls[1].getName());
				try {
					tool.compareAndCreate(xmls[0], xmls[1]);
				} catch (IOException e) {
					e.printStackTrace();
				}
				i = standaredList.size();
				System.out.println("还剩" + i + "份等待重组");
				if(i > 0){
					System.out.println("===========================================================================================");
				}else{
					System.out.println("=======================================重组完成=============================================");
				}
				
			}
		}
		System.out.println("耗时 : "+(System.currentTimeMillis() - nowTime) / 1000f + " 秒 ");
	}
}
