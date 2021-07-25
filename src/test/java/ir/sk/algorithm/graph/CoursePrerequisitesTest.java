package ir.sk.algorithm.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 7/25/2021.
 */
public class CoursePrerequisitesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void coursePrerequisites() {
        String c1 = "CSC100";
        String c2 = "CSC200";
        String c3 = "CSC300";
        Map<String, List<String>> map = new HashMap<>();
        map.put(c3, Arrays.asList(c1, c2));
        map.put(c2, Arrays.asList(c1));
        map.put(c1, Arrays.asList());
        CoursePrerequisites prerequisites = new CoursePrerequisites(map);
        prerequisites.coursePrerequisites().forEach(s -> System.out.println(s));
    }
}