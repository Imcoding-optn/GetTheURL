package analyzingHtml;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import analyzingString.GetItemChar;

/**
 * 引入jsoup
 * 
 */
public class AnalyzingItem {

	private GetItemChar gc = new GetItemChar();//传给处理字符串的类的实例
	private static int index = 0;//视频排序数
	/**
	 * 解析HTML获取视频链接
	 * */
	public void GetVedioTags(String HtmlPath) {
		
		try {
			//从本地文件内解析
			File input = new File(HtmlPath);
			Document doc = Jsoup.parse(input, "UTF-8");
			
			//c-link 是视频链接所在a标签的类  这个标签也包含了视频名
			Elements className = doc.getElementsByClass("c-link");
			Elements linksTags = className.select("a[href]");//
			
			for(Element link:linksTags){
				//解析视频名
				String VedioNameChar = link.text();
				//获得传进来的a标签中的href中的真实视频地址，当然有些href也没有链接 比如  href="javascript:;"  就没有地址 
				String VedioURL = link.attr("href");
				
				/**
				 * 判断是否是符合要求的URL
				 * */
				if(!VedioURL.equals("javascript:;")){
					gc.GetVedioName(VedioNameChar,index);//传给处理字符串的类
					gc.GetVedioUrl(VedioURL);
					gc.GetVedioOldName(VedioURL);
					
					gc.ReNameVedio(VedioURL, VedioNameChar,index);
					index++;
				}
				
//				System.out.println(VedioNameChar);
//				System.out.println(VedioURL);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	


}
