
import com.google.gson.JsonSyntaxException;
import com.sortutils.parser.InputValidationParser;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for InputValidationParser
 */
public class InputValidationParserTest {

    private static final String INVALID_JSON = "{\"distances\"[{\"key\":\"cm\",\"value\":1.367},{\"key\":\"km\",\"value\":-1.37},{\"key\":\"km\",\"value\":1.976}]}";
    private static final String VALID_JSON = "{\"distances\":[{\"key\":\"cm\",\"value\":1.367},{\"key\":\"km\",\"value\":-1.37},{\"key\":\"km\",\"value\":1.976}]}";


    @Test(expected = JsonSyntaxException.class)
    public void throw_JsonSyntaxException_when_Json_is_invalid(){
        InputValidationParser.isValidJson(INVALID_JSON);
    }

    @Test
    public void return_true_when_distance_is_valid(){
        boolean result = InputValidationParser.isValidJson(VALID_JSON);
        Assert.assertThat(result,CoreMatchers.is(true));
    }

}
