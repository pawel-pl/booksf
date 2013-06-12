package linkedin;

public class PrintText {
	public static void main(String[] args) {
		String input = "Cracking the Coding Interview: 150 Programming Interview Questions and Answers focuses on mastering the programming interview. " +
				"Topics include: strategies to handle tough algorithm questions, preparation techniques, behavioral questions, " +
				"and 150 programming interview questions and answers.";
		int width = 20;

		int pos = 0;
		StringBuilder sb = new StringBuilder();

		String[] words = input.split(" ");
		for (String w : words) {
			if (pos + w.length() > width) {
				sb.append('\n');
				pos = 0;
			}
			sb.append(w);
			sb.append(' ');
			pos += w.length() + 1;
		}

		System.out.println(sb);
	}
}
