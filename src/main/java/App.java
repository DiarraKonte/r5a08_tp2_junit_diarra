//
// Utilisation nominale des classes td3.Buffer, Killring et td3.Editor
//
////////////////////////////////////////////////////////////////

import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import fr.einfolearning.tp2.utilitaires.EmacsAnalyze;

public class App {

    public static void main(String[] args) throws EmacsKillRingOverflowException {
        TextEditor texte = new TextEditor("Je suis un editeur de texte");
        EmacsAnalyze.dumpTextEditor(texte, true, true);

        // Etape deux : sauvegarder "suis" dans le tampon circulaire
        texte.setCursor(3);
        texte.setMark(7);
        texte.killRingBackup(); // copier "suis"
        EmacsAnalyze.dumpTextEditor(texte, true, true);

        // Etape trois :couper la sous chaines "editeur"
        texte.setCursor(11);
        texte.setMark(16);
        texte.killSection(); // copier "suis"
        EmacsAnalyze.dumpTextEditor(texte, true, true);

        // Etape quatre : coller "editeur" avant "un"\
        texte.setCursor(8);
        try {
            texte.yank();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EmacsAnalyze.dumpTextEditor(texte, true, true);
        
        // Etape cinq : ecraser la sous chaine que l'on vient de coller avec le mot "suis"
        try {
            texte.yankPop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EmacsAnalyze.dumpTextEditor(texte, true, true);

    }
}
