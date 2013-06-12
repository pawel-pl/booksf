package tribal;

public class ThreadsOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {
					System.out.println("A");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {
					System.out.println("B");
					try {
						Thread.sleep(1000);
						if (i == 3) {
							t1.join();
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
