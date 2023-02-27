package model;

import java.util.ArrayList;

public class House {

	private String description;
	private String color;
	private ArrayList<Openings> doorsList = new ArrayList<Openings>();
	private ArrayList<Openings> windowsList = new ArrayList<Openings>();

	public String getDescription() {

		return description;

	}

	public void setDescription(String description) {

		this.description = description;
	}

	public String getColor() {

		return color;
	}

	public void setColor(String color) {

		this.color = color;
	}

	public ArrayList<Openings> getdoorsList() {

		return doorsList;
	}

	public void setDoorsList(ArrayList<Openings> doorsList) {

		this.doorsList = doorsList;
	}

	public ArrayList<Openings> getWindowsList() {

		return windowsList;
	}

	public void setWindowsList(ArrayList<Openings> windowsList) {

		this.windowsList = windowsList;
	}

	public void buildHouse(String description, String color, ArrayList<Openings> doorsList,
			ArrayList<Openings> windowsList) {

		setDescription(description);
		setColor(color);
		setDoorsList(doorsList);
		setWindowsList(windowsList);

	}

	public Openings returnsOpening(int position, String openingType) {

		if (openingType.equals("door.")) {
			return this.doorsList.get(position);

		} else {
			return this.windowsList.get(position);
		}
	}

	public void moveOpening(Openings opening, int newState) {
		opening.setSituation(newState);

	}

	public String houseInformationAtAll() {
		String lyricalOpeningType = "";
		String info = "Description: " + this.description + "\nColor: " + this.color + "\n" + "\nDoors List:  ";

		for (Openings opening : this.doorsList) {
			int situation = opening.getSituation();

			if (situation == 0) {
				lyricalOpeningType = "Closed";
			}else {
				lyricalOpeningType = "Opened";
			}
			
			info += opening.getDescription() + "\nSituation: " + lyricalOpeningType + "\n";
		}

		info += "\nWindows List: ";

		for (Openings opening : this.windowsList) {
			int situation = opening.getSituation();
			info += opening.getDescription() + " \nSituation: " + lyricalOpeningType + "\n";
		}

		return info;

	}

}
