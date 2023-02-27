package control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.tools.javac.Main;

import view.Data;
import model.*;

public class Controller {

	private House house = null;

	public void showsMenu() {
		int option;

		do {
			option = Data.asksOption();

			switch (option) {

			case 0:

				this.house = new House();

				String description = Data.asksDescription("house ", 0);
				String color = Data.asksColor();

				int doorsQuantity = 0;
				do {

					doorsQuantity = Data.asksHowManyOpenings("doors ");

				} while (doorsQuantity <= 0);

				int windowsQuantity = 0;

				do {

					windowsQuantity = Data.asksHowManyOpenings(" windows");

				} while (windowsQuantity <= 0);

				ArrayList<Openings> doorsList = new ArrayList<Openings>();

				for (int i = 0; i < doorsQuantity; i++) {
					Door door = new Door();

					if (doorsQuantity >= 0) {
						door.setDescription(Data.asksDescription("Door ", (i + 1)));
						door.setSituation(Data.asksSituation("door "));
						doorsList.add(door);
					} else
						Data.negativeDoorsNumber();
				}

				ArrayList<Openings> windowsList = new ArrayList<Openings>();

				for (int i = 0; i < windowsQuantity; i++) {

					Window window = new Window();

					window.setDescription(Data.asksDescription("window ", (i + 1)));
					window.setSituation(Data.asksSituation("window "));
					windowsList.add(window);
				}

				this.house.buildHouse(description, color, doorsList, windowsList);

				System.out.println("Description of the house " + house.getDescription() + "\n");
				System.out.println("Color of the house " + house.getColor() + "\n");

				for (Openings door : house.getdoorsList()) {
					System.out.println("Door description " + door.getDescription() + "\n");
					System.out.println("Door situation" + door.getSituation() + "\n");
				}

				for (Openings window : house.getWindowsList()) {
					System.out.println("Window description " + window.getDescription() + "\n");
					System.out.println("Window situation" + window.getSituation() + "\n");
				}

				break;

			case 1:

				if (house != null) {

					String openingType = Data.asksOpeningType();

					ArrayList<Openings> openingsList = new ArrayList<Openings>();

					if (openingType.equals("door")) {
						openingsList = this.house.getdoorsList();
					} else {
						openingsList = this.house.getWindowsList();
					}

					int position = Data.asksOpeningMove(openingsList);
					int newState = 0;

					if (position != -1) {

						newState = Data.asksSituation(openingType);
						Openings opening = this.house.returnsOpening(position, openingType);
						this.house.moveOpening(opening, newState);
						System.out.println("New situation of the" + openingType + ":" + opening.getSituation());
					} else {
						Data.showsOpeningMsg();

					}
				} else {
					Data.notFinishedHouse();
				}

				break;

			case 2:

				if (house != null) {

					String info = this.house.houseInformationAtAll();
					Data.showsHouseInfoAtAll(info);

					break;
				}
			default:

			}
		} while (option != 3);

		Data.showsEndProgram();

		System.exit(0);
	}

}
