package command;

// 2.5 大川
import bean.Manager;
import bean.Message;
import context.RequestContext;
import context.ResponseContext;

public class ManagerLoginCommand extends AbstractCommand {

	public ResponseContext execute(ResponseContext resc) {

		RequestContext reqc = getRequestContext();
		String id = reqc.getParameter("id")[0];
		String pass = reqc.getParameter("pass")[0];

		System.out.println(id);
		System.out.println(pass);

		Manager manager = new Manager();
		manager.setId(id);
		manager.setPass(pass);

		Message message=new Message();

			for(int i=0;i<LoginManagerMap.MAMAP.size();i++){
				if(pass.equals((String)LoginManagerMap.MAMAP.get(id))){
					manager.setToken("1");
					resc.setResult(manager);
					resc.setTarget("managementTop");
					break;
				}else if(pass.equals((String)LoginStaffMap.STMAP.get(id))){
					//店員側のリストから検索,今は（仮）
					manager.setToken("2");
					resc.setResult(manager);
					resc.setTarget("managementTop");
				}else{
					message.setMessage("IDまたはパスワードが違います。");
					resc.setResult(message);
					resc.setTarget("managementLogin");
				}
			}
		return resc;
	}

}
