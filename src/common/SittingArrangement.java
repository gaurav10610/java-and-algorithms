package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SittingArrangement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long testCases = Long.parseLong(br.readLine());
		for (int i = 0; i < testCases; i++) {
			int seat = Integer.parseInt(br.readLine());
			int compartment = seat / 12;
			int seatDelta = seat % 12;
			int oppositeSeat;
			if (seatDelta != 0) {
				oppositeSeat = compartment * 12 + (13 - seatDelta);
			} else {
				oppositeSeat = compartment * 12 - 11;
			}
			System.out.print(oppositeSeat);
			int seatNum = oppositeSeat % 6;

				switch (seatNum) {
				case 0:
					System.out.println(" WS");
					break;
				case 1:
					System.out.println(" WS");
					break;
				case 2:
					System.out.println(" MS");
					break;
				case 3:
					System.out.println(" AS");
					break;
				case 4:
					System.out.println(" AS");
					break;
				case 5:
					System.out.println(" MS");
					break;
				}

		}

	}
}
