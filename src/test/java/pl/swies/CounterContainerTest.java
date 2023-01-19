package pl.swies;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pl.swies.container.CounterContainer;
import pl.swies.container.DistinctGroup;

public class CounterContainerTest
{
    @Test
    public void test_DistinctGroups_comparison()
    {
        CounterContainer container = new CounterContainer(new DistinctGroup());
        DistinctGroup distinctGroup = new DistinctGroup();
        assertEquals(true, container.compareGroups(distinctGroup));
    }

    @Test
    public void test_line_creation_and_average_calculation()
    {
        DistinctGroup distinctGroup = new DistinctGroup();
        distinctGroup.updateSet("a");
        distinctGroup.increaseLength();
        distinctGroup.updateSet("e");
        distinctGroup.increaseLength();
        distinctGroup.increaseLength();
        distinctGroup.increaseLength();
        // Word of length of 4 and a & e vowels

        CounterContainer cc = new CounterContainer(distinctGroup);
        cc.increaseCount(2);
        cc.increaseCount(3);

        assertEquals("For four-letter 2 different words of a & e vowels occurring 2 and 3 times average" +
                " num of vovels per them is 2.5:","({a,e}, 4) -> 2.5", cc.createLine());
    }

}
