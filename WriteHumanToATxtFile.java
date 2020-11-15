package gr.projAboutCovid.leo.proj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class WriteHumanToATxtFile {

	
		public static void main(String[] args) {

			Human p1 = new Human("Λεωνίδας","1","1234", "Άρρεν");
			Human p2 =  new Human("Λεωνίδας","2","1234", "Άρρεν");

			try {
				FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
				ObjectOutputStream o = new ObjectOutputStream(f);

				// Write objects to file
				o.writeObject(p1);
				o.writeObject(p2);

				o.close();
				f.close();

				FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
				ObjectInputStream oi = new ObjectInputStream(fi);

				// Read objects
				WriteHumanToATxtFile pr1 = (WriteHumanToATxtFile) oi.readObject();
				WriteHumanToATxtFile pr2 = (WriteHumanToATxtFile) oi.readObject();

				System.out.println(pr1.toString());
				System.out.println(pr2.toString());

				oi.close();
				fi.close();

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println("Error initializing stream");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	
}


