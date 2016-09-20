package devmop.codeeval.task114;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static devmop.codeeval.task114.Package.bestPackage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;

public class PackageTest {


    @Test
    public void example1() {
        List<Item> items = Arrays.asList(new Item(45, 5338), new Item(98, 8862), new Item(3, 7848), new Item(76, 7230), new Item(9, 3018), new Item(48, 4634));
        List<Integer> integers = bestPackage(8100, items);

        assertThat(integers, is(Arrays.asList(4)));
    }


    @Test
    public void example2() {
        List<Item> items = Arrays.asList(new Item(34, 1530));
        List<Integer> integers = bestPackage(800, items);

        assertThat(integers, is(empty()));
    }
}