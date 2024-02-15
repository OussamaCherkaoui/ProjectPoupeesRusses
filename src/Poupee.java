public abstract class Poupee {
    private int size;
    private int fabricationYear;
    private boolean opened;
    public Poupee(int size){
        this.size=size;
    }
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

    public abstract void ouvrir();
    public abstract void fermer();
    public abstract void placerDans(Poupee p);
    public abstract  void sortirDe(Poupee p);

}

