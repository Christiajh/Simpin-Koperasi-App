
package aplikasi.simpin.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class roundedpanel extends JPanel{

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
    }

    public int getRoundBottomright() {
        return roundBottomright;
    }

    public void setRoundBottomright(int roundBottomright) {
        this.roundBottomright = roundBottomright;
    }
    
    private int roundTopLeft = 0;
    int roundTopRight = 0;
    int roundBottomLeft = 0;
    int roundBottomright = 0;
    
    public  roundedpanel(){
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 =(Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        
        if (roundTopRight>0){
            area.intersect(new Area(createRoundTopRight()));
    
        }
        
        if (roundTopLeft>0){
            area.intersect(new Area(createRoundTopLeft()));
    
        }
        
        if (roundBottomLeft>0){
            area.intersect(new Area(createRoundBottomLeft()));
    
        }
        
        if (roundBottomright>0){
            area.intersect(new Area(createRoundBottomRight()));
    
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(g);
    }
    
    private Shape createRoundTopLeft() {
    int width = getWidth();
    int height = getHeight();
    int roundX = Math.min(width, roundTopLeft);
    int roundY = Math.min(height, roundTopLeft);

    Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
    area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, width)));
    area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
    return area;
}
    
    private Shape createRoundTopRight() {
    int width = getWidth();
    int height = getHeight();
    int roundX = Math.min(width, roundTopRight);
    int roundY = Math.min(height, roundTopRight);

    Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
    area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, width)));
    area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
    return area;
}
    
    private Shape createRoundBottomLeft() {
    int width = getWidth();
    int height = getHeight();
    int roundX = Math.min(width, roundBottomLeft);
    int roundY = Math.min(height, roundBottomLeft);

    Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
    area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
    area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
    return area;
}
    
    private Shape createRoundBottomRight() {
    int width = getWidth();
    int height = getHeight();
    int roundX = Math.min(width, roundBottomright);
    int roundY = Math.min(height, roundBottomright);

    Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
    area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
    area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
    return area;
    }
    
}
