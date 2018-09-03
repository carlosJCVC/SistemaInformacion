package contaes;

public class Puente
{
  private int asiento;
  private int control;
  private int empresa;
  private String prefijo;
  private String cuentaStr;
  private String factura;
  private String usuario;
  private String password;
  private String direccionIP;
  private String ejercicio;
  private String facturacion;
  private boolean modoPOS;
  private boolean registro;

  public Puente()
  {
     this.control = 0;

     this.asiento = 0;
     this.empresa = 1;
     this.usuario = "";
     this.password = "";
     this.direccionIP = "";
     this.ejercicio = "";
     this.cuentaStr = "";
     this.factura = "NEW";
     this.prefijo = "";
     this.facturacion = "";
     this.modoPOS = false;
     this.registro = false;
  }

  public int getAsiento()
  {
     return this.asiento;
  }

  public void setAsiento(int asiento)
  {
     this.asiento = asiento;
  }

  public int getControl()
  {
     return this.control;
  }

  public void setControl(int control)
  {
     this.control = control;
  }

  public String getCuentaStr()
  {
     return this.cuentaStr;
  }

  public void setCuentaStr(String cuentaStr)
  {
     this.cuentaStr = cuentaStr;
  }

  public String getEjercicio()
  {
     return this.ejercicio;
  }

  public void setEjercicio(String ejercicio)
  {
     this.ejercicio = ejercicio;
  }

  public int getEmpresa()
  {
     return this.empresa;
  }

  public void setEmpresa(int empresa)
  {
     this.empresa = empresa;
  }

  public String getFactura()
  {
     return this.factura;
  }

  public void setFactura(String factura)
  {
     this.factura = factura;
  }

  public String getPassword()
  {
     return this.password;
  }

  public void setPassword(String password)
  {
     this.password = password;
  }

  public String getDireccionIP() {
     return this.direccionIP;
  }

  public void setDireccionIP(String direccionIP) {
     this.direccionIP = direccionIP;
  }

  public String getPrefijo()
  {
     return this.prefijo;
  }

  public void setPrefijo(String prefijo)
  {
     this.prefijo = prefijo;
  }

  public String getUsuario()
  {
     return this.usuario;
  }

  public void setUsuario(String usuario)
  {
     this.usuario = usuario;
  }

  public String getFacturacion() {
     return this.facturacion;
  }

  public void setFacturacion(String facturacion) {
     this.facturacion = facturacion;
  }

  public boolean isModoPOS() {
     return this.modoPOS;
  }

  public void setModoPOS(boolean modoPOS) {
     this.modoPOS = modoPOS;
  }

  public boolean isRegistro() {
     return this.registro;
  }

  public void setRegistro(boolean registro) {
     this.registro = registro;
  }
}

/*Location:        		/media/sda1/contaes4/contaes4.jar
 * Qualified Name:     contaes.Puente
 * JD-Core Version:    0.6.2
 */