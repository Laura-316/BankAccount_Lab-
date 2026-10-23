public class CuentaEmpresarial extends CuentaBancaria {
    private String nombreEmpresa;
    private String rut;
    private double comisionRetiro;

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, String rut) {
        super(numeroCuenta, titular, saldoInicial, 1.5); // Tasa de interés fija 1.5%
        if (saldoInicial < 100000) {
            throw new IllegalArgumentException("Error: El saldo mínimo para abrir una Cuenta Empresarial es de $100,000.");
        }
        this.nombreEmpresa = nombreEmpresa;
        this.rut = rut;
        this.comisionRetiro = 2000.0; // Valor por defecto
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getRut() {
        return rut;
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
        } else {
            setSaldo(getSaldo() - monto);
            setSaldo(getSaldo() - comisionRetiro);
            System.out.printf("Retiro exitoso de $%.2f.%n", monto);
            System.out.printf("Comisión por retiro: $%.2f%n", comisionRetiro);
            System.out.printf("Nuevo saldo: $%.2f%n", getSaldo());
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo de Cuenta: Cuenta Empresarial");
        System.out.println("Nombre de la Empresa: " + nombreEmpresa);
        System.out.println("RUT: " + rut);
        System.out.printf("Comisión por Retiro: $%.2f%n", comisionRetiro);
        System.out.println("----------------------------------------");
    }
}