
public class Alligators {
	private String[] wordList;
	private String answer, displayWord;
	public Alligators() {
		wordList = new String[20];
		wordList[0]="dolphin";
		wordList[1]="cheetah";
		wordList[2]="lion";
		wordList[3]="rat";
		wordList[4]="bear";
		wordList[5]="salmon";
		wordList[6]="elephant";
		wordList[7]="giraffe";
		wordList[8]="dog";
		wordList[9]="cat";
		wordList[10]="hippo";
		wordList[11]="toucan";
		wordList[12]="parrot";
		wordList[13]="anteater";
		wordList[14]="skunk";
		wordList[15]="monkey";
		wordList[16]="orangutan";
		wordList[17]="horse";
		wordList[18]="buffalo";
		wordList[19]="salamander";
 
		
		answer = getRandomWord();
		displayWord = getDisplayWord();
		System.out.println(answer);
	}
	
	public String getDisplayWord() {
		String s = "";
		
		for(int i=0; i<answer.length(); i++) {
			if(answer.charAt(i)==' ') {
				s+=" ";
			}
			else {
				s+="-";
			}
		}
		
	return s;
	}
	public String disWord() {
		return displayWord;
	}
	
	public Boolean checkGuess (char c) {
		boolean correct = false;
		for (int i=0; i<answer.length(); i++ ) {
			if (Character.toLowerCase(answer.charAt(i))==c) { 
			correct=true;
			displayWord = displayWord.substring(0,i) + c + displayWord.substring(i + 1, answer.length());
		System.out.println("Replaced letter at position " + i + ".");
		}
	}
	return correct;
	}
	public String getAnswer() {
		return answer;
	}
	public void restart() {
		answer = getRandomWord();
		displayWord = getDisplayWord();
		System.out.println(answer);
	}
	public int getRandomNumber() {
		return(int)(Math.random()*(wordList.length-1-0)+0)+1;
	}
	public String getRandomWord() {
		return (wordList[getRandomNumber()]);
	}
}
