//0203 染谷
package filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface UnNeedLoginPageList{
    static final List<String> LIST = Collections.unmodifiableList(new ArrayList<String>()
    {
        {add("/start");}
        {add("/addUserResult");}
        {add("/addUser");}
        {add("/login");}
        {add("/menu");}
        {add("/management");}
        {add("/managementLogin");}
        {add("/managementTop");}
        {add("/addProducts");}
        {add("/addProductsResult");}
        {add("/editDisplay");}
        {add("/editDisplayResult");}
        {add("/managerlogout");}
        {add("/sales");}
        {add("/showSales");}
        {add("/addressee");}
        {add("/doneDelivery");}
    });
}