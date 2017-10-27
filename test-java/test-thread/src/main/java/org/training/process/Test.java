package org.training.process;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by anderson on 17-10-26.
 */
public class Test
{
    public static void main(String[] args) throws IOException
    {
        ProcessBuilder pb = new ProcessBuilder("sh", "/bin", "java -version");
        Process process = pb.start();
        Scanner scanner = new Scanner(process.getInputStream());

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}
