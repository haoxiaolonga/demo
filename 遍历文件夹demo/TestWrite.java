  
package com.petecat.interchan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.util.StringUtils;

import com.petecat.interchan.core.exception.BusinessException;


public class TestWrite {
	
	
	
	
	public static void main(String[] args) {
		
		String path = "*****";
		String outpath = "****outPut.txt";
		String strLine = ""; 
		List<File> allFile= TestFileList.getallfile(path);
		try {
			PrintWriter write = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
			BufferedReader in = null;
			int count = 0;
			for(File f : allFile) {
				try {
					 count = 0;
					 in = new BufferedReader(new FileReader(f));
					 while ((strLine = in.readLine()) != null) {
						 count ++;
						 System.out.println(count);
						 if (strLine.contains("throw new BusinessException")) {
							 write.println("文件:"+ f.getName() + "行号:" + count + ":        " + strLine.trim() );
						 }
					 }
					 
				} catch (Exception e) {
					 e.printStackTrace();
				}
				finally {
					in.close();
				}
				
			}
			write.close();
		} catch (IOException e1) {
			System.out.println("出現异常");
			e1.printStackTrace();
		}
		finally {
			System.out.println("結束");
		}
		
		System.out.println(allFile.size());
	}
	
}
