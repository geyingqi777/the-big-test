package gyq.java.algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * The common interface of most sorting algorithms
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 **/
public interface SortAlgorithm {

    /**
     * Main method arrays sorting algorithms
     *
     * @param array - an array should be sorted
     * @return a sorted array
     */
    <T extends Comparable<T>> T[] sort(T[] array);

    /**
     * Auxiliary method for algorithms what wanted to work with lists from JCF
     *
     * @param array - a list should be sorted
     * @return a sorted list
     */
    @SuppressWarnings("unchecked")
    default <T extends Comparable<T>> List<T> sort(List<T> array) {
        return Arrays.asList(sort(array.toArray((T[]) new Comparable[array.size()])));
    }

}
