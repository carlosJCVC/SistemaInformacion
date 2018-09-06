package contaes;

import almacen2.gui.BuscarRefOldJDialog;
import almacen2.gui.ListarProductosOldJInternalFrame;
import almacen2.gui.OldAlmacenJInternalFrame;
import contaes.asientosModelo.Lista;
import contaes.auxiliar.ImageJDesktopPane;
import contaes.auxiliar.MyDefaultDesktopManager;
import contaes.cuentas.ComparativaCuentasDlg;
import contaes.cuentas.ComparativaSaldosDlg;
import contaes.cuentas.MarcoParaGraficos;
import contaes.cuentas.Sustitucion;
import contaes.dialogosAuxiliares.BackupProgramPathJDialog;
import contaes.dialogosFunciones.AperturaEjercicio;
import contaes.dialogosFunciones.BorrarVencimientos;
import contaes.dialogosFunciones.BuscarDescuadres;
import contaes.dialogosFunciones.Calculadora;
import contaes.dialogosFunciones.CierreEjercicio;
import contaes.dialogosFunciones.ComprobarVencimientos;
import contaes.dialogosFunciones.ComprobarVencimientosCobrar;
import contaes.dialogosFunciones.CrearFicheroCSB;
import contaes.dialogosFunciones.FormasPago;
import contaes.dialogosFunciones.LiquidacionIVA;
import contaes.dialogosFunciones.Paises;
import contaes.dialogosFunciones.PerdidasGanancias;
import contaes.dialogosFunciones.RegenerarSaldosSubcuentas;
import contaes.dialogosFunciones.RegularizacionExistencias;
import contaes.dialogosFunciones.Reordenar;
import contaes.dialogosFunciones.ReordenarDiario;
import contaes.dialogosFunciones.TraspasarAsientos;
import contaes.empresas.AboutBox;
import contaes.empresas.CreaEjercicio;
import contaes.empresas.GestionaEmpresas;
import contaes.empresas.LastSelectedEmpresa;
import contaes.empresas.SeleccionEmpresa;
import contaes.empresas.UsuariosJDialog;
import contaes.informes.view.ContrapartidasJDialog;
import contaes.informes.view.DistribucionPartidasJDialog;
import contaes.informes.view.RatiosJDialog;
import contaes.informes.view.ResumenFacturasJDialog;
import contaes.listados.Balance;
import contaes.listados.Balance08;
import contaes.listados.CuentaPyG;
import contaes.listados.CuentaPyG08;
import contaes.listados.ECPN;
import contaes.listados.LiquidacionFiscalIVA;
import contaes.listados.Listado;
import contaes.listados.ListadoFacturas;
import contaes.listados.ListadoNiveles;
import contaes.listados.OperacionesTerceros;
import contaes.manejoDatos.CheckVersionInWeb;
import contaes.manejoDatos.ManejoEmpresas;
import contaes.manejoDatos.auxiliar.ConfiguracionBean;
import contaes.manejoDatos.auxiliar.DataBasesBackup;
import contaes.manejoDatos.funciones.ImportarDiario;
import contaes.manejoDatos.funciones.ImportarSubcuentas;
import internationalization.Mensajes;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import pos.view.MediosPagoJDialog;
import pos.view.VendedoresJDialog;

public class MarcoInicio extends JFrame implements ActionListener
{
  boolean firstStart = true;
  private static final String SELECCIONAREMPRESA = "selempresa";
  private static final String GESTIONEMPRESAS = "gesempresas";
  private static final String ABRIREJERCICIO = "abrirejercicio";
  private static final String BORRAREJERCICIO = "borrarejercicio";
  private static final String GESTIONUSUARIOS = "gestionusuarios";
  private static final String DESINSTALAR = "desinstalar";
  private static final String SALIR = "salir";
  private static final String ASIENTOS = "asientos";
  private static final String ASIENTOSAUT = "asientosaut";
  private static final String CONSULTASDIARIO = "consultasdiario";
  private static final String CONCEPTOS = "conceptos";
  private static final String REGENERARSALDOS = "regenerarsaldos";
  private static final String DESCUADRES = "descuadres";
  private static final String RENUMERAR = "renumerar";
  private static final String INTROFACTURAS = "facturas";
  private static final String GESTIONEMITIDAS = "gestionEmitidas";
  private static final String GESTIONRECIBIDAS = "gestionRecibidas";
  private static final String LISTAEMITIDAS = "emitidas";
  private static final String LISTARECIBIDAS = "recibidas";
  private static final String VENCIMIENTOS = "vencimientos";
  private static final String COMPVENCIMIENTOS = "comprobarVencimientos";
  private static final String ELIMVENCIMIENTOS = "eliminarVencimientos";
  private static final String VENCIMIENTOSCOBRAR = "vencimientoscobrar";
  private static final String COMPVENCIMIENTOSCOBRAR = "comprobarVencimientosCobrar";
  private static final String ELIMVENCIMIENTOSCOBRAR = "eliminarVencimientosCobrar";
  private static final String GESTIONCUENTAS = "cuentas";
  private static final String BALNIVELES = "niveles";
  private static final String PYG = "pyg";
  private static final String BALANCE = "balance";
  private static final String PYG07 = "pyg07";
  private static final String BALANCE07 = "balance07";
  private static final String ECPN = "ecpn";
  private static final String REGULASTOCK = "stocks";
  private static final String ASIENTOPYG = "asientoPyG";
  private static final String APERTURA = "apertura";
  private static final String CIERRE = "cierre";
  private static final String LIQUIDAIVA = "liquidacioniva";
  private static final String LIQUIDAFISCALIVA = "liquidacionfiscaliva";
  private static final String AYUDA = "ayuda";
  private static final String INFO = "info";
  private static final String GRAFICOSCUENTAS = "graficoscuentas";
  private static final String GRAFICOSSALDOS = "graficossaldos";
  private static final String SUSTITUCION = "sustitucion";
  private static final String CALCULADORA = "calculadora";
  private static final String OPTERCEROS = "operacionesTerceros";
  private static final String CERRARTODO = "cerrartodo";
  private static final String TIPOSIVA = "tiposIVA";
  private static final String TRASPASAR = "traspasarAsientos";
  private static final String FORMASPAGO = "formasPago";
  private static final String IMPORTAR = "ImportarFacturas";
  private static final String PRODUCTOS = "productos";
  private static final String GESTIONFACTURACION = "gestionfacturas";
  private static final String INTROFACTURACION = "introduccionfacturas";
  private static final String GESTIONFACTURACIONPROV = "gestionfacturasrecibidas";
  private static final String INTROFACTURACIONPROV = "introduccionfacturasrecibidas";
  private static final String PEDIDOSPROVEEDORES = "pedidosproveedores";
  private static final String PEDIDOSCLIENTES = "pedidosclientes";
  private static final String LISTADOSALMACEN = "listadosalmacen";
  private static final String RESUMENMENSUALCLIENTES = "resumenclientes";
  private static final String RESUMENMENSUALPROVEEDORES = "resumenproveedores";
  private static final String DISTRIBUCIONPARTIDAS = "distribucionpartidas";
  private static final String ORIGENESDESTINOS = "origenesDestinos";
  private static final String RATIOS = "ratios";
  private static final String ALMACENES = "almacenes";
  private static final String MEDIOSPAGO = "mediospago";
  private static final String VENDEDORES = "vendedores";
  private static final String TERMINALVENTAS = "terminalventas";
  private static final String RESUMENDIARIO = "resumendiario";
  private static final String PAISES = "paises";
  private static final String WEB = "web";
  private static final String UPDATES = "updates";
  private static final String ISUPDATE = "isupdate";
  private static final String CSB19 = "CSB19";
  private static final String CSB58 = "CSB58";
  private static final String BACKPROGRAMPATH = "backprogrampath";
  private static final String MAKEBACKUP = "makebackup";
  private static final String RESTOREBACKUP = "restorebackup";
  private static final String TPVTOFACT = "tpvtofact";
  private static final String RENUMERARFACTURACION = "renumerarfacturacion";
  private static final String RENUMERARTICKETS = "renumerartickets";
  private static final String TRASPASARFACTURASVENTAS = "traspasarfacturasventas";
  private static final String TRASPASARFACTURASCOMPRAS = "traspasarfacturascompras";
  private static final String IMPORTARSUBCUENTAS = "importarsubcuentas";
  private static final String IMPORTARDIARIO = "importardiaro";
  private static final String CONTROLCENTRE = "controlcentre";
  private static final String REGISTRO = "registro";
  
