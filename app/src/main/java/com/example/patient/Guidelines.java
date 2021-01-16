package com.example.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.awt.font.TextAttribute;

public class Guidelines extends AppCompatActivity {

    TextView txtHospitalRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_guidelines);
        txtHospitalRules = findViewById(R.id.txtHospitalRules);
        String s = "VISITING HOURS - In the Wards between 5:00 – 7:00 pm (summer) and 4:00 – 6:00 pm (winter) daily. In ICU, Morning visiting hours will be from 10:30 – 11:00 am and Evening from 5:00 – 5:30 pm.\n" +
                "\nSERVICES – Services of Medical, Nursing, Housekeeping and Maintenance staffs are available round the clock.\n" +
                "\nADMISSION ADVANCE – Admission advance must be paid at the time of admission to cover the expenses for surgery / treatment. Personal cheques are not accepted.\n" +
                "\nATTENDANTS – Only one attendant is allowed with all categories of patients.\n" +
                "\nOT/HDU/ICU TRANSFER – The attendants have to vacate the room whenever the patient is shifted to any critical care area or for a surgery / procedure.\n" +
                "\nDISCHARGE – Check out time is 12:00 Noon. Patients discharged between 12 Noon to 6 PM will be charged ½ day’s room rent. Please clear your bills before 12 noon and 6 PM.\n" +
                "\nFOOD AND BEVERAGES - No Outside food or beverages are allowed in the hospital premises. \n" +
                "\nTOBACCO - All Tobacco products are strictly prohibited (Smoking, Chewing, Pan / Pan Masala) in the Hospital premises.";

        txtHospitalRules.setText(s);

        YouTubePlayerView youTubePlayerView1 = findViewById(R.id.youtube_player_view1);
        getLifecycle().addObserver(youTubePlayerView1);

        YouTubePlayerView youTubePlayerView2 = findViewById(R.id.youtube_player_view2);
        getLifecycle().addObserver(youTubePlayerView2);

    }
}