package com.ats.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class ResumeScanner {
	
	
	HashSet<String> skills_set = new HashSet<String>();
	HashSet<String> employees_skills_set = new HashSet<String>();
	
	private void checkSkills(String line)
	{
		for(String skill:skills_set)
		{
			if(line.toLowerCase().contains(skill.toLowerCase()))
			{
				//System.out.println("Line : "+line);

				System.out.println("SKILL : "+skill);	
				employees_skills_set.add(skill);
			}
		}
	}
	
	private void populateSkillsSet() {
		String skill;
		try  
		{  
		FileInputStream fileInputStream = new FileInputStream("All_Skills.txt");       
		Scanner scanner=new Scanner(fileInputStream);   
		while(scanner.hasNextLine())  
		{  
		skill = scanner.nextLine().trim();
		//System.out.println("Read from file :"+skill);
		skills_set.add(skill);
		}  
		scanner.close();
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}  
	}
	

	public static void main(String[] args) throws IOException {
		ResumeScanner example1 = new ResumeScanner();
		example1.populateSkillsSet();
		PDFTextStripper pdfTextStripper = new PDFTextStripper();
		pdfTextStripper.setStartPage(1);
		pdfTextStripper.setEndPage(2);
		String content = null;
		PDDocument document = PDDocument.load(new File("C:\\Users\\rkumawat3\\Downloads\\Sample Resume.pdf"));
		document.getClass();
		String pdfFileInText = pdfTextStripper.getText(document);
		String[] lines = pdfFileInText.split("\\r\\n\\r\\n");
		for (String line : lines) {
			example1.checkSkills(line);
			content += line;
		}
	}

	
}