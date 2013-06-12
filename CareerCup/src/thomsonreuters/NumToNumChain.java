package thomsonreuters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class NumToNumChain {

    public static void main(String[] args) {

	try {

	    File file = new File("c:/Users/spike/Documents/samplefile.txt");
	    if (!file.exists()) {
		file.createNewFile();
	    }
	    BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));

	    StringBuilder sb = new StringBuilder();
	    int n = 100000;
	    bw.write("1");
	    for (int i = 2; i <= n; i++) {
		sb.append(", " + i);
		if (i % 1000 == 0) {
		    bw.write(sb.toString());
		    sb.setLength(0);
		}
	    }
	    bw.flush();
	    bw.close();

	} catch (Exception ex) {
	    ex.printStackTrace();
	}

    }

}
