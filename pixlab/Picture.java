import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  } // END zeroBlue()
  
  /** Method to set the red to 0 */
  public void zeroRed()
  {
    Pixel[][] image = this.getPixels2D();
    for (Pixel[] row: image)
    {
        for (Pixel p: row)
        {
            p.setRed(0);
        }
    }
  } //END zeroRed
  
  /** Method to set the green to 0 */
  public void zeroGreen()
  {
    Pixel[][] image = this.getPixels2D();
    for (Pixel[] row: image)
    {
        for (Pixel p: row)
        {
            p.setGreen(0);
        }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int col = 0; col < pixels[0].length; col++)
    {
      for (int row = 0; row < height / 2; row++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height-1-row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int col = 0; col < pixels[0].length; col++)
    {
      for (int row = 0; row < height / 2; row++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height-1-row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  
  public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel original = null;
    Pixel newone = null;
    int height = pixels.length;
    int width = pixels[0].length; 
    int end = Math.min(height, width);
    for (int i=0; i<end; i++)
    {
        for (int j=0; j<i; j++)
        {
            original = pixels[i][j];
            newone = pixels[j][i];
            newone.setColor(original.getColor());
        }
    }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  public void mirrorArms()
  {
    Pixel[][] image = this.getPixels2D();
    Pixel topPixel;
    Pixel bottomPixel;
    int mirrorpoint = 200;
    for (int row = 155; row< mirrorpoint; row++)
    {    
        for (int col = 100; col < 180; col++)
        {
          topPixel = image[row][col];
          bottomPixel = image[mirrorpoint+mirrorpoint - row][col];
          bottomPixel.setColor(topPixel.getColor());
        }
    }
    
    for (int row = 155; row< mirrorpoint; row++)
    {    
        for (int col = 230; col < 300; col++)
        {
          topPixel = image[row][col];
          bottomPixel = image[mirrorpoint+mirrorpoint - row][col];
          bottomPixel.setColor(topPixel.getColor());
        }
    }
    
  }
  
  public void mirrorGull()
  {
    Pixel[][] image = this.getPixels2D();
    Pixel leftPixel; 
    Pixel rightPixel;
    int mirrorpoint = 350;
    for (int row = 220; row<350; row++)
    {
        for (int col = 220; col<mirrorpoint; col++)
        {
            leftPixel = image[row][col];
            rightPixel = image[row][mirrorpoint+mirrorpoint-col];
            rightPixel.setColor(leftPixel.getColor());
        }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy(Picture fromPic, 
                 int startRow, int startCol,
                 int fSR,      int fSC,
                 int fER,      int fEC)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = fSR, toRow = startRow; 
         fromRow < fER &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = fSC, toCol = startCol; 
           fromCol < fEC &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,20);
    this.copy(flower2,100,40);
    this.copy(flower1,200,60);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,80);
    this.copy(flower1,400,100);
    this.copy(flower2,500,120);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage()
  {
    Picture gull = new Picture("flower1.jpg");
    Picture gullNegate = new Picture(gull);
    gullNegate.negate();
    Picture gullGrayscale = new Picture(gull);
    gullGrayscale.grayscale();
    Picture gullZeroBlue = new Picture(gull);
    gullZeroBlue.zeroBlue();
    this.copy(gull, 0, 20);
    this.copy(gullNegate, 100, 40);
    this.copy(gullGrayscale, 200, 60);
    this.mirrorVertical();
    this.copy(gullZeroBlue, 150, 200);
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  /** Set red and green values to zero */
  public void keepOnlyBlue()
  {
    zeroRed();
    zeroGreen();
  }
  
  /** Negate the pixels in the picture */
  public void negate()
  {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] i: pixels)
      {
          for (Pixel j: i)
          {
              j.setRed(255-j.getRed());
              j.setBlue(255-j.getBlue());
              j.setGreen(255-j.getGreen());
          }
      }
  }
  
  /** Turn the picture into shades of gray */
  public void grayscale()
  {
      Pixel[][] pixels = this.getPixels2D();
      int total;
      for (Pixel[] i: pixels)
      {
          for (Pixel j: i)
          {
              total = (j.getRed()+j.getGreen()+j.getBlue());
              total/=3;
              j.setRed(total);
              j.setGreen(total);
              j.setBlue(total);
          }
      }
  }
  
  public void fixUnderwater()
  {
    Pixel[][] image = this.getPixels2D();
    Pixel j;
    for (int i=0; i<180; i++)
    {
        for (int q=100; q<470; q++)
        {
            j = image[i][q];
            if (j.getRed()<30 && j.getBlue()>155 && j.getGreen()<175)
            {
                j.setRed(255);
                j.setBlue(0);
            }
        }
    }
    
    for (Pixel[] row: image)
    {
        for (Pixel p: row)
        {
            if (p.getRed()!=255)
            {
                p.setBlue(p.getBlue()-50);
            }
        }
    }
  }
              
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  public void EdgeDetection2(int edgeDist)
  {
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    Pixel downPixel = null;
    Pixel upPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color upColor = null;
    Color rightColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length; row++)
      {
        downPixel = pixels[row][col];
        upPixel = pixels[row+1][col];
        upColor = upPixel.getColor();
        if ((rightPixel.colorDistance(rightColor) > 
            edgeDist))
        {
          downPixel.setColor(Color.BLACK);
          leftPixel.setColor(Color.BLACK);
        }
        else
        {
          downPixel.setColor(Color.WHITE);
          leftPixel.setColor(Color.WHITE);
        }
    }
  }
}} // this } is the end of class Picture, put all new methods before this