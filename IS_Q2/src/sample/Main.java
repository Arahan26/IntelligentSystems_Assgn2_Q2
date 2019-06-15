package sample;

/*import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;*/

import java.util.Random;
import java.util.Scanner;

public abstract class Main //extends //Application {
{

    /*@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/


    public static void main(String[] args) {
        mainMenu();
    }

    /**
     * Displays the main menu for the program.
     */
    public static void menuDisplay() {
        System.out.println("(1) 2a");
        System.out.println("(2) 2b");
        System.out.println("(3) 2c");
        System.out.println("(4) 2d");
        System.out.println("(5) Exit");
    }

    /**
     * Displays the menu and takes user input
     */
    public static void mainMenu() {
        try {
            String menuOption;
            do {
                menuDisplay();

                menuOption = readInput();
                switch (menuOption) {
                    case "1":
                        answerA();
                        break;
                    case "2":
                        answerB();
                        break;
                    case "3":
                        answerC();
                        break;
                    case "4":
                        answerD();
                        break;
                    case "5":
                        menuOption = "5";
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please select from the given options.");
                }
            }
            while (!menuOption.equals("5"));//"5");
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    /**
     * Main function to run 2a.
     */
    public static void answerA() {
        try {
            String menuOption;

            System.out.println("-----Start of 1A-----");
            System.out.println("1. Start search at u=0");
            System.out.println("2. Start search at a random value of u");
            System.out.println("3. Enter a user specified value for u");
            System.out.println("4. Exit to main menu");
            //menuOption = readInput();
            do {
                //menuDisplay();
                menuOption = readInput();
                switch (menuOption) {
                    case "1":
                        answerAStartAtUZero();
                        break;
                    case "2":
                        answerAStartAtRandomValue();
                        break;
                    case "3":
                        answerAStartAtUserValue();
                        break;
                    case "4":
                        menuOption = "4";
                        //mainMenu();
                        //System.exit(0);
                        break;
                    default:
                        System.out.println("Please select from the given options.");
                }
            }
            while (!menuOption.equals("4"));// "4");
            mainMenu();

        } catch (Exception e) {
            System.out.println("Error!");
        }


    }

    /**
     * runs the algorithm at u = 0
     */
    private static void answerAStartAtUZero() {
        double T = 100;
        double z = 0.1;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double maxZ = -1;
        double u = 0;
        double correspondingU = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 2.0;
        double random;
        random = rNGOneZero();
        while ((T >= minT) && (z < threshold)) {
            zNew = (u * Math.sin(1 / ((0.01) + u * u))) + (u * u * u) * Math.sin(1 / (0.001 + (u * u * u * u)));
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
            }
            u = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU);
        answerA();
        /*while ((T>=minT) &&(z<threshold) )
        {
            zNew = (u * Math.sin(1 / ((0.01) + u*u))) +(u*u*u) * Math.sin(1 / (0.001 + (u*u*u*u)));
            d = zNew -z;
            p = d/T;

            if(d>0)
                z=zNew;

            else if(random<Math.exp(p))
                {
                z =zNew;
            }
            System.out.println("\tz="+zNew+"\tT="+T+"\tu="+u);
            T = minT;
            //System.out.println("\tz="+zNew+"\tT="+T+"\tu="+u);
        }*/
    }

    /**
     * Runs the algorithm at a random value of u. value between -1 and 1
     */
    private static void answerAStartAtRandomValue() {

        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u = rNG();
        double maxZ = -1;
        double correspondingU = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();
        while ((T >= minT) && (z < threshold)) {
            zNew = (u * Math.sin(1 / ((0.01) + Math.pow(u, 2))) + (Math.pow(u, 3)) * Math.sin(1 / (0.001 + (Math.pow(u, 4)))));
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
            }
            u = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU);
        answerA();
    }

