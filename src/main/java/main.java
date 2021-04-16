import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import sun.util.resources.cldr.yav.LocaleNames_yav;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigDecimal;
import java.security.PrivilegedExceptionAction;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: HGF
 * ate: 4/16/21
 */
public class main {

    private static final String LAYER05 = "05_SIG2.lyr";
    private static final String LAYER07 = "07_SIG3.lyr";
    private static final String LAYER03 = "03_SIG1.lyr";

    public static void main(String[] args) {
        collectData(LAYER03);
        collectData(LAYER05);
        collectData(LAYER07);
    }

    private static void collectData(String layerName) {
        File file = new File("/home/aurora/Documents/rocky-pre-layout/design_case/design/AuroraDB/layers/" + layerName);
        Map<String, List<Double>> dqMap = new HashMap<>();
        List<Double> dq = new ArrayList<>();
        String dqName = "";
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            String lastLine = "";
            boolean startFlag = false;
            while ((line = bf.readLine()) != null) {
                if (line.trim().startsWith("DDR4_DQ")) {
                    startFlag = true;
                    dqName = line.split("\\s+")[1];
                    dq.clear();
                }
                if (line.trim().startsWith("Line") && startFlag) {
                    String[] split = line.split("\\s+");
                    dq.add(calculateLength(split));
                }
                if (line.endsWith("}") && lastLine.endsWith("}") && startFlag) {
                    startFlag = false;
                    dqMap.put(dqName, new ArrayList<>(dq));
                }
                lastLine = line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (HSSFWorkbook excel = new HSSFWorkbook()) {
            HSSFSheet sheet1 = excel.createSheet("sheet1");
            DecimalFormat df = new DecimalFormat("#.00");
            int i = 0;
            for (Map.Entry<String, List<Double>> entry : dqMap.entrySet()) {
                HSSFRow row = sheet1.createRow(i);
                row.createCell(0).setCellValue(entry.getKey());
                dq = entry.getValue();
                for (int j = 0; j < dq.size(); j++) {
                    HSSFCell cell = row.createCell(j + 1);
                    cell.setCellValue(df.format(dq.get(j)));
                }
                i++;
            }
            try (FileOutputStream fo = new FileOutputStream("/home/aurora/Documents/rocky-pre-layout/" + layerName + ".xlsx")){
                excel.write(fo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double calculateLength(String[] split) {
        Double x1 = Double.valueOf(split[2]);
        Double y1 = Double.valueOf(split[3]);
        Double x2 = Double.valueOf(split[4]);
        Double y2 = Double.valueOf(split[5]);
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
