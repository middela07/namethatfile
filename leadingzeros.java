import java.io.File;

public class RewriteLastIntegerWithLeadingZeros {
    public static void main(String[] args) {
        // Define the path to the directory where the files are located
        String directoryPath = "/Users/nainamiddela/Documents/HighSchool CODE/blueJ projects 12th/Sem 2/LeadingZeroAdd/Box 24 Naina file#1/";

        System.out.println("code prints");
        // Get a list of files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("goes in get filename");
                    String oldFileName = file.getName();
                    String newFileName = rewriteLastIntegerWithLeadingZeros(oldFileName);

                    // Create File objects for the old and new file paths
                    File oldFile = new File(directoryPath + oldFileName);
                    File newFile = new File(directoryPath + newFileName);

                    // Check if the old file exists before renaming
                    if (oldFile.exists()) {
                        // Attempt to rename the file
                        System.out.println("old file exists");
                        if (oldFile.renameTo(newFile)) {
                            System.out.println("File '" + oldFileName + "' has been renamed to '" + newFileName + "'.");
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

    // Helper method to rewrite the last integer in a file name as a 4-digit number with leading zeros
    private static String rewriteLastIntegerWithLeadingZeros(String fileName) {
        int lastIntegerStart = fileName.lastIndexOf('_');
        System.out.println("goes in helper method");
        if (lastIntegerStart != -1) {
            String baseName = fileName.substring(0, lastIntegerStart + 1);
            String lastIntegerStr = fileName.substring(lastIntegerStart + 1, fileName.lastIndexOf('.'));
            try {
                int lastInteger = Integer.parseInt(lastIntegerStr);
                String newLastIntegerStr = String.format("%04d", lastInteger); // Format as a 4-digit number with leading zeros
                String fileExtension = fileName.substring(fileName.lastIndexOf('.'));

                return baseName + newLastIntegerStr + fileExtension;
            } catch (NumberFormatException e) {
                // If the last part is not a valid integer, return the original name
                return fileName;
            }
        }
        return fileName; // If there's no integer in the file name, return the original name.
    }
}
