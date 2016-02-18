package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Veronika Rodionova nika.blaine@gmail.com
 */
public class JokesterTest extends ApplicationTestCase<Application> implements JokeListener {

    private String joke;

    public JokesterTest() {
        super(Application.class);
    }

    @Test
    public void test() {
        CountDownLatch latch = new CountDownLatch(1);
        new EndpointsAsyncTask(this).execute();
        try {
            latch.await(1000, TimeUnit.MILLISECONDS);
            assertEquals("This is a joke", joke);
        } catch (InterruptedException e) {
            fail();
        }
    }

    @Override
    public void onJoke(String joke) {
        this.joke = joke;
    }
}
