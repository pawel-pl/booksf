package qualcomm;

public class Fiveton {

	private static int index = 0;
	private static Fiveton[] fivetonInstances = new Fiveton[5];

	private Fiveton() {
	}

	@Override
	protected Fiveton clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	public static Fiveton getFivetonIntance() {
		if (fivetonInstances[index] == null) {
			// if the array is NULL at the specified
			// index then create a new instance there
			fivetonInstances[index] = new Fiveton();
		}
		Fiveton instance = fivetonInstances[index];
		// serve the Fiveton instances in a round robin fashion
		index = (index + 1) % fivetonInstances.length;
		return instance;
	}
}
