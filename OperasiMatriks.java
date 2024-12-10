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

    public static double[][] penjumlahan(double[][] matriks1, double[][] matriks2){
        double[][] hasil = new double[matriks1.length][matriks1[0].length];
        for (int i = 0; i < hasil.length; i++) {
            for (int j = 0; j < hasil[i].length; j++) {
                hasil[i][j] = matriks1[i][j] + matriks2[i][j];
            }
        }
        return hasil;
    }
    public static double[][] pengurangan(double[][] matriks1, double[][] matriks2){
        double[][] hasil = new double[matriks1.length][matriks1[0].length];
        for (int i = 0; i < hasil.length; i++) {
            for (int j = 0; j < hasil[i].length; j++) {
                hasil[i][j] = matriks1[i][j] - matriks2[i][j];
            }
        }
        return hasil;
    }
    public static void tambahKurang(int pilihan){
        int baris,kolom;
        double[][] matriks1,matriks2,hasil;
        System.out.println(pilihan == 1?"\nPenjumlahan Matriks":"\nPengurangan Matriks");
        while (true) {
            System.out.print("Input baris matriks: ");
            baris = sc.nextInt();
            System.out.print("Input kolom matriks: ");
            kolom = sc.nextInt();
            if (baris > 0 && kolom > 0) {
                break;
            }else
            System.out.println("baris dan kolom harus lebih besar dari 0.");
        }

        System.out.println("\nInput elemen matriks ke-1");
        matriks1 = inputElemen(baris, kolom);
        System.out.println("\nInput elemen matriks ke-2");
        matriks2 = inputElemen(baris, kolom);
        hasil = pilihan==1?penjumlahan(matriks1, matriks2):pengurangan(matriks1, matriks2);

        System.out.println("\nMatriks 1:");
        printMatriks(matriks1);
        System.out.println("\nMatriks 2:");
        printMatriks(matriks2);
        System.out.println("\nHasil matriks:");
        printMatriks(hasil);
    }

    public static void menuTambahKurang() {
        int pilihMenu;
        do {
            System.out.println("\n=== Operasi Penjumlahan dan Pengurangan Matriks ===");
            System.out.println("1. Penjumlahan Matriks (+)");
            System.out.println("2. Pengurangan Matriks (-)");
            System.out.println("3. Kembali ke menu utama");
            System.out.print("Pilih menu: ");
            pilihMenu = sc.nextInt();
            if (pilihMenu >3){
                System.out.println("Menu tidak tersedia.");
                continue;
            }
            if (pilihMenu==3){
                System.out.println("Kembali ke menu utama.\n");
                continue;
            }
            tambahKurang(pilihMenu);
        } while (pilihMenu!=3);
    }

    public static void perkalianMatriks() {
        int baris1, baris2, kolom1, kolom2;
        boolean isNotValid = true;
        System.out.println("\nPerkalian Matriks");
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
            else
                System.out.println("Baris atau kolom tidak valid.\n");
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
            System.out.println("\n=== Menu Invers Matriks ===");
            System.out.println("1. Invers Matriks 2x2");
            System.out.println("2. Invers Matriks 3x3");
            System.out.println("3. Kembali");
            System.out.print("Pilih menu: ");
            inversMenu = sc.nextInt();
            switch (inversMenu) {
                case 1:
                    invers2x2();
                    break;
                case 2:
                    invers3x3();
                    break;
                case 3:
                    System.out.println("Kembali ke menu utama\n");
                    break;
                default:
                    System.out.println("Input tidak valid. Coba lagi.\n");
                    break;
            }
        } while (inversMenu != 3);
    }

    public static void invers2x2() {
        double determinan;
        int barisKolom = 2;
        double[][] matriks;
        double[][] invers = new double[2][2];
        matriks = inputElemen(barisKolom, barisKolom);
        determinan = (matriks[0][0] * matriks[1][1]) - (matriks[0][1] * matriks[1][0]);
        if (determinan == 0) {
            System.out.println("Determinan tidak boleh kosong\n");
            return;
        }
        System.out.println("\nMatriks Awal:");
        printMatriks(matriks);
        for (int i = 0; i < barisKolom; i++) {
            for (int j = 0; j < barisKolom; j++) {
                int index = (i + j) % 2 == 0 ? 1 : -1;
                invers[i][j] = index * matriks[(j + 1) % 2][(i + 1) % 2];
                invers[i][j] /= determinan;
            }
        }
        System.out.println("\nInvers Matriks");
        printMatriks(invers);
    }

    public static void invers3x3(){
        double determinan=0;
        int barisKolom = 3;
        double[][] matriks;
        double[][] kofaktor = new double[barisKolom][barisKolom];
        double[][] invers = new double[barisKolom][barisKolom];
        matriks = inputElemen(barisKolom, barisKolom);
        for (int j = 0; j < barisKolom; j++) {
                determinan = determinan + ((matriks[0][j]*matriks[1][(j+1)%3]*matriks[2][(j+2)%3])-(matriks[0][(j+2)%3]*matriks[1][(j+4)%3]*matriks[2][(j+3)%3]));
        }
        if (determinan == 0) {
            System.out.println("Determinan tidak boleh kosong\n");
            return;
        }
        for (int i = 0; i < invers.length; i++) {
            for (int j = 0; j < invers[i].length; j++) {
                kofaktor[i][j] = (matriks[(i+1)%3][(j+1)%3]*matriks[(i+2)%3][(j+2)%3])-(matriks[(i+1)%3][(j+2)%3]*matriks[(i+2)%3][(j+1)%3]);
                invers[j][i] = kofaktor[i][j];
                invers[j][i] /= determinan;
            }
        }

        System.out.println("\nMatriks Awal");
        printMatriks(matriks);

        System.out.println("\nMatriks Invers");
        printMatriks(invers);
    } 

    public static void TransposeMatriks() {
        int baris, kolom;
        boolean isNotValid = true;
        System.out.println("\nTranspose Matriks");
        do {
            System.out.print("Masukkan baris matriks: ");
            baris = sc.nextInt();
            System.out.print("Masukkan kolom matriks: ");
            kolom = sc.nextInt();
            if (baris > 0 && kolom > 0)
                isNotValid = false;
            else
                System.out.println("Baris atau kolom tidak valid.");
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
                    menuTambahKurang();
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