import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadCSVPerf {

	public static void main(String[] args) {
    System.out.println("3 col csv");
		long start2 = System.currentTimeMillis();
    String fileName2 = "/home/kenneth/Projects/PandasAteMyData/data/3col.csv";
		try (Stream<String> lines = Files.lines(Paths.get(fileName2))) {
			List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
			long end2 = System.currentTimeMillis();
      System.out.println("Time lapsed : " + (end2 - start2) + " ms");
		} catch (IOException e) {
			e.printStackTrace();
		}

    System.out.println("1 col csv");
		long start = System.currentTimeMillis();
    String fileName = "/home/kenneth/Projects/PandasAteMyData/data/1col.csv";
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
			long end = System.currentTimeMillis();
      System.out.println("Time lapsed : " + (end - start) + " ms");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}