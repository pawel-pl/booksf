package novel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadTest {

	private int i;

	public ThreadTest(int input) {
		i = input;
	}

	public int getI() {
		return i;
	}

	public void setI(int value) {
		i = value;
	}

	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(11, 12, 13, 14, 15));
		List<Integer> l3 = new ArrayList<Integer>(Arrays.asList(21, 22, 23, 24, 25));

		ThreadTest t = new ThreadTest(1);

		Thread1 t1 = new Thread1(l1, t);
		Thread2 t2 = new Thread2(l2, t);
		Thread3 t3 = new Thread3(l3, t);

		t1.start();
		t2.start();
		t3.start();

	}
}

class Thread1 extends Thread {

	private List<Integer> l;
	private ThreadTest t;

	public Thread1(List<Integer> list, ThreadTest tIN) {
		l = list;
		t = tIN;
	}

	public void run() {
		int i = 0;
		while (i < l.size()) {
			synchronized (t) {
				if (t.getI() != 1) {
					try {
						t.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(l.get(i++));
					t.setI(2);
					t.notifyAll();
				}
			}
		}
	}

}

class Thread2 extends Thread {

	private List<Integer> l;
	private ThreadTest t;

	public Thread2(List<Integer> list, ThreadTest tIN) {
		l = list;
		t = tIN;
	}

	public void run() {
		int i = 0;
		while (i < l.size()) {
			synchronized (t) {
				if (t.getI() != 2) {
					try {
						t.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(l.get(i++));
					t.setI(3);
					t.notifyAll();
				}
			}
		}
	}

}

class Thread3 extends Thread {

	private List<Integer> l;
	private ThreadTest t;

	public Thread3(List<Integer> list, ThreadTest tIN) {
		l = list;
		t = tIN;
	}

	public void run() {
		int i = 0;
		while (i < l.size()) {
			synchronized (t) {
				if (t.getI() != 3) {
					try {
						t.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					System.out.println(l.get(i++));
					t.setI(1);
					t.notifyAll();
				}
			}
		}
	}
}
