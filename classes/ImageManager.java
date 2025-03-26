/*     */ package classes;
/*     */ 
/*     */ import java.util.Random;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImageManager
/*     */ {
/*  28 */   private Random rand = new Random();
/*  29 */   private int[] counters = new int[8];
/*     */   
/*     */   private static final int COMPUTER = 0;
/*     */   private static final int CSS = 1;
/*     */   
/*     */   public Icon getImageById(int imId) {
/*  35 */     Icon im = null;
/*     */     
/*  37 */     switch (imId) {
/*     */ 
/*     */       
/*     */       case 0:
/*  41 */         im = new ImageIcon(ImageManager.class.getResource("computer.png"));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 1:
/*  46 */         im = new ImageIcon(ImageManager.class.getResource("css.png"));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/*  51 */         im = new ImageIcon(ImageManager.class.getResource("game.png"));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/*  56 */         im = new ImageIcon(ImageManager.class.getResource("html.png"));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 4:
/*  61 */         im = new ImageIcon(ImageManager.class.getResource("java.png"));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 5:
/*  66 */         im = new ImageIcon(ImageManager.class.getResource("js.png"));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 6:
/*  71 */         im = new ImageIcon(ImageManager.class.getResource("math.png"));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 7:
/*  76 */         im = new ImageIcon(ImageManager.class.getResource("web.png"));
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/*  81 */     return im;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int GAME = 2;
/*     */   private static final int HTML = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int JAVA = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int JS = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MATH = 6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int WEB = 7;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean countersAllow() {
/* 164 */     boolean allowed = false;
/*     */     
/* 166 */     for (int counter : this.counters) {
/*     */       
/* 168 */       if (counter < 2) {
/* 169 */         allowed = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 175 */     return allowed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAvailableImageNumber() {
/*     */     int beginning;
/*     */     do {
/* 186 */       beginning = this.rand.nextInt(8);
/*     */     }
/* 188 */     while (this.counters[beginning] >= 2);
/*     */     
/* 190 */     this.counters[beginning] = this.counters[beginning] + 1;
/*     */     
/* 192 */     return beginning;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cleanCounters() {
/* 198 */     for (int i = 0; i < this.counters.length; i++)
/* 199 */       this.counters[i] = 0; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Isaac\Desktop\MemoryGame.jar!\classes\ImageManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */