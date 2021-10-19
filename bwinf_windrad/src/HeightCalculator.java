import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class HeightCalculator {
    
    public static String heightCalculator(String landkreis) throws FileNotFoundException, IOException {
        
        // fileReader aufrufen und input-Beispiele in Array einlesen lassen
		String[] landkreisArray = fileReader(landkreis);
		
        // Anzahl an Häusern und Windkraftanlagen einlesen
		int houseCount = Integer.parseInt(landkreisArray[0].split(" ")[0]);
		int windCount = Integer.parseInt(landkreisArray[0].split(" ")[1]);
				
		// alle Häuser in array einlesen
		Position[] houseArray = new Position[houseCount];
		int counter = 0;
		for (int i = 1; i <= houseCount; i++) {
			int x = Integer.parseInt(landkreisArray[i].split(" ")[0]);
			int y = Integer.parseInt(landkreisArray[i].split(" ")[1]);
			
			houseArray[counter] = new Position(x, y);
			counter++;
		}
		
		// alle Windräder in array einlesen
		Position[] windArray = new Position[windCount];
		counter = 0;
		for (int i = houseCount+1; i < landkreisArray.length; i++) {
			int x = Integer.parseInt(landkreisArray[i].split(" ")[0]);
			int y = Integer.parseInt(landkreisArray[i].split(" ")[1]);
			
			windArray[counter] = new Position(x, y);
			counter++;
		}

		// Suche kleinste Distanz zwischen Haus und Windrad
		String windmills = "";
		for (Position wind : windArray) {
			double minDistance = 999999999;
			for (Position house : houseArray) {
				if (distance(house, wind) < minDistance) minDistance = distance(house, wind);
			}

			// erlaubte Höhe berechnen
			double height = minDistance / 10;

			// füge Zeile zu fertigem String hinzu
			windmills += wind.x + " " + wind.y + " " + height + "\n";
		}

		return windmills;

	}

    public static String[] fileReader(String landkreis) throws FileNotFoundException, IOException {
        // file mit Beispielen einlesen
		File file = new File("bwinf_windrad/resources/" + landkreis + ".txt");
		Scanner scan = new Scanner(file);

		// Länge des Files checken, damit man Länge für Array hat
		int linecount = 0;
		while(scan.hasNextLine()) {
			linecount++;
			scan.nextLine();
		}
		scan.close();

		// durch file scannen und in landkreisArray einlesen
		scan = new Scanner(file);
		String[] landkreisArray = new String[linecount];
		int counter = 0;
		while(scan.hasNextLine()) {
			landkreisArray[counter] = scan.nextLine();
			counter++;
		}
		scan.close();
        
        return landkreisArray;
    }
		
	// Nimmt zwei Positionen und berechnet die Distanz
	public static double distance(Position startpoint, Position endpoint) {
		double distance = Math.sqrt(Math.pow(startpoint.x - endpoint.x, 2) + Math.pow(startpoint.y - endpoint.y, 2));
		return distance;
	}

}
