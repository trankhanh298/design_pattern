package com.tk.singleton;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

    @Test
    public void test1() {
        SingletonSystemConfigV1 instance1 = SingletonSystemConfigV1.getInstance();
        SingletonSystemConfigV1 anotherInstance1 = SingletonSystemConfigV1.getInstance();
        Assert.assertTrue("They have to share same reference", instance1 == anotherInstance1);

        // should test concurrently with ExecutorService, but lazy now :)
    }

    @Test
    public void test2() {
        SingletonSystemConfigV2 instance2 = SingletonSystemConfigV2.getInstance();
        SingletonSystemConfigV2 anotherInstance2 = SingletonSystemConfigV2.getInstance();
        Assert.assertTrue("They have to share same reference", instance2 == anotherInstance2);
    }
}
