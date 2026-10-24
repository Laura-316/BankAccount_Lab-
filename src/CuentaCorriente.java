public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro; // Atributo privado de la clase CuentaCorriente Private (encapsulación)
    private double porcentajeComisionSobregiro; // Atributo privado de la clase CuentaCorriente Private (encapsulación)

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double limiteSobregiro, double porcentajeComisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial, 0.0);
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
    }

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, 50000.0, 5.0);
    }
    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser positivo.");
            return;
        }
        if (monto > getSaldo() + limiteSobregiro) {
            System.out.println("Error: El monto supera el límite de sobregiro.");
            return;
        }
        double nuevoSaldo = getSaldo() - monto;
        double comision = 0;

        if (nuevoSaldo < 0) {
            double montoSobregirado = Math.abs(nuevoSaldo);
            comision = montoSobregirado * (porcentajeComisionSobregiro / 100.0);
            nuevoSaldo -= comision;
        }
        actualizarSaldo(nuevoSaldo);

        System.out.println("Retiro exitoso.");

        if (comision > 0) {
            System.out.printf("Comisión por sobregiro: $%.2f%n", comision);
        }
        System.out.printf("Nuevo saldo: $%.2f%n", getSaldo());
    }
        // Mostrar información de la cuenta
        @Override
        public void mostrarInfo() {
            super.mostrarInfo();
            System.out.printf("Límite de sobregiro: $%.2f%n", limiteSobregiro);
            System.out.printf("Porcentaje de comisión por sobregiro: %.2f%%%n", porcentajeComisionSobregiro);
        }
    }