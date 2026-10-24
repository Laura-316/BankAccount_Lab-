public class CuentaEmpresarial extends CuentaBancaria {
    private String nombreEmpresa; // Atributo privado de la clase CuentaEmpresarial Private (encapsulación)
    private String RUT; // Atributo privado de la clase CuentaEmpresarial Private (encapsulación)
    private double comisionRetiro; // Atributo privado de la clase CuentaEmpresarial Private (encapsulación)

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, String RUT) {
        super(numeroCuenta, titular, saldoInicial, 1.5);
        if (saldoInicial < 100000) {
            throw new IllegalArgumentException("El saldo mínimo para abrir una Cuenta Empresarial es de $100,000.");
        }
        this.nombreEmpresa = nombreEmpresa;
        this.RUT = RUT;
        this.comisionRetiro = 2000.0; // Valor por defecto
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getRUT() {
        return RUT;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser positivo.");
            return;
        }

        // Verificar que monto + comisión no supere el saldo disponible
        if ((monto + comisionRetiro) > getSaldo()) {
            System.out.println("Error: Saldo insuficiente para cubrir el retiro y la comisión de $" + comisionRetiro);
            return;
        }
        double nuevoSaldo = getSaldo() - monto - comisionRetiro;
        actualizarSaldo(nuevoSaldo);

        System.out.printf("Retiro exitoso: $%.2f%n", monto);
        System.out.printf("Comisión por retiro: $%.2f%n", comisionRetiro);
        System.out.printf("Nuevo saldo: $%.2f%n", getSaldo());
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo de Cuenta: Cuenta Empresarial");
        System.out.println("Nombre de la Empresa: " + nombreEmpresa);
        System.out.println("RUT: " + RUT);
        System.out.printf("Comisión por Retiro: $%.2f%n", comisionRetiro);
    }
}