package contaes.empresas;

import contaes.Inicio;
import contaes.Puente;
import contaes.manejoDatos.auxiliar.ConfiguracionBean;
import internationalization.Mensajes;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import pos.view.UserPasswordJDialog;

public class UsuariosJDialog extends JDialog
{
  private ArrayList<String> nombres = new ArrayList();
  private ArrayList<String> contras = new ArrayList();
  private ArrayList<String> dirip = new ArrayList();
  DesEncrypter encrypter = new DesEncrypter("juanmiguel");
  private boolean modoPOS = false;
  private JButton Borrar;
  private JPasswordField cPassword;
  private JTextField cdirIP;
  private JButton jButton1;
  private JComboBox jComboBox1;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JButton seleccionar;

  public UsuariosJDialog(boolean modoPOS)
  {
     super(new Frame(), true);
     this.modoPOS = modoPOS;
     initComponents();
     llenarListaUsuarios();
     this.jComboBox1.setSelectedIndex(0);
     this.cdirIP.setText((String)this.dirip.get(0));
     if (modoPOS) {
       this.jLabel2.setText("");
       this.cPassword.setEnabled(false);
       this.cPassword.setVisible(false);
       this.jButton1.setEnabled(false);
    }
    else
    {
       this.cPassword.requestFocus();
    }
  }

  public static void seleccionDeUsuario(boolean modoPOS) {
     UsuariosJDialog dlg = new UsuariosJDialog(modoPOS);
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     Dimension frameSize = dlg.getSize();
     if (frameSize.height > screenSize.height) {
       frameSize.height = screenSize.height;
    }
     if (frameSize.width > screenSize.width) {
       frameSize.width = screenSize.width;
    }
     dlg.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

     dlg.pack();
     dlg.setVisible(true);
  }

  private void llenarListaUsuarios()
  {
     ConfiguracionBean config = new ConfiguracionBean();
     this.nombres = config.getConfig("<usuarios>");
     ArrayList contrasE = config.getConfig("<controles>");
     this.dirip = config.getConfig("<direccionip>");

     this.jComboBox1.removeAllItems();

     for (String string : this.nombres) {
       this.jComboBox1.addItem(string);
    }
     for (String string :(List<String>)  contrasE)
       this.contras.add(this.encrypter.decrypt(string));
  }

