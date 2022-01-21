package inventorymanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class BarChartExample extends JFrame {
    public String[] str = new String[]{"null", "null", "null", "null", "null", "null"};
    public int[] arr = new int[]{0, 0, 0, 0, 0, 0};
    public String a = null;
    private static final long serialVersionUID = 1L;
    Object result;
    public BarChartExample(String appTitle) {
        super(appTitle);
        CategoryDataset dataset = createDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart",
                "Products",
                "Quantity",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            JFrame frame = new JFrame();
            a = (String) result;
            String query = "select s.stkname,SUM(quantity) from order_det where month='" + a + "' group by stockname order by sum(quantity)desc";
            try (Connection con = DriverConnection.getConnection()) {
                Statement t = con.createStatement();
                ResultSet rs = t.executeQuery(query);
                int i = 0;
                while (rs.next()) {
                    str[i] = (rs.getString(1));
                    arr[i] = (rs.getInt(2));
                    i++;
                }
                System.out.println("sucess");
            }
        } catch (Exception e) {
            System.out.println(e+"in barchartexample");
        }
        String month = a;
        String s1 = str[0], s2 = str[1], s3 = str[2], s4 = str[3], s5 = str[4];
        int a = arr[0], b = arr[1], c = arr[2], d = arr[3], e = arr[4];
        dataset.addValue(a, s1, month);
        dataset.addValue(b, s2, month);
        dataset.addValue(c, s3, month);
        dataset.addValue(d, s4, month);
        dataset.addValue(e, s5, month);
        return dataset;
    }
}