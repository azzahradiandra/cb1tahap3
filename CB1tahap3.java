public class CB1tahap3 {
    public static void main(String[] args) {
        Perusahaan ptInovasi = new Perusahaan("PT. Inovasi Teknologi");

        Karyawan k1 = new Karyawan("Andi", 5000000, ptInovasi);
        Programmer p1 = new Programmer("Budi", 7000000, ptInovasi, 2000000);
        Manager m1 = new Manager("Ekak", 6000000, ptInovasi, 3000000);

        k1.infoGaji();
        p1.infoGaji();
        m1.infoGaji();
    }
}

class Perusahaan {
    private final String namaPerusahaan;

    public Perusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }
}

class Karyawan {
    private String nama;
    private double gajiPokok;
    private Perusahaan perusahaan;

    public Karyawan(String nama, double gajiPokok, Perusahaan perusahaan) {
        setNama(nama);
        this.gajiPokok = gajiPokok;
        this.perusahaan = perusahaan;
    }

    public void setNama(String nama) {
        if (nama.length() >= 4) {
            this.nama = nama;
        } else {
            System.out.println("Nama harus memiliki minimal 4 karakter.");
            this.nama = "Nama Invalid";
        }
    }

    public String getNama() {
        return nama;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public double hitungGaji() {
        return gajiPokok;
    }

    public void infoGaji() {
        System.out.println("Nama Karyawan  : " + nama);
        System.out.println("Perusahaan     : " + perusahaan.getNamaPerusahaan());
        System.out.println("Gaji Pokok     : " + Util.formatRupiah(gajiPokok));
        if (this instanceof Programmer) {
            System.out.println("Bonus          : " + Util.formatRupiah(((Programmer) this).getBonus()));
        } else if (this instanceof Manager) {
            System.out.println("Insentif       : " + Util.formatRupiah(((Manager) this).getInsentif()));
        }
        System.out.println("Total Gaji     : " + Util.formatRupiah(hitungGaji()));
        System.out.println("---------------------------");
    }
}

class Programmer extends Karyawan {
    private double bonus;

    public Programmer(String nama, double gajiPokok, Perusahaan perusahaan, double bonus) {
        super(nama, gajiPokok, perusahaan);
        this.bonus = bonus;
    }

    @Override
    public double hitungGaji() {
        return getGajiPokok() + bonus;
    }

    public double getBonus() {
        return bonus;
    }
}

class Manager extends Karyawan {
    private double insentif;

    public Manager(String nama, double gajiPokok, Perusahaan perusahaan, double insentif) {
        super(nama, gajiPokok, perusahaan);
        this.insentif = insentif;
    }

    @Override
    public double hitungGaji() {
        return getGajiPokok() + insentif;
    }

    public double getInsentif() {
        return insentif;
    }
}

class Util {
    public static String formatRupiah(double amount) {
        return "Rp" + String.format("%,.0f", amount).replace(",", ".");
    }
}