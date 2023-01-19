package pl.swies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import pl.swies.container.DistinctGroup;

public class DistinctGroupTest {

    DistinctGroup distinctGroup1;
    DistinctGroup distinctGroup2;

    @Before
    public void createNewObjects()
    {
        distinctGroup1 = new DistinctGroup();
        distinctGroup2 = new DistinctGroup();
    }

    @Test
    public void test_objects_comparision()
    {
        assertEquals(distinctGroup1, distinctGroup2);
    }

    @Test
    public void test_objects_comparision_after_updating_set() {
        distinctGroup2.increaseLength();
        assertNotEquals(distinctGroup1, distinctGroup2);
    }

    @Test
    public void test_objects_comparision_after_updating_length()
    {
        distinctGroup2.updateSet("a");
        assertNotEquals("Objects are not equals for theirs different sets", distinctGroup1, distinctGroup2);
    }
}
