
public class Datenelement
{
    private String fremdwort;
    private String uebersetzung;
    private String erklaerung;

    public Datenelement(String fremdwort, String uebersetzung, String erklaerung){
        this.fremdwort = fremdwort;
        this.uebersetzung = uebersetzung;
        this.erklaerung = erklaerung;
    }

    public void datenAusgeben(){
        System.out.print("Fremdwort: " + fremdwort + ", Übersetzung: " + uebersetzung + ", Erklärung: " + erklaerung + "\n");
    }

    public int compareTo(Datenelement ele){
        return fremdwort.compareTo(ele.fremdwort);
    }
}
