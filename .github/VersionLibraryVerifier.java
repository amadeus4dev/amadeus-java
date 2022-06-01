///usr/bin/env jbang "$0" "$@" ; exit $?

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.Properties;
import java.util.List;
import java.util.function.Function;

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

    public static void main(String[] args) {

        //Parameter
        String path = args[0];

        //Parse line to extract the version value
        Function<String, String> extractValue = str -> {
          Integer position = str.indexOf("VERSION");
          String chuncked = str.substring(position + "VERSION".length()).trim();
          chuncked = chuncked.replace("=","").trim();
          chuncked = chuncked.replace(";","");
          chuncked = chuncked.replace("\"","");
          return chuncked;
        };

        //Get library version from Java class (Amadeus.java)
        Function<String, String> getJavaVersion = param -> {
          try {
            List<String> allLines = Files.readAllLines(Paths.get(param + "/src/main/java/com/amadeus/Amadeus.java"));
            return allLines.stream()
              .filter(str -> str.contains("VERSION"))
              .limit(1)
              .map(extractValue)
              .peek(System.out::println)
              .findFirst()
              .orElseThrow(RuntimeException::new);
          } catch (IOException e) {
            return "999";
          }
        };

        //Get library version from Gradle file (gradle.properties)
        Function<String, String> getGradleVersion = param -> {
          try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(param + "gradle.properties")));
            String versionGradle = properties.get("VERSION_NAME").toString();
            System.out.println(versionGradle);
            return versionGradle;
          } catch (IOException e) {
              return "998";
          }
        };

        //Process
        File userDirPath = new File(System.getProperty("user.dir"));
        String directoryPath = userDirPath.getParent() + "/" + path;

        String versionJava = getJavaVersion.apply(directoryPath);
        String versionGradle = getGradleVersion.apply(directoryPath);

        //Assert
        if(versionJava.equals(versionGradle)) {
            System.out.println("Versions in the library are the same.");
            System.exit(0);
        } else {
            System.out.println("Versions in the library are not the same.");
            System.exit(-1);
        }
    }
}
