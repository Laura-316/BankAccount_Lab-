public class TestBanco {
    public static void main(String[] args) {
        CuentaAhorro ana = new CuentaAhorro("AH001", "Ana Perez", 50000.0, "2024-01-15");
        CuentaCorriente luis = new CuentaCorriente("CC001","Luis Gomez", 20000 );
        CuentaEmpresarial tech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000.0, "Tech Solutions", "123456789-0");
        CuentaAhorro maria = new CuentaAhorro("AH002", "Maria Lopez", 15000.0, "2024-02-01");

        System.out.println("Informacion inicial");
        ana.mostrarInfo();
        luis.mostrarInfo();
        tech.mostrarInfo();
        maria.mostrarInfo();


        System.out.println("¡Las 4 cuentas se han creado exitosamente!");
        System.out.println(" Ana Perez deposita $10,000:");
        ana.depositar(10000.0);
        System.out.println(" Luis Gomez retira $25,000:");
        luis.retirar(25000.0);
        System.out.println(" Tech Solutions retira $10,000:");
        tech.retirar(10000.0);
        System.out.println(" Maria Lopez intenta retirar $20,000:");
        maria.retirar(20000.0);

        ana.aplicarInteres();
        luis.aplicarInteres();
        tech.aplicarInteres();
        maria.aplicarInteres();

        System.out.println("estado final");
        ana.mostrarInfo();
        luis.mostrarInfo();
        tech.mostrarInfo();
        maria.mostrarInfo();

        System.out.println("\n--- PASO 6: GENERAR UN RESUMEN ---");


        int totalCuentas = 4;
        double saldoTotal = ana.getSaldo() + luis.getSaldo() + tech.getSaldo() + maria.getSaldo();
        double promedioSaldo = saldoTotal / totalCuentas;



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

        System.out.println(" - Número de cuenta: " + cuentaMayor.getNumeroCuenta());
        System.out.println(" - Titular: " + cuentaMayor.getTitular());
        System.out.println(" - Saldo: $" + String.format("%.2f", cuentaMayor.getSaldo()));
    }



}