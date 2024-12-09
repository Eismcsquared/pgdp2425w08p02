package powerset;

import java.util.LinkedList;
import java.util.List;

public class Main {

    private static <T> LinkedList<LinkedList<T>> addToAll(LinkedList<LinkedList<T>> list, T value) {
        if (list.isEmpty()) {
            return new LinkedList<>();
        }
        LinkedList<LinkedList<T>> copy = new LinkedList<>(list);
        LinkedList<T> last = new LinkedList<>(copy.removeLast());
        last.add(value);
        LinkedList<LinkedList<T>> result = addToAll(copy, value);
        result.add(last);
        return result;
    }

    private static <T> LinkedList<T> concatenate(LinkedList<T> l1, LinkedList<T> l2) {
        if (l2.isEmpty()) {
            return new LinkedList<>(l1);
        }
        LinkedList<T> copy1 = new LinkedList<>(l1);
        LinkedList<T> copy2 = new LinkedList<>(l2);
        copy1.add(copy2.removeFirst());
        return concatenate(copy1, copy2);
    }

    /**
     * @param inputSet from this set all power sets should be returned as a list.
     */

    static LinkedList<LinkedList<Integer>> powerSet(LinkedList<Integer> inputSet) {
        if (inputSet.isEmpty()) {
            LinkedList<LinkedList<Integer>> result = new LinkedList<>();
            result.add(new LinkedList<>());
            return result;
        }
        // Kopie anlegen, damit der Parameter danach unverändert bleibt.
        LinkedList<Integer> copy = new LinkedList<>(inputSet);
        int last = copy.removeLast();
        LinkedList<LinkedList<Integer>> powerSetWithoutLast = powerSet(copy);
        LinkedList<LinkedList<Integer>> powerSetWithLast = addToAll(powerSetWithoutLast, last);
        return concatenate(powerSetWithoutLast, powerSetWithLast);
    }

    /**
     * @param inputSet all power sets from this set with sum
     * @param sum      should be returned as a list.
     */
    static LinkedList<Integer> findWithSum(LinkedList<Integer> inputSet, int sum) {
        if (sum == 0) {
            return new LinkedList<>();
        }
        if (inputSet.isEmpty()) {
            return null;
        }
        LinkedList<Integer> copy = new LinkedList<>(inputSet);
        int current = copy.removeFirst();
        LinkedList<Integer> result = findWithSum(copy, sum - current);
        if (result != null) {
            result.addFirst(current);
            return result;
        }
        return findWithSum(copy, sum);
    }


    public static void main(String[] args) {
        // TODO : Test your implementation here.

        //generate an example list to test.
        LinkedList<Integer> inputSet = new LinkedList<>();
        inputSet.add(1);
        inputSet.add(2);
        inputSet.add(3);

        //find all power sets of the set and print them.
        System.out.println("Finding all power sets");
        LinkedList<LinkedList<Integer>> subsets = powerSet(inputSet);
        subsets.forEach(System.out::println);
        System.out.println();

        //find the subset from the set with sum and print them.
        int sum = 5;
        System.out.println("Finding subset with sum " + sum);
        LinkedList<Integer> subsetWithSum = findWithSum(inputSet, sum);
        System.out.println(subsetWithSum);
    }
}
