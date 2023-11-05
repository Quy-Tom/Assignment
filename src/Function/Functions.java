package Function;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;

public class Functions {

    private static Scanner sc = new Scanner(System.in);

    //Nhập vào một số nguyên, nhập khác số nguyên báo lỗi
    public static int setAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int setAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //Nhập vào một số thực
    public static double setADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double setADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    
    public static double setADouble(String inputMsg, String errorMsg, double lowerBound) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    //Nhập vào một chuỗi kí tự theo định dạng
    public static String setID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } 
            else return id;    
        }
    }
    
    public static String setID(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }
    
    //Nhập vào một chuỗi kí tự, khác rỗng
    public static String setString(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty()) {
                System.out.println(errorMsg);
            } 
            else return str;       
        }
    }
    
    public static double getRound(double k, String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        String s = df.format(k);
        double result = Double.parseDouble(s);
        return result;
    }
    
    public static int getRandomInt() {
        Random rand = new Random();
        return rand.nextInt();
    }

    public static double getRandomDoubleInRange(double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("Value of min and max are not true");
        }
        Random rand = new Random();
        return min + (max - min) * rand.nextDouble();
    }
    
    public static int getRandomIntInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Value of min and max are not true");
        }
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
    
    public static String genRandomBrandID(ArrayList<String> usedIDs) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder brandID = new StringBuilder();

        do {
            int x = getRandomIntInRange(0, 9); // Số từ 0-9
            char y = alphabet.charAt(getRandomIntInRange(0, alphabet.length() - 1)); 
            char z = alphabet.charAt(getRandomIntInRange(0, alphabet.length() - 1)); 
            int a = getRandomIntInRange(0, 9); 
            int b = getRandomIntInRange(0, 9);

            brandID.setLength(0); 
            brandID.append("B"); 
            brandID.append(x);
            brandID.append("-");
            brandID.append(y);
            brandID.append(z);
            brandID.append(a);
            brandID.append(b);
        } while (usedIDs.contains(brandID.toString()));

        return brandID.toString();
    }
    
    public static String genRandomBrandName() {
        String[] brand = {"BMW 3 Series","BMW 5 Series","BMW 7 Series","BMW X3","BMW X5","BMW X7","BMW Z4","BMW M3","BMW M5","BMW M8","BMW i3","BMW i4","BMW X1","BMW X6","BMW 8 Series","BMW X2","BMW M2","BMW X4","BMW X8", "BMW Z3",};
        return bn[getRandomIntInRange(0, bn.length - 1)];      
    }
    
    public static String genRandomSoundBrand() {
        String[] sb = {"SoundXperience", "SonicWave", "AudioZen", "HarmonicBeats", "SoundSculpt", "AcousticPulse", "SonicHarbor", "MeloGroove", "HarmonyWave", "EchoVibes", "SoniBlend", "AcousticPulse", "ResoTune", "SonicSphere", "VibeWave", "HarmonixRhythm", "PulseFusion", "EchoDynamics", "SoundWavesX", "AcousticMomentum"};
        return sb[getRandomIntInRange(0, sb.length - 1)];
    }
    
    public static String genRandomColor() {
        String[] colors = {"red", "green", "blue", "yellow", "black", "white", "brown", "cyan", "vermilion", "pink", "gray", "orange", "purple", "violet", "mauve", "gold"};
        return colors[getRandomIntInRange(0, colors.length - 1)];
    }
    
    public static String genRandomFrameID(ArrayList<String> usedIDs) {   
        StringBuilder frameID = new StringBuilder();

        do {
            int num1 = getRandomIntInRange(0, 9); 
            int num2 = getRandomIntInRange(0, 9); 
            int num3 = getRandomIntInRange(0, 9);
            int num4 = getRandomIntInRange(0, 9);
            int num5 = getRandomIntInRange(0, 9);

            frameID.setLength(0); 
            frameID.append("F"); 
            frameID.append(num1);
            frameID.append(num2);
            frameID.append(num3); 
            frameID.append(num4);
            frameID.append(num5);
        } while (usedIDs.contains(frameID.toString()));
        return frameID.toString();
    }
    
    public static String genRandomCarID(ArrayList<String> usedIDs) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder carID = new StringBuilder();

        do {
            int x = getRandomIntInRange(0, 9); 
            char y = alphabet.charAt(getRandomIntInRange(0, alphabet.length() - 1)); 
            char z = alphabet.charAt(getRandomIntInRange(0, alphabet.length() - 1)); 
            int a = getRandomIntInRange(0, 9); 
            int b = getRandomIntInRange(0, 9);

            carID.setLength(0); 
            carID.append("C"); 
            carID.append(x);
            carID.append(y);
            carID.append(z);
            carID.append(a);
            carID.append(b);
        } while (usedIDs.contains(carID.toString()));

        return carID.toString();
    }
}
