package kata4.view;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;

public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<String> mails) {
        Histogram histo = new Histogram();
        for (String mail : mails) {
            histo.increment(new Mail(mail).getDomain());
        }
        return histo;
    }
    
}