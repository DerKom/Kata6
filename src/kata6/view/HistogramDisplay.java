package kata6.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import kata6.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay<T> extends ApplicationFrame{

    private final Histogram<T> histogram;
    private final String nameEjeX; 
    private final String nameEjeY; 
            
    public HistogramDisplay(Histogram<T> histogram, String nameEjeX, String nameEjeY) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        this.nameEjeX = nameEjeX; 
        this.nameEjeY = nameEjeY; 
        setContentPane(createPanel());
        pack();
    }
    
    public void execute() {
        setVisible(true);
    }
    
    private JPanel createPanel() {
       ChartPanel chartPanel = new ChartPanel(createChart(createDataset())); 
       chartPanel.setPreferredSize(new Dimension (500,400));
       return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset param) {
        JFreeChart chart = ChartFactory.createBarChart(
           "Histograma JFreeChart", nameEjeX, nameEjeY, param, 
            PlotOrientation.VERTICAL, false, rootPaneCheckingEnabled,
            rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        if (histogram != null){
           for (T key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", (Comparable) key);
            }    
        }
        
        return dataSet;
    }
    
}