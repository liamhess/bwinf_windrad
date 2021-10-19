

public class App {
	
	public static void main(String[] args) {
		
		String input = "12 3\r\n"
				+ "-82 -315\r\n"
				+ "248 714\r\n"
				+ "1202 907\r\n"
				+ "226 680\r\n"
				+ "694 -20\r\n"
				+ "-767 44\r\n"
				+ "-245 719\r\n"
				+ "-339 36\r\n"
				+ "473 406\r\n"
				+ "863 -290\r\n"
				+ "953 885\r\n"
				+ "-109 510\r\n"
				+ "1242 -593\r\n"
				+ "-1223 -1479\r\n"
				+ "1720 401";
		
		String[] landkreisArray = input.split("\r\n");
		
		int houseCount = Integer.parseInt(landkreisArray[0].split(" ")[0]);
		int windCount = Integer.parseInt(landkreisArray[0].split(" ")[1]);
				
		Position[] houseArray = new Position[houseCount];
		int counter = 0;
		for (int i = 1; i <= houseCount; i++) {
			int x = Integer.parseInt(landkreisArray[i].split(" ")[0]);
			int y = Integer.parseInt(landkreisArray[i].split(" ")[1]);
			
			houseArray[counter] = new Position(x, y);
//			System.out.println(houseArray[counter].x + " " + houseArray[counter].y);
			counter++;
		}
		
		Position[] windArray = new Position[windCount];
		counter = 0;
		for (int i = houseCount+1; i < landkreisArray.length; i++) {
			int x = Integer.parseInt(landkreisArray[i].split(" ")[0]);
			int y = Integer.parseInt(landkreisArray[i].split(" ")[1]);
			
			windArray[counter] = new Position(x, y);
//			System.out.println(windArray[counter].x + " " + windArray[counter].y);
			counter++;
		}
		
	}
		
	public static int distance(Position house, Position wind) {
		int distance = (int) Math.sqrt(Math.pow(house.x - wind.x, 2) + Math.pow(house.y - wind.x, 22));
		
		return distance;
	}
	
	Position startt = new Position(0, 0);
	Position end = new Position(2, 2);
	
	System.out.println();

}
