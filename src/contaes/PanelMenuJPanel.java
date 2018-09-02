/*     */ package contaes;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.awt.Container;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.util.ResourceBundle;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JPanel;
/*     */ import org.jdesktop.swingx.JXHyperlink;
/*     */ import org.jdesktop.swingx.JXTaskPane;
/*     */ import org.jdesktop.swingx.JXTaskPaneContainer;
/*     */ 
/*     */ public class PanelMenuJPanel extends JPanel
/*     */   implements ActionListener
/*     */ {
/*     */   private JButton jButton1;
/*     */   private JXHyperlink jXHyperlink1;
/*     */   private JXHyperlink jXHyperlink10;
/*     */   private JXHyperlink jXHyperlink11;
/*     */   private JXHyperlink jXHyperlink12;
/*     */   private JXHyperlink jXHyperlink13;
/*     */   private JXHyperlink jXHyperlink14;
/*     */   private JXHyperlink jXHyperlink15;
/*     */   private JXHyperlink jXHyperlink16;
/*     */   private JXHyperlink jXHyperlink17;
/*     */   private JXHyperlink jXHyperlink18;
/*     */   private JXHyperlink jXHyperlink19;
/*     */   private JXHyperlink jXHyperlink2;
/*     */   private JXHyperlink jXHyperlink20;
/*     */   private JXHyperlink jXHyperlink21;
/*     */   private JXHyperlink jXHyperlink22;
/*     */   private JXHyperlink jXHyperlink23;
/*     */   private JXHyperlink jXHyperlink24;
/*     */   private JXHyperlink jXHyperlink25;
/*     */   private JXHyperlink jXHyperlink26;
/*     */   private JXHyperlink jXHyperlink27;
/*     */   private JXHyperlink jXHyperlink28;
/*     */   private JXHyperlink jXHyperlink29;
/*     */   private JXHyperlink jXHyperlink3;
/*     */   private JXHyperlink jXHyperlink30;
/*     */   private JXHyperlink jXHyperlink31;
/*     */   private JXHyperlink jXHyperlink32;
/*     */   private JXHyperlink jXHyperlink33;
/*     */   private JXHyperlink jXHyperlink34;
/*     */   private JXHyperlink jXHyperlink35;
/*     */   private JXHyperlink jXHyperlink36;
/*     */   private JXHyperlink jXHyperlink37;
/*     */   private JXHyperlink jXHyperlink38;
/*     */   private JXHyperlink jXHyperlink39;
/*     */   private JXHyperlink jXHyperlink4;
/*     */   private JXHyperlink jXHyperlink40;
/*     */   private JXHyperlink jXHyperlink41;
/*     */   private JXHyperlink jXHyperlink42;
/*     */   private JXHyperlink jXHyperlink43;
/*     */   private JXHyperlink jXHyperlink5;
/*     */   private JXHyperlink jXHyperlink6;
/*     */   private JXHyperlink jXHyperlink7;
/*     */   private JXHyperlink jXHyperlink8;
/*     */   private JXHyperlink jXHyperlink9;
/*     */   private JXTaskPane jXTaskPane1;
/*     */   private JXTaskPane jXTaskPane2;
/*     */   private JXTaskPane jXTaskPane3;
/*     */   private JXTaskPane jXTaskPane4;
/*     */   private JXTaskPane jXTaskPane5;
/*     */   private JXTaskPane jXTaskPane6;
/*     */   private JXTaskPane jXTaskPane7;
/*     */   private JXTaskPane jXTaskPane8;
/*     */   private JXTaskPaneContainer jXTaskPaneContainer1;
/*     */ 
/*     */   public PanelMenuJPanel()
/*     */   {
/*  69 */     initComponents();
/*     */   }
/*     */ 
/*     */   public int[] saveState() {
/*  73 */     int[] statePanel = new int[8];
/*  74 */     statePanel[0] = (this.jXTaskPane1.isCollapsed() ? 0 : 1);
/*  75 */     statePanel[1] = (this.jXTaskPane2.isCollapsed() ? 0 : 1);
/*  76 */     statePanel[2] = (this.jXTaskPane3.isCollapsed() ? 0 : 1);
/*  77 */     statePanel[3] = (this.jXTaskPane4.isCollapsed() ? 0 : 1);
/*  78 */     statePanel[4] = (this.jXTaskPane5.isCollapsed() ? 0 : 1);
/*  79 */     statePanel[5] = (this.jXTaskPane6.isCollapsed() ? 0 : 1);
/*  80 */     statePanel[6] = (this.jXTaskPane7.isCollapsed() ? 0 : 1);
/*  81 */     statePanel[7] = (this.jXTaskPane8.isCollapsed() ? 0 : 1);
/*  82 */     return statePanel;
/*     */   }
/*     */ 
/*     */   public void readState(int[] statePanel)
/*     */   {
/*  93 */     this.jXTaskPane1.setCollapsed(statePanel[0] == 0);
/*  94 */     this.jXTaskPane2.setCollapsed(statePanel[1] == 0);
/*  95 */     this.jXTaskPane3.setCollapsed(statePanel[2] == 0);
/*  96 */     this.jXTaskPane4.setCollapsed(statePanel[3] == 0);
/*  97 */     this.jXTaskPane5.setCollapsed(statePanel[4] == 0);
/*  98 */     this.jXTaskPane6.setCollapsed(statePanel[5] == 0);
/*  99 */     this.jXTaskPane7.setCollapsed(statePanel[6] == 0);
/* 100 */     this.jXTaskPane8.setCollapsed(statePanel[7] == 0);
/*     */   }
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 112 */     this.jXTaskPaneContainer1 = new JXTaskPaneContainer();
/* 113 */     this.jButton1 = new JButton();
/* 114 */     this.jXTaskPane1 = new JXTaskPane();
/* 115 */     this.jXHyperlink1 = new JXHyperlink();
/* 116 */     this.jXHyperlink2 = new JXHyperlink();
/* 117 */     this.jXHyperlink3 = new JXHyperlink();
/* 118 */     this.jXHyperlink4 = new JXHyperlink();
/* 119 */     this.jXHyperlink5 = new JXHyperlink();
/* 120 */     this.jXHyperlink41 = new JXHyperlink();
/* 121 */     this.jXTaskPane2 = new JXTaskPane();
/* 122 */     this.jXHyperlink27 = new JXHyperlink();
/* 123 */     this.jXHyperlink6 = new JXHyperlink();
/* 124 */     this.jXHyperlink7 = new JXHyperlink();
/* 125 */     this.jXHyperlink8 = new JXHyperlink();
/* 126 */     this.jXHyperlink9 = new JXHyperlink();
/* 127 */     this.jXTaskPane3 = new JXTaskPane();
/* 128 */     this.jXHyperlink10 = new JXHyperlink();
/* 129 */     this.jXHyperlink11 = new JXHyperlink();
/* 130 */     this.jXHyperlink12 = new JXHyperlink();
/* 131 */     this.jXHyperlink13 = new JXHyperlink();
/* 132 */     this.jXHyperlink14 = new JXHyperlink();
/* 133 */     this.jXHyperlink42 = new JXHyperlink();
/* 134 */     this.jXHyperlink43 = new JXHyperlink();
/* 135 */     this.jXTaskPane7 = new JXTaskPane();
/* 136 */     this.jXHyperlink20 = new JXHyperlink();
/* 137 */     this.jXHyperlink21 = new JXHyperlink();
/* 138 */     this.jXHyperlink22 = new JXHyperlink();
/* 139 */     this.jXHyperlink23 = new JXHyperlink();
/* 140 */     this.jXHyperlink24 = new JXHyperlink();
/* 141 */     this.jXHyperlink25 = new JXHyperlink();
/* 142 */     this.jXHyperlink26 = new JXHyperlink();
/* 143 */     this.jXTaskPane6 = new JXTaskPane();
/* 144 */     this.jXHyperlink30 = new JXHyperlink();
/* 145 */     this.jXHyperlink31 = new JXHyperlink();
/* 146 */     this.jXHyperlink32 = new JXHyperlink();
/* 147 */     this.jXHyperlink33 = new JXHyperlink();
/* 148 */     this.jXHyperlink34 = new JXHyperlink();
/* 149 */     this.jXTaskPane4 = new JXTaskPane();
/* 150 */     this.jXHyperlink15 = new JXHyperlink();
/* 151 */     this.jXHyperlink16 = new JXHyperlink();
/* 152 */     this.jXHyperlink17 = new JXHyperlink();
/* 153 */     this.jXHyperlink18 = new JXHyperlink();
/* 154 */     this.jXTaskPane5 = new JXTaskPane();
/* 155 */     this.jXHyperlink19 = new JXHyperlink();
/* 156 */     this.jXHyperlink28 = new JXHyperlink();
/* 157 */     this.jXHyperlink35 = new JXHyperlink();
/* 158 */     this.jXHyperlink29 = new JXHyperlink();
/* 159 */     this.jXHyperlink36 = new JXHyperlink();
/* 160 */     this.jXTaskPane8 = new JXTaskPane();
/* 161 */     this.jXHyperlink39 = new JXHyperlink();
/* 162 */     this.jXHyperlink40 = new JXHyperlink();
/* 163 */     this.jXHyperlink37 = new JXHyperlink();
/* 164 */     this.jXHyperlink38 = new JXHyperlink();
/*     */ 
/* 166 */     setBackground(new Color(69, 105, 170));
/*     */ 
/* 168 */     this.jXTaskPaneContainer1.setBackground(new Color(69, 105, 170));
/*     */ 
/* 170 */     this.jButton1.setFont(new Font("Lucida Grande", 1, 13));
/* 171 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/cache.png")));
/* 172 */     this.jButton1.setText("Reportes dados");
/* 173 */     this.jButton1.setActionCommand("controlcentre");
/* 174 */     this.jButton1.setHorizontalAlignment(2);
/* 175 */     this.jButton1.addActionListener(this);
/* 176 */     this.jXTaskPaneContainer1.add(this.jButton1);

/* 214 */     ResourceBundle bundle = ResourceBundle.getBundle("internationalization/Mensajes");
/*     */ 
/* 360 */     this.jXTaskPane6.setCollapsed(true);
/* 361 */     this.jXTaskPane6.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/Mlistado.png")));
/* 362 */     this.jXTaskPane6.setTitle("Sucursales");
/*     */ 
/* 364 */     this.jXHyperlink30.setClickedColor(new Color(0, 51, 255));
/* 365 */     this.jXHyperlink30.setText("1.-14 de septiembre ");
/* 366 */     this.jXHyperlink30.setActionCommand("resumenclientes");
/* 367 */     this.jXHyperlink30.addActionListener(this);
/* 368 */     this.jXTaskPane6.getContentPane().add(this.jXHyperlink30);
/*     */ 
/* 370 */     this.jXHyperlink31.setClickedColor(new Color(0, 51, 255));
/* 371 */     this.jXHyperlink31.setText("2.-Fortaleza");
/* 372 */     this.jXHyperlink31.setActionCommand("resumenproveedores");
/* 373 */     this.jXHyperlink31.addActionListener(this);
/* 374 */     this.jXTaskPane6.getContentPane().add(this.jXHyperlink31);
/*     */ 
/* 376 */     this.jXHyperlink32.setClickedColor(new Color(0, 51, 255));
/* 377 */     this.jXHyperlink32.setText(bundle.getString("distribucionPartidas"));
/* 378 */     this.jXHyperlink32.setActionCommand("distribucionpartidas");
/* 379 */     this.jXHyperlink32.addActionListener(this);
/* 380 */     this.jXTaskPane6.getContentPane().add(this.jXHyperlink32);
/*     */ 
/* 382 */     this.jXHyperlink33.setClickedColor(new Color(0, 51, 255));
/* 383 */     this.jXHyperlink33.setText(bundle.getString("origenDestinoMenu"));
/* 384 */     this.jXHyperlink33.setActionCommand("origenesDestinos");
/* 385 */     this.jXHyperlink33.addActionListener(this);
/* 386 */     this.jXTaskPane6.getContentPane().add(this.jXHyperlink33);
/*     */ 
/* 388 */     this.jXHyperlink34.setClickedColor(new Color(0, 51, 255));
/* 389 */     this.jXHyperlink34.setText(bundle.getString("ratios"));
/* 390 */     this.jXHyperlink34.setActionCommand("ratios");
/* 391 */     this.jXHyperlink34.addActionListener(this);
/* 392 */     this.jXTaskPane6.getContentPane().add(this.jXHyperlink34);
/*     */ 
/* 394 */     this.jXTaskPaneContainer1.add(this.jXTaskPane6);
/*     */ 
/* 426 */     this.jXTaskPane5.setCollapsed(true);
/* 427 */     this.jXTaskPane5.setIcon(new ImageIcon(getClass().getResource("/contaes/iconos/producto18.png")));
/* 428 */     this.jXTaskPane5.setTitle("Resumen Diario");
/*     */ 
/* 436 */     this.jXHyperlink28.setClickedColor(new Color(0, 51, 255));
/* 437 */     this.jXHyperlink28.setText(bundle.getString("pedidosProveedores"));
/* 438 */     this.jXHyperlink28.setActionCommand("pedidosproveedores");
/* 439 */     this.jXHyperlink28.addActionListener(this);
/* 440 */     this.jXTaskPane5.getContentPane().add(this.jXHyperlink28);
/*     */ 
/* 442 */     this.jXHyperlink35.setClickedColor(new Color(0, 51, 255));
/* 443 */     this.jXHyperlink35.setText(bundle.getString("pedidosClientes"));
/* 444 */     this.jXHyperlink35.setActionCommand("pedidosclientes");
/* 445 */     this.jXHyperlink35.addActionListener(this);
/* 446 */     this.jXTaskPane5.getContentPane().add(this.jXHyperlink35);
/*     */ 
/* 448 */     this.jXHyperlink29.setClickedColor(new Color(0, 51, 255));
/* 449 */     this.jXHyperlink29.setText("ingreso a caja y de ventas");
/* 450 */     this.jXHyperlink29.setActionCommand("listadosalmacen");
/* 451 */     this.jXHyperlink29.addActionListener(this);
/* 452 */     this.jXTaskPane5.getContentPane().add(this.jXHyperlink29);
/*     */ 
/* 454 */     this.jXHyperlink36.setClickedColor(new Color(0, 51, 255));
/* 455 */     this.jXHyperlink36.setText(bundle.getString("almacenes"));
/* 456 */     this.jXHyperlink36.setActionCommand("almacenes");
/* 457 */     this.jXHyperlink36.addActionListener(this);
/* 458 */     this.jXTaskPane5.getContentPane().add(this.jXHyperlink36);
/*     */ 
/* 460 */     this.jXTaskPaneContainer1.add(this.jXTaskPane5);
/*     */ 
/* 462 */     this.jXTaskPane8.setTitle(bundle.getString("postitle"));
/*     */ 
/* 490 */     add(this.jXTaskPaneContainer1);
/*     */   }
/*     */ 
/*     */   private void jXHyperlink20ActionPerformed(ActionEvent evt)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 554 */     String cmd = e.getActionCommand();
/* 555 */     Inicio.frame.realizarAccion(cmd);
/*     */   }
/*     */ }

/* Location:           /media/sda1/contaes4/contaes4.jar
 * Qualified Name:     contaes.PanelMenuJPanel
 * JD-Core Version:    0.6.2
 */