/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.kozusznik.pl1.shapes.manager;

import cz.kozusznik.pl1.shapes.MyColor;
import cz.kozusznik.pl1.shapes.Position;
import cz.kozusznik.pl1.shapes.tools.ITransformable;

/**
 *
 * @author Dan Krupa
 */
public abstract class AbstractShape implements ITransformable,IPaintable,IClickable
{
      /** Platno, na ktere se bude instance kreslit. */
  protected static final CanvasManager CM = CanvasManager.getInstance();

//== PROMENNE ATRIBUTY TRIDY ===================================================

  /**
   * Pocet pixelu, o nez se instance posune
   * po bezparametrickem posunovem povelu
   */
 protected static int step = 50;

    protected int xPos; //Bodová x-ová souřadnice instance
    protected int yPos; //Bodová y-ová souřadnice instance
    protected int width; //šířka v bodech
    protected int height; //Výška v bodech
    protected MyColor color; //Barva instance

  @Override
  public int getX() {
    return xPos;
  }

  /***************************************************************************
   * Vrati y-ovou souradnici pozice instance.
   *
   * @return y-ova souradnice.
   */
  @Override
  public int getY() {
    return yPos;
  }

  /***************************************************************************
   * Nastavi novou pozici instance.
   *
   * @param x
   *          Nova x-ova pozice instance
   * @param y
   *          Nova y-ova pozice instance
   */
  @Override
  public void setPosition(int x, int y) {

    xPos = x;
    yPos = y;
    CM.repaint();
  }

  /***************************************************************************
   * Vrati sirku instance.
   *
   * @return Sirka instance v bodech
   */
  @Override
  public int getWidth() {
    return width;
  }

  /***************************************************************************
   * Vrati vysku instance.
   *
   * @return Vyska instance v bodech
   */
  @Override
  public int getHeight() {
    return height;
  }

  /***************************************************************************
   * Nastavi novy "ctvercovy" rozmer instance -
   * na zadany rozmer se nastavi vyska i sirka.
   *
   * @param size
   *          Nove nastavovany rozmer v obou smerech; rozmer>0
   */
  public void setDimension(int size) {
    setDimension(size, size);
  }

  /***************************************************************************
   * Nastavi nove rozmery instance.
   *
   * @param width
   *          Nove nastavovana sirka; sirka>=0
   * @param height
   *          Nove nastavovana vyska; vyska>=0
   */
  public void setDimension(int width, int height) {
    if ((width < 0) || (height < 0)) {
      throw new IllegalArgumentException(
          "Rozmery musi byt nezaporne: sirka=" + width + ", vyska=" + height);
    }

    this.width = width;
    this.height = height;
    CM.repaint();
  }

  /***************************************************************************
   * Vrati barvu instance.
   *
   * @return Instance tridy Barva definujici nastavenou barvu.
   */
  public MyColor getColor() {
    return color;
  }

  /***************************************************************************
   * Nastavi novou barvu instance.
   *
   * @param newColor
   *          Pozadovana nova barva.
   */
  public void setColor(MyColor newColor) {
    color = newColor;
    CM.repaint();
  }

 
//== PREKRYTE METODY IMPLEMENTOVANYCH ROZHRANI =================================
//== PREKRYTE ABSTRAKTNI METODY RODICOVSKE TRIDY ===============================
//== PREKRYTE KONKRETNI METODY RODICOVSKE TRIDY ================================

  /***************************************************************************
   * Prevede instanci na retezec. Pouziva se predevsim pri ladeni.
   *
   * @return Retezcova reprezentace dane instance.
   */
  

//== NOVE ZAVEDENE METODY INSTANCI =============================================

  /***************************************************************************
   * Presune instanci o zadany pocet bodu vpravo,
   * pri zaporne hodnote parametru vlevo.
   *
   * @param distance
   *          Vzdalenost, o kterou se instance presune.
   */
  public void moveRight(int distance) {
    setPosition(xPos + distance, yPos);
  }

  /***************************************************************************
   * Presune instanci o krok bodu vpravo.
   */
  public void moveRight() {
    moveRight(step);
  }

  /***************************************************************************
   * Presune instanci o krok bodu vlevo.
   */
  public void moveLeft() {
    moveRight(-step);
  }

  /***************************************************************************
   * Presune instanci o zadany pocet bodu dolu,
   * pri zaporne hodnote parametru nahoru.
   *
   * @param vzdalenost
   *          Pocet bodu, o ktere se instance presune.
   */
  public void moveDown(int distance) {
    setPosition(xPos, yPos + distance);
  }

  /***************************************************************************
   * Presune instanci o krok bodu dolu.
   */
  public void moveDown() {
    moveDown(step);
  }

  /***************************************************************************
   * Presune instanci o krok bodu nahoru.
   */
  public void moveUp() {
    moveDown(-step);
  }

  @Override
  public boolean isInBound(double x, double y) {

    return (xPos <= x) && (x <= (xPos + width)) && (yPos <= y)
        && (y <= (yPos + height));
  }

//== SOUKROME A POMOCNE METODY TRIDY ===========================================
//== SOUKROME A POMOCNE METODY INSTANCI ========================================
//== VNORENE A VNITRNI TRIDY ===================================================
//== TESTY A METODA MAIN =======================================================

    @Override
    public void setWidth(int w) 
    {
        this.width=w;
    }

    @Override
    public void setHeight(int h) 
    {
        this.height=h;
    }

    @Override
    public Position getPosition() {
       return new Position(this.xPos,this.yPos);
    }
    
}
