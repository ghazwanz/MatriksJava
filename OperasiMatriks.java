package Matriks;

import java.util.Scanner;

public class OperasiMatriks {
    static Scanner sc = new Scanner(System.in);

    public static void printMatriks(double matriks[][]) {
        for (int i = 0; i < matriks.length; i++) {
            System.out.print("|\t\t");
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.printf("%s\t", matriks[i][j]);
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


    public static void perkalianMatriks() {
        int baris1, baris2, kolom1, kolom2;
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
        System.out.println("\nInput elemen matriks ke-1");
        double[][] matriks1 = inputElemen(baris1, kolom1);
        System.out.println("\nInput elemen matriks ke-2");
        double[][] matriks2 = inputElemen(baris2, kolom2);
        double[][] hasil = new double[baris1][kolom2];

        for (int i = 0; i < baris1; i++) {
            for (int j = 0; j < matriks2[0].length; j++) {
                for (int k = 0; k < matriks1[0].length; k++) {
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
    public static void TransposeMatriks(){
        int baris, kolom;

        System.out.print("Masukkan baris matriks: ");
        baris = sc.nextInt();
        System.out.print("Masukkan kolom matriks: ");
        kolom = sc.nextInt();

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