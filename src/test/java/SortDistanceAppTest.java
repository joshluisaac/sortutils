import com.sortutils.JsonSampleDocument;
import org.junit.Test;

import java.lang.reflect.Method;

public class SortDistanceAppTest {

    @Test
    public void execute_sorting_integration_test() throws Exception {
        Class<?> cls = Class.forName("com.sortutils.SortDistanceApp");
        Method method = cls.getMethod("main", String[].class);
        String[] params = new String[2];
        params[0] = JsonSampleDocument.JSON_TEXT;
        method.invoke(null, (Object) params);
    }


}
