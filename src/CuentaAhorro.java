public class CuentaAhorro extends CuentaBancaria {
    private String fechaApertura;

    private static final double TASA_FIJA_AHORRO = 2.5;
    private static final double SALDO_MINIMO_ABRIR = 10000.0;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, String fechaApertura) {
        super(numeroCuenta, titular, saldoInicial, TASA_FIJA_AHORRO);
        if (saldoInicial < SALDO_MINIMO_ABRIR) {
            System.out.println("Error: El saldo inicial para abrir la Cuenta de Ahorro debe ser de al menos $10,000.");
        }
        this.fechaApertura = fechaApertura;
    }
    public String getFechaApertura() {
        return fechaApertura;
    }
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser mayor a 0.");
            return;
        }
        if (monto > getSaldo()) {
            System.out.println("Error: Saldo insuficiente en la Cuenta de Ahorro para realizar el retiro.");
        } else {
            setSaldo(getSaldo() - monto);
            System.out.println("Retiro exitoso. Nuevo saldo: $" + getSaldo());
        }
    }
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Fecha de Apertura: " + fechaApertura);
        System.out.println("Tipo de cuenta: Cuenta de Ahorro");
    }
}
