package com.petecat.interchan;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**   
 * @ClassName:  TestFileList   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: haoxiaolong
 * @date:   2018年10月24日 下午3:07:39   
 */
public class TestFileList {
	
	 public static List<File> getallfile(String path) {
	        List<File> allfilelist = new ArrayList<File>();
	        return getallfile(new File(path), allfilelist);
	    }
	 
	    /**
	     * @Title: getallfile
	     * @Description: 获取当前文件夹下的所有文件
	     * @author ruby
	     * @return void 返回类型
	     * @date 2018年1月4日 下午2:15:38 @throws
	     */
	    public static List<File> getallfile(File file, List<File> allfilelist) {
	        if (file.exists()) {
	            //判断文件是否是文件夹，如果是，开始递归
	            if (file.isDirectory()) {
	                File f[] = file.listFiles();
	                for (File file2 : f) {
	                    getallfile(file2, allfilelist);
	                }
	            } else {
	            	if(file.getName().endsWith(".java")) {
	            		allfilelist.add(file);
	            	}
	                
	            }
	        }
	        return allfilelist;
	      }
}
