public class CuentaAhorro extends CuentaBancaria {
    private String fechaApertura; // Atributo privado de la clase CuentaAhorro Private (encapsulación)

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, String fechaApertura) {
        super(numeroCuenta, titular, saldoInicial, 2.5);
        // Valida la regla de negocio del saldo mínimo de apertura ($10,000)
        if (saldoInicial < 10000) {
            throw new IllegalArgumentException("El saldo mínimo para abrir una Cuenta de Ahorro es de $10,000.");
        }
        this.fechaApertura = fechaApertura;
    }
    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser mayor a 0.");
            return;
        }
        if (monto > getSaldo()) {
            System.out.println("Error: Saldo insuficiente en la Cuenta de Ahorro para realizar el retiro.");
            return;
        }
        actualizarSaldo(getSaldo() - monto);
        System.out.println("Retiro exitoso.");
        System.out.printf("Nuevo saldo: $%.2f%n", getSaldo());
    }
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo de cuenta: Cuenta de Ahorro");
        System.out.println("Fecha de Apertura: " + fechaApertura);
    }
}