package Matriks;

import java.util.Scanner;

public class OperasiMatriks {
    static Scanner sc = new Scanner(System.in);

    public static void printMatriks(double matriks[][]) {
        for (int i = 0; i < matriks.length; i++) {
            System.out.print("|\t\t");
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.printf("%.2f\t", matriks[i][j]);
            }
            System.out.println("\t\s|");
        }
    }

    public static double[][] inputElemen(int baris, int kolom) {
        double[][] matriks = new double[baris][kolom];
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.printf("Masukkan elemen matriks [%s][%s]: ", i + 1, j + 1);
                matriks[i][j] = sc.nextDouble();
            }
        }
        return matriks;
    }

    public static void perkalianMatriks() {
        int baris1, baris2, kolom1, kolom2;
        boolean isNotValid = true;
        do {
            System.out.print("Input baris matriks ke-1: ");
            baris1 = sc.nextInt();
            while (true) {
                System.out.print("Input kolom matriks ke-1: ");
                kolom1 = sc.nextInt();
                System.out.print("Input baris matriks ke-2: ");
                baris2 = sc.nextInt();
                if (kolom1 == baris2)
                    break;
                else
                    System.out.println("Kolom matriks ke-1 dan Baris matriks ke-2 harus sama\n");
            }
            System.out.print("Input kolom matriks ke-2: ");
            kolom2 = sc.nextInt();
            if (baris1 > 0 && kolom1 > 0 && baris2 > 0 && kolom2 > 0)
                isNotValid = false;
            else System.out.println("Baris atau kolom tidak valid.");
        } while (isNotValid);
        System.out.println("\nInput elemen matriks ke-1");
        double[][] matriks1 = inputElemen(baris1, kolom1);
        System.out.println("\nInput elemen matriks ke-2");
        double[][] matriks2 = inputElemen(baris2, kolom2);
        double[][] hasil = new double[baris1][kolom2];

        for (int i = 0; i < baris1; i++) {
            for (int j = 0; j < kolom2; j++) {
                for (int k = 0; k < baris2; k++) {
                    hasil[i][j] += matriks1[i][k] * matriks2[k][j];
                }
            }
        }
        System.out.println("Matriks 1:");
        printMatriks(matriks1);
        System.out.println("Matriks 2:");
        printMatriks(matriks2);
        System.out.println("Hasil Matriks 1 * Matriks 2:");
        printMatriks(hasil);
    }
    public static void invers() {
        int inversMenu;
        do {
            System.out.println("===Daftar Menu===");
            System.out.println("1. Invers 2x2");
            System.out.println("2. Invers 3x3");
            System.out.println("3. Kembali");
            System.out.print("Pilih menu: ");
            inversMenu = sc.nextInt();
            switch (inversMenu) {
                case 1:
                    invers2x2();
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Kembali ke menu utama");
                    break;
                default:
                    System.out.println("Input tidak valid. Coba lagi.");
                    break;
            }
        } while (inversMenu != 3);
    }
    public static void invers2x2(){
        double determinan;
        int barisKolom = 2;
        double[][] matriks;
        double[][] invers = new double[2][2];
        matriks = inputElemen(barisKolom,barisKolom);
        System.out.println("\nMatriks Awal:");
        printMatriks(matriks);
        determinan = (matriks[0][0]*matriks[1][1])-(matriks[0][1]*matriks[1][0]);
        for (int i = 0; i < barisKolom; i++) {
            for (int j = 0; j < barisKolom; j++) {
                int index = (i+j) %2==0 ? 1:-1;
                invers[i][j] = index * matriks[(j + 1) % 2][(i + 1) % 2];
                invers[i][j]/= determinan;
            }
        }
        System.out.println("Invers Matriks");
        printMatriks(invers);
    }
    public static void TransposeMatriks() {
        int baris, kolom;
        boolean isNotValid = true;
        do {
            System.out.print("Masukkan baris matriks: ");
            baris = sc.nextInt();
            System.out.print("Masukkan kolom matriks: ");
            kolom = sc.nextInt();
            if (baris > 0 && kolom > 0) isNotValid = false;
            else System.out.println("Baris atau kolom tidak valid.");
        } while (isNotValid);

        double matriks[][] = inputElemen(baris, kolom);

        double Transpose[][] = new double[kolom][baris];
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                Transpose[j][i] = matriks[i][j];
            }
        }
        System.out.println("Matriks Asli: ");
        printMatriks(matriks);
        System.out.println("Transpose matriks: ");
        printMatriks(Transpose);
    }

    public static void main(String[] args) {
        int menu;
        do {
            System.out.println("===Daftar Pilihan Matriks===");
            System.out.println("1. Operasi Tambah dan Kurang Matriks");
            System.out.println("2. Operasi Perkalian Matriks");
            System.out.println("3. Invers Matriks");
            System.out.println("4. Transpose Matriks");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu: ");
            menu = sc.nextInt();
            switch (menu) {
                case 1:

                    break;
                case 2:
                    perkalianMatriks();
                    break;
                case 3:
                    invers();
                    break;
                case 4:
                    TransposeMatriks();
                    break;
                case 5:
                    System.out.println("Program selesai. Terima kasih.");
                    break;
                default:
                    System.out.println("Input menu tidak valid. Coba lagi.");
                    break;
            }
        } while (menu != 5);
    }
}