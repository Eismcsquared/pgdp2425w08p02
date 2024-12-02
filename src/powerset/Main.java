package powerset;

import java.util.LinkedList;

public class Main {


    /**
     * @param inputSet from this set all power sets should be returned as a list.
     */

    static LinkedList<LinkedList<Integer>> powerSet(LinkedList<Integer> inputSet) {
        // TODO
        return null;
    }

    /**
     * @param inputSet all power sets from this set with sum
     * @param sum      should be returned as a list.
     */
    static LinkedList<Integer> findWithSum(LinkedList<Integer> inputSet, int sum) {
        // TODO
        return null;
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
