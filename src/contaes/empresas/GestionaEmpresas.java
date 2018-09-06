package contaes.empresas;

import contaes.Inicio;
import contaes.Puente;
import contaes.auxiliar.DocDiezCarac;
import contaes.manejoDatos.ManejoEmpresas;
import internationalization.Mensajes;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GestionaEmpresas extends JDialog
{
  private JPanel jContentPane = null;
  private JLabel jLabel = null;
  private JComboBox listaEmpresas = null;
  private JTextField cNombre = null;
  private JLabel jLabel1 = null;
  private JLabel jLabel2 = null;
  private JLabel jLabel3 = null;
  private JLabel jLabel4 = null;
  private JLabel jLabel5 = null;
  private JTextField cNIF = null;
  private JTextField cDireccion = null;
  private JTextField cLocalidad = null;
  private JTextField cProvincia = null;
  private JTextField cTelefono = null;
  private JLabel jLabel6 = null;
  private JLabel jLabel7 = null;
  private JTextField cFax = null;
  private JTextField cCP = null;
  private JButton bNueva = null;
  private JPanel jPanel = null;
  private JButton bBorrar = null;
  private JButton bSalir = null;
  private JButton bModificar = null;
  private boolean esNueva = false;
  private JLabel jLabel8 = null;
  private JTextField cPrejifo = null;
  private ManejoEmpresas empresaM = null;
  private Acciones escuchaAccion = null;

  public GestionaEmpresas()
  {
    this(new Frame(), Mensajes.getString("gesEmp"), false);
  }

  public GestionaEmpresas(Frame owner, String title, boolean modal)
  {
    super(owner, title, modal);
    this.empresaM = new ManejoEmpresas(Inicio.getCGeneral(), Inicio.p.getEmpresa());
    this.escuchaAccion = new Acciones();
    initialize();
  }

  private void initialize()
  {
    setSize(420, 300);
    setContentPane(getJContentPane());
    if (this.listaEmpresas.getItemCount() > 0)
      cambiaEmpresa(this.listaEmpresas.getSelectedItem().toString());
  }

  private JPanel getJContentPane()
  {
    if (this.jContentPane == null) {
      GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
      gridBagConstraints21.fill = 2;
      gridBagConstraints21.gridy = 2;
      gridBagConstraints21.weightx = 1.0D;
      gridBagConstraints21.insets = new Insets(3, 10, 2, 80);
      gridBagConstraints21.gridx = 3;
      GridBagConstraints gridBagConstraints110 = new GridBagConstraints();
      gridBagConstraints110.gridx = 2;
      gridBagConstraints110.anchor = 13;
      gridBagConstraints110.insets = new Insets(3, 5, 2, 0);
      gridBagConstraints110.gridy = 2;
      this.jLabel8 = new JLabel();
      this.jLabel8.setText(Mensajes.getString("prefijo"));
      GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
      gridBagConstraints18.fill = 2;
      gridBagConstraints18.gridy = 1;
      gridBagConstraints18.weightx = 1.0D;
      gridBagConstraints18.anchor = 17;
      gridBagConstraints18.insets = new Insets(3, 10, 2, 150);
      gridBagConstraints18.gridwidth = 4;
      gridBagConstraints18.gridx = 0;
      GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
      gridBagConstraints17.gridx = 0;
      gridBagConstraints17.gridwidth = 4;
      gridBagConstraints17.insets = new Insets(10, 10, 10, 10);
      gridBagConstraints17.fill = 2;
      gridBagConstraints17.gridy = 7;
      GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
      gridBagConstraints16.gridx = 3;
      gridBagConstraints16.anchor = 10;
      gridBagConstraints16.insets = new Insets(0, 0, 0, 0);
      gridBagConstraints16.gridy = 1;
      GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
      gridBagConstraints15.fill = 2;
      gridBagConstraints15.gridy = 5;
      gridBagConstraints15.weightx = 1.0D;
      gridBagConstraints15.insets = new Insets(3, 10, 2, 80);
      gridBagConstraints15.gridx = 3;
      GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
      gridBagConstraints14.fill = 2;
      gridBagConstraints14.gridy = 6;
      gridBagConstraints14.weightx = 1.0D;
      gridBagConstraints14.insets = new Insets(3, 10, 2, 70);
      gridBagConstraints14.gridx = 3;
      GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
      gridBagConstraints13.gridx = 2;
      gridBagConstraints13.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints13.gridy = 5;
      this.jLabel7 = new JLabel();
      this.jLabel7.setText(Mensajes.getString("cp"));
      GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
      gridBagConstraints12.gridx = 2;
      gridBagConstraints12.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints12.gridy = 6;
      this.jLabel6 = new JLabel();
      this.jLabel6.setText(Mensajes.getString("fax"));
      GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
      gridBagConstraints11.fill = 2;
      gridBagConstraints11.gridy = 6;
      gridBagConstraints11.weightx = 1.0D;
      gridBagConstraints11.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints11.gridx = 1;
      GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
      gridBagConstraints10.fill = 2;
      gridBagConstraints10.gridy = 5;
      gridBagConstraints10.weightx = 1.0D;
      gridBagConstraints10.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints10.gridx = 1;
      GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
      gridBagConstraints9.fill = 2;
      gridBagConstraints9.gridy = 4;
      gridBagConstraints9.weightx = 1.0D;
      gridBagConstraints9.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints9.gridwidth = 2;
      gridBagConstraints9.gridx = 1;
      GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
      gridBagConstraints8.fill = 2;
      gridBagConstraints8.gridy = 3;
      gridBagConstraints8.weightx = 1.0D;
      gridBagConstraints8.insets = new Insets(3, 10, 2, 30);
      gridBagConstraints8.gridwidth = 3;
      gridBagConstraints8.gridx = 1;
      GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
      gridBagConstraints7.fill = 2;
      gridBagConstraints7.gridy = 2;
      gridBagConstraints7.weightx = 1.0D;
      gridBagConstraints7.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints7.gridx = 1;
      GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
      gridBagConstraints6.gridx = 0;
      gridBagConstraints6.anchor = 17;
      gridBagConstraints6.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints6.gridy = 6;
      this.jLabel5 = new JLabel();
      this.jLabel5.setText(Mensajes.getString("telefono"));
      GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
      gridBagConstraints5.gridx = 0;
      gridBagConstraints5.anchor = 17;
      gridBagConstraints5.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints5.gridy = 5;
      this.jLabel4 = new JLabel();
      this.jLabel4.setText(Mensajes.getString("provincia"));
      GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
      gridBagConstraints4.gridx = 0;
      gridBagConstraints4.anchor = 17;
      gridBagConstraints4.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints4.gridy = 4;
      this.jLabel3 = new JLabel();
      this.jLabel3.setText(Mensajes.getString("localidad"));
      GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
      gridBagConstraints3.gridx = 0;
      gridBagConstraints3.anchor = 17;
      gridBagConstraints3.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints3.gridy = 3;
      this.jLabel2 = new JLabel();
      this.jLabel2.setText(Mensajes.getString("direccion"));
      GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
      gridBagConstraints2.gridx = 0;
      gridBagConstraints2.anchor = 17;
      gridBagConstraints2.insets = new Insets(3, 10, 2, 0);
      gridBagConstraints2.gridy = 2;
      this.jLabel1 = new JLabel();
      this.jLabel1.setText(Mensajes.getString("NIF"));
      GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
      gridBagConstraints1.fill = 2;
      gridBagConstraints1.gridy = 1;
      gridBagConstraints1.weightx = 1.0D;
      gridBagConstraints1.anchor = 17;
      gridBagConstraints1.insets = new Insets(3, 10, 2, 150);
      gridBagConstraints1.gridwidth = 4;
      gridBagConstraints1.gridx = 0;
      GridBagConstraints gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 0;
      gridBagConstraints.anchor = 17;
      gridBagConstraints.insets = new Insets(10, 10, 0, 0);
      gridBagConstraints.gridy = 0;
      this.jLabel = new JLabel();
      this.jLabel.setText(Mensajes.getString("nombre"));
      this.jContentPane = new JPanel();
      this.jContentPane.setLayout(new GridBagLayout());
      this.jContentPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createEtchedBorder(1)));

      this.jContentPane.add(this.jLabel, gridBagConstraints);
      this.jContentPane.add(getListaEmpresas(), gridBagConstraints1);
      this.jContentPane.add(getCNombre(), gridBagConstraints18);
      this.jContentPane.add(this.jLabel1, gridBagConstraints2);
      this.jContentPane.add(this.jLabel2, gridBagConstraints3);
      this.jContentPane.add(this.jLabel3, gridBagConstraints4);
      this.jContentPane.add(this.jLabel4, gridBagConstraints5);
      this.jContentPane.add(this.jLabel5, gridBagConstraints6);
      this.jContentPane.add(getCNIF(), gridBagConstraints7);
      this.jContentPane.add(getCDireccion(), gridBagConstraints8);
      this.jContentPane.add(getCLocalidad(), gridBagConstraints9);
      this.jContentPane.add(getCProvincia(), gridBagConstraints10);
      this.jContentPane.add(getCTelefono(), gridBagConstraints11);
      this.jContentPane.add(this.jLabel6, gridBagConstraints12);
      this.jContentPane.add(this.jLabel7, gridBagConstraints13);
      this.jContentPane.add(getCFax(), gridBagConstraints14);
      this.jContentPane.add(getCCP(), gridBagConstraints15);
      this.jContentPane.add(getBNueva(), gridBagConstraints16);
      this.jContentPane.add(getJPanel(), gridBagConstraints17);
      this.jContentPane.add(this.jLabel8, gridBagConstraints110);
      this.jContentPane.add(getCPrejifo(), gridBagConstraints21);
    }
    return this.jContentPane;
  }

  private JComboBox getListaEmpresas()
  {
    if (this.listaEmpresas == null) {
      this.listaEmpresas = new JComboBox();
      LinkedList lista = new LinkedList();
      lista.addAll(this.empresaM.listaEmpresas());
      if (lista.size() > 0) {
        for (String x : (List<String>) lista) {
          this.listaEmpresas.addItem(x);
        }
      }
      this.listaEmpresas.addActionListener(this.escuchaAccion);
    }
    return this.listaEmpresas;
  }

  private JTextField getCNIF()
  {
    if (this.cNIF == null) {
      this.cNIF = new JTextField(7);
    }
    return this.cNIF;
  }

  private JTextField getCDireccion()
  {
    if (this.cDireccion == null) {
      this.cDireccion = new JTextField();
    }
    return this.cDireccion;
  }

  private JTextField getCLocalidad()
  {
    if (this.cLocalidad == null) {
      this.cLocalidad = new JTextField();
    }
    return this.cLocalidad;
  }

  private JTextField getCProvincia()
  {
    if (this.cProvincia == null) {
      this.cProvincia = new JTextField();
    }
    return this.cProvincia;
  }

  private JTextField getCTelefono()
  {
    if (this.cTelefono == null) {
      this.cTelefono = new JTextField();
    }
    return this.cTelefono;
  }

  private JTextField getCFax()
  {
    if (this.cFax == null) {
      this.cFax = new JTextField(7);
    }
    return this.cFax;
  }

  private JTextField getCCP()
  {
    if (this.cCP == null) {
      this.cCP = new JTextField();
    }
    return this.cCP;
  }

  private JButton getBNueva()
  {
    if (this.bNueva == null) {
      this.bNueva = new JButton();
      this.bNueva.setText(Mensajes.getString("nueva"));
      this.bNueva.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/new.png")));
      this.bNueva.setHorizontalTextPosition(2);
      this.bNueva.addActionListener(this.escuchaAccion);
    }
    return this.bNueva;
  }

  private JPanel getJPanel()
  {
    if (this.jPanel == null) {
      GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
      gridBagConstraints20.gridx = 0;
      gridBagConstraints20.insets = new Insets(5, 10, 0, 10);
      gridBagConstraints20.gridy = 0;
      GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
      gridBagConstraints19.gridx = 2;
      gridBagConstraints19.insets = new Insets(5, 10, 0, 10);
      gridBagConstraints19.gridy = 0;
      GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
      gridBagConstraints18.gridx = 1;
      gridBagConstraints18.ipadx = 0;
      gridBagConstraints18.insets = new Insets(5, 10, 0, 10);
      gridBagConstraints18.gridy = 0;
      this.jPanel = new JPanel();
      this.jPanel.setLayout(new GridBagLayout());
      this.jPanel.add(getBBorrar(), gridBagConstraints18);
      this.jPanel.add(getBSalir(), gridBagConstraints19);
      this.jPanel.add(getBModificar(), gridBagConstraints20);
    }
    return this.jPanel;
  }

  private JButton getBBorrar()
  {
    if (this.bBorrar == null) {
      this.bBorrar = new JButton();
      this.bBorrar.setText(Mensajes.getString("borrar"));
      this.bBorrar.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/delete.png")));
      this.bBorrar.setHorizontalTextPosition(2);
      this.bBorrar.addActionListener(this.escuchaAccion);
    }
    return this.bBorrar;
  }

  private JButton getBSalir()
  {
    if (this.bSalir == null) {
      this.bSalir = new JButton();
      this.bSalir.setText(Mensajes.getString("salir"));
      this.bSalir.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/cancel.png")));
      this.bSalir.setHorizontalTextPosition(2);
      this.bSalir.addActionListener(this.escuchaAccion);
    }
    return this.bSalir;
  }

  private JButton getBModificar()
  {
    if (this.bModificar == null) {
      this.bModificar = new JButton();
      this.bModificar.setText(Mensajes.getString("modificar"));
      this.bModificar.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/edit.png")));
      this.bModificar.setHorizontalTextPosition(2);
      this.bModificar.addActionListener(this.escuchaAccion);
    }
    return this.bModificar;
  }

  public JTextField getCNombre()
  {
    if (this.cNombre == null) {
      this.cNombre = new JTextField();
      this.cNombre.setEnabled(false);
      this.cNombre.setVisible(false);
    }
    return this.cNombre;
  }

  private void limpiarDialogo()
  {
    this.cNombre.setText("");
    this.cNIF.setText("");
    this.cDireccion.setText("");
    this.cLocalidad.setText("");
    this.cProvincia.setText("");
    this.cCP.setText("");
    this.cTelefono.setText("");
    this.cFax.setText("");
    this.cPrejifo.setText("");
  }

  private void cambiaEmpresa(String empresa)
  {
    String[] datos = this.empresaM.datosEmpresa(empresa);
    if (datos != null) {
      this.cNIF.setText(datos[0]);
      this.cDireccion.setText(datos[1]);
      this.cLocalidad.setText(datos[2]);
      this.cProvincia.setText(datos[3]);
      this.cCP.setText(datos[4]);
      this.cTelefono.setText(datos[5]);
      this.cFax.setText(datos[6]);
      this.cPrejifo.setText(datos[7]);
    }
  }

  //Almacenamiento del cliente
  private void creaCliente()
  {
    String[] datos = { this.cNombre.getText(), this.cNIF.getText(), this.cDireccion.getText(), this.cLocalidad.getText(), this.cProvincia.getText(), this.cCP.getText(), this.cTelefono.getText(), this.cFax.getText(), this.cPrejifo.getText() };
   
    if (this.esNueva) {
      int id = this.empresaM.getIdEmpresa(datos[0]);
      if (id == -1) {
        this.empresaM.crearEmpresa(datos);
        this.esNueva = false;
        this.listaEmpresas.addItem(this.cNombre.getText());
        limpiarDialogo();
        this.listaEmpresas.setEnabled(true);
        this.listaEmpresas.setVisible(true);
        this.cNombre.setVisible(false);
        this.cNombre.setEnabled(false);
        this.bModificar.setText(Mensajes.getString("modificar"));
        this.bModificar.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/edit.png")));
        this.listaEmpresas.setSelectedIndex(0);
        this.listaEmpresas.requestFocus();
      }
      else {
        JOptionPane.showMessageDialog(getContentPane(), "Ya existe una empresa con ese nombre");
      }
    }
    else
    {
      datos[0] = this.listaEmpresas.getSelectedItem().toString();
      this.empresaM.modificarEmpresa(datos);
    }
  }

  private void borraEmpresa(String empresa)
  {
    if (this.empresaM.borrarEmpresa(empresa)) {
      limpiarDialogo();
      this.listaEmpresas.removeItem(empresa);
      this.listaEmpresas.setSelectedIndex(0);
      this.listaEmpresas.requestFocus();
    } else {
      JOptionPane.showMessageDialog(getContentPane(), Mensajes.getString("empEnUso"));
    }
  }

  private JTextField getCPrejifo()
  {
    if (this.cPrejifo == null) {
      this.cPrejifo = new JTextField();
      this.cPrejifo.setDocument(new DocDiezCarac());
      this.cPrejifo.setToolTipText("<html>" + Mensajes.getString("prefijott1") + "<br>" + Mensajes.getString("prefijott2") + " <b>" + Mensajes.getString("menu33") + "</b>");
    }

    return this.cPrejifo;
  }
  private class Acciones implements ActionListener {
    private Acciones() {
    }
    public void actionPerformed(ActionEvent arg0) {
      Object fuente = arg0.getSource();
      if (fuente == GestionaEmpresas.this.bSalir) {
        GestionaEmpresas.this.dispose();
      } else if (fuente == GestionaEmpresas.this.bModificar) {
        GestionaEmpresas.this.creaCliente();
      } else if (fuente == GestionaEmpresas.this.bBorrar) {
        GestionaEmpresas.this.borraEmpresa(GestionaEmpresas.this.listaEmpresas.getSelectedItem().toString());
      } else if (fuente == GestionaEmpresas.this.bNueva) {
        GestionaEmpresas.this.bModificar.setText(Mensajes.getString("crear"));
        GestionaEmpresas.this.bModificar.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/new.png")));
        GestionaEmpresas.this.esNueva = true;
        GestionaEmpresas.this.limpiarDialogo();
        GestionaEmpresas.this.listaEmpresas.setEnabled(false);
        GestionaEmpresas.this.listaEmpresas.setVisible(false);
        GestionaEmpresas.this.cNombre.setEnabled(true);
        GestionaEmpresas.this.cNombre.setVisible(true);
        GestionaEmpresas.this.cNombre.requestFocus();
      } else if (fuente == GestionaEmpresas.this.listaEmpresas) {
        GestionaEmpresas.this.cambiaEmpresa(GestionaEmpresas.this.listaEmpresas.getSelectedItem().toString());
      }
    }
  }
}

/* Location:        	/media/sda1/contaes4/contaes4.jar
 * Qualified Name:     contaes.empresas.GestionaEmpresas
 * JD-Core Version:    0.6.2
 */