import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RenameFilesWithBoxAndNumber {
    public static void main(String[] args) {
        // Define the path to the directory where the files are located
        String directoryPath = "/Users/nainamiddela/Documents/HighSchool CODE/blueJ projects 12th/Sem 2/LeadingZeroAdd/Box 24 Naina file#1/";


        // Create a Scanner object to get user input for the Box #
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Box #: ");
        String boxNumber = scanner.next();
        System.out.print("Enter the starting number for the middle part: ");
        int startingNumber = scanner.nextInt();
        scanner.close();

        // Get a list of files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            // Sort the files in ascending order based on file name
            Arrays.sort(files, Comparator.comparing(File::getName));

            for (File file : files) {
                if (file.isFile()) {
                    String oldFileName = file.getName();
                    String newFileName = renameFileWithBoxAndNumber(boxNumber, startingNumber);

                    // Create File objects for the old and new file paths
                    File oldFile = new File(directoryPath + oldFileName);
                    File newFile = new File(directoryPath + newFileName);

                    // Check if the old file exists before renaming
                    if (oldFile.exists()) {
                        // Attempt to rename the file
                        if (oldFile.renameTo(newFile)) {
                            System.out.println("File '" + oldFileName + "' has been renamed to '" + newFileName + "'.");
                            startingNumber++; // Increment the starting number for the next file
                        } else {
                            System.out.println("Failed to rename the file '" + oldFileName + "'. Please check file permissions.");
                        }
                    }
                }
            }
        } else {
            System.out.println("No files found in the specified directory.");
        }
    }

    // Helper method to rename the file name in the format "##_####_####"
    private static String renameFileWithBoxAndNumber(String boxNumber, int number) {
        String formattedNumber = String.format("%04d", number);
        return boxNumber + "_" + formattedNumber + "_0000.jpg"; // Replace "ext" with the actual file extension
    }
}
