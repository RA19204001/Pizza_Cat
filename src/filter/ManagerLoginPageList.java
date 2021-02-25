package filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface ManagerLoginPageList {
		static final List<String> MLIST = Collections.unmodifiableList(new ArrayList<String>()
	    {
	        {add("/managementTop");}
	        {add("/addProducts");}
	        {add("/addProductsResult");}
	        {add("/editDisplay");}
	        {add("/editDisplayResult");}
	        {add("/sales");}
	        {add("/showSales");}
	        {add("/addressee");}
	        {add("/doneDelivery");}
	        {add("/addPizzaOptionResult");}
	        {add("/addSideResult");}
	    });
	}
