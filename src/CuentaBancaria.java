public abstract class CuentaBancaria { // Se define una clase abstracta.
    private String numeroCuenta; // Atributo privado de la clase CuentaBancaria Private (encapsulación)
    private String titular; // Atributo privado de la clase CuentaBancaria Private (encapsulación)
    private double saldo; // Atributo privado de la clase CuentaBancaria Private (encapsulación)
    private double tasaInteres; // Atributo privado de la clase CuentaBancaria Private (encapsulación)

    // Contructor de la clase, recibe los datos necesarios para inicializar una cuenta.
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        // Validaciones requeridas
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        // Asiganamos los valores recibidos por parámetro a los atributos
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.tasaInteres = tasaInteres;
    }
    // Métodos Getters
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
    // Método para actualizar el saldo
    protected void actualizarSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }
    // Método depositar - valida que el monto sea mayor a 0.
    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a depositar debe ser positivo.");
            return;
        }
        this.saldo += monto;
        System.out.printf("Depósito exitoso. Monto: $%.2f%n", monto);
        System.out.printf("Nuevo saldo: $%.2f%n", this.saldo);
    }
    // Método abstracto que implementará cada subclase
    public abstract void retirar(double monto);
    // Calcula el interes y se lo suma al saldo
    public void aplicarInteres() {
        double interesGenerado = this.saldo * (this.tasaInteres / 100);
        this.saldo += interesGenerado;
        System.out.printf("Interés generado para la cuenta %s: $%.2f%n", numeroCuenta, interesGenerado);
        System.out.printf("Saldo actual: $%.2f%n", saldo);
    }

    public void mostrarInfo() {
        System.out.println("----------------------------------------");
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo: $%.2f%n", saldo);
        System.out.printf("Tasa de Interés: %.2f%%%n", tasaInteres);
    }
}