// 2.5 大川
package command;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface LoginStaffMap {
	public static final Map<String,String> STMAP = Collections.unmodifiableMap(new HashMap<String,String>()
    {
        {put("staff","staff");}
    });
}
