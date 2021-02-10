// 2.5 大川
package command;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface LoginManagerMap {
	public static final Map<String,String> MAMAP = Collections.unmodifiableMap(new HashMap<String,String>()
    {
        {put("kanri","kanri");}
    });
}
