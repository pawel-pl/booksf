package adobe;

public class WaitWithoutJoin {

	public static void main(String[] args) {

		final Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (this) {
					for (int i = 0; i < 5; i++) {
						try {
							Thread.sleep(1000);
							System.out.println("T1: " + i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					notifyAll();
				}
			}
		});

		final Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (t1) {
					try {
						t1.wait();
						for (int i = 0; i < 5; i++) {
							System.out.println("T2: " + i);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		t1.start();
		t2.start();
	}

}
