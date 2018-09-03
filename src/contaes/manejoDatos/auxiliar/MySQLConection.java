package contaes.manejoDatos.auxiliar;

import contaes.Inicio;
import contaes.Puente;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConection
{
  private ResultSet res;
  private Connection con;
  private Statement sentencia;

  public MySQLConection()
  {
    try
    {
      this.con = DriverManager.getConnection("jdbc:mysql://" + Inicio.p.getDireccionIP() + "/contaes", Inicio.p.getUsuario(), Inicio.p.getPassword());

      this.sentencia = this.con.createStatement();
    } catch (SQLException exc) {
      System.out.println(exc.getMessage());
    }
  }

  public MySQLConection(int empresa)
  {
    try
    {
      this.con = DriverManager.getConnection("jdbc:mysql://" + Inicio.p.getDireccionIP() + "/contaes" + empresa, Inicio.p.getUsuario(), Inicio.p.getPassword());

      this.sentencia = this.con.createStatement();
    } catch (SQLException exc) {
      System.out.println(exc.getMessage());
    }
  }

  public void cierraConexion()
  {
    try
    {
      if (this.res != null) {
        this.res.close();
      }
      this.sentencia.close();
      this.con.close();
    } catch (SQLException exc) {
      System.out.println(exc.getMessage());
    }
  }

  public Statement getSentencia()
  {
    return this.sentencia;
  }

  public ResultSet getRes(String consulta)
    throws SQLException
  {
    this.res = this.sentencia.executeQuery(consulta);
    return this.res;
  }

  public Connection getCon()
  {
    return this.con;
  }
}

/* Location:           /media/sda1/contaes4/contaes4.jar
 * Qualified Name:     contaes.manejoDatos.auxiliar.MySQLConection
 * JD-Core Version:    0.6.2
 */