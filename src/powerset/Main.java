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

    /**
     * @param inputSet from this set all power sets should be returned as a list.
     */

    static LinkedList<LinkedList<Integer>> powerSet(LinkedList<Integer> inputSet) {
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        if (inputSet.isEmpty()) {
            result.add(new LinkedList<>());
            return result;
        }
        // Kopie anlegen, damit der Parameter danach unverändert bleibt.
        LinkedList<Integer> copy = new LinkedList<>(inputSet);
        int last = copy.removeLast();
        LinkedList<LinkedList<Integer>> powerSetWithoutLast = powerSet(copy);
        LinkedList<LinkedList<Integer>> powerSetWithLast = addToAll(powerSetWithoutLast, last);
        result.addAll(powerSetWithoutLast);
        result.addAll(powerSetWithLast);
        return result;
    }

    /**
     * @param inputSet all power sets from this set with sum
     * @param sum      should be returned as a list.
     */
    static LinkedList<Integer> findWithSum(LinkedList<Integer> inputSet, int sum) {
        if (sum == 0) {
            return new LinkedList<>();
        }
        if (inputSet.isEmpty() || sum < 0) {
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
