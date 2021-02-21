package command;

import bean.AddresseeList;
import bean.Message;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.DeliveryDao;
import exception.PizzaViewFailedException;

public class AddresseeCommand extends AbstractCommand {

    @Override
    public ResponseContext execute(ResponseContext resc) {

        AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
        DeliveryDao deld = factory.getDeliveryDao();
        ConnectionManager cm = factory.getConnectionManager();
        AddresseeList addresseeList = new AddresseeList();

        cm.beginTransaction();

        try {

        	addresseeList = deld.getAddresseeList();

            resc.setResult(addresseeList);
            resc.setTarget("addressee");

        }catch(PizzaViewFailedException e) {

        Message message=new Message();
        message.setMessage("注文一覧を表示できません");
        e.printStackTrace();

        }
        cm.commit();
        cm.closeConnection();

        return resc;
    }
}