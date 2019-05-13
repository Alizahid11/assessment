package task1;

import java.awt.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Replace {
	
	
	

	public static void main(String[] args) {
		Replace1("This NETbuilder assesment is way too easy");
	}
	
	static String  position = "";
	static String changeInString;
	
	
	public static void Replace1(String x) {
		
		changeInString = x;
		String[] changeInStringSeperate = changeInString.split("");
		Stream.of(changeInStringSeperate).forEach(Replace::setCharacterPosition);
		
		System.out.println(position);
		
	}
	
	public static void setCharacterPosition(String a) {
		
		if (!(a.trim().equals(""))) {
			switch (a.toLowerCase()) {
			case "a":
				position+="1 ";
				break;
				
			case "b":
				position+="2 ";
				break;
				
			case "c":
				position+="3 ";
				break;
				
			case "d":
				position+="4 ";
				break;
			case "e":
				position+="5 ";
				break;
				
			case "f":
				position+="6 ";
				break;
				
			case "g":
				position+="7 ";
				break;
				
			case "h":
				position+="8 ";
				break;
				
			case "i":
				position+="9 ";
				break;
				
			case "j":
				position+="10 ";
				break;
				
			case "k":
				position+="11 ";
				break;
				
			case "l":
				position+="12 ";
				break;
				
			case "m":
				position+="13 ";
				break;
				
			case "n":
				position+="14 ";
				break;
				
			case "o":
				position+="15 ";
				break;
				
			case "p":
				position+="16 ";
				break;
				
			case "q":
				position+="17 ";
				break;
				
			case "r":
				position+="18 ";
				break;
				
			case "s":
				position+="19 ";
				break;
				
			case "t":
				position+="20 ";
				break;
				
			case "u":
				position+="21 ";
				break;
				
			case "v":
				position+="22 ";
				break;
				
			case "w":
				position+="23 ";
				break;
				
			case "x":
				position+="24 ";
				break;
				
			case "y":
				position+="25 ";
				break;
				
			case "z":
				position+="26 ";
				break;
			}
		}
	}
}