    /**
     * runs the algorithm at a user specified value of u. value between -1 and 1.
     */
    public static void answerAStartAtUserValue() {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u;
        double maxZ = -1;
        double correspondingU = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();
        System.out.println("Enter a value for u from -1 to 1");
        u = readDoubleInput();
        while ((T >= minT) && (z < threshold)) {
            zNew = (u * Math.sin(1 / ((0.01) + Math.pow(u, 2))) + (Math.pow(u, 3)) * Math.sin(1 / (0.001 + (Math.pow(u, 4)))));
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
            }
            u = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU);
        answerA();
    }

    /**
     * reads the input as double
     * @return
     */
    private static double readDoubleInput() {
        Double input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextDouble();
        return input;
    }

    /**
     * main function to run 2b
     */
    public static void answerB() {
        try {
            String menuOption;

            System.out.println("-----Start of B-----");
            System.out.println("1. Start search at u,v = 0,0");
            System.out.println("2. Start search at a random value of u and v");
            System.out.println("3. Enter a user specified value for u and v");
            System.out.println("4. Exit to main menu");
            //menuOption = readInput();
            do {
                menuOption = readInput();
                switch (menuOption) {
                    case "1":
                        answerBStartAtUZeroVZero();
                        break;
                    case "2":
                        answerBStartAtRandomValueOfUandV();
                        break;
                    case "3":
                        answerBStartAtUserSpecifiedValueForUandV();
                    case "4":
                        menuOption = "4";
                        //System.exit(0);
                        break;
                    default:
                        System.out.println("Please select from the given options.");
                }
            }
            while (menuOption != "4");
            mainMenu();

        } catch (Exception e) {
            System.out.println("Error!");
        }


    }


    /**
     * Runs the algorithm at u = 0 and v = 0
     */
    public static void answerBStartAtUZeroVZero() {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u = 0;
        double maxZ = -1;
        double correspondingU = 0;
        double v = 0;
        double correspondingV = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();
        while ((T >= minT) && (z < threshold)) {
            zNew = ((u * Math.pow(v, 2)) * Math.sin(v / ((0.01) + Math.pow(u, 2))) + (Math.pow(u, 3) * Math.pow(v, 2)) * Math.sin((Math.pow(v, 3)) / (0.001 + (Math.pow(u, 4)))));
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
                correspondingV = v;
            }
            u = rNG();
            v = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u + "v=" + v);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU + "\tcorrespondingV = " + correspondingV);
        answerB();
    }

    /**
     * runs the algorithm at a random value of u and v. values lie between -1 and 1
     */
    public static void answerBStartAtRandomValueOfUandV() {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u = rNG();
        double maxZ = -1;
        double correspondingU = 0;
        double v = rNG();
        double correspondingV = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();
        while ((T >= minT) && (z < threshold)) {
            zNew = ((u * Math.pow(v, 2)) * Math.sin(v / ((0.01) + Math.pow(u, 2))) + (Math.pow(u, 3) * Math.pow(v, 2)) * Math.sin((Math.pow(v, 3)) / (0.001 + (Math.pow(u, 4)))));
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
                correspondingV = v;
            }
            u = rNG();
            v = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u + "v=" + v);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU + "\tcorrespondingV = " + correspondingV);
        answerB();
    }

    /**
     * runs the algorithm at user specified value of u and v. values lie between -1 and 1
     */
    public static void answerBStartAtUserSpecifiedValueForUandV() {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u;
        double maxZ = -1;
        double correspondingU = 0;
        double v;
        double correspondingV = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();
        System.out.println("Enter a value for u from -1 to 1");
        u = readDoubleInput();
        System.out.println("Enter a value for v from -1 to 1");
        v = readDoubleInput();
        while ((T >= minT) && (z < threshold)) {
            zNew = ((u * Math.pow(v, 2)) * Math.sin(v / ((0.01) + Math.pow(u, 2))) + (Math.pow(u, 3) * Math.pow(v, 2)) * Math.sin((Math.pow(v, 3)) / (0.001 + (Math.pow(u, 4)))));
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
                correspondingV = v;
            }
            u = rNG();
            v = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u + "v=" + v);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU + "\tcorrespondingV = " + correspondingV);
        answerB();
    }

    /**
     * main function to run 2c
     */
    public static void answerC() {
        try {
            String menuOption;
            System.out.println("-----Start of 1C-----");
            System.out.println("1. Start search at u,v,w = 0,0,0");
            System.out.println("2. Start search at a random value of u, v, and w");
            System.out.println("3. Enter a user specified value for u, v, and w");
            System.out.println("4. Exit to main menu");

            //menuOption = readInput();

            do {
                menuOption = readInput();
                switch (menuOption) {
                    case "1":
                        answerCStartAtUZeroVZeroWZero();
                        break;
                    case "2":
                        answerCStartAtRandomValueofUVW();
                        break;
                    case "3":
                        answerCStartAtUserSpecifiedValueOfUVandW();
                        break;
                    case "4":
                        menuOption = "4";
                        //mainMenu();
                        //System.exit(0);
                    default:
                        System.out.println("Please select from the given options.");
                }
            }
            while (menuOption != "4");
            mainMenu();

        } catch (Exception e) {
            System.out.println("Error!");
        }


    }

    /**
     * runs algorithm  at u=0, v=0 and w=0
     */
    public static void answerCStartAtUZeroVZeroWZero() {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u = 0;
        double maxZ = -1;
        double correspondingU = 0;
        double v = 0;
        double correspondingV = 0;
        double w = 0;
        double correspondingW = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();
        while ((T >= minT) && (z < threshold)) {
            zNew = (((u * Math.pow(v, 2) + (Math.sin(Math.PI) * w)) * ((Math.sin(v / ((0.01)) * (Math.sin((Math.PI * w) / 2))))) + (((Math.pow(u, 3) * Math.pow(v, 2) * w)) * Math.sin((Math.pow(v, 3) / ((0.001 * (Math.pow(Math.sin((Math.PI * w) / 2), 2))))))) + (Math.pow(u, 4) + Math.pow((w - 1), 2))));
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            //temp = T;
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
                correspondingV = v;
                correspondingW = w;
            }
            u = rNG();
            v = rNG();
            w = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u + "\tv=" + v + "\tw=" + w);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU + "\tcorrespondingV = " + correspondingV + "\tcorrespondingW = " + correspondingW);
        answerC();
    }

    /**
     * runs the algorithm at random value of u,v and w. values lie between -1 and 1.
     */
    public static void answerCStartAtRandomValueofUVW() {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u = rNG();
        double maxZ = -1;
        double correspondingU = 0;
        double v = rNG();
        double correspondingV = 0;
        double w = rNG();
        double correspondingW = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();
        while ((T >= minT) && (z < threshold)) {
            zNew = (((u * Math.pow(v, 2) + (Math.sin(Math.PI) * w)) * ((Math.sin(v / ((0.01)) * (Math.sin((Math.PI * w) / 2))))) + (((Math.pow(u, 3) * Math.pow(v, 2) * w)) * Math.sin((Math.pow(v, 3) / ((0.001 * (Math.pow(Math.sin((Math.PI * w) / 2), 2))))))) + (Math.pow(u, 4) + Math.pow((w - 1), 2))));
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            //temp = T;
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
                correspondingV = v;
                correspondingW = w;
            }
            u = rNG();
            v = rNG();
            w = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u + "\tv=" + v + "\tw=" + w);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU + "\tcorrespondingV = " + correspondingV + "\tcorrespondingW = " + correspondingW);
        answerC();
    }

    public static void answerCStartAtUserSpecifiedValueOfUVandW() {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u;
        double maxZ = -1;
        double correspondingU = 0;
        double v;
        double correspondingV = 0;
        double w;
        double correspondingW = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();
        System.out.println("Enter a value for u from -1 to 1");
        u = readDoubleInput();
        System.out.println("Enter a value for v from -1 to 1");
        v = readDoubleInput();
        System.out.println("Enter a value for w from -1 to 1");
        w = readDoubleInput();
        while ((T >= minT) && (z < threshold)) {
            zNew = (((u * Math.pow(v, 2) + (Math.sin(Math.PI) * w)) * ((Math.sin(v / ((0.01)) * (Math.sin((Math.PI * w) / 2))))) + (((Math.pow(u, 3) * Math.pow(v, 2) * w)) * Math.sin((Math.pow(v, 3) / ((0.001 * (Math.pow(Math.sin((Math.PI * w) / 2), 2))))))) + (Math.pow(u, 4) + Math.pow((w - 1), 2))));
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            //temp = T;
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
                correspondingV = v;
                correspondingW = w;
            }
            u = rNG();
            v = rNG();
            w = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u + "\tv=" + v + "\tw=" + w);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU + "\tcorrespondingV = " + correspondingV + "\tcorrespondingW = " + correspondingW);
        answerC();
    }


    /**
     * main function to run 2d
     */
    public static void answerD() {
        try {
            String menuOption;
            System.out.println("-----Start of 1D-----");
            System.out.println("1. Start search at u,v,w,y = 0,0,0,0");
            System.out.println("2. Start search at a random value of u, v, w and y");
            System.out.println("3. Enter a user specified value for u, v, w and y");
            System.out.println("4. Exit to main menu");
            //menuOption = readInput();

            do {
                menuOption = readInput();
                switch (menuOption) {
                    case "1":
                        answerDStartAtZero();
                        break;
                    case "2":
                        answerDStartAtRandomValueForUVWandY();
                        break;
                    case "3":
                        answerDStartAtUserSpecifiedValuesForUVandW();
                        break;
                    case "4":
                        menuOption = "4";
                        break;
                    default:
                        System.out.println("Please select from the given options.");
                }
            }
            while (menuOption != "4");
            menuDisplay();
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    /**
     * runs the algorithm at random value of u, v and w with their values between -1 and 1.
     * Value of y is either 1 or 0 or -1.
     */
    public static void answerDStartAtRandomValueForUVWandY()
    {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u = rNG();
        double maxZ = -1;
        double correspondingU = 0;
        double v = rNG();
        double correspondingV = 0;
        double w = rNG();
        double correspondingW = 0;
        double y = rNGNegOneOrZeroOrOne();
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();

        while ((T >= minT) && (z < threshold)) {
            zNew = ((((u * Math.pow(v, 2) + (Math.sin(Math.PI) * w)) * ((Math.sin(v / ((0.01)) * (Math.sin((Math.PI * w) / 2))))) + (((Math.pow(u, 3) * Math.pow(v, 2) * w)) * Math.sin((Math.pow(v, 3) / ((0.001 * (Math.pow(Math.sin((Math.PI * w) / 2), 2))))))) + (Math.pow(u, 4) + Math.pow((w - 1), 2))))) * y;
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            //temp = T;
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
                correspondingV = v;
                correspondingW = w;
            }
            u = rNG();
            v = rNG();
            w = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u + "\tv=" + v + "\tw=" + w);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU + "\tcorrespondingV = " + correspondingV + "\tcorrespondingW = " + correspondingW+"corresponding Y = "+y);
        answerD();
    }

    /**
     * runs the algorithm at u, v, w, and y at 0.
     */
    public static void answerDStartAtZero()
    {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u = 0;
        double maxZ = -1;
        double correspondingU = 0;
        double v = 0;
        double correspondingV = 0;
        double w = 0;
        double correspondingW = 0;
        double y = 0;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();

        while ((T >= minT) && (z < threshold)) {
            zNew = ((((u * Math.pow(v, 2) + (Math.sin(Math.PI) * w)) * ((Math.sin(v / ((0.01)) * (Math.sin((Math.PI * w) / 2))))) + (((Math.pow(u, 3) * Math.pow(v, 2) * w)) * Math.sin((Math.pow(v, 3) / ((0.001 * (Math.pow(Math.sin((Math.PI * w) / 2), 2))))))) + (Math.pow(u, 4) + Math.pow((w - 1), 2))))) * y;
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            //temp = T;
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
                correspondingV = v;
                correspondingW = w;
            }
            u = rNG();
            v = rNG();
            w = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u + "\tv=" + v + "\tw=" + w);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU + "\tcorrespondingV = " + correspondingV + "\tcorrespondingW = " + correspondingW+"corresponding Y = "+y);
        answerD();
    }

    /**
     * runs the algorithm at a user specified value of u, v, w and y.
     * u, v and w lie between -1 and 1.
     * y can be either 1 or 0 or -1.
     */
    public static void answerDStartAtUserSpecifiedValuesForUVandW() {
        double T = 100;
        double z = 0.2;
        double minT = 0.001;
        double alpha = 0.99;
        double zNew;
        double u;
        double maxZ = -1;
        double correspondingU = 0;
        double v;
        double correspondingV = 0;
        double w;
        double correspondingW = 0;
        double y;
        double d;
        double p;
        double P = 0;
        double threshold = 5.0;
        double random;
        random = rNGOneZero();
        System.out.println("Enter a value for u from -1 to 1");
        u = readDoubleInput();
        System.out.println("Enter a value for v from -1 to 1");
        v = readDoubleInput();
        System.out.println("Enter a value for w from -1 to 1");
        w = readDoubleInput();
        System.out.println("Please enter a value for y in[-1,0,1]");
        y=readDoubleInput();
        while ((T >= minT) && (z < threshold)) {
            zNew = ((((u * Math.pow(v, 2) + (Math.sin(Math.PI) * w)) * ((Math.sin(v / ((0.01)) * (Math.sin((Math.PI * w) / 2))))) + (((Math.pow(u, 3) * Math.pow(v, 2) * w)) * Math.sin((Math.pow(v, 3) / ((0.001 * (Math.pow(Math.sin((Math.PI * w) / 2), 2))))))) + (Math.pow(u, 4) + Math.pow((w - 1), 2))))) * y;
            d = zNew - z;
            p = d / T;

            if ((random >= 0.0) && random <= p)
                P = p;
            else if ((random > p) && random <= 1)
                P = 1 - p;

            if (d > 0)
                z = zNew;

            else if (random < Math.exp(P)) {
                z = zNew;
            }
            //temp = T;
            T = alpha * T;
            if (z > maxZ) {
                maxZ = zNew;
                correspondingU = u;
                correspondingV = v;
                correspondingW = w;
            }
            u = rNG();
            v = rNG();
            w = rNG();
            System.out.println("\tz=" + z + "\tT=" + T + "\tu=" + u + "\tv=" + v + "\tw=" + w);
        }
        System.out.println("Highest Z = " + maxZ + "\tCorresponding u = " + correspondingU + "\tcorrespondingV = " + correspondingV + "\tcorrespondingW = " + correspondingW+"corresponding Y = "+y);
        answerD();

    }

    /**
     * generates and returns a random number from -1 to 1.
     * @return
     */
    public static double rNG() {
        double x;
        Random random = new Random();
        x = random.nextDouble() * 2 - 1;
        return x;
    }

    /**
     * generates and return a random value between 1 and 0.
     * @return
     */
    public static double rNGOneZero() {
        double randomNumber;
        randomNumber = Math.random();
        return randomNumber;
    }

    /**
     * generates and returns a random value that is either 1 or 0 or -1.
     * @return
     */
    public static int rNGNegOneOrZeroOrOne() {
        Random random = new Random();
        int randomNumber;
        randomNumber = random.nextInt(3) - 1;
        return randomNumber;
    }

    /**
     * reads string input and returns it.
     * @return
     */
    public static String readInput() {
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        return input;
    }

}

