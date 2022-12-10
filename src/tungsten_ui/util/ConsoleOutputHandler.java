package tungsten_ui.util;

public class ConsoleOutputHandler {

	public static int INFO = 0;
	public static int WARNING = 1;
	public static int ERROR = 2;
	public static int FATAL = 3;

	public ConsoleOutputHandler() {
		// TODO Auto-generated constructor stub
	}

	public static void output(String str, int type) {
		String typeText;
		if (type == INFO) {
			typeText = "INFO";
		} else if (type == WARNING) {
			typeText = "WARN";
		} else if (type == ERROR) {
			typeText = "ERROR";
		} else if (type == FATAL) {
			typeText = "FATAL";
		} else
			throw new IllegalArgumentException("Type values must be between 0 and 3.");
		
		if(type > 1) {
			System.err.println("[" + typeText + "]: " + str);
		} else {
			System.out.println("[" + typeText + "]: " + str);
		}
	}

}
