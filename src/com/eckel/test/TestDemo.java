import com.eckel.test.*;

public class TestDemo {
	private static int objCounter = 0;
	private int id = ++objCounter;
	
	public TestDemo(String s) {
		System.out.println("{CTor} " + s + ": count = " + id);
	}
	
	public void close() {
		System.out.println("Cleaning up: " + id);
	}
	
	public boolean someCondition() { return true; }
	
	public static class Test extends UnitTest {
		TestDemo test1 = new TestDemo("test1");
		TestDemo test2 = new TestDemo("test2");
		
		public void cleanup() {
			test2.close();
			test1.close();
		}
		
		public void AtestA() {
			System.out.println("TestDemo.testA");
			this.assertTrue(test1.someCondition());
		}
		
		public void BtestB() {
			System.out.println("TestDemo.testB");
			this.assertTrue(test2.someCondition());
			this.assertTrue(TestDemo.objCounter != 0);
		}
		// Causes the build to halt:
		//! 
		public void Ctest3() { 
			this.assertTrue(true); 
		}
	}
} ///:~
