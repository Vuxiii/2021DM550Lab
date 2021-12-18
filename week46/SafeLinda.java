import java.util.Scanner // <- Du har glemt et ";" - Willi
/**
En klasse der gemmer en hemmelighed, der skal bruges en nøgle for at komme ind
*/
public class SafeLinda{
	
	// Attributter
	private boolean isTrue = false;
	
	// Konstanter
	private final int [] KEY = new int [6];
	
	// En constructor
	public SafeLinda(int[] password){
		this.password[] = password[];
		
		// Koden
		KEY[0]= 4;
		KEY[1]= 5;
		KEY[2]= 1;
		KEY[3]= 2;
		KEY[4]= 6;
		KEY[5]= 4;
		
		//Hvis koden er rigtigt
		if(locked())
			isTrue = true;
	}
	
	// Tjekker om koden er rigtig
	private boolean isKey(int [] password){
		//Tjekker om kombinationen er korrekt, retunere fandt/falsk
		for (int i = 0 ; i < KEY.length ; i++){
			if(password[i]==key[i])
				isTrue=true;
			
			else{
				isTrue=false;
				i=7;
			}
		}
	}
	
	// Tjekker om hemmeligheden er låst, retunere sandt/falsk 
	private boolean locked(){
		return isTrue;
		
	}
	
	// Indeholder hemmeligheden
	private void store(){
		System.out.println = "The secret"
	}
	
	// Tjekker om de kan se hemmeligheden. Retunere hemmeligheden eller ej fejl.
	private String contens (){
		if(isTrue)
			return store();
		else
			return System.out.println = "you dont have acces to the secreet";
	}
	
	// Ændre koden til n på alle pladser
	private void insert(int n){
		for(int i=0 ; i < paswoord.length ; i++){
			password[i]=n;
		}
		
	}
	
	// ?? 
	private void reset(){
		
		
	}
	
	
}