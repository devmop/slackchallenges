package devmop.codeeval.task114;

import java.util.*;

class Item {
    final int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class Package {

    static List<Integer> bestPackage(int limit, List<Item> items) {
        BitSet all = new BitSet(items.size());
        all.set(0, items.size());

        PriorityQueue<BitSet> queue = new PriorityQueue<>((a, b) -> compare(items, a, b));
        queue.add(all);

        while (!queue.isEmpty()) {
            BitSet set = queue.poll();

            if (weight(items, set) <= limit) {
                return indexes(set);
            }

            for (int i = 0; i < items.size(); i++) {
                if (!set.get(i)) {
                    break;
                }

                BitSet clone = (BitSet) set.clone();
                clone.clear(i);
                queue.add(clone);
            }
        }

        return new ArrayList<>();
    }

    private static List<Integer> indexes(BitSet set) {
        ArrayList<Integer> indexes = new ArrayList<>(set.cardinality());

        for (int i = 0; i < set.length(); i++) {
            if (set.get(i)) {
                indexes.add(i + 1);
            }
        }

        return indexes;
    }

    private static int compare(List<Item> items, BitSet a, BitSet b) {
        int result = Integer.compare(value(items, b), value(items, a));

        if (result != 0) {
            return result;
        } else {
            return Integer.compare(weight(items, a), weight(items, b));
        }
    }

    private static int weight(List<Item> items, BitSet set) {
        int sum = 0;
        for (int i = 0; i < items.size(); i++) {
            if (set.get(i)) {
                sum += items.get(i).weight;
            }
        }

        return sum;
    }

    private static int value(List<Item> items, BitSet set) {
        int sum = 0;
        for (int i = 0; i < items.size(); i++) {
            if (set.get(i)) {
                sum += items.get(i).value;
            }
        }

        return sum;
    }
}
