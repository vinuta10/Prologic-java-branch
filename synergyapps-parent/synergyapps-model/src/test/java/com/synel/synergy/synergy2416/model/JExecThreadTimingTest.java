package com.synel.synergy.synergy2416.model;

import static org.junit.Assert.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JExecThreadTimingTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws ExecutionException,InterruptedException {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		long time1 = System.nanoTime();
		final Callable call = new Callable() {
	        @Override
	        public Object call() throws Exception {
	             try {
	                Thread.sleep(2000);
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }
	            return 0;
	        }
	    };

	    System.out.println("Submitting");
	    
	    final Future<Object> future = exec.submit(call);
	    try {
	        future.get(1000, TimeUnit.MILLISECONDS);

	        long time2 = System.nanoTime();
	        System.out.println("No timeout after " + 
	                             (time2-time1)/1000000000.0 + " seconds");

	        fail("expected TimeoutException");
	    } catch (TimeoutException ignore) {
	        long time2 = System.nanoTime();
	        System.out.println("Timed out after " +
	                             (time2-time1)/1000000000.0 + " seconds");
	    }
	    finally {
	        exec.shutdown();
	    }
	}

}
