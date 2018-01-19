package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.view.*;

public class Kata4 {

    public static void main(String[] args) throws IOException {
        Kata4 kata4 = new Kata4();
        kata4.execute();        
    }
    
    private final String fileName = "emailsFile.txt";
    private List<String> mailList;
    private Histogram<String> histogram;
    
    private void execute() throws IOException {
        input();
        process();
        output();
    }

    private void input() throws IOException {
        mailList = MailListReader.read(fileName);
    }

    private void process() {
        histogram = MailHistogramBuilder.build(mailList);        
    }
    
    private void output() {
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);
        histogramDisplay.execute();
    }
    
}