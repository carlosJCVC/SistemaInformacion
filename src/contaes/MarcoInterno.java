/*    */ package contaes;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.net.URL;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JInternalFrame;
/*    */ 
/*    */ public abstract class MarcoInterno extends JInternalFrame
/*    */ {
/*    */   public MarcoInterno(String titulo)
/*    */   {
/* 12 */     super(titulo, true, true, true, true);
/* 13 */     setDefaultCloseOperation(2);
/*    */   }
/*    */ 
/*    */   protected static ImageIcon createImageIcon(String path) {
/* 17 */     URL imgURL = MarcoInternoAsientosFacturas.class.getResource(path);
/* 18 */     if (imgURL != null) {
/* 19 */       return new ImageIcon(imgURL);
/*    */     }
/* 21 */     System.err.println("Couldn't find file: " + path);
/* 22 */     return null;
/*    */   }
/*    */ 
/*    */   public abstract void cerrarConexion();
/*    */ }

/* Location:           /media/sda1/contaes4/contaes4.jar
 * Qualified Name:     contaes.MarcoInterno
 * JD-Core Version:    0.6.2
 */