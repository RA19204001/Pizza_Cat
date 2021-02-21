package command;

import bean.Sales;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.ConnectionManager;
import dao.SalesDao;

public class ShowSalesCommand extends AbstractCommand {

	@Override
	public ResponseContext execute(ResponseContext resc) {
		RequestContext reqc = getRequestContext();

		String[] startDates = reqc.getParameter("startDate");
		String[] endDates = reqc.getParameter("endDate");

		if(startDates == null || endDates == null) {
			return resc;
		}
		String startDate = startDates[0];
		String endDate = endDates[0];

		AbstractDaoFactory factory = AbstractDaoFactory.getFactory();
		ConnectionManager manager = factory.getConnectionManager();
        SalesDao dao = factory.getSalesDao();
		manager.beginTransaction();

		Sales sales = dao.getSales(startDate, endDate);

		manager.commit();
		manager.closeConnection();

		resc.setResult(sales);

		resc.setTarget("sales");

		return resc;
	}

}
