//0203 染谷
package filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface UnNeedLoginPageList{
    static final List<String> LIST = Collections.unmodifiableList(new ArrayList<String>()
    {
        {add("/view");}
        {add("/start");}
        {add("/addUserResult");}
        {add("/addUser");}
        {add("/login");}
        {add("/menu");}
        {add("/managementTop");}

    });
}