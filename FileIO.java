import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class FileIO {
/**
     * Utility class constructor.
     */
    private FileIO() {
        // Prevent instantiation
    }

    /**
     * Main method to execute file reading and writing operations.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        File inputFile = new File("Unit2-02-input.txt");

        try (Scanner scanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter("Unit2-02-output.txt")) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (!line.isEmpty()) {
                    String[] tokens = line.split("\\s+");
                    int sum = 0;
                    boolean hasError = false;

                    for (String token : tokens) {
                        try {
                            sum += Integer.parseInt(token);
                        } catch (NumberFormatException e) {
                            hasError = true;
                            break;
                        }
                    }

                    if (hasError) {
                        writer.println("Please enter a valid integer.");
                    } else {
                        writer.println(sum);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File I/O Error: " + e.getMessage());
        }
    }
}
