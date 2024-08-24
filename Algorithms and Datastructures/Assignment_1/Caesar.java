
public class Caesar 
{
	 public static char encrypt_character ( char tkn, int key)
	 {
		 int tknInt = (int)tkn;
		 int newTkn = tknInt+key;
		 if(tknInt <= 90 && tknInt >= 65) //Big characters
		 {
			 while(newTkn >= 90)
			 {
				 newTkn = 65 + newTkn - 91; //Loop around if new token is outside the range
			 }
			 
		 }
		 else if(tknInt <= 57 && tknInt >= 48) //Numbers
		 {
			 while(newTkn >= 57)
			 {
				 newTkn = 48 + newTkn - 58; //Loop around if new token is outside the range
			 }
		 }
		 else if(tknInt <= 122 && tknInt >= 97) //Small characters
		 {
			 while(newTkn >= 122)
			 {
				 newTkn = 97 + newTkn - 123; //Loop around if new token is outside the range
			 }
		 }
		 else
		 {
			 newTkn = tknInt;
		 }
		 char encChar = (char)(newTkn);
		 
		 return encChar;
	 }
	 public static char decrypt_character ( char tkn, int key)
	 {
		 int tknInt = (int)tkn;
		 int newTkn = tknInt-key;
		 if(tknInt <= 90 && tknInt >= 65) //Big characters
		 {
			 while(newTkn < 65)
			 {
				 newTkn = 90 + newTkn - 64; //Loop around if new token is outside the range
			 }
			 
		 }
		 else if(tknInt <= 57 && tknInt >= 48) //Numbers
		 {
			 while(newTkn < 48)
			 {
				 newTkn = 57 + newTkn - 47; //Loop around if new token is outside the range
			 }
		 }
		 else if(tknInt <= 122 && tknInt >= 97) //Small characters
		 {
			 while(newTkn < 97)
			 {
				 newTkn = 122 + newTkn - 96; //Loop around if new token is outside the range
			 }
		 }
		 else
		 {
			 newTkn = tknInt;
		 }
		 
		 char decChar = (char)(newTkn);
		 
		 return decChar;
	 }
	 
}
