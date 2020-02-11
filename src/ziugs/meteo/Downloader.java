package ziugs.meteo;

        import java.io.ByteArrayOutputStream;
        import java.io.IOException;
        import java.io.StringReader;
        import java.util.*;

        import org.apache.commons.csv.CSVFormat;
        import org.apache.commons.csv.CSVParser;
        import org.apache.commons.csv.CSVRecord;
        import org.apache.commons.net.ftp.FTPClient;

public class Downloader {

    private static final String FOLDER = "/10_min_andmed/";
    static List<String> allVallues = new LinkedList<>();
    static List<String> updateTimeOnServer = new LinkedList<>();
    static List<String> pressure = new LinkedList<>();
    static List<String> temperature = new LinkedList<>();
    static List<String> visibility = new LinkedList<>();
    static List<String> weatherFenomenon = new LinkedList<>();
    static List<String> cloudBase = new LinkedList<>();
    static List<String> okta = new LinkedList<>();


    protected void doDownload() {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        Map<Stations, List<String>> meteoData = new HashMap<>();
        try {
            ftpClient.connect("ftp.emhi.ee", 21);
            ftpClient.login("ppalennusalk", "***");
            ftpClient.enterLocalPassiveMode();
            Arrays.stream(Stations.values()).forEach(station -> meteoData.put(station,
                    parse(retrieveFile(FOLDER.concat(station.getCsvFileName()), ftpClient))));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.logout();
                ftpClient.disconnect();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private List<String> parse(ByteArrayOutputStream bos) {

        try (CSVParser parser = new CSVParser(new StringReader(new String(bos.toByteArray(), "UTF-8")),
                CSVFormat.DEFAULT.withDelimiter(';'));) {
            List<CSVRecord> lines = parser.getRecords();
            List<String> result = new ArrayList<String>();
            lines.get(lines.size() - 1).forEach(str -> result.add(str));

            for (int i = 0; i < result.size(); i++) {
                String b = result.get(i);
                allVallues.add(b);

            }

            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private ByteArrayOutputStream retrieveFile(String fileName, FTPClient ftpClient) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            if (!ftpClient.retrieveFile(fileName, bos)) {
                throw new RuntimeException(String.format("Unable to read %s", fileName));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bos;
    }

}
