package childrensgame;

import java.util.Scanner;

import childrensgame.service.ChildService;
import childrensgame.service.impl.ChildServiceImpl;

/**
 * Calls service to find winner of Children's Game 
 * 
 * @author Tom Ward
 * @version 1.0
 * 
 */
public class ChildrensGame {
	public static void main(String[] args) {
		
		ChildService childService = new ChildServiceImpl();
		
		// Example call to service
		// Given a circle size of 3 and elimination count of 4, returns id of winning child 1 
		boolean carryOn = true;
		Scanner scanner = new Scanner(System.in);
		
		while (carryOn){
						
			System.out.print("Enter circle size : ");
			Integer circleSize = Integer.parseInt(scanner.nextLine());
			
			System.out.print("Enter elimination count : ");
			Integer eliminationCount = Integer.parseInt(scanner.nextLine());
			
			System.out.println("Id of winning child: " + childService.getWinner(circleSize, eliminationCount));
			
			System.out.print("(q)uit ?: ");
			String operator = scanner.nextLine();
	
            if ("q".equals(operator)) {
                System.out.println("Bye!");
                break;
            }
		}
		scanner.close();

	}

}