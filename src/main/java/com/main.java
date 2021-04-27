package com;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.annotation.Target;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: HGF
 * ate: 4/16/21
 */
public class main {


    public static void main(String[] args) {
//        WriteExcelService writeExcelService = new WriteExcelService();
//        writeExcelService.write();
//        Memory um0 = new Memory(785f, -6f, 0);
//        Memory um1 = new Memory(785f, 550f, 0);
//        Memory um2 = new Memory(785f, 1105f, 0);
//        Memory um3 = new Memory(785f, 1660f, 0);
        Memory um0 = new Memory(462f, 1048f, 0);
        Memory um1 = new Memory(462f, 1553f, 1);
//
        Float w = 1716f;
        Float c = 462f;
        CalculateTrace calculateTrace = new CalculateTrace();
        System.out.println(calculateTrace.CalculateDistance(w, c, um0, 3));
        System.out.println(calculateTrace.CalculateDistance(w, c, um1, 4));
//        System.out.println(calculateTrace.CalculateDistance(w, c, um2, 2));
//        System.out.println(calculateTrace.CalculateDistance(w, c, um3, 3));

    }

}
