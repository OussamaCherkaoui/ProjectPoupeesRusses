public abstract class Poupee {
    private int size;
    private int fabricationYear;
    private boolean opened=false;
    private Poupee contient;
    public Poupee(int size){
        this.size=size;
    }
    public Poupee(){};
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(int fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public Poupee getContient() {
        return contient;
    }

    public void setContient(Poupee contient) {
        this.contient = contient;
    }
    public abstract void ouvrir(Poupee p);
    public abstract void fermer(Poupee p);
    public abstract boolean placerDans(Poupee p);
    public abstract boolean sortirDe(Poupee p);

}

