package com.khan.designpatterns.singleton;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import com.khan.designpatterns.singleton.SingletonPatternTest.SingletonBlockProducer.WrapperBlock;
import com.khan.designpatterns.singleton.SingletonPatternTest.SingletonInstanceProducer.WrapperInstance;

public class SingletonPatternTest {

	@Test
	public void testSingletonPatternWithEnum() {
		SingletonWithEnum singletonWithEnum = SingletonWithEnum.INSTANCE;
		SingletonWithEnum singletonWithEnum2 = SingletonWithEnum.INSTANCE;

		assertEquals(singletonWithEnum, singletonWithEnum2);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testSingletonPatternWithStaticField() throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		Callable<WrapperInstance> producer1 =  new SingletonInstanceProducer();
		Callable<WrapperInstance> producer2 =  new SingletonInstanceProducer();
		Callable<WrapperInstance> producer3 =  new SingletonInstanceProducer();
		Callable<WrapperInstance> producer4 =  new SingletonInstanceProducer();
		Callable<WrapperInstance> producer5 =  new SingletonInstanceProducer();
		
		Future<WrapperInstance> fu1 = service.submit(producer1);
		Future<WrapperInstance> fu2 = service.submit(producer2);
		Future<WrapperInstance> fu3 = service.submit(producer3);
		Future<WrapperInstance> fu4 = service.submit(producer4);
		Future<WrapperInstance> fu5 = service.submit(producer5);
		
		
		WrapperInstance result5 = fu5.get();
		WrapperInstance result4 = fu4.get();
		WrapperInstance result3 = fu3.get();
		WrapperInstance result2 = fu2.get();
		WrapperInstance result1 = fu1.get();

		
		// if we remove *synchronized* keyword in getInstance method, u will face an error likes below
		// java.lang.AssertionError: expected:<com.khan.designpatterns.singleton.SingletonWithStaticInstance@643b1d11> but was:<com.khan.designpatterns.singleton.SingletonWithStaticInstance@2ef5e5e3>

		assertEquals(result1.getData(), result2.getData());
		assertEquals(result1.getData(), result3.getData());
		assertEquals(result1.getData(), result4.getData());
		assertEquals(result1.getData(), result5.getData());
	}
	
	@SuppressWarnings("rawtypes")
	public class SingletonInstanceProducer<WrapperInstance> implements Callable {

		public WrapperInstance call() throws Exception {
			SingletonWithStaticInstance data = SingletonWithStaticInstance.getInstance();
			WrapperInstance wrapper = new WrapperInstance();
			wrapper.setData(data);
			return wrapper;
		}


		// FIXME cannot use SingletonWithStaticInstance as generic type here
		// so i did introduce a Wrapper class
		public class WrapperInstance {
			private SingletonWithStaticInstance data;
			
			public SingletonWithStaticInstance getData() {
				return this.data;
			}
			
			public void setData(SingletonWithStaticInstance data) {
				this.data = data;
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testSingletonPatternWithStaticBlock() throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		Callable<WrapperBlock> producer1 =  new SingletonBlockProducer();
		Callable<WrapperBlock> producer2 =  new SingletonBlockProducer();
		Callable<WrapperBlock> producer3 =  new SingletonBlockProducer();
		Callable<WrapperBlock> producer4 =  new SingletonBlockProducer();
		Callable<WrapperBlock> producer5 =  new SingletonBlockProducer();
		
		Future<WrapperBlock> fu1 = service.submit(producer1);
		Future<WrapperBlock> fu2 = service.submit(producer2);
		Future<WrapperBlock> fu3 = service.submit(producer3);
		Future<WrapperBlock> fu4 = service.submit(producer4);
		Future<WrapperBlock> fu5 = service.submit(producer5);
		
		
		WrapperBlock result5 = fu5.get();
		WrapperBlock result4 = fu4.get();
		WrapperBlock result3 = fu3.get();
		WrapperBlock result2 = fu2.get();
		WrapperBlock result1 = fu1.get();

		
		// if we remove *synchronized* keyword in getInstance method, u will face an error likes below
		// java.lang.AssertionError: expected:<com.khan.designpatterns.singleton.SingletonWithStaticInstance@643b1d11> but was:<com.khan.designpatterns.singleton.SingletonWithStaticInstance@2ef5e5e3>

		assertEquals(result1.getData(), result2.getData());
		assertEquals(result1.getData(), result3.getData());
		assertEquals(result1.getData(), result4.getData());
		assertEquals(result1.getData(), result5.getData());
	}
	

	@SuppressWarnings("rawtypes")
	public class SingletonBlockProducer<WrapperBlock> implements Callable {

		public WrapperBlock call() throws Exception {
			SingletonWithStaticBlock data = SingletonWithStaticBlock.getInstance();
			WrapperBlock wrapper = new WrapperBlock();
			wrapper.setData(data);
			return wrapper;
		}


		// FIXME cannot use SingletonWithStaticInstance as generic type here
		// so i did introduce a Wrapper class
		public class WrapperBlock {
			private SingletonWithStaticBlock data;
			
			public SingletonWithStaticBlock getData() {
				return this.data;
			}
			
			public void setData(SingletonWithStaticBlock data) {
				this.data = data;
			}
		}
	}
}
