import java.util.Scanner;

public class MenuMetodi {

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		int scelta;
		do{
			
			System.out.println("1 Opzione A");
			System.out.println("2 Opzione B");
			System.out.println("3 Opzione C");
			System.out.println("0 Esci");
			
			scelta = mostratmenu(input);
			
			faiswitch(scelta);
			
			
			
		} while (scelta != 0);
	}

     public static int mostratmenu(Scanner input) {
    	 System.out.println("1 Opzione A");
		 System.out.println("2 Opzione B");
		 System.out.println("3 Opzione C");
		 System.out.println("0 Esci");
		 
		 //UN METODO NON VOID PUÒ ESEGUIRE ISTRUZIONI 
		 //MA DEVE TORNARE CON UN RETURN
		 return input.nextInt();
     }
     
     public static void faiswitch(int scelta) {
    	 
    	 switch(scelta) {
			
			case 1:
				System.out.println("Hai scelto opzione A");
				break;
			case 2:
				System.out.println("Hai scelto opzione B");
				break;
			case 3:
				System.out.println("Hai scelto opzione C");
				break;
			case 0:
				System.out.println("Alla prossima");
				break;
			}
    	 
     }
}