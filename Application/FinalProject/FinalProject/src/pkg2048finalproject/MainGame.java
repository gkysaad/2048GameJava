/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048finalproject;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George-Kirollos Saad
 * Date : August 21, 2018
 * This is the JFrame file with the main components of the game.
 * 
 */
public class MainGame extends javax.swing.JFrame {
    //Creates 2 arrays and declares and initializes the score variable.
    JLabel [][] tilesArray = new JLabel [4][4];
    static Tiles [][] infoArray = new Tiles [4][4];
    int intScore = 0;
    boolean isFirst = true;
          
    //Stores image files in variables.
    ImageIcon img0 = new ImageIcon("img0.png");
    ImageIcon img1 = new ImageIcon("img1.png");
    ImageIcon img2 = new ImageIcon("img2.png");
    ImageIcon img3 = new ImageIcon("img3.png");
    ImageIcon img4 = new ImageIcon("img4.png");
    
    
    /**
     * This is a method that fills the tiles Array with the tiles labels and the info array with tiles.
     */
    public void runFirst(){
        if (isFirst){
            tilesArray [0][0] = lbl1;
            tilesArray [0][1] = lbl2;
            tilesArray [0][2] = lbl3;
            tilesArray [0][3] = lbl4;
            tilesArray [1][0] = lbl5;
            tilesArray [1][1] = lbl6;
            tilesArray [1][2] = lbl7;
            tilesArray [1][3] = lbl8;
            tilesArray [2][0] = lbl9;
            tilesArray [2][1] = lbl10;
            tilesArray [2][2] = lbl11;
            tilesArray [2][3] = lbl12;
            tilesArray [3][0] = lbl13;
            tilesArray [3][1] = lbl14;
            tilesArray [3][2] = lbl15;
            tilesArray [3][3] = lbl16;
            //Creates tile objects and populates the tile objects array with them.
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    infoArray[i][j] = new Tiles();
                }
            }
        }
        
    }
    /**
     * This function calls the getColourCategory method for each tile to get the colour
     * that the tile should be. It then uses this data to change the icon for each tile 
     * to match the desired colour.
     */    
    public void setTileColours(){
        //Loops through all of the labels, changing the icon based on the getColourCategory method.
        for (int intRow =0; intRow <= 3; intRow++){
                for (int intCol = 0; intCol <= 3; intCol++){
                    int intCategory = infoArray[intRow][intCol].getColourCategory();
                    switch (intCategory){
                        case 0:
                            tilesArray[intRow][intCol].setIcon(img0);
                            break;
                        case 1:
                            tilesArray[intRow][intCol].setIcon(img1);
                            break;
                        case 2:
                            tilesArray[intRow][intCol].setIcon(img2);
                            break;
                        case 3:
                            tilesArray[intRow][intCol].setIcon(img3);
                            break;
                        case 4:
                            tilesArray[intRow][intCol].setIcon(img4);
                            break;
                        default:
                            tilesArray[intRow][intCol].setIcon(new ImageIcon("tileBackground.png"));
                    }                    
                }
            }
    }
    
    /**
     * This function loops through all of the tiles until it finds an empty one.
     * @return a boolean. True if all tiles are filled, false if there is an empty tile.
     */
    public boolean checkGameOver(){
        //Loops through all of the tiles.
        for (int intRow = 0; intRow < 4; intRow++){
            for (int intCol = 0; intCol < 4; intCol++){
                if (infoArray[intRow][intCol].getValue() == 0){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * This function saves the score to a text file and resets the infoArray of tiles.
     */
    public void runGameOver(){
        try {
            //Saves score to score.txt file.
            FileWriter fileWriter = new FileWriter("score.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(intScore);
            printWriter.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Loops through tiles array to set all values to 0.
        for (int intRow = 0; intRow <= 3; intRow++){
            for (int intCol = 0; intCol <= 3; intCol++){
                infoArray[intRow][intCol].setValue(0);
            }
        }
        //Creates a new game screen and sets it visible.
        GameOverScreen endScreen = new GameOverScreen();
        endScreen.setVisible(true);
        //Closes the current screen.
        this.dispose();
    }
    /**
     * Creates new form MainGame
     */
    public MainGame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        lbl14 = new javax.swing.JLabel();
        lbl15 = new javax.swing.JLabel();
        lbl16 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblDes = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        panelMain.setBackground(new java.awt.Color(204, 204, 255));
        panelMain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbl1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl1.setForeground(new java.awt.Color(51, 0, 153));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl1.setToolTipText("");
        lbl1.setFocusable(false);
        lbl1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl2.setForeground(new java.awt.Color(51, 0, 153));
        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl3.setForeground(new java.awt.Color(51, 0, 153));
        lbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl3.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl4.setForeground(new java.awt.Color(51, 0, 153));
        lbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl4.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl5.setForeground(new java.awt.Color(51, 0, 153));
        lbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl5.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl6.setForeground(new java.awt.Color(51, 0, 153));
        lbl6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl6.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl7.setForeground(new java.awt.Color(51, 0, 153));
        lbl7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl7.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl8.setForeground(new java.awt.Color(51, 0, 153));
        lbl8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl8.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl9.setForeground(new java.awt.Color(51, 0, 153));
        lbl9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl9.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl9.setToolTipText("");
        lbl9.setFocusable(false);
        lbl9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl10.setForeground(new java.awt.Color(51, 0, 153));
        lbl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl10.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl11.setForeground(new java.awt.Color(51, 0, 153));
        lbl11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl11.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl12.setForeground(new java.awt.Color(51, 0, 153));
        lbl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl12.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl13.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl13.setForeground(new java.awt.Color(51, 0, 153));
        lbl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl13.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl14.setForeground(new java.awt.Color(51, 0, 153));
        lbl14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl14.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl15.setForeground(new java.awt.Color(51, 0, 153));
        lbl15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl15.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl16.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbl16.setForeground(new java.awt.Color(51, 0, 153));
        lbl16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl16.setIcon(new javax.swing.ImageIcon("C:\\Users\\georg\\OneDrive\\Documents\\IB Documents\\ICS4U\\FinalProject\\tileBackground.png")); // NOI18N
        lbl16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTitle.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(51, 0, 153));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("2048");

        lblDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDes.setText("To start, click an arrow key. To move the tiles, click an arrow key.");

        lblScore.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblScore.setText("Score: 0");

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl13)
                            .addComponent(lbl9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(lbl10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl12))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(lbl14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl16))))
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(lbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl4))
                            .addGroup(panelMainLayout.createSequentialGroup()
                                .addComponent(lbl6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl8)))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl4)
                    .addComponent(lbl1)
                    .addComponent(lbl3)
                    .addComponent(lbl2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl5)
                    .addComponent(lbl6)
                    .addComponent(lbl8)
                    .addComponent(lbl7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl12)
                    .addComponent(lbl9)
                    .addComponent(lbl11)
                    .addComponent(lbl10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl13)
                    .addComponent(lbl14)
                    .addComponent(lbl16)
                    .addComponent(lbl15))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        //Moves tiles to the left if the left arrow key is released
        if (evt.getKeyCode() == evt.VK_LEFT){
            runFirst();
            isFirst = false;
            //Loops through each tile
            for (int intRow =0; intRow <= 3; intRow++){
                for (int intCol = 0; intCol <= 3; intCol++){
                    int intCurrent = infoArray[intRow][intCol].getValue();
                    int intMove = intCol;
                    //Checks the tiles left of the current one and moves the tile
                    //to the first empty one or doubles the tile and moves it to 
                    //the first identical tile.
                    if (intCurrent != 0){
                        for (int i = intCol - 1; i >= 0; i--){
                            //Checks for a tile of different value, but not 0.
                            if (infoArray[intRow][i].getValue() != intCurrent && infoArray[intRow][i].getValue() > 0){
                                break;
                            }
                            //Checks for tile with same value.
                            else if (infoArray[intRow][i].getValue() == intCurrent){
                                intMove = i;
                                intCurrent *= 2;
                                break;
                            }
                            //If empty tile found, set as tile to move to.
                            else {
                                intMove = i;
                            }
                        }
                    }
                    
                    //Moves the tile.
                    if (intMove != intCol){
                        //Update value storage objects in array.
                        infoArray[intRow][intMove].setValue(intCurrent);
                        infoArray[intRow][intCol].setValue(0);
                        //Update GUI.
                        tilesArray[intRow][intMove].setText("" + intCurrent);
                        tilesArray[intRow][intCol].setText("");
                        
                        //Updates the score based on tile value.
                        if (intCurrent > intScore){
                            intScore = intCurrent;
                            lblScore.setText("Score : " + intScore);
                        }                        
                    }
                    
                }
            }
                        
            //Calls the function that sets the colour of all the tiles.
            setTileColours();
            
            //Calls the function that checks if the game is over and stores the result in a variable.
            boolean isOver = checkGameOver();
            
            //Uses the Tiles class to create a new tile.
            if (!isOver){
                Tiles newTile = new Tiles();
                int [] intNew = newTile.placeNew(infoArray);
                infoArray[intNew[0]][intNew[1]].setValue(2);
                tilesArray[intNew[0]][intNew[1]].setText("2");
            }
            else {
                //Calls the end game function if the game is over.
                runGameOver();
            }
        }
        
        //Moves tiles to the right if the right arrow key is released
        if (evt.getKeyCode() == evt.VK_RIGHT){
            runFirst();
            isFirst = false;
            //Loops through each tile
            for (int intRow = 3; intRow >= 0; intRow--){
                for (int intCol = 3; intCol >= 0; intCol--){
                    int intCurrent = infoArray[intRow][intCol].getValue();
                    int intMove = intCol;
                    //Checks the tiles right of the current one and moves the tile
                    //to the first empty one or doubles the tile and moves it to 
                    //the first identical tile.
                    if (intCurrent != 0){
                        for (int i = intCol + 1; i <= 3; i++){
                        //Checks for a tile of different value, but not 0.
                            if (infoArray[intRow][i].getValue() != intCurrent && infoArray[intRow][i].getValue() > 0){
                                break;
                            }
                            //Checks for tile with same value.
                            else if (infoArray[intRow][i].getValue() == intCurrent){
                                intMove = i;
                                intCurrent *= 2;
                                break;
                            }
                            //If empty tile found, set as tile to move to.
                            else {
                                intMove = i;
                            }
                        }
                    }
                    
                    //Moves the tile.
                    if (intMove != intCol){
                        //Update value storage objects in array.
                        infoArray[intRow][intMove].setValue(intCurrent);
                        infoArray[intRow][intCol].setValue(0);
                        //Update GUI.
                        tilesArray[intRow][intMove].setText("" + intCurrent);
                        tilesArray[intRow][intCol].setText("");
                        
                        //Updates the score based on tile value.
                        if (intCurrent > intScore){
                            intScore = intCurrent;
                            lblScore.setText("Score : " + intScore);
                        }    
                    }
                    
                }
            }
                        
            //Calls the function that sets the colour of all the tiles.
            setTileColours();

            ////Calls the function that checks if the game is over.
            boolean isOver = checkGameOver();

            //Uses the Tiles class to create a new tile.
            if (!isOver){
                Tiles newTile = new Tiles();
                int [] intNew = newTile.placeNew(infoArray);
                infoArray[intNew[0]][intNew[1]].setValue(2);
                tilesArray[intNew[0]][intNew[1]].setText("2");
            }
            else {
                //Calls the end game function if the game is over.
                runGameOver();
            }            
        }
        
        //Moves tiles down if the down arrow key is released
        if (evt.getKeyCode() == evt.VK_DOWN){
            runFirst();
            isFirst = false;
            //Loops through each tile
            for (int intCol = 3; intCol >= 0; intCol--){
                for (int intRow = 3; intRow >= 0; intRow--){
                    int intCurrent = infoArray[intRow][intCol].getValue();
                    int intMove = intRow;
                    //Checks the tiles below the current one and moves the tile
                    //to the first empty one or doubles the tile and moves it to 
                    //the first identical tile.
                    if (intCurrent != 0){
                        for (int i = intRow + 1; i <= 3; i++){
                        //Checks for a tile of different value, but not 0.
                            if (infoArray[i][intCol].getValue() != intCurrent && infoArray[i][intCol].getValue() > 0){
                                break;
                            }
                            //Checks for tile with same value.
                            else if (infoArray[i][intCol].getValue() == intCurrent){
                                intMove = i;
                                intCurrent *= 2;
                                break;
                            }
                            //If empty tile found, set as tile to move to.
                            else {
                                intMove = i;
                            }
                        }
                    }
                    
                    //Moves the tile.
                    if (intMove != intRow){
                        //Update value storage objects in array.
                        infoArray[intMove][intCol].setValue(intCurrent);
                        infoArray[intRow][intCol].setValue(0);
                        //Update GUI.
                        tilesArray[intMove][intCol].setText("" + intCurrent);
                        tilesArray[intRow][intCol].setText("");
                        
                        //Updates the score based on tile value.
                        if (intCurrent > intScore){
                            intScore = intCurrent;
                            lblScore.setText("Score : " + intScore);
                        }    
                    }
                    
                }
            }
                        
            //Calls the function that sets the colour of all the tiles.
            setTileColours();
            
            //Calls the function that checks if the game is over.
            boolean isOver = checkGameOver();

            //Uses the Tiles class to create a new tile.
            if (!isOver){
                Tiles newTile = new Tiles();
                int [] intNew = newTile.placeNew(infoArray);
                infoArray[intNew[0]][intNew[1]].setValue(2);
                tilesArray[intNew[0]][intNew[1]].setText("2");
            }
            else {
                //Calls the end game function if the game is over.
                runGameOver();
            }           
        }

        //Moves tiles up if the up arrow key is released
        if (evt.getKeyCode() == evt.VK_UP){
            runFirst();
            isFirst = false;
            //Loops through each tile
            for (int intCol = 0; intCol <= 3; intCol++){
                for (int intRow = 0; intRow <= 3; intRow++){
                    int intCurrent = infoArray[intRow][intCol].getValue();
                    int intMove = intRow;
                    //Checks the tiles below the current one and moves the tile
                    //to the first empty one or doubles the tile and moves it to 
                    //the first identical tile.
                    if (intCurrent != 0){
                        for (int i = intRow - 1; i >= 0; i--){
                            //Checks for a tile of different value, but not 0.
                            if (infoArray[i][intCol].getValue() != intCurrent && infoArray[i][intCol].getValue() > 0){
                                break;
                            }
                            //Checks for tile with same value.
                            else if (infoArray[i][intCol].getValue() == intCurrent){
                                intMove = i;
                                intCurrent *= 2;
                                break;
                            }
                            //If empty tile found, set as tile to move to.
                            else {
                                intMove = i;
                            }
                        }
                    }
                    
                    //Moves the tile.
                    if (intMove != intRow){
                        //Update value storage objects in array.
                        infoArray[intMove][intCol].setValue(intCurrent);
                        infoArray[intRow][intCol].setValue(0);
                        //Update GUI.
                        tilesArray[intMove][intCol].setText("" + intCurrent);
                        tilesArray[intRow][intCol].setText("");
                        
                        //Updates the score based on tile value.
                        if (intCurrent > intScore){
                            intScore = intCurrent;
                            lblScore.setText("Score : " + intScore);
                        }    
                    }
                    
                }
            }
                        
            //Calls the function that sets the colour of all the tiles.
            setTileColours();
            
            //Calls the function that checks if the game is over.
            boolean isOver = checkGameOver();

            //Uses the Tiles class to create a new tile.
            if (!isOver){
                Tiles newTile = new Tiles();
                int [] intNew = newTile.placeNew(infoArray);
                infoArray[intNew[0]][intNew[1]].setValue(2);
                tilesArray[intNew[0]][intNew[1]].setText("2");
            }
            else {
                //Calls the end game function if the game is over.
                runGameOver();
            }
        }

    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGame().setVisible(true);
            }
        });
                               
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl13;
    private javax.swing.JLabel lbl14;
    private javax.swing.JLabel lbl15;
    private javax.swing.JLabel lbl16;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelMain;
    // End of variables declaration//GEN-END:variables
}
