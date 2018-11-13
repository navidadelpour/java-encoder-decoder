import javax.swing.JOptionPane;

public class Main {
//goodbye message and error message
	private static String goodbyeMessage = String.format("%40s\n\n%s\n%s\n\n%38s", "thanks for running this program",
			"java encoder/decoder", "programed by Navid Adelpour", "GoodBye");
	public static String errorMessage = String.format("wrong!!!\nplease try again...");
//main first shows a message then runs the method mainMenu
	public static void main(String[] args) {
		String message = String.format("%40s\n\n%s\n\n%42s", "welcome",
				"this is a program that have a mechanism for\nconveting a text to unreadable code\nor converting a code to text",
				"press ok to start.");
		JOptionPane.showMessageDialog(null, message, "Encryptor", JOptionPane.PLAIN_MESSAGE);
		try {
			mainMenu();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, goodbyeMessage, "Encryptor", JOptionPane.PLAIN_MESSAGE);
			System.exit(1);
		}

	}
//this method create a menu for user
	public static void mainMenu() {
			String message = String.format("%30s\n%s\n%s\n%s\n%s\n", "Main Menu", "which one do you want to do?",
					"      1) Encryption", "      2) Decoding", "      3) exit");
			String answer = JOptionPane.showInputDialog(null, message, "Encryptor", JOptionPane.QUESTION_MESSAGE);
			switch (answer) {
			case "1":
				Coding t = new Coding(askForFileReading().toString());
				String code = t.toCode().toString();
				//this is because we want to remain in the  askForFileWriting menu for multiple writing
				while(true)
					askForFileWriting(code);
			case "2":
				Coding c = new Coding(askForFileReading().toString());
				String text = c.toText().toString();
				while(true)
					askForFileWriting(text);
			case "3":
				JOptionPane.showMessageDialog(null, goodbyeMessage, "Encryptor", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
				mainMenu();
			}
	}
//this method create a menu for writing the argument in multiple ways
	public static void askForFileWriting(String x) {
		String message = String.format("%s\n%s\n%s\n%s\n%s", "do you want to write in a file or just show here ?",
				"      1) binary file", "      2) character file", "      3) show here", "      4) go to main menu");
		String answer = JOptionPane.showInputDialog(null, message, "Encryptor", JOptionPane.QUESTION_MESSAGE);
		switch (answer) {
		case "1":
			IOFile.binaryWrite(x);
			break;
		case "2":
			IOFile.textWrite(x);
			break;
		case "3":
			JOptionPane.showMessageDialog(null, String.valueOf(x), "Encryptor", JOptionPane.PLAIN_MESSAGE);
			break;
		case "4":
			//if the user wants to get back, must input 4
			mainMenu();
			break;
		default:
			JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
			askForFileWriting(x);
			break;
		}
	}
//this method read the file content or ask for user input and returns
	public static String askForFileReading() {
		String message = String.format("%s\n%s\n%s\n%s\n%s", "do you want to read from a file or just inputing ?",
				"      1) binary file", "      2) character file", "      3) inputing", "      4) go to main menu");
		String answer = JOptionPane.showInputDialog(null, message, "Encryptor", JOptionPane.QUESTION_MESSAGE);
		switch (answer) {
		case "1":
			return IOFile.binaryRead();
		case "2":
			return IOFile.textRead();
		case "3":
			return JOptionPane.showInputDialog(null, "please enter your text", "Encryptor", JOptionPane.PLAIN_MESSAGE);
		case "4":
			//if the user wants to get back, must input 4
			mainMenu();
		default:
			JOptionPane.showMessageDialog(null,errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
			return askForFileReading();
		}
	}
}