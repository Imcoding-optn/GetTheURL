package analyzingString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import saveInfo.SaveItemChar;


/**
 * 处理解析过来的字符串，提取各种所需的信息
 * */
public class GetItemChar {
 	private static SaveItemChar st = new SaveItemChar();

	public  void GetVedioUrl(String URLChar){
		st.saveFile("视频直链地址.txt", URLChar);
	}
	
	/**
	 * 得到要给视频重命名的名字
	 * */
	public  void GetVedioName(String NameChar){
		st.saveFile("desName.txt", NameChar.replace("？", ""));//除去创建文件名时有影响的字符串  （虽然此处是中文问号  对文件名来说无影响 但是还是去掉）
	}
	
	/**
	 * 获取下载后的视频名  也就是未重命名前的视频名
	 * 传进来的参数为     http://v.stu.126.net/mooc-video/nos/mp4/2015/11/18/2491001_hd.mp4
	 * */
	public  void GetVedioOldName(String URLChar){
		String SrcVedioName = URLChar.substring(URLChar.lastIndexOf("/")+1);//直接获取最后一个/后的内容
		st.saveFile("srcName.txt", SrcVedioName);
		//System.out.println(SrcVedioName);
	}
	
	/**
	 * 生成bat批处理命令 重命名视频
	 * @param URLChar:视频直链地址 <br />
	 * @param NewChar:要改成的名字 <br />
	 * @param index:视频排序数 (一门课总要按顺序来学吧)<br />
	 * */
	public  void ReNameVedio(String URLChar,String NewChar,int index){
		String  OldChar = URLChar.substring(URLChar.lastIndexOf("/")+1);
		String NewName =  "ren "+OldChar+" "+index+"-"+NewChar.replace("？", "")+".mp4";//使用批处理改名   
		st.saveFile("重命名命令", NewName);
	}

	
	
}
