package com.example.mihirnewalkar.builditbigger;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.util.Log;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static junit.framework.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;


@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    public EndpointsAsyncTaskTest() {
    }

    @Test
    public void testGetJokeTask() throws ExecutionException, InterruptedException {
        Log.i("EndpointsAsyncTaskTest","Hello");
        EndpointsAsyncTask testJoke = new EndpointsAsyncTask(new EndpointsAsyncTask.Callback() {
            @Override
            public void onFinished(String result) {

            }
        });
        testJoke.execute(new Pair<Context, String>(getTargetContext(),"MainFred"));
        String joke = testJoke.get();
        Log.i("EndpointsAsyncTaskTest","joke = " + joke);
        assertNotNull(joke);
    }
}