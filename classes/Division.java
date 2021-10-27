/*     */ package classes;
/*     */ 
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import javax.swing.Icon;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.SwingUtilities;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Division
/*     */   extends JPanel
/*     */   implements MouseListener, Comparable<Division>
/*     */ {
/*     */   private JLabel imageLbl;
/*     */   private boolean usingImage;
/*     */   private int divId;
/*     */   private int imageId;
/*     */   private boolean restartSetting;
/*     */   private static ImageManager imageManager;
/*     */   private static int usingImageCount;
/*  33 */   private static int firstImIdClick = -1; private static int lastImIdClick = -1;
/*     */   
/*  35 */   private static final Color QUEST_COLOR = new Color(240, 240, 240);
/*     */   
/*  37 */   private static final Color EQ_COLOR_BG = Color.WHITE;
/*     */ 
/*     */ 
/*     */   
/*     */   public Division(int dId) {
/*  42 */     super(new BorderLayout());
/*     */     
/*  44 */     this.divId = dId;
/*  45 */     addMouseListener(this);
/*     */ 
/*     */     
/*  48 */     if (imageManager == null) {
/*  49 */       imageManager = new ImageManager();
/*     */     }
/*     */     
/*  52 */     this; this.imageId = imageManager.getAvailableImageNumber();
/*     */     
/*  54 */     this
/*     */       
/*  56 */       .imageLbl = new JLabel(new ImageIcon(Division.class.getResource("question-default.png")));
/*  57 */     setBackground(QUEST_COLOR);
/*  58 */     add(this.imageLbl, "Center");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int findDivIndex(int imId) {
/*  66 */     int index = -1;
/*     */     
/*  68 */     for (int i = 0; i < MainPanel.divisions.size(); i++) {
/*     */       
/*  70 */       if (((Division)MainPanel.divisions.get(i)).getImageId() == imId && ((Division)MainPanel.divisions
/*  71 */         .get(i)).getUsingImage()) {
/*     */         
/*  73 */         index = ((Division)MainPanel.divisions.get(i)).getDivId();
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  81 */     return index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setDefaultImage(int dId) {
/*  88 */     ((Division)MainPanel.divisions.get(dId)).setBackground(QUEST_COLOR);
/*     */     
/*  90 */     ((Division)MainPanel.divisions.get(dId)).getImageLbl().setIcon(new ImageIcon(Division.class
/*     */           
/*  92 */           .getResource("question-default.png")));
/*     */ 
/*     */     
/*  95 */     this.imageLbl.setHorizontalAlignment(0);
/*     */ 
/*     */     
/*  98 */     SwingUtilities.updateComponentTreeUI(this);
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
/*     */   private void updateImage() {
/* 125 */     setBackground(new Color(211, 254, 231));
/*     */     
/* 127 */     this; this.imageLbl.setIcon(imageManager
/* 128 */         .getImageById(this.imageId));
/*     */     
/* 130 */     this.imageLbl.setHorizontalAlignment(0);
/*     */ 
/*     */     
/* 133 */     SwingUtilities.updateComponentTreeUI(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void cleanDiv(int dId) {
/* 140 */     ((Division)MainPanel.divisions.get(dId)).setUsingImage(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setEqualsColorBg(int fDivId, int lDivId) {
/* 148 */     ((Division)MainPanel.divisions.get(fDivId)).setBackground(EQ_COLOR_BG);
/* 149 */     ((Division)MainPanel.divisions.get(lDivId)).setBackground(EQ_COLOR_BG);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int findEqualsImIdIndex(int begIndex, int imId) {
/* 155 */     int dvIndex = -1;
/* 156 */     for (int c = begIndex; c < MainPanel.divisions.size(); c++) {
/*     */       
/* 158 */       if (((Division)MainPanel.divisions.get(c)).getImageId() == imId) {
/* 159 */         dvIndex = ((Division)MainPanel.divisions.get(c)).getDivId();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 165 */     return dvIndex;
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
/*     */ 
/*     */ 
/*     */   
/*     */   private void evaluateDivs(final int fImId, final int lImId) {
/* 183 */     Timer timer = new Timer(500, new ActionListener()
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void actionPerformed(ActionEvent actEvent)
/*     */           {
/* 194 */             if (fImId != lImId) {
/*     */               
/* 196 */               Division.this.setDefaultImage(Division.this.findDivIndex(fImId));
/* 197 */               Division.this.setDefaultImage(Division.this.findDivIndex(lImId));
/*     */               
/* 199 */               Division.this.cleanDiv(Division.this.findDivIndex(fImId));
/* 200 */               Division.this.cleanDiv(Division.this.findDivIndex(lImId));
/*     */             }
/*     */             else {
/*     */               
/* 204 */               Division.this.setEqualsColorBg(Division.this.findEqualsImIdIndex(0, fImId), Division.this
/* 205 */                   .findEqualsImIdIndex(Division.this.findDivIndex(lImId) + 1, lImId));
/*     */               
/* 207 */               if (Division.this.isGameEnded())
/*     */               {
/* 209 */                 Division.this.doQuestion();
/*     */               }
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 220 */     timer.setRepeats(false);
/* 221 */     timer.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isGameEnded() {
/* 231 */     boolean regress = true;
/*     */     
/* 233 */     for (int y = 0; y < MainPanel.divisions.size(); y++) {
/*     */       
/* 235 */       if (!((Division)MainPanel.divisions.get(y)).getUsingImage()) {
/* 236 */         regress = false;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 242 */     return regress;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doQuestion() {
/* 249 */     Icon ic = new ImageIcon(Division.class.getResource("question-to-question.png"));
/*     */ 
/*     */     
/* 252 */     int answer = JOptionPane.showConfirmDialog(null, "Do you want restart game?", "Restart?", 0, 3, ic);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 258 */     if (answer == 0) {
/* 259 */       restartGame();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void restartGame() {
/* 270 */     this.restartSetting = true;
/*     */     
/* 272 */     this; imageManager.cleanCounters();
/*     */     
/* 274 */     for (int i = 0; i < MainPanel.divisions.size(); i++) {
/*     */       
/* 276 */       this; ((Division)MainPanel.divisions.get(i)).setImageId(imageManager
/* 277 */           .getAvailableImageNumber());
/* 278 */       ((Division)MainPanel.divisions.get(i)).setUsingImage(false);
/* 279 */       setDefaultImage(i);
/*     */     } 
/*     */ 
/*     */     
/* 283 */     this.restartSetting = false;
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
/*     */ 
/*     */   
/*     */   public void mouseClicked(MouseEvent me) {
/* 300 */     if (!this.restartSetting) {
/*     */       
/* 302 */       this; if (usingImageCount < 2)
/*     */       {
/* 304 */         if (!this.usingImage) {
/*     */           
/* 306 */           updateImage();
/*     */ 
/*     */           
/* 309 */           this.usingImage = true;
/* 310 */           this; usingImageCount++;
/*     */ 
/*     */           
/* 313 */           this; if (usingImageCount == 1)
/* 314 */           { this; firstImIdClick = this.imageId; }
/* 315 */           else { this; if (usingImageCount == 2) {
/* 316 */               this; lastImIdClick = this.imageId;
/*     */             }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 323 */           this; if (usingImageCount == 2) {
/*     */             
/* 325 */             evaluateDivs(firstImIdClick, lastImIdClick);
/* 326 */             this; usingImageCount = 0;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mousePressed(MouseEvent me) {
/* 341 */     if (isGameEnded())
/*     */     {
/* 343 */       doQuestion();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseReleased(MouseEvent me) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseEntered(MouseEvent me) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseExited(MouseEvent me) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsingImage(boolean ui) {
/* 362 */     this.usingImage = ui;
/*     */   }
/*     */   
/*     */   public boolean getUsingImage() {
/* 366 */     return this.usingImage;
/*     */   }
/*     */   
/*     */   public int getDivId() {
/* 370 */     return this.divId;
/*     */   }
/*     */   
/*     */   public void setDivId(int divId) {
/* 374 */     this.divId = divId;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getImageId() {
/* 379 */     return this.imageId;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setImageId(int imageId) {
/* 384 */     this.imageId = imageId;
/*     */   }
/*     */   
/*     */   public JLabel getImageLbl() {
/* 388 */     return this.imageLbl;
/*     */   }
/*     */   
/*     */   public void setImageLbl(JLabel imageLbl) {
/* 392 */     this.imageLbl = imageLbl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(Division anotherDiv) {
/* 401 */     if (getDivId() < anotherDiv.getDivId()) {
/* 402 */       return -1;
/*     */     }
/*     */     
/* 405 */     if (getDivId() > anotherDiv.getDivId()) {
/* 406 */       return 1;
/*     */     }
/*     */     
/* 409 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Isaac\Desktop\MemoryGame.jar!\classes\Division.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */