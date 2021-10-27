/*    */ package classes;
/*    */ 
/*    */ import java.awt.BorderLayout;
/*    */ import java.awt.Color;
/*    */ import java.awt.GridLayout;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import javax.swing.Box;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MainPanel
/*    */   extends JPanel
/*    */ {
/*    */   private Box vertSupportBox;
/*    */   private Box horizSupportBox;
/*    */   private JPanel divPanel;
/*    */   private JScrollPane scSupportPane;
/*    */   public static List<Division> divisions;
/*    */   
/*    */   public MainPanel() {
/* 33 */     this;
/* 34 */     divisions = new ArrayList<>(Arrays.asList(new Division[] { 
/*    */             new Division(0), new Division(1), new Division(2), new Division(3), new Division(4), new Division(5), new Division(6), new Division(7), new Division(8), new Division(9), 
/*    */             new Division(10), new Division(11), new Division(12), new Division(13), new Division(14), new Division(15) }));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 42 */     this; Collections.sort(divisions);
/* 43 */     setLayout(new BorderLayout());
/*    */     
/* 45 */     setBackground(new Color(116, 216, 224));
/*    */ 
/*    */     
/* 48 */     setDivPanel();
/* 49 */     setSupportBoxes();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setSupportBoxes() {
/* 56 */     this.horizSupportBox = Box.createHorizontalBox();
/* 57 */     this.horizSupportBox.add(Box.createHorizontalStrut(50));
/* 58 */     this.horizSupportBox.add(this.divPanel);
/* 59 */     this.horizSupportBox.add(Box.createHorizontalStrut(50));
/*    */     
/* 61 */     this.vertSupportBox = Box.createVerticalBox();
/* 62 */     this.vertSupportBox.add(Box.createVerticalStrut(50));
/* 63 */     this.vertSupportBox.add(this.horizSupportBox);
/* 64 */     this.vertSupportBox.add(Box.createVerticalStrut(50));
/*    */     
/* 66 */     this.scSupportPane = new JScrollPane(20, 31);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 71 */     this.scSupportPane.setViewportView(this.vertSupportBox);
/* 72 */     this.scSupportPane.getViewport().setBackground(new Color(116, 216, 224));
/*    */     
/* 74 */     add(this.scSupportPane);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDivPanel() {
/* 81 */     this.divPanel = new JPanel(new GridLayout(4, 4, 50, 50));
/*    */     
/* 83 */     this.divPanel.setBackground(new Color(116, 216, 224));
/*    */     
/* 85 */     for (int i = 0; i < divisions.size(); i++)
/*    */     {
/* 87 */       this.divPanel.add(divisions.get(i));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Isaac\Desktop\MemoryGame.jar!\classes\MainPanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */