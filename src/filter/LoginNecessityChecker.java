//01.27 15:00 大川
//01.29 移行 大川
//0203  クラス名変更、動作改修    染谷
package filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginNecessityChecker{
	  public String isRequredLogin(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{

	    String path = req.getServletPath();
		String judge = "";

		for(int i=0;i<UnNeedLoginPageList.LIST.size();i++){
			if(path.equals(UnNeedLoginPageList.LIST.get(i))){
				judge = "user";
				break;
			}
		}
		for(int i=0;i<ManagerLoginPageList.MLIST.size();i++){
			if(path.equals(ManagerLoginPageList.MLIST.get(i))){
				judge = "manager";
				break;
			}
		}
		return judge;
	}
}
