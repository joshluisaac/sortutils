
import com.sortutils.util.DistanceUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DistanceUtils_Spec {

    /* dependencies */
    DistanceUtils distanceUtils;

    @Before
    public void run_once_per_test() {
        distanceUtils = new DistanceUtils();
    }

    @Test
    public void i_expect_duplicates_removed_after_unique_operation(){
        //Given a list of duplicate elements
        List<Number> duplicates = Arrays.asList(1,1.9,1.8,1.3,-0.5,9.34,1.3,1,1);

        //when i remove duplicates
        List<?> unique = distanceUtils.unique(duplicates);
        System.out.println(unique.toString());

        /* i expect duplicates removed */
        Assert.assertThat(unique, CoreMatchers.is(Arrays.asList(1, 1.9, 1.8, 1.3, -0.5, 9.34)));

    }

}
