import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //logo
        String[] logos = {
                "  ____  _                 _      ____                                 ",
                "/ ___|(_)_ __ ___  _ __ | | ___/ ___|  ___ __ _ _ __  _ __   ___ _ __ ",
                " ___  | | '_ ` _  | '_  | |/ _  ___   / __/ _` | '_  | '_   / _   '__|",
                " ___) | | | | | | | |_) | |  __/___) | (_| (_| | | | | | | |  __/ |   ",
                "|____/|_|_| |_| |_| .__/|_| ___|____/  ___ __,_|_| |_|_| |_| ___|_|   ",
                "                  |_|                                                 ",
        };
        for (String logo : logos) {
            System.out.println(logo);
        }
        //end
        Scan scan= new Scan();
        System.out.println(scan.Getopen());

    }
}