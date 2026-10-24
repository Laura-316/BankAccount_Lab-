public class TestBanco {
    public static void main(String[] args) { // Crear las cuentas
        CuentaAhorro ana = new CuentaAhorro("AH001", "Ana Perez", 50000.0, "2024-01-15");
        CuentaCorriente luis = new CuentaCorriente("CC001","Luis Gomez", 20000.0);
        CuentaEmpresarial tech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000.0, "Tech Solutions", "123456789-0");
        CuentaAhorro maria = new CuentaAhorro("AH002", "Maria Lopez", 15000.0, "2024-02-01");

        System.out.println("----- Mostrar la informacion inicial-----");
        ana.mostrarInfo();
        luis.mostrarInfo();
        tech.mostrarInfo();
        maria.mostrarInfo();

        System.out.println("----- Realizar las operaciones -----");
        System.out.println("Ana Perez deposita $10,000:");
        ana.depositar(10000.0);
        System.out.println("Luis Gomez retira $25,000:");
        luis.retirar(25000.0);
        System.out.println("Tech Solutions retira $10,000:");
        tech.retirar(10000.0);
        System.out.println("Maria Lopez intenta retirar $20,000:");
        maria.retirar(20000.0);

        System.out.println("----- Aplicar intereses -----");
        System.out.println("Cuenta de Ana Perez:");
        ana.aplicarInteres();
        System.out.println("Cuenta de Luis Gomez:" );
        luis.aplicarInteres();
        System.out.println("Cuenta de Tech Solutions:");
        tech.aplicarInteres();
        System.out.println("Cuenta de Maria Lopez:");
        maria.aplicarInteres();

        System.out.println("----- Mostrar el estado final -----");
        ana.mostrarInfo();
        luis.mostrarInfo();
        tech.mostrarInfo();
        maria.mostrarInfo();

        System.out.println("----- Generar un resumen -----");

        int totalCuentas = 4;
        double saldoTotal = ana.getSaldo() + luis.getSaldo() + tech.getSaldo() + maria.getSaldo();
        double promedioSaldo = saldoTotal / totalCuentas;

        System.out.println("Total de cuentas: " + totalCuentas);
        System.out.printf("Saldo total: $%.2f%n", saldoTotal);
        System.out.printf("Promedio de saldo: $%.2f%n", promedioSaldo);

        CuentaBancaria cuentaMayor = ana;

        if (luis.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = luis;
        }
        if (tech.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = tech;
        }
        if (maria.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = maria;
        }

        System.out.println("Cuenta con el mayor saldo:");

        System.out.println("Número de cuenta: " + cuentaMayor.getNumeroCuenta());
        System.out.println("Titular: " + cuentaMayor.getTitular());
        System.out.printf("Saldo: $%.2f%n", cuentaMayor.getSaldo());
    }
}