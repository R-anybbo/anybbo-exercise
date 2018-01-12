package com.anybbo;

import lombok.extern.log4j.Log4j2;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: Huopengbo
 * @data: 2018/1/11
 * @time: 13:19
 * @description: .
 */
@Log4j2
public class Exercuse1 {

	static int i = 0;
	static void t1() {
//		Runnable runnable = () -> {
//			i = i + 1;
//		};
//		new Thread(runnable).start();
//		new Thread(runnable).start();
//		log.info(i);

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				log.info("Running");
				try {
					for (int j = 0; j < 5; j++) {
						log.info("Running " + j);
						Thread.sleep(50);
					}
				} catch (Exception ex) {
					log.info("", ex);
				}
				log.info("thread exiting.");
			}
		};

		new Thread(runnable, "test-1").start();
		new Thread(runnable, "test-2").start();
	}

	static void t2() {
		Callable<Integer> callable = () -> new Random().nextInt(100);
		FutureTask<Integer> futureTask = new FutureTask<>(callable);

		new Thread(futureTask).start();

		try {
			Thread.sleep(500);
			log.info(futureTask.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	static void t3() {
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<Integer> future = service.submit(() -> new Random().nextInt(100));

		try {
			Thread.sleep(500);
			log.info(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	volatile int a = 1;
	static void t4() {

	}
}
