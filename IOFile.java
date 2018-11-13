import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

public class IOFile {
	public static String errorMessage = String.format("wrong!!!\nplease try again...");
//this method take a path from user and return its String value
	public static String getPath() {
		Path x = Paths.get(JOptionPane.showInputDialog(null, "please enter your text file directory"));
		return x.toString();
	}
//this method write the argument in a binary file
	public static void binaryWrite(String x) {
		try {
			FileOutputStream fileOpener = new FileOutputStream(getPath());
			ObjectOutputStream writer = new ObjectOutputStream(fileOpener);
			writer.writeObject(x);
			writer.close();
			fileOpener.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,errorMessage, "ERROR",JOptionPane.ERROR_MESSAGE);
			Main.askForFileWriting(x);
		}
	}
//this method read a binary file and return its content
	public static String binaryRead() {
		String x = null;
		try {
			FileInputStream fileOpener = new FileInputStream(getPath());
			ObjectInputStream reader = new ObjectInputStream(fileOpener);
			x = (String) reader.readObject();
			reader.close();
			fileOpener.close();
			return x;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
			return Main.askForFileReading();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, errorMessage,"ERROR",JOptionPane.ERROR_MESSAGE);
			return Main.askForFileReading();
		}
	}
//this method write the argument in a character file
	public static void textWrite(String x) {
		try {
			FileWriter fileOpener = new FileWriter(getPath());
			BufferedWriter writer = new BufferedWriter(fileOpener);
			writer.write(x);
			writer.close();
			fileOpener.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, errorMessage, "ERROR",	JOptionPane.ERROR_MESSAGE);
		Main.askForFileWriting(x);
		}
	}
//this method read a character file and returns its content
	public static String textRead() {
		String x = null;
		try {
			FileReader fileOpener = new FileReader(getPath());
			BufferedReader reader = new BufferedReader(fileOpener);
			x = reader.readLine();
			reader.close();
			fileOpener.close();
			return x;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, errorMessage, "ERROR",	JOptionPane.ERROR_MESSAGE);
			return Main.askForFileReading();
		}
	}
}
