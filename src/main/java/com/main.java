package com;

/**
 * @Author: HGF
 * @Date: 4/16/21
 */
public class main {


    public static void main(String[] args) {
        WriteExcelService writeExcelService = new WriteExcelService();
//        writeExcelService.writeCLK();
//
//        case7575();
//        caseFMC();
//        caseAM574();
        casePKG();
    }












    private static void casePKG() {
        Memory um0 = new Memory(1350f, 849f);
        Float w = 654f;
        Float c = 654f;
        CalculateTrace calculateTrace = new CalculateTrace();
        System.out.println(calculateTrace.CalculateDistance(w, c, um0));
    }


    private static void caseAM574() {
        Memory um0 = new Memory(640f, 1973f);
        Memory um1 = new Memory(40f, 1973f);
        Memory um2 = new Memory(560f, 1973f);
        Float w = 433f;
        Float c = 433f;
        CalculateTrace calculateTrace = new CalculateTrace();
        System.out.println(calculateTrace.CalculateDistance(w, c, um0));
        System.out.println(calculateTrace.CalculateDistance(w, c, um1));
        System.out.println(calculateTrace.CalculateDistance(w, c, um2));
    }

    private static void caseFMC() {
        Memory um0 = new Memory(1320f, 695f);
        Memory um2 = new Memory(1320f, 190f);
        Float w = 858f;
        Float c = 858f;
        CalculateTrace calculateTrace = new CalculateTrace();
        System.out.println(calculateTrace.CalculateDistance(w, c, um0));
        System.out.println(calculateTrace.CalculateDistance(w, c, um2));
    }



    private static void case7575() {
        Memory um0 = new Memory(1445f, -632f);
        Memory um1 = new Memory(1445f, -77f);
        Memory um2 = new Memory(1445f, 478f);
        Memory um3 = new Memory(1445f, 1033f);
        Float w = 660f;
        Float c = 660f;
        CalculateTrace calculateTrace = new CalculateTrace();
        System.out.println(calculateTrace.CalculateDistance(w, c, um0));
        System.out.println(calculateTrace.CalculateDistance(w, c, um1));
        System.out.println(calculateTrace.CalculateDistance(w, c, um2));
        System.out.println(calculateTrace.CalculateDistance(w, c, um3));
    }

}
