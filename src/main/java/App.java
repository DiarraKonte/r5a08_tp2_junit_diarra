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

    public static void main(String[] args) throws EmacsKillRingOverflowException{
        TextEditor texte = new TextEditor("Je suis un editeur de texte");
        EmacsAnalyze.dumpTextEditor(texte, true, true);


        // Etape deux : sauvegarder "suis" dans le tampon circulaire    
        texte.setCursor(3);
        texte.setMark(7);
        texte.killRingBackup();  // copier "suis"     
        EmacsAnalyze.dumpTextEditor(texte, true, true);
        

        // Etape trois : supprimer "suis" dans le tampon circulaire    
        texte.setCursor(3);
        texte.setMark(7);
        texte.killRingBackup();  // copier "suis"     
        EmacsAnalyze.dumpTextEditor(texte, true, true);
    }
}
