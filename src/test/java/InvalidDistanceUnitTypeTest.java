import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import com.sortutils.JsonSampleDocument;
import com.sortutils.exception.InvalidDistanceUnitTypeException;
import com.sortutils.handler.DistanceHandlerFactory;
import com.sortutils.handler.IDistanceHandlerFactory;

public class InvalidDistanceUnitTypeTest {
	
	//test dependency
	IDistanceHandlerFactory factory;
	
    @Before
    public void run_once_per_test() {
    	factory = new DistanceHandlerFactory();
    }
	
	
    @Test(expected = InvocationTargetException.class)
    public void throw_InvalidDistanceUnitType_Exception_when_Json_is_invalid()  throws Exception{
        Class<?> cls = Class.forName("com.sortutils.SortDistanceApp");
        Method method = cls.getMethod("main", String[].class);
        String[] params = new String[2];
        params[0] = JsonSampleDocument.INVALID_JSON_TEXT;
        method.invoke(null, (Object) params);
    }
	

}
