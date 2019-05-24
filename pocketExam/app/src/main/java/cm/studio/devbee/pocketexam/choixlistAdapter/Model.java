package cm.studio.devbee.pocketexam.choixlistAdapter;

import cm.studio.devbee.pocketexam.PostId;

public class Model extends cm.studio.devbee.pocketexam.PostId {
    String annee;
    String lien;

    public Model(String annee, String lien) {
        this.annee = annee;
        this.lien = lien;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
}
