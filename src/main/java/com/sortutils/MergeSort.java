package com.sortutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * An implementation of {@link} that contains methods for performing merge sort.
 *
 * <p>
 * The algorithm uses a divide and conquer technique which was invented by John
 * von Neumann in 1945.
 * (<a href="https://en.wikipedia.org/wiki/Merge_sort">MergeSort</a>)
 *
 * <p>
 * The algorithm offers <strong>O(n log(n))</strong> performance in all cases
 * (worst,average and best case)
 *
 * @author Joshua Nwankwo
 * @version 1.0
 * @since April 2019
 */

@Component("MergeSort")
@Qualifier("MergeSort")
public class MergeSort extends AbstractSort implements IMergeSort {

    private static final Logger LOG = LoggerFactory.getLogger(MergeSort.class);

    /**
     * Calculates and returns an array midpoint.
     *
     * @param arr the input array
     * @return the array midpoint
     */
    public int calculateMidPoint(double[] arr) {
        return arr.length / 2;
    }

    /**
     * Populates the left fragment of the array with left elements from the parent
     * array.
     *
     * @param midPoint the midpoint
     * @param left     left array fragment
     * @param arr      the parent array
     * @return resultant left array
     */
    public double[] loadLeftArray(int midPoint, double[] left, double[] arr) {
        for (int i = 0; i < midPoint; i++) {
            left[i] = arr[i];
        }
        return left;
    }

    /**
     * Populates the right fragment of the array with right elements from the parent
     * array.
     *
     * @param right right array fragment
     * @param arr   the parent array
     * @return resultant right array
     */
    public double[] loadRightArray(double[] right, double[] arr) {
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[((arr.length - right.length) + i)];
        }
        return right;
    }

    /**
     * Will construct the right array based on the midpoint and the parent array. If
     * the length of the parent array is divisible by 2 without a remainder This
     * means the length is an even number and the initial array can be divided into
     * equal parts. However, if it is not divisible by 2 then it is an odd number
     * and an else construction rule is applied.
     *
     * @param midPoint the midpoint
     * @param arr      the parent array
     * @return the right array
     */
    public double[] constructRightArray(int midPoint, double[] arr) {
        if (arr.length % 2 == 0) {
            return new double[midPoint];
        } else {
            return new double[midPoint + 1];
        }
    }

    /**
     * This is a recursive split operation which will split the left side of the
     * array until it gets to the base case and can no longer be splitted any
     * further. It then propagates to the right array fragment and does the same
     * splitting operation.
     * <p>
     * 
     * @param arr the array to be sorted
     * @return the sorted array
     */

    // @Override
    public double[] sort(double[] arr) {
        /* base case condition */
        if (arr.length <= 1)
            return arr;

        int midPoint = calculateMidPoint(arr);
        double[] left = new double[midPoint];
        double[] right = constructRightArray(midPoint, arr);

        /* populate left & right arrays */
        left = loadLeftArray(midPoint, left, arr);
        right = loadRightArray(right, arr);

        return merge(sort(left), sort(right));
    }

    /**
     * Will merge the left and right sides of the array. This will merge left and
     * right array fragments that are on the same level.
     *
     * The leftPtr, rightPtr and resultPtr cannot possibly exceed the length of
     * their respective arrays.
     *
     *
     * @param leftArr  the left array fragment
     * @param rightArr the right array fragment
     * @return the result of merging both arrays
     */
    public double[] merge(double[] leftArr, double[] rightArr) {

        // result which is an ascending array
        double[] result = new double[leftArr.length + rightArr.length];

        // pointer to the current position in left array
        int leftPtr = 0;

        // pointer to the current position in right array
        int rightPtr = 0;

        // pointer to the current position in the sorted array
        int resultIndex = 0;

        while (leftPtr < leftArr.length || rightPtr < rightArr.length) {
            if (leftPtr < leftArr.length && rightPtr < rightArr.length) {
                if (leftArr[leftPtr] < rightArr[rightPtr]) {
                    result[resultIndex] = leftArr[leftPtr];
                    resultIndex++;
                    leftPtr++;
                } else {
                    result[resultIndex] = rightArr[rightPtr];
                    resultIndex++;
                    rightPtr++;
                }
            } else if (leftPtr < leftArr.length) {
                result[resultIndex] = leftArr[leftPtr];
                resultIndex++;
                leftPtr++;
            } else if (rightPtr < rightArr.length) {
                result[resultIndex] = rightArr[rightPtr];
                resultIndex++;
                rightPtr++;
            }
        }
        count++;
        return result;
    }

    /**
     * A forwarding method which overrides the behaviour of the parent abstract
     * method in an attempt to set the number of iterations.
     *
     * @param arr raw input array
     * @return returns {@link SortResponse} which contains a bunch of properties
     */
    @Override
    public SortResponse execute(double[] arr) {
    SortResponse response = super.execute(arr);
    response.setCount(count);
    return response;
    }

}
