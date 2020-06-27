package com.akostikov.app.firestore;

import com.akostikov.app.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.akostikov.app.firestore.InitialTableData.DONSAK_KOTAO;
import static com.akostikov.app.firestore.InitialTableData.DONSAK_PHANGAN;
import static com.akostikov.app.firestore.InitialTableData.DONSAK_SAMUI;


public class FirestoreHelper {

    private FirebaseFirestore fbfs = FirebaseFirestore.getInstance();

    public void populateFirestore()  {
        this.populateTemplate("DonSakKoTao", DONSAK_KOTAO);
        this.populateTemplate("DonSakPhangan", DONSAK_PHANGAN);
        this.populateTemplate("DonSakSamui", DONSAK_SAMUI);
    }

    public void populateTemplate(String tableName, String[][] schedule) {

        int boatLogo = 0;

        for (int i = 0; i < schedule.length; i++) {

            switch (schedule[i][0]) {
                case "Raja": boatLogo = R.drawable.raja; break;
                case "Lomprayah": boatLogo = R.drawable.lomprayah; break;
                case "Seatran": boatLogo = R.drawable.seatran; break;
                case "Songserm": boatLogo = R.drawable.songserm; break;
                case "Haadrin Queen": boatLogo = R.drawable.haadrin_queen; break;
            }

            if (boatLogo > 0) {
                final Map<String, Object> mappedDoc = new HashMap<>();
                mappedDoc.put("boat", boatLogo);
                mappedDoc.put("time_depart", schedule[i][1]);
                mappedDoc.put("pier_depart", schedule[i][2]);
                mappedDoc.put("time_arrive", schedule[i][3]);
                mappedDoc.put("pier_arrive", schedule[i][4]);
                mappedDoc.put("price", schedule[i][5]);

                fbfs.collection(tableName)
                        .document(String.format(Locale.US, "race-%d", i + 1))
                        .set(mappedDoc);
            }
        }
    }
}
