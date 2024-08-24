package exercise8_new;

public abstract class Filter {
	
	abstract boolean accept(String text);
	
	public final String[] filter(String[] text) {
			String[] newtext = new String[elements(text)];
			int j = 0;
			for(int i = 0; i < text.length; i++) {
				if(this.accept(text[i])) {
					newtext[j] = text[i];
					j++;
				}
			}
			return newtext;
	}
	
	
	/*
	 * @param textsize is the String array which will be filtered.
	 * @return amount of elements that have <= 3 in String length.
	 * A function I made only to have the right size on the new array for accept. Might be an overkill since we 
	 * loop it in the same way for when we want to filter. However we just made this because it was prettier to have 
	 * the array in the same size as the elements.
	 */
	public int elements(String[] textsize) {
		int i = 0;
		for(int j = 0; j < textsize.length; j++) {
			if(textsize[j].length() <= 3) {
				i++;
			}
		}
		return i;
	}
}
