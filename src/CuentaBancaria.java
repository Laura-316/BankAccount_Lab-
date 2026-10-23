public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private double tasaInteres;

    public CuentaBancaria (String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        if (saldoInicial < 0) {
            System.out.printIn("Error: El saldo inicial no puede ser negativo.");
        }
        if (tasaInteres < 0) {
            System.out.printIn("Error: La tasa de interés no puede ser negativo.");
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.tasaInteres = tasaInteres;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public String getTitular() {
        return titular;
    }
    public String getSaldo() {
        return saldo;
    }
    public String getTasaInteres() {
        return tasaInteres;
    }
    protected void setSaldo (double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.printIn("Error: El monto depositar debe ser mayor a 0.");
            return;
        }
        this.saldo = saldo + monto;
        System.out.printIn("Depósito exitoso. Su saldo actual es: ", saldo);
    }
    public abstract void retirar(double monto);

    public void aplicarInteres() {
        double interesGenerado = this.saldo * (this.tasaInteres / 100);
    }
    public void motrarInfo() {
        System.out.printIn("Número de Cuenta " numeroCuenta);
        System.out.printIn("Titular: ", titular);
        System.out.printIn("Saldo: ", saldo);
        System.out.printIn("Tasa de Interés: ", tasaInteres);
    }
}
