
package BEAN;

/**
 *
 * @author Acer
 */
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Danhmuc {
    private String kind;
    private JPanel jpn;
    private JLabel jlb;
    
    public Danhmuc() {
    }

    public Danhmuc(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }
    
}