  private void addUsuario()
  {
     CrearUsuarioJDialog dlg = new CrearUsuarioJDialog(null, true);
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     Dimension frameSize = dlg.getSize();
     if (frameSize.height > screenSize.height) {
       frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    dlg.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    dlg.pack();
    dlg.setVisible(true);
    if (dlg.isCrear()) {
      String nombre = dlg.getUsuario();
      String password = dlg.getContras();
      String direccion = dlg.getDirIP();
      this.nombres.add(nombre);
      this.jComboBox1.addItem(nombre);
      this.contras.add(new String(password));
      this.dirip.add(direccion);
      guardarLista();
    }
  }

  private void seleccionarUsuario()
  {
    if (!aceptar()) {
      JOptionPane.showMessageDialog(getContentPane(), Mensajes.getString("usuEt3"));

      this.cPassword.setText("");
    } else {
      dispose();
    }
  }

  private boolean aceptar()
  {
    String passw = "";
    if (this.modoPOS) {
      passw = UserPasswordJDialog.obtenerObjeto(new Frame(), true);
    }
    else {
      char[] contr = null;
      try {
        contr = this.cPassword.getPassword();
      } catch (NullPointerException nexc) {
        nexc.printStackTrace();
      }

      if (contr != null) {
        passw = new String(contr);
      }
    }
    String nombreUsuario = this.jComboBox1.getSelectedItem().toString();
    String direccionIP = this.cdirIP.getText();
    if (((String)this.contras.get(this.jComboBox1.getSelectedIndex())).equals(passw)) {
      Inicio.p.setUsuario(nombreUsuario);
      Inicio.p.setPassword(passw);
      Inicio.p.setDireccionIP(direccionIP);
      return true;
    }
    return false;
  }

  private void borrarUsuario()
  {
    if (this.jComboBox1.getItemCount() <= 1) {
      JOptionPane.showMessageDialog(getContentPane(), "La lista de usuarios no puede quedar vacía", Mensajes.getString("informacion"), 0);

      return;
    }
    int confirma = JOptionPane.showConfirmDialog(getContentPane(), Mensajes.getString("usuEt4") + "\n" + Mensajes.getString("usuEt5"), Mensajes.getString("confirma"), 0);

    if (confirma == 0) {
      int index = this.jComboBox1.getSelectedIndex();
      this.jComboBox1.removeItemAt(index);
      this.nombres.remove(index);
      this.contras.remove(index);
      this.dirip.remove(index);
      guardarLista();
    }
  }

  private void guardarLista()
  {
    ArrayList contraE = new ArrayList();

    for (String string : this.contras) {
      contraE.add(this.encrypter.encrypt(string));
    }
    ConfiguracionBean config = new ConfiguracionBean();
    config.saveConfig("<usuarios>", this.nombres);
    config.saveConfig("<controles>", contraE);
    config.saveConfig("<direccionip>", this.dirip);
  }

  private void initComponents()
  {
    this.jPanel1 = new JPanel();
    this.jLabel1 = new JLabel();
    this.jComboBox1 = new JComboBox();
    this.jLabel2 = new JLabel();
    this.cPassword = new JPasswordField();
    this.jLabel3 = new JLabel();
    this.cdirIP = new JTextField();
    this.seleccionar = new JButton();
    this.jPanel2 = new JPanel();
    this.jButton1 = new JButton();
    this.Borrar = new JButton();

    setDefaultCloseOperation(2);
    ResourceBundle bundle = ResourceBundle.getBundle("internationalization/Mensajes");
    setTitle(bundle.getString("welcome"));

    this.jPanel1.setBorder(BorderFactory.createEtchedBorder());

    this.jLabel1.setText(bundle.getString("usuario"));

    this.jComboBox1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        UsuariosJDialog.this.jComboBox1ActionPerformed(evt);
      }
    });
    this.jLabel2.setText(bundle.getString("passw"));

    this.cPassword.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent evt) {
        UsuariosJDialog.this.cPasswordKeyPressed(evt);
      }
    });
    this.jLabel3.setText(bundle.getString("DirIP"));

    this.seleccionar.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/apply.png")));
    this.seleccionar.setText(bundle.getString("seleccionar"));
    this.seleccionar.setHorizontalTextPosition(2);
    this.seleccionar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        UsuariosJDialog.this.seleccionarActionPerformed(evt);
      }
    });
    this.jPanel2.setBorder(BorderFactory.createEtchedBorder());

    this.jButton1.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/new.png")));
    this.jButton1.setText(bundle.getString("add"));
    this.jButton1.setHorizontalTextPosition(2);
    this.jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        UsuariosJDialog.this.jButton1ActionPerformed(evt);
      }
    });
    this.Borrar.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/delete.png")));
    this.Borrar.setText(bundle.getString("borrar"));
    this.Borrar.setHorizontalTextPosition(2);
    this.Borrar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        UsuariosJDialog.this.BorrarActionPerformed(evt);
      }
    });
    GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
    this.jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, 32767).addComponent(this.Borrar).addContainerGap()));

    jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.Borrar)).addContainerGap(-1, 32767)));

    GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
    this.jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1).addComponent(this.jLabel3)).addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jComboBox1, 0, -1, 32767).addComponent(this.cPassword).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.cdirIP, -2, 143, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.seleccionar)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2))).addContainerGap(19, 32767)));

    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jComboBox1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.cPassword, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.cdirIP, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.seleccionar).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addGap(105, 105, 105)));

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 235, -2).addContainerGap(-1, 32767)));

    pack();
  }

  private void jButton1ActionPerformed(ActionEvent evt) {
    addUsuario();
  }

  private void jComboBox1ActionPerformed(ActionEvent evt) {
    int indice = this.jComboBox1.getSelectedIndex();
    if (indice != -1) {
      this.cdirIP.setText((String)this.dirip.get(indice));
      this.cPassword.setText("");
      this.cPassword.requestFocusInWindow();
    }
  }

  private void seleccionarActionPerformed(ActionEvent evt) {
    seleccionarUsuario();
  }

  private void BorrarActionPerformed(ActionEvent evt) {
    borrarUsuario();
  }

  private void cPasswordKeyPressed(KeyEvent evt) {
    if (evt.getKeyCode() == 10)
      seleccionarUsuario();
  }
}

/*Location:          	/media/sda1/contaes4/contaes4.jar
 * Qualified Name:     	contaes.empresas.UsuariosJDialog
 * JD-Core Version:    	0.6.2
 */