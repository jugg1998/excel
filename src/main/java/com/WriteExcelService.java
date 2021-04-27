package com;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: HGF
 * @Date: 4/21/21
 */
public class WriteExcelService {
    private static final String LAYER05 = "05_SIG2.lyr";
    private static final String LAYER07 = "07_SIG3.lyr";
    private static final String LAYER03 = "03_SIG1.lyr";
    private static final String LAYER12 = "12_SIG4.lyr";
    private static final String LAYER14 = "14_SIG5.lyr";

    public WriteExcelService() {

    }

    public void write() {
        Map<String, Double> data = new HashMap<>();
        //        collectData(LAYER03, data);
//        collectData(LAYER05, data);
//        collectData(LAYER07, data);
//        collectData(LAYER14, data);
//        collectData(LAYER12, data);

//        collectData("L3.lyr", data);
//        collectData("L5.lyr", data);
//        collectData("L7.lyr", data);
//        collectData("L8.lyr", data);
//        collectData("L10.lyr", data);
//        collectData("LN12.lyr", data);

        collectData("TOP.lyr", data);
        collectData("SIG1.lyr", data);
        collectData("SIG3.lyr", data);
        collectData("BOTTOM.lyr",data);
        saveExcel(data);
    }


    private static void collectData(String layerName, Map<String, Double> data) {
        File file = new File("/home/aurora/Documents/rocky-pre-layout/design_case/drone/AuroraDB/layers/" + layerName);
        Double length = 0d;
        String netName = "";
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            String lastLine = "";
            boolean startFlag = false;
            while ((line = bf.readLine()) != null) {
                if (line.trim().contains("DDR3_")) {
                    startFlag = true;
                    netName = line.split("\\s+")[1];
                }
                if (line.trim().startsWith("Line") && startFlag) {
                    String[] split = line.split("\\s+");
                    length += calculateLength(split);
                }
                if (line.endsWith("}") && lastLine.endsWith("}") && startFlag) {
                    startFlag = false;
                    data.put(netName, length);
                    length = 0d;
                }
                lastLine = line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveExcel(Map<String, Double> data) {
        try (HSSFWorkbook excel = new HSSFWorkbook()) {
            HSSFSheet sheet1 = excel.createSheet("sheet1");
            DecimalFormat df = new DecimalFormat("#.00");
            int i = 0;
            for (Map.Entry<String, Double> entry : data.entrySet()) {
                HSSFRow row = sheet1.createRow(i);
                row.createCell(0).setCellValue(entry.getKey());
                row.createCell(1).setCellValue(df.format(entry.getValue()));
                i++;
            }
            try (FileOutputStream fo = new FileOutputStream("/home/aurora/Documents/rocky-pre-layout/design_case/drone/data.xlsx")){
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
