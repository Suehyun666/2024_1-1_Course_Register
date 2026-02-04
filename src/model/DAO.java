package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class DAO {
	
	//constructors
	public DAO() {}
	
	//initialize
	public void initialize() {}
	
	//methods 
	public Vector<Model> getList(String link) {
		Vector<Model> List= new Vector<Model>();
		try {
			File file = new File("data/"+link+".txt");
			Scanner scanner=new Scanner(file);
			
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] wordList =line.split(" ");
				if (wordList.length == 5) {
					Model mLecture = new Model();
					mLecture.setId(wordList[0]);
					mLecture.setName(wordList[1]);
					mLecture.setName1(wordList[2]);
					mLecture.setScore(wordList[3]);
					mLecture.setTime(wordList[4]);
					List.add(mLecture);
				} else  {
					Model mLecture = new Model();
					mLecture.setId(wordList[0]);
					mLecture.setName(wordList[1]);
					mLecture.setLink(wordList[2]);
					List.add(mLecture);
				}
			}scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} return List;
	}
    
}
