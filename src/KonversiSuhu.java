import java.util.Scanner;

public class KonversiSuhu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        // Menyimpan menu dalam array
        String[] menuKonversi = {
                "Celsius ke Fahrenheit",
                "Celsius ke Kelvin",
                "Fahrenheit ke Celsius",
                "Fahrenheit ke Kelvin",
                "Kelvin ke Celsius",
                "Kelvin ke Fahrenheit",
                "Keluar"
        };

        do {
            // Menampilkan menu
            System.out.println("=== Aplikasi Konversi Suhu ===");
            for (int i = 0; i < menuKonversi.length; i++) {
                System.out.println((i + 1) + ". " + menuKonversi[i]);
            }
            System.out.print("Masukkan pilihan (1-7): ");

            if (!scanner.hasNextInt()) { // Cegah error jika user input non-angka
                System.out.println("Pilihan tidak valid! Masukkan angka 1-7.\n");
                scanner.next(); // Buang input yang salah
                continue;
            }

            pilihan = scanner.nextInt();

            if (pilihan == 7) {
                System.out.println("Terima kasih telah menggunakan aplikasi konversi suhu!");
                break;
            }
            if (pilihan < 1 || pilihan > 6) {
                System.out.println("Pilihan tidak valid! Masukkan angka 1-6.\n");
                continue;
            }

            // Debugging: Menampilkan pilihan konversi yang dipilih oleh pengguna
            System.out.println("[DEBUG] Kamu memilih konversi " + menuKonversi[pilihan - 1]);

            // Memasukkan suhu
            System.out.print("Masukkan suhu: ");
            if (!scanner.hasNextDouble()) { // Cegah error jika user input non-angka
                System.out.println("Input suhu tidak valid! Masukkan angka.\n");
                scanner.next(); // Buang input yang salah
                continue;
            }

            double suhu = scanner.nextDouble();
            double hasil = 0;

            // Melakukan konversi berdasarkan pilihan pengguna
            switch (pilihan) {
                case 1 -> hasil = celsiusToFahrenheit(suhu);
                case 2 -> hasil = celsiusToKelvin(suhu);
                case 3 -> hasil = fahrenheitToCelsius(suhu);
                case 4 -> hasil = fahrenheitToKelvin(suhu);
                case 5 -> hasil = kelvinToCelsius(suhu);
                case 6 -> hasil = kelvinToFahrenheit(suhu);
            }

            // Debugging: Menampilkan hasil konversi
            System.out.println("[DEBUG] Suhu yang dimasukkan: " + suhu);
            System.out.println("[DEBUG] Hasil konversi sebelum pembulatan: " + hasil);

            // Menampilkan hasil akhir ke pengguna dengan 2 angka di belakang koma
            System.out.printf("Hasil konversi %s adalah %.2f\n\n", menuKonversi[pilihan - 1], hasil);

        } while (true);

        scanner.close();
    }

    // Fungsi konversi suhu
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double f) {
        return (f - 32) * 5 / 9 + 273.15;
    }

    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double kelvinToFahrenheit(double k) {
        return (k - 273.15) * 9 / 5 + 32;
    }
}
