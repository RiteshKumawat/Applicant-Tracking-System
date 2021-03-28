package com.ats.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
public class ResumeScanner {
	HashSet<String> skills_set = new HashSet<String>();
	HashSet<String> employees_skills_set = new HashSet<String>();
	File orignalFile;
	
	
	
	private void checkSkills(String line)
	{
		//System.err.println("CHECKKKINNGGGG"+line);
		for(String skill:skills_set)
		{
		//	System.out.println("Line : "+line);

			if(line.toLowerCase().contains(skill.toLowerCase()))
			{
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
//		System.out.println("Read from file :"+skill);
		skills_set.add(skill);
		}  
		scanner.close();
		}  
		catch(IOException e)  
		{  
		e.printStackTrace();  
		}  
	}
	
	  private  static File convertMultiPartToFile(MultipartFile file ) throws IOException
	    {
	        File convFile = new File( file.getOriginalFilename() );
	        FileOutputStream fos = new FileOutputStream( convFile );
	        fos.write( file.getBytes() );
	        fos.close();
	        return convFile;
	    }
	
	public void scan(MultipartFile multipartFile)
	{
		try {
		//	ResumeScanner resumeScanner = new ResumeScanner();
			orignalFile = convertMultiPartToFile(multipartFile);
			PDFTextStripper pdfTextStripper = new PDFTextStripper();
			pdfTextStripper.setStartPage(1);
			pdfTextStripper.setEndPage(2);
			String content = null;
			PDDocument document = PDDocument.load(orignalFile);
			document.getClass();
			String pdfFileInText = pdfTextStripper.getText(document);
			String[] lines = pdfFileInText.split("\\r\\n\\r\\n");
			for (String line : lines) {
				checkSkills(line);
				content += line;
			}
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public HashSet<String> getSkillsSet()
	{
		return this.employees_skills_set;	
	}

	public ResumeScanner() {
		populateSkillsSet();

	}

	


	
	
}