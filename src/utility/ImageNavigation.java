package utility;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import context.RequestContext;

public class ImageNavigation {
	Map fields = new HashMap();
	public Map imageNavi(String id,RequestContext reqc){
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();

		//使ってない、デバッグ用の処理
		String path = req.getServletContext().getRealPath("data");
		System.out.println("ImageUploadManager:path="+path);

		DiskFileItemFactory factory = new DiskFileItemFactory();
	    ServletFileUpload sfu = new ServletFileUpload(factory);

	    try {
	        List list = sfu.parseRequest(req);
	        Iterator iterator = list.iterator();
	        System.out.println(list.size());

	        //送られてきたデータの個数分回る
	        while(iterator.hasNext()){
	          FileItem item = (FileItem)iterator.next();
	          //画像かそうでないか判別
	          if (!item.isFormField()){
	            String filename = item.getName();

	            //画像かつファイルの名前が取得出来てたら保存する
	            if ((filename != null) && (!filename.equals(""))) {
	            	id=(Integer.toString(Integer.parseInt(id)+1));
	            	System.out.println(id);
	              item.write(new File("\\\\172.19.253.32\\public\\2020\\卒業制作\\PizzaCat\\WebContent\\pizza\\" + id + ".jpg"));

	              //ファイルの名前をMapに格納
	              fields.put("itemImage",filename);
	            }
	          }else if (item.isFormField()) {
	        	  this.setFormField(item);
	          }
	        }
	      }catch (FileUploadException e) {
	        e.printStackTrace();
	      }catch (Exception e) {
	        e.printStackTrace();
	      }
	    return fields;
	}

	//画像以外を取得したときに呼び出される処理
	//name属性とその中身をMapに格納する
	private void setFormField(FileItem item) throws ServletException {
		try {
			String name = item.getFieldName();
			String field = item.getString("UTF8");

			fields.put(name,field);
			System.out.println("ImageUploadManager:name="+name+",field="+field);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public Map getFields() {
		return fields;
	}
}
