
import com.sortutils.component.InsertionSort;
import com.sortutils.component.InstrumentationSort;
import com.sortutils.entity.SortResponse;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for InsertionSort
 */
public class InsertionSortTest {


    /* dependencies */
    InstrumentationSort instrumentationSort;

    @Before
    public void run_once_per_test() {
        instrumentationSort = new InsertionSort();
    }


    @Test
    public void sorting_a_collection_of_distances_should_return_ordered_collection() {

        /* given the following array */
        double[] arr = new double[]{7, 3, 9, 1, 2, 4, 5, 6, 82, 0, -1};

        /* when i sort it */
        double[] result = instrumentationSort.sort(arr);

        /* i expect [-1, 0, 1, 2, 3, 4, 5, 6, 7, 9, 82] after sorting */
        Assert.assertThat(result, CoreMatchers.is(new double[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 9, 82}));

    }


    @Test
    public void executing_insertion_sort_returns_json_response() {

        /* given the following array */
        double[] arr = new double[]{7, 3, 9, 1, 2, 4, 5, 6};

        /* when i execute sort */
        SortResponse response = instrumentationSort.execute(arr);

        /* i expect [1, 2, 4, 5, 6, 7, 9] after sorting */
        Assert.assertThat(response.getSortResult(), CoreMatchers.is("[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 9.0]"));

    }




}
