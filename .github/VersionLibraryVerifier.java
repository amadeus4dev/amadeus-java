///usr/bin/env jbang "$0" "$@" ; exit $?

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.List;

/**
 * This Java class verify in the library that in the following files:
 *
 * - /gradle.properties
 * - /src/main/java/com/amadeus/Amadeus.java
 *
 * The versions of the library continues with the same value.
 *
 * How to run in local:
 * jbang VersionLibraryVerifier.java ./
 */
public class VersionLibraryVerifier {

    public static void main(String[] args) throws IOException {

        String specDir = args[0];
        File userDirPath = new File(System.getProperty("user.dir"));
        String specPath = userDirPath.getParent() + "/" + specDir;

        try {
            List<String> allLines = Files.readAllLines(Paths.get(specPath + "/src/main/java/com/amadeus/Amadeus.java"));
            String versionJava = allLines.stream()
                .filter(str -> str.contains("VERSION"))
                .limit(1)
                .map(str -> {
                    Integer position = str.indexOf("VERSION");
                    String chuncked = str.substring(position + "VERSION".length()).trim();
                    chuncked = chuncked.replace("=","").trim();
                    chuncked = chuncked.replace(";","");
                    chuncked = chuncked.replace("\"","");
                    return chuncked;
                })
                .peek(System.out::println)
                .findFirst()
                .get();

            Properties properties= new Properties();
            properties.load(new FileInputStream(new File(specPath + "gradle.properties")));
            String versionGradle = properties.get("VERSION_NAME").toString();
            System.out.println(versionGradle);

            //Assert
            if(versionJava.equals(versionGradle)) {
                System.out.println("Versions in the library are the same.");
                System.exit(0);
            } else {
                System.out.println("Versions in the library are not the same.");
                System.exit(-1);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}