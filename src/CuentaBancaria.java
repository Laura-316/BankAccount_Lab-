public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private double tasaInteres;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
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

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a depositar debe ser positivo.");
            return;
        }
        this.saldo += monto;
        System.out.printf("Depósito exitoso. Monto: $%.2f. Nuevo saldo: $%.2f%n", monto, this.saldo);
    }

    // Método abstracto que implementará cada subclase
    public abstract void retirar(double monto);

    public void aplicarInteres() {
        double interesGenerado = this.saldo * (this.tasaInteres / 100);
        this.saldo += interesGenerado;
        System.out.printf("Interés generado para la cuenta %s: $%.2f. Saldo actual: $%.2f%n",
                numeroCuenta, interesGenerado, this.saldo);
    }

    public void mostrarInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo: $%.2f%n", saldo);
        System.out.printf("Tasa de Interés: %.2f%%%n", tasaInteres);
    }
}