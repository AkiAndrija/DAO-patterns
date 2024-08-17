import java.io.Serializable;

public class Izvodjac implements Serializable {
    private int ID;
    private String nazivIzvodjaca;
    private String tipIzvodjaca;
    private int godinaFormacije;
    private int godinaRaspada;
    private String zvanicanSajt;

    public Izvodjac() {
    }

    public Izvodjac(int ID, String nazivIzvodjaca, String tipIzvodjaca, int godinaFormacije, int godinaRaspada, String zvanicanSajt) {

    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNazivIzvodjaca() {
        return this.nazivIzvodjaca;
    }

    public void setNazivIzvodjaca(String nazivIzvodjaca) {
        this.nazivIzvodjaca = nazivIzvodjaca;
    }

    public String getTipIzvodjaca() {
        return this.tipIzvodjaca;
    }

    public void setTipIzvodjaca(String tipIzvodjaca) {
        this.tipIzvodjaca = tipIzvodjaca;
    }

    public int getGodinaFormacije() {
        return this.godinaFormacije;
    }

    public void setGodinaFormacije(int godinaFormacije) {
        this.godinaFormacije = godinaFormacije;
    }

    public int getGodinaRaspada() {
        return this.godinaRaspada;
    }

    public void setGodinaRaspada(int godinaRaspada) {
        this.godinaRaspada = godinaRaspada;
    }

    public String getZvanicanSajt() {
        return this.zvanicanSajt;
    }

    public void setZvanicanSajt(String zvanicanSajt) {
        this.zvanicanSajt = zvanicanSajt;
    }

    @Override
    public String toString() {
        return getID() + "\t" + getNazivIzvodjaca() + "\t" + getTipIzvodjaca() + "\t" + getGodinaFormacije() + "\t" + getGodinaRaspada() + "\t" + getZvanicanSajt();
    }
}
