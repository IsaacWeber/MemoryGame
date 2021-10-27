/*    */ package classes;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import java.awt.Toolkit;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.SwingUtilities;
/*    */ import javax.swing.UIManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MainFrame
/*    */   extends JFrame
/*    */ {
/*    */   public MainFrame() {
/* 19 */     super("Memory Game - Main Frame");
/*    */ 
/*    */     
/* 22 */     setDefaultCloseOperation(3);
/* 23 */     setLKF("Nimbus");
/* 24 */     setIconImage(
/* 25 */         Toolkit.getDefaultToolkit().getImage(MainFrame.class
/* 26 */           .getResource("elephant-img.png")));
/* 27 */     setExtendedState(6);
/* 28 */     setSize(800, 600);
/* 29 */     setLocationRelativeTo((Component)null);
/* 30 */     setVisible(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void init() {
/* 38 */     MainPanel mPanel = new MainPanel();
/* 39 */     add(mPanel);
/*    */     
/* 41 */     SwingUtilities.updateComponentTreeUI(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void setLKF(String lkName) {
/* 49 */     for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
/*    */       
/* 51 */       if (info.getName().equals(lkName))
/*    */         
/*    */         try {
/*    */           
/* 55 */           UIManager.setLookAndFeel(info.getClassName());
/*    */         }
/* 57 */         catch (Exception excpt) {
/* 58 */           System.out.println("entered");
/*    */         }  
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Isaac\Desktop\MemoryGame.jar!\classes\MainFrame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */