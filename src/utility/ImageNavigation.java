package utility;

//2/10 大川
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageNavigation {

		public void imageNavi(String fullPath,String fileName){



	        try {
		            //移動元
		            FileInputStream input=new FileInputStream(fullPath);
		            //移動先
		            FileOutputStream output=new FileOutputStream("C:\\PizzaCatImage\\"+fileName+".jpg");

		            byte buf[]=new byte[256];
		            int len;
		            while((len=input.read(buf))!=-1){
		            output.write(buf,0,len);
	            }
		            output.flush();
		            output.close();
		            input.close();

		            System.out.println("ファイル名、場所を変更しました。");
	        } catch (Exception e) {
        }
    }
}
