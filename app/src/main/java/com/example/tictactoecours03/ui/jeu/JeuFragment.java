package com.example.tictactoecours03.ui.jeu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.tictactoecours03.MainActivity;
import com.example.tictactoecours03.R;
import java.util.ArrayList;

public class JeuFragment extends Fragment {

    public static int btnCase[] = {R.id.buttonCase01, R.id.buttonCase02,
            R.id.buttonCase03, R.id.buttonCase04, R.id.buttonCase05, R.id.buttonCase06,
            R.id.buttonCase07, R.id.buttonCase08, R.id.buttonCase09};
    public boolean player_o = true;
    public int counterDraw = 0;
    ArrayList<ImageButton> imageButton = new ArrayList<ImageButton>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_jeu, container, false);

        for (int i = 0; i < 9; i++) {
            imageButton.add((ImageButton) root.findViewById(btnCase[i]));
        }

        for (int i = 0; i < imageButton.size(); i++) {
            final int counterClick = i;
            imageButton.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (imageButton.get(counterClick).getTag() == null) {
                        counterDraw++;
                        if (player_o) {
                            imageButton.get(counterClick).setBackgroundResource(R.drawable.btn_o);
                            imageButton.get(counterClick).setTag("btn_o");
                            player_o = false;
                        } else {
                            imageButton.get(counterClick).setBackgroundResource(R.drawable.btn_x);
                            imageButton.get(counterClick).setTag("btn_x");
                            player_o = true;
                        }
                        if (counterDraw == 9) {
                            dialogBox("PAS DE GAGNANT");
                        }
                    }
                    verifierVertical("btn_x");
                    verifierVertical("btn_o");

                    verifierHorizontal("btn_x");
                    verifierHorizontal("btn_o");

                    verifierDiagional("btn_x");
                    verifierDiagional("btn_o");
                }
            });
        }
        return root;
    }

    public void dialogBox(String texte) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(texte);
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                });
        final Dialog dialog = builder.create();
        dialog.show();
    }

    public void verifierVertical(String btn) {
        for (int j = 0; j <= 2; j++) {
            if (String.valueOf(imageButton.get(j).getTag()) == btn &&
                    String.valueOf(imageButton.get(j + 3).getTag()) == btn &&
                    String.valueOf(imageButton.get(j + 6).getTag()) == btn) {
                dialogBox("UN GAGNANT!!!");
            }
        }
    }

    public void verifierHorizontal(String btn) {
        for (int j = 0; j <= 6; j += 3) {
            if (String.valueOf(imageButton.get(j).getTag()) == btn &&
                    String.valueOf(imageButton.get(j + 1).getTag()) == btn &&
                    String.valueOf(imageButton.get(j + 2).getTag()) == btn) {
                dialogBox("UN GAGNANT!!!");
            }
        }
    }

    public void verifierDiagional(String btn) {
        if (String.valueOf(imageButton.get(0).getTag()) == btn &&
                String.valueOf(imageButton.get(4).getTag()) == btn &&
                String.valueOf(imageButton.get(8).getTag()) == btn ||
                String.valueOf(imageButton.get(2).getTag()) == btn &&
                        String.valueOf(imageButton.get(4).getTag()) == btn &&
                        String.valueOf(imageButton.get(6).getTag()) == btn) {
            dialogBox("UN GAGNANT!!!");
        }
    }
}