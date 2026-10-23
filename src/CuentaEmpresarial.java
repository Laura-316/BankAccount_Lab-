public class CuentaEmpresarial extends CuentaBancaria {
    private String nombreEmpresa;
    private String rut;
    private double comisionRetiro;

    public CuentaEmpresarial (String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, tring rut) {
        super(numeroCuenta, titular, saldoInicial, 1.5);
        if (saldoInicial < 100000) {
            System.out.printIn("Error: El saldo minimo para abrir una Cuenta Empresarial es de $100.000.");
        }

    }
}
