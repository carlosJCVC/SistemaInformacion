 package contaes;
 
 import com.nilo.plaf.nimrod.NimRODLookAndFeel;
 import com.nilo.plaf.nimrod.NimRODTheme;
 import contaes.dialogosAuxiliares.DonacionesJDialog;
 import contaes.dialogosFunciones.Calculadora;
 import contaes.empresas.UsuariosJDialog;
 import contaes.manejoDatos.auxiliar.ConfiguracionBean;
 import contaes.manejoDatos.auxiliar.Registro;
 import contaes.manejoDatos.funciones.BuildPlanTree;
 import internationalization.Mensajes;
 import java.awt.Color;
 import java.awt.Frame;
 import java.io.PrintStream;
 import java.util.ArrayList;
import java.util.Arrays;
 import java.util.Properties;
 import java.util.concurrent.ExecutorService;
 import java.util.concurrent.Executors;
 import javax.swing.JFrame;
 import javax.swing.JOptionPane;
 import javax.swing.JTree;
 import javax.swing.SwingUtilities;
 import javax.swing.UIManager;
 import javax.swing.UnsupportedLookAndFeelException;
 
 public class Inicio
 {
   public static Puente p = new Puente();
   public static MarcoInicio frame;
   public static Calculadora calculadora;
   public static JTree arbolPC;
   private static contaes.manejoDatos.auxiliar.MySQLConection cEmpresa = null;
   private static contaes.manejoDatos.auxiliar.MySQLConection cFacturacion = null;
   private static contaes.manejoDatos.auxiliar.MySQLConection cGeneral = null;
   private static almacen2.data.MySQLConection cAlmacen = null;
 
   public Inicio(boolean POS)
   {
     try
     {
       Class.forName("com.mysql.jdbc.Driver");
     } catch (ClassNotFoundException exc) {
       JOptionPane.showMessageDialog(new JFrame(), "¡Error al registrar el controlador para MySQL!", "Error", 0);
 
       System.exit(1);
     }
 
     p.setModoPOS(POS);
 
     System.setProperty("apple.laf.useScreenMenuBar", "false");
 
     UsuariosJDialog.seleccionDeUsuario(POS);
     comprobarInstalacion();
 
     cGeneral = new contaes.manejoDatos.auxiliar.MySQLConection();
     cAlmacen = new almacen2.data.MySQLConection();
     crearArbolPGC();
     checkVersion();
     p.setRegistro(Registro.isRegistrado());
     frame = new MarcoInicio();
     calculadora = new Calculadora();
     calculadora.validate();
     frame.validate();
     frame.setVisible(true);
     frame.colocarInfo();
   }
 
   private void comprobarInstalacion()
   {
     Instalar instalacion = new Instalar();
     int retorno = instalacion.yaInstalado();
     if ((retorno != 1) && (retorno != -2)) {
       int confirma = JOptionPane.showConfirmDialog(new Frame(), Mensajes.getString("instala1"), Mensajes.getString("instala2"), 0);
 
       if (confirma == 0) {
         if (!instalacion.instalacion()) {
           JOptionPane.showMessageDialog(new Frame(), Mensajes.getString("instala4"));
 
           System.exit(0);
         }
         DonacionesJDialog.recordarDonaciones();
       }
     } else if (retorno == -2) {
       JOptionPane.showMessageDialog(new Frame(), Mensajes.getString("errorSQLGeneral") + "\n" + instalacion.getError());
 
       System.exit(0);
     }
   }
 
   private void checkVersion()
   {
     String actualVersion = "2.5";
     ArrayList array = new ArrayList();
     ConfiguracionBean config = new ConfiguracionBean();
     array = config.getConfig("<version>");
     if (array.isEmpty()) {
       array.add(actualVersion);
       config.saveConfig("<version>", array);
     }
     else {
       String anteriorVersion = (String)array.get(0);
       if (!((String)array.get(0)).equals(actualVersion))
       {
         array.clear();
         array.add(actualVersion);
         config.saveConfig("<version>", array);
       }
 
       if (anteriorVersion.equals("2.1")) {
         Instalar instalacion = new Instalar();
         instalacion.de21a22();
       }
       if ((anteriorVersion.equals("2.0")) || (anteriorVersion.equals("2.1")) || (anteriorVersion.equals("2.2")) || (anteriorVersion.equals("2.3")) || (anteriorVersion.equals("2.4")))
       {
         Instalar instalacion = new Instalar();
         instalacion.de24a241();
       }
       if ((anteriorVersion.equals("2.0")) || (anteriorVersion.equals("2.1")) || (anteriorVersion.equals("2.2")) || (anteriorVersion.equals("2.3")) || (anteriorVersion.equals("2.4")) || (anteriorVersion.equals("2.4.1")))
       {
         Instalar instalacion = new Instalar();
         instalacion.de241a242();
       }
       if ((anteriorVersion.equals("2.0")) || (anteriorVersion.equals("2.1")) || (anteriorVersion.equals("2.2")) || (anteriorVersion.equals("2.3")) || (anteriorVersion.equals("2.4")) || (anteriorVersion.equals("2.4.1")) || (anteriorVersion.equals("2.4.2")) || (anteriorVersion.equals("2.4.3")) || (anteriorVersion.equals("2.4.4")))
       {
         Instalar instalacion = new Instalar();
         instalacion.de244a245();
       }
     }
   }
 
   public static contaes.manejoDatos.auxiliar.MySQLConection getCEmpresa()
   {
     return cEmpresa;
   }
 
   public static void setCEmpresa(int empresa) {
     if (cEmpresa != null) {
       cEmpresa.cierraConexion();
     }
     cEmpresa = new contaes.manejoDatos.auxiliar.MySQLConection(empresa);
   }
 
   public static contaes.manejoDatos.auxiliar.MySQLConection getCFacturacion() {
     return cFacturacion;
   }
 
   public static void setCFacturacion(int empresa) {
     if (cFacturacion != null) {
       cFacturacion.cierraConexion();
     }
     cFacturacion = new contaes.manejoDatos.auxiliar.MySQLConection(empresa);
   }
 
   public static contaes.manejoDatos.auxiliar.MySQLConection getCGeneral() {
     return cGeneral;
   }
 
   public static almacen2.data.MySQLConection getcAlmacen() {
     return cAlmacen;
   }
 
   public static JTree getArbolPGC() {
     return arbolPC;
   }
 
   private void crearArbolPGC() {
     ExecutorService exec = Executors.newSingleThreadExecutor();
     exec.execute(new TreeCreator());
     exec.shutdown();
   }
 
   
   // Esta funcion main es la que inicia todo el sistema
   
   public static void main(String[] args)
   {
       final String[] opcion = args;
       SwingUtilities.invokeLater(new Runnable(){
           public void run() {
                boolean POS = false;
                int n = opcion.length;
                if ((n > 0) && (opcion[0].equals("POS"))) {
                    POS = true;
                }
                
                try {
                    Properties sistema = System.getProperties();
                    String sisOp = sistema.getProperty("os.name").substring(0, 3);
                    if (sisOp.equals("Lin")) {
                        NimRODTheme nt = new NimRODTheme();
                        nt.setSecondary3(new Color(226, 216, 207));

                        nt.setPrimary2(new Color(156, 100, 77));
                        nt.setPrimary3(new Color(189, 189, 189));
                        NimRODLookAndFeel NimRODLF = new NimRODLookAndFeel();
                        NimRODLookAndFeel.setCurrentTheme(nt);
                        //JFrame.setDefaultLookAndFeelDecorated(true);

                        //aki iba NimRODLF
                        //     UIManager.setLookAndFeel(NimRODLF);
                        UIManager.setLookAndFeel(UIManager.getDefaults().toString());
                        // UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    } else {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    }
                } catch (ClassNotFoundException exc1) {
                  System.out.println(exc1.getMessage());
                } catch (InstantiationException exc2) {
                  System.out.println(exc2.getMessage());
                } catch (IllegalAccessException exc3) {
                  System.out.println(exc3.getMessage());
                } catch (UnsupportedLookAndFeelException exc4) {
                  System.out.println(exc4.getMessage());
                }
                
                new Inicio(POS);
            } 
       });
   }
 
   class TreeCreator implements Runnable {
     TreeCreator() {
     }
 
     public void run() { 
         Inicio.arbolPC = new BuildPlanTree().getArbol();
     }
 
   }
 }

/*/media/sda1/contaes4/contaes4.jar
 * Qualified Name:     contaes.Inicio
 * JD-Core Version:    0.6.2
 */