package saveInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveItemChar {

	/**
	 * 文件默认路径
	 */
	private static String FilePath="src/";

    public void saveFile(String FileName,String FileContent){
    	//文件名和路径
    	String theFile = FilePath+FileName;
    	File file = new File(theFile);
    	
    	if(!file.exists()){
    		try {
				file.createNewFile();
				System.out.println("文件>"+FileName+"<已创建");
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	
    	//追加写入
    	writeContent(theFile,FileContent);
    }
    
    /**
	 * 写入内容
	 * */
    public void writeContent(String thefile,String FileContent){
    	FileWriter fw = null;
    	BufferedWriter bufw = null;
    	
    	try {
    		//追加写入
			fw = new FileWriter(thefile,true);
			bufw = new BufferedWriter(fw);
			bufw.write(FileContent+"\r\n");//加入换行
			bufw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(bufw != null)
					bufw.close();
				if(fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	System.out.println("写入：====="+FileContent+"=====完成");
    	
    }
	
}
