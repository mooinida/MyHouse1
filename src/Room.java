import javax.swing.*;

public interface Room {
    int sizecheck = 0;

    public default void setCnt(int sizecheck) {

    }

    public default int getSizecheck() {
        return sizecheck;
    }
    public default void setAnimalBIcon(ImageIcon icon) {
    }
    public default void setBedIcon(ImageIcon icon) {
    }
    public default void setAirconIcon(ImageIcon icon) {
    }
    public default void setGamingBack(ImageIcon icon){
    }
    public default void setChairIcon(ImageIcon icon){
    }
    public default void setTIcon(ImageIcon icon){
    }
    public default void setShowerIcon(ImageIcon icon){
    }
    public default void setSinkIcon(ImageIcon icon){
    }
    public default void setTableIcon(ImageIcon icon){
    }

}