  BorderLayout bLayout = new BorderLayout();
  ImageJDesktopPane escritorio = new ImageJDesktopPane();
  JMenuBar barraMenu = new JMenuBar();

  JToolBar herramientasPOS = new JToolBar();
  PanelMenuJPanel panelMenu = new PanelMenuJPanel();

  JButton terminalPOS = null;
  JButton resumenPOS = null;
  JButton salirPOS = null;
  //TablaDiario marco_tDiario = null;
  Lista marco_Asientos_Modelo = null;
  CreacionFacturas marco_CreacionFacturas = null;
  
  InfoJInternalFrame marco_info = null;
  ControlCentreJInternalFrame centroControl = null;
  String titulo = "Titulo del proyecto  - ";

  public MarcoInicio() {
    try {
      setDefaultCloseOperation(3);
      initialize();
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  private void initialize() throws Exception {
    addWindowListener(new CierreVentana());
    Rectangle bounds = readFrameBounds();
    setPanelMenuState();
    if (bounds == null) {
      int inset = 20;
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int ancho = screenSize.width < 940 ? screenSize.width : 1004;
      int alto = screenSize.height < 700 ? screenSize.height : 710;
      setBounds(inset, inset, ancho, alto);
    } else {
      setBounds(bounds);
    }
    setTitle(this.titulo);
    URL icono = MarcoInicio.class.getResource("/contaes/iconos/maxifarm.jpg");
    if (icono != null) {
      setIconImage(Toolkit.getDefaultToolkit().getImage(icono));
    }
    getContentPane().setLayout(this.bLayout);
    this.escritorio.setDesktopManager(new MyDefaultDesktopManager());
    URL fondo = MarcoInicio.class.getResource("/contaes/iconos/farma.png");
    this.escritorio.setImage(new ImageIcon(fondo));
    this.escritorio.setFillEntireArea(true);
    getContentPane().add(this.escritorio, "Center");

    addComponentListener(new ComponentAdapter()
    {
      public void componentResized(ComponentEvent e)
      {
        MarcoInicio.this.colocarInfo();
      }
    });
    while (this.firstStart) {
      if (hayEmpresas()) {
        LastSelectedEmpresa lastSelected = new LastSelectedEmpresa();
        if (lastSelected.isCreated()) {
          setTitle(this.titulo + lastSelected.getNombreEmpresa() + " - " + Inicio.p.getEjercicio());
          colocarInfo(lastSelected.getNombreEmpresa());
          this.firstStart = false;
        } else {
          seleccionarEmpresa();
        }
      } else {
        GestionaEmpresas dlg = new GestionaEmpresas(this, Mensajes.getString("gesEmp"), true);
        mostrarDialogo(dlg);
        if (hayEmpresas()) {
          CreaEjercicio dlg2 = new CreaEjercicio(this, Mensajes.getString("creaEj"), true);
          mostrarDialogo(dlg2);
          saveFirstStart();
          seleccionarEmpresa();
          }
        else {
          System.exit(0);
        }
      }
    }

    if (Inicio.p.isModoPOS()) {
      setExtendedState(6);
      setUndecorated(true);
      this.herramientasPOS.setRollover(true);
      this.herramientasPOS.setBorder(BorderFactory.createEtchedBorder(1));
      addBotonesPOS(this.herramientasPOS);
      getContentPane().add(this.herramientasPOS, "First");
      realizarAccion("terminalventas");
    }
    else
    {
      getContentPane().add(this.panelMenu, "West");

      crearMenu(this.barraMenu);
      setJMenuBar(this.barraMenu);
    }
  }

  private void saveFirstStart()
  {
    ArrayList array = new ArrayList();
    GregorianCalendar fecha = new GregorianCalendar();
    fecha.add(2, 1);
    array.add("" + fecha.get(1));
    array.add("" + fecha.get(2));
    array.add("" + fecha.get(5));
    ConfiguracionBean config = new ConfiguracionBean();
    config.saveConfig("<check>", array);
  }

  private GregorianCalendar readFirtsStart() {
    GregorianCalendar fecha = new GregorianCalendar();
    ArrayList array = new ArrayList();
    ConfiguracionBean config = new ConfiguracionBean();
    array = config.getConfig("<check>");
    try {
      if (!array.isEmpty()) {
        int year = Integer.parseInt((String)array.get(0));
        int month = Integer.parseInt((String)array.get(1));
        int day = Integer.parseInt((String)array.get(2));
        fecha.set(year, month, day);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
    }
    return fecha;
  }

  private void setPanelMenuState() {
    ArrayList array = new ArrayList();
    ConfiguracionBean config = new ConfiguracionBean();
    array = config.getConfig("<menuconfig>");
    if (!array.isEmpty())
      try {
        int[] panelState = new int[8];
        for (int x = 0; x < 8; x++) {
          panelState[x] = Integer.parseInt((String)array.get(x));
        }
        this.panelMenu.readState(panelState);
      } catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
      }
  }

  private Rectangle readFrameBounds()
  {
    Rectangle bounds = null;
    ArrayList array = new ArrayList();
    ConfiguracionBean config = new ConfiguracionBean();
    array = config.getConfig("<lastposition>");
    if (!array.isEmpty()) {
      try {
        bounds = new Rectangle(Integer.parseInt((String)array.get(0)), Integer.parseInt((String)array.get(1)), Integer.parseInt((String)array.get(2)), Integer.parseInt((String)array.get(3)));
      }
      catch (NumberFormatException e)
      {
        e.printStackTrace();
      } catch (ArrayIndexOutOfBoundsException ex) {
        ex.printStackTrace();
      }
    }
    return bounds;
  }

  private void colocarInfo(String empresa) {
    if ((this.marco_info == null) || (this.marco_info.isClosed())) {
      this.marco_info = new InfoJInternalFrame();
      this.escritorio.add(this.marco_info);
    }
    this.marco_info.redibujar(empresa, Inicio.p.getEjercicio(), this.escritorio.getBounds());
    mostrarMarco(this.marco_info);
  }

  public void colocarInfo() {
    if ((this.marco_info == null) || (this.marco_info.isClosed())) {
      this.marco_info = new InfoJInternalFrame();
      this.escritorio.add(this.marco_info);
    }
    this.marco_info.redibujar(this.escritorio.getBounds());
    mostrarMarco(this.marco_info);
  }

  public void actionPerformed(ActionEvent e)
  {
    String cmd = e.getActionCommand();
    realizarAccion(cmd);
  }

  public void realizarAccion(String cmd) {
    if ("selempresa".equals(cmd)) {
      seleccionarEmpresa();
    } else if ("gesempresas".equals(cmd)) {
      GestionaEmpresas dlg = new GestionaEmpresas(this, Mensajes.getString("gesEmp"), true);
      mostrarDialogo(dlg);
    } else if ("abrirejercicio".equals(cmd)) {
      CreaEjercicio dlg = new CreaEjercicio(this, Mensajes.getString("creaEj"), true);
      mostrarDialogo(dlg);
    } else if ("borrarejercicio".equals(cmd)) {
      SeleccionEmpresa dlg = new SeleccionEmpresa(this, Mensajes.getString("suprEj"), true, true);
      mostrarDialogo(dlg);
    } else if ("gestionusuarios".equals(cmd))
    {
      UsuariosJDialog dlg = new UsuariosJDialog(false);
      mostrarDialogo(dlg);
    } else if ("salir".equals(cmd)) {
      System.exit(0);
    } else if ("desinstalar".equals(cmd)) {
      Desinstalar dlg = new Desinstalar(this, true);
      mostrarDialogo(dlg);
    } else if ("asientosaut".equals(cmd)) {
      if ((this.marco_Asientos_Modelo == null) || (this.marco_Asientos_Modelo.isClosed()))
      {
        this.marco_Asientos_Modelo = new Lista();
        this.escritorio.add(this.marco_Asientos_Modelo);
        annadirMarcoMenu(this.marco_Asientos_Modelo);
      }
      mostrarMarco(this.marco_Asientos_Modelo);
    }
    else if ("descuadres".equals(cmd)) {
      BuscarDescuadres dlg = new BuscarDescuadres(this, true);
      mostrarDialogo(dlg);
    } else if ("renumerar".equals(cmd)) {
      ReordenarDiario dlg = new ReordenarDiario(this, true);
      mostrarDialogo(dlg);
    } else if ("emitidas".equals(cmd)) {
      ListadoFacturas dlgListado = new ListadoFacturas(this, true);
      mostrarDialogo(dlgListado);
      if (dlgListado.Listar()) {
        List listado = dlgListado.textoListado();
        Listado listaEmitidas = new Listado(Mensajes.getString("lisEmit"), listado);
        mostrarMarcoExterno(listaEmitidas);
      }
    } else if ("recibidas".equals(cmd)) {
      ListadoFacturas dlgListado = new ListadoFacturas(this, true, false);
      mostrarDialogo(dlgListado);
      if (dlgListado.Listar()) {
        List listado = dlgListado.textoListado();
        Listado listaRecibidas = new Listado(Mensajes.getString("listReci"), listado);
        mostrarMarcoExterno(listaRecibidas);
      }
    }  else if ("comprobarVencimientos".equals(cmd)) {
      ComprobarVencimientos dlg = new ComprobarVencimientos(this, true);
      mostrarDialogo(dlg);
    } else if ("eliminarVencimientos".equals(cmd)) {
      BorrarVencimientos dlg = new BorrarVencimientos(this);
      mostrarDialogo(dlg);
    } else if ("comprobarVencimientosCobrar".equals(cmd)) {
      ComprobarVencimientosCobrar dlg = new ComprobarVencimientosCobrar(this, true);
      mostrarDialogo(dlg);
    } else if ("eliminarVencimientosCobrar".equals(cmd)) {
      BorrarVencimientos dlg = new BorrarVencimientos(this, false);
      mostrarDialogo(dlg);
    } else if ("liquidacioniva".equals(cmd)) {
      LiquidacionIVA dlg = new LiquidacionIVA(this, Mensajes.getString("liquidIVA"), true);
      mostrarDialogo(dlg);
    } else if ("liquidacionfiscaliva".equals(cmd)) {
      LiquidacionFiscalIVA dlg = new LiquidacionFiscalIVA(this, Mensajes.getString("liquidFiscalIVA"), true);
      mostrarDialogo(dlg);
      if (dlg.isListar()) {
        Listado listado = new Listado(dlg.getTitulo(), dlg.getListado());
        mostrarMarcoExterno(listado);
      }
    }
    else if ("operacionesTerceros".equals(cmd)) {
      OperacionesTerceros dlg = new OperacionesTerceros(this, true);
      mostrarDialogo(dlg);
      if (dlg.isListar()) {
        Listado listado = new Listado(dlg.getTitulo(), dlg.getListado());
        mostrarMarcoExterno(listado);
      }
    } else if ("sustitucion".equals(cmd)) {
      Sustitucion dlg = new Sustitucion(this, true);
      mostrarDialogo(dlg);
    } else if ("regenerarsaldos".equals(cmd)) {
      RegenerarSaldosSubcuentas dlg = new RegenerarSaldosSubcuentas(this, true);
      mostrarDialogo(dlg);
    } else if ("graficoscuentas".equals(cmd)) {
      ComparativaCuentasDlg dlg = new ComparativaCuentasDlg(this, true);
      mostrarDialogo(dlg);
      if (dlg.isHayDatos()) {
        MarcoParaGraficos marco = new MarcoParaGraficos(Mensajes.getString("comparativaGrafica") + " " + Mensajes.getString("de") + " " + Mensajes.getString("cuentas"), dlg.getNCta(), dlg.getNombreCuenta(), dlg.getDatosSaldos());

        mostrarMarcoExterno(marco);
      }
    } else if ("graficossaldos".equals(cmd)) {
      ComparativaSaldosDlg dlg = new ComparativaSaldosDlg(this, true);
      mostrarDialogo(dlg);
      if (dlg.isHayDatos()) {
        MarcoParaGraficos marco = new MarcoParaGraficos(dlg.getCuenta() + " : " + dlg.getNombreCuenta(), dlg.getNYear(), dlg.getYear(), dlg.getDatosSaldos());

        mostrarMarcoExterno(marco);
      }
    } else if ("niveles".equals(cmd)) {
      ListadoNiveles dlgListado = new ListadoNiveles(this, Mensajes.getString("niveles"), true);
      mostrarDialogo(dlgListado);
      if (dlgListado.Listar()) {
        List listado = dlgListado.textoListado();
        Listado listaRecibidas = new Listado(Mensajes.getString("niveles"), listado);
        mostrarMarcoExterno(listaRecibidas);
      }
    } else if ("pyg".equals(cmd))
    {
      CuentaPyG dlgListado = new CuentaPyG(this, true);
      mostrarDialogo(dlgListado);
      if (dlgListado.Listar()) {
        List listado = dlgListado.textoListado();
        Listado listaEmitidas = new Listado(Mensajes.getString("ctaPG"), listado);
        mostrarMarcoExterno(listaEmitidas);
      }
    } else if ("balance".equals(cmd))
    {
      Balance dlgListado = new Balance(this, true);
      mostrarDialogo(dlgListado);
      if (dlgListado.Listar()) {
        List listado = dlgListado.textoListado();
        Listado listaEmitidas = new Listado(Mensajes.getString("balance"), listado);
        mostrarMarcoExterno(listaEmitidas);
      }
    } else if ("pyg07".equals(cmd)) {
      CuentaPyG08 dlgListado = new CuentaPyG08(this, true);
      mostrarDialogo(dlgListado);
      if (dlgListado.Listar()) {
        List listado = dlgListado.textoListado();
        Listado listaEmitidas = new Listado(Mensajes.getString("ctaPG07"), listado);
        mostrarMarcoExterno(listaEmitidas);
      }
    } else if ("balance07".equals(cmd)) {
      Balance08 dlgListado = new Balance08(this, true);
      mostrarDialogo(dlgListado);
      if (dlgListado.Listar()) {
        List listado = dlgListado.textoListado();
        Listado listaEmitidas = new Listado(Mensajes.getString("balance07"), listado);
        mostrarMarcoExterno(listaEmitidas);
      }
    } else if ("ecpn".equals(cmd)) {
      ECPN clase = new ECPN();
      clase.ejecutar();
    } else if ("stocks".equals(cmd)) {
      RegularizacionExistencias dlg = new RegularizacionExistencias(this, true);
      mostrarDialogo(dlg);
    } else if ("asientoPyG".equals(cmd)) {
      PerdidasGanancias dlg = new PerdidasGanancias(this, true);
      mostrarDialogo(dlg);
    } else if ("apertura".equals(cmd)) {
      AperturaEjercicio dlg = new AperturaEjercicio(this, true);
      mostrarDialogo(dlg);
    } else if ("cierre".equals(cmd)) {
      CierreEjercicio dlg = new CierreEjercicio(this, true);
      mostrarDialogo(dlg);
    } else if ("cerrartodo".equals(cmd)) {
      cerrarMarcos();
    } else if ("ayuda".equals(cmd)) {
      abrirManual();
    }
    else if ("calculadora".equals(cmd)) {
      Inicio.calculadora.setVisible(true);
    } else if ("info".equals(cmd)) {
      AboutBox dlg = new AboutBox(this, true);
      mostrarDialogo(dlg);
    } else if ("web".equals(cmd)) {
      try {
        URI url = new URI("http://www.contaes.es");
        Desktop.getDesktop().browse(url);
      } catch (URISyntaxException ex) {
        Logger.getLogger(MarcoInicio.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (IOException ex) {
        ex.printStackTrace();
      }
    } else if ("updates".equals(cmd)) {
      try {
        URI url = new URI("http://www.contaes.es/instalar.html");
        Desktop.getDesktop().browse(url);
      } catch (URISyntaxException ex) {
        Logger.getLogger(MarcoInicio.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (IOException ex) {
        ex.printStackTrace();
      }
    } else if ("isupdate".equals(cmd)) {
      boolean isUpdate = new CheckVersionInWeb().isIsUpdate();
      if (isUpdate) {
        JOptionPane.showMessageDialog(this, "Su versión de Contaes4 está actualizada.", "Actualizaciones", 1);
      }
      else
      {
        int confirma = JOptionPane.showConfirmDialog(this, "Hay una versión más reciente de Contaes4.\n¿Desea abrir la página Web para descargarla?", "Actualizaciones", 0);

        if (confirma == 0) {
          try {
            URI url = new URI("http://www.contaes.es");
            Desktop.getDesktop().browse(url);
          } catch (URISyntaxException ex) {
            Logger.getLogger(MarcoInicio.class.getName()).log(Level.SEVERE, null, ex);
          }
          catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      }
    }else if ("traspasarAsientos".equals(cmd)) {
      TraspasarAsientos dlg = new TraspasarAsientos(this, true);
      mostrarDialogo(dlg);
    } else if ("formasPago".equals(cmd)) {
      FormasPago dlg = new FormasPago(this, true);
      mostrarDialogo(dlg);
    } else if ("ImportarFacturas".equals(cmd)) {
      new ImportarFacturas();
    } else if ("resumenclientes".equals(cmd)) {
      ResumenFacturasJDialog dlg = new ResumenFacturasJDialog(this, true, true);
      mostrarDialogo(dlg);
    } else if ("resumenproveedores".equals(cmd)) {
      ResumenFacturasJDialog dlg = new ResumenFacturasJDialog(this, true, false);
      mostrarDialogo(dlg);
    } else if ("distribucionpartidas".equals(cmd)) {
      DistribucionPartidasJDialog dlg = new DistribucionPartidasJDialog(this, true);
      mostrarDialogo(dlg);
    } else if ("origenesDestinos".equals(cmd)) {
      ContrapartidasJDialog dlg = new ContrapartidasJDialog(this, true);
      mostrarDialogo(dlg);
    } else if ("ratios".equals(cmd)) {
      RatiosJDialog dlg = new RatiosJDialog(this, true);
      mostrarDialogo(dlg);
    } else if ("mediospago".equals(cmd)) {
      MediosPagoJDialog dlg = new MediosPagoJDialog(this, true);
      mostrarDialogo(dlg);
    } else if ("vendedores".equals(cmd)) {
      VendedoresJDialog dlg = new VendedoresJDialog(this, true);
      mostrarDialogo(dlg);
    } else if ("ALMACENOLD1".equals(cmd)) {
      OldAlmacenJInternalFrame marcoAlmacenOld = new OldAlmacenJInternalFrame();
      this.escritorio.add(marcoAlmacenOld);
      marcoAlmacenOld.show();
      annadirMarcoMenu(marcoAlmacenOld);
    } else if ("ALMACENOLD2".equals(cmd)) {
      ListarProductosOldJInternalFrame marcoAlmacenOld2 = new ListarProductosOldJInternalFrame();
      this.escritorio.add(marcoAlmacenOld2);
      marcoAlmacenOld2.show();
      annadirMarcoMenu(marcoAlmacenOld2);
    } else if ("ALMACENOLD3".equals(cmd)) {
      BuscarRefOldJDialog dlg = new BuscarRefOldJDialog();
      mostrarDialogo(dlg);
    } else if ("paises".equals(cmd)) {
      Paises dlg = new Paises(this, true);
      mostrarDialogo(dlg);
    } else if ("makebackup".equals(cmd)) {
      DataBasesBackup backup = new DataBasesBackup();
      backup.make();
    }
    else if ("restorebackup".equals(cmd)) {
      DataBasesBackup backup = new DataBasesBackup();
      backup.restore();
    }
    else if ("backprogrampath".equals(cmd)) {
      BackupProgramPathJDialog dlg = new BackupProgramPathJDialog(this, true);
      mostrarDialogo(dlg);
    } else if ("renumerarfacturacion".equals(cmd)) {
      Reordenar dlg = new Reordenar(this, true, 0);
      mostrarDialogo(dlg);
    } else if ("renumerartickets".equals(cmd)) {
      Reordenar dlg = new Reordenar(this, true, 1);
      mostrarDialogo(dlg);
    } else if ("importarsubcuentas".equals(cmd)) {
      ImportarSubcuentas clase = new ImportarSubcuentas();
      clase.importar();
    } else if ("importardiaro".equals(cmd)) {
      ImportarDiario clase = new ImportarDiario();
      clase.importar();
    } else if ("controlcentre".equals(cmd)) {
      crearCentroControl();
      mostrarMarco(this.centroControl);
    } else if ("registro".equals(cmd)) {
      getSerialNumber();
    }
  }

  public Rectangle localizacion()
  {
    return getBounds();
  }

  private boolean hayEmpresas()
  {
    int numEmpresas = new ManejoEmpresas(Inicio.getCGeneral(), Inicio.p.getEmpresa()).listaEmpresas().size();
    if (numEmpresas > 0) {
      return true;
    }
    return false;
  }

  private void seleccionarEmpresa()
  {
    SeleccionEmpresa dlg = new SeleccionEmpresa(this, Mensajes.getString("selEmp"), true, false);
    mostrarDialogo(dlg);
    if (dlg.haySeleccion()) {
      setTitle(this.titulo + dlg.getNombre() + " - " + Inicio.p.getEjercicio());
      if (this.firstStart)
      {
        this.firstStart = false;
      }
      else
      {
       
        anularMarco(this.marco_CreacionFacturas);
        anularMarco(this.centroControl);
      }
      colocarInfo(dlg.getNombre());
    }
    getContentPane().repaint();
    System.gc();
  }
  private void getSerialNumber() {
    String s = JOptionPane.showInputDialog(this, "Introduzca su número de serie", "Registro", 3);
    if (s.equals("VBJ05E151R3010M276")) {
      ConfiguracionBean c = new ConfiguracionBean();
      c.saveConfigStr("<mouse>", "1");
      Inicio.p.setRegistro(true);
      JOptionPane.showMessageDialog(this, "¡Gracias por registrar Contaes4!", "Registro", 1);
    }
    else {
      JOptionPane.showMessageDialog(this, "¡El número introducido no es correcto!", "Registro", 0);
    }
  }

  public void renovarTabla(int tabla)
  {
    switch (tabla) {
    case 0:
      if (this.marco_Asientos_Modelo != null)
        this.marco_Asientos_Modelo.renovarTabla(); break;
   
    }
  }

  public void modificarElemento(int marco)
  {
    JInternalFrame f = null;
    switch (marco) {
    case 0:
      crearMarcoNuevaFactura();
      f = this.marco_CreacionFacturas;
      break;
    }

    if (f != null) {
      f.setVisible(true);
      try {
        if (f.isIcon()) {
          f.setIcon(false);
        }
        if (!f.isSelected())
          f.setSelected(true);
      }
      catch (PropertyVetoException exc) {
      }
    }
  }

  private void crearMenu(JMenuBar menu)
  {
    JMenu empresas = new JMenu(Mensajes.getString("menu1"));
    menu.add(empresas);
    JMenu diario = new JMenu(Mensajes.getString("diario"));
    menu.add(diario);
    JMenu cuentas = new JMenu(Mensajes.getString("menu4"));
    menu.add(cuentas);
    JMenu facturas = new JMenu(Mensajes.getString("menu3"));
    menu.add(facturas);
    JMenu balances = new JMenu(Mensajes.getString("menu5"));
    menu.add(balances);
    JMenu ventanas = new JMenu(Mensajes.getString("ventana"));
    menu.add(ventanas);
    JMenu ayuda = new JMenu(Mensajes.getString("ayuda"));
    menu.add(ayuda);

    JMenuItem item = null;
    item = makeMenuItem("MseleccEj", "selempresa", Mensajes.getString("menu11tt"), Mensajes.getString("selEmp"));
    empresas.add(item);
    item = makeMenuItem("MgestionEmp", "gesempresas", Mensajes.getString("menu12tt"), Mensajes.getString("gesEmp"));
    empresas.add(item);
    empresas.addSeparator();
    item = makeMenuItem("McrearEj", "abrirejercicio", Mensajes.getString("menu13tt"), Mensajes.getString("creaEj"));
    empresas.add(item);
    item = makeMenuItem("MsuprimirEj", "borrarejercicio", Mensajes.getString("menu14tt"), Mensajes.getString("suprEj"));
    empresas.add(item);
    empresas.addSeparator();
    item = makeMenuItem("MgestionUsu", "gestionusuarios", Mensajes.getString("menu15tt"), Mensajes.getString("usuarios"));
    empresas.add(item);
    empresas.addSeparator();
    item = makeMenuItem("makebackup", "makebackup", "Realiza una copia de seguridad de las bases de datos", "Respaldar bases de datos");
    empresas.add(item);
    item = makeMenuItem("restorebackup", "restorebackup", "Restaura una copia de seguridad de las bases de datos", "Restaurar bases de datos");
    empresas.add(item);
    item = makeMenuItem("backuppath", "backprogrampath", "Guarda la ruta de acceso a la instalación de MySQL", "Ruta de MySQL");
    empresas.add(item);
    empresas.addSeparator();
    item = makeMenuItem("danger", "desinstalar", "Borra todas las bases de datos del programa", "Desinstalar");
    empresas.add(item);
    empresas.addSeparator();
    item = makeMenuItem("exit", "salir", Mensajes.getString("menu16tt"), Mensajes.getString("salir"));
    empresas.add(item);

    item = makeMenuItem("Masientos", "asientos", Mensajes.getString("menu21tt"), Mensajes.getString("menu21"));
    diario.add(item);
    item = makeMenuItem("MasientosModelo", "asientosaut", Mensajes.getString("menu22tt"), Mensajes.getString("astModel"));
    diario.add(item);
    diario.addSeparator();
    item = makeMenuItem("Mdiario", "consultasdiario", Mensajes.getString("listaDiario"), Mensajes.getString("menu23"));
    diario.add(item);
    item = makeMenuItem("Traspaso", "traspasarAsientos", "Copia asientos entre empresas", "Copiar asientos");
    diario.add(item);
    diario.addSeparator();
    item = makeMenuItem("Mconceptos", "conceptos", Mensajes.getString("menu24tt"), Mensajes.getString("menu24"));
    diario.add(item);
    diario.addSeparator();
    item = makeMenuItem("Mdescuadres", "descuadres", Mensajes.getString("menu25tt"), Mensajes.getString("descuadres"));
    diario.add(item);
    item = makeMenuItem("MrenumD", "renumerar", Mensajes.getString("menu26tt"), Mensajes.getString("renumerarD"));
    diario.add(item);
    diario.addSeparator();
    item = makeMenuItem("diarioImportar", "importardiaro", "Importar diario desde archivo csv", "Importar diario");
    diario.add(item);

    item = makeMenuItem("Mfacturas", "facturas", Mensajes.getString("menu31tt"), Mensajes.getString("menu31"));
    facturas.add(item);
    JMenu Gestion = new JMenu(Mensajes.getString("menu31b"));
    Gestion.setIcon(new ImageIcon(MarcoInicio.class.getResource("/contaes/iconos/gestionFacturas.png")));
    facturas.add(Gestion);
    item = makeMenuItem("gestionEmitidas", "gestionEmitidas", Mensajes.getString("menu31b1tt"), Mensajes.getString("menu31b1"));
    Gestion.add(item);
    item = makeMenuItem("gestionRecibidas", "gestionRecibidas", Mensajes.getString("menu31b2tt"), Mensajes.getString("menu31b2"));
    Gestion.add(item);
    JMenu listados = new JMenu(Mensajes.getString("menu32"));
    listados.setIcon(new ImageIcon(MarcoInicio.class.getResource("/contaes/iconos/MlistFacturas.png")));
    facturas.add(listados);
    item = makeMenuItem("MlFactEmit", "emitidas", Mensajes.getString("lisEmit"), Mensajes.getString("menu33"));
    listados.add(item);
    item = makeMenuItem("MlFactReci", "recibidas", Mensajes.getString("listReci"), Mensajes.getString("menu34"));
    listados.add(item);
    facturas.addSeparator();
    JMenu vencimientos = new JMenu(Mensajes.getString("vencimientos"));
    vencimientos.setIcon(new ImageIcon(MarcoInicio.class.getResource("/contaes/iconos/MV.png")));
    item = makeMenuItem("MV", "formasPago", "Gestión de formas de pago", "Formas de pago");
    vencimientos.add(item);
    vencimientos.addSeparator();
    item = makeMenuItem("MVc", "vencimientoscobrar", Mensajes.getString("menu35att"), Mensajes.getString("menu35a"));
    vencimientos.add(item);
    item = makeMenuItem("McomprobarVc", "comprobarVencimientosCobrar", Mensajes.getString("menu36tt"), Mensajes.getString("menu36a"));
    vencimientos.add(item);
    item = makeMenuItem("MEliminarVc", "eliminarVencimientosCobrar", "", Mensajes.getString("elimVto"));
    vencimientos.add(item);
    vencimientos.addSeparator();
    item = makeMenuItem("MVp", "vencimientos", Mensajes.getString("menu35tt"), Mensajes.getString("menu35"));
    vencimientos.add(item);
    item = makeMenuItem("McomprobarVp", "comprobarVencimientos", Mensajes.getString("menu36tt"), Mensajes.getString("menu36"));
    vencimientos.add(item);
    item = makeMenuItem("MEliminarVp", "eliminarVencimientos", "", Mensajes.getString("elimVto"));
    vencimientos.add(item);
    facturas.add(vencimientos);
    facturas.addSeparator();
    item = makeMenuItem("MIVAfiscal", "tiposIVA", "Gestión de tipos de IVA", "Tipos de IVA");
    facturas.add(item);
    item = makeMenuItem("MIVAcontable", "liquidacioniva", Mensajes.getString("menu37tt"), Mensajes.getString("liquidIVA"));
    facturas.add(item);
    item = makeMenuItem("MIVAfiscal", "liquidacionfiscaliva", Mensajes.getString("menuIVAtt"), Mensajes.getString("liquidFiscalIVA"));
    facturas.add(item);
    item = makeMenuItem("MOpTerceros", "operacionesTerceros", "", Mensajes.getString("OperaTerceros"));
    facturas.add(item);


    item = makeMenuItem("Mcuentas", "cuentas", Mensajes.getString("menu41tt"), Mensajes.getString("menu41"));
    cuentas.add(item);
    cuentas.addSeparator();
    item = makeMenuItem("Mgraficos", "graficoscuentas", Mensajes.getString("comparativaGraficatt1"), Mensajes.getString("comparativaGrafica") + " " + Mensajes.getString("de") + " " + Mensajes.getString("cuentas"));

    cuentas.add(item);
    item = makeMenuItem("Mgraficos", "graficossaldos", Mensajes.getString("comparativaGraficatt2"), Mensajes.getString("comparativaGrafica") + " " + Mensajes.getString("de") + " " + Mensajes.getString("saldos"));

    cuentas.add(item);
    cuentas.addSeparator();
    item = makeMenuItem("MsustituCtas", "sustitucion", Mensajes.getString("sustituCuentastt"), Mensajes.getString("sustituCuentas"));
    cuentas.add(item);
    item = makeMenuItem("MrecalcSaldos", "regenerarsaldos", Mensajes.getString("menu42tt"), Mensajes.getString("regen"));
    cuentas.add(item);
    cuentas.addSeparator();
    item = makeMenuItem("cuentasImportar", "importarsubcuentas", "Importar subcuentas desde archivo csv", "Importar subcuentas");
    cuentas.add(item);

    item = makeMenuItem("MlistSN", "niveles", Mensajes.getString("menu51tt"), Mensajes.getString("niveles"));
    balances.add(item);
    balances.addSeparator();

    item = makeMenuItem("MlistPG", "pyg07", Mensajes.getString("menu52tt07"), Mensajes.getString("ctaPG07"));
    balances.add(item);

    item = makeMenuItem("MlistB", "balance07", Mensajes.getString("menu53tt07"), Mensajes.getString("balance07"));
    balances.add(item);
    item = makeMenuItem("MlistB", "ecpn", Mensajes.getString("ecpntt"), Mensajes.getString("ecpn"));
    balances.add(item);
    balances.addSeparator();
    JMenu cierre = new JMenu(Mensajes.getString("menu54"));
    cierre.setIcon(new ImageIcon(MarcoInicio.class.getResource("/contaes/iconos/Mcierre.png")));
    balances.add(cierre);
    item = makeMenuItem("MasientoRE", "stocks", Mensajes.getString("menu55tt"), Mensajes.getString("regulaEx"));
    cierre.add(item);
    item = makeMenuItem("MasientoPG", "asientoPyG", Mensajes.getString("menu56tt"), Mensajes.getString("menu56"));
    cierre.add(item);
    item = makeMenuItem("MasientoCierre", "cierre", Mensajes.getString("menu57tt"), Mensajes.getString("astoCierre"));
    cierre.add(item);
    item = makeMenuItem("MasientoApert", "apertura", Mensajes.getString("menu58tt"), Mensajes.getString("astoApertura"));
    cierre.add(item);

    item = makeMenuItem("hide", "cerrartodo", Mensajes.getString("cerrarTodastt"), Mensajes.getString("cerrarTodas"));
    ventanas.add(item);

    item = makeMenuItem("ok", "registro", "", "Registrar producto");
    ayuda.add(item);
    ayuda.addSeparator();
    item = makeMenuItem("help", "ayuda", "", Mensajes.getString("ayuda"));
    ayuda.add(item);
    item = makeMenuItem("Mcalc", "calculadora", "", Mensajes.getString("calculadora"));
    ayuda.add(item);

    ayuda.addSeparator();
    item = makeMenuItem("web", "web", "", "Web de Contaes");
    ayuda.add(item);
    item = makeMenuItem("web", "updates", "", "Novedades");
    ayuda.add(item);
    item = makeMenuItem("checkupd", "isupdate", "", "Comprobar actualizaciones");
    ayuda.add(item);
    ayuda.addSeparator();
    item = makeMenuItem("info", "info", "", Mensajes.getString("info"));
    ayuda.add(item);
  }

  private JMenuItem makeMenuItem(String imageName, String actionCommand, String toolTipText, String Text)
  {
    String imgLocation = "/contaes/iconos/" + imageName + ".png";
    URL imageURL = MarcoInicio.class.getResource(imgLocation);

    JMenuItem elementoMenu = new JMenuItem();
    elementoMenu.setActionCommand(actionCommand);
    elementoMenu.setToolTipText(toolTipText);
    elementoMenu.addActionListener(this);
    elementoMenu.setText(Text);

    if (imageURL != null) {
      elementoMenu.setIcon(new ImageIcon(imageURL));
    }

    return elementoMenu;
  }

  private void addBotonesPOS(JToolBar toolBar)
  {
    toolBar.addSeparator();

    this.terminalPOS = makeNavigationButton("tpv32", "terminalventas", Mensajes.getString("terminalventas"), "");

    toolBar.add(this.terminalPOS);
    toolBar.addSeparator(new Dimension(20, 0));

    this.resumenPOS = makeNavigationButton("tpvres32", "resumendiario", Mensajes.getString("resumendia"), "");

    toolBar.add(this.resumenPOS);
    toolBar.addSeparator(new Dimension(30, 0));

    this.salirPOS = makeNavigationButton("exit32", "salir", Mensajes.getString("salir"), "");

    toolBar.add(this.salirPOS);
  }

  private JButton makeNavigationButton(String imageName, String actionCommand, String toolTipText, String altText)
  {
    String imgLocation = "/contaes/iconos/" + imageName + ".png";
    URL imageURL = MarcoInicio.class.getResource(imgLocation);

    JButton button = new JButton();
    button.setActionCommand(actionCommand);
    button.setToolTipText(toolTipText);
    button.addActionListener(this);

    if (imageURL != null) {
      button.setIcon(new ImageIcon(imageURL, altText));
    } else {
      button.setText(altText);
      System.err.println("Resource not found: " + imgLocation);
    }

    return button;
  }

  public void mostrarDialogo(JDialog dlg) {
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);

    dlg.pack();
    dlg.setVisible(true);
  }

  private void mostrarMarco(JInternalFrame marco) {
    marco.setVisible(true);

    marco.moveToFront();
    try {
      if (marco.isIcon()) {
        marco.setIcon(false);
      }
      marco.setSelected(true);
    } catch (PropertyVetoException exc) {
    }
  }

  public void mostrarMarcoExterno(JFrame frame) {
    frame.validate();

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    frame.setVisible(true);
  }

  private void abrirManual()
  {
    try {
      File path = new File("ManualContaes.pdf");
      Desktop.getDesktop().open(path);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private void cerrarMarcos()
  {
    JInternalFrame[] marco = this.escritorio.getAllFrames();
    for (int x = 0; x < marco.length; x++) {
      if (marco[x] != null) {
        marco[x].hide();
      }
    }
    this.escritorio.repaint();
  }

  private void anularMarco(MarcoInterno marco) {
    if (marco != null) {
      eliminarMarcoMenu(marco.getTitle());
      marco.cerrarConexion();
      marco.dispose();
    }
  }

  private void anularMarco(JInternalFrame marco) {
    if (marco != null) {
      eliminarMarcoMenu(marco.getTitle());
      marco.dispose();
    }
  }

  private void anularMarco(CreacionFacturas marco_CreacionFacturas) {
    if (marco_CreacionFacturas != null) {
      eliminarMarcoMenu(marco_CreacionFacturas.getTitle());
      marco_CreacionFacturas.cerrarConexion();
      marco_CreacionFacturas.dispose();
    }
  }

  private void crearMarcoNuevaFactura() {
    if ((this.marco_CreacionFacturas == null) || (this.marco_CreacionFacturas.isClosed())) {
      this.marco_CreacionFacturas = new CreacionFacturas();
      this.escritorio.add(this.marco_CreacionFacturas);
      annadirMarcoMenu(this.marco_CreacionFacturas);
    }
  }

  private void crearCentroControl() {
    if ((this.centroControl == null) || (this.centroControl.isClosed())) {
      this.centroControl = new ControlCentreJInternalFrame();
      this.escritorio.add(this.centroControl);
      annadirMarcoMenu(this.centroControl);
    }
  }

  private void annadirMarcoMenu(final JInternalFrame marco) {
    String imgLocation = "/contaes/iconos/window.png";
    URL imageURL = MarcoInicio.class.getResource(imgLocation);

    JMenuItem elementoMenu = new JMenuItem();
    elementoMenu.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        MarcoInicio.this.mostrarMarco(marco);
      }
    });
    elementoMenu.setText(marco.getTitle());

    if (imageURL != null) {
      elementoMenu.setIcon(new ImageIcon(imageURL));
    }
    this.barraMenu.getMenu(7).add(elementoMenu);
  }

  public void eliminarMarcoMenu(String titulo) {
    for (int x = 0; x < this.barraMenu.getMenu(7).getItemCount(); x++)
      if (titulo.equals(this.barraMenu.getMenu(7).getItem(x).getText())) {
        this.barraMenu.getMenu(7).remove(x);
        break;
      }
  }

  private class CierreVentana extends WindowAdapter
  {
    private CierreVentana()
    {
    }

    public void windowClosing(WindowEvent arg0)
    {
      Rectangle dimMarco = arg0.getWindow().getBounds();
      grabarDimesiones(dimMarco);
      grabarEmpresaSeleccionada();
      if (Inicio.getCEmpresa() != null) {
        Inicio.getCEmpresa().cierraConexion();
      }
      if (Inicio.getCGeneral() != null) {
        Inicio.getCGeneral().cierraConexion();
      }
      if (Inicio.getCFacturacion() != null) {
        Inicio.getCFacturacion().cierraConexion();
      }
      if (Inicio.getcAlmacen() != null) {
        Inicio.getcAlmacen().cierraConexion();
      }
      if (MarcoInicio.this.centroControl != null) {
        MarcoInicio.this.centroControl.saveFrameBounds();
      }
      super.windowClosing(arg0);
    }

    private void grabarDimesiones(Rectangle dim) {
      int[] panelState = MarcoInicio.this.panelMenu.saveState();

      ConfiguracionBean config = new ConfiguracionBean();
      ArrayList array = new ArrayList();
      array.add(Integer.toString(dim.x));
      array.add(Integer.toString(dim.y));
      array.add(Integer.toString(dim.width));
      array.add(Integer.toString(dim.height));
      config.saveConfig("<lastposition>", array);
      array.clear();
      for (int x = 0; x < 8; x++) {
        array.add(Integer.toString(panelState[x]));
      }
      config.saveConfig("<menuconfig>", array);
    }

    private void grabarEmpresaSeleccionada()
    {
      ConfiguracionBean config = new ConfiguracionBean();
      ArrayList array = new ArrayList();
      array.add(Integer.toString(Inicio.p.getEmpresa()));
      array.add(Inicio.p.getEjercicio());
      config.saveConfig("<lastuse>", array);
    }
  }
}

 /*Location       /media/sda1/contaes4/contaes4.jar
 * Qualified Name:     contaes.MarcoInicio
 * JD-Core Version:    0.6.2
 */