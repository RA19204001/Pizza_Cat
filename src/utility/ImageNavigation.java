package utility;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import context.RequestContext;

public class ImageNavigation {

		public void imageNavi(String fileName,RequestContext reqc){



//	        try {

			try {
	            //移動元
//	            FileInputStream input=new FileInputStream(fullPath);

        		//Part
	            Part part=((HttpServletRequest)reqc.getRequest()).getPart("file");

	            //移動先
//	            FileOutputStream output=new FileOutputStream("C:\\PizzaCatImage\\"+fileName+".jpg");

	            //ファイル名の取得
	            String filenames=part.getSubmittedFileName();
	            String file=filenames.substring(0,filenames.indexOf("."));

	            //アップロード先の指定
	            String path="c:\\pizza";

	            System.out.println("ファイル名"+fileName+".jpg");

	            part.write(path+File.separator+fileName+".jpg");
//	            byte buf[]=new byte[256];
//	            int len;
//	            while((len=input.read(buf))!=-1){
//	            output.write(buf,0,len);
//            }
//	            output.flush();
//	            output.close();
//	            input.close();

	            System.out.println("ファイル名、場所を変更しました。");
        } catch (Exception e) {
        	e.printStackTrace();
    }
    }
}
