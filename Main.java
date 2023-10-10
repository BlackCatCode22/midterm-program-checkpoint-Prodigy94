import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;


// Main.java
// Driver class for the Zoo program
// dH
// 9/26/23

// updated Oct 5, 2023


public class Main {

    // Creating the genUniqueID method
    private static String genUniqueID(String theSpecies, int numOfSpecies) {
        String prefix = "";
        int suffix = numOfSpecies + 1;


        if (theSpecies.contains("hyena")) {
            prefix = "Hy";
        }

        return prefix + Integer.valueOf(suffix);

    }


    public static void main(String[] args) {

        // Load all species classes with name.
        // Call the static methods to create a lists of names.
        Lion.inputLionNames();
        Tiger.inputTigerNames();
        Bear.inputBearNames();
        Hyena.inputHyenaNames();



        // Open a csv file using the split() method on a string object
        String path = "C:\\Users\\BE218\\Desktop\\arrivingAnimals.txt";
        String myFileLine = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int myCounter = 1;
            while ((myFileLine = reader.readLine()) != null) {
                // The input data from arrvingAnimals Looks like this:
                // 4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia

                // Create a String array named myArrayOfAnimalData
                String[] myArrayofAnimalData = myFileLine.split(",");


                // Create another String array named
                String[] myArrayOfAgeGenderSpecies = myArrayofAnimalData[0].split(" ");

                // output the Age, Gender and Species
                System.out.println("\nAge in years: " + myArrayOfAgeGenderSpecies[0]);
                System.out.println("\nText for age (should be 'year') " + myArrayOfAgeGenderSpecies[1]);
                System.out.println("\nText for age (should be 'old') " + myArrayOfAgeGenderSpecies[2]);
                System.out.println("\nGender is " + myArrayOfAgeGenderSpecies[3]);
                System.out.println("\nSpecies is " + myArrayOfAgeGenderSpecies[4]);


                // Code of the BirthDate() method
                // Get today's date
                Date currentDate = new Date();


                // Create a calendar instance and set it to today's date
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);

                // Subtract 4 years from the date
                calendar.add(Calendar.YEAR, - Integer.parseInt(myArrayOfAgeGenderSpecies[0]));

                // Get the result as a Date object
                Date YearsAgo = calendar.getTime();

                // Format and print the result
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = dateFormat.format(YearsAgo);
                System.out.println("Today's Date: " + dateFormat.format(currentDate));
                System.out.println("Date " +myArrayOfAgeGenderSpecies[0] + " Years Ago: " + formattedDate);



                System.out.println("\nSpecies is " + myArrayOfAgeGenderSpecies[4]);
                System.out.println("\n Animal number " + myCounter + "*************");
                System.out.println("\nmyArrayofAnimalData[0] is.. " +myArrayofAnimalData[0]);
                System.out.println("\nmyArrayofAnimalData[1] is.. " +myArrayofAnimalData[1]);
                System.out.println("\nmyArrayofAnimalData[2] is.. " +myArrayofAnimalData[2]);
                System.out.println("\nmyArrayofAnimalData[3] is.. " +myArrayofAnimalData[3]);
                System.out.println("\nmyArrayofAnimalData[4] is.. " +myArrayofAnimalData[4]);
                System.out.println("\nmyArrayofAnimalData[5] is.. " +myArrayofAnimalData[5]);
                System.out.println("\n\n");

                //increment the animal counter
                myCounter++;






                /*
                String myStr = myArray[0];
                System.out.println("\n myStr = " + myStr);
                myArray = myStr.split(" ");
                String mySpecies = myArray[4];
                System.out.println(" Species is: " + mySpecies);
                System.out.println("\n myStr = " + myStr);


               /*
                System.out.println(" First element: " + myArray[0]);
                System.out.println(" Second element: " + myArray[1]);
                System.out.println(" Third item: " + myArray[2]);
                System.out.println(" Fourth element: " + myArray[3]);
                System.out.println(" Fifth item: " + myArray[4]);
                System.out.println(" Sixth item: " + myArray[5]);

                */
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }




}
