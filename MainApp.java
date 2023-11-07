public class MainApp {
    public static void main(String[] args) {
        // Retrieve the folder path from command-line arguments
        String folderPath = args.length > 0 ? args[0] : null;

        if (folderPath != null) {
            // Call the class for renaming files with leading zeros
            RewriteLastIntegerWithLeadingZeros.main(new String[]{folderPath});

            // Call the class for renaming files backward with leading zeros
            RenameFilesWithBoxAndNumber.main(new String[]{folderPath});
        } else {
            System.out.println("Folder path not provided. Exiting.");
        }
    }
    import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

public void createZipFile(List<File> filesToZip, String zipFileName) {
    try (ZipArchiveOutputStream zipOut = new ZipArchiveOutputStream(new FileOutputStream(zipFileName))) {
        for (File file : filesToZip) {
            ZipArchiveEntry entry = new ZipArchiveEntry(file, file.getName());
            zipOut.putArchiveEntry(entry);
            Files.copy(file.toPath(), zipOut);
            zipOut.closeArchiveEntry();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
