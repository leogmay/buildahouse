package view;

import javax.swing.JOptionPane;

import model.House;
import model.Openings;

import java.util.ArrayList;

import javax.swing.JComboBox;

public class Data {

	public static int asksOption() {
		String[] options = { "Build the House", "Move doors or windows", "See all house information", "Exit Program!" };

		JComboBox<String> menu = new JComboBox<String>(options);

		JOptionPane.showConfirmDialog(null, menu, "Please, choose the desired option ", JOptionPane.OK_CANCEL_OPTION);

		return menu.getSelectedIndex();

	}

	public static void showsEndProgram() {
		JOptionPane.showMessageDialog(null, "The program will be finished ");
	}

	public static String asksDescription(String description, int order) {

		if (order == 0) {
			return JOptionPane.showInputDialog("Please inform us the description of the " + description);
		} else {
			return JOptionPane.showInputDialog("Please, inform us the description of the " + order + " " + description);

		}
	}

	public static String asksColor() {

		return JOptionPane.showInputDialog("Please, enter the color of the house ");
	}

	public static int asksHowManyOpenings(String openings) {

		return Integer.parseInt(JOptionPane.showInputDialog("Please, enter the number of " + openings));
	}

	public static int asksSituation(String openingType) {
		String[] options = { "Closed", "Opened" };

		return JOptionPane.showOptionDialog(null, "Enter the state of the " + openingType, "State",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

	}

	public static String asksOpeningType() {

		String[] options = { "Door", "Window" };

		int openingType = JOptionPane.showOptionDialog(null, "Please, enter which opening do you intend to move ",
				"Move opening ", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
				options[0]);

		if (openingType == 0) {
			return "door";
		} else {
			return "window";
		}

	}

	public static int asksOpeningMove(ArrayList<Openings> openingsList) {
		String openingType = openingsList.get(0).getClass().getName();
		openingType = openingType.replaceAll("model.","");

		int openingsQuantity = openingsList.size();

		String[] openingsDescription = new String[openingsQuantity];

		for (int i = 0; i < openingsQuantity; i++) {
			openingsDescription[i] = openingsList.get(i).getDescription();
		}

		String msg = "Choose the " + openingType + " to move";

		JComboBox openingsExhibition = new JComboBox(openingsDescription);
		int confirmation = JOptionPane.showConfirmDialog(null, openingsExhibition, msg, JOptionPane.OK_CANCEL_OPTION);

		if (confirmation == 0) {
			return openingsExhibition.getSelectedIndex();
		} else {
			return -1;
		}
	}

	public static void showsOpeningMsg() {
		JOptionPane.showMessageDialog(null, "!NONE!", "No opening shall move!", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showsHouseInfoAtAll(String info) {
		JOptionPane.showMessageDialog(null, info, "House Information ", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void notFinishedHouse() {
		JOptionPane.showMessageDialog(null, "The house is not finished yet, try again!");
	}

	public static void negativeDoorsNumber() {
		JOptionPane.showMessageDialog(null, "You cannot type a negative number on it");
	}

}
