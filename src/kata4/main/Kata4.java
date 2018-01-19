package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.view.*;

public class Kata4 {
    
    public static void main(String[] args) throws IOException {      
        String fileName = "emailsFile.txt";      
        List<String> mailList = MailListReader.read(fileName);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList); 
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram);      
        histogramDisplay.execute();
    } 
    
}