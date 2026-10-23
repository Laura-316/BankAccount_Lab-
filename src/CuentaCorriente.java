public class CuentaCorriente extends CuentaBancaria {

    private double limiteSobregiro;
    private double porcentajeComisionSobregiro;

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
        if (monto <= (getSaldo() + limiteSobregiro)) {
            double nuevoSaldo = getSaldo() - monto;
            double comision = 0.0;

            if (nuevoSaldo < 0) {
                double montoSobregirado = Math.abs(nuevoSaldo);
                comision = montoSobregirado * (porcentajeComisionSobregiro / 100.0);
                nuevoSaldo -= comision;

                System.out.println("Retiro exitoso.");
                System.out.println("Comisión por sobregiro: $" + String.format("%.2f", comision));
            } else {
                System.out.println("Retiro exitoso.");
            }

            setSaldo(nuevoSaldo);
            System.out.println("Nuevo saldo: $" + String.format("%.2f", getSaldo()));
        } else {
            System.out.println("Error: Saldo insuficiente. El monto supera el saldo disponible y el límite de sobregiro.");
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo(); // Asegúrate de que en CuentaBancaria este método se llame mostrarInfo (con 's')
        System.out.println("Límite de Sobregiro: $" + String.format("%.2f", limiteSobregiro));
        System.out.println("Porcentaje de Comisión por Sobregiro: " + porcentajeComisionSobregiro + "%");
    }
}