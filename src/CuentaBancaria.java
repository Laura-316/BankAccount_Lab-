public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private double tasaInteres;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        if (saldoInicial < 0) {
            System.out.println("Error: El saldo inicial no puede ser negativo.");
        }
        if (tasaInteres < 0) {
            System.out.println("Error: La tasa de interés no puede ser negativa.");
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

    public double getTasaInteres() {
        return tasaInteres;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a depositar debe ser mayor a 0.");
            return;
        }
        this.saldo += monto;
        System.out.println("Depósito exitoso. Su saldo actual es: " + this.saldo);
    }
    public abstract void retirar(double monto);

    public void aplicarInteres() {
        double interesGenerado = this.saldo * (this.tasaInteres / 100);
        this.saldo += interesGenerado;
        System.out.println("Interés generado: " + interesGenerado + " | Nuevo saldo: " + this.saldo);
    }

    public void mostrarInfo() {
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
        System.out.println("Tasa de Interés: " + tasaInteres + "%");
    }
}