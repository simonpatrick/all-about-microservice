package io.hedwig.jpasamples.tools;

import io.hedwig.jpasamples.tools.mockobject.TestCase1;
import io.hedwig.jpasamples.tools.mockobject.TestCase2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by patrick on 16/1/16.
 */
public class BeanMapperTest {

    @org.junit.Test
    public void testMap() throws Exception {
        TestCase1 testCase1= new TestCase1();
        testCase1.setName("test");
        testCase1.setPassword("test1");
        assertNotNull(BeanMapper.map(testCase1, TestCase2.class));
        assertThat(BeanMapper.map(testCase1, TestCase2.class).getName(), is("test"));
    }

    @org.junit.Test
    public void testMapList() throws Exception {

    }
}