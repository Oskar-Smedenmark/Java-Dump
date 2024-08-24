package Framework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {

	File build;
	String buildName;

	
	public FileSaver(File build, String buildName) {
		this.build = build;
		this.buildName = buildName;
		
	}
	
	/**
	 * To create a new file and save the "components".
	 * @param text File content.
	 */
	public boolean saveNew(String text){
		try {
		
			if(build.createNewFile()) {
				write(text);
				return true;
				
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return false;
	}
	/**
	 * Tests whether the file or directory denoted by this abstract pathnameexists.
	 * @return true if and only if the file or directory denotedby this abstract pathname exists; false otherwise
	 */
	public boolean exist() {
		return build.exists();
	}
	/**
	 * writes directly to the file.
	 * @param text File content.
	 */
	public void write(String text) {
		FileWriter writer;
		try {
			writer = new FileWriter(build);
			writer.write(text);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return The file as type File.
	 */
	public File getFile() {
		return build;
	}
	
	/**
	 * 
	 * @return Name of file as String.
	 */
	public String getName() {
		return buildName;
	}
	
}
